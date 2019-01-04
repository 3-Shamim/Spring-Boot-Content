package ServiceAccessObject;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class SessionFactoryProvider {
    private final static SessionFactoryProvider instant =  new SessionFactoryProvider();
    private static SessionFactory sessionFactory;
    private SessionFactoryProvider() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
