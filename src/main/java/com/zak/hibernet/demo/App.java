package com.zak.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App 
{
    public static void main( String[] args )
    {
        HibernateUtil h= new HibernateUtil();
        SessionFactory sf=h.getSessionFactory();
        
        Item i=new Item();
        i.setName("vscode");
        i.setId(2);
        
        Session s=sf.openSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
        System.out.println("bye");
    }
}
