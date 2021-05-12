package com.example.bankingsolutions;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
public class viewtransdetails extends AppCompatActivity {
    dbase mydb;
    TextView tr,cv1,cv2,cv3;
    ListView lv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewtransdetails);
        mydb=new dbase(this);
        tr = (TextView) findViewById(R.id.transa);
        cv1 = (TextView) findViewById(R.id.c1);
        cv2= (TextView) findViewById(R.id.c2);
        cv3= (TextView) findViewById(R.id.c3);
        lv2=(ListView)findViewById(R.id.vu2);
        Cursor r=mydb.viewtra();
        int c=0;
        while(r.moveToNext())
        {
            c++;
        }
        String tra[]=new String[c];
        Cursor r1=mydb.viewtra();
        int i=0;
        ArrayList<String> arrayList=new ArrayList<>();
        while (r1.moveToNext())
        {
            tra[i]=r1.getString(r1.getColumnIndex(dbase.Transactions_byaccholder));
            arrayList.add(tra[i]);
            i++;
        }
        final ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arrayList);
        lv2.setAdapter(arrayAdapter);
        lv2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clicked=(String)lv2.getItemAtPosition(position);
                mydb.viewtrandet(clicked);
                String tactno="",amt="",ttype="";
                Cursor r=mydb.viewtrandet(clicked);
                while (r.moveToNext()) {
                    tactno = r.getString(r.getColumnIndex(dbase.Transactions_toaccountnumber));
                    amt = r.getString(r.getColumnIndex(dbase.Transactions_Ammount));
                    ttype = r.getString(r.getColumnIndex(dbase.Transactions_transfertype));

                }
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(viewtransdetails.this);
                alertDialogBuilder.setTitle("VIEW TRANSFER DETAILS..!!!");
                alertDialogBuilder.setMessage("transferred to account number :"+tactno+"\n"+"amount transferred :"+amt+"\n"+"Transfer type :"+ttype);
                alertDialogBuilder.setCancelable(false);
                alertDialogBuilder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"You clicked on OK",Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
                cv1.setText(clicked+"\n"+"Transfer to account number :"+tactno);
                cv2.setText("amount transferred is-"+amt);
                cv3.setText("Transfer type is-"+ttype);

            }
        });
    }
}

