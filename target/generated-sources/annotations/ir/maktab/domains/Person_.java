package ir.maktab.domains;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Person.class)
public abstract class Person_ extends ir.maktab.base.domains.BaseEntity_ {

	public static volatile SingularAttribute<Person, String> firstName;
	public static volatile SingularAttribute<Person, String> lastName;
	public static volatile SingularAttribute<Person, Long> phoneNumber;

}

