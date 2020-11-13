import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest
{

    @Test
    public void addingTaskItemsIncreasesSize()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        assertEquals(0, tasks.getTasks().size());

        tasks.newTask(title, desc, date);
        assertEquals(1, tasks.getTasks().size());
    }

    @Test
    public void completingTaskItemChangesStatus()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertNull(tasks.getTasks().get(index).getMark());

        tasks.markTask(index);
        assertEquals("X", tasks.getTasks().get(index).getMark());
    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertNull(tasks.getTasks().get(index).getMark());

        tasks.markTask(index + 1);
        assertNull(tasks.getTasks().get(index).getMark());
    }

    @Test
    public void editingTaskItemChangesValues()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newTitle = "Grocery List";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);
        int index = 0;
        assertEquals("Groceries", tasks.getTasks().get(index).getTitle());

        tasks.editTask(index, newTitle, desc, date);
        assertEquals("Grocery List", tasks.getTasks().get(index).getTitle());
    }

    @Test
    public void editingTaskItemDescriptionChangesValue()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newDesc = "Bananas and Oranges";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);
        int index = 0;
        assertEquals("Oranges", tasks.getTasks().get(index).getDesc());

        tasks.editTask(index, title, newDesc, date);
        assertEquals("Bananas and Oranges", tasks.getTasks().get(index).getDesc());
    }

    @Test
    public void editingTaskItemDescriptionFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newDesc = "Oranges and Bananas";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("Oranges", tasks.getTasks().get(index).getDesc());

        tasks.editTask(index + 1, title, newDesc, date);
        assertEquals("Oranges", tasks.getTasks().get(index).getDesc());
    }

    @Test
    public void editingTaskItemDueDateChangesValue()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newDate = "2020-12-18";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);
        int index = 0;
        assertEquals("2020-12-13", tasks.getTasks().get(index).getDate());

        tasks.editTask(index, title, desc, newDate);
        assertEquals("2020-12-18", tasks.getTasks().get(index).getDate());
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newDate = "2020-12-18";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("2020-12-13", tasks.getTasks().get(index).getDate());

        tasks.editTask(index + 1, title, desc, newDate);
        assertEquals("2020-12-13", tasks.getTasks().get(index).getDate());
    }

    @Test
    public void editingTaskItemTitleChangesValue()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newTitle = "Grocery List";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);
        int index = 0;
        assertEquals("Groceries", tasks.getTasks().get(index).getTitle());

        tasks.editTask(index, newTitle, desc, date);
        assertEquals("Grocery List", tasks.getTasks().get(index).getTitle());
    }

    @Test
    public void editingTaskItemTitleFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        String newTitle = "Grocery List";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("Groceries", tasks.getTasks().get(index).getTitle());

        tasks.editTask(index + 1, newTitle, desc, date);
        assertEquals("Groceries", tasks.getTasks().get(index).getTitle());
    }

    @Test
    public void gettingTaskItemDescriptionFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("Oranges", tasks.getTasks().get(index).getDesc());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTasks().get(index + 1).getDesc());
    }

    @Test
    public void gettingTaskItemDescriptionSucceedsWithValidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("Oranges", tasks.getTasks().get(index).getDesc());
    }

    @Test
    public void gettingTaskItemDueDateFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("2020-12-13", tasks.getTasks().get(index).getDate());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTasks().get(index + 1).getDate());
    }

    @Test
    public void gettingTaskItemDueDateSucceedsWithValidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("2020-12-13", tasks.getTasks().get(index).getDate());
    }

    @Test
    public void gettingTaskItemTitleFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("Groceries", tasks.getTasks().get(index).getTitle());

        Assertions.assertThrows(IndexOutOfBoundsException.class, () ->tasks.getTasks().get(index + 1).getTitle());
    }

    @Test
    public void gettingTaskItemTitleSucceedsWithValidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertEquals("Groceries", tasks.getTasks().get(index).getTitle());
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

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);
        assertEquals(1, tasks.getTasks().size());

        int index = 0;
        tasks.removeTask(index);
        assertEquals(0, tasks.getTasks().size());
    }

    @Test
    public void removingTaskItemsFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);
        assertEquals(1, tasks.getTasks().size());

        int index = 0;
        tasks.removeTask(index + 1);
        assertEquals(1, tasks.getTasks().size());
    }

    @Test
    public void savedTaskListCanBeLoaded()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";
        boolean tester;

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);
        int index = 0;

        File name = new File("savedTaskListCanBeLoaded.txt");
        tasks.saveFile(name);
        assertTrue(name.exists());

        tasks.loadFile(name);
        assertEquals("Oranges", tasks.getTasks().get(index).getDesc());
    }

    @Test
    public void uncompletingTaskItemChangesStatus()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertNull(tasks.getTasks().get(index).getMark());
        tasks.markTask(index);
        assertEquals("X", tasks.getTasks().get(index).getMark());

        tasks.unmarkTask(index);
        assertNull(tasks.getTasks().get(index).getMark());
    }

    @Test
    public void uncompletingTaskItemFailsWithInvalidIndex()
    {
        String title = "Groceries";
        String desc = "Oranges";
        String date = "2020-12-13";

        TaskList tasks = new TaskList();
        tasks.newTask(title, desc, date);

        int index = 0;
        assertNull(tasks.getTasks().get(index).getMark());
        tasks.markTask(index);
        assertEquals("X", tasks.getTasks().get(index).getMark());

        tasks.unmarkTask(index + 1);
        assertEquals("X", tasks.getTasks().get(index).getMark());
    }
}
