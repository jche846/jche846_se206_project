package jche846.softeng206.contactsmanager;

import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	//class which handles database creation and upgrades
	
	//Database version
	private static final int DATABASE_VERSION = 1;
	
	//Database Name
	private static final String DATABASE_NAME = "contactsManager";
	
	//Contacts table name
	private static final String TABLE_CONTACTS= "contacts";
	
	//Contacts Table Column names
	private static final String COLUMN_ID = "id";
	private static final String COLUMN_FIRST = "first";
	private static final String COLUMN_LAST = "last";
	private static final String COLUMN_MOBILE = "mobile";
	private static final String COLUMN_HOME = "home";
	private static final String COLUMN_WORK = "work";
	private static final String COLUMN_EMAIL = "email";
	private static final String COLUMN_HOMEADD = "homeadd";
	private static final String COLUMN_DOB = "dob";
	
	String CREATE_CONTACTS_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + "("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," 
    		+ COLUMN_FIRST + " TEXT,"
            + COLUMN_LAST + " TEXT," 
    		+ COLUMN_MOBILE +" TEXT," 
    		+ COLUMN_HOME +" TEXT,"
    		+ COLUMN_WORK +" TEXT,"
    		+ COLUMN_EMAIL +" TEXT,"
    		+ COLUMN_HOMEADD +" TEXT,"
    		+ COLUMN_DOB +" TEXT);";
	
	private static final String DELETE_CONTACTS_TABLE = "DROP TABLE IF EXISTS " + TABLE_CONTACTS;
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);	
	}
	
	 // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_CONTACTS_TABLE);
    }
    
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL(DELETE_CONTACTS_TABLE);
 
        // Create tables again
        onCreate(db);
    }
    
    /**
     * The following methods are implemented to handle data in the database.
     */
    
  //Adding a new contact, this method accepts Contact object as parameter. Once data is inserted in database it needs to be closed.
    public void addContact(All_contacts contact){
    	SQLiteDatabase db = this.getWritableDatabase();
    	
    	ContentValues values = new ContentValues();
    	values.put(COLUMN_FIRST, contact.getFirst()); // Contact first name
    	values.put(COLUMN_LAST, contact.getLast()); // Contact last name
        values.put(COLUMN_MOBILE,contact.getMobile()); // Contact mobile phone number
        values.put(COLUMN_HOME,contact.getHome()); // Contact home phone number
        values.put(COLUMN_WORK,contact.getWork()); // Contact work phone number
        values.put(COLUMN_EMAIL,contact.getEmail()); // Contact email address
        values.put(COLUMN_HOMEADD,contact.getHomeAddress()); // Contact home address
        values.put(COLUMN_DOB,contact.getDOB()); // Contact date of birth
        
        //Inserts data into a row
        db.insert(TABLE_CONTACTS, null, values);
        db.close();   
    }
    
    // Getting all the informations of a single contact by reading information of its row.
    public All_contacts getContact(int id){
    	SQLiteDatabase db = this.getReadableDatabase();
    	
    	//Cursor to enumerate through the rows of a contact.
    	Cursor cursor = db.query(TABLE_CONTACTS, new String[] { COLUMN_ID,
    			COLUMN_FIRST, COLUMN_LAST, COLUMN_MOBILE, COLUMN_HOME, 
    			COLUMN_WORK, COLUMN_EMAIL, COLUMN_HOMEADD, COLUMN_DOB }, COLUMN_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
     
        All_contacts contact = new All_contacts(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3), 
                cursor.getString(4), cursor.getString(5), cursor.getString(6),
                cursor.getString(7), cursor.getString(8));
        return contact;
    }
    
    //This method returns all the contacts in the database by looping through each contact and storing it in an array list of contact class type.
    
    public List<All_contacts> getAllContacts() {
    	//Create a new arrayList of contact class type
        List<All_contacts> contactList = new ArrayList<All_contacts>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_CONTACTS;
     
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
     
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                All_contacts contact = new All_contacts();
                contact.setID(Integer.parseInt(cursor.getString(0)));
                contact.setFirst(cursor.getString(1));
                contact.setLast(cursor.getString(2));
                contact.setMobile(cursor.getString(3));
                contact.setHome(cursor.getString(4));
                contact.setWork(cursor.getString(5));
                contact.setEmail(cursor.getString(6));
                contact.setHomeAddress(cursor.getString(7));
                contact.setDateOfBirth(cursor.getString(8));
                
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }
    
    //This method will return the total number of contacts in the database
    public int getContactsCount() {
        String countQuery = "SELECT  * FROM " + TABLE_CONTACTS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }
    
    //This method will update the edit made to an existing contact
    public int updateContact(All_contacts contact) {
        SQLiteDatabase db = this.getWritableDatabase();
     
        ContentValues values = new ContentValues();
        values.put(COLUMN_FIRST, contact.getFirst()); // Contact first name
    	values.put(COLUMN_LAST, contact.getLast()); // Contact last name
        values.put(COLUMN_MOBILE,contact.getMobile()); // Contact mobile phone number
        values.put(COLUMN_HOME,contact.getHome()); // Contact home phone number
        values.put(COLUMN_WORK,contact.getWork()); // Contact work phone number
        values.put(COLUMN_EMAIL,contact.getEmail()); // Contact email address
        values.put(COLUMN_HOMEADD,contact.getHomeAddress()); // Contact home address
        values.put(COLUMN_DOB,contact.getDOB()); // Contact date of birth
        
        // updating row
        return db.update(TABLE_CONTACTS, values, COLUMN_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
    }
    
    //This method will delete a single contact
    public void deleteContact(All_contacts contact) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CONTACTS, COLUMN_ID + " = ?",
                new String[] { String.valueOf(contact.getID()) });
        db.close();
    }
	
}
