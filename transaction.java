package com.example.bankingsolutions;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build;
import java.util.Locale;
import java.util.HashMap;
import android.view.View;
import android.speech.tts.TextToSpeech;
import android.util.Log;import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class transaction extends AppCompatActivity implements  TextToSpeech.OnInitListener {
    private TextToSpeech tts;

    public ImageButton viewbal,details,history,tra,lout;
    public TextView ba;
    Intent it;
    String text="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        tts = new TextToSpeech(this, this);
        details=(ImageButton)findViewById(R.id.btn10);
        lout=(ImageButton)findViewById(R.id.btn60);
        history=(ImageButton)findViewById(R.id.btn20);
        tra=(ImageButton)findViewById(R.id.btn40);
        viewbal=(ImageButton)findViewById(R.id.btn50);
        ba=(TextView)findViewById(R.id.head);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"bank account details",Toast.LENGTH_SHORT).show();
                 text="RED BUTTON IS FOR CHECKING ACCOUNT DETAILS";
                 speakOut();
                it=new Intent(transaction.this,accountdet.class);
                startActivity(it);

            }
        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"transaction history",Toast.LENGTH_SHORT).show();
                text="YELLOW BUTTON IS FOR CHECKING TRANSACTION HISTORY";
                speakOut();
                it=new Intent(transaction.this,transhis.class);
                startActivity(it);

            }
        });

        tra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"TRANSFER",Toast.LENGTH_SHORT).show();
                text="GREEN BUTTON IS FOR  TRANSFER";
                speakOut();
                it=new Intent(transaction.this,transfer.class);
                startActivity(it);

            }
        });


        viewbal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"View balance",Toast.LENGTH_SHORT).show();
                text="BLACK BUTTON IS FOR VIEWING BALANCE";
                speakOut();
                it=new Intent(transaction.this,viewbalance.class);
                startActivity(it);

            }
        });
        lout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"LOGOUT",Toast.LENGTH_SHORT).show();
                text="PURPLE BUTTON IS FOR  LOGOUT";
                speakOut();
                it=new Intent(transaction.this,logout.class);
                startActivity(it);

            }
        });

    }
    public void speakOut() {



        tts.setLanguage(Locale.US);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            tts(text);
        } else {
            tts(text);
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
        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            // tts.setPitch(5); // set pitch level

            // tts.setSpeechRate(2); // set speech speed rate

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "Language is not supported");
            } else {
                details.setEnabled(true);
                speakOut();
            }

        } else {
            Log.e("TTS", "Initialisation Failed");
        }

    }


}

