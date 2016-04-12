package menus;

public class UserActionsMenu{
	
	private boolean changeUser;
	private boolean addUser;
	private boolean deleteCurrentUser;
	private boolean renameCurrentUser;
	private boolean exit;
	
	private int selectedUserIndex;
	
	public UserActionsMenu(){
	
		addUser = true;
		changeUser = false;
		deleteCurrentUser = false;
		renameCurrentUser = false;
		exit = false;
		
		selectedUserIndex = 0;
	}
	
	public void upOne(){
	
		if(addUser){
			
			addUser = false;
			exit = true;
		}
		
		else if(changeUser){
			
			changeUser = false;
			addUser = true;
		}
		
		else if(deleteCurrentUser){
			
			deleteCurrentUser = false;
			changeUser = true;
		}
		
		else if(renameCurrentUser){
			
			renameCurrentUser = false;
			deleteCurrentUser = true;
		}
		
		else{
			
			exit = false;
			renameCurrentUser = true;
		}
	}
	
	public void downOne(){
	
		if(addUser){
			addUser = false;
			changeUser = true;
		}
		
		else if(changeUser){
			
			changeUser = false;
			deleteCurrentUser = true;
		}
		
		else if(deleteCurrentUser){
			
			deleteCurrentUser = false;
			renameCurrentUser = true;
		}
		
		else if(renameCurrentUser){
			
			renameCurrentUser = false;
			exit = true;
		}
		
		else{
			
			exit = false;
			addUser = true;
		}
		
	}
	
	public boolean getAddUser(){
	
		return addUser;
	}
	
	public boolean getChangeUser(){
	
		return changeUser;
	}
	
	public boolean getDeleteCurrentUser(){
	
		return deleteCurrentUser;
	}
	
	public boolean getRenameCurrentUser(){
	
		return renameCurrentUser;
	}
	
	public boolean getExit(){
	
		return exit;
	}
	
	public int getSelectedUserIndex(){
		
		return selectedUserIndex;
	}
	
	public void userMenuUpOne(int amountOfUsers){
		
		if(selectedUserIndex > 0){
			
			selectedUserIndex --;
		}
		
		else{
			selectedUserIndex = amountOfUsers - 1;
		}
	}
	
	public void userMenuDownOne(int amountOfUsers){
		
		if(selectedUserIndex < amountOfUsers - 1){
			
			selectedUserIndex ++;
		}
		
		else{
			
			selectedUserIndex = 0;
		}
	}
}
