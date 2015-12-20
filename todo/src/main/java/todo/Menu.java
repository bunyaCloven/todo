package todo;

public class Menu {
	private MenuState status;

	public Menu() {
		status = MenuState.MAIN;
	}

	public String getAsString() {
		String result = null;
		switch (status) {
		case MAIN:
			result = ":a or :i for inserting a task";
			break;
		}
		return result;
	}

}
