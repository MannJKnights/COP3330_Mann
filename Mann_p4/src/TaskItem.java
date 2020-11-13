import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskItem implements Serializable
{
    private String title;
    private String desc;
    private String date;
    private String mark = " ";

    // Constructor that sets the 3 main components of a Task
    public TaskItem(String title, String desc, String date)
    {
        this.title = title;
        this.desc = desc;
        this.date = date;
    }

    // Title getter method
    public String getTitle()
    {
        // Checks if the title has atleast 1 or more character
        // Error message if empty
        if(title.isEmpty())
        {
            System.out.println("WARNING - Title Can Not Be Empty!");
            System.out.println("Task Creation Aborted");
            System.out.println(" ");
            return null;
        }
        else
        {
            return this.title;
        }
    }

    // Title setter method
    public void setTitle(String newTitle)
    {
        // Checks if title is empty or not
        // Error message if empty
        if(newTitle.isEmpty())
        {
            System.out.println("WARNING - Title Can Not Be Empty!");
            System.out.println("Task Edit Aborted");
            System.out.println(" ");
        }
        else
        {
            this.title = newTitle;
        }
    }

    // Description getter method
    public String getDesc()
    {
        return this.desc;
    }

    // Description setter method
    public void setDesc(String newDesc)
    {
        this.desc = newDesc;
    }

    // Date getter method
    public String getDate()
    {
        Date date1 = null;
        // A try-catch exception handler to check if the date is in the correct format
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date1 = dateFormat.parse(date);
            // Checks if the passed date string is in correct format and date, if not then resets the Date object as null
            if(!date.equals(dateFormat.format(date1)))
            {
                date1 = null;
            }
        }
        // Error message if not in correct format
        catch (ParseException e)
        {
            System.out.println("WARNING - Date is Not in Correct Format!");
            System.out.println("Task Creation Aborted");
            System.out.println(" ");
        }
        // Checks if the string was a correct date
        // Error message if not correct date
        if(date1 == null)
        {
            System.out.println("WARNING - Date is Not Valid!");
            System.out.println("Task Creation Aborted");
            System.out.println(" ");
            return null;
        }
        else
        {
            return this.date;
        }
    }

    // Date setter method
    public void setDate(String newDate)
    {
        Date date1 = null;
        // A try-catch exception handler to check if the date is in the correct format
        try
        {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            date1 = dateFormat.parse(newDate);
            // Checks if the passed date string is in correct format and date, if not then resets the Date object as null
            if(!newDate.equals(dateFormat.format(date1)))
            {
                date1 = null;
            }
        }
        // Error message if not in correct format
        catch (ParseException e)
        {
            System.out.println("WARNING - Date is Not in Correct Format!");
            System.out.println("Task Edit Aborted");
            System.out.println(" ");
        }
        // Checks if the string was a correct date
        // Error message if not correct date
        if(date1 == null)
        {
            System.out.println("WARNING - Date is Not Valid!");
            System.out.println("Task Edit Aborted");
            System.out.println(" ");
        }
        else
        {
            this.date = newDate;
        }
    }

    // A method to mark task as complete
    public String taskCompleted()
    {
        this.mark = "X";
        return mark;
    }

    // A method to mark task as uncomplete
    public String taskUnCompleted()
    {
        this.mark = " ";
        return mark;
    }

    // A method to see what the mark is
    public String getMark()
    {
        if(!mark.equals(" "))
        {
            return mark;
        }
        else
        {
            return null;
        }
    }

    // A toString method to put the final object all together nice and pretty
    @Override
    public String toString()
    {
        return "[" + mark + "] " + "| " + "[" + date + "] " + title + ": " + desc;
    }
}