package database.android.com.database_sqlite;

import db.DataHandler;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends Activity {

    EditText editEmail,editPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        editEmail=(EditText)findViewById(R.id.editText1);
        editPass=(EditText)findViewById(R.id.editText2);

    }

    /*public void abc()
    {
        DataHandler handler=new DataHandler(this);
        SQLiteDatabase db=handler.getReadableDatabase();
        //Cursor cr=db.query(table, columns, selection, selectionArgs, groupBy, having, orderBy)
    }*/
    public void onLogIn(View v)
    {
        String email=editEmail.getText().toString();
        String pass=editPass.getText().toString();

        DataHandler handler=new DataHandler(this);
        SQLiteDatabase db=handler.getReadableDatabase();
        String sqlCmd="select * from "+DataHandler.TABUSER +" where "+DataHandler.COL3_EMAIL+" = ? and "+DataHandler.COL5_PASS+" =?";
        String [] selectionArgs={email,pass};
        Cursor cr=db.rawQuery(sqlCmd, selectionArgs);
        if(cr.moveToFirst())
        {
            String fname=cr.getString(0);
            String lname=cr.getString(1);
            String email1=cr.getString(2);
            String phone=cr.getString(3);
            String pass1=cr.getString(4);
            Toast.makeText(this, "Fname: "+fname+"\nLname: "+lname+"\nPhone: "+phone, 1).show();
        }


        else
        {
            Toast.makeText(this, "invalid email or password", 1).show();
        }
        cr.close();
        db.close();
    }



}
