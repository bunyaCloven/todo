package todo.menu.type;

import todo.menu.Menu;
import todo.task.Task;
import todo.task.TaskList;
import todo.task.TaskStatus;
import todo.task.TaskStore;

public class TaskEditStatusMenu extends Menu {
	Task task;

	public TaskEditStatusMenu(TaskStore store, TaskList list, Integer input) {
		super(store, list);
		task = store.getTask(input);
	}

	@Override
	public String getCurrent() {
		return "Enter new status([D]one, [S]tarted, [P]ending):";
	}

	@Override
	public Menu processInput(String input) {
		TaskStatus status = null;
		switch (input.toLowerCase().charAt(0)) {
		case 'd':
			status = TaskStatus.DONE;
			break;
		case 's':
			status = TaskStatus.STARTED;
			break;
		case 'p':
			status = TaskStatus.PENDING;
			break;
		}
		task.setStatus(status);
		return new MainMenu(model, view);
	}

}
