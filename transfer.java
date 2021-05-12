package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;

import java.util.HashMap;

public class transfer extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextView acc1,dm1,dm2,tranto,amt;
    Button trans,g1,g2,g3,g4,g5,g6,g7,g8,g9,g0,j1,j2,j3,j4,j5,j6,j7,j8,j9,j0,tr1,dd;
    String pr="",pm="";
    private TextToSpeech tts;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String balance = "balanceKey";
    public static final String accountnum = "numberKey";
    SharedPreferences sharedpreferences;
    String ak="";
     int f=0;
    dbase pp;
    String hname="",accno="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        pp=new dbase(this);
        acc1=(TextView)findViewById(R.id.taccn);
        amt=(TextView)findViewById(R.id.am);
        dd=(Button)findViewById(R.id.didp);
        tranto=(TextView)findViewById(R.id.tto);
        dm1=(TextView)findViewById(R.id.hel);
        dm2=(TextView)findViewById(R.id.helpe);
        g0=(Button)findViewById(R.id.k0);
        g1=(Button)findViewById(R.id.k1);
        g2=(Button)findViewById(R.id.k2);
        g3=(Button)findViewById(R.id.k3);
        g4=(Button)findViewById(R.id.k4);
        g5=(Button)findViewById(R.id.k5);
        g6=(Button)findViewById(R.id.k6);
        g7=(Button)findViewById(R.id.k7);
        g8=(Button)findViewById(R.id.k8);
        g9=(Button)findViewById(R.id.k9);
        j0=(Button)findViewById(R.id.f0);
        j1=(Button)findViewById(R.id.f1);
        j2=(Button)findViewById(R.id.f2);
        j3=(Button)findViewById(R.id.f3);
        j4=(Button)findViewById(R.id.f4);
        j5=(Button)findViewById(R.id.f5);
        j6=(Button)findViewById(R.id.f6);
        j7=(Button)findViewById(R.id.f7);
        j8=(Button)findViewById(R.id.f8);
        j9=(Button)findViewById(R.id.f9);
        tr1=(Button)findViewById(R.id.tran1);
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        hname = prefs.getString(Name, null);
        accno=prefs.getString(accountnum,null);

        Cursor ra=pp.viewbal();
        while (ra.moveToNext()){
            ak=ra.getString(ra.getColumnIndex(dbase.Balance_userBalance));
        }
        trans=(Button)findViewById(R.id.tfer);
        g0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="0";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr+ "0";
                dm1.setText(pr);
            }
        });

        g1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 1";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "1";
                dm1.setText(pr);

            }
        });
        g2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 2";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "2";
                dm1.setText(pr);

            }
        });
        acc1.setMovementMethod(LinkMovementMethod.getInstance());
        acc1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER ACCOUNT NUMBER HERE";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });

        g3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 3";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "3";
                dm1.setText(pr);

            }
        });
        g4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 4";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "4";
                dm1.setText(pr);

            }
        });
        g5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 5";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "5";
                dm1.setText(pr);

            }
        });
        g6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="6";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "6";
                dm1.setText(pr);

            }
        });
        g7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="7";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "7";
                dm1.setText(pr);

            }
        });
        g8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="8";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "8";
                dm1.setText(pr);

            }
        });
        g9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="9";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pr = pr + "9";
                dm1.setText(pr);

            }
        });
        j0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="0";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "0";
                dm2.setText(pm);

            }
        });
        j1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="1";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "1";
                dm2.setText(pm);

            }
        });
        j2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="2";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "2";
                dm2.setText(pm);

            }
        });
        j3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="3";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "3";
                dm2.setText(pm);

            }
        });
        j4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="4";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "4";
                dm2.setText(pm);

            }
        });
        j5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="5";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "5";
                dm2.setText(pm);

            }
        });
        j6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="6";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "6";
                dm2.setText(pm);

            }
        });
        amt.setMovementMethod(LinkMovementMethod.getInstance());
        amt.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER AMOUNT  HERE";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        j7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="7";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "7";
                dm2.setText(pm);

            }
        });
        j8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="8";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "8";
                dm2.setText(pm);

            }
        });
        j9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="9";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                pm= pm+ "9";
                dm2.setText(pm);

            }
        });
        trans.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="THIS IS A TRANSFER  PAGE    YOU CAN TRANSFER MONEY TO A BANK ACCOUNT OR TRANSFER FROM A BANK ACCOUNT";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);


            }
        });
        tr1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String  a=dm1.getText().toString();
                String k=dm2.getText().toString();
                int fa=Integer.parseInt(k);
                if (a.equals(""))
                {
                    String st="please enter account number";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(),"enter account number",Toast.LENGTH_SHORT).show();
                }
                else if (a.length()!=10)
                {
                    String st="please enter valid account number";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(),"enter valid account number",Toast.LENGTH_SHORT).show();
                }
                else if (k.equals(""))
                {
                    String st="please fill amount";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(),"please fill the amount",Toast.LENGTH_SHORT).show();
                }
                else if (k.length()>ak.length())
                {
                    String st="amount entered exceeds the limit";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(),"amount entered exceeds the limit",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    String am="";
                    Cursor ra=pp.viewbal();
                    while (ra.moveToNext()){
                        am=ra.getString(ra.getColumnIndex(dbase.Balance_userBalance));
                    }
                    int oo=Integer.parseInt(am);
                    int gg=oo-fa;
                    String to= Integer.toString(gg);
                    SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();
                    editor.putString(balance, to);
                    editor.apply();
                    String st="TRANSFERRED";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    String ty="TRANSFER";
                    pp.inserttrans(hname,accno,a,ty,k);
                    Toast.makeText(getApplicationContext(),"transferred ",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tranto.setMovementMethod(LinkMovementMethod.getInstance());
        tranto.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="TRANSFER TO BANK ACCOUNT";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });


      dd.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String  a=dm1.getText().toString();
              String k=dm2.getText().toString();
              int fa=Integer.parseInt(k);
              if (a.equals(""))
              {
                  String st="please enter account number";
                  tts.setSpeechRate(1.0f);
                  tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                  Toast.makeText(getApplicationContext(),"enter account number",Toast.LENGTH_SHORT).show();
              }
              else if (a.length()!=10)
              {
                  String st="please enter valid account number";
                  tts.setSpeechRate(1.0f);
                  tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                  Toast.makeText(getApplicationContext(),"enter valid account number",Toast.LENGTH_SHORT).show();
              }
              else if (k.equals(""))
              {
                  String st="please fill amount";
                  tts.setSpeechRate(1.0f);
                  tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                  Toast.makeText(getApplicationContext(),"please fill the amount",Toast.LENGTH_SHORT).show();
              }
              else if (k.length()>ak.length())
              {
                  String st="amount entered exceeds the limit";
                  tts.setSpeechRate(1.0f);
                  tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                  Toast.makeText(getApplicationContext(),"amount entered exceeds the limit",Toast.LENGTH_SHORT).show();
              }

              else {
                  String am="";
                  Cursor ra=pp.viewbal();
                  while (ra.moveToNext()){
                      am=ra.getString(ra.getColumnIndex(dbase.Balance_userBalance));
                  }
                  int oo=Integer.parseInt(am);
                  int gg=oo-fa;
                  String trt= Integer.toString(gg);
                  SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();
                  editor.putString(balance, trt);
                  editor.apply();
                  String st=" DEPOSIT successful";
                  tts.setSpeechRate(1.0f);
                  tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                  String ty="DIRECT DEPOSIT ";
                  pp.inserttrans(hname,accno,a,ty,k);
                  Toast.makeText(getApplicationContext(),"deposited",Toast.LENGTH_SHORT).show();
              }
          }
      });


        Intent i =new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, 1);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            if(resultCode==TextToSpeech.Engine.CHECK_VOICE_DATA_PASS)
            {
                tts= new TextToSpeech(this,this);
            }
            else
            {
                Intent i=new Intent();
                i.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(i);
            }
        }
    }
    public void tts(String text) {

        tts.speak(text,TextToSpeech.QUEUE_FLUSH,null,null);

    }

    @SuppressWarnings("deprecation")
    public void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void ttsGreater21(String text) {
        String utteranceId=this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }


    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if(status==TextToSpeech.SUCCESS)
        {
            int f=1;
        }
        if(status==TextToSpeech.ERROR)
        {
            int f=0;
        }
    }


}


