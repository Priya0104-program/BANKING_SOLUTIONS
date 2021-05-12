package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class adminmenu extends AppCompatActivity {
    Button viewus,viewtransdet,editinfo,adlogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminmenu);
        viewus=(Button)findViewById(R.id.vus);
        viewtransdet=(Button)findViewById(R.id.vtrde);
        editinfo=(Button)findViewById(R.id.ei);
        adlogout=(Button)findViewById(R.id.alo);
        viewus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(adminmenu.this,viewuser.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"View User",Toast.LENGTH_SHORT).show();

            }
        });

        viewtransdet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(adminmenu.this,viewtransdetails.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"View Transaction Details",Toast.LENGTH_SHORT).show();

            }
        });
        editinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(adminmenu.this,editinformation.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"Edit information",Toast.LENGTH_SHORT).show();

            }
        });
        adlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(adminmenu.this,adminlogout.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"Logout page",Toast.LENGTH_SHORT).show();

            }
        });
    }
}
