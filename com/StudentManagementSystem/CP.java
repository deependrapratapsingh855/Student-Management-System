package com.StudentManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {
    static Connection con;
    public static Connection createCon(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","Deep","deep");
        }catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }
        return con;
    }
}
