package com.example.digitaludhaarkhata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.IInterface;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        String stat = sharedPreferences.getString("Status","No");
        String name = sharedPreferences.getString("Name","Error");
        if (stat.equals("YES")){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Welcome back " + name, Toast.LENGTH_SHORT).show();
        }

    }

    public void log(View view) {
        TextView textView = findViewById(R.id.editText);
        TextView textView1 = findViewById(R.id.pass2);
        TextView pass = findViewById(R.id.password);
        String Pass = pass.getText().toString();
        String Name = textView.getText().toString();
        String Ph = textView1.getText().toString();
        user1 user1 = new user1(Name,Ph,Pass);

        if(TextUtils.isEmpty(Name)) {
            textView.setError("Set a proper name");
            return;
        }
        if(TextUtils.isEmpty(Ph) || Ph.length() !=10 ) {
            textView1.setError("Set a proper phone No.");
            return;
        }
        if(TextUtils.isEmpty(Pass) ) {
            pass.setError("Set a password");
            return;
        }


        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mDatabase.child(Name+Ph).setValue(user1);
        Intent intent = new Intent(this, MainActivity.class) ;
        //This is for now
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();

        editor.putString("Nameu",Name);
        editor.putString("Phu",Ph);
        editor.putString("Status","YES");
        editor.apply();

/*
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage(Ph, null, "Your Message Text", null, null);

 */
        startActivity(intent);


    }


    public void signup(View view) {
        Intent intent = new Intent(this,SignUp.class);
        startActivity(intent);
    }
}
