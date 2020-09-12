package com.onlineGym;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public interface GymManager {

    void AddStudentMember(StudentMember member);
    void AddOver60Member(Over60Member member);
    void AddDefaultMember(DefaultMember member);
    void deleteMember(int MembershipNo);
    void DeleteStudentMember(int MembershipNO);
    void DeleteOver60Member(int MembershipNO);
    ArrayList<DefaultMember> ShowAllMember()throws SQLException;
    public ResultSet sort();
    public void SaveMember(ResultSet data);

}
