package com.example.digitaludhaarkhata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");

    }

    public void add(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String nameu = sharedPreferences.getString("Nameu", "not found");

        Intent intent = getIntent();
        String name = intent.getStringExtra("Name");
        String Owe = sharedPreferences.getString(nameu+name+"owe","0");
        int owe = Integer.parseInt(Owe);

        TextView textView = findViewById(R.id.get);
        String Owes = textView.getText().toString();

        if(TextUtils.isEmpty(Owes) ) {
            textView.setError("Set a proper amount");
            return;
        }
        int owes = Integer.parseInt(Owes);
        owe = owe + owes;
        String newowe = String.valueOf(owe);

        editor.putString(nameu+name+"owe",newowe);
        editor.apply();
        Intent intent1 = new Intent(this,Transaction.class);
        intent1.putExtra("Name",name);
        startActivity(intent1);


    }
}
