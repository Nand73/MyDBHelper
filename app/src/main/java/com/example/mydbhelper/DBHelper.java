package com.example.mydbhelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="ContactsDB";
    private static final int DATABASE_VERSION=1;
    private static final String TABLE_CONTACT="contacts";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_PHONE_NO="phone_no";

    public DBHelper( Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
      // sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_CONTACT
    //   +"("+KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+KEY_NAME+"TEXT,"+KEY_PHONE_NO+"TEXT"+")");
       String dbQuery="CREATE TABLE Items(id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,phone_no TEXT)";
       sqLiteDatabase.execSQL(dbQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_CONTACT);

        onCreate(sqLiteDatabase);
    }
    public void addContact(String name,String phone_no){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_NAME,name);
        values.put(KEY_PHONE_NO,phone_no);
        db.insert(TABLE_CONTACT,null,values);
         db.close();
    }
}
