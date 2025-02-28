package OneToManymapping;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.HashSet;
import java.util.Set;

public class maindemo {


    public static void main(String[] args) {

                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Departmentt.class)
                        .addAnnotatedClass(College.class)
                        .buildSessionFactory();

        Session session=factory.openSession();

                Departmentt department = new Departmentt();
                department.setDepartmentName("Engineering");

                College college1 = new College();
                college1.setCollegeName("College of Computer Science");

                College college2 = new College();
                college2.setCollegeName("College of Electrical Engineering");

                college1.setDepartment(department);
                college2.setDepartment(department);

                Set<College> colleges = new HashSet<>();
                colleges.add(college1);
                colleges.add(college2);
                department.setColleges(colleges);

                    Transaction txt=  session.beginTransaction();

                session.save(department);

                txt.commit();
                System.out.println("Department and colleges saved successfully!");

                factory.close();
            }
        }



