package todo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Menu {
	private MenuState status;
	private TaskStore model;
	private TaskList view;
	private Task task;

	public Menu(TaskStore store, TaskList list) {
		model = store;
		view = list;
		status = MenuState.MAIN;
	}

	public String getCurrent() {
		String result = null;
		switch (status) {
		case MAIN:
			result = "TO DO LIST MENU \n "
					+ "Press 1 for inserting a new task \n "
					+ "Press 2 for listing all tasks \n" + "q to quit";
			break;
		case ADD_TASK:
			result = "Enter the title:";
			break;
		case ADD_DEADLINE:
			result = "Enter deadline(dd-MM-yyyy):";
			break;
		case ADD_PERIOD:
			result = "Enter period([N]ONE,[D]AILY,[W]EEKLY,[M]ONTHLY):";
			break;
		case LIST_TASKS:
			result = view.toString() + "\nPress any key to continue...";
			break;
		}
		return result;
	}

	public void processInput(String input) {
		switch (status) {
		case MAIN:
			main(input);
			break;
		case ADD_TASK:
			addTask(input);
			break;
		case ADD_DEADLINE:
			setDeadline(input);
			break;
		case ADD_PERIOD:
			setPeriod(input);
			break;
		default:
		}
	}

	private void main(String input) {
		switch (input) {
		case "1":
			status = MenuState.ADD_TASK;
			break;
		case "2":
			status = MenuState.LIST_TASKS;
			break;
		}
	}

	private void addTask(String input) {
		task = new Task(input);
		status = MenuState.ADD_DEADLINE;
	}

	private void setDeadline(String input) {
		Date date;
		try {
			date = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH)
					.parse(input);
			task.setDeadline(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		status = MenuState.ADD_PERIOD;
	}

	private void setPeriod(String input) {
		TaskPeriod period = null;
		switch (input.toLowerCase().charAt(0)) {
		case 'd':
			period = TaskPeriod.DAILY;
			break;
		case 'm':
			period = TaskPeriod.MONTHLY;
			break;
		case 'w':
			period = TaskPeriod.WEEKLY;
			break;
		case 'n':
			period = TaskPeriod.NONE;
			break;
		}
		task.setPeriod(period);
		model.addTask(task);
		status = MenuState.MAIN;
	}

}
