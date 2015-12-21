package todo.menu.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import todo.menu.Menu;
import todo.menu.state.AddMenuState;
import todo.task.Task;
import todo.task.TaskList;
import todo.task.TaskPeriod;
import todo.task.TaskStatus;
import todo.task.TaskStore;

public class AddTaskMenu extends Menu {
	private Task task;
	private AddMenuState status;

	public AddTaskMenu(TaskStore store, TaskList list) {
		super(store, list);
		status = AddMenuState.ADD_TASK;
	}

	@Override
	public String getCurrent() {
		String result = null;
		switch (status) {
		case ADD_TASK:
			result = "Enter the title:";
			break;
		case ADD_DEADLINE:
			result = "Enter deadline(dd-MM-yyyy):";
			break;
		case ADD_PERIOD:
			result = "Enter period([O]NE_TIME,[D]AILY,[W]EEKLY,[M]ONTHLY):";
			break;
		case ADD_STATUS:
			result = "Enter status([D]one, [S]tarted, [P]ending):";
			break;
		}
		return result;
	}

	public Menu processInput(String input) {
		switch (status) {
		case ADD_TASK:
			addTask(input);
			break;
		case ADD_DEADLINE:
			setDeadline(input);
			break;
		case ADD_PERIOD:
			setPeriod(input);
			break;
		case ADD_STATUS:
			setStatus(input);
			model.addTask(task);
			return new MainMenu(model, view);
		}
		return this;
	}

	private void addTask(String input) {
		task = new Task(input);
		status = AddMenuState.ADD_DEADLINE;
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
		status = AddMenuState.ADD_PERIOD;
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
		case 'o':
			period = TaskPeriod.ONE_TIME;
			break;
		}
		status = AddMenuState.ADD_STATUS;
		task.setPeriod(period);
	}

	private void setStatus(String input) {
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
	}
}
