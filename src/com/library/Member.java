package com.library;

public class Member {
    private String name;
    private int memberID;

    public Member(String name, int memberID){
        this.name = name;
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberID() {
        return memberID;
    }

    public void setMemberID(int memberID) {
        this.memberID = memberID;
    }

    @Override
    public String toString() {
        return "MemberID: " + memberID +
                "\nName: " + name;
    }
}



