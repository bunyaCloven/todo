package todo;

public class TaskController implements Runnable {
	private TaskStore model;
	private TaskList view;
	private Menu menu;
	private MenuView menuView;

	public TaskController(TaskStore store, TaskList list) {
		model = store;
		view = list;
		menu = new Menu();
		menuView = new MenuView(menu);
	}

	@Override
	public void run() {
		System.out.println(menuView.getAsString());
	}
}
