package com.zak.hibernet.demo;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class App 
{
   
   
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws NumberFormatException, IOException {
       
        PetDao idao=new PetDao();
        Pet it=null;
        int id;
        String name;
        String owner;
        String type;
   
        do {
            try{
            System.out.println("Menu\n1.Add Pet\n2.Change Pet\n3.Display all pets\n4.Exit\nEnter choice");
            switch(Integer.parseInt(br.readLine())) {
            case 1:
                //FILL YOUR CODE
                
                System.out.println("Enter pet name");
                name=br.readLine();
                System.out.println("Enter pet owner name");4
                owner=br.readLine();
                System.out.println("Enter Tpye");
                type=br.readLine();
                
               
                it=new Pet();
                
                it.setName(name);
                it.setOwner(owner);
                it.setType(type);
               
               
                idao.add(it);
                System.out.println("Added to the list successfully");
                break;
            case 2:
                System.out.println("Enter item id");
                id=Integer.parseInt(br.readLine());
                if(idao.find(id)==null)
                    System.out.println("pet not found");
                else {
                    it=new Pet();
                    it.setId(id);
                    
                    System.out.println("Enter pet name");
                    name=br.readLine();
                    System.out.println("Enter pet owner name");
                    owner=br.readLine();
                    System.out.println("Enter Tpye");
                    type=br.readLine();
                    it.setName(name);
                    it.setOwner(owner);
                    it.setType(type);
                    idao.update(it);
                    System.out.println("Changes are updated successfully");
                }
                break;
           
            case 3:
                List<Pet> ilit=new ArrayList<Pet>();
                ilit=idao.getall();
                if(ilit.isEmpty())
                {
                    System.out.println("Empty list");
                }
                else
                {
                System.out.printf("%-15s %-15s %-15s  %-15s\n","Id","Name","Owner","Type");
                for(Pet i:ilit) {
                    System.out.printf("%-15s %-15s %-15s %-15s\n", i.getId(),i.getName(),i.getOwner(),i.getType());
                }
                }
                break;
            case 4:
                System.out.println("Bye");
                System.exit(0);
            default:
                System.out.println("Invalid choice");
            }
        }
        catch(Exception e)
        {
            System.out.println("error ");
        }
        }while(true);
    }
    
}
