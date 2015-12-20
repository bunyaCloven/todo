package todo;

public class TaskController {
	private TaskStore model;
	private TaskList view;

	public TaskController(TaskStore store, TaskList list) {
		model = store;
		view = list;
	}

}
