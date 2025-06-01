import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private static int nextID = 1;

    public void addTask (String description) {
        tasks.add(new Task(nextID, description));
        System.out.printf("Task added (ID: %d).\n", nextID);
        nextID++;
    }

    public void updateTask (int id, String newDescription) {
        if (newDescription == null || newDescription.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be empty.");
        }

        for (Task task: tasks) {
            if (task.getID() == id) {
                task.setDescription(newDescription);
                System.out.println("Task description update.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void deleteTask (int id) {
        if (tasks.removeIf(task -> task.getID() == id)) {
            System.out.println("Task deleted.");
        } else {
            System.out.println("Task not found.");
        }
    }

    public void markTaskInProgress (int id) {
        for (Task task: tasks) {
            if (task.getID() == id) {
                task.setStatusInProgress();
                System.out.println("Marked.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void markTaskDone (int id) {
        for (Task task: tasks) {
            if (task.getID() == id) {
                task.setStatusDone();
                System.out.println("Marked.");
                return;
            }
        }
        System.out.println("Task not found.");
    }

    public void listAllTasks () {
        for (Task task: tasks) {
            System.out.printf("%d. %s\n", task.getID(), task.getDescription());
        }
    }

    public void listDoneTasks () {
        for (Task task: tasks) {
            if (task.getStatus().equals("Done")) {
                System.out.printf("%d. %s\n", task.getID(), task.getDescription());
            }
        }
    }

    public void listTodoTasks () {
        for (Task task: tasks) {
            if (task.getStatus().equals("Todo")) {
                System.out.printf("%d. %s\n", task.getID(), task.getDescription());
            }
        }
    }

    public void listInProgress() {
        for (Task task: tasks) {
            if (task.getStatus().equals("In-progress")) {
                System.out.printf("%d. %s\n", task.getID(), task.getDescription());
            }
        }
    }
}