package com.codercrope.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static DBConnection dbConnection;
    private String port;
    private String user;
    private String pwd;

    private final Connection connection;

    private DBConnection(String port, String user, String pwd) throws ClassNotFoundException, SQLException {
        this.port=port;
        this.user = user;
        this.pwd = pwd;
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.connection = DriverManager.getConnection("jdbc:mysql://localhost:"+this.port+"/lms_gdse",this.user,this.pwd);
    }
    public static DBConnection getConnection(String port,String user,String pwd) throws SQLException, ClassNotFoundException {
        return dbConnection ==null ? dbConnection=new DBConnection(port,user,pwd):dbConnection;
    }
}
