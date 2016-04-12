package savedData;

import java.util.ArrayList;

public class AllUsers{
	
	private ArrayList<User> users;
	
	private int currentUserIndex;
	
	public AllUsers(){
	
		users = new ArrayList<User>();
	}
	
	public void setCurrentUserIndex(int currentUserIndexIn){
	
		currentUserIndex = currentUserIndexIn;
	}
	
	public void addUser(User user){
	
		users.add(user);
	}
	
	public void setUser(int index, User user){
	
		users.set(index, user);
	}
	
	public User getUser(){
	
		return users.get(currentUserIndex);
	}
	
	public User getUser(int index){
	
		return users.get(index);
	}
	
	public int getSize(){
	
		return users.size();
	}
	
	public void remove(int index){
	
		users.remove(index);
	}
	
	public void remove(){
	
		users.remove(currentUserIndex);
	}
	
	public boolean setCurrentUserUsingUserName(String userName){
		
		String userNameOfIndexI;
		
		for(int i = 0; i < users.size(); i ++){
			
			userNameOfIndexI = users.get(i).getUserName();
			if(userNameOfIndexI.contentEquals(userName)){
				currentUserIndex = i;
				return true;
			}
		}
		return false;
	}
	
	public int getIndexOfUserWithUserName(String userName){
	
		String userNameOfIndexI;
		
		for(int i = 0; i < users.size(); i ++){
			
			userNameOfIndexI = users.get(i).getUserName();
			if(userNameOfIndexI.contentEquals(userName)){
				return i;
			}
		}
		return - 1;
	}
}
