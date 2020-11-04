package ir.maktab.repository;



import ir.maktab.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.domains.Person;

import javax.persistence.TypedQuery;
import java.util.List;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Person,Long> implements PersonRepository {
    @Override
    protected Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Person findByName(String personName) {
        em.getTransaction().begin();
        TypedQuery<Person> query = em.createQuery(
                "SELECT u FROM Person u where u.firstName=:userName",
                Person.class);

        query.setParameter("userName", personName);
        List<Person> resultList = query.getResultList();
        em.getTransaction().commit();
        if (resultList.size() > 0) {
            return resultList.get(0);
        }
        return null;
    }
}
