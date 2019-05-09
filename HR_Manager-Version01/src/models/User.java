
/**
 * User Interface
 */

package models;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface User extends Serializable {
	
	String getUserName();
	void setUserName(String userName);
	String getPassword() ;
	void setPassword(String password);
	
	static String verifyLogin(String userName, String password) {							// Veirfy Username and Password of a User
		
		List<User> users = User.loadUsers();
		boolean existUN = false;
		boolean correctPwd = false; 
		
		for(User u: users) {
			
			if(userName.equals(u.getUserName())) {
				
				existUN = true;
				if(password.equals(u.getPassword()))
					correctPwd = true;
				
			}
			
		}
		
		if(existUN == false)
			return "Incorrect Username";
		else if(correctPwd == false)
			return "Incorrect Password";
		else
			return "logInPass";
		
	}
	
	
	static ArrayList<User> loadUsers() {													// Load all Users to the system 
		
		List<User> users = new ArrayList<>();
		System.out.println();
		boolean cont = true;
		String fileName = "data/Files/user.ser";
		
		try(ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(fileName ))){
			
			 while(cont){
				 
                 Object obj=null;
                 
               try {
            	   
                   obj = objInput.readObject();
                   
               } catch (ClassNotFoundException e) {
            	   
                   e.printStackTrace();
                   
               }
                 if(obj != null && obj instanceof User) {
                	 
                    users.add((User)obj);
                                     	
                 }
                 else
                    cont = false;
              }
			 
		}
		catch(EOFException e) {
			//System.out.println("File Loaded");
		}
		catch(Exception e) {
			
			System.out.println("Error while loading users:" + e);
			
		}
		
		return (ArrayList<User>) users;
		
	}
	
	static void saveUsers(List<User> users) {												// Save all users to the data file
		
		String fileName = "data/Files/user.ser" ;
		File file = new File(fileName); 
		file.delete();
    
		try(ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(fileName,true))) {
			
			  for(User u: users) {
				  
				  objOutput.writeObject(u);
				  
			  }
			  
		  } catch(IOException e) {
			  
			  System.out.println("Error while saving users");
			  
		  }
		
	}
	
	static User getUser(String username) {													// get a User
		
		List<User> users = User.loadUsers();
		
		for(User u: users) {
			
			if(username.equals(u.getUserName())) 
			return u;
			
		}
		
		return null;
		
	}
	
}	
	