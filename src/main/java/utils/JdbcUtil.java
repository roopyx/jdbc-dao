package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtil
{
    private static Connection conn = null;
    private static Properties prop;

    static
    {
        try
        {
            prop = new Properties();
            prop.load(new FileInputStream("src/main/resources/jdbc.properties"));
            String propName = "jdbc.connection.drv";
            String drv = prop.getProperty(propName);
            Class.forName(drv);

            Thread t = new ShutdownHookImple();
            Runtime.getRuntime().addShutdownHook((Thread)t);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection()
    {
        try
        {
            if ( conn == null || conn.isClosed() )
            {
                // url
                String propName = "jdbc.connection.url";
                String url = prop.getProperty(propName);

                // usr
                propName = "jdbc.connection.usr";
                String usr = prop.getProperty(propName);

                // pwd
                propName = "jdbc.connection.pwd";
                String pwd = prop.getProperty(propName);
                conn = DriverManager.getConnection(url, usr, pwd);
            }
            return conn;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
