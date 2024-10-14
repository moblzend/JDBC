package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Util {

    private static final  String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final  String USERNAME = "postgres";
    private static final  String PASSWORD = "postgres";

    public static Connection getConnection() {
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    return connection;
    }


//--------------------------------------------------------------------------------


    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration();


                configuration.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/first_db");
                configuration.setProperty("hibernate.connection.username", "postgres");
                configuration.setProperty("hibernate.connection.password", "postgres");
                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
                configuration.setProperty("hibernate.hbm2ddl.auto", "update"); // Для автоматического создания таблиц
                configuration.setProperty("hibernate.show_sql", "true"); // Для отображения SQL-запросов в консоли

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();


                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }


}
