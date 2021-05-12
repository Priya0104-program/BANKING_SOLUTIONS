package com.example.bankingsolutions;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ListView;
import android.content.DialogInterface;
import android.widget.TextView;

import java.util.ArrayList;

public class viewuser extends AppCompatActivity {
    dbase mydb;
    TextView vus,tv1,tv2;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewuser);
        mydb=new dbase(this);
        vus = (TextView) findViewById(R.id.vur);
        tv1 = (TextView) findViewById(R.id.v1);
        tv2= (TextView) findViewById(R.id.v2);
        lv=(ListView)findViewById(R.id.vu);
        Cursor r=mydb.viewus();
        int c=0;
        while(r.moveToNext())
        {
            c++;
        }
        String user[]=new String[c];
        Cursor r1=mydb.viewus();
        int i=0;
        ArrayList<String> arrayList=new ArrayList<>();
        while (r1.moveToNext())
        {
            user[i]=r1.getString(r1.getColumnIndex(dbase.REGISTER_COLUMN_FULLNAME));
            arrayList.add(user[i]);
            i++;
        }
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clicked=(String)lv.getItemAtPosition(position);
                mydb.viewphone(clicked);
                String actno="",ph="";
                Cursor r=mydb.viewuserdet(clicked);
                while (r.moveToNext())
                {
                    actno=r.getString(r.getColumnIndex(dbase.REGISTER_COLUMN_ACCOUNT_ID));
                    ph=r.getString(r.getColumnIndex(dbase.REGISTER_COLUMN_PHONE_NO));

                }
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(viewuser.this);
                alertDialogBuilder.setTitle("VIEW USER DETAILS..!!!");
                alertDialogBuilder.setMessage("Phone number ="+ph+"\n"+"Account number ="+actno);
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You clicked on OK",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                tv1.setText("account number of "+clicked+" is-"+actno);
                tv2.setText("phone number of "+clicked+"  is-"+ph);
            }
        });
    }
}