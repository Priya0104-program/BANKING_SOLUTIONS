package com.example.bankingsolutions;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.annotation.TargetApi;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.method.LinkMovementMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class loginpage  extends AppCompatActivity  implements TextToSpeech.OnInitListener {
    public EditText na;
    public ImageButton but1,but2,but3,but4,but5,but6;
    public Button login;
    public TextView password,nam,du,tit,title;
    private TextToSpeech tts;
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String Name = "nameKey";
    SharedPreferences sharedpreferences;
   dbase base;
   Intent i;

  String st="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);


        na = (EditText) findViewById(R.id.usname);
        tit=(TextView)findViewById(R.id.ti);
        nam = (TextView) findViewById(R.id.nm);
        du=(TextView)findViewById(R.id.dumm);
        but1 = (ImageButton) findViewById(R.id.button10);
        but2 = (ImageButton) findViewById(R.id.button20);
        but3 = (ImageButton) findViewById(R.id.button30);
        but4 = (ImageButton) findViewById(R.id.button40);
        but5 = (ImageButton) findViewById(R.id.button50);
        but6 = (ImageButton) findViewById(R.id.button60);
        password = (TextView) findViewById(R.id.thirdTxt);
        title = (TextView) findViewById(R.id.titl);

        base = new dbase(this);
        login = (Button) findViewById(R.id.login);
        title.setMovementMethod(LinkMovementMethod.getInstance());
        title.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="NOT registered yet login here";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                i = new Intent(loginpage.this, register.class);
                startActivity(i);
            }
        });

        password.setMovementMethod(LinkMovementMethod.getInstance());
        password.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER PASSWORD HERE WITH THE HELP OF BUTTONS GIVEN BELOW";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        nam.setMovementMethod(LinkMovementMethod.getInstance());
        nam.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER YOUR NAME HERE";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        tit.setMovementMethod(LinkMovementMethod.getInstance());
        tit.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="YOU ARE ON LOGIN PAGE PLEASE ENTER THE INFORMATION ASKED BELOW ";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st = st + "r";
                du.setText(st);
                String str=" RED BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str=" YELLOW BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);
                st = st + "y";
                du.setText(st);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st = st + "b";
                du.setText(st);
                String str=" BLUE BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st = st + "g";
                du.setText(st);
                String str=" GREEN BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st = st + "c";
                du.setText(st);
                String str=" BLACK BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                st = st + "p";
                du.setText(st);
                String str=" PURPLE BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dbpass="",stri="",naa="";
                String stt="";
                na=(EditText)findViewById(R.id.usname);
                stri = na.getText().toString();
                stt=st;
                Cursor ra=base.viewpassword(stri);
                while (ra.moveToNext()){
                    dbpass=ra.getString(ra.getColumnIndex(dbase.REGISTER_COLUMN_PASSWORD));
                }
                if (stri.equals(""))
                {
                    String st="please enter username";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(),"please enter username",Toast.LENGTH_SHORT).show();

                }
                else if (stt.equals(""))
                {
                    String st="please enter password";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(),"please enter password",Toast.LENGTH_SHORT).show();
                }
                else if (dbpass.equals(stt)){
                    String sna=na.getText().toString();
                    SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();
                    editor.putString(Name, sna);
                    editor.apply();
                    String str=" login successful";

                        tts.setSpeechRate(1.0f);
                    tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);
                            Toast.makeText(getApplicationContext(),"Login successful",Toast.LENGTH_SHORT).show();
                            i=new Intent(loginpage.this,transaction.class);
                            startActivity(i);

                        }

                else {

                    String st="invalid username or password";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(),"Invalid username or password",Toast.LENGTH_SHORT).show();
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








