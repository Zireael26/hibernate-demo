package com.registrarplatform.driver.OneToOne;

import com.registrarplatform.entity.Instructor;
import com.registrarplatform.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class ReadOneToOneDemo {
    public static void main(String[] args) {

        SessionFactory factory = new AnnotationConfiguration()
                .configure()
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
        Session session = factory.getCurrentSession();

        Instructor tempInstr = null;

        try {
            // use the session object to save/retrieve Java Objects

            // Start Transaction
            session.beginTransaction();

            // Get instructor by ID
            InstructorDetail tempInstrDetail = (InstructorDetail) session.get(InstructorDetail.class, 3L);

            // Delete the instructor
            if (tempInstrDetail != null) {
                tempInstr = tempInstrDetail.getInstructor();
            }

            // Commit the transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            System.out.print("Error occurred: ");
            e.printStackTrace();
        } finally {
            factory.close();
            System.out.println(tempInstr);
        }
    }
}
