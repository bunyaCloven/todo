package todo;

public class TaskApplication {

	public static void main(String... args) {
		TaskStore model = new TaskStore();
		TaskList view = new TaskList(model);
		Menu menu = new Menu(model, view);
		MenuView menuView = new MenuView(menu);
		new MenuController(menu, menuView).run();
	}

}
