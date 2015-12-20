package todo;

public class TaskList {
	private TaskStore store;

	public TaskList(TaskStore store) {
		setStore(store);
	}

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

	@Override
	public String toString() {
		return store.toString();
	}
}
