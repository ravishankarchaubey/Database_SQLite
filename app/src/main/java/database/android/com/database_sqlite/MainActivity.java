package database.android.com.database_sqlite;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void onLogin(View v)
    {
        Intent intent=new Intent(this,LogInActivity.class);
        startActivity(intent);
    }

    public void onSignup(View v)
    {
        Intent intent=new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
