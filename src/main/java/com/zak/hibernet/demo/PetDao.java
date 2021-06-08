package com.zak.hibernet.demo;
import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class PetDao {
    SessionFactory sf;
    public PetDao(){
        HibernateUtil h= new HibernateUtil();
         sf=h.getSessionFactory();
    }
    public void add(Pet i)
    {
        Session s=sf.openSession();
        s.beginTransaction();
        s.save(i);
        s.getTransaction().commit();
       // System.out.println("pet added to database");
    }
    public Pet find(int id)
    {
        Session s=sf.openSession();
        s.beginTransaction();
        Pet i = (Pet)s.get(Pet.class,id);
        
        s.getTransaction().commit();
        return i;
    }
    public List<Pet> getall()
    {
        List<Pet> li=new ArrayList<Pet>();
        Session s=sf.openSession();
        s.beginTransaction();
        Criteria c=s.createCriteria(Pet.class);
        li=c.list();
        s.getTransaction().commit();
        return li;
    }
    public  void update(Pet i)
    {
        Session s=sf.openSession();
        s.beginTransaction();
        s.update(i);
        s.getTransaction().commit();
    //    System.out.println("data updated ");
    }
    
}
