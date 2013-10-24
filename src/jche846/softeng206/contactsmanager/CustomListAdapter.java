package jche846.softeng206.contactsmanager;

	import java.util.List;
	import android.content.Context;
	import android.view.LayoutInflater;
	import android.view.View;
	import android.view.ViewGroup;
	import android.widget.ArrayAdapter;
	import android.widget.TextView;

	public class CustomListAdapter extends ArrayAdapter<All_contacts> {
		
		private List<All_contacts> displayList;
		private Context context;
		
		CustomListAdapter(Context context, int textViewResourceId, List<All_contacts> displayList) {
			super(context, textViewResourceId, displayList);
			
			this.displayList = displayList;
			this.context = context;
		}
		
		@Override
    	public View getView(int position, View convertView, ViewGroup parent){
    		//Create a layout inflater to inflate our fml layout for each item in the list
    		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		
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