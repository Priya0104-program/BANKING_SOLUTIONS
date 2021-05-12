package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import androidx.appcompat.app.ActionBar;
import android.os.Message;
import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.speech.tts.TextToSpeech;


import android.widget.Button;
import android.widget.Toast;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.content.Intent;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class logout extends AppCompatActivity implements TextToSpeech.OnInitListener{
    Button lo;
    private TextToSpeech tts;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        lo = (Button) findViewById(R.id.lout);

        Intent i = new Intent();
        i.setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
        startActivityForResult(i, 1);
        lo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st="Logout page";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                Toast.makeText(getApplicationContext(),"Logout successful",Toast.LENGTH_SHORT).show();
                Intent i;
                i=new Intent(logout.this,fpage.class);
                startActivity(i);
            }
        });
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




