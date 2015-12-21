package todo.menu.type;

import todo.menu.Menu;
import todo.task.TaskList;
import todo.task.TaskStore;

public class ListTasksMenu extends Menu {

	public ListTasksMenu(TaskStore store, TaskList list) {
		super(store, list);
	}

	@Override
	public String getCurrent() {
		return view.toString()
				+ "\nEnter a number to edit a task's status, anything else to go back to main menu:";
	}

	@Override
	public Menu processInput(String input) {
		if (input.matches("-?\\d+(\\.\\d+)?")) {
			return new TaskEditStatusMenu(model, view,
					Integer.parseInt(input) - 1);
		} else {
			return new MainMenu(model, view);
		}
	}

}
