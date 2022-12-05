package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Gateway<T> {
    T find(int id);
    boolean create(T obj);
    boolean update(T obj);
    boolean delete(T obj);

    class DBConnection
    {
        public static Connection getConnection()
        {
            try {
                String url = "jdbc:sqlserver://dbsys.cs.vsb.cz\\STUDENT;Database=paz0042;encrypt=true;trustServerCertificate=true;";
                String usr = "paz0042";
                String pass = "B8SwW0ftnXm8vBt9";
                return DriverManager.getConnection(url, usr, pass);
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
