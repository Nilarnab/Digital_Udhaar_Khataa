package com.example.digitaludhaarkhata;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Transaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        Intent intent = getIntent();
        TextView textView = findViewById(R.id.name);
        String name = intent.getStringExtra("Name");

        textView.setText(name);

        //action bar
        //ActionSupportBar.setDisplayHomeAsUpEnabled(true);




        SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
        String nameu = sharedPreferences.getString("Nameu", "not found");
        TextView textView1 = findViewById(R.id.owe);
        textView1.setText(sharedPreferences.getString(nameu+name+"owe","0"));

        TextView textView2 = findViewById(R.id.crdt);
        textView2.setText(sharedPreferences.getString(nameu+name+"crdt","0"));

        int owe = Integer.parseInt(sharedPreferences.getString(nameu+name+"owe","0"));
        int owed = Integer.parseInt(sharedPreferences.getString(nameu+name+"crdt","0"));
        int net = owe - owed;

        TextView textView3 = findViewById(R.id.net);
        TextView textView4 = findViewById(R.id.stat);

        if ( owe> owed){

            textView4.setText("You owe");
            String Net = String.valueOf(net);
            textView3.setText(Net);
        }
        else{

            textView4.setText("balance(owed)");
            net = net * (-1);
            String Net = String.valueOf(net);
            textView3.setText(Net);


        }




    }

    public void pay(View view) {
        Intent intent1 = new Intent(this, Payment.class);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        intent1.putExtra("Name",name);
        startActivity(intent1);
    }

    public void credit(View view) {
        Intent intent1 = new Intent(this, Credit.class);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        intent1.putExtra("Name",name);
        startActivity(intent1);
    }

}
