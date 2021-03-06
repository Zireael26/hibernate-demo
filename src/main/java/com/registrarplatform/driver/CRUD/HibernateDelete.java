package com.registrarplatform.driver.CRUD;

import com.registrarplatform.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateDelete {
    public static void main(String[] args) {
        SessionFactory factory = new AnnotationConfiguration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save/retrieve Java Objects
            // Start Transaction
            session.beginTransaction();

            // Get a student object
//            Student tempStudent = (Student) session.get(Student.class, 8L);
            // Delete the value
//            tempStudent.delete(tempStudent);

            // OR

//          Remember that in createQuery() method, we use the Entity Class name and data members, not how its written in the database
            session.createQuery("delete from Student where id = 9").executeUpdate();
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
