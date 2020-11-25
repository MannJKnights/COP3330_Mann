import java.io.File;
import java.util.Scanner;

public class TaskApp
{
    public static void taskMenu()
    {
        // Task menu with scanner for user to navigate through the menu
        int menuInput;
        while (true) {
            Scanner userChoice = new Scanner(System.in);

            System.out.println("Task Menu");
            System.out.println("----------");
            System.out.println("1) Create a New List");
            System.out.println("2) Load an Existing List");
            System.out.println("3) Quit to Main Menu");

            // Switch to iterate through the choices
            menuInput = userChoice.nextInt();
            switch (menuInput)
            {
                // First choice creates a new TaskList and then calls to the second menu screen
                case 1 -> {
                    TaskList tasks = new TaskList();
                    System.out.println("New task list has been created!");
                    System.out.println(" ");

                    secondMenu(tasks);
                }
                // Second choice loads in a file and then sends that TaskList to the second menu screen
                // IMPORTANT NOTE: Can only load files saved in the same program!
                case 2 -> {
                    System.out.println("Please input file name to load!");
                    Scanner fileName = new Scanner(System.in);
                    String loadFiler = fileName.nextLine();
                    TaskList tasks = new TaskList();

                    tasks.loadItem(new File(loadFiler));
                    System.out.println(" ");

                    // Makes sure that the file loaded has content in it before sending to second menu
                    if(!tasks.getTasks().isEmpty())
                    {
                        secondMenu(tasks);
                    }
                }
                // Third choice returns user to main menu
                case 3 -> {
                    return;
                }
            }
        }
    }

    // Second task menu
    public static void secondMenu(TaskList tasks)
    {
        // Menu with scanner to help user navigate through the menu
        int exitC = 0;
        while (exitC == 0)
        {
            Scanner user2 = new Scanner(System.in);

            System.out.println("List Operation Menu");
            System.out.println("--------------------");
            System.out.println("1) View the List");
            System.out.println("2) Add an Item");
            System.out.println("3) Edit an Item");
            System.out.println("4) Remove an Item");
            System.out.println("5) Mark an Item as Completed");
            System.out.println("6) Unmark an Item as Completed");
            System.out.println("7) Save the Current List");
            System.out.println("8) Quit to the Task Menu");

            // Switch to iterate through choices
            int menu2 = user2.nextInt();
            switch (menu2) {
                // First choice shows all the current tasks by calling the method in TaskList
                case 1 -> tasks.showItem();
                // Second choice creates a new task by gathering input and then sending that to the method in TaskList
                case 2 -> {
                    Scanner taskItems = new Scanner(System.in);
                    String mark = " ";

                    System.out.println("Please enter your task title:");
                    String title = taskItems.nextLine();
                    System.out.println("Please enter your task description:");
                    String desc = taskItems.nextLine();
                    System.out.println("Please enter the task due date (YYYY-MM-DD):");
                    String date = taskItems.nextLine();

                    tasks.newItem(title, desc, date, mark);
                }
                // Third choice edits tasks already made by taking the new data and sending it to the method in TaskList
                case 3 -> {
                    tasks.showItem();
                    // Checks if the list is empty
                    if(tasks.checkArray())
                    {
                        System.out.println("Which task will you edit?");

                        Scanner arrayChoice = new Scanner(System.in);
                        int line = arrayChoice.nextInt();
                        Scanner newTaskItems = new Scanner(System.in);
                        String mark = null;
                        try
                        {
                            mark = tasks.getMarker(line);
                        }
                        catch(IndexOutOfBoundsException e)
                        {
                            System.out.println(" ");
                        }

                        System.out.println("Please enter your task title:");
                        String newTitle = newTaskItems.nextLine();
                        System.out.println("Please enter your task description:");
                        String newDesc = newTaskItems.nextLine();
                        System.out.println("Please enter your task due date (YYYY-MM-DD):");
                        String newDate = newTaskItems.nextLine();

                        tasks.editItem(line, newTitle, newDesc, newDate, mark);
                    }
                }
                // Fourth choice removes tasks from the list by calling the method in TaskList
                case 4 -> {
                    tasks.showItem();

                    // Checks if the list is empty
                    if(tasks.checkArray())
                    {
                        System.out.println("Which task will you remove?");

                        Scanner arrayChoice = new Scanner(System.in);
                        int line = arrayChoice.nextInt();
                        tasks.removeItem(line);
                    }
                }
                // Fifth choice allows you to mark tasks as complete
                case 5 -> {
                    tasks.showUnTask();

                    // Checks if the list is empty
                    if(tasks.checkArray())
                    {
                        // Checks if any tasks are marked as uncompleted
                        if(!tasks.checkUncomp())
                        {
                            System.out.println("Which task will you mark as completed?");

                            Scanner arrayChoice = new Scanner(System.in);
                            int line = arrayChoice.nextInt();
                            tasks.markTask(line);
                        }
                    }
                }
                // Sixth choice allows you to mark tasks as uncompleted
                case 6 -> {
                    tasks.showCoTask();

                    // Checks if task list is empty
                    if(tasks.checkArray())
                    {
                        // Checks if any tasks are marked as completed
                        if(!tasks.checkComp())
                        {
                            System.out.println("Which task will you mark as uncompleted?");

                            Scanner arrayChoice = new Scanner(System.in);
                            int line = arrayChoice.nextInt();
                            tasks.unmarkTask(line);
                        }
                    }
                }
                // Seventh choice saves a file to the same folder as the .java
                // IMPORTANT NOTE: Can only load files saved in the same program!
                case 7 -> {
                    String h;
                    System.out.println("Please input file name to save!");
                    Scanner fileName = new Scanner(System.in);
                    h = fileName.nextLine();

                    File y = new File(h);
                    tasks.saveItem(y);
                    System.out.println(" ");
                }
                // Eighth choice sends user back to the Task Menu
                case 8 -> exitC = 1;
            }
        }
    }
}