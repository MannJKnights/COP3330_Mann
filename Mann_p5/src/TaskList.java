import java.io.*;
import java.util.ArrayList;

public class TaskList extends ItemList
{
    private ArrayList<TaskItem> taskArray = new ArrayList<>();

    // The method to show all the tasks printed out
    @Override
    public void showItem()
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
    @Override
    public void newItem(String title, String desc, String date, String mark)
    {
        TaskItem temp = new TaskItem(title, desc, date, mark);

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
    @Override
    public void editItem(int choice, String newTitle, String newDesc, String newDate, String mark)
    {
        // Checks if the inputted number is within the ArrayList bounds
        if(checkIndex(choice))
        {
            TaskItem temp = new TaskItem(newTitle, newDesc, newDate, mark);

            // Checks if the title and date are empty
            if(temp.getTitle() != null && temp.getDate() != null)
            {
                taskArray.get(choice).setTitle(newTitle);
                taskArray.get(choice).setDesc(newDesc);
                taskArray.get(choice).setDate(newDate);
            }
        }
    }

    // The method to remove Tasks from the TaskList
    @Override
    public void removeItem(int choice)
    {
        // Checks to see if the inputted number is within ArrayList bounds
        if(checkIndex(choice))
        {
            taskArray.remove(choice);
        }
    }

    // The method to save a file to the same file as the .java application
    // IMPORTANT NOTE: Can only load files saved in the same program!
    @Override
    public void saveItem(File y)
    {
        // A try-catch method to save the file
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
        }
    }

    // The method to load in files and their TaskList data
    // IMPORTANT NOTE: Can only load files saved in the same program!
    @Override
    public void loadItem(File loadFiler)
    {
        // A try-catch method to load a file
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
        }
    }

    // The method to check if array is empty
    @Override
    public boolean checkArray()
    {
        if(!taskArray.isEmpty())
        {
            return true;
        }
        else
        {
            System.out.println("Task List is Currently Empty!");
            System.out.println(" ");
            return false;
        }
    }

    // The method to check if the user inputted number was within ArrayList bounds
    @Override
    public boolean checkIndex(int index)
    {
        // If loop that checks if the number was below bounds or above bounds
        if(index < 0 || index >= taskArray.size())
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

    // The method to show all the uncompleted tasks
    public void showUnTask()
    {
        System.out.println("Uncompleted Tasks");
        System.out.println("--------------");

        int x = -1;

        // A loop to print out each Task object in the TaskList
        for (TaskItem tmp1: getTasks())
        {
            // If-loop to check if any tasks have the uncompleted status with counter to display index
            x++;
            if(tmp1.seeMark() == null)
            {
                System.out.println(x + ") " + tmp1.toString());
            }
        }
        System.out.println(" ");
    }

    // The method to mark tasks as complete
    public void markTask(int line)
    {
        // Checks to see if inputted number is within ArrayList bounds
        if(checkIndex(line))
        {
            String mark = "X";
            taskArray.get(line).setMark(mark);
        }
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
            // Loop to check if any tasks are marked with an X with counter to show index
            x++;
            if(tmp1.seeMark() != null)
            {
                System.out.println(x + ") " + tmp1.toString());
            }
        }
        System.out.println(" ");
    }

    // The method to unmark tasks
    public void unmarkTask(int line)
    {
        // Checks to see if inputted number is within ArrayList bounds
        if(checkIndex(line))
        {
            String mark = " ";
            taskArray.get(line).setMark(mark);
        }
    }

    // The method to check if any tasks are uncompleted
    public boolean checkUncomp()
    {
        int x = 0;
        // Loop to go through the ArrayList and see if its empty of unmarked tasks
        for (TaskItem tmp1: taskArray)
        {
            // If loop that adds to the counter if tasks are uncompleted
            if(tmp1.seeMark() == null)
            {
                x++;
            }
        }
        // If loop that if any of the tasks are marked as uncompleted then it returns false
        if(x > 0)
        {
            return false;
        }
        else
        {
            System.out.println("Task List Has No Uncompleted Tasks!");
            System.out.println(" ");
            return true;
        }
    }

    // The method to check if the list has any complete tasks
    public boolean checkComp()
    {
        int x = 0;
        // For loop that goes through the ArrayList
        for (TaskItem tmp1: taskArray)
        {
            // If any tasks are marked as complete then adds to the counter
            if(tmp1.seeMark() != null)
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
            System.out.println("Task List Has No Completed Tasks!");
            System.out.println(" ");
            return true;
        }
    }

    // The method to get all the objects within array list
    public ArrayList<TaskItem> getTasks()
    {
        return taskArray;
    }

    // Method to get the marker
    public String getMarker(int line)
    {
        return taskArray.get(line).getMark();
    }
}