package server;
import java.sql.*;

public class sqlserver{
    private sqlserver(){}
    private static Connection SQLConnection;
    private static PreparedStatement SQLOperator;
    private static ResultSet SQLResultSet;
    public static ResultSet go(logID logInfo, String SQLInstruction) throws Exception {
        try{
            System.out.println("Connecting to SQL Server ...");
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            SQLConnection = DriverManager.getConnection(logInfo.getHost() + ";encrypt=true;trustServerCertificate=true", logInfo.getUser(), logInfo.getPassword());
            System.out.println("Done");
            SQLConnection.setAutoCommit(true);
        } catch(ClassNotFoundException e) { System.err.println(e.getMessage()); }
        catch(Exception e){ System.err.println(e.getMessage()); }
        try {
            SQLConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            SQLOperator = SQLConnection.prepareStatement(SQLInstruction, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            SQLOperator.execute();
            SQLResultSet = SQLOperator.getResultSet();
            if(SQLResultSet == null) {
                System.out.println(" - Resultset is null - ");
            }
        } catch (SQLException e) { System.err.println(e.getMessage()); }
        catch(Exception e){ System.err.println(e.getMessage()); }
        return SQLResultSet;
    }
    public static void closeServer() throws Exception {
        try{
            if(SQLOperator != null){
                System.out.println("SQL Server operator closing ...");
                SQLOperator.close();
                System.out.println("Done");
            }
        }catch(Exception e){
            SQLConnection.rollback();
            throw new Exception("Operator could not close: " + e.getMessage());
        }try{
            if(SQLConnection != null){
                System.out.println("SQL Server connection closing ...");
                SQLConnection.close();
                System.out.println("Done");
            }
        }catch(Exception e){
            SQLConnection.rollback();
            throw new Exception("Connection could not close: " + e.getMessage());
        }
    }
}