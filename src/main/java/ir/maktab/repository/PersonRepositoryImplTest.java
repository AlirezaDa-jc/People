package ir.maktab.repository;

import ir.maktab.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.domains.Person;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

class PersonRepositoryImplTest extends BaseRepositoryImpl<Person, Long> {
    private static PersonRepository personRepository;
    @BeforeAll
    static void beforeAll() {
        personRepository = new PersonRepositoryImpl();
    }

    @Test
    void saveOrUpdate() {
        for(int i = 0 ; i < 100 ; i++){
            Person person = new Person("first"+new Date(),"last" + new Date() , new Date().getTime());
            personRepository.saveOrUpdate(person);
        }
    }

    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }
}