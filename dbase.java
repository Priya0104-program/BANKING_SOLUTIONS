package com.example.bankingsolutions;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class dbase extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="MyDB.db";
    public static final String REGISTER_TABLE_NAME="Register";
    public static final String REGISTER_COLUMN_REGISTERID="register_id";
    public static final String REGISTER_COLUMN_FULLNAME="name";
    public static final String REGISTER_COLUMN_ACCOUNT_ID="acid";
    public static final String REGISTER_COLUMN_PASSWORD="password";
    public static final String REGISTER_COLUMN_PHONE_NO="phone";

    public static final String Admin="admin";
    public static final String Admin_Name= "aname";
    public static final String Admin_password="apassword";

    public static final String Transactions="transactions";
    public static final String Transactions_transferaccholdername="accholdername";
    public static final String Transactions_byaccholder="oaccholder";
    public static final String Transactions_toaccountnumber="toaccno";
    public static final String Transactions_transfertype="transferty";
    public static final String Transactions_Ammount="amount";

    public static final String Balance="balance";
    public static final String Balance_userBalance="bal";


    private HashMap hp;

    public dbase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {

            db.execSQL("create table " + REGISTER_TABLE_NAME + "( register_id INTEGER PRIMARY KEY AUTOINCREMENT , name TEXT,acid TEXT ,password TEXT , phone TEXT)");
            db.execSQL("create table admin(aname text, apassword text)");
            db.execSQL("create table transactions(accholdername text , oaccholder text,toaccno text,transferty text,amount text)");
            db.execSQL("create table balance(bal text) ");
        }
        catch (Exception ev)
        {
            System.out.println("EXCEPTION RAISED");
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+REGISTER_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS admin");
        db.execSQL("DROP TABLE IF EXISTS transactions");
        db.execSQL("DROP TABLE IF EXISTS balance");

        onCreate(db);

    }

    public void insertContacts(String name,String acid,String password, String phone) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(REGISTER_COLUMN_FULLNAME, name);
            contentValues.put(REGISTER_COLUMN_ACCOUNT_ID,acid);
            contentValues.put(REGISTER_COLUMN_PASSWORD, password);
            contentValues.put(REGISTER_COLUMN_PHONE_NO, phone);
            db.insert(REGISTER_TABLE_NAME, null, contentValues);
        } catch (Exception e) {
            System.out.println("EXCEPTION RAISED");

        }
    }
    public  void insertadmin()
    {
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("aname","priyamishra2224");
            cv.put("apassword","priya2224");
            db.insert("admin",null,cv);
        }
        catch (Exception e){
            System.out.println("Exception raised");
        }
    }
    public void inserttrans(String oaccholder,String accholdername,String toaccno,String transferty,String amount)
    {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Transactions_transferaccholdername,accholdername);
            contentValues.put(Transactions_byaccholder,oaccholder);
            contentValues.put(Transactions_toaccountnumber,toaccno);
            contentValues.put(Transactions_transfertype,transferty);
            contentValues.put(Transactions_Ammount,amount);

            db.insert("transactions", null, contentValues);
        } catch (Exception e) {
            System.out.println("EXCEPTION RAISED");

        }
    }
    public void insertbalance(String bal)
    {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(Balance_userBalance, bal);
            db.insert("balance", null, contentValues);
        }
        catch (Exception e)
        {
            System.out.println("EXCEPTION RAISED");
        }

    }
    public Integer deletecontact(String name)
    {
        String s[]=new String[1];
        s[0]=name;
        SQLiteDatabase db=this.getWritableDatabase();
        return db.delete("register","username =?",s);
    }
    public Cursor viewadname(String adnm)
    {   Cursor r=null;
        SQLiteDatabase db=this.getReadableDatabase();
        r=db.rawQuery("select * from admin where aname='"+adnm+"'",null);
        return r;
    }
    public Cursor viewbal()
    {   Cursor r=null;
        SQLiteDatabase db=this.getReadableDatabase();
        r=db.rawQuery("select * from balance ",null);
        return r;
    }
    public Cursor viewadpassword(String uaame)
    {   Cursor r=null;
        SQLiteDatabase db=this.getReadableDatabase();
        r=db.rawQuery("select * from Admin where aname='"+uaame+"'",null);
        return r;
    }
    public Cursor viewpassword(String uame)
    {   Cursor r=null;
        SQLiteDatabase db=this.getReadableDatabase();
         r=db.rawQuery("select * from register where name='"+uame+"'",null);
        return r;
    }
    public Cursor viewphone(String name)
    {     Cursor r=null;
        SQLiteDatabase db=this.getReadableDatabase();
         r=db.rawQuery("select * from register where name='"+name+"'",null);
        return r;
    }
   public Cursor viewuser(String nme)
   {
       Cursor r=null;
       SQLiteDatabase db=this.getReadableDatabase();
       r=db.rawQuery("select * from register where name='"+nme+"'",null);
       return r;
   }
    public Cursor viewaccountnumber(String unme)
    {
        Cursor r=null;
        SQLiteDatabase db=this.getReadableDatabase();
        r=db.rawQuery("select * from transactions where name='"+unme+"'",null);
        return r;
    }
    public Cursor viewaccountid(String n)
    {
        Cursor r=null;
        SQLiteDatabase db=this.getReadableDatabase();
        r=db.rawQuery("select * from register where name='"+n+"'",null);
        return r;
    }
    public Cursor viewus()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from register ",null);
        return res;
    }
    public Cursor viewtra()
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor res=db.rawQuery("select * from transactions ",null);
        return res;
    }
    public Cursor viewtrandet(String hnms){
        Cursor r=null;
        SQLiteDatabase datab=this.getReadableDatabase();
        r=datab.rawQuery("select * from transactions where  oaccholder ='" +hnms+"' ",null);
        return r;
    }
    public Cursor viewuserdet(String nm){
        Cursor r=null;
        SQLiteDatabase datab=this.getReadableDatabase();
        r=datab.rawQuery("select * from register where name ='" +nm+"' ",null);
        return r;
    }


    public Cursor getid()
    {
        Cursor r=null;
        try {
            // SQLiteDatabase db=this.getReadableDatabase();
            // r=db.rawQuery("select id from trans",null);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        return r;

    }


}
