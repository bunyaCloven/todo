package todo.menu.type;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import todo.menu.Menu;
import todo.task.TaskList;
import todo.task.TaskStore;

public class DateChangeMenu extends Menu {

	public DateChangeMenu(TaskStore store, TaskList list) {
		super(store, list);
	}

	@Override
	public String getCurrent() {
		return "Please enter a date to set as current date(dd-MM-yyyy):";
	}

	@Override
	public Menu processInput(String input) {
		try {
			Date date = new SimpleDateFormat("dd-MM-yyyy").parse(input);
			view.alertDaily(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new MainMenu(model, view);
	}

}
