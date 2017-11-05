package com.example.cmgoe.hackpsu;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import Model.Company;
import Model.FirebaseDB;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener{
    private Toolbar mActionBarToolbar;
    private TextView infoLabel, titleLabel, descLabel,tagsLabel,actualTagsLabel;
    private ListView mListView;
    private ArrayList<Company> companies;
    private FirebaseDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        db = new FirebaseDB();
        companies = db.getCompanies();

        mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mActionBarToolbar);
        getSupportActionBar().setTitle("Welcome back "+companies.get(0).getContact() + "!");
        RelativeLayout rl = (RelativeLayout)findViewById(R.id.profile_layout);
        //rl.setBackgroundColor(Color.LTGRAY);

        titleLabel = (TextView)findViewById(R.id.business_title);
        titleLabel.setText(companies.get(0).getName());

        descLabel = (TextView)findViewById(R.id.business_description);
        descLabel.setText(companies.get(0).getDescription());

        actualTagsLabel = (TextView)findViewById(R.id.business_tags);
        if(companies.get(0).getTags() == null){
            actualTagsLabel.setText("3D Printing, Sample tags, Hacking!");
        } else {
            actualTagsLabel.setText(companies.get(0).getTags().toString());
        }


        mListView = (ListView) findViewById(R.id.tasks_list_view);
        TaskListAdapter adapter = new TaskListAdapter(this, companies.get(0).getTasks());
        mListView.setAdapter(adapter);
        //mListView.setOnItemClickListener(this);

        findViewById(R.id.edit_profile).setOnClickListener(this);

       boolean toast = getIntent().getBooleanExtra("toast", false);
        if(toast){

        }

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.edit_profile) {
            Intent intent = new Intent();
            intent.setClass(this, CompanyEditProfile.class);
            startActivity(intent);
        }
    }

    public void updateConcepts(ArrayList<String> concepts){
        companies.get(0).setTags(concepts);
        db.write(companies);
    }
}
