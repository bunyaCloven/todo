package todo;

public class MenuView {
	private Menu menu;

	public MenuView(Menu menu) {
		this.menu = menu;
	}

	public String getAsString() {
		return menu.getAsString();
	}

}
