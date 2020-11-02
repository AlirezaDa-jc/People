package ir.maktab.repository;


import ir.maktab.base.repository.BaseRepository;
import ir.maktab.domains.Person;

public interface PersonRepository extends BaseRepository<Person,Long> {
    Person findByName(String aquariumName);
}
