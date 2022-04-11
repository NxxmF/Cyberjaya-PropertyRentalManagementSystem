import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// property manager model class, parent of agent and owner classes
public abstract class PropertyManager extends User{
	private static int lastID = 0;
	private int propertyManagerID;
	private File propertyManagerDir;
	private ArrayList<Property> propertyList;
	
	// constructor to create agent and owner, set ID to lastID+1
	public PropertyManager(String userName, String password, String fullName, String contact, String email, String role, String status) {
		super(userName, password, fullName, contact, email, role, status);
		try {
			lastID = readLastID();
			this.propertyManagerID = ++lastID;
			sendLastID(lastID);
			sendManagerToFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// create property manager from files
	public PropertyManager(int propertyManagerID, String userName, String password, String fullName, String contact, String email, String role, String status) {
		super(userName, password, fullName, contact, email, role, status);
		this.propertyManagerID = propertyManagerID;
	}
	
	public int getPropertyManagerID() {
		return propertyManagerID;
	}
	
	public void setPropertyManagerID(int propertyManagerID) {
		this.propertyManagerID = propertyManagerID;
	}

    public ArrayList<Property> getPropertyList() {
        return propertyList;
    }
    public void setPropertyList(ArrayList<Property> propertyList) {
        this.propertyList = propertyList;
    }
    public void addToPropertyList(Property newProperty){
        this.propertyList.add(newProperty);
    }
    // read lastID file
    private int readLastID() throws FileNotFoundException {
    	File lastIDFile = new File("System/Property Manager/LastID.txt");
    	if(lastIDFile.exists()) {
    		Scanner lastIDScanner = new Scanner(lastIDFile);
    		int lastIDread = lastIDScanner.nextInt();
    		lastIDScanner.close();
    		return lastIDread;
    	}
    	else
    		return 0;
    	
    }
    
    private void sendLastID(int lastID){ // set the lastID file to the new one.
		try{
			FileWriter LastIDFile = new FileWriter("System/Property Manager/LastID.txt"); 
			PrintWriter outputNames =  new PrintWriter(LastIDFile);	
			outputNames.println(lastID);
			outputNames.close();
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}	
	}
    // write property manager to files
    private void sendManagerToFile() throws FileNotFoundException{ // used to make a directory for the property manager
    	propertyManagerDir = new File("System/Property Manager/" + getUserName());
    	propertyManagerDir.mkdir(); // make the directory using the property manager name
    	File propertiesFile = new File(propertyManagerDir + "/Properties/");
    	propertiesFile.mkdir();
		File accountInfo = new File(propertyManagerDir + "/accountInfo.txt"); // make a text file to store the property manager information
		PrintWriter outputManagerInfo =  new PrintWriter(accountInfo); // writes into the accountInfo.txt
		outputManagerInfo.println(getPropertyManagerID()); // move the info to the accountInfo.txt file
		outputManagerInfo.println(getUserName());
		outputManagerInfo.println(getPassword());
		outputManagerInfo.println(getFullName());
		outputManagerInfo.println(getContact());
		outputManagerInfo.println(getEmail());
		outputManagerInfo.println(getRole());
		outputManagerInfo.println(getStatus());
		outputManagerInfo.close(); // close accountInfo.txt file
	}
    public File getPropertyManagerDir() {
    	return propertyManagerDir;
    }
}
