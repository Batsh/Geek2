package com.example.muradmomani.anothaone;

import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.EditText;

public class MyDatabase extends SQLiteOpenHelper {
    public static final String Database_name="GeekThree.db";
    public static final String table_name="movie";
    public static final String col_1="ID";
    public static final String col_2="name";
    public static final String col_3="discription";


    public MyDatabase(Context context) {

        super(context, Database_name, null, 1);
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE AHMAD(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, discription TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS AHMAD");
        onCreate(db);
    }

    public boolean insert(String name, String discription)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(col_2, name);
        values.put(col_3, discription);
        long result=db.insert("AHMAD", null,values );
        //db.close();
        if(result==-1)
            return false;
        else
            return true;

    }
}
