package com.example.cmgoe.hackpsu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by lap55 on 11/5/2017.
 */

public class ContractorProfileSetupActivity extends AppCompatActivity{
    private Button launchDashButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contractor_profile_setup);

        launchDashButton = (Button) findViewById(R.id.portfolio_nav_id);

        launchDashButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                getContractorDash();
            }
        });
    }

    public void getContractorDash(){
        Intent intent = new Intent();
        intent.setClass(this, ContractorDashboardActivity.class);
        startActivity(intent);
    }

}
