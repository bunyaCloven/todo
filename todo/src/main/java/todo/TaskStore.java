package todo;

import java.util.LinkedList;
import java.util.List;

public class TaskStore {
	private List<Task> tasks;

	public TaskStore() {
		tasks = new LinkedList<>();
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public void removeTask(Task task) {
		tasks.remove(task);
	}

	public void clearTasks() {
		tasks.removeAll(tasks);
	}
}
