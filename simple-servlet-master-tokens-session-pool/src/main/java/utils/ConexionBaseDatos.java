package utils;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    private static String url = "jdbc:mysql://localhost:3306/gestion_libros?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "eneas2805";
    private static BasicDataSource pool;  //<-- ESte es el pool de conexiones que tiene unos valores por defecto

    // Crea el pool
    public static BasicDataSource getInstance() throws SQLException {
        if (pool == null) {
            pool = new BasicDataSource();
            pool.setUrl(url);
            pool.setDriverClassName("com.mysql.cj.jdbc.Driver");
            pool.setUsername(username);
            pool.setPassword(password);
            pool.setInitialSize(3); //<-- cantidad de conexiones habilitadas al inicio. Por defecto, es 0
            pool.setMinIdle(3);     //<-- min. de conexiones esperando para ser utilizadas. Por defecto, es 0
            pool.setMaxIdle(8);     //<-- idem, pero máximo
            pool.setMaxTotal(20);    //<-- Total de conexiones entre inactivas (sin utilizar) y utilizadas
        }
        return pool;
    }

    // Devuelve una conexión del pool
    public static Connection getConnection() throws SQLException {
        return getInstance().getConnection();
    }
}
