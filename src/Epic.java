import java.util.ArrayList;
import java.util.List;


public class Epic extends Task {
   private  List<Integer> subtaskIds = new ArrayList<>() {};
   // Status status = Status.NEW;
    public Epic(String nameTask, String description) {
        this.nameTask = nameTask;
        this.description = description;
        this.id = TasksManager.counter;
        this.status = Status.NEW;
        TasksManager.counter++;
    }

    public void setEpicSubtaskId(int subtaskId){
        subtaskIds.add(subtaskId);
    }

    public List<Integer> getSubtaskIds() {
        return subtaskIds;
    }


}
