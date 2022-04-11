import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

// property model class
public class Property {
	private static int lastID; // holds last property ID, used to set new propertyID to lastID + 1
    private int propertyID; // property unique identifier
	private String propertyName; // property name
	private double price; // rent price
	private int size; // property size
	private String[] propertyPicturePath; //property picture paths
	private Address propertyAddress; 
	private int bedRoomsNum;   // number of bedrooms
	private int bathRoomsNum;  // number of bathrooms
	private String propertyType;  
    private String furnishing;   // types of furnishing
	private String propertyActivationStatus;  // activate/deactivate status
	private String propertyApprovalStatus;    // approval from admin status
	private String[] availableFacilities; // property facilities 
	private String[] availableFeatures;  // property features
	private String description;
	private String tenantName;
	private String agentName;
	
	// main constructor, used to create properties that are read from files
	public Property(int propertyID,String propertyName,double price,int size, String[] propertyPicturePath,Address propertyAddress, 
					int bedRoomsNum, int bathRoomsNum, String propertyType, String furnishing,   String propertyActivationStatus,
                                        String propertyApprovalStatus, String[] availableFacilities, String[] availableFeatures,
                                        String description, String tenantName, String agentName) {
											
        this.propertyID = propertyID;
		this.propertyName = propertyName;
        this.size = size;
		this.price = price;
		this.propertyPicturePath = propertyPicturePath;
        this.propertyAddress = propertyAddress;
		this.bathRoomsNum= bathRoomsNum;
		this.bedRoomsNum = bedRoomsNum;
		this.propertyType = propertyType;
        this.furnishing = furnishing;
        this.propertyActivationStatus = propertyActivationStatus;
        this.propertyApprovalStatus = propertyApprovalStatus;
        this.availableFacilities = availableFacilities;
        this.availableFeatures = availableFeatures;
        this.description = description;
        this.tenantName = tenantName;
        this.agentName = agentName;
	}
		
	// constructor to write property to files, will set propertyID according to lastID
	public Property(String propertyName,double price,int size, Address propertyAddress, 
			int bedRoomsNum, int bathRoomsNum, String propertyType, String furnishing,   String propertyActivationStatus,
                                String propertyApprovalStatus, String[] availableFacilities, String[] availableFeatures,
                                String description, String tenantName, String agentName) {

		this.propertyName = propertyName;
		this.size = size;
		this.price = price;
		this.propertyAddress = propertyAddress;
		this.bathRoomsNum= bathRoomsNum;
		this.bedRoomsNum = bedRoomsNum;
		this.propertyType = propertyType;
		this.furnishing = furnishing;
		this.propertyActivationStatus = propertyActivationStatus;
		this.propertyApprovalStatus = propertyApprovalStatus;
		this.availableFacilities = availableFacilities;
		this.availableFeatures = availableFeatures;
		this.description = description;
		this.tenantName = tenantName;
		this.agentName = agentName;
		
		try {
			lastID = readPropertyLastID();
			this.propertyID = ++lastID;
			sendPropertyLastID(lastID);
	        this.savePropertyFile();
	    } catch (IOException ex) {
	       System.out.println(ex.getMessage());
	    }
	}

	// read lastID file, if not found(first property to create) return 0
	private int readPropertyLastID() throws FileNotFoundException {
		File lastIDFile = new File("System/Property Manager/PropertyLastID.txt");
		if(lastIDFile.exists()) {
			Scanner lastIDScanner = new Scanner(lastIDFile);
			int lastIDread =lastIDScanner.nextInt();
			lastIDScanner.close();
			return lastIDread;
		}
		else
			return 0;
		
	}

	private void sendPropertyLastID(int lastID){ // set the lastID file to the new one.
		try{
			FileWriter LastIDFile = new FileWriter("System/Property Manager/PropertyLastID.txt"); 
			PrintWriter outputNames =  new PrintWriter(LastIDFile);	
			outputNames.println(lastID);
			outputNames.close();
		}
		catch(IOException ex){
			System.out.println(ex.getMessage());
		}	
	}

