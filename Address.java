public class Address {		//Address object, used to store Project and the rest of the address together
	private String project;
	private String fullAddress;

	public Address(String project, String fullAddress) {	//Constructor for the Address project
		this.project = project;
		this.fullAddress = fullAddress;

	}
	//Getters and setters
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
}
