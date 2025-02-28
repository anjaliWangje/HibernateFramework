package Lifecyle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import static Lifecyle.Main.sessionFactory;

    public class hibernatelifecycle {

        public static void main(String[] args) {

            Session session = sessionFactory.openSession();
   //Transient state
            Company company = new Company("TCS", "pune");
            System.out.println("Company in Transient State: " + company);
            //Persistent state
             Transaction tx = session.beginTransaction();
            System.out.println("saving the company");
            session.save(company);

            tx.commit();
            System.out.println("Company in Persistent State: " + company);
//Detached state
                  session = Main.getSession();
                  Transaction txt= session.beginTransaction();
                  Company fetchedCompany = session.get(Company.class, company.getId());
                  txt.commit();
                  session.close();
                  System.out.println("Company in detached state: " + fetchedCompany);
//removed state
                  session = Main.getSession();
                 session.beginTransaction();
                 session.delete(fetchedCompany);
                 System.out.println("Company in removed state: " + fetchedCompany);

                 session.close();
        }
    }





