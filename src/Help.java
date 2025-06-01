public class Help {
    public static void printHelp() {
        System.out.println("===== Task CLI Help =====");
        System.out.println("Usage: java Main <command> [arguments]");
        System.out.println();
        System.out.println("Available commands:");
        System.out.println("  add <description>                Add a new task");
        System.out.println("  update <id> <new description>   Update task description");
        System.out.println("  delete <id>                      Delete a task by ID");
        System.out.println("  mark-in-progress <id>            Mark task as In-progress");
        System.out.println("  mark-done <id>                  Mark task as Done");
        System.out.println("  list                            List all tasks");
        System.out.println("  list-done                       List only completed tasks");
        System.out.println("  list-todo                       List tasks to be done");
        System.out.println("  list-in-progress                 List tasks in progress");
        System.out.println("  help                            Show this help message");
        System.out.println("==============================");
    }
}