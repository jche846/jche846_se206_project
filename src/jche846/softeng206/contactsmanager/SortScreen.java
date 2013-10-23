package jche846.softeng206.contactsmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
	DatabaseHandler db = new DatabaseHandler(this);
	
	public void sortFirst(){
		 List<All_contacts> displayList = db.getAllContacts();
		 List<All_contacts> list= new ArrayList<All_contacts>();
		 
		 for (int i= 0; i < displayList.size(); i++){
			 
		 }
	}
	public void sortLast(){
		 List<All_contacts> displayList = db.getAllContacts();
		 List<All_contacts> list= new ArrayList<All_contacts>();
	}
	public void sortMobile(){
		 List<All_contacts> displayList = db.getAllContacts();
		 List<All_contacts> list= new ArrayList<All_contacts>();
	}
	class firstComparator implements Comparator<All_contacts> {

		@Override
		public int compare(All_contacts arg0, All_contacts arg1) {
			// TODO Auto-generated method stub
			return 0;
		}
	   
	}
	
	class lastComparator implements Comparator<All_contacts> {
		@Override
		public int compare(All_contacts lhs, All_contacts rhs) {
			// TODO Auto-generated method stub
			return 0;
		}
	   
	}
	
	class mobileComparator implements Comparator<All_contacts> {

		@Override
		public int compare(All_contacts lhs, All_contacts rhs) {
			// TODO Auto-generated method stub
			return 0;
		}
	   
	}
	
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
				dialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
					
					
					@Override
					public void onClick(DialogInterface dialog, int Button) {

						Intent intent1= new Intent();
						intent1.setClass(SortScreen.this, MainActivity.class);
						startActivity(intent1);
						
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
				dialogBuilder.setPositiveButton("Yes",null);
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
				dialogBuilder.setPositiveButton("Yes", null);
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



