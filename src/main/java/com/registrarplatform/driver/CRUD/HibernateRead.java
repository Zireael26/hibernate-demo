package com.registrarplatform.driver.CRUD;

import com.registrarplatform.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class HibernateRead {
    public static void main(String[] args) {

        SessionFactory factory = new AnnotationConfiguration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        List savedStudents = null;

        try {
            // use the session object to save/retrieve Java Objects

            // Start Transaction
            session.beginTransaction();

            // Retrieve saved student
//            Student retrievedStudent = (Student) session.get(Student.class, tempStudent.getId());
            savedStudents = session.createQuery("from Student").list();
//            savedStudents = session.createQuery("from Student s where s.lastName = 'Doe' OR s.firstName LIKE '%a%'").list();

            // Commit the transaction
            session.getTransaction().commit();

//            System.out.println(retrievedStudent);
            for (Object s : savedStudents) {
                Student stu = (Student) s;
                System.out.println(stu);
            }

        } catch (Exception e) {
            System.out.print("Error occurred: ");
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
