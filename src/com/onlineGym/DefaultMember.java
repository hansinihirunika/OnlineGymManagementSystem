package com.onlineGym;

public class DefaultMember {
    private int membershipNumber;
    private String membershipName;
    private int teleNo;
    private String address;



    public int getMembershipNumber() {
        return membershipNumber;
    }

    public void setMembershipNumber(int membershipNumber) {
        this.membershipNumber = membershipNumber;
    }

    public String getMembershipName() {
        return membershipName;
    }

    public void setMembershipName(String membershipName) {
        this.membershipName = membershipName;
    }

    public int getTeleNo() {
        return teleNo;
    }

    public void setTeleNo(int teleNo) {
        this.teleNo = teleNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "DefaultMember{" +
                "membershipNumber=" + membershipNumber +
                ", membershipName='" + membershipName + '\'' +
                ", teleNo=" + teleNo +
                ", address='" + address + '\'' +
                '}';
    }
}
