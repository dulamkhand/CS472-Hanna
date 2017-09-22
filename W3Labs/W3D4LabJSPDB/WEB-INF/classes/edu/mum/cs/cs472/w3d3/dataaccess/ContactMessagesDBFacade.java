package edu.mum.cs.cs472.w3d3.dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.mum.cs.cs472.w3d3.model.ContactMessage;

public class ContactMessagesDBFacade {
	
	private DBConnection dbConnection;
	
	public ContactMessagesDBFacade() {
		this.dbConnection = DBConnection.getInstance();
	}
	
	public void saveContactMessage(ContactMessage contactMessage) {		
		Connection conn = dbConnection.getConnection();
		String sqlCmd = "insert into APP.TBL_CONTACTMESSAGES (CUSTOMERNAME, GENDER, CATEGORY, MESSAGE, DATESUBMITTED) values (?, ?, ?, ?, ?)";		 	
		try (PreparedStatement pstmt = conn.prepareStatement(sqlCmd)) {
			pstmt.setString(1, contactMessage.getCustomerName());
			pstmt.setString(2, contactMessage.getGender());
			pstmt.setString(3, contactMessage.getCategory());
			pstmt.setString(4, contactMessage.getMessage());
			pstmt.setString(5, contactMessage.getCurrentDate());
			pstmt.executeUpdate();
		} catch(SQLException sqlEx) {
			printSQLException(sqlEx);
		} 		
	}	
	
	public List<ContactMessage> getContactMessages() {
		Connection conn = dbConnection.getConnection();
		ResultSet rs = null;
		List<ContactMessage> contactMessages = new ArrayList<>();
		
		try (Statement stmt = conn.createStatement()){
			rs = stmt.executeQuery("SELECT CONTACTMESSAGEID, CUSTOMERNAME, GENDER, CATEGORY, MESSAGE, DATESUBMITTED from app.tbl_CONTACTMESSAGES order by CONTACTMESSAGEID");
			
			while(rs.next()) {
				ContactMessage cm = new ContactMessage();
				int contactMessageId = rs.getInt("CONTACTMESSAGEID");
				String customerName = rs.getString("CUSTOMERNAME");
				String gender = rs.getString("GENDER");
				String category = rs.getString("CATEGORY");
				String message = rs.getString("MESSAGE");	
				String dateSubmitted = rs.getString("DATESUBMITTED");	
				cm.setContactMessageId(contactMessageId);
				cm.setCustomerName(customerName);
				cm.setGender(gender);
				cm.setCategory(category);
				cm.setMessage(message);
				cm.setCurrentDate(dateSubmitted);				
				contactMessages.add(cm);
			}
			closeResultSet(rs);
		} catch(SQLException sqlEx) {
			printSQLException(sqlEx);
		}
		return contactMessages;
	}
	
    /**
     * Prints details of an SQLException chain to <code>System.err</code>.
     * Details included are SQL State, Error code, Exception message.
     *
     * @param e the SQLException from which to print details.
     */
    public static void printSQLException(SQLException e)
    {
        // Unwraps the entire exception chain to unveil the real cause of the Exception.
        while (e != null)
        {
            System.err.println("\n----- SQLException -----");
            System.err.println("  SQL State:  " + e.getSQLState());
            System.err.println("  Error Code: " + e.getErrorCode());
            System.err.println("  Message:    " + e.getMessage());
            // for stack traces, refer to derby.log or uncomment this:
            //e.printStackTrace(System.err);
            e = e.getNextException();
        }
    }	
    
    private void closeResultSet(ResultSet rs) {
        // ResultSet
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
        } catch (SQLException sqle) {
            printSQLException(sqle);
        }
    }
    
    public static void closeDBConnection(Connection conn) {
        try {
            if (conn != null) {
            	System.out.println("Closing connection to the SRSDB database on JavaDB server...");
                conn.close();
                conn = null;
                System.out.println("Successfully closed connection to the SRSDB database on JavaDB server...");
            }
        } catch (SQLException sqle) {
            printSQLException(sqle);
        }
    }    
	
}
