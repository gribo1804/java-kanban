
public class Task {

    protected int id = 0;
    protected String nameTask;
    protected String description;

    protected Status status;

    public Task(String nameTask, String description, Status status) {
        this.nameTask = nameTask;
        this.description = description;
        this.status = status;
        this.id = TasksManager.counter;
        TasksManager.counter++;
    }

     public Task() {

    }

    public int getId() {
        return this.id;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    protected String getName() {
        return nameTask;
    }

    protected Status getStatus() {
        return status;
    }

    protected String getDescription() {
        return description;
    }

    protected void updateDescription(String description) {
        this.description = description;

    }

    protected void updateName(String nameTask) {
        this.nameTask = nameTask;

    }

    protected void updateStatus(Status status) {
        this.status = status;

    }

    @Override
    public String toString() {
        return "Task{" +
                "nameTask='" + nameTask + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
