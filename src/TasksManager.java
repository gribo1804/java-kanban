import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TasksManager {
    //    static Integer id = 0;
    public static int counter = 1;

    static HashMap<Integer, Task> tasksMap = new HashMap<>();

    private HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private HashMap<Integer, Epic> epics = new HashMap<Integer, Epic>();

//    public  Integer genID() {
//
//        return id++;
//    }

    public int addTask(Task task) {
        tasksMap.put(task.getId(), task);
        return task.getId();
    }


    public int addEpic(Epic epic) {
        epics.put(epic.getId(), epic);
        return epic.getId();
    }

    public Task getTaskById(int id) {
        return tasksMap.get(id);
    }

    public Subtask getSubtaskById(int id) {
        return subtasks.get(id);
    }
//    public Epic getEpicById(int id) {
//        return epics.get(id);
//    }
// В этом метоте прото добавляется subtask
    public int addSubtask(Subtask subtask) {
        // В этом метоте прото добавляется subtask
        subtasks.put(subtask.getId(), subtask);
        return subtask.getId();
    }

    public Collection<Task> getAllTasks() {

        return tasksMap.values();
    }

    public Collection<Epic> getAllEpics() {

        return epics.values();
    }
//    public static void getALLRemoveTask() {
//
//        tasksMap.clear();
//
//    }

    public void removeTaskById(int id) {

        tasksMap.remove(id);

    }

    public void removeEpicById(int id) {
        for (Subtask sub : getEpicSubtask(id)) {
            subtasks.remove(sub.getId());
        }
        epics.remove(id);

    }

    public void updateTask(Task task) {
        tasksMap.put(task.getId(), task);
    }

    public void updateSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(),subtask);
        for(Epic epic : epics.values()){
           if(getEpicSubtask(epic.getId()).contains(subtask)){
               epic.setStatus(getEpicStatus(epic.getId()));
           }
        }
    }

    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }

    public ArrayList<Subtask> getEpicSubtask(int id) {
        ArrayList<Subtask> result = new ArrayList<>();
        for (Integer subId : epics.get(id).getSubtaskIds()) {
            result.add(subtasks.get(subId));
        }
        return result;
    }

    public void addSubtaskToEpic(int epicId, int subId){
        epics.get(epicId).setEpicSubtaskId(subId);
        epics.get(epicId).setStatus(getEpicStatus(epicId));
    }

    public Collection<Subtask> getAllSubtasks() {

        return subtasks.values();
    }

    public Status getEpicStatus(int id) {
        if (getEpicSubtask(id).isEmpty()) {
            return Status.NEW;
        }
        for (Subtask sub : getEpicSubtask(id)) {
            Status current = subtasks.get(sub.getId()).getStatus();
            if (current != Status.NEW && current != Status.DONE) {
                return Status.IN_PROGRESS;
            }
        }
        for (Subtask sub : getEpicSubtask(id)) {
            Status current = subtasks.get(sub.getId()).getStatus();
            if (current == Status.NEW) {
                return Status.NEW;
            } else {
                return Status.DONE;
            }
        }
        return null;
    }

}
