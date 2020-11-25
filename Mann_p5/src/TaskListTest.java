import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

class TaskListTest
{
    @Test
    public void addingTaskItemsIncreasesSize()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        assertEquals(0, tasks.getTasks().size());

        tasks.newItem(title, desc, date, mark);
        assertEquals(1, tasks.getTasks().size());
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals(" ", tasks.getTasks().get(0).getMark());

        tasks.markTask(0);
        assertEquals("X", tasks.getTasks().get(0).getMark());
    }

    @Test
    public void completingTaskItemFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals(" ", tasks.getTasks().get(0).getMark());

        tasks.markTask(1);
        assertEquals(" ", tasks.getTasks().get(0).getMark());
    }

    @Test
    public void editingTaskItemChangesValues()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newTitle = "Grocery List";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals("Groceries", tasks.getTasks().get(0).getTitle());

        tasks.editItem(0, newTitle, desc, date, mark);
        assertEquals("Grocery List", tasks.getTasks().get(0).getTitle());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newDesc = "Bananas and Oranges";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals("Oranges", tasks.getTasks().get(0).getDesc());

        tasks.editItem(0, title, newDesc, date, mark);
        assertEquals("Bananas and Oranges", tasks.getTasks().get(0).getDesc());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newDesc = "Oranges and Bananas";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals("Oranges", tasks.getTasks().get(0).getDesc());

        tasks.editItem(1, title, newDesc, date, mark);
        assertEquals("Oranges", tasks.getTasks().get(0).getDesc());
    }

    @Test
    public void editingTaskItemDueDateChangesValue()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newDate = "2020-12-18";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals("2020-12-13", tasks.getTasks().get(0).getDate());

        tasks.editItem(0, title, desc, newDate, mark);
        assertEquals("2020-12-18", tasks.getTasks().get(0).getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newDate = "2020-12-18";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals("2020-12-13", tasks.getTasks().get(0).getDate());

        tasks.editItem(1, title, desc, newDate, mark);
        assertEquals("2020-12-13", tasks.getTasks().get(0).getDate());
    }

    @Test
    public void editingTaskItemTitleChangesValue()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newTitle = "Grocery List";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals("Groceries", tasks.getTasks().get(0).getTitle());

        tasks.editItem(0, newTitle, desc, date, mark);
        assertEquals("Grocery List", tasks.getTasks().get(0).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newTitle = "Grocery List";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals("Groceries", tasks.getTasks().get(0).getTitle());

        tasks.editItem(1, newTitle, desc, date, mark);
        assertEquals("Groceries", tasks.getTasks().get(0).getTitle());
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals("Oranges", tasks.getTasks().get(0).getDesc());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTasks().get(1).getDesc());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals("Oranges", tasks.getTasks().get(0).getDesc());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals("2020-12-13", tasks.getTasks().get(0).getDate());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTasks().get(1).getDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals("2020-12-13", tasks.getTasks().get(0).getDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals("Groceries", tasks.getTasks().get(0).getTitle());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTasks().get(1).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals("Groceries", tasks.getTasks().get(0).getTitle());
    }

    @Test
    public void newTaskListIsEmpty()
    {
        TaskList tasks = new TaskList();

        assertTrue(tasks.getTasks().isEmpty());
    }

    @Test
    public void removingTaskItemsDecreasesSize()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals(1, tasks.getTasks().size());

        tasks.removeItem(0);
        assertEquals(0, tasks.getTasks().size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);
        assertEquals(1, tasks.getTasks().size());

        tasks.removeItem(1);
        assertEquals(1, tasks.getTasks().size());
    }

    @Test
    public void savedTaskListCanBeLoaded()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        File name = new File("savedTaskListCanBeLoaded.txt");
        tasks.saveItem(name);
        assertTrue(name.exists());

        tasks.loadItem(name);
        assertEquals("Oranges", tasks.getTasks().get(0).getDesc());
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals(" ", tasks.getTasks().get(0).getMark());
        tasks.markTask(0);
        assertEquals("X", tasks.getTasks().get(0).getMark());

        tasks.unmarkTask(0);
        assertEquals(" ", tasks.getTasks().get(0).getMark());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalid0()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String mark = " ";

        TaskList tasks = new TaskList();
        tasks.newItem(title, desc, date, mark);

        assertEquals(" ", tasks.getTasks().get(0).getMark());
        tasks.markTask(0);
        assertEquals("X", tasks.getTasks().get(0).getMark());

        tasks.unmarkTask(1);
        assertEquals("X", tasks.getTasks().get(0).getMark());
    }
}