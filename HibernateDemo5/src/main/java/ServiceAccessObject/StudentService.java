package ServiceAccessObject;

import Model.Student;
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
    public void addStudent(Student student) {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    // Insert ALL
    public void addAllStudent(List<Student> students) {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        for (Student student : students) {
            session.save(student);
        }
        transaction.commit();
    }

    public List<Student> getAllStudent() {
        List<Student> studentList = new ArrayList<>();
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Query query = session.createQuery("From Student");
        studentList = query.getResultList();
        return studentList;
    }

    public Student getStudent(int studentId) {
        Session session = sessionFactory.openSession();
        Student student = session.get(Student.class, studentId);
        return student;
    }

    public void deleteStudent(int studentId)
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
        String HQLquery = "DELETE FROM Student st where st.studentId = :st_id";
        Query query = session.createQuery(HQLquery);
        query.setParameter("st_id",studentId);
        query.executeUpdate();
        transaction.commit();
    }

    public void updateStudent(int studentId, String studentName, String studentEmail)
    {
        if (session == null)
        {
            session = sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, studentId);

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
            studentName = student.getStudentName();
        }
        if(!(studentEmail != null && studentEmail.trim().length() > 0))
        {
            studentEmail = student.getStudentEmail();
        }
        query.setParameter("studentName", studentName);
        query.setParameter("studentEmail", studentEmail);
        query.setParameter("studentId", studentId);
        query.executeUpdate();
        transaction.commit();
    }

}
