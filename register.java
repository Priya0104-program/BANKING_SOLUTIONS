package com.example.bankingsolutions;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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


public class register extends AppCompatActivity implements TextToSpeech.OnInitListener{
    EditText  name;
    Toast toast;
    TextView reg, log, ink, fname, phone, password, dummy1, dummy2,ai,du;
    Button b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, regi,bu1,bu2,bu3,bu4,bu5,bu6,bu7,bu8,bu9,bu0;
    ImageButton button1, button2, button3, button4, button5, button6;
    Intent tolog;
    dbase mydb, checkuser;
    private TextToSpeech tts;
    String s = "", s1 = "", pass = "", ph = "", str = "", stp = "",stk="",accid="";
    public static final String MyPREFERENCES = "MyPrefs" ;
    public static final String accountnum = "numberKey";
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        mydb = new dbase(this);
        checkuser = new dbase(this);
        dummy1 = (TextView) findViewById(R.id.pho);
        dummy2 = (TextView) findViewById(R.id.paas);
        ai=(TextView)findViewById(R.id.atxt);
        du=(TextView)findViewById(R.id.adum);
        bu0=(Button)findViewById(R.id.ab0);
        bu1=(Button)findViewById(R.id.ab1);
        bu2=(Button)findViewById(R.id.ab2);
        bu3=(Button)findViewById(R.id.ab3);
        bu4=(Button)findViewById(R.id.ab4);
        bu5=(Button)findViewById(R.id.ab5);
        bu6=(Button)findViewById(R.id.ab6);
        bu7=(Button)findViewById(R.id.ab7);
        bu8=(Button)findViewById(R.id.ab8);
        bu9=(Button)findViewById(R.id.ab9);
        b0 = (Button) findViewById(R.id.btn0);
        b1 = (Button) findViewById(R.id.btn1);
        b2 = (Button) findViewById(R.id.btn2);
        b3 = (Button) findViewById(R.id.btn3);
        b4 = (Button) findViewById(R.id.btn4);
        b5 = (Button) findViewById(R.id.btn5);
        b6 = (Button) findViewById(R.id.btn6);
        b7 = (Button) findViewById(R.id.btn7);
        b8 = (Button) findViewById(R.id.btn8);
        b9 = (Button) findViewById(R.id.btn9);
        regi = (Button) findViewById(R.id.btnLogin);
        name = (EditText) findViewById(R.id.txtName);
        phone = (TextView) findViewById(R.id.secTxt);
        fname = (TextView) findViewById(R.id.ftxt);
        ink = (TextView) findViewById(R.id.lnkLogin);
        log = (TextView) findViewById(R.id.loginscrn);
        button1 = (ImageButton) findViewById(R.id.button1);
        button2 = (ImageButton) findViewById(R.id.button2);
        button3 = (ImageButton) findViewById(R.id.button3);
        button4 = (ImageButton) findViewById(R.id.button4);
        button5 = (ImageButton) findViewById(R.id.button5);
        button6 = (ImageButton) findViewById(R.id.button6);
        password = (TextView) findViewById(R.id.thirdTxt);


