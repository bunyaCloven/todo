package todo.menu.type;

import todo.menu.Menu;
import todo.task.TaskList;
import todo.task.TaskStore;

public class MainMenu extends Menu {

	public MainMenu(TaskStore store, TaskList list) {
		super(store, list);
	}

	@Override
	public String getCurrent() {
		return "TO DO LIST MENU \n" + "Enter 1 to insert a new task \n"
				+ "2 to list all tasks \n" + "3 to change the current date\n"
				+ "4 to the tasks of a date" + "q to quit:";
	}

	@Override
	public Menu processInput(String input) {
		switch (input) {
		case "1":
			return new AddTaskMenu(model, view);
		case "2":
			return new ListTasksMenu(model, view);
		case "3":
			return new DateChangeMenu(model, view);
		case "4":
			return new DateQueryMenu(model, view);
		case "q":
			System.exit(0);
		default:
			return this;
		}
	}

}
