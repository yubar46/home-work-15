package presentation.web;

import context.ApplicationContext;
import domain.Fly;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

@WebServlet(name = "searchTicket",urlPatterns = "/tickets")
public class SearchTicket extends HttpServlet {

 private List<Fly> flies;
 private String sortModel;
 private String orderModel;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Writer writer = resp.getWriter();
    if (flies.isEmpty()){
      writer.write("<!DOCTYPE html>\n" +
        "<html lang=\"en\">\n" +
        "<head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "    <title>Document</title>\n" +
        "    <style>\n" +
        "         input,\n" +
        "      button {\n" +
        "        width: 190px;\n" +
        "        height: 30px;\n" +
        "        margin: 10px;\n" +
        "      }\n" +
        "      .container {\n" +
        "        margin-right: 200px;\n" +
        "        margin-top: 50px;\n" +
        "      }\n" +
        "      form {\n" +
        "        display: flex;\n" +
        "        flex-direction: column;\n" +
        "      }\n" +
        "    \n" +
        " .notFounded{\n" +
        "        position: absolute;\n" +
        "        left: 20cm;    \n" +
        "        margin-top: 100px;\n" +
        "        margin-right: 500px;\n" +
        "    \n" +
        "\n" +
        "      }"+
        "    </style>\n" +
        "</head>\n" +
        "<body>\n" +
        "    <div >\n"  +
        " <p class=\"notFound\"> <strong>there no fly with this parameters</strong></p>" +
        "</div>"+

        "    <div class=\"container\">\n" +
        "        <h1>search tickets</h1>\n" +
        "        \n" +
        "\n" +
        "        <form method= \"post\" action=\" /home_work_15_war_exploded/tickets\">\n" +
        "            <input type=\"text\" name=\"origin\" id=\"origin\" placeholder=\"origin\">\n" +
        "            <input type=\"text\" name=\"destination\" id=\"destination\" placeholder=\"destination\">\n" +
        "            <input type=\"date\" name=\"date\" >\n" +
        " <div class=\"sort\">\n" +
        "            <p><strong> sortin by</strong></p>\n" +
        "            <input name=\"sort\" type=\"radio\" id=\"cost\" value= \"cost\"> <label for=\"cost\"> cost</label>\n" +
        "            <input name=\"sort\" type=\"radio\" id=\"origin\" value= \"origin\"> <label for=\"origin \">origin</label>\n" +
        "            <br>\n" +
        "            <input name=\"sort\" type=\"radio\" id=\"destination\" value= \"destination\"> <label for=\"destination\">destination</label>\n" +
        "            <input name=\"sort\" type=\"radio\" id=\"airline\" value= \"airline\" > <label for=\"airline\">airline</label>\n" +
        "            <p><strong> order by</strong></p>\n" +
        "\n" +
        "            <input name=\"ad\" type=\"radio\" id=\"ascending\" value= \"ascending\" ><label for=\"ascending\"> ascending</label>\n" +
        "            <input name=\"ad\" type=\"radio\" id=\"descending\" value= \"descending\"><label for=\"descending\"> descending</label>\n" +
        "\n" +
        "\n" +
        "           </div>"+
        "            <button type=\"submit\">search</button>\n" +
        "        </form>\n" +
        "    </div>\n" +
        "\n" +
        "   \n" +
        "\n" +
        "\n" +
        "        </div>\n" +
        "    </div>\n" +
        "\n" +
        "    \n" +
        "</body>\n" +
        "</html>");
    }else {
      StringBuilder allFlies = new StringBuilder();
      if (orderModel.equals("ascending")){
        for (Fly fly:flies) {
          allFlies.append(fly);
          allFlies.append("\n");
        }
      }
      if (orderModel.equals("descending")){
        for (int i = flies.size()-1 ;i>=0;i-- ){
          allFlies.append(flies.get(i));
          allFlies.append("\n");
          allFlies.append("\n");
        }
      }

      writer.write("<!DOCTYPE html>\n" +
        "<html lang=\"en\">\n" +
        "<head>\n" +
        "    <meta charset=\"UTF-8\">\n" +
        "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
        "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
        "    <title>Document</title>\n" +
        "    <style>\n" +
        "         input,\n" +
        "      button {\n" +
        "        width: 190px;\n" +
        "        height: 30px;\n" +
        "        margin: 10px;\n" +
        "      }\n" +
        "      .container {\n" +
        "        margin-right: 200px;\n" +
        "        margin-top: 50px;\n" +
        "      }\n" +
        "      form {\n" +
        "        display: flex;\n" +
        "        flex-direction: column;\n" +
        "      }\n" +
        "    \n" +
        " .founded{\n" +
          "        position: absolute;\n" +
          "       left: 20cm;    \n" +
          "        margin-top: 100px;\n" +
          "        margin-right: 500px;\n" +
          "    \n" +
          "\n" +
          "      }"+
        "    </style>\n" +
        "</head>\n" +
        "<body>\n" +
        "    <div>\n"  +
        "<h1 class=\"founded\"><strong> <strong>flies:</strong> </strong> </h1>"+
        "<br> <br>"+
        "<h2 class=\"founded\"><strong> "+ allFlies+"</strong> </h2>"+
        "</div>"+

        "    <div class=\"container\">\n" +
        "        <h1>ticket search</h1>\n" +
        "        \n" +
        "\n" +
        "        <form method= \"post\" action=\" /home_work_15_war_exploded/tickets\">\n" +
        "            <input type=\"text\" name=\"origin\" id=\"origin\" placeholder=\"origin\" required >\n" +
        "            <input type=\"text\" name=\"destination\" id=\"destination\" placeholder=\"destination\" required >\n" +
        "            <input type=\"date\" name=\"date\" >\n" +
        " <div class=\"sort\">\n" +
        "            <p><strong> sortin by</strong></p>\n" +
        "            <input name=\"sort\" type=\"radio\" id=\"cost\" value= \"cost\" checked> <label for=\"cost\"> cost</label>\n" +
        "            <input name=\"sort\" type=\"radio\" id=\"origin\" value= \"origin\"> <label for=\"origin \">origin</label>\n" +
        "            <br>\n" +
        "            <input name=\"sort\" type=\"radio\" id=\"destination\" value= \"destination\"> <label for=\"destination\">destination</label>\n" +
        "            <input name=\"sort\" type=\"radio\" id=\"airline\" value= \"airline\" > <label for=\"airline\">airline</label>\n" +
        "            <p><strong> order by</strong></p>\n" +
        "\n" +
        "            <input name=\"ad\" type=\"radio\" id=\"ascending\" value= \"ascending\"  checked ><label for=\"ascending\"> ascending</label>\n" +
        "            <input name=\"ad\" type=\"radio\" id=\"descending\" value= \"descending\"><label for=\"descending\"> descending</label>\n" +
        "\n" +
        "\n" +
        "           </div>"+
        "            <button type=\"submit\">search</button>\n" +

        "        </form>\n" +
        "    </div>\n" +
        "\n" +
        "   \n" +
        "\n" +
        "\n" +
        "        </div>\n" +
        "    </div>\n" +
        "\n" +
        "    \n" +
        "</body>\n" +
        "</html>");
    }

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String originCity = req.getParameter("origin");
    String destination = req.getParameter("destination");
    LocalDate date = LocalDate.parse(req.getParameter("date"));
    sortModel= req.getParameter("sort");
    orderModel= req.getParameter("ad");

    flies = ApplicationContext.
      getInstance().
      getFlyService().findByDateAndCity(date, originCity, destination);
    if (!flies.isEmpty()&& sortModel.equals("cost")){
      flies.sort(new Comparator<Fly>() {
        @Override
        public int compare(Fly o1, Fly o2) {
          return o1.compareToFlyCost(o2);
        }
      });
    }
    if (!flies.isEmpty()&& sortModel.equals("origin")){
        flies.sort(new Comparator<Fly>() {
          @Override
          public int compare(Fly o1, Fly o2) {
            return o1.compareToSourceCity(o2);
          }
        });

    }
    if (!flies.isEmpty()&& sortModel.equals("destination")){

      flies.sort(new Comparator<Fly>() {
        @Override
        public int compare(Fly o1, Fly o2) {
          return o1.compareToDesCity(o2);
        }
      });

    }
    if (!flies.isEmpty()&& sortModel.equals("airline")){
      flies.sort(new Comparator<Fly>() {
        @Override
        public int compare(Fly o1, Fly o2) {
          return o1.compareToAirlineCompany(o2);
        }
      });

    }
    resp.sendRedirect("/home_work_15_war_exploded/tickets");

  }
}
