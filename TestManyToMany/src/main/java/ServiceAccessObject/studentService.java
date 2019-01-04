package ServiceAccessObject;

import Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class studentService {

    private SessionFactory sessionFactory;
    private Session session;
    public studentService() {
        sessionFactory = SessionFactoryProvider.getSessionFactory();
    }

    public void addStudent(Student student)
    {
        if (session == null)
        {
            session =  sessionFactory.openSession();
        }
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
    }

    public Student getStudent(int studentId)
    {
        if (session == null)
        {
            session =  sessionFactory.openSession();
        }
        Student student = session.get(Student.class, studentId);
        return student;
    }
}
