package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
    private static final int numOfConnection = 3;
    private static final List<PooledConnection> connectionList = new ArrayList<PooledConnection>();
    private static final ConnectionPool connectionPool = new ConnectionPool();

    private ConnectionPool()
    {
        try
        {
            for(int i = 0; i < numOfConnection; i++)
            {
                ConnectionPool.connectionList.add(new PooledConnection());
            }
        }
        catch (ClassNotFoundException | SQLException e)
        {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public static PooledConnection getConnection()
    {
        PooledConnection connection = null;
        while(connection == null)
        {
            for(int i = 0; i < numOfConnection; i++)
            {
                PooledConnection pooledConnection = connectionList.get(i);
                if(!pooledConnection.getUsed())
                {
                    pooledConnection.setUsed(true);
                    connection = pooledConnection;
                    break;
                }
            }
        }
        return connection;
    }

    public static void releaseConnection(PooledConnection connection)
    {
        connection.setUsed(false);
    }


    public static ConnectionPool getConnectionpool() {
        return connectionPool;
    }
}
