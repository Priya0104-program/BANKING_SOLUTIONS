package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class adminlogout extends AppCompatActivity {
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogout);
        logout=(Button)findViewById(R.id.lo);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(adminlogout.this,fpage.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"logout page",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
