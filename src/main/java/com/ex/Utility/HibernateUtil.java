package com.ex.Utility;

import java.util.Properties;

import com.ex.Models.Reimbursement;
import com.ex.Models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static boolean testing = false;



    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                String url = "jdbc:postgresql://database-18.ck6vrhldzog7.us-east-1.rds.amazonaws.com:5432/postgres";
                String username = "josfeldmann";
                String password = "Elliotsarat";

                Properties props = new Properties();
                props.setProperty("hibernate.connection.url", url);
                props.setProperty("hibernate.connection.username", username);
                props.setProperty("hibernate.connection.password", password);
                props.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                props.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
                props.setProperty("hibernate.show_sql", "true");
                props.setProperty("hibernate.format_sql", "true");
                props.setProperty("hibernate.hbm2ddl.auto", "update");


                configuration.setProperties(props);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Reimbursement.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}