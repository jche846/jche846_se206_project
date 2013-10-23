package jche846.softeng206.contactsmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add_new_contact extends Activity {
	DatabaseHandler db = new DatabaseHandler(this);
	
	//create button objects
	private Button buttonAdd;
	private Button buttonCancel;
	
	//edit text boxes
	private EditText addFirst;
	private EditText addLast;
	private EditText addMobile;
	private EditText addHome;
	private EditText addWork;
	private EditText addEmail;
	private EditText addHomeAdd;
	private EditText addDOB;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_contact);
		
		//Set the edit text boxes
		addFirst = (EditText)findViewById(R.id.addText1);
		addLast = (EditText)findViewById(R.id.addText2);
		addMobile = (EditText)findViewById(R.id.addText3);
		addHome = (EditText)findViewById(R.id.addText4);
		addWork = (EditText)findViewById(R.id.addText5);
		addEmail = (EditText)findViewById(R.id.addText6);
		addHomeAdd = (EditText)findViewById(R.id.addText7);
		addDOB = (EditText)findViewById(R.id.addText8);
		
		
		//Set the add button to change activity on click
        buttonAdd = (Button)findViewById(R.id.addContact);
        buttonAdd.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				String first =addFirst.getText().toString();
				String last =addLast.getText().toString();
				String mobile =addMobile.getText().toString();
				String home =addHome.getText().toString();
				String work =addWork.getText().toString();
				String email =addEmail.getText().toString();
				String homeadd =addHomeAdd.getText().toString();
				String dob =addDOB.getText().toString();
				
				db.addContact(new All_contacts(first,last,mobile,home,work,email,homeadd,dob));
				
				Intent intent= new Intent();
        		intent.setClass(Add_new_contact.this, MainActivity.class);
        		startActivity(intent);
        		
				}
        	 });
		
		//Set the cancel button to change activity on click
        buttonCancel= (Button)findViewById(R.id.CancelAdd);
        buttonCancel.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent= new Intent();
        		intent.setClass(Add_new_contact.this, MainActivity.class);
        		startActivity(intent);
				}
        	 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_new_contact, menu);
		return true;
	}

}
