import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

// Main Class Driver
public class MainDriver {
	public static void main(String[] args) {
		ArrayList<Property> modelPropertyList = new ArrayList<>();
		try {
			modelPropertyList = readPropertiesFromFiles();
			
			SystemController controller = new SystemController(modelPropertyList, MyJFrame.getMyJFrame());
			controller.initLoginPage();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	// read all "approved" properties from files
	public static ArrayList<Property> readPropertiesFromFiles() throws FileNotFoundException {
		ArrayList<Property> propertyList = new ArrayList<>();
		File mainDir = new File("System/Property Manager/");
		File[] listOfManagersDir = mainDir.listFiles();
		for(File file : listOfManagersDir) {
			if(file.isDirectory()){
				File propertiesDir = new File(file.getPath() + "/Properties/");
				File[] propertiesOfManager = propertiesDir.listFiles();
				for(File property : propertiesOfManager) {
					File propertyInfo = new File(property.getPath() + "/propertyInfo.txt");
					File propertyPic = new File(property.getPath()+ "/propertyPics");
					String[] propertyPicPath = new String[propertyPic.list().length];
					for(int i = 0; i < propertyPicPath.length; ++i){
						 propertyPicPath[i] = "System/" + mainDir.getName() + "/" + file.getName() +"/" +  propertiesDir.getName() + "/" + property.getName() + "/" + propertyPic.getName() + "/" + propertyPic.list()[i];
						System.out.println(propertyPicPath[i]);
					}

					Scanner propertyInfoScanner = new Scanner(propertyInfo);
					while(propertyInfoScanner.hasNextLine()){
					Property readProperty = new Property(Integer.parseInt(propertyInfoScanner.nextLine()), //using the reading constructor (without incrementing the lastID)
							  propertyInfoScanner.nextLine(), 
							  Double.parseDouble(propertyInfoScanner.nextLine()), 
							  Integer.parseInt(propertyInfoScanner.nextLine()),
							  propertyPicPath,
							  new Address (propertyInfoScanner.nextLine(), propertyInfoScanner.nextLine()),
							  Integer.parseInt(propertyInfoScanner.nextLine()),
							  Integer.parseInt(propertyInfoScanner.nextLine()),
							  propertyInfoScanner.nextLine(),
							  propertyInfoScanner.nextLine(),
							  propertyInfoScanner.nextLine(),
							  propertyInfoScanner.nextLine(),
							  propertyInfoScanner.nextLine().split("\\|"),
							  propertyInfoScanner.nextLine().split("\\|"),
							  propertyInfoScanner.nextLine(),
							  propertyInfoScanner.nextLine(),
							  propertyInfoScanner.nextLine()
							  );
					if(readProperty.getPropertyApprovalStatus().equals("Approved"))
						propertyList.add(readProperty);
					}propertyInfoScanner.close();
				}
			}
		
		}
		return propertyList;
	}	
}
