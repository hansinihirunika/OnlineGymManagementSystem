package com.onlineGym;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyGymManager implements GymManager {

    ArrayList<DefaultMember> defaultMembers=new ArrayList<>();

    private Database database;

    MyGymManager(){
        this.database=new Database();
    }


    @Override
    public void AddStudentMember(StudentMember member) {
        database.AddStudentMember(member);

    }

    @Override
    public void AddOver60Member(Over60Member member) {
        database.AddOver60Member(member);


    }

    @Override
    public void AddDefaultMember(DefaultMember member) {
        database.AddDefaultMember(member);
    }

    @Override
    public void deleteMember(int MembershipNo) {
        this.database.deleteMember(MembershipNo);
    }

    @Override
    public void DeleteStudentMember(int MembershipNO) {
        this.database.DeleteStudentMember(MembershipNO);
    }

    @Override
    public void DeleteOver60Member(int MembershipNO) {
        this.database.DeleteOver60Member(MembershipNO);
    }


    @Override
    public ArrayList<DefaultMember> ShowAllMember(){
        return database.ShowAllMember();
    }


    @Override
    public ResultSet sort() {
        return null;
    }

    @Override
    public void SaveMember(ResultSet data) {

    }


}


