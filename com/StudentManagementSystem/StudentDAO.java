package com.StudentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class StudentDAO {
    public boolean addStudent(Student obj) throws Exception {
        boolean b=false;
        try {
            Connection con=CP.createCon();
            String q="insert into students(sname,sdept,sphone,saddress) values(?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getDepartment());
            ps.setString(3, obj.getPhoneNo());
            ps.setString(4, obj.getAddress());
            ps.execute();
            b=true;
        }catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }

        return b;
    }

    public boolean deleteStudent(int id) throws Exception {
        boolean b=false;
        try {
            Connection con=CP.createCon();
            String q="delete students where id=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, String.valueOf(id));
            ps.execute();

            b=true;

        }catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }

        return b;
    }
    public void listAllStudent() throws Exception {
        try {
            Connection con=CP.createCon();
            String q="select * from students";
            Statement st= con.createStatement();
            ResultSet set=st.executeQuery(q);
            while(set.next())
            {
                System.out.println("ID : "+set.getInt(1));
                System.out.println("NAME : "+set.getString(2));
                System.out.println("DEPARTMENT : "+set.getString(3));
                System.out.println("PHONE NO. : "+ set.getString(4));
                System.out.println("ADDRESS : "+set.getString(5));
                System.out.println("---------------------------------------");
            }
        }catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }

    }

    public boolean findStudent(int ids) throws Exception {
        boolean b=false;
        try {
            Connection con=CP.createCon();
            String q1="select * from students where id=";
            String s= String.valueOf(ids);
            String q=q1+s;
            Statement st= con.createStatement();
            ResultSet set=st.executeQuery(q);
            set.next();
                int id=set.getInt(1);
                String name=set.getString(2);
                String department=set.getString(3);
                String phoneNo=set.getString(4);
                String address=set.getString(5);
                b=true;
            System.out.println("-----------------------------------------");
                System.out.println("ID : "+id);
                System.out.println("NAME : "+name);
                System.out.println("DEPARTMENT : "+department);
                System.out.println("PHONE NO. : "+ phoneNo);
                System.out.println("ADDRESS : "+address);
                System.out.println("---------------------------------------");
        }catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }

        return b;
    }

    public boolean updateStudent(Student obj) throws Exception {
        boolean b=false;
        try {
            Connection con=CP.createCon();
            String q="update students set sname=? ,sdept=?,sphone=?,saddress=? where id=?";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, obj.getName());
            ps.setString(2, obj.getDepartment());
            ps.setString(3, obj.getPhoneNo());
            ps.setString(4, obj.getAddress());
            ps.setInt(5, obj.getId());
            ps.execute();
            b=true;
        }catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }

        return b;
    }
    public boolean checkid(int ids) throws Exception {
        boolean b=false;
        try {
            Connection con=CP.createCon();
            String q1="select * from students where id=";
            String s= String.valueOf(ids);
            String q=q1+s;
            Statement st= con.createStatement();
            ResultSet set=st.executeQuery(q);
            b=set.next();
        }catch (Exception e)
        {
            System.out.println("Exception : "+e);
        }

        return b;
    }


}


