package jche846.softeng206.contactsmanager;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class SortScreen extends Activity {
	private Button button1;
	private Button button2;
	private Button button3;
	private Button button4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sort_screen);
		
		//First sorting option
		button1 = (Button)findViewById(R.id.sort_button_1);
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(SortScreen.this);
				dialogBuilder.setTitle("Confirmation.");
				dialogBuilder.setMessage("Are you sure you want to sort your contacts by first name?");
				
				dialogBuilder.setNegativeButton("No",null);
				dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int Button) {
						Intent intent= new Intent();
						intent.setClass(SortScreen.this, MainActivity.class);
						startActivity(intent);
						
					}
				});
				dialogBuilder.setCancelable(true);
				
				dialogBuilder.create().show();
				
			}
		});
		
		
		//Second sorting option
        button2 = (Button)findViewById(R.id.sort_button_2);
        button2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(SortScreen.this);
				dialogBuilder.setTitle("Confirmation.");
				dialogBuilder.setMessage("Are you sure you want to sort your contacts by last name?");
				
				dialogBuilder.setNegativeButton("No",null);
				dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int Button) {
						Intent intent= new Intent();
						intent.setClass(SortScreen.this, MainActivity.class);
						startActivity(intent);
						
					}
				});
				dialogBuilder.setCancelable(true);
				
				dialogBuilder.create().show();
				
			}
		});
        
        
        //Third sorting option
        button3 = (Button)findViewById(R.id.sort_button_3);
        button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(SortScreen.this);
				dialogBuilder.setTitle("Confirmation.");
				dialogBuilder.setMessage("Are you sure you want to sort your contacts by mobile phone number?");
				
				dialogBuilder.setNegativeButton("No",null);
				dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int Button) {
						Intent intent= new Intent();
						intent.setClass(SortScreen.this, MainActivity.class);
						startActivity(intent);
						
					}
				});
				dialogBuilder.setCancelable(true);
				
				dialogBuilder.create().show();
				
			}
		});
        
        
        //Fourth sorting option
        button4 = (Button)findViewById(R.id.sort_button_4);
        button4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(SortScreen.this);
				dialogBuilder.setTitle("Confirmation.");
				dialogBuilder.setMessage("Are you sure you want to sort your contacts by E-mail address?");
				
				dialogBuilder.setNegativeButton("No",null);
				dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int Button) {
						Intent intent= new Intent();
						intent.setClass(SortScreen.this, MainActivity.class);
						startActivity(intent);
						
					}
				});
				dialogBuilder.setCancelable(true);
				
				dialogBuilder.create().show();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sort_screen, menu);
		return true;
	}

}



