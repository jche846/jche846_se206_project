package jche846.softeng206.contactsmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
	int textlength = 0;
	// Search EditText
    EditText inputSearch;
    
    private CustomListAdapter adapter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayList = db.getAllContacts();
        
        //List View
        listView= (ListView)findViewById(R.id.contacts_screen);
        
        //search text
        inputSearch = (EditText) findViewById(R.id.inputSearch);
        
        
        //enabling search functionality
        
       /**putSearch.addTextChangedListener(new TextWatcher() {
        	
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
            	adapter.getFilter().filter(toString());  
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                    int arg3) {
                // TODO Auto-generated method stub

            }

           @Override
           public void afterTextChanged(Editable s) {
               // TODO Auto-generated method stub

           }
        });*/
        
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
	



