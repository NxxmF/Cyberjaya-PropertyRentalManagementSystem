// user model class
public class User {
    private int userID;
    private String userName;
    private String password;
    private String fullName;
    private String contact;
    private String email;
    private String role;
    private String status;
    
	// create user objects from files
    public User(int userID,String userName,String password,String fullName,String contact,String email,String role,String status){
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.contact = contact;
        this.email = email;
        this.role = role;
        this.status = status;
    }
    public User(String userName,String password,String fullName,String contact,String email,String role,String status){
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.contact = contact;
        this.email = email;
        this.role = role;
        this.status = status;
    }
    
    public int getUserID(){
        return userID;
    }
    
    public String getUserName(){
        return userName;
    }
    
    public String getPassword(){
        return password;
    }
    
    public String getFullName(){
        return fullName;
    }
    
    public String getContact(){
        return contact;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getRole(){
        return role;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setUserID(int userID){
        this.userID = userID;
    }
    
    public void setUserName(String userName){
        this.userName = userName;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    
    public void setContact(String contact){
        this.contact = contact;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setRole(String role){
        this.role = role;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
}
