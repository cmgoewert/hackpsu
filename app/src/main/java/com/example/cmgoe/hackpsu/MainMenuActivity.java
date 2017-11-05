package com.example.cmgoe.hackpsu;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import Model.Company;
import Model.FirebaseDB;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        FirebaseDB database = new FirebaseDB();

        ArrayList<Company> companies = database.read();
        System.out.println(companies.get(0).getDescription());

        //database.createDummyData();

    }

}
