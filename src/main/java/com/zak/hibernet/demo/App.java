package com.zak.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class App 
{
    SessionFactory sf;
    public App(){
        HibernateUtil h= new HibernateUtil();
         sf=h.getSessionFactory();
    }
    public static void main( String[] args )
    {
        System.out.println("hi");
        
        
        Item i=new Item();
        i.setName("vscode");
        i.setId(2);

        App ob=new App();
        ob.add(i);
        ob.print();
      
      
        
        System.out.println("bye");
    }
    public void add(Item i)
    {
        Session s=sf.openSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
    }
    public void print()
    {
        Session s=sf.openSession();
        s.beginTransaction();
        Item i = (Item)s.get(Item.class,2);
        System.out.println(i);
        s.getTransaction().commit();
    }
}
