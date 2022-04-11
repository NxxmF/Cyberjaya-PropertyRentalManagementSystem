import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

// Tenant model class
public class Tenant extends User{
	private static int lastID = 0;
	private int tenantID;
	private File tenantDir;
	private String propertyRent;
	
	// constructor to create tenant, set ID to lastID+1
	public Tenant(String userName, String password, String fullName, String contact, String email, String role, String status) {
		super(userName, password, fullName, contact, email, role, status);
		try {
			lastID = readLastID();
			this.tenantID = ++lastID;
			sendLastID(lastID);
			sendTenantToFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	// create Tenant from files
	public Tenant(int tenantID, String userName, String password, String fullName, String contact, String email, String role, String status) {
		super(userName, password, fullName, contact, email, role, status);
		this.tenantID = tenantID;
	}
	
	public int getTenantID() {
		return tenantID;
	}
	
	public void setTenantID(int tenantID) {
		this.tenantID = tenantID;
	}

    public String getPropertyRent() {
        return propertyRent;
    }
    public void setPropertyTent(String propertyRent) {
        this.propertyRent = propertyRent;
    }

    // read lastID file
    private int readLastID() throws FileNotFoundException {
    	File lastIDFile = new File("System/Tenant/LastID.txt");
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
			FileWriter LastIDFile = new FileWriter("System/Tenant/LastID.txt"); 
			PrintWriter outputNames =  new PrintWriter(LastIDFile);	
			outputNames.println(lastID);
			outputNames.close();
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}	
	}
    // write Tenant to files
    private void sendTenantToFile() throws FileNotFoundException{ // used to make a directory for Tenant folder
    	tenantDir = new File("System/Tenant/" + getUserName());
    	tenantDir.mkdir(); // make the directory using the Tenant name
    	//File propertiesFile = new File(tenantDir);
    	//propertiesFile.mkdir();
		File accountInfo = new File(tenantDir + "/accountInfo.txt"); // make a text file to store the tenant information
		PrintWriter outputManagerInfo =  new PrintWriter(accountInfo); // writes into the accountInfo.txt
		outputManagerInfo.println(getTenantID()); // move the info to the accountInfo.txt file
		outputManagerInfo.println(getUserName());
		outputManagerInfo.println(getPassword());
		outputManagerInfo.println(getFullName());
		outputManagerInfo.println(getContact());
		outputManagerInfo.println(getEmail());
		outputManagerInfo.println(getRole());
		outputManagerInfo.println(getStatus());
		outputManagerInfo.close(); // close accountInfo.txt file
	}
    public File getTenantDir() {
    	return tenantDir;
    }
}
