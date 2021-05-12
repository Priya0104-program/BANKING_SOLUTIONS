package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.HashMap;
import android.media.MediaPlayer;

public class viewbalance extends AppCompatActivity implements TextToSpeech.OnInitListener {
    TextView vb,de;
   ImageButton hh;
   String bala="";
    private TextToSpeech tts;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String balance = "balanceKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewbalance);
       vb=(TextView)findViewById(R.id.he);
       de=(TextView)findViewById(R.id.kkm);
       hh=(ImageButton)findViewById(R.id.llm);
        vb.setMovementMethod(LinkMovementMethod.getInstance());
        vb.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="this is a view balance page  you can click the blue button to check your balance";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
      bala = prefs.getString(balance, null);
      de.setText(bala);

      hh.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              String st=bala;
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





