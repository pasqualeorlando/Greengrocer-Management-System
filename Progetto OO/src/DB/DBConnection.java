package DB;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static DBConnection instance;
    private Connection connection = null;

    private DBConnection() throws SQLException, IOException {
        try{
            Class.forName("org.postgresql.Driver");
            //carico il file di configurazione contenente le credenziali
            Properties props = new Properties();
            FileInputStream in = new FileInputStream("src/DB/dbconfig.properties");
            props.load(in);
            in.close();
            
            String USERNAME = props.getProperty("username");
            String PASSWORD = props.getProperty("password");
            String IP = props.getProperty("ip");
            String URL = "jdbc:postgresql://"+IP+":5432"+"/Progetto";
            
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (ClassNotFoundException ex){
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBConnection getInstance() throws SQLException, IOException {
        if (instance == null){
            instance = new DBConnection();
        }
        else
            if (instance.getConnection().isClosed()){
                instance = new DBConnection();
            }

        return instance;
    }
}
