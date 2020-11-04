package ir.maktab;

import ir.maktab.services.PersonService;
import ir.maktab.services.PersonServiceImpl;


public class MyApp {
    private static final PersonService personService = new PersonServiceImpl();

    public static PersonService getPersonService() {
        return personService;
    }

}
