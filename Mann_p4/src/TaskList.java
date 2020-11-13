import java.io.*;
import java.util.ArrayList;

public class TaskList
{
    private ArrayList<TaskItem> taskArray = new ArrayList<>();

    // The method to show all the tasks printed out
    public void showTasks()
    {
        System.out.println("Current Tasks");
        System.out.println("--------------");

        int x = 0;

        // A loop to print out each Task object going down with each array position printed alongside
        for (TaskItem tmp: getTasks())
        {
            System.out.println(x + ") " + tmp.toString());
            x++;
        }
        System.out.println(" ");
    }

    // The method to create a new task
    public void newTask(String title, String desc, String date)
    {
        TaskItem temp = new TaskItem(title, desc, date);

        // Checks to see if the title and date aren't empty, if not then adds the new Item to the ArrayList
        if(temp.getTitle() != null && temp.getDate() != null)
        {
            taskArray.add(temp);

            System.out.println("Task Title: " + title);
            System.out.println("Task Description: " + desc);
            System.out.println("Task Due Date (YYYY-MM-DD): " + date);
            System.out.println(" ");
        }
    }

    // The method to edit tasks already in the ArrayList
    public void editTask(int x, String newTitle, String newDesc, String newDate)
    {
        // Checks if the inputted number is within the ArrayList bounds
        if(noExist(x))
        {
            TaskItem temp = new TaskItem(newTitle, newDesc, newDate);

            // Checks if the title and date aren't empty and if they aren't then sets the new data
            if(temp.getTitle() != null && temp.getDate() != null)
            {
                taskArray.get(x).setTitle(newTitle);
                taskArray.get(x).setDesc(newDesc);
                taskArray.get(x).setDate(newDate);
            }
        }
    }

    // The method to remove Tasks from the TaskList
    public void removeTask(int line)
    {
        // Checks to see if the inputted number is within ArrayList bounds
        if(noExist(line))
        {
            taskArray.remove(line);
        }
    }

    // The method to mark tasks as complete
    public void markTask(int line)
    {
        // Checks to see if inputted number is within ArrayList bounds
        if(noExist(line))
        {
            taskArray.get(line).taskCompleted();
        }
    }

    // The method to unmark tasks as complete
    public void unmarkTask(int line)
    {
        // Checks to see if inputted number is within ArrayList bounds
        if(noExist(line))
        {
            taskArray.get(line).taskUnCompleted();
        }
    }

    // The method to save a file to the same file as the .java application
    // IMPORTANT NOTE: Most likely can only read files later that were saved through this method!
    public void saveFile(File y)
    {
        // A try-catch method to save the file, if an error happens then prints said message
        try
        {
            FileOutputStream writer = new FileOutputStream(y);
            ObjectOutputStream writer2 = new ObjectOutputStream(writer);
            writer2.writeObject(taskArray);
            writer2.close();
            writer.close();

            System.out.println("Task List has been saved!");
        }
        // Error message if couldn't save properly
        catch (IOException e)
        {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }

    // The method to load in files and their TaskList data
    // IMPORTANT NOTE: Can only read files that were saved through previous method!
    public void loadFile(File loadFiler)
    {
        // A try-catch method to see if file can be properly loaded otherwise prints error
        try
        {
            FileInputStream reader = new FileInputStream(loadFiler);
            ObjectInputStream reader1 = new ObjectInputStream(reader);
            taskArray = (ArrayList<TaskItem>)reader1.readObject();
            reader1.close();

            System.out.println("Task List has been Loaded!");
        }
        // Error message if file wasn't loaded properly
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("An error has occurred!");
            e.printStackTrace();
        }
    }

    // The method to show all the uncompleted tasks
    public void showUnTask()
    {
        System.out.println("Uncompleted Tasks");
        System.out.println("--------------");

        int x = -1;

        // A loop to print out each Task object in the TaskList
        for (TaskItem tmp1: getTasks())
        {
            // Counter outside of if-loop for my own sake and to fix error of uncorrelating array positions
            x++;
            // If-loop to check if any tasks have the uncompleted status
            if(tmp1.getMark() == null)
            {
                System.out.println(x + ") " + tmp1.toString());
            }
        }
        System.out.println(" ");
    }

    // The method to show all completed tasks
    public void showCoTask()
    {
        System.out.println("Completed Tasks");
        System.out.println("--------------");

        int x = -1;

        // A loop to print all completed tasks
        for (TaskItem tmp1: getTasks())
        {
            // Counter outside loop again to prevent uncorrelating positions
            x++;
            // Loop to check if any tasks are marked with an X or not
            if(tmp1.getMark() != null)
            {
                System.out.println(x + ") " + tmp1.toString());
            }
        }
        System.out.println(" ");
    }

    // The method to check if array is empty or not
    public boolean emptyArray()
    {
        return !taskArray.isEmpty();
    }

    // The method to check if any tasks are uncomplete or not
    public boolean emptyComp()
    {
        int x = 0;
        // Loop to go through the ArrayList and see if its empty of unmarked tasks or not
        for (TaskItem tmp1: taskArray)
        {
            // If loop that adds to the counter if tasks are uncomplete
            if(tmp1.getMark() == null)
            {
                x++;
            }
        }
        // Another if loop that if any of the tasks are marked as uncomplete then it returns false
        if(x > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // The method to check if the list has any complete tasks or not
    public boolean emptyComp1()
    {
        int x = 0;
        // For loop that goes through the ArrayList
        for (TaskItem tmp1: taskArray)
        {
            // If any tasks are marked as complete then adds to the counter
            if(tmp1.getMark() != null)
            {
                x++;
            }
        }
        // If loop that returns false if any tasks were marked as complete
        if(x > 0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // The method to check if the user inputted number was within ArrayList bounds
    public boolean noExist(int indexCheck)
    {
        // If loop that checks if the number was below bounds or above bounds
        if(indexCheck < 0 || indexCheck >= taskArray.size())
        {
            System.out.println("Task Does Not Exist!");
            System.out.println(" ");
            return false;
        }
        else
        {
            return true;
        }
    }

    // The method to get all tasks
    // Truthfully added to make tests easier to tast, teehee
    public ArrayList<TaskItem> getTasks()
    {
        return taskArray;
    }
}