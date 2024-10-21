package com.master.main.Config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfig {
	
	public static SessionFactory sessionFactory() {
		Configuration configuration = new Configuration();
		configuration.configure("com/master/main/resources/hibernate-cfg.xml");
		
		return configuration.buildSessionFactory();
	}
}
