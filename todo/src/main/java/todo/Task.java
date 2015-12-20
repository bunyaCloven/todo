package todo;

import java.time.Instant;

public class Task {
	private TaskPeriod period;
	private TaskStatus status;
	private Instant deadline;

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
}
