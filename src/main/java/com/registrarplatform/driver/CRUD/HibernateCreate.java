package com.registrarplatform.driver.CRUD;

import com.registrarplatform.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Hello world!
 */
public class HibernateCreate {

    public static void main(String[] args) {

        SessionFactory factory = new AnnotationConfiguration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save/retrieve Java Objects
            // Create a student object
            Student tempStudent = new Student("Abhishek", "Kaushik", "abhishek.ka@endurance.com");
            Student tempStudent2 = new Student("john", "Doe", "john@endurance.com");
            Student tempStudent3 = new Student("Jane", "Doe", "jane@endurance.com");
            Student tempStudent4 = new Student("Jack", "Sparrow", "jack@endurance.com");
            Student tempStudent5 = new Student("Will", "Ferrell", "william@endurance.com");
            Student tempStudent6 = new Student("Manish", "Manchanda", "manish@endurance.com");

            // Start Transaction
            session.beginTransaction();

            // Save the Student
            session.save(tempStudent);
            session.save(tempStudent2);
            session.save(tempStudent3);
            session.save(tempStudent4);
            session.save(tempStudent5);
            session.save(tempStudent6);

            // Commit the transaction
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.print("Error occurred: ");
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
