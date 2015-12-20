package todo;

import java.util.Scanner;

public class Menu {
	private MenuState status;

	public Menu() {
		status = MenuState.MAIN;
	}

	public String getAsString() {
				
		Scanner input = new Scanner(System.in);
		
		String result = null;
		String subMenu = null;
		switch (status) {
		case MAIN:
			result = "TO DO LIST MENU \n 1) Press 1 for inserting a new task \n 2) Press 2 for listing all tasks \n";
			subMenu= input.next();
			
			switch(subMenu){
			case "1":
				status = MenuState.ADD_TASK;
				break;
			case "2":
				status = MenuState.LIST_TASKS;
			}
			break;
		case ADDTASK:
			result = "";
			break;
		}
		return result;
	}

}
