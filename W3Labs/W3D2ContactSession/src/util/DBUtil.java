package util;

import java.sql.*;
import com.sun.rowset.CachedRowSetImpl;

public class DBUtil {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static Connection conn = null;

    private static final String connStr = "jdbc:mysql://107.180.56.180:3306/"
            + "music_recc?user=musifyy_dbuser&password=musifyy_dbpa$$";

    public static void dbConnect() throws SQLException, ClassNotFoundException {
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not locate jdbc driver");
            throw e;
        }

        try {
            conn = DriverManager.getConnection(connStr);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            throw e;
        }
    }

    public static Connection getDbConnect() throws SQLException, ClassNotFoundException {
        Connection conn1;
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Could not locate jdbc driver");
            throw e;
        }

        try {
            conn1 = DriverManager.getConnection(connStr);
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console" + e);
            throw e;
        }
        return conn1;
    }

    public static void setAutoCommitOff() throws SQLException, ClassNotFoundException {
        if (conn != null) {
            dbConnect();
            conn.setAutoCommit(false);
        }
    }

    public static void dbDisconnect() throws SQLException {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                //System.out.println("Database connection is closed");
            }
        } catch (SQLException e) {
            throw e;
        }
    }

    //DB Execute Query Operation
    public static ResultSet dbExecuteQuery(String queryStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet resultSet = null;
        CachedRowSetImpl crs = null;
        try {
            dbConnect();
            System.out.println("----------");
            System.out.println(queryStmt + "\n");
            stmt = conn.createStatement();
            resultSet = stmt.executeQuery(queryStmt);

            crs = new CachedRowSetImpl();
            crs.populate(resultSet);
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return crs;
    }

    public static Integer dbExecuteUpdate(String sqlStmt) throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        Integer id = null;
        try {
            dbConnect();
            System.out.println("----------");
            System.out.println(sqlStmt + "\n");
            stmt = conn.createStatement();
            stmt.executeUpdate(sqlStmt, Statement.RETURN_GENERATED_KEYS);

            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("Problem occurred at executeUpdate operation : " + e);
            throw e;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
            dbDisconnect();
        }
        return id;
    }

}
