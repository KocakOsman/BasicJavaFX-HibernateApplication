package HibernateCfg;

import Model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            Configuration configuration = new Configuration();
            Properties settings = new Properties();

            settings.put(Environment.DRIVER,"com.mysql.jdbc.Driver");
            settings.put(Environment.URL,"jdbc:mysql://localhost:3306/javafxhiber?useSSL=false");
            settings.put(Environment.USER,"root");
            settings.put(Environment.PASS,"Bailey2019");
            settings.put(Environment.SHOW_SQL,"true");
            settings.put(Environment.HBM2DDL_AUTO,"create-drop");

            configuration.setProperties(settings);
            configuration.addAnnotatedClass(User.class);

            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }
}
