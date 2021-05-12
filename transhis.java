package com.example.bankingsolutions;

        import androidx.appcompat.app.AlertDialog;
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
        import android.widget.ImageButton;
        import android.widget.TextView;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.HashMap;


public class transhis extends AppCompatActivity implements TextToSpeech.OnInitListener{
    TextView tra,d1;
    ImageButton pm;
    String aname="",aaccno="",type="",tactno="",amt="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    public static final String accountnum = "numberKey";
    private TextToSpeech tts;
    dbase mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transhis);
        tra=(TextView)findViewById(R.id.hea);
        pm=(ImageButton)findViewById(R.id.ll);
        d1=(TextView)findViewById(R.id.kk);

        mydb=new dbase(this);
        SharedPreferences prefs = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE);
        final StringBuffer buffer=new StringBuffer();
        tra.setMovementMethod(LinkMovementMethod.getInstance());
        tra.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="This is transfer history  page  to know your transfer history click the orange button below";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });

        aname = prefs.getString(Name, null);
        aaccno=prefs.getString(accountnum,null);

        Cursor ra=mydb.viewtrandet(aname);
        while (ra.moveToNext()) {
            type = ra.getString(ra.getColumnIndex(dbase.Transactions_transfertype));
            tactno = ra.getString(ra.getColumnIndex(dbase.Transactions_toaccountnumber));
            amt = ra.getString(ra.getColumnIndex(dbase.Transactions_Ammount));
            buffer.append(">> Transferred to account number :"+tactno+"\n");
            buffer.append("Amount transferred :"+amt+"\n");
            buffer.append("Transfer type :"+type+"\n");

            d1.setText(buffer);


        }
        pm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st=buffer.toString();
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









