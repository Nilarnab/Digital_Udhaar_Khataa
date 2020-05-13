package com.example.digitaludhaarkhata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        String Stat = sharedPreferences.getString("Status","null");
        final String name = sharedPreferences.getString("Nameu","Not Found");



        if (Stat.equals("YES")) {


            TextView textView = findViewById(R.id.textView2);
            textView.setText(name);

        }
        else{
            TextView textView = findViewById(R.id.textView2);
            textView.setText("You are logged out!");
        }


       ListView listView = findViewById(R.id.mobile_list);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent myIntent = new Intent(MainActivity.this,Transaction.class);
                myIntent.putExtra("Name", selectedItem);

                startActivity(myIntent);
                Toast.makeText(MainActivity.this,"Opening Transaction with " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

    }



    public void ShowCust(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        String Stat = sharedPreferences.getString("Status","null");
        String name = sharedPreferences.getString("Nameu","Not Found");
        String phone = sharedPreferences.getString("Phu","Not Found");

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mDatabase.child(name+phone).child("Customers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ListView listView = findViewById(R.id.mobile_list);
                final List<String> Mess = new ArrayList<String>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    user user1 = dataSnapshot1.getValue(user.class);
                    // assert user1 != null;
                    // Toast.makeText(MainActivity.this, "Entered loop", Toast.LENGTH_SHORT).show();

                 Mess.add(user1.name);
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, Mess);
                listView.setAdapter(arrayAdapter);
            }
            //Log.d(TAG, "User name: " + user.getName() + ", email " + user.getEmail());


            @Override
            public void onCancelled(@NonNull DatabaseError error) {


                // Failed to read value

            }
        });


        Toast.makeText(this,"Work complete",Toast.LENGTH_SHORT).show();


    }



    public void AddCust1(View view) {
        Intent intent = new Intent(this, AddCust.class);
        startActivity(intent);
    }

    public void logout(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("Status","NO");
        editor.putString("LangStat","NO");
        editor.apply();

        Intent intent = new Intent(this, Language.class);

        startActivity(intent);
    }
}
