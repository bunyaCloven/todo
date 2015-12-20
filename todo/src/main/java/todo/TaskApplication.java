package todo;

public class TaskApplication {

	public static void main(String... args) {
		TaskStore model = new TaskStore();
		TaskList view = new TaskList();
		TaskController controller = new TaskController(model, view);
		controller.run();
	}

}
