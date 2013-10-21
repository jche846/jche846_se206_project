package jche846.softeng206.contactsmanager;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Add_new_contact extends Activity {
	//create button objects
	private Button buttonAdd;
	private Button buttonCancel;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_new_contact);
		
		//Set the add button to change activity on click
        buttonAdd= (Button)findViewById(R.id.addContact);
        buttonAdd.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
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
