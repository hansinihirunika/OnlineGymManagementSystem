package com.onlineGym;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement = null;
    String connectionString = "jdbc:mysql://localhost/gym_management";
    String username = "root";
    String password = "";
    String query;

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionString, username, password);
            System.out.println("[DATABASE] - Connected!");
            this.statement = connection.createStatement();
        } catch (SQLException ex) {
            System.out.println("[DATABASE] - Error in Connecting\n" + ex);
        } catch (ClassNotFoundException ex) {
            System.out.println("[DATABASE] - Error in Connecting\n" + ex);
        } catch (Exception ex) {
            System.out.println("[DATABASE] - Error in Connecting\n" + ex);
        }
    }

    //adding default members to database

    public void AddDefaultMember(DefaultMember member) {
        PreparedStatement prestatement = null;
        try {
            prestatement = connection.prepareStatement("insert into default_member values(?,?,?,?)");
            prestatement.setInt(1, member.getMembershipNumber());
            prestatement.setString(2, member.getMembershipName());
            prestatement.setInt(3, member.getTeleNo());
            prestatement.setString(4, member.getAddress());
            prestatement.execute();
            System.out.println("[DATABASE] -Successfully added member");
        } catch (Exception ex) {
            System.out.println("[DATABASE] - ERROR");
            ex.printStackTrace();
        }
    }

    //adding student members to database

    public void AddStudentMember(StudentMember member) {
        PreparedStatement prestatement = null;
        try {
            prestatement = connection.prepareStatement("insert into student_member1 values(?,?,?,?,?,?)");
            prestatement.setInt(1, member.getMembershipNumber());
            prestatement.setString(2, member.getMembershipName());
            prestatement.setInt(3, member.getTeleNo());
            prestatement.setString(4, member.getAddress());
            prestatement.setString(5, member.getSchoolName());
            prestatement.setInt(6, member.getGrade());
            prestatement.execute();
            System.out.println("[DATABASE] -Successfully added member");
        } catch (Exception ex) {
            System.out.println("[DATABASE] - ERROR");
            ex.printStackTrace();
        }
    }

    //adding over 60 members to database

    public void AddOver60Member(Over60Member member) {
        PreparedStatement prestatement = null;
        try {
            prestatement = connection.prepareStatement("insert into over60_member values(?,?,?,?,?,?)");
            prestatement.setInt(1, member.getMembershipNumber());
            prestatement.setString(2, member.getMembershipName());
            prestatement.setInt(3, member.getTeleNo());
            prestatement.setString(4, member.getAddress());
            prestatement.setInt(5, member.getAge());
            prestatement.setString(6, member.getLongTermDisease());
            prestatement.execute();
            System.out.println("[DATABASE] -Successfully added member");
        } catch (Exception ex) {
            System.out.println("[DATABASE] - ERROR");
            ex.printStackTrace();
        }
    }

    //delete default member from database


    public void deleteMember(int membershipNo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("delete from default_member where membership_number =?");
            preparedStatement.setInt(1, membershipNo);
            preparedStatement.execute();
            System.out.println("[DATABASE] -Successfully Deleted member");

        } catch (Exception ex) {
            System.out.println("[DATABASE] -Member is Not FOUND");
            ex.printStackTrace();
        }
    }

    //delete student member from database

    public void DeleteStudentMember(int membershipNo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("delete from student_member1 where membership_number =?");
            preparedStatement.setInt(1, membershipNo);
            preparedStatement.execute();
            System.out.println("[DATABASE] -Successfully Deleted member");

        } catch (Exception ex) {
            System.out.println("[DATABASE] -Member is Not FOUND");
            ex.printStackTrace();
        }
    }

    //delete over 60 member from database

    public void DeleteOver60Member(int membershipNo) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement("delete from over60_member where membership_number =?");
            preparedStatement.setInt(1, membershipNo);
            preparedStatement.execute();
            System.out.println("[DATABASE] -Successfully Deleted member");

        } catch (Exception ex) {
            System.out.println("[DATABASE] -Member is Not FOUND");
            ex.printStackTrace();
        }
    }

    //show member from database

    public ArrayList<DefaultMember> ShowAllMember(){
        ArrayList<DefaultMember> defaultMembers = new ArrayList<>();

        try {

            query = "SELECT * " + "FROM default_member";
            resultSet = statement.executeQuery(query);

            query = "SELECT * " + "FROM student_member1";
            resultSet = statement.executeQuery(query);





            while(resultSet.next()) {
                DefaultMember defaultMember = new DefaultMember();

                defaultMember.setMembershipNumber(resultSet.getInt("membership_number"));
                defaultMember.setMembershipName(resultSet.getString("membership_name"));
                defaultMember.setTeleNo(resultSet.getInt("tele_no"));
                defaultMember.setAddress(resultSet.getString("address"));
                defaultMembers.add(defaultMember);

                StudentMember studentMember=new StudentMember();

                studentMember.setMembershipNumber(resultSet.getInt("membership_number"));
                studentMember.setMembershipName(resultSet.getString("membership_name"));
                studentMember.setTeleNo(resultSet.getInt("tele_no"));
                studentMember.setAddress(resultSet.getString("address"));
                studentMember.setSchoolName(resultSet.getString("school_name"));
                studentMember.setGrade(resultSet.getInt("grade"));
            }



        }catch (Exception ex){
            System.out.println(ex);
        }
        return defaultMembers;
    }

}

