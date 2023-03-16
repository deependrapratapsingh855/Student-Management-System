package com.StudentManagementSystem;

public class StudentService {
    StudentDAO dao = new StudentDAO();
    public boolean addStudent(Student obj) throws Exception {
        boolean b=dao.addStudent(obj);
        return b;
    }
    public boolean findStudent(int id) throws Exception{
        boolean b=dao.findStudent(id);
        return b;
    }
    public boolean checkid(int id) throws Exception{
        boolean b=dao.checkid(id);
        return b;
    }
    public boolean updateStudent(Student obj) throws Exception{
        boolean b=dao.updateStudent(obj);
        return b;
    }
    public boolean deleteStudent(int id) throws Exception{
        boolean b=dao.deleteStudent(id);
        return b;
    }
    public void listAllStudent() throws Exception{
        dao.listAllStudent();
    }
}
