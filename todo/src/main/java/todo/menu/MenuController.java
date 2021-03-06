package todo.menu;

import java.util.Scanner;

public class MenuController implements Runnable {
	private Menu menu;
	private MenuView menuView;

	public MenuController(Menu model, MenuView view) {
		menu = model;
		menuView = view;
	}

	@Override
	public void run() {
		String option;
		do {
			System.out.print(menuView.getAsString());
			Scanner input = new Scanner(System.in);
			option = input.next();
			menu = menu.processInput(option);
			menuView.setMenu(menu);
		} while (option != "q");
	}
}
