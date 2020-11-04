package ir.maktab.controller;


import ir.maktab.MyApp;
import ir.maktab.domains.Person;
import ir.maktab.services.PersonService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddPersonServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String firstName = req.getParameter("firstname");
            String lastName = req.getParameter("lastname");
            long phoneNumber = Long.parseLong(req.getParameter("phonenumber"));
            PersonService personService = MyApp.getPersonService();
            Person person = new Person();
            person.setFirstName(firstName);
            person.setLastName(lastName);
            person.setPhoneNumber(phoneNumber);
            personService.saveOrUpdate(person);
            if(personService.findAll().size() > 100){
                resp.sendRedirect("export");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
