package utils;

import java.sql.Connection;

public class ShutdownHookImple extends Thread
{
    @Override
    public void run ()
    {
        try
        {
            Connection conn = JdbcUtil.getConnection();
            conn.close();
            System.out.println("bye bye...");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
