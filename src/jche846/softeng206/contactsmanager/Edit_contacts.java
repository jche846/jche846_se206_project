package jche846.softeng206.contactsmanager;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Edit_contacts extends Activity {
	private Button SaveButton;
	private Button CancelSave;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_contacts);
		
		//The save button, set it to change activity on click
		SaveButton= (Button)findViewById(R.id.SaveButton);
		SaveButton.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(Edit_contacts.this);
				dialogBuilder.setTitle("Confirmation.");
				dialogBuilder.setMessage("Are you sure you want to save the new changes made??");
				
				dialogBuilder.setNegativeButton("No",null);
				dialogBuilder.setPositiveButton("Yes", null);
				dialogBuilder.setCancelable(true);
				
				dialogBuilder.create().show();
				}
        	 });
		
		//The cancel button, set it to change activity on click
		CancelSave= (Button)findViewById(R.id.CancelEdit);
		CancelSave.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent= new Intent();
        		intent.setClass(Edit_contacts.this, IndividualScreen.class);
        		startActivity(intent);
				}
        	 });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_contacts, menu);
		return true;
	}

}
