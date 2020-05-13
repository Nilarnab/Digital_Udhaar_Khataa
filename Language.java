package com.example.digitaludhaarkhata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Toast;

import java.util.Locale;

public class Language extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        SharedPreferences sharedPreferences = getSharedPreferences("Login",MODE_PRIVATE);
        String stat = sharedPreferences.getString("LangStat","NO");
        String lang = sharedPreferences.getString("Lang","en");
        if ( stat.equals("YES")){
            Locale myLocale = new Locale(lang);
            Resources res = getResources();
            DisplayMetrics dm = res.getDisplayMetrics();
            Configuration conf = res.getConfiguration();
            conf.locale = myLocale;
            res.updateConfiguration(conf, dm);
            Intent refresh = new Intent(this, login.class);
            finish();

            Toast.makeText(this, "Language chosen as "+ lang, Toast.LENGTH_SHORT).show();
            startActivity(refresh);




        }


    }

    public void Hindi(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","hi");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("hi");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);

    }


    public void bangla(View view) {

        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","bl");
        editor.putString("LangStat","YES");
        editor.apply();

        Locale myLocale = new Locale("bl");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this,login.class);
        finish();
        startActivity(refresh);
    }

    public void gujrati(View view) {

        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","gj");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("gj");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);
    }

    public void kannd(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","kd");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("kd");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);

    }

    public void malayam(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","ml");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("ml");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);

    }

    public void marathi(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","mr");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("mr");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);
    }

    public void nepali(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","np");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("np");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);
    }

    public void Odia(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","od");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("od");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);

    }

    public void eng(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","en");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("en");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this,login.class);
        finish();
        startActivity(refresh);

    }

    public void punjabi(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","pj");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("pj");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this,login.class);
        finish();
        startActivity(refresh);

    }

    public void tamil(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","tl");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("tl");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);
    }

    public void telegu(View view) {

        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","tg");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("tg");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);
    }

    public void urdu(View view) {
        SharedPreferences sharedPreferences1 = getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences1.edit();
        editor.putString("Lang","ur");
        editor.putString("LangStat","YES");
        editor.apply();
        Locale myLocale = new Locale("ur");
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, login.class);
        finish();
        startActivity(refresh);

    }
}
