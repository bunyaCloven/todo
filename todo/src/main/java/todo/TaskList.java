package todo;

public class TaskList {
	private TaskStore store;

	public TaskStore getStore() {
		return store;
	}

	public void setStore(TaskStore store) {
		this.store = store;
		refresh();
	}

	public void refresh() {
		// FIXME: empty
	}
}
