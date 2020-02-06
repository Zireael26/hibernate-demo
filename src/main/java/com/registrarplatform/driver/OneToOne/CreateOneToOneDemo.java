package com.registrarplatform.driver.OneToOne;

import com.registrarplatform.entity.Instructor;
import com.registrarplatform.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class CreateOneToOneDemo {
    public static void main(String[] args) {

        SessionFactory factory = new AnnotationConfiguration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        try {
            // use the session object to save/retrieve Java Objects

            // Create an Instructor object
            Instructor tempInstructor = new Instructor("Abhishek", "Kaushik", "abhishek.nexus26@gmail.com");
            // Create aa InstructorDetail object
            InstructorDetail tempInstructorDetail = new InstructorDetail("https://youtube.com/abhi26", "Chess");
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // Start Transaction
            session.beginTransaction();

            // Save the Student
            session.save(tempInstructor);

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
