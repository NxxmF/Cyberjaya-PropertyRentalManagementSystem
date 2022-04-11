import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Owner extends PropertyManager{     //Property Owner class. Extends PropertyManager superclass due to shared functions with Agent class.
    private ArrayList<String> grants = new ArrayList<>();   //List of grants for particular owner

    public Owner(String userName, String password, String fullName, String contact, String email, String role, String status) {
    	super(userName, password, fullName, contact, email, role, status);  //Constructor for new Owner accounts, user PropertyManager constructor to create files and directories
    	
    }
    //Getters and setters for grants
    public ArrayList<String> getGrants() {
        return grants;
    }
    public void setGrants(ArrayList<String> grants) {
        this.grants = grants;
    }
    public void addToGrantList(String newGrant) {
        this.grants.add(newGrant);
        try {
			sendGrantsToFile(newGrant);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    //Creates grants file in Owner directory
    public void sendGrantsToFile(String grant) throws IOException {
    	FileWriter grantsFile = new FileWriter(getPropertyManagerDir() + "/grants.txt", true); // make a text file to store the owner's grant number
		PrintWriter outputLicenseID =  new PrintWriter(grantsFile); 
		outputLicenseID.println(grant);
		outputLicenseID.close();
    }
}
