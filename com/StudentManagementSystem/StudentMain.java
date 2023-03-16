package com.StudentManagementSystem;

import java.util.Scanner;
public class StudentMain {
    Student student, obj;
        public static void main(String[] args) throws Exception {
            StudentMain demo = new StudentMain();
            int choice;
            do {
                choice = demo.menu();
                demo.process(choice);
            } while (choice != 0);
        }
        public int menu() {
            System.out.println();
            System.out.println("------------MENU------------");
            System.out.println("1 : ADD STUDENT");
            System.out.println("2 : SEARCH STUDENT");
            System.out.println("3 : UPDATE STUDENT");
            System.out.println("4 : DELETE STUDENT");
            System.out.println("5 : SHOW LIST");
            System.out.println("0 : EXIT");
            System.out.println("-----------------------");
            System.out.println("PLEASE ENTER YOUR CHOICE:");
            Scanner in = new Scanner(System.in); // Create a Scanner object
            int input = in.nextInt();
            return input;
        }

        public void process(int choice) throws Exception {
            StudentService service = new StudentService();
            Scanner sc=new Scanner(System.in);
            switch (choice) {
                case 1:
                    System.out.println("ADD STUDENT");
                    System.out.println("ENTER NAME : ");
                    String name=sc.nextLine();
                    System.out.println("ENTER DEPARTMENT : ");
                    String depart=sc.nextLine();
                    System.out.println("ENTER Phone No. : ");
                    String phoneNo=sc.nextLine();
                    System.out.println("ENTER ADDRESS. : ");
                    String address=sc.nextLine();
                    student= new Student(name,depart,phoneNo,address);
                    boolean b=service.addStudent(student);
                    if(b)
                    {
                        System.out.println("Student Added Successfully...");
                    }
                    else
                    {
                        System.out.println("Something went wrong... TRY AGAIN...");
                    }
                    break;
                case 2:
                    System.out.println("ENTER ID TO FIND STUDENT");
                    int id1=sc.nextInt();
                    boolean b3=service.findStudent(id1);
                    if(b3)
                    {
                        System.out.println("Student found...");
                    }
                    else
                    {
                        System.out.println("Something went wrong...OR Student Not Found TRY AGAIN");
                    }
                    break;
                case 3:
                    System.out.println("FOR UPDATE");
                    System.out.println("ENTER ID YOU WANNA UPDATE : ");
                    int idup=sc.nextInt();
                    sc.nextLine();
                    boolean b6=service.checkid(idup);
                    if(b6){
                        System.out.println("ENTER NAME : ");
                        String name1=sc.nextLine();
                        System.out.println("ENTER DEPARTMENT : ");
                        String depart1=sc.nextLine();
                        System.out.println("ENTER Phone No. : ");
                        String phoneNo1=sc.nextLine();
                        System.out.println("ENTER ADDRESS. : ");
                        String address1=sc.nextLine();
                        obj= new Student(idup,name1,depart1,phoneNo1,address1);
                        boolean b4=service.updateStudent(obj);
                        if(b4)
                        {
                            System.out.println("Student Updated...");
                        }
                        else
                        {
                            System.out.println("Something went wrong...OR Student Not Found TRY AGAIN");
                        }
                    }
                    else{
                        System.out.println("Student Not in Database");
                    }
                    break;
                case 4:
                    System.out.println("Enter the Id of student you want to delete");
                    int id=sc.nextInt();
                    boolean b1=service.deleteStudent(id);
                    if(b1)
                    {
                        System.out.println("Student Deleted...");
                    }
                    else
                    {
                        System.out.println("Something went wrong...OR Student Not Found TRY AGAIN");
                    }
                    break;
                case 5:
                    System.out.println("LIST OF STUDENT");
                    service.listAllStudent();
                    break;
                case 0:
                    System.out.println("THANK YOU");
                    break;
                default:
                    System.out.println("WRONG INPUT");
                    break;
            }

        }


}
