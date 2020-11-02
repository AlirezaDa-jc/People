package ir.maktab.services;


import ir.maktab.base.services.impl.BaseServiceImpl;
import ir.maktab.domains.Person;
import ir.maktab.repository.PersonRepository;
import ir.maktab.repository.PersonRepositoryImpl;

import java.util.LinkedList;
import java.util.List;


public class PersonServiceImpl extends BaseServiceImpl<Person, Long, PersonRepository> implements PersonService {
    private static List<Person> people = new LinkedList<>();

    public PersonServiceImpl() {
        PersonRepository repository = new PersonRepositoryImpl();
        super.setRepository(repository);
    }

    public static List<Person> getPeople() {
        return people;
    }

    @Override
    public Person saveOrUpdate(Person person) {
        return super.saveOrUpdate(person);
    }

    @Override
    public Person findByName(String aquariumName) {
        return baseRepository.findByName(aquariumName);
    }
}
