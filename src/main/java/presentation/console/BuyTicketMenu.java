package presentation.console;

import context.ApplicationContext;
import domain.BankCard;
import domain.Fly;
import domain.Passenger;

import java.time.LocalDate;
import java.util.Scanner;

public class BuyTicketMenu implements Menu {
  @Override
  public Menu action() {
    Scanner console = new Scanner(System.in);
    System.out.println("enter the fly id");
    int flyId = console.nextInt();
    if (ApplicationContext.getInstance().getFlyService().read(flyId)
      != null) {
      Fly fly = ApplicationContext.getInstance().getFlyService().read(flyId);
      if (fly.getPassengers().size() > 40) {
        System.out.println("all sits are taken");
      } else {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("enter your first name");
        String firstName = scanner.nextLine();
        System.out.println("enter your last name");
        String lastName = scanner2.nextLine();
        System.out.println("enter your phone number");
        String phoneNumber = scanner.nextLine();
        Passenger passenger = new Passenger(firstName, lastName, phoneNumber);
        passenger.setFly(fly);
        System.out.println("enter your card number");
        Long cardNumber = console.nextLong();
        System.out.println("enter your cvv2");
        Integer cvv2 = console.nextInt();
        System.out.println("enter your second password");
        String password = console.next();
        System.out.println("enter expireDate");
        System.out.println("year");
        int year = console.nextInt();
        System.out.println("month");
        int month = console.nextInt();
        System.out.println("day");
        int day = console.nextInt();
        LocalDate localDate = LocalDate.of(year, month, day);
        if (ApplicationContext.getInstance().getBankCardService().read(cardNumber) != null) {
          BankCard bankCard = ApplicationContext.getInstance().getBankCardService().read(cardNumber);
          if (!bankCard.getSecondPassword().equals(password) ||
            !bankCard.getCvv2().equals(cvv2) ||
            !bankCard.getExpireDate().equals(localDate)) {
            System.out.println("your password or cvv2 or expireDate is wrong");
          } else {
            if (bankCard.getCardBalance() < fly.getFlyCost()) {
              System.out.println("your card balance is not enough");
            } else ApplicationContext.getInstance().getPassengerService().create(passenger);
            bankCard.setCardBalance(bankCard.getCardBalance() - fly.getFlyCost());
            ApplicationContext.getInstance().getBankCardService().update(bankCard);
          }
        }

      }

    }
    return new CustomerMenu();
  }
}
