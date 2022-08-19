package presentation.web;

import context.ApplicationContext;
import domain.AirLine;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "signUp",urlPatterns = "/signup")
public class AirlineSingUp extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    PrintWriter writer = resp.getWriter();
    writer.write("<!DOCTYPE html>\n" +
      "<html lang=\"en\">\n" +
      "<head>\n" +
      "    <meta charset=\"UTF-8\">\n" +
      "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
      "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
      "    <title>Document</title>\n" +
      "    <style>\n" +
      "        .login{\n" +
      "            position: absolute;\n" +
      "            margin-right: 10cm;\n" +
      "            margin-left: 22cm;\n" +
      "             margin-top: 10cm;\n" +
      "\n" +
      "\n" +
      "        }\n" +
      "        input{\n" +
      "            padding: 12px 20px;\n" +
      "            border-radius: 1px;\n" +
      "             background-color: #adbdf5;\n" +
      "             \n" +
      "        }\n" +
      "        button{\n" +
      "            padding: 12px 20px;\n" +
      "            background-color: #f1f515;\n" +
      "\n" +
      "\n" +
      "        }\n" +
      "    </style>\n" +
      "</head>\n" +
      "<body>\n" +
      "\n" +
      "    <div class=\"login\"> \n" +
      "        <div>\n" +
      "            <h2><strong>sign up</strong> </h2>\n" +
      "            <form method=\"post\" action=\"/home_work_15_war_exploded/signup\">\n" +
      "              <input name=\"airline name\" type=\"text\" id=\"airline name\" placeholder=\"airline name\" required >\n" +
      "              <br><br>\n" +
      "              <input name=\"password\" type=\"password\" id=\"password\" placeholder=\"password\" required >\n" +
      "              <br> <br>\n" +
      "              <input name=\"check\" type=\"password\" id=\"check\" placeholder=\"reenter password\" required >\n" +
      "\n" +
      "          <br>\n" +
      "          <button type=\"submit\"> sign up </button>\n" +
      "            </form>  \n" +

      "    \n" +
      "</body>\n" +
      "</html>");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String airlineName = req.getParameter("airline name");
    String password = req.getParameter("password");
    String passwordCheck = req.getParameter("check");
    if(!password.equals(passwordCheck)){
      resp.sendRedirect("/signup?error");
    }else{
      AirLine airLine = new AirLine();
      airLine.setName(airlineName);
      airLine.setPassword(password);
      ApplicationContext.getInstance().getAirLineService().create(airLine);
      resp.sendRedirect("/home_work_15_war_exploded/login");
    }


  }
}
