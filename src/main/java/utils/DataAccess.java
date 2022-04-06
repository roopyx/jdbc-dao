package utils;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataAccess {

    private static String properties = "src/main/resources/DataAccess.properties";
    private static Connection conn = null;
    private static Properties prop = null;

    static
    {
        try
        {
            prop = new Properties();
            prop.load(new FileInputStream(properties));
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

    public static Transaction beginTransaction ()
    {
        return new Transaction( getConnection() );
    }

    public static <T> T getObject ( String objName )
    {
        try
        {
            String classname = prop.getProperty(objName);
            Class<?> clazz = Class.forName(classname);
            return (T)clazz.newInstance();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
