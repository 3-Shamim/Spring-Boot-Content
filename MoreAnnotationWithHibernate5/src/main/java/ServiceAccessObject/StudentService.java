package ServiceAccessObject;

import Model.StudentDetails;
import SessionFactoryProvider.SessionFactorySingleton;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StudentService {

    private SessionFactory sessionFactory;
    private Session session;

    public StudentService() {
        sessionFactory = SessionFactorySingleton.getSessionFactory();
    }

    // Insert Single
    public void addStudentDetails(StudentDetails student) {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    // Insert ALL
    public void addAllStudentDetails(List<StudentDetails> students) {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();

//        students.forEach(student -> session.save(student));

        for (StudentDetails student : students) {
            session.save(student);
        }
        transaction.commit();
    }

    // Get List of StudentDetails
    public List<StudentDetails> getAllStudentDetails() {
        List<StudentDetails> studentList = new ArrayList<>();
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Query query = session.createQuery("From StudentDetails");
        studentList = query.getResultList();
        return studentList;
    }

    // Get Single StudentDetails
    public StudentDetails getStudentDetails(int studentId) {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        StudentDetails student = session.get(StudentDetails.class, studentId);
        return student;
    }

    // Delete StudentDetails
    public void deleteStudentDetails(int studentId)
    {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        // Built Id Method
//        Student student = session.get(Student.class,studentId);
//        session.delete(student);

        // By HQL
//        String HQLquery = "DELETE FROM Student WHERE studentId = " + studentId;
        String HQLquery = "DELETE FROM StudentDetails st where st.id = :st_id";
        Query query = session.createQuery(HQLquery);
        query.setParameter("st_id",studentId);
        query.executeUpdate();
        transaction.commit();
    }

    // Update StudentDetails
    // Need to fix this method
    public void updateStudentDetails(int studentId, String studentName, String studentEmail)
    {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        StudentDetails student = session.get(StudentDetails.class, studentId);

        // Built in Method
//        if(studentName != null && studentName.trim().length() > 0)
//        {
//            student.setStudentName(studentName);
//        }
//        if(studentEmail != null && studentEmail.trim().length() > 0)
//        {
//            student.setStudentEmail(studentEmail);
//        }
//        session.save(student);

        // HQL
        Query query = session.createQuery("UPDATE Student st " +
                "SET st.studentName = :studentName, st.studentEmail = :studentEmail WHERE st.studentId = :studentId");
        if(!(studentName != null && studentName.trim().length() > 0))
        {
//            studentName = student.getStudentName();
        }
        if(!(studentEmail != null && studentEmail.trim().length() > 0))
        {
//            studentEmail = student.getStudentEmail();
        }
        query.setParameter("studentName", studentName);
        query.setParameter("studentEmail", studentEmail);
        query.setParameter("studentId", studentId);
        query.executeUpdate();
        transaction.commit();
    }

}
