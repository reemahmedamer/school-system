/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project_dlinkedlist;

import java.util.Scanner;

/**
 *
 * @author Reem
 */
public class Project_DLinkedList {

    public static String data() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Student Name");
        String name = sc.next();
        System.out.println("Enter Student ID");
        int id = sc.nextInt();
        System.out.println("Enter Student GPA");
        double gpa = sc.nextDouble();

        return (name + "\n" + id + "\n" + gpa);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DoubleLinkedList list = new DoubleLinkedList();

        System.out.println("------------------------------");
        System.out.println("-----------Welcome------------");

        boolean t = true;
        while (t) {
            System.out.println("------------------------------");
            System.out.println("--------Choose Operation------");
            System.out.println("1) Add Student ");
            System.out.println("2) Insert Student At Certain Location ");
            System.out.println("3) update Student Data ");
            System.out.println("4) Delete Student Data ");
            System.out.println("5) Count Number Of Students ");
            System.out.println("6) search For student by ID ");
            System.out.println("7) Display All Students ");
            System.out.println("8) Delete All Students ");
            System.out.println("0) [EXIT]");

            int f = sc.nextInt();
            System.out.println("------------------------------");
            switch (f) {
                case 1:
                    String addData = data();
                    list.AddStudent(addData);
                    break;
                case 2:
                    String insertData = data();
                    System.out.println("Enter Location");
                    int loc = sc.nextInt() - 1;
                    list.InsertStudent(insertData, loc);
                    break;
                case 3:
                    //System.out.println("Enter Old data");
                    //String oldData = data();
                    System.out.println("Enter Old Student ID");
                    String oldData = list.SearchStudent(sc.next()).Data;
                    System.out.println("Enter New data");
                    String newData = data();
                    list.UpdateData(oldData, newData);
                    break;
                case 4:
                    System.out.println("Enter Location of Required Student to Delete");
                    int deleteLoc = sc.nextInt() - 1;
                    boolean delete = list.DeleteStudent(deleteLoc);
                    if (delete) {
                        System.out.println("student Deleted successfully");
                    } else {
                    }
                    break;
                case 5:
                    list.countStudents();
                    break;
                case 6:
                    System.out.println("Enter Student ID");
                    String id = sc.next();
                    Node1 student = list.SearchStudent(id);
                    System.out.println(student.Data);
                    break;
                case 7:
                    list.showData();
                    break;
                case 8:
                    list.DeleteAllNodes();
                    break;

                case 0:
                    t = false;
            }
        }
    }

}
