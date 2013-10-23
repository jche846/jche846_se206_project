package jche846.softeng206.contactsmanager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Edit_contacts extends Activity {
	DatabaseHandler db = new DatabaseHandler(this);

	//create button objects
	private Button SaveButton;
	private Button CancelSave;
	
	//edit text boxes
		private EditText editFirst;
		private EditText editLast;
		private EditText editMobile;
		private EditText editHome;
		private EditText editWork;
		private EditText editEmail;
		private EditText editHomeAdd;
		private EditText editDOB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_contacts);
		//Intent intent= getIntent();
		//All_contacts contact = (All_contacts) intent.getSerializableExtra("All_contacts");

		//Set the edit text boxes
		editFirst = (EditText)findViewById(R.id.editText1);
		editLast = (EditText)findViewById(R.id.editText2);
		editMobile = (EditText)findViewById(R.id.editText3);
		editHome = (EditText)findViewById(R.id.editText4);
		editWork = (EditText)findViewById(R.id.editText5);
		editEmail = (EditText)findViewById(R.id.editText6);
		editHomeAdd = (EditText)findViewById(R.id.editText7);
		editDOB = (EditText)findViewById(R.id.editText8);

		/**editFirst.setText(contact.getFirst(), TextView.BufferType.EDITABLE);
		editLast.setText(contact.getLast(), TextView.BufferType.EDITABLE);
		editMobile.setText(contact.getMobile(), TextView.BufferType.EDITABLE);
		editHome.setText(contact.getHome(), TextView.BufferType.EDITABLE);
		editWork.setText(contact.getWork(), TextView.BufferType.EDITABLE);
		editEmail.setText(contact.getEmail(), TextView.BufferType.EDITABLE);
		editHomeAdd.setText(contact.getHomeAddress(), TextView.BufferType.EDITABLE);
		editDOB.setText(contact.getDOB(), TextView.BufferType.EDITABLE); */
		
		
		//The save button, set it to change activity on click
		SaveButton= (Button)findViewById(R.id.SaveButton);
		SaveButton.setOnClickListener(new View.OnClickListener(){
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(Edit_contacts.this);
				dialogBuilder.setTitle("Confirmation.");
				dialogBuilder.setMessage("Are you sure you want to save the new changes made??");
				
				dialogBuilder.setNegativeButton("No",null);
				dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int Button) {
						
						Intent intent1= new Intent();
						intent1.setClass(Edit_contacts.this, MainActivity.class);
						startActivity(intent1);
						
					}
				});
				
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
        		intent.setClass(Edit_contacts.this, MainActivity.class);
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
