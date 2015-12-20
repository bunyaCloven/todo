package todo.task;

import java.util.Date;

public class Task {
	private String title;
	private Date deadline;
	private TaskPeriod period;
	private TaskStatus status;

	public Task(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return title + ":" + deadline + "(" + period.toString() + ")";
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

	public Date getDeadline() {
		return deadline;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public void setPeriod(TaskPeriod period) {
		this.period = period;
	}
}
