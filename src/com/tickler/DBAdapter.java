package com.tickler;

import android.content.Context;  
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteDatabase.CursorFactory;  
import android.database.sqlite.SQLiteOpenHelper;

public class DBAdapter extends SQLiteOpenHelper {
	
	 public DBAdapter(Context context, String name, CursorFactory factory,  
	            int version) {  
	        super(context, name, factory, version);
	        }
	
	 public void onCreate(SQLiteDatabase db){
		 String sql = "CREATE  TABLE addressbook (_id INTEGER PRIMARY KEY , KEY_TITLE, KEY_CONTENT)";  
	        db.execSQL(sql);  
	 }

	 public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
	        // TODO Auto-generated method stub  
	  
	    }

	public void insert(String say) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int step) {
		// TODO Auto-generated method stub
		
	}
}
