package entity;

import entity.*;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Passport.class)
public abstract class Passport_ {

	public static volatile SingularAttribute<Passport, String> passportNumber;
	public static volatile SingularAttribute<Passport, Long> id;
	public static volatile SingularAttribute<Passport, Customer> customer;

}

