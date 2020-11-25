import java.io.File;

// Abstract class to combine the various abstract methods
public abstract class ItemList
{
    // Abstract methods of common methods between TaskList and ContactList
    public abstract void showItem();
    public abstract void newItem(String tiFN, String deLN, String daPh, String maEm);
    public abstract void editItem(int choice, String tiFN, String deLN, String daPh, String maEm);
    public abstract void removeItem(int choice);
    public abstract void saveItem(File file);
    public abstract void loadItem(File file);
    public abstract boolean checkArray();
    public abstract boolean checkIndex(int index);
}