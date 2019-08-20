package com.third.project3;

import javax.persistence.EntityManagerFactory;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	//http://www.objectdb.com/java/jpa/persistence/overview
	//EntityManagerFactory: to support instantiation of EntityManager instances.
	//EntityManager: provides functionality for performing operations on a database
	
	@Bean
	public SessionFactory getSessionFactory()
	{
		if(entityManagerFactory.unwrap(SessionFactory.class)==null) 
			{
				throw new NullPointerException("factory is not a hibernate factory");
			}
    return entityManagerFactory.unwrap(SessionFactory.class);
}
	//http://www.javaforecast4u.com/2012/05/what-is-seesion-factory-in-hibernate.html
	//Interface that creates live long thread 
	
	//unwarp:https://jensonjava.wordpress.com/2011/11/08/jpa-entitymanager-unwrap-method/
	//used to gain access of JPA-vendor-specific classes.
}
