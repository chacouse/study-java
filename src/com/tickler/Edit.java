package com.tickler;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class Edit extends Activity{
	
	    SQLiteDatabase sqldb;  
	    public String DB_NAME = "sql.db";  
	    public String DB_TABLE = "num";  
	    public int DB_VERSION = 1;  
	    final DBAdapter helper = new DBAdapter(this, DB_NAME, null, DB_VERSION);  
	   
	 
	    @Override  
	    public void onCreate(Bundle savedInstanceState) {  
	        super.onCreate(savedInstanceState);  
	        setContentView(R.layout.describe);  
	        sqldb = helper.getWritableDatabase();  
	       
	        Button insert = (Button) findViewById(R.id.insert);  
	        Button delete = (Button) findViewById(R.id.delete);  
	       	final ContentValues cv = new ContentValues();  
	
	  	        // 添加insert  
	        insert.setOnClickListener(new OnClickListener() {  
	  
	            @Override  
	            public void onClick(View v) {  
	                // TODO Auto-generated method stub  
	                EditText et_title = (EditText) findViewById(R.id.title);  
	                EditText et_content= (EditText) findViewById(R.id.content);  
	                cv.put("title", et_title.getText().toString());  
	                long res = sqldb.insert("addressbook", null, cv);// 插入数据  
	                if (res == -1) {  
	                    Toast.makeText(Edit.this, "添加失败",  
	                            Toast.LENGTH_SHORT).show();  
	                } else {  
	                    Toast.makeText(Edit.this, "添加成功",  
	                            Toast.LENGTH_SHORT).show();  
	                }  
	             
	            }  
	        });  
	        // 删除  
	        delete.setOnClickListener(new OnClickListener() {  
	  
	            @Override  
	            public void onClick(View v) {  
	                // TODO Auto-generated method stub  
	                int res = sqldb.delete("addressbook", "title='abc'", null);  
	                // 删除列名title，行名为“abc”的，这一行的所有数据，null表示这一行的所有数据  
	                // 若第二个参数为null，则删除表中所有列对应的所有行的数据，也就是把table清空了。  
	                // title='abc  
	                // 返回值为删除的行数  
	                if (res == 0) {  
	                    Toast.makeText(Edit.this, "删除失败",  
	                            Toast.LENGTH_SHORT).show();  
	                } else {  
	                    Toast.makeText(Edit.this, "成删除了" + res + "行的数据",  
	                            Toast.LENGTH_SHORT).show();  
	                }  
	    	  
	            }  
	        });  
	     
	       
	  
	  
	    }  
    
		}
