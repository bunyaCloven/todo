package todo.task;

import java.util.Date;
import java.util.List;

public class TaskList {
	private TaskStore store;

	public TaskList(TaskStore store) {
		setStore(store);
	}

	public TaskStore getStore() {
		return store;
	}

	public void setStore(TaskStore store) {
		this.store = store;
		refresh();
	}

	public void refresh() {
		// FIXME: empty
	}

	@Override
	public String toString() {
		return store.toString();
	}

	public void alertSameDate(Date date) {
		List<Task> tasks = store.getSameDate(date);
		System.out.println("============Alert============");
		for (Task task : tasks) {
			System.out.println(task.toString());
		}
		System.out.println("=============================");
	}

	public void alertDaily(Date date) {
		List<Task> tasks = store.getDaily(date);
		System.out.println("============Alert============");
		for (Task task : tasks) {
			System.out.println(task.toString());
		}
		System.out.println("=============================");
	}
}
