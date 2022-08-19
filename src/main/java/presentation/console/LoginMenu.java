package presentation.console;

import context.ApplicationContext;

import java.util.Scanner;

public class LoginMenu implements Menu {
    @Override
    public Menu action() {

        Scanner console = new Scanner(System.in);
        boolean checkLogin = false;
        do {
            System.out.println("enter your airline name");
            String airlineName = console.next();
            System.out.println("enter your password");
            String password = console.next();
            if (ApplicationContext.Instance.getAirLineService().findByeAirLineName(airlineName)
                    != null) {
                ApplicationContext.Instance.setAirLine(ApplicationContext.getInstance().getAirLineService().findByeAirLineName(airlineName));

                if (ApplicationContext.Instance.getAirLine().getPassword().equals(password)) {
                    checkLogin = true;
                    return new AirlineInsideMenu();
                }
            } else System.out.println("wrong airlineName or password entered");

        } while (!checkLogin);

        return new LoginMenu();
    }
}
