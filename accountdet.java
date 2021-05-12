package com.example.bankingsolutions;


import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;
import java.util.Queue;

public class accountdet extends AppCompatActivity  implements  OnInitListener  {
    private TextToSpeech tts;
    public TextView ti,an,anam,ano,anum,at,atype,ac,acountry,pri,yourbal;
    String text="",name=""; String accnumb="";
    Button dummm;String am="";
dbase pp;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String accountnum = "numberKey";
    Intent it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountdet);
        ti=(TextView)findViewById(R.id.titlea);
        pri=(TextView)findViewById(R.id.naam);
        pp=new dbase(this);
        an=(TextView)findViewById(R.id.accn);
        yourbal=(TextView)findViewById(R.id.ybal);
        anam=(TextView)findViewById(R.id.accname);
        ano=(TextView)findViewById(R.id.accno);
        anum=(TextView)findViewById(R.id.accnumber);
        at=(TextView)findViewById(R.id.accty);
        atype=(TextView)findViewById(R.id.acctype);
        ac=(TextView)findViewById(R.id.acccoun);
        acountry=(TextView)findViewById(R.id.country);
        dummm=(Button) findViewById(R.id.du);
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
         name = prefs.getString(Name, null);
           accnumb=prefs.getString(accountnum,null);
        anam.setText(name);
       anum.setText(accnumb);
       pri.setText(name);

        Cursor ra=pp.viewbal();
        while (ra.moveToNext()){
            am=ra.getString(ra.getColumnIndex(dbase.Balance_userBalance));
        }
        yourbal.setText(am);

        dummm.setOnClickListener(new View.OnClickListener() {
    @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

        String str=" ACCOUNT HOLDER NAME IS" +name+
                "YOUR ACCOUNT NUMBER IS " +accnumb+
                "YOUR ACCOUNT TYPE IS PERSONAL" +
                "YOUR BANK COUNTRY IS INDIA" +
                "Your Balance is"+am ;
        tts.setSpeechRate(0.80f);
        tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);


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
