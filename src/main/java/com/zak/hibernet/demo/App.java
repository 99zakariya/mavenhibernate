package com.zak.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("hi");
        HibernateUtil h= new HibernateUtil();
        SessionFactory sf=h.getSessionFactory();
        
     //   Item i=new Item();
      //  i.setName("vscode");
       // i.setId(2);
        
        Session s=sf.openSession();
        s.beginTransaction();
       // s.save(i);
       Item i = (Item)s.get(Item.class,2);
       System.out.println(i);
        s.getTransaction().commit();
        System.out.println("bye");
    }
}
