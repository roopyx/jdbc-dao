package utils;

import java.sql.Connection;

public class Transaction
{

    private Connection connection = null;

    public Transaction (Connection connection) {this.connection = connection;}

    public void commit ()
    {
        try
        {
            //connection.setAutoCommit(false);
            connection.commit();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    public void rollback ()
    {
        try
        {
            connection.rollback();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            throw new RuntimeException();
        }
    }
}
