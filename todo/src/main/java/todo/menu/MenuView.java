package todo.menu;

public class MenuView {
	private Menu menu;

	public MenuView(Menu menu) {
		this.menu = menu;
	}

	public String getAsString() {
		return menu.getCurrent();
	}

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}
