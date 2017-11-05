package com.example.cmgoe.hackpsu;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        FirebaseDB database = new FirebaseDB();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> concepts = WatsonInteraction.send("random descrption");
                System.out.println(concepts.toString());
            }
        });

        ArrayList<Company> companies = database.read();
        System.out.println(companies.get(0).getDescription());

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
        actualTagsLabel.setText("3D Printing, Sample tags, Hacking!");

        mListView = (ListView) findViewById(R.id.tasks_list_view);
        TaskListAdapter adapter = new TaskListAdapter(this, companies.get(0).getTasks());
        mListView.setAdapter(adapter);
        //mListView.setOnItemClickListener(this);

        findViewById(R.id.edit_profile).setOnClickListener(this);

        //database.createDummyData();

    }

    @Override
    public void onClick(View v) {
        int i = v.getId();
        if (i == R.id.edit_profile) {

        }
    }

}
