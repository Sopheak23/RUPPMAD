package kh.edu.rupp.fe.ruppmad.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import kh.edu.rupp.fe.ruppmad.adapter.Assignment;

/**
 * Created by MK COMPUTER on 5/6/2017.
 */

public class DbManager extends SQLiteOpenHelper {

    public DbManager(Context context){ super(context, "ruppmad.db", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d("rupp", "DB onCreate");
        String tblAssignmentSql = "create table tblAssignment" +
                "(_id integer primary key autoincrement, " +
                "_title text, _thumbnail_url text, _size integer)";
        sqLiteDatabase.execSQL(tblAssignmentSql);

//        Insert default assignments
        Assignment a1 = new Assignment("Group Projects New", "", "5-09-2017");
        insertAssignment(a1, sqLiteDatabase);
        Assignment a2 = new Assignment("Individual Projects", "", "5-09-2017");
        insertAssignment(a2, sqLiteDatabase);
        Assignment a3 = new Assignment("Projects for the Nerd", "", "5-09-2017");
        insertAssignment(a3, sqLiteDatabase);
        Assignment a4 = new Assignment("Good Old Projects", "", "5-09-2017");
        insertAssignment(a4, sqLiteDatabase);
        Assignment a5 = new Assignment("Badas Projects", "", "5-09-2017");
        insertAssignment(a5, sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean insertAssignment(Assignment assignment, SQLiteDatabase db){
        ContentValues row = new ContentValues();
        row.put("_title", assignment.getTitle());
        row.put("_thumbnail_url", assignment.getThumbnailUrl());
        row.put("_size", assignment.getDate());
        long newId = db.insert("tblAssignment", null, row);
        return (newId > -1);
    }

    public boolean insertAssignment(Assignment assignment){
        return insertAssignment(assignment, getWritableDatabase());
    }

    public Assignment[] getAllAssignments(){
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {"_id", "_title", "_thumbnail_url", "_size"};
        Cursor cursor = db.query("tblAssignment", columns, null, null, null, null, null);
        Assignment[] assignments = new Assignment[cursor.getCount()];
        int i = 0;
        while(cursor.moveToNext()){
            int id  = cursor.getInt(0);
            String title = cursor.getString(1);
            String thumbnailUrl = cursor.getString(2);
            String date = cursor.getString(2);
            Assignment assignment = new Assignment(title, thumbnailUrl, date);
            assignments[i] = assignment;
            i++;
        }
        return assignments;
    }
}
