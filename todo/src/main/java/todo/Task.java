package todo;

import java.time.Instant;

public class Task {
	private String title;
	private TaskPeriod period;
	private TaskStatus status;
	private Instant deadline;

	@Override
	public String toString() {
		return title + ":" + period.toString();
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public TaskPeriod getPeriod() {
		return period;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public Instant getDeadline() {
		return deadline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
