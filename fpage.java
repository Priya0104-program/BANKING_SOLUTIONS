package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class fpage extends AppCompatActivity implements TextToSpeech.OnInitListener{
    Button alogin,ulogin,uregister;
    dbase bb;
    private TextToSpeech tts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpage);
        alogin=(Button)findViewById(R.id.adlog);
        ulogin=(Button)findViewById(R.id.uslog);
        uregister=(Button)findViewById(R.id.usreg);
        bb=new dbase(this);

        alogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bb.insertadmin();
                Intent in=new Intent(fpage.this,admin.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"admin login page",Toast.LENGTH_SHORT).show();
                String st="Admin login page";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        ulogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(fpage.this,loginpage.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"user login page",Toast.LENGTH_SHORT).show();
                String st="user login page";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        uregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(fpage.this,register.class);
                startActivity(in);
                Toast.makeText(getApplicationContext(),"user register page",Toast.LENGTH_SHORT).show();
                String st="user register page";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        Intent i = new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                tts = new TextToSpeech(this, this);
            } else {
                Intent i = new Intent();
                i.setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(i);
            }
        }
    }

    public void tts(String text) {

        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, null);

    }

    @SuppressWarnings("deprecation")
    public void ttsUnder20(String text) {
        HashMap<String, String> map = new HashMap<>();
        map.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "MessageId");
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, map);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void ttsGreater21(String text) {
        String utteranceId = this.hashCode() + "";
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, utteranceId);
    }


    @Override
    public void onInit(int status) {
        // TODO Auto-generated method stub
        if (status == TextToSpeech.SUCCESS) {
            int f = 1;
        }
        if (status == TextToSpeech.ERROR) {
            int f = 0;
        }
    }

}





