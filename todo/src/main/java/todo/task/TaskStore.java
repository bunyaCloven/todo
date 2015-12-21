package todo.task;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class TaskStore {
	private List<Task> tasks;

	public TaskStore() {
		tasks = new LinkedList<>();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		int i = 0;
		for (Task task : getTasks()) {
			result.append(++i);
			result.append("-");
			result.append(task.toString());
		}
		return result.toString();
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

	public List<Task> getSameDate(Date date) {
		List<Task> result = new LinkedList<>();
		for (Task task : tasks) {
			if (task.getDeadline().equals(date)) {
				result.add(task);
			}
		}
		return result;
	}

	public Task getTask(Integer input) {
		return tasks.get(input);
	}

	public List<Task> getDaily(Date date) {
		List<Task> result = new LinkedList<>();
		for (Task task : tasks) {
			if (TaskPeriod.DAILY.equals(task.getPeriod())) {
				result.add(task);
			}
		}
		return result;
	}
}
