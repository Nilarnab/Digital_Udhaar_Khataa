package com.example.digitaludhaarkhata;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.TextUtils;
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

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class AddCust extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_cust);


        ListView listView = findViewById(R.id.mobile_list1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                TextView textView1 = findViewById(R.id.editText2);
                textView1.setText(selectedItem);





                Toast.makeText(AddCust.this,"You are selecting " + selectedItem, Toast.LENGTH_SHORT).show();

                
            }
        });
    }

    public void submt(View view) {


        TextView textView = findViewById(R.id.editText);
        String Customer = textView.getText().toString();

        TextView textView1 = findViewById(R.id.editText2);
        String CustomerPh = textView1.getText().toString();

        if(TextUtils.isEmpty(Customer)) {
            textView.setError("Set a proper name");
            return;
        }
        if(TextUtils.isEmpty(CustomerPh) || CustomerPh.length() !=10 ) {
            textView1.setError("Set a proper phone No.");
            return;
        }


        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        String name = sharedPreferences1.getString("Nameu","Name not found");
        String phone = sharedPreferences1.getString("Phu","Number not found");
        user user = new user(Customer,CustomerPh);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mDatabase.child(name+phone).child("Customers").child(Customer).setValue(user);

        Toast.makeText(this,"Customer Added",Toast.LENGTH_LONG).show();

        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void getNumber(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Login", MODE_PRIVATE);
        String Stat = sharedPreferences.getString("Status","null");
        String name = sharedPreferences.getString("Name","Not Found");

        TextView textView = findViewById(R.id.editText);
        final String Customer = textView.getText().toString();


        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("users");
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ListView listView = findViewById(R.id.mobile_list1);
                final List<String> Mess = new ArrayList<String>();
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
                    user user1 = dataSnapshot1.getValue(user.class);

                    // assert user1 != null;
                    // Toast.makeText(MainActivity.this, "Entered loop", Toast.LENGTH_SHORT).show();

                    assert user1 != null;
                    if ( Customer.equals(user1.name)) {
                        Mess.add(user1.Ph);
                    }
                }
                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(AddCust.this, android.R.layout.simple_list_item_1, Mess);
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


    }

