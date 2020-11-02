package ir.maktab.controller;


import ir.maktab.MyApp;
import ir.maktab.domains.Person;
import ir.maktab.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DisplayServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<style>\n" +
                "#customers {\n" +
                "  font-family: Arial, Helvetica, sans-serif;\n" +
                "  border-collapse: collapse;\n" +
                "  width: 100%;\n" +
                "}\n" +
                "\n" +
                "#customers td, #customers th {\n" +
                "  border: 1px solid #ddd;\n" +
                "  padding: 8px;\n" +
                "}\n" +
                "\n" +
                "#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
                "\n" +
                "#customers tr:hover {background-color: #ddd;}\n" +
                "\n" +
                "#customers th {\n" +
                "  padding-top: 12px;\n" +
                "  padding-bottom: 12px;\n" +
                "  text-align: left;\n" +
                "  background-color: #4CAF50;\n" +
                "  color: white;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<table id=\"people\">\n" +
                "</html>");
        PersonService personService = MyApp.getPersonService();
        List<Person> all = personService.findAll();
        out.println("  <tr>\n" +
                "    <th>ID</th>\n" +
                "    <th>FirstName</th>\n" +
                "    <th>LastName</th>\n" +
                "    <th>PhoneNumber</th>\n" +
                "  </tr>\n");
        for (Person person : all) {
            out.println("<tr>\n");
            out.println("<td>" + person.getId() + "</td>\n" );
            out.println("<td>" + person.getFirstName() + "</td>\n" );
            out.println("<td>" + person.getLastName() + "</td>\n" );
            out.println("<td>" + person.getPhoneNumber() + "</td>\n" + "</tr>\n" );
        }
        out.println("</table>\n" +
                "\n" +
                "</body>\n" );
        out.println("<a href=\"export\">Export As An Excel File</a> <br> ");

    }
}
