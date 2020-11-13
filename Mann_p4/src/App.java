import java.io.File;
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        // Introduction to the program
        System.out.println("Welcome to COP3330 O.O.P's Console-based Task List");

        // Initializing the int to be used when choosing the different menu options
        int menuInput;

        // First menu screen, runs until the third options exists the program
        while (true) {
            Scanner userChoice = new Scanner(System.in);

            System.out.println("Main Menu");
            System.out.println("----------");
            System.out.println("1) Create a New List");
            System.out.println("2) Load an Existing List");
            System.out.println("3) Quit");

            menuInput = userChoice.nextInt();

            // Switch to iterate through the choices
            switch (menuInput)
            {
                // First choice creates a new Task List and then calls to the second menu screen
                case 1 -> {
                    TaskList tasks = new TaskList();
                    System.out.println("New task list has been created!");
                    System.out.println(" ");

                    secondMenu(tasks);
                }
                // Second choice loads in a file and then sends that Task List to the second menu screen
                // IMPORTANT NOTE: Can only load files saved in the same program! (Or at least couldn't load previous saved files after changes)
                case 2 -> {
                    System.out.println("Please input file name to load!");
                    Scanner fileName = new Scanner(System.in);
                    String loadFiler = fileName.nextLine();
                    TaskList tasks = new TaskList();

                    tasks.loadFile(new File(loadFiler));
                    System.out.println(" ");

                    secondMenu(tasks);
                }
                // Third choice exists the program
                case 3 -> System.exit(0);
            }
        }
    }

    // This is the second menu, put it in another method to simplify the program a little
    public static void secondMenu(TaskList tasks)
    {
        // Another initialization that that helps the program run its while loop
        int exitC = 0;

        // Runs till you choose to quit to the main menu
        while (exitC == 0)
        {
            System.out.println("List Operation Menu");
            System.out.println("--------------------");
            System.out.println("1) View the List");
            System.out.println("2) Add an Item");
            System.out.println("3) Edit an Item");
            System.out.println("4) Remove an Item");
            System.out.println("5) Mark an Item as Completed");
            System.out.println("6) Unmark an item as Completed");
            System.out.println("7) Save the Current List");
            System.out.println("8) Quit to the Main Menu");

            Scanner user2 = new Scanner(System.in);
            int menu2 = user2.nextInt();

            // This is a switch to loop through the different choices
            switch (menu2) {
                // First choice shows all the current tasks by calling the method that does that
                case 1 -> tasks.showTasks();
                // Second choice creates a new task by gathering input and then sending that to the method in Task List
                case 2 -> {
                    Scanner taskItems = new Scanner(System.in);

                    System.out.println("Please enter your task title:");
                    String title = taskItems.nextLine();
                    System.out.println("Please enter your task description:");
                    String desc = taskItems.nextLine();
                    System.out.println("Please enter the task due date (YYYY-MM-DD):");
                    String date = taskItems.nextLine();

                    tasks.newTask(title, desc, date);
                }
                // Third choice edit tasks already made by taking the new data and sending it to the edit method
                case 3 -> {
                    tasks.showTasks();
                    // Checks if the list is empty, if it is then prints error message otherwise continues the tool
                    if(tasks.emptyArray())
                    {
                        System.out.println("Which task will you edit?");

                        Scanner arrayChoice = new Scanner(System.in);
                        int line = arrayChoice.nextInt();
                        Scanner newTaskItems = new Scanner(System.in);

                        System.out.println("Please enter your new task title:");
                        String newTitle = newTaskItems.nextLine();
                        System.out.println("Please enter your new task description:");
                        String newDesc = newTaskItems.nextLine();
                        System.out.println("Please enter your new task due date (YYYY-MM-DD):");
                        String newDate = newTaskItems.nextLine();

                        tasks.editTask(line, newTitle, newDesc, newDate);
                    }
                    // Error message if empty
                    else
                    {
                        System.out.println("Task List is Currently Empty!");
                        System.out.println(" ");
                    }
                }
                // Fourth choice removes tasks from the list by calling said method
                case 4 -> {
                    tasks.showTasks();

                    // Checks if the list is empty or not
                    if(tasks.emptyArray())
                    {
                        System.out.println("Which task will you remove?");

                        Scanner arrayChoice = new Scanner(System.in);
                        int line = arrayChoice.nextInt();
                        tasks.removeTask(line);
                    }
                    // Error message is empty
                    else
                    {
                        System.out.println("Task List is Currently Empty!");
                        System.out.println(" ");
                    }
                }
                // Fifth choice allows you to mark tasks as complete
                case 5 -> {
                    tasks.showUnTask();

                    // Checks if the list if empty
                    if(tasks.emptyArray())
                    {
                        // Checks if the list has any uncompleted tasks
                        if(!tasks.emptyComp())
                        {
                            System.out.println("Which task will you mark as completed?");

                            Scanner arrayChoice = new Scanner(System.in);
                            int line = arrayChoice.nextInt();
                            tasks.markTask(line);
                        }
                        // Error message if all tasks are marked as complete
                        else
                        {
                            System.out.println("Task List Has No Uncompleted Tasks!");
                            System.out.println(" ");
                        }
                    }
                    // Error message if task list is empty
                    else
                    {
                        System.out.println("Task List is Currently Empty!");
                        System.out.println(" ");
                    }
                }
                // Sixth choice allows you to mark tasks as uncomplete
                case 6 -> {
                    tasks.showCoTask();

                    // Checks if task list is empty or not
                    if(tasks.emptyArray())
                    {
                        // Checks if any tasks are marked as completed
                        if(!tasks.emptyComp1())
                        {
                            System.out.println("Which task will you mark as uncompleted?");

                            Scanner arrayChoice = new Scanner(System.in);
                            int line = arrayChoice.nextInt();
                            tasks.unmarkTask(line);
                        }
                        // Error message if no completed tasks
                        else
                        {
                            System.out.println("Task List Has No Completed Tasks!");
                            System.out.println(" ");
                        }
                    }
                    // Error message if task list is empty
                    else
                    {
                        System.out.println("Task List is Currently Empty!");
                        System.out.println(" ");
                    }
                }
                // Seventh choice allows you to save task list to a file
                case 7 -> {
                    String h;
                    System.out.println("Please input file name to save!");
                    Scanner fileName = new Scanner(System.in);
                    h = fileName.nextLine();

                    File y = new File(h);
                    tasks.saveFile(y);
                    System.out.println(" ");
                }
                // Eighth choice exists the current loop and into the other menu loop
                case 8 -> exitC = 1;
            }
        }
    }
}