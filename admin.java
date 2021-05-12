package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class admin extends AppCompatActivity {
     Button back,go;
     EditText adnam,adpass;
     String name,pass;
     dbase mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mydb=new dbase(this);
        adnam=(EditText)findViewById(R.id.una);
        adpass=(EditText)findViewById(R.id.unp);
        setContentView(R.layout.activity_admin);
        back=(Button)findViewById(R.id.aback);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(admin.this,fpage.class);
                startActivity(in);
            }
        });
        go=(Button)findViewById(R.id.alog);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adnam=(EditText)findViewById(R.id.una);
                adpass=(EditText)findViewById(R.id.unp);
                String adpa="";
                name=adnam.getText().toString();
                pass=adpass.getText().toString();
                Cursor cursor=mydb.viewadpassword(name);
                while (cursor.moveToNext())
                {
                    adpa=cursor.getString(cursor.getColumnIndex(dbase.Admin_password));
                }
                if (name.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"please enter name",Toast.LENGTH_SHORT).show();
                }
                else if (pass.equals(""))
                {
                    Toast.makeText(getApplicationContext(),"please enter password",Toast.LENGTH_SHORT).show();

                }
                else if (adpa.equals(pass))
                {
                    Intent in=new Intent(admin.this,adminmenu.class);
                    startActivity(in);
                    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalid name or password",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
    public void onBackPressed()
    {
        Intent in=new Intent(admin.this,fpage.class);
        startActivity(in);
    }
}
