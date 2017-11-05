package com.example.cmgoe.hackpsu;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import Model.Company;
import Model.FirebaseDB;

public class CompanyEditProfile extends AppCompatActivity implements View.OnClickListener{
    private EditText companyName;
    private EditText companyDesc;
    private Button saveButton;
    private FirebaseDB db;
    private ArrayList<Company> companies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company_edit_profile);
        db = new FirebaseDB();

        companies = db.getCompanies();


        companyName = (EditText)findViewById(R.id.editText5);
        companyName.setText(companies.get(0).getName());

        companyDesc = (EditText)findViewById(R.id.editText4);
        companyDesc.setText(companies.get(0).getDescription());

        saveButton = (Button)findViewById(R.id.save_button);
        saveButton.setOnClickListener(this);

        getSupportActionBar().setTitle("Edit Company Profile");

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.save_button) {
            companies.get(0).setDescription(companyDesc.getText().toString());
            AsyncTask.execute(new Runnable() {
                @Override
                public void run() {
                    ArrayList<String> concepts = WatsonInteraction.send(companies.get(0).getDescription());
                    System.out.println(concepts.toString());
                    updateConcepts(concepts);
                }
            });

        }
    }

    public void updateConcepts(ArrayList<String> concepts){
        companies.get(0).setTags(concepts);
        db.write(companies);

        Intent intent = new Intent();
        intent.setClass(this, MainMenuActivity.class);
        intent.putExtra("toast",true);
        startActivity(intent);
    }
}
