package presentation.console;

import context.ApplicationContext;
import domain.AirLine;

import java.util.Scanner;

public class SignUpMenu implements Menu {
    Scanner console = new Scanner(System.in);

    @Override
    public Menu action() {
      String airLineName;


        do {
            System.out.println("please enter airline name");
            airLineName = console.next();
        } while (!checkAirLineName(airLineName));
        String password;
        boolean check = false;
        do {
            System.out.println("please enter your  password");
            password = console.next();

            if (password.length() < 8) System.out.println("your password must be greater than 8 characters");
            else check = checkPassword(password);
        } while (!check);
      AirLine airLine = new AirLine();
      airLine.setName(airLineName);
      airLine.setPassword(password);
      ApplicationContext.Instance.getAirLineService().create(airLine);
        return new AirlineInsideMenu();
    }

    private boolean checkAirLineName(String username) {
        boolean check = false;

        if (ApplicationContext.Instance.getAirLineService().findByeAirLineName(username) != null)
            System.out.println("this name is already registered please enter choose another name");
        else check = true;
        return true;

    }

    private boolean checkPassword(String password) {

        boolean check = false;
        System.out.println("please enter your password again");
        String checkPassword = console.next();
        if (password.equals(checkPassword)) check = true;
        else System.out.println("first password and second password is not same enter password again");
        return check;


    }
}
