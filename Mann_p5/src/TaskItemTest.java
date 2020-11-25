import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskItemTest
{
    @Test
    public void creatingTaskItemFailsWithInvalidDueDate()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "20201213";
        String mark = " ";

        TaskItem task = new TaskItem(title, desc, date, mark);
        assertNull(task.getDate());
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle()
    {
        String title = "";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskItem task = new TaskItem(title, desc, date, mark);
        assertNull(task.getTitle());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskItem task = new TaskItem(title, desc, date, mark);
        assertEquals("2020-12-13", task.getDate());
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskItem task = new TaskItem(title, desc, date, mark);
        assertEquals("Groceries", task.getTitle());
    }

    @Test
    public void settingTaskItemDueDateFailsWithInvalidDate()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String badDate = "20201213";
        String mark = " ";

        TaskItem task = new TaskItem(title, desc, date, mark);
        task.setDate(badDate);

        assertEquals("2020-12-13", task.getDate());
    }

    @Test
    public void settingTaskItemDueDateSucceedsWithValidDate()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String goodDate = "2020-12-30";
        String mark = " ";

        TaskItem task = new TaskItem(title, desc, date, mark);
        task.setDate(goodDate);

        assertEquals("2020-12-30", task.getDate());
    }

    @Test
    public void settingTaskItemTitleFailsWithInvalidTitle()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String badTitle = "";
        String mark = " ";

        TaskItem task = new TaskItem(title, desc, date, mark);
        task.setTitle(badTitle);

        assertEquals("Groceries", task.getTitle());
    }

    @Test
    public void settingTaskItemTitleSucceedsWithValidTitle()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String goodTitle = "Grocery List";
        String mark = " ";

        TaskItem task = new TaskItem(title, desc, date, mark);
        task.setTitle(goodTitle);

        assertEquals("Grocery List", task.getTitle());
    }
}