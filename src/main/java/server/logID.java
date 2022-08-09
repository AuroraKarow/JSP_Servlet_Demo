package server;

public class logID {
    private String host;
    private String user;
    private String password;
    private String databse;
    private String port;
    public logID(String hostWithPort, String DBName, String userID, String userPassword){
        port = hostWithPort;
        databse = DBName;
        host = "jdbc:sqlserver://" + hostWithPort + ";databaseName=" + DBName;
        user = userID;
        password = userPassword;
    }
    public void setDBName(String DBName){
        databse = DBName;
        host = "jdbc:sqlserver://" + port + ";databaseName=" + DBName;
    }
    public void setHost(String hostWithPort){
        port = hostWithPort;
        host = "jdbc:sqlserver://" + hostWithPort + ";databaseName=" + databse;
    }
    public void setUserID(String userID){
        user = userID;
    }
    public void setPassword(String userPassword){
        password = userPassword;
    }
    public String getHost(){
        return host;
    }
    public String getUser(){
        return user;
    }
    public String getPassword(){
        return password;
    }
}