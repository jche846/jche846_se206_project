package jche846.softeng206.contactsmanager;

import java.util.ArrayList;
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
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.Toast;

public class MainActivity extends Activity {
	DatabaseHandler db = new DatabaseHandler(this);
	private ListView listView;
	// Create button objects
	//private RadioButton radiobutton;
	//private Button buttonEdit;
	private Button buttonSort;
	private Button buttonAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayList = db.getAllContacts();
        //List View
        listView = (ListView)findViewById(R.id.contacts_screen);
        
       /** //The Edit button, set it to change activity on click
        buttonEdit= (Button)findViewById(R.id.edit);
        buttonEdit.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent= new Intent();
        		intent.setClass(MainActivity.this, IndividualScreen.class);
        		startActivity(intent);
				}
        	 });*/
        
        //The sort button, set it to change activity on click
        buttonSort= (Button)findViewById(R.id.sort);
        buttonSort.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View v) {
				
				Intent intent= new Intent();
        		intent.setClass(MainActivity.this, SortScreen.class);
        		startActivity(intent);
				}
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
    
    private class CustomListAdapter extends ArrayAdapter<All_contacts>{
    	
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
    }
    List<All_contacts> displayList = new ArrayList<All_contacts>();
    private void setUpListView(){
    	
    	//All_contacts contact = new All_contacts("James", "Chen","0216969696966","64342341","43153141","jche846","2132112","04/13/1994");
    	//db.addContact(contact);
    	//displayList.add(contact);
    	//displayList.add(new All_contacts("James", "chen","d","d","f","d","d","d"));
    	//displayList.add(new All_contacts("James", "Chen","0210432141"));
    	//displayList.add(new All_contacts("Robin", "Feng","364513422131"));
    	//displayList.add(new All_contacts("Alan", "Lau","6969696969"));
    	//displayList.add(new All_contacts("John", "Lee","3296969632131"));
    	
    	ListAdapter listAdapter= new CustomListAdapter();
    	listView.setAdapter(listAdapter);
    	listView.setOnItemClickListener(new listItemClickedListener());
    	
    }
    
    /**
    //Sorting methods (by first name, last name, mobile phone, email)
    private List<All_contacts> sortFirst(List<All_contacts> contactList){
    	List<All_contacts> displayList = new ArrayList<All_contacts>();
    	displayList.add(new All_contacts("Alan", "Lau","6969696969"));
    	displayList.add(new All_contacts("James", "Chen","0210432141"));
    	displayList.add(new All_contacts("John", "Lee","3296969632131"));
    	displayList.add(new All_contacts("Robin", "Feng","364513422131"));
    	return displayList;
    	
    }
    private List<All_contacts> sortLast(List<All_contacts> contactList){
    	List<All_contacts> displayList = new ArrayList<All_contacts>();
    	displayList.add(new All_contacts("James", "Chen","0210432141"));
    	displayList.add(new All_contacts("Robin", "Feng","364513422131"));
    	displayList.add(new All_contacts("Alan", "Lau","6969696969"));	
    	displayList.add(new All_contacts("John", "Lee","3296969632131"));
    	return displayList;
    	
    }
    private List<All_contacts> sortEmail(List<All_contacts> contactList){
    	List<All_contacts> displayList = new ArrayList<All_contacts>();
    	//emails in order
    	return displayList;
    	
    }
    private List<All_contacts> sortMobile(List<All_contacts> contactList){
    	List<All_contacts> displayList = new ArrayList<All_contacts>();
    	displayList.add(new All_contacts("James", "Chen","0210432141"));
    	displayList.add(new All_contacts("John", "Lee","3296969632131"));
    	displayList.add(new All_contacts("Robin", "Feng","364513422131"));
    	displayList.add(new All_contacts("Alan", "Lau","6969696969"));
    	return displayList;
    	
    }
    
    //Delete a contact
    private List<All_contacts> deleteContact(List<All_contacts> contactList){
    	List<All_contacts> displayList = new ArrayList<All_contacts>();
    	//removes 1 contact
    	displayList.add(new All_contacts("John", "Lee","3296969632131"));
    	displayList.add(new All_contacts("Robin", "Feng","364513422131"));
    	displayList.add(new All_contacts("Alan", "Lau","6969696969"));
    	return displayList;
    }*/
    
  //Custom adapter
  	class listItemClickedListener implements AdapterView.OnItemClickListener{

  		
  		@Override
  		public void onItemClick(AdapterView<?> parentView, View clickedView, int clickedViewPosition,
  				long id) {
  			All_contacts sc = db.getAllContacts().get(clickedViewPosition);
  			Intent intent= new Intent();
  			intent.putExtra("all_contacts", sc);
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
	



