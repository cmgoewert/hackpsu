package com.example.cmgoe.hackpsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lap55 on 11/4/2017.
 */

public class ContractorSkillsActivity extends AppCompatActivity {

    private Button launchProfileButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contractor_profile_skills);

        launchProfileButton = (Button) findViewById(R.id.profile_setup_button);

        launchProfileButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getProfileSetup();
            }
        });
    }

    public void getProfileSetup(){
        Intent intent = new Intent();
        intent.setClass(this, ContractorProfileSetupActivity.class);
        startActivity(intent);
    }
}
