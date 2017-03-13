package database.android.com.database_sqlite;
import db.DataHandler;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Build;
import android.provider.ContactsContract.Contacts.Data;

public class SignUpActivity extends Activity {

    EditText editFname,editLname,editEmail,editPhone,editPass,editCpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editFname=(EditText)findViewById(R.id.editfname);
        editLname=(EditText)findViewById(R.id.editlname);
        editEmail=(EditText)findViewById(R.id.editemail);
        editPhone=(EditText)findViewById(R.id.editphone);
        editPass=(EditText)findViewById(R.id.editpass);
        editCpass=(EditText)findViewById(R.id.editecpass);
    }

    public void onSubmit(View v)
    {
        final String fname=editFname.getText().toString();
        final String lname=editLname.getText().toString();
        final String email=editEmail.getText().toString();
        final String phone=editPhone.getText().toString();
        final String pass=editPass.getText().toString();
        final String cpass=editCpass.getText().toString();
        if(fname.equals(""))
        {
            editFname.setError("You must enter your first name");
            editFname.requestFocus();
        }
        else if(lname.equals(""))
        {
            editLname.setError("You must enter your last name");
            editLname.requestFocus();
        }
        else if(email.equals(""))
        {
            editEmail.setError("You must enter your email address");
            editEmail.requestFocus();
        }
        else if(phone.equals(""))
        {
            editPhone.setError("You must enter your phone number");
            editPhone.requestFocus();
        }
        else if(pass.equals(""))
        {
            editPass.setError("You must enter password");
            editPass.requestFocus();
        }
        else if(!pass.equals(cpass))
        {
            editCpass.setError("Confirm password mismatch");
            editCpass.requestFocus();
        }
        else
        {
            DataHandler handler=new DataHandler(this);
            SQLiteDatabase db=handler.getWritableDatabase();

            //String cmd="insert";
            //db.rawQuery(sql, selectionArgs)
            ContentValues cv=new ContentValues();
            cv.put(DataHandler.COL1_FNAME, fname);
            cv.put(DataHandler.COL2_LNAME, lname);
            cv.put(DataHandler.COL3_EMAIL, email);
            cv.put(DataHandler.COL4_PHONE, phone);
            cv.put(DataHandler.COL5_PASS, pass);
            long l=db.insert(DataHandler.TABUSER, null, cv);
            if(l>0)
            {
                Toast.makeText(this, "Record inserted", 1).show();
                editFname.setText("");
                editLname.setText("");
                editEmail.setText("");
                editPhone.setText("");
                editPass.setText("");
                editCpass.setText("");
            }
        }
    }

}
