package ir.maktab.services;


import ir.maktab.base.services.BaseService;
import ir.maktab.domains.Person;


public interface PersonService extends BaseService<Person,Long> {
   Person findByName(String aquariumName);
}
