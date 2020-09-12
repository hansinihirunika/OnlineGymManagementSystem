package com.onlineGym;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GymApplication {


    public static MyGymManager myGymManager;
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {

        myGymManager = new MyGymManager();
        while (true) {
            printMenu();
        }
    }

    public static void printMenu() {

        System.out.println("----GYM----");
        System.out.println("1. ADD member");
        System.out.println("2. SHOW All members");
        System.out.println("3. REMOVE member");
        System.out.println("4. SAVE member");
        System.out.println("0. EXIT");
        String choice = scanner.next();

        chooseMethod(Integer.parseInt(choice));

    }

    public static void chooseMethod(int choice) {

        switch (choice) {
            case 0:
                System.exit(0);
                break;
            case 1:

                AddMember();
                break;
            case 2:
                ShowAllMember();
                break;
            case 3:
                deleteMember();
                break;
            case 4:
                SaveMember();
                break;
            default:
                throw new AssertionError();
        }
    }

    //Add method

    public static void AddMember() {
        System.out.println("Add the Member Type");
        System.out.println("1.Student Member");
        System.out.println("2.Over 60 Member");
        System.out.println("3. Default Member");
        int type = Integer.parseInt(scanner.next());

        System.out.println("Enter Membership Number: ");
        int membershipNumber = scanner.nextInt();
        System.out.println("Enter Member Name: ");
        String membershipName = scanner.next();
        System.out.println("Enter Tele No: ");
        int teleNo = scanner.nextInt();
        System.out.println("Enter Address: ");
        String address = scanner.next();

        if (type == 1) {
            System.out.println("Enter School Name: ");
            String schoolName = scanner.next();

            System.out.println("Enter Grade: ");
            int grade = scanner.nextInt();

            StudentMember Student = new StudentMember();
            Student.setMembershipNumber(membershipNumber);
            Student.setMembershipName(membershipName);
            Student.setTeleNo(teleNo);
            Student.setAddress(address);
            Student.setSchoolName(schoolName);
            Student.setGrade(grade);

            myGymManager.AddStudentMember(Student);

            System.out.println("Added");


        } else if (type == 2) {
            System.out.println("Enter The Age: ");
            int age = scanner.nextInt();
            System.out.println("Enter the Long Term Desease: ");
            String longTermDisease = scanner.next();

            Over60Member Over60 = new Over60Member();
            Over60.setMembershipNumber(membershipNumber);
            Over60.setMembershipName(membershipName);
            Over60.setTeleNo(teleNo);
            Over60.setAddress(address);
            Over60.setAge(age);
            Over60.setLongTermDisease(longTermDisease);

            myGymManager.AddOver60Member(Over60);


        } else if (type == 3) {
            DefaultMember def = new DefaultMember();
            def.setMembershipNumber(membershipNumber);
            def.setMembershipName(membershipName);
            def.setTeleNo(teleNo);
            def.setAddress(address);

            myGymManager.AddDefaultMember(def);

        } else {
            System.out.println("Invalid Input!!!");
        }
    }

    //delete method

    public static void deleteMember() {

        System.out.println("Enter Membership Number: ");
        int membershipNumber = scanner.nextInt();
        myGymManager.deleteMember(membershipNumber);

        myGymManager.DeleteStudentMember(membershipNumber);

        myGymManager.DeleteOver60Member(membershipNumber);

        System.out.println("Deleted");
    }

    //Show method


    public static void ShowAllMember() {

        ArrayList<DefaultMember> defaultMembers = myGymManager.ShowAllMember();
        for (DefaultMember member : defaultMembers) {
            System.out.println("ID: " + member.getMembershipNumber() + ", Name: " + member.getMembershipName() +", Tel: " + member.getTeleNo() +", Address: " + member.getAddress());

        }

    }

    //Save method

    public static void SaveMember() {
        ArrayList<DefaultMember> defaultMembers= myGymManager.ShowAllMember();
        ArrayList<DefaultMember> studentMembers= myGymManager.ShowAllMember();

        String fileDir = "E:\\Intelij-files\\Online Gym Management System\\members.txt";
        try {
            File file = new File(fileDir);

            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);

            for(DefaultMember member : defaultMembers){
               bw.write("ID: " + member.getMembershipNumber() + ", Name: " + member.getMembershipName() +", Tel: " + member.getTeleNo() +", Address: " + member.getAddress());
               bw.newLine();
            }

            for(DefaultMember member : studentMembers){
                bw.write("ID: " + member.getMembershipNumber() + ", Name: " + member.getMembershipName() +", Tel: " + member.getTeleNo() +", Address: " + member.getAddress());
                bw.newLine();
            }

            bw.flush();
            bw.close();


        }catch (Exception ex){
            ex.printStackTrace();
        }

        System.out.println("Saved !!!");

    }


}




