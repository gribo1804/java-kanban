import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class TasksManager {
    static Integer Id = 0;

    static HashMap<Integer, Task> tasksMap = new HashMap<>();

    private static HashMap<Integer, Subtask> subtasks = new HashMap<>();
    private static HashMap<Integer, Epic> epics = new HashMap<Integer, Epic>();

    public static Integer genID() {

        return Id = Id + 1;
    }

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

    public int addSubtask(Subtask subtask) {
        subtasks.put(subtask.getId(), subtask);
        return subtask.getId();
    }

    public  Collection<Task> getAllTasks() {

        return tasksMap.values();
    }
    public  Collection<Epic> getAllEpics() {

        return epics.values();
    }
//    public static void getALLRemoveTask() {
//
//        tasksMap.clear();
//
//    }

    public  void removeTaskById(int id) {

        tasksMap.remove(id);

    }

    public  void removeEpicById(int id) {

        epics.remove(id);

    }

    public void updateTask(Task task) {
        tasksMap.put(task.getId(), task);
    }
    public void updateSubtask(Subtask subtask) {
        tasksMap.put(subtask.getId(), subtask);
    }
    public void updateEpic(Epic epic) {
        epics.put(epic.getId(), epic);
    }
    public  ArrayList<Subtask> getEpicSubtask(int id) {
        ArrayList<Subtask> result = new ArrayList<>();
        for(Subtask st : subtasks.values()){
            if(st.getEpicId() == id){
                result.add(st);
            }
        }
        return result;
    }


    public  Collection<Subtask> getAllSubtasks() {

        return subtasks.values();
    }

}
