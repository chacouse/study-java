package com.tickler;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.ActionBar;
import android.content.Intent;



public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ActionBar actionBar =getActionBar();		  
	    setContentView(R.layout.describe); 
	      //取得Intent中的Bundle对象
	    Bundle bundle = this.getIntent().getExtras();       
	        //取得Bundle对象中的数据
	    String message  = bundle.getString("title");           
	        //设置输出文字
	    String text = getIntent().getExtras().getString("title");
	    TextView Title= (TextView)findViewById(R.id.title);
	    Title.setText( message ); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		super.onCreateOptionsMenu(menu);
		CreateMenu(menu);
		return true;
	}
	public boolean onOptionsItemSelected(MenuItem item)
	{return MenuChoice(item);}
	
	
	private void CreateMenu(Menu menu) {
		// TODO Auto-generated method stub
		MenuItem mnu1 = menu.add(0, 0, 0, "ADD");//
		{mnu1.setIcon(android.R.drawable.ic_menu_save);
		mnu1.setAlphabeticShortcut('a');
		
		
		}
		MenuItem mnu2 = menu.add(0, 1, 1, "DELETE");
		{mnu2.setIcon(android.R.drawable.ic_menu_delete);
		mnu2.setAlphabeticShortcut('b');
		
		
		}
		
	}
	

	private boolean MenuChoice(MenuItem item) 
	{
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case 0:
		Toast.makeText(this, "创建新文档",
		Toast.LENGTH_LONG).show();
		 add(); 
     
        
	
	
	return true;
		case 1:
		Toast.makeText(this, "进行删除操作",
		Toast.LENGTH_LONG).show();
		return true;
		
		}
		return false;
	}

	private void add() {
		// TODO Auto-generated method stub
		
	}
	

      
    
	
	
	
	
}