package UI;

import customer.CustomerListImpl;
import insurance.Insurance;
import insurance.InsuranceListImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.ServerException;
import java.util.ArrayList;

public class ISMain {
    public static void main(String[] args) throws NotBoundException, IOException {
        BufferedReader objectReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while(true) {
                printMenu();
                String sChoice = objectReader.readLine().trim();
                switch (sChoice) {
                    case "1":
                        registerCustomer(sChoice);
                        break;
                    case "2":
                        showList(server.getAllCourseData());
                        break;
                    case "3":
                        addStudent(server, objectReader);
                        break;
                    case "4":
                        deleteStudent(server, objectReader);
                        break;
                    case "5":
                        addCourse(server, objectReader);
                        break;
                    case "6":
                        deletCourse(server, objectReader);
                        break;
                    case "7":
                        reservation(server,objectReader);
                        break;
                    case "x":
                        return;
                    default:
                        System.out.println("Invaild choice !!!");
                }
            }
        }catch (RemoteException e) {e.printStackTrace();
        }
    }
    private static void registerCustomer(BufferedReader objectReader) throws IOException, RemoteException {
        CustomerListImpl customerList = new CustomerListImpl();

        System.out.println("---------Student Information");
        System.out.print("1. 회원 이름을 입력하세요 : "); String customerName = objectReader.readLine().trim();
        System.out.print("Student Name : "); String studentName = objectReader.readLine().trim();
        System.out.print("Student Department : "); String studentDept = objectReader.readLine().trim();
        System.out.print("Student Completed Course list : "); String completedCourses = objectReader.readLine().trim();

    }
    private static void designInsurance(BufferedReader objectReader) throws RemoteException, IOException {
        InsuranceListImpl insuranceList = new InsuranceListImpl();
        Insurance insurance = new Insurance();
        System.out.print("보험정보 입력하기");

    }
    private static void addCourse(ServerIF server, BufferedReader objectReader) throws IOException, RemoteException{
        System.out.println("---------Course Information");
        System.out.print("Course ID : "); String courseId = objectReader.readLine().trim();
        System.out.print("Professor Name : "); String professorName = objectReader.readLine().trim();
        System.out.print("Course Name : "); String courseName = objectReader.readLine().trim();
        System.out.print("Required Course : "); String requiredCourse = objectReader.readLine().trim();

        if(server.addCourse(courseId+" "+professorName+" "+courseName+" "+requiredCourse)) System.out.println("SUCESS");
        else System.out.println("FAIL");
    }
    private static void deletCourse(ServerIF server, BufferedReader objectReader) throws RemoteException, IOException {
        System.out.print("Course Id : ");
        if(server.deleteCourse(objectReader.readLine().trim())) System.out.println("SUCESS");
        else System.out.println("FAIL");
    }
    private static void reservation(ServerIF server, BufferedReader objectReader) throws RemoteException, IOException, NullDataException{
        System.out.print("Student ID : "); String studentId = objectReader.readLine().trim();
        System.out.print("Course ID : ");  String courseId = objectReader.readLine().trim();
        try {
            server.addReservation(studentId, courseId);
            System.out.println("SUCESS");
        }catch (ServerException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void printLoginMenu() {
        System.out.println("*********************MENU********************");
        System.out.println("1. Login");
        System.out.println("2. SignUp");
    }
    private static void printMenu() {
        System.out.println("*********************MENU********************");
        System.out.println("1. List Student");
        System.out.println("2. List Course");
        System.out.println("3. Add Student");
        System.out.println("4. Delete Student");
        System.out.println("5. Add Course");
        System.out.println("6. Delete Course");
        System.out.println("7. Reservation");
        System.out.println("X. Exit");
    }
    private static void showList(ArrayList<?> dataList) throws RemoteException {
        String list = "";
        for(int i=0; i<dataList.size(); i++) {
            list += dataList.get(i) + "\n";
        }
        System.out.println(list);
    }

}
