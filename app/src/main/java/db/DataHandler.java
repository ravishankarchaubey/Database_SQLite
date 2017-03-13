package db;

        import android.content.Context;
        import android.database.sqlite.SQLiteDatabase;

        import android.database.sqlite.SQLiteOpenHelper;

public class DataHandler extends SQLiteOpenHelper{

    private final static int VERSION=1;
    public final static String DB="MyDb";

    public final static String TABUSER="user_data";
    public final static String COL1_FNAME="fname";
    public final static String COL2_LNAME="lname";
    public final static String COL3_EMAIL="email";
    public final static String COL4_PHONE="phone";
    public final static String COL5_PASS="password";

    public DataHandler(Context context) {
        super(context, DB, null, VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Command to create table
        //text,integer,blob
        String cmd1=String.format("Create table %s (%s text, %s text, %s text,%s text,%s text)",
                TABUSER,COL1_FNAME,COL2_LNAME,COL3_EMAIL,COL4_PHONE,COL5_PASS);
        db.execSQL(cmd1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub


    }

}

