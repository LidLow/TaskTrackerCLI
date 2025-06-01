public class TaskTracker {

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        if (args.length == 0) {
            System.out.println("No command provided. Use 'help' for instructions.");
            return;
        }

        String command = args[0];

        switch (command.toLowerCase()) {
            case "add":
                if (args.length < 2) {
                    System.out.println("Usage: add <description>");
                    break;
                }
                String description = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length));
                manager.addTask(description);
                break;

            case "update":
                if (args.length < 3) {
                    System.out.println("Usage: update <id> <new description>");
                    break;
                }
                try {
                    int id = Integer.parseInt(args[1]);
                    String newDesc = String.join(" ", java.util.Arrays.copyOfRange(args, 2, args.length));
                    manager.updateTask(id, newDesc);
                } catch (NumberFormatException e) {
                    System.out.println("ID must be a number.");
                }
                break;

            case "delete":
                if (args.length != 2) {
                    System.out.println("Usage: delete <id>");
                    break;
                }
                try {
                    int id = Integer.parseInt(args[1]);
                    manager.deleteTask(id);
                } catch (NumberFormatException e) {
                    System.out.println("ID must be a number.");
                }
                break;

            case "mark-in-progress":
                if (args.length != 2) {
                    System.out.println("Usage: mark-in-progress <id>");
                    break;
                }
                try {
                    int id = Integer.parseInt(args[1]);
                    manager.markTaskInProgress(id);
                } catch (NumberFormatException e) {
                    System.out.println("ID must be a number.");
                }
                break;

            case "mark-done":
                if (args.length != 2) {
                    System.out.println("Usage: mark-done <id>");
                    break;
                }
                try {
                    int id = Integer.parseInt(args[1]);
                    manager.markTaskDone(id);
                } catch (NumberFormatException e) {
                    System.out.println("ID must be a number.");
                }
                break;

            case "list":
                manager.listAllTasks();
                break;

            case "list-done":
                manager.listDoneTasks();
                break;

            case "list-todo":
                manager.listTodoTasks();
                break;

            case "list-in-progress":
                manager.listInProgress();
                break;

            case "help":
                Help.printHelp();
                break;

            default:
                System.out.println("Unknown command. Use 'help' to see the list of commands.");
                break;
        }
    }
}