        ink.setMovementMethod(LinkMovementMethod.getInstance());
        ink.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="LOGIN PAGE";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                tolog = new Intent(register.this, loginpage.class);
                startActivity(tolog);
            }
        });

        password.setMovementMethod(LinkMovementMethod.getInstance());
        password.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER PASSWORD HERE";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });


        ai.setMovementMethod(LinkMovementMethod.getInstance());
        ai.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER ACCOUNT NUMBER HERE WITH THE HELP OF BUTTONS GIVEN BELOW";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        phone.setMovementMethod(LinkMovementMethod.getInstance());
        phone.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER PHONE NUMBER HERE WITH THE HELP OF BUTTONS GIVEN BELOW";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        fname.setMovementMethod(LinkMovementMethod.getInstance());
        fname.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="ENTER YOUR NAME HERE";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });
        log.setMovementMethod(LinkMovementMethod.getInstance());
        log.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="THIS IS REGISTRATION PAGE FILL ALL THE DETAILS GIVEN BELOW";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

            }
        });

        button1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" RED BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                str = str + "r";
                dummy2.setText(str);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" YELLOW BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                str = str + "y";
                dummy2.setText(str);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" BLUE BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                str = str + "b";
                dummy2.setText(str);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" GREEN BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                str = str + "g";
                dummy2.setText(str);


            }
        });
        button5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" BLACK BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                str = str + "c";
                dummy2.setText(str);

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" PURPLE BUTTON ";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                str = str + "p";
                dummy2.setText(str);
            }
        });
        b0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="0";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stp = stp + "0";
                dummy1.setText(stp);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 1";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stp = stp + "1";
                dummy1.setText(stp);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 2";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stp = stp + "2";
                dummy1.setText(stp);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 3";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stp = stp + "3";
                dummy1.setText(stp);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 4";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stp = stp + "4";
                dummy1.setText(stp);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 5";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stp = stp + "5";
                dummy1.setText(stp);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 6";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                stp = stp + "6";
                dummy1.setText(stp);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 7";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stp = stp + "7";
                dummy1.setText(stp);
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 8";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stp = stp + "8";
                dummy1.setText(stp);
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 9";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                stp = stp + "9";
                dummy1.setText(stp);
            }
        });
        bu0.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st="0";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stk= stk + "0";
                du.setText(stk);
            }
        });

        bu1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String stm=" 1";
                tts.setSpeechRate(1.0f);
                tts.speak(stm,TextToSpeech.QUEUE_FLUSH,null);

                stk = stk + "1";
                du.setText(stk);

            }
        });
        bu2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 2";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stk = stk + "2";
                du.setText(stk);
            }
        });
        bu3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 3";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stk = stk + "3";
                du.setText(stk);
            }
        });
        bu4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 4";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stk = stk + "4";
                du.setText(stk);
            }
        });
        bu5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 5";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stk = stk + "5";
                du.setText(stk);
            }
        });
        bu6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 6";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                stk = stk + "6";
                du.setText(stk);
            }
        });
        bu7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 7";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stk = stk + "7";
                du.setText(stk);
            }
        });

        bu8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 8";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);

                stk= stk+ "8";
                du.setText(stk);
            }
        });
        bu9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                String st=" 9";
                tts.setSpeechRate(1.0f);
                tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                stk = stk + "9";
                du.setText(stk);
            }
        });



        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = "";
                s = name.getText().toString();
                pass = dummy2.getText().toString();
                ph = dummy1.getText().toString();
                accid=du.getText().toString();
                boolean val = true;
                Cursor cursor=checkuser.viewuser(s);
                while (cursor.moveToNext()){
                    user=cursor.getString(cursor.getColumnIndex(dbase.REGISTER_COLUMN_FULLNAME));
                }

                if (s.equals("")) {
                    String st="please enter your name";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter the name", Toast.LENGTH_SHORT).show();
                    val = false;
                }
               else if (s.equals(user))
                {
                    String st="User name already exists enter another user name";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "user name already exists", Toast.LENGTH_SHORT).show();
                    val = false;
                }
                else if (pass.equals("")) {
                    String st="please enter the  password";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter the password", Toast.LENGTH_SHORT).show();
                    val = false;
                } else if (ph.equals("")) {
                    String st="please enter  phone number";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter phone number", Toast.LENGTH_SHORT).show();
                    val = false;
                }
                else if (accid.equals("")){
                    String st="please enter  account number";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter your account number", Toast.LENGTH_SHORT).show();
                    val = false;
                }
                else if(accid.length()!=10)
                {
                    String st="enter  correct account number";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter correct account number", Toast.LENGTH_SHORT).show();
                    val = false;
                }
                else if (ph.length() != 10) {
                    String st="enter correct phone number";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter correct phone number", Toast.LENGTH_SHORT).show();
                    val = false;
                } else if (pass.length() < 4) {
                    String st="enter valid password";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "enter valid password", Toast.LENGTH_SHORT).show();
                    val = false;
                } else if (val) {
                    String sna=du.getText().toString();
                    SharedPreferences.Editor editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();
                    editor.putString(accountnum , sna);
                    editor.apply();
                    String nms,aa, pp, ss;
                    nms = name.getText().toString();
                    pp = dummy2.getText().toString();
                    ss = dummy1.getText().toString();
                    aa=du.getText().toString();
                    String str="REGISTRATION SUCCESSFUL";
                    tts.setSpeechRate(1.0f);
                    tts.speak(str,TextToSpeech.QUEUE_FLUSH,null);
                    mydb.insertContacts(nms,aa, pp, ss);
                    Toast.makeText(getApplicationContext(), " registration successful ", Toast.LENGTH_SHORT).show();
                    tolog = new Intent(register.this, loginpage.class);
                    startActivity(tolog);
                } else {
                    String st="please verify details";
                    tts.setSpeechRate(1.0f);
                    tts.speak(st,TextToSpeech.QUEUE_FLUSH,null);
                    Toast.makeText(getApplicationContext(), "please verify details.", Toast.LENGTH_SHORT).show();
                }


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




