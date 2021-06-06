package com.zak.hibernet.demo;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil 
{
   private static SessionFactory sessionFactory=null;

    static {   
        try 
        {
        	Logger l=Logger.getLogger("org.hibernate");
        	l.setLevel(Level.OFF);
        	System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");
        	
        	
	
            Configuration cfg = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/mydb");
            cfg.setProperty("hibernate.connection.username", "petclinic");
            cfg.setProperty("hibernate.connection.password", "petclinic");
//            cfg.setProperty("hibernate.connection.username", "system");
//            cfg.setProperty("hibernate.connection.password", "system");
            cfg.addAnnotatedClass(Item.class);
            sessionFactory=cfg.buildSessionFactory();
        }
        catch (Throwable ex) 
        {
            System.err.println("SessionFactory initial creation error."+ ex);    
        }
    }
    
    public static SessionFactory getSessionFactory() 
    {
        return sessionFactory;
    }
}