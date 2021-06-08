package com.zak.hibernet.demo;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class itemDao {
    SessionFactory sf;
    public itemDao(){
        HibernateUtil h= new HibernateUtil();
         sf=h.getSessionFactory();
    }
    public void add(Item i)
    {
        Session s=sf.openSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
        System.out.println("item added to database");
    }
    public void print()
    {
        Session s=sf.openSession();
        s.beginTransaction();
        Item i = (Item)s.get(Item.class,2);
        System.out.println(i);
        s.getTransaction().commit();
    }
    public List<Item> getall()
    {
        List<Item> li=new ArrayList<Item>();
        Session s=sf.openSession();
        s.beginTransaction();
        Criteria c=s.createCriteria(Item.class);
        li=c.list();
        s.getTransaction().commit();
        return li;
    }
    public  void update(Item i)
    {
        Session s=sf.openSession();
        s.beginTransaction();
        s.update(i);
        s.getTransaction().commit();
        System.out.println("item updated ");
    }
    
}
