package db;

import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MessageDAO {

    public static Message find(String id) throws SQLException, ClassNotFoundException {
        String selectStmt = "SELECT * FROM contact;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);

            Message o = null;
            if (rs.next()) {
                o = new Message(rs.getString("NAME"), rs.getString("GENDER"),
                        rs.getString("CATEGORY"), rs.getString("MESSAGE"));
            }
            return o;
        } catch (SQLException e) {
            System.out.println("While searching a invoice with "
                    + id + " id, an error occurred: " + e);
            throw e;
        }
    }

    public static List<Message> list() throws SQLException,
            ClassNotFoundException {
        String selectStmt = "SELECT * FROM contact;";
        try {
            ResultSet rs = DBUtil.dbExecuteQuery(selectStmt);
            List<Message> list = new ArrayList();

            Message o;
            while (rs.next()) {
                o = new Message(rs.getString("NAME"), rs.getString("GENDER"),
                        rs.getString("CATEGORY"), rs.getString("MESSAGE"));
                list.add(o);
            }
            return list;
        } catch (SQLException e) {
            System.out.println("SQL select operation has been failed: " + e);
            throw e;
        }
    }

    public static Integer insert(String name, String gender, String category, String message)
            throws SQLException, ClassNotFoundException {
        Integer id = null;
        String updateStmt = "INSERT INTO contact (NAME, GENDER, CATEGORY, MESSAGE)"
                + " VALUES('" + name + "', '" + gender + "', '" + category + "', '" + message + "');";

        try {
            id = DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while INSERT Operation: " + e);
            throw e;
        }
        return id;
    }

    public static void delete(String id) throws SQLException, ClassNotFoundException {
        String updateStmt
                = "BEGIN\n"
                + "   DELETE FROM CONTACT\n"
                + "         WHERE id =" + id + ";\n"
                + "   COMMIT;\n"
                + "END;";
        try {
            DBUtil.dbExecuteUpdate(updateStmt);
        } catch (SQLException e) {
            System.out.print("Error occurred while DELETE Operation: " + e);
            throw e;
        }
    }

}
