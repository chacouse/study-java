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
	
	  	        // ���insert  
	        insert.setOnClickListener(new OnClickListener() {  
	  
	            @Override  
	            public void onClick(View v) {  
	                // TODO Auto-generated method stub  
	                EditText et_title = (EditText) findViewById(R.id.title);  
	                EditText et_content= (EditText) findViewById(R.id.content);  
	                cv.put("title", et_title.getText().toString());  
	                long res = sqldb.insert("addressbook", null, cv);// ��������  
	                if (res == -1) {  
	                    Toast.makeText(Edit.this, "���ʧ��",  
	                            Toast.LENGTH_SHORT).show();  
	                } else {  
	                    Toast.makeText(Edit.this, "��ӳɹ�",  
	                            Toast.LENGTH_SHORT).show();  
	                }  
	             
	            }  
	        });  
	        // ɾ��  
	        delete.setOnClickListener(new OnClickListener() {  
	  
	            @Override  
	            public void onClick(View v) {  
	                // TODO Auto-generated method stub  
	                int res = sqldb.delete("addressbook", "title='abc'", null);  
	                // ɾ������title������Ϊ��abc���ģ���һ�е��������ݣ�null��ʾ��һ�е���������  
	                // ���ڶ�������Ϊnull����ɾ�����������ж�Ӧ�������е����ݣ�Ҳ���ǰ�table����ˡ�  
	                // title='abc  
	                // ����ֵΪɾ��������  
	                if (res == 0) {  
	                    Toast.makeText(Edit.this, "ɾ��ʧ��",  
	                            Toast.LENGTH_SHORT).show();  
	                } else {  
	                    Toast.makeText(Edit.this, "��ɾ����" + res + "�е�����",  
	                            Toast.LENGTH_SHORT).show();  
	                }  
	    	  
	            }  
	        });  
	     
	       
	  
	  
	    }  
    
		}