	// save property to files
	public final void savePropertyFile() throws IOException{
		new File("System\\Property Manager\\" + agentName + "\\Properties\\"+ propertyID + "\\propertyPics\\").mkdirs();                // code for making order file in directory
		File propertyInfo = new File("System\\Property Manager\\" + agentName + "\\Properties\\" + propertyID + "\\propertyInfo.txt"); //Adds order filename to names.txt file. Used to fetch order file names later.
		FileWriter propertyFileWriter = new FileWriter(propertyInfo, false);
		PrintWriter propertyPrintWriter = new PrintWriter(propertyFileWriter);
	
		propertyPrintWriter.println(propertyID);
		propertyPrintWriter.println(propertyName);
		propertyPrintWriter.println(price);
		propertyPrintWriter.println(size);
		propertyPrintWriter.println(propertyAddress.getProject());
		propertyPrintWriter.println(propertyAddress.getFullAddress());
		propertyPrintWriter.println(bedRoomsNum);
		propertyPrintWriter.println(bathRoomsNum);
		propertyPrintWriter.println(propertyType);
		propertyPrintWriter.println(furnishing);
		propertyPrintWriter.println(propertyActivationStatus);
		propertyPrintWriter.println(propertyApprovalStatus);
		
		for (String s : getAvailableFacilities()){ // split facilities / features using "|"
				propertyPrintWriter.print(s + "|");
		}
		propertyPrintWriter.print("\n");
		
		for (String s : getAvailableFeatures()){
				propertyPrintWriter.print(s + "|");
		}
		propertyPrintWriter.print("\n");
		
		propertyPrintWriter.println(description);
		propertyPrintWriter.println(tenantName);
		propertyPrintWriter.println(agentName);      
	
		propertyPrintWriter.close();
		propertyFileWriter.close();

	}

	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public int getPropertyID() {
		return propertyID;
	}
	public void setPropertyID(int propertyID) {
		this.propertyID = propertyID;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
        public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String[] getPropertyPicturePath() {
		return propertyPicturePath;
	}
	public void setPropertyPicturePath(String[] propertyPicturePath) {
		this.propertyPicturePath = propertyPicturePath;
	}
	public Address getPropertyAddress() {
		return propertyAddress;
	}
	public void setPropertyAddress(Address propertyAddress) {
		this.propertyAddress = propertyAddress;
	}
	public int getBedRoomsNum() {
		return bedRoomsNum;
	}
	public void setBedRoomsNum(int bedRoomsNum) {
		this.bedRoomsNum = bedRoomsNum;
	}
	public int getBathRoomsNum() {
		return bathRoomsNum;
	}
	public void setBathRoomsNum(int bathRoomsNum) {
		this.bathRoomsNum = bathRoomsNum;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
        public String getFurnishing() {
		return furnishing;
	}
	public void setFurnishing(String furnishing) {
		this.furnishing = furnishing;
	}
	public String getPropertyActivationStatus() {
		return propertyActivationStatus;
	}
	public void setPropertyActivationStatus(String propertyActivationStatus) {
		this.propertyActivationStatus = propertyActivationStatus;
	}
	public String[] getAvailableFacilities() {
		return availableFacilities;
	}
	public void setAvailableFacilities(String[] availableFacilities) {
		this.availableFacilities = availableFacilities;
	}
	public String getPropertyApprovalStatus() {
		return propertyApprovalStatus;
	}
	public void setPropertyApprovalStatus(String propertyApprovalStatus) {
		this.propertyApprovalStatus = propertyApprovalStatus;
	}
	public String[] getAvailableFeatures() {
		return availableFeatures;
	}
	public void setAvailableFeatures(String[] availableFeatures) {
		this.availableFeatures = availableFeatures;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTenantName() {
		return tenantName;
	}
	public void setTenantName(String tenantName) {
		this.tenantName = tenantName;
	}
	public String getAgentName() {
		return agentName;
	}
	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}
	// calculate rent rate
	public double getRentalRate() {
		double rentalRate = price/ size;
		BigDecimal bd = new BigDecimal(rentalRate).setScale(2, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}
	
}
