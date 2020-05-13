package com.example.digitaludhaarkhata;

import com.google.firebase.database.IgnoreExtraProperties;



@IgnoreExtraProperties
public class user1 {

    public String name;
    public String Ph;
    public String Pass;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public user1() {
    }

    public user1(String name, String Ph,String Pass) {
        this.name = name;
        this.Ph= Ph;
        this.Pass = Pass;
    }
}
