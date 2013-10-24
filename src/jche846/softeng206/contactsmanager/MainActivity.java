package jche846.softeng206.contactsmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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

public class MainActivity extends Activity {
	DatabaseHandler db = new DatabaseHandler(this);
	private ListView listView;
	// Create button objects
	private Button buttonAdd;
	private Button sort1;
	private Button sort2;
	private Button sort3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayList = db.getAllContacts();
        //List View
        listView = (ListView)findViewById(R.id.contacts_screen);
        
        //sort by first
        sort1 = (Button)findViewById(R.id.sort_button_1);
        sort1.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				Collections.sort(displayList, new Comparator<All_contacts>(){
					@Override
					public int compare(All_contacts c1, All_contacts c2) {
						return c1.getFirst().toLowerCase().compareToIgnoreCase(c2.getFirst().toLowerCase());
					}
				});
				setUpListView();}
		});
        
        //sort by last
        sort2 = (Button)findViewById(R.id.sort_button_2);
        sort2.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				Collections.sort(displayList, new Comparator<All_contacts>(){
					@Override
					public int compare(All_contacts c1, All_contacts c2) {
						return c1.getLast().toLowerCase().compareToIgnoreCase(c2.getLast().toLowerCase());
					}
				});
				setUpListView();}
		});
        //sort by mobile
        sort3 = (Button)findViewById(R.id.sort_button_3);
        sort3.setOnClickListener(new View.OnClickListener() {
        	
			@Override
			public void onClick(View v) {
				Collections.sort(displayList, new Comparator<All_contacts>(){
					@Override
					public int compare(All_contacts c1, All_contacts c2) {
						return c1.getMobile().toLowerCase().compareTo(c2.getMobile().toLowerCase());
					}
				});
				setUpListView();}
		});
        
        //The add button, set it to change activity on click
        buttonAdd= (Button)findViewById(R.id.add);
        buttonAdd.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent= new Intent();
        		intent.setClass(MainActivity.this, Add_new_contact.class);
        		startActivity(intent);
				}
        	 });
        
        setUpListView();
    }
    
    /**private class CustomListAdapter extends ArrayAdapter<All_contacts>{
    	
    	CustomListAdapter(){
    		super(MainActivity.this, android.R.layout.simple_list_item_1, displayList);
    		//super(MainActivity.this, android.R.layout.simple_list_item_1, db.getAllContacts());
    	}
    	
    	@Override
    	public View getView(int position, View convertView, ViewGroup parent){
    		//Create a layout inflater to inflate our fml layout for each item in the list
    		LayoutInflater inflater = (LayoutInflater) MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		
    		//Inflate the list view item layout. Keep a reference to the inflated view. Note there is no view root specified
    		View listItemView = inflater.inflate(R.layout.custom_list_item_layout,null);
    		//Access text view elements inside the view
    		TextView first= (TextView)listItemView.findViewById(R.id.list_item_first_name);
    		TextView last= (TextView)listItemView.findViewById(R.id.list_item_last_name);
    		TextView mobile= (TextView)listItemView.findViewById(R.id.list_item_mobile_phone);
    		
    		//Set the text for each text view
    		first.setText(displayList.get(position).getFirst());
    		last.setText(displayList.get(position).getLast());
    		mobile.setText(displayList.get(position).getMobile());
    		
    		return listItemView;
    		
    	}
    }*/
    List<All_contacts> displayList = new ArrayList<All_contacts>();
    
    private void setUpListView(){
    	
    	//All_contacts contact = new All_contacts("James!", "Chen","02169666","64342341","43153141","jche846","2132112","04/13/1994");
    	//db.addContact(contact);
    	//displayList.add(contact);
    	
    	
    	ListAdapter listAdapter= new CustomListAdapter(this, android.R.layout.simple_list_item_1, displayList);
    	listView.setAdapter(listAdapter);
    	listView.setOnItemClickListener(new listItemClickedListener());
    	
    }
    
    
  //Custom adapter
  	class listItemClickedListener implements AdapterView.OnItemClickListener{

  		
  		@Override
  		public void onItemClick(AdapterView<?> parentView, View clickedView, int clickedViewPosition, long id) {
			Intent intent = new Intent();
			intent.putExtra("All_contacts", displayList.get(clickedViewPosition));
    		intent.setClass(MainActivity.this, IndividualScreen.class);
    		startActivity(intent);
  			
  		}
  		
  	}



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
	



