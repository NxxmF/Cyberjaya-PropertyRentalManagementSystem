import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Agent extends PropertyManager{	//Property Agent class. Inherits from PropertyManager superclass due to shared functions with Owner

    private int licenseNum;	//Agent license number, set at registration

    public Agent(String userName, String password, String fullName, String contact, String email, String role, String status, int licenseNum) { //PropertyManager constructor creates files and directories for new agent accounts
    	super(userName, password, fullName, contact, email, role, status);																		//Agent constructor adds license number to the created info text file
		this.licenseNum = licenseNum;
		try {
			sendLicenseIDToFile();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    //Getter and setter for license number
    public int getLicenseNum() {
        return licenseNum;
    }
    public void setLicenseNum(int licenseNum) {
        this.licenseNum = licenseNum;
    }
    
    public void sendLicenseIDToFile() throws FileNotFoundException {	
    	File licenseID = new File(getPropertyManagerDir() + "/licenseID.txt"); // Creates text file storing agent's license number
		PrintWriter outputLicenseID =  new PrintWriter(licenseID); 
		outputLicenseID.println(licenseNum);
		outputLicenseID.close();
    }
    
}
