package com.example.digitaludhaarkhata;
import com.google.firebase.database.IgnoreExtraProperties;



@IgnoreExtraProperties
public class user {

    public String name;
    public String Ph;

    // Default constructor required for calls to
    // DataSnapshot.getValue(User.class)
    public user() {
    }

    public user(String name, String Ph) {
        this.name = name;
        this.Ph= Ph;
    }
}
