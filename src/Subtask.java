public class Subtask extends Task {
    private final int epicId;

    public Subtask(String nameTask, String description, Status status, int epicId) {
        super(nameTask, description, status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }
}
