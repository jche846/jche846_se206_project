package jche846.softeng206.contactsmanager;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.BaseAdapter;

public class IndividualScreen extends Activity {
	DatabaseHandler db = new DatabaseHandler(this);
	
	private ListView listView;
	private Button editButton;
	private Button deleteContact;
	private Button backButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_individual_screen);
		
		//The ListView
		listView=(ListView)findViewById(R.id.individual_screen);
		
		//Back to menu button
		backButton= (Button)findViewById(R.id.back);
		backButton.setOnClickListener(new View.OnClickListener(){

				@Override
				public void onClick(View v) {
					
					Intent intent= new Intent();
	        		intent.setClass(IndividualScreen.this, MainActivity.class);
	        		startActivity(intent);
					}
	        	 });
		
		//Edit Button
        editButton= (Button)findViewById(R.id.edit_contact);
        editButton.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent= new Intent();
        		intent.setClass(IndividualScreen.this, Edit_contacts.class);
        		startActivity(intent);
				}
        	 });
		
		//Delete Button
		deleteContact=(Button)findViewById(R.id.delete_contact);
		deleteContact.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				AlertDialog.Builder dialogBuilder=new AlertDialog.Builder(IndividualScreen.this);
				dialogBuilder.setTitle("Confirmation.");
				dialogBuilder.setMessage("Are you sure you want to delete this contact?");
				
				dialogBuilder.setNegativeButton("No",null);
				dialogBuilder.setPositiveButton("Yes",null); 
				dialogBuilder.setCancelable(true);
				
				dialogBuilder.create().show();
				
			}
		});	
		
		setUpListView();
	}
	
	private void setUpListView(){
		//Each individual contacts has 8 display items, 
		//Namely- first name, last name, mobile, home number, work number, email, date of birth, home address (not all have to be filled)
		
		//Create an array list to store the displays (Stub implementation for view an individual contact)
		Intent intent= getIntent();
		All_contacts contact = (All_contacts) intent.getSerializableExtra("All_contacts");
		List<String> displayList= new ArrayList<String>();
		
		displayList.add("First Name: " + contact.getFirst());//first
		displayList.add("Last Name: " + contact.getLast());//last
		displayList.add("Mobile Phone Number: "+ contact.getMobile());//mobile
		displayList.add("Home Number: " +contact.getHome());//home
		displayList.add("Work Number: " +contact.getWork());//work
		displayList.add("E-mail: "+contact.getEmail());//email
		displayList.add("Date Of Birth: " +contact.getDOB());//date of birth
		displayList.add("Home Address: " +contact.getHomeAddress());//home address
		
		//Create a new list Adapter object for listViews.
		ListAdapter listAdapter = new CustomListAdapter(IndividualScreen.this, displayList);
		listView.setAdapter(listAdapter);
		listView.setOnItemClickListener(new ListItemClickedListener());
				
	}
	//custom adapter
		class ListItemClickedListener implements AdapterView.OnItemClickListener{

			@Override
			public void onItemClick(AdapterView<?> parentView, View clickedView, int clickedViewPosition,
					long id) {
				String displayString= "You have selected this item";
						// Integer.toString(clickedViewPosition);
				Toast.makeText(clickedView.getContext(), displayString, Toast.LENGTH_LONG).show();
				
			}
			
		}
	
	
	private class CustomListAdapter extends ArrayAdapter<String>{
		
		CustomListAdapter(Context context, List<String> strings){
			super(context, android.R.layout.simple_list_item_1, strings);
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.individual_screen, menu);
		return true;
	}

}
	


