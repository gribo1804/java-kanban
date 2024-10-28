public class Main {


    public static void main(String[] args) {

        TasksManager manager = new TasksManager();

        // Создание
        Task task1 = new Task("Task #1", "Task1 description", Status.NEW);
        Task task2 = new Task("Task #2", "Task2 description", Status.IN_PROGRESS);
        final int taskId1 = manager.addTask(task1);
        final int taskId2 = manager.addTask(task2);

        Epic epic1 = new Epic("Epic #1", "Epic1 description");
        Epic epic2 = new Epic("Epic #2", "Epic2 description");
        final int epicId1 = manager.addEpic(epic1);
        final int epicId2 = manager.addEpic(epic2);

        Subtask subtask1 = new Subtask("Subtask #1-1", "Subtask1 description", Status.NEW, epicId1);
        Subtask subtask2 = new Subtask("Subtask #2-1", "Subtask1 description", Status.NEW, epicId1);
        Subtask subtask3 = new Subtask("Subtask #3-2", "Subtask1 description", Status.DONE, epicId2);
        final Integer subtaskId1 = manager.addSubtask(subtask1);
        final Integer subtaskId2 = manager.addSubtask(subtask2);
        final Integer subtaskId3 = manager.addSubtask(subtask3);



        // Обновление
        final Task task = manager.getTaskById(taskId2);
        task.setStatus(Status.DONE);
        manager.updateTask(task);
        System.out.println("CHANGE STATUS: Task2 IN_PROGRESS->DONE");
        System.out.println("Задачи:");
        for (Task tasks : manager.getAllTasks()) {
            System.out.println(tasks);
        }

        Subtask subtask = manager.getSubtaskById(subtaskId2);
        subtask.setStatus(Status.DONE);
        manager.updateSubtask(subtask);
        System.out.println("CHANGE STATUS: Subtask2 NEW->DONE");
        subtask = manager.getSubtaskById(subtaskId3);
        subtask.setStatus(Status.NEW);
        manager.updateSubtask(subtask);

        System.out.println("CHANGE STATUS: Subtask3 DONE->NEW");
        System.out.println("Подзадачи:");
        for (Task subtasks : manager.getAllSubtasks()) {
            System.out.println(subtasks);
        }

        manager.linkSubtaskToEpic(epicId1, subtaskId2);
        manager.linkSubtaskToEpic(epicId2, subtaskId3);
        manager.linkSubtaskToEpic(epicId2, subtaskId1);
        System.out.println("Эпики:");
        for (Task epic : manager.getAllEpics()) {
            System.out.println(manager.getEpicStatus(epic.getId()));
            System.out.println(epic);
            for (Task st : manager.getEpicSubtask(epic.getId())) {
                System.out.println("--> " + st);
            }
        }

//
        // Удаление
        System.out.println("DELETE: Task1");
        manager.removeTaskById(taskId1);
        System.out.println("DELETE: Epic1");
        manager.removeEpicById(epicId1);
    }
}
