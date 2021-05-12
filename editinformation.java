package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class editinformation extends AppCompatActivity {
    TextView heading;
    EditText ty;
    Button in;
    dbase db;
    String hn="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinformation);
        heading=(TextView)findViewById(R.id.headinn);
        ty=(EditText)findViewById(R.id.ba);
        in=(Button)findViewById(R.id.ee);
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        hn= prefs.getString(Name, null);
        db=new dbase(this);
        in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String d=ty.getText().toString();
                db.insertbalance(d);
                Toast.makeText(getApplicationContext(),"Balance inserted ",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
