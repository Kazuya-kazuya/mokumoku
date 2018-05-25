package service;

import java.sql.Connection;
import java.sql.SQLException;

public class PooledConnection
{
    private boolean isUsed;
    private Connection connection;

    public PooledConnection() throws ClassNotFoundException, SQLException
    {
        this.setUsed(false);
        this.setConnection(dao.Dao.getConnection());
    }

    public boolean getUsed() {
        return isUsed;
    }

    public void setUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
