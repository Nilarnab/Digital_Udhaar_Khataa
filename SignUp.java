package com.example.digitaludhaarkhata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void access(View view) {

        TextView textView = findViewById(R.id.editText20);
        TextView textView1 = findViewById(R.id.pass2);
        TextView pass = findViewById(R.id.password20);
        final String Pass = pass.getText().toString();
        final String Name = textView.getText().toString();
        final String Ph = textView1.getText().toString();

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
        mDatabase.addValueEventListener(new ValueEventListener() {
            int flag = 0;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    user1 user1 = dataSnapshot1.getValue(user1.class);

                    // assert user1 != null;
                    // Toast.makeText(MainActivity.this, "Entered loop", Toast.LENGTH_SHORT).show();

                    assert user1 != null;
                    if ( Name.equals(user1.name)) {
                        if ( Ph.equals(user1.Ph)  && Pass.equals(user1.Pass)) {
                            Intent intent = new Intent(SignUp.this,MainActivity.class);
                            startActivity(intent);

                            SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
                            SharedPreferences.Editor editor=sharedPreferences1.edit();

                            editor.putString("Nameu",Name);
                            editor.putString("Phu",Ph);
                            editor.putString("Status","YES");
                            editor.apply();
                            Toast.makeText(SignUp.this, "Welcome "+Name, Toast.LENGTH_SHORT).show();
                            flag = 1;
                        }
                    }
                }
                if ( flag == 0){
                    Toast.makeText(SignUp.this, "ACCESS DENIED!", Toast.LENGTH_SHORT).show();
                }

            }
            //Log.d(TAG, "User name: " + user.getName() + ", email " + user.getEmail());


            @Override
            public void onCancelled(@NonNull DatabaseError error) {


                // Failed to read value

            }
        });



    }
}
