package jche846.softeng206.contactsmanager;

public class All_contacts {
	int _id; //id
	String first;//first name
	String last;//last name
	String mobile;//mobile phone number
	String home;//home number
	String work;//work number
	String email;//email address
	String HomeAddress;//Home address
	String DateOfBirth;//DateOfBirth
	
	//empty constructor
	public All_contacts(){
		
	}
	//Constructor for id, first name, last name, mobile phone
	public All_contacts(int id, String first, String last, String mobile){
		this._id=id;
		this.first=first;
		this.last=last;
		this.mobile=mobile;
	}
	
	
	//Constructor for first name, last name, mobile phone	
	public All_contacts(String first, String last, String mobile){
		this.first=first;
		this.last=last;
		this.mobile=mobile;
	}
	
	//Constructor for all information.
	public All_contacts(int id, String first, String last, String mobile, String home, String work, String email, String HomeAdd, String DOB){
		this._id=id;
		this.first=first;
		this.last=last;
		this.mobile=mobile;
		this.home=home;
		this.work=work;
		this.email=email;
		this.HomeAddress=HomeAdd;
		this.DateOfBirth=DOB;
	}
	//Constructor for all information.
		public All_contacts(String first, String last, String mobile, String home, String work, String email, String HomeAdd, String DOB){
			this.first=first;
			this.last=last;
			this.mobile=mobile;
			this.home=home;
			this.work=work;
			this.email=email;
			this.HomeAddress=HomeAdd;
			this.DateOfBirth=DOB;
		}
	
	//Getters
	public int getID(){
		return this._id;
	}
	
	public String getFirst() {
		return this.first;
	}

	public String getLast() {
		return this.last;
	}

	public String getMobile() {
		return this.mobile;
	}
	
	public String getHome() {
		return this.home;
	}
	
	public String getWork() {
		return this.work;
	}
	
	public String getEmail() {
		return this.email;
	}
	public String getHomeAddress() {
		return this.HomeAddress;
	}
	
	public String getDOB() {
		return this.DateOfBirth;
	}
	
	//Setters
	public void setID(int id){
        this._id = id;
    }
	
	public void setFirst(String first){
		this.first=first;
	}
	
	public void setLast(String last){
		this.last=last;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public void setHome(String home) {
		this.home = home;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setHomeAddress(String HomeAdd) {
		this.HomeAddress = HomeAdd;
	}
	public void setDateOfBirth(String dob) {
		this.DateOfBirth = dob;
	}
	
	
	
	
	
}
