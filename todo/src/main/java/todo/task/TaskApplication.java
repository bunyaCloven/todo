package todo.task;

import todo.menu.Menu;
import todo.menu.MenuController;
import todo.menu.MenuView;
import todo.menu.type.MainMenu;

public class TaskApplication {

	public static void main(String... args) {
		TaskStore model = new TaskStore();
		TaskList view = new TaskList(model);
		Menu menu = new MainMenu(model, view);
		MenuView menuView = new MenuView(menu);
		new MenuController(menu, menuView).run();
	}

}
