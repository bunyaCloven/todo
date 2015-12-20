package todo;

public class MenuController implements Runnable {
	private Menu menu;
	private MenuView menuView;

	public MenuController() {
		menu = new Menu();
		menuView = new MenuView(menu);
	}

	@Override
	public void run() {
		System.out.println(menuView.getAsString());
	}
}
