package todo.menu;

import todo.task.TaskList;
import todo.task.TaskStore;

public abstract class Menu {
	protected TaskStore model;
	protected TaskList view;

	public Menu(TaskStore store, TaskList list) {
		model = store;
		view = list;
	}

	public abstract String getCurrent();

	public abstract Menu processInput(String input);

}
