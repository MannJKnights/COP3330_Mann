import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContactListTest
{
    @Test
    public void addingItemsIncreasesSize()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        ContactList contacts = new ContactList();
        assertEquals(0, contacts.getContacts().size());

        contacts.newItem(firstName, lastName, phone, email);
        assertEquals(1, contacts.getContacts().size());
    }

    @Test
    public void editingItemsFailsWithAllBlankValues()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "";
        String newLN= "";
        String newPhone = "";
        String newEmail = "";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(0,newFN, newLN, newPhone, newEmail);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void editingItemsFailsWithInvalidIndex()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "";
        String newLN= "";
        String newPhone = "";
        String newEmail = "";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(1,newFN, newLN, newPhone, newEmail);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankFirstName()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "";
        String newLN= "Bunny";
        String newPhone = "239-210-2020";
        String newEmail = "bugsbunny@gmail.com";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(0,newFN, newLN, newPhone, newEmail);
        assertEquals("", contact.getContacts().get(0).getFirstName());
        assertEquals("Bunny", contact.getContacts().get(0).getLastName());
        assertEquals("239-210-2020", contact.getContacts().get(0).getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankLastName()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "Bugs";
        String newLN= "";
        String newPhone = "239-210-2020";
        String newEmail = "bugsbunny@gmail.com";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(0,newFN, newLN, newPhone, newEmail);
        assertEquals("Bugs", contact.getContacts().get(0).getFirstName());
        assertEquals("", contact.getContacts().get(0).getLastName());
        assertEquals("239-210-2020", contact.getContacts().get(0).getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankPhone()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "Bugs";
        String newLN= "Bunny";
        String newPhone = "";
        String newEmail = "bugsbunny@gmail.com";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(0,newFN, newLN, newPhone, newEmail);
        assertEquals("Bugs", contact.getContacts().get(0).getFirstName());
        assertEquals("Bunny", contact.getContacts().get(0).getLastName());
        assertEquals("", contact.getContacts().get(0).getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void editingFailsWithInvalidPhone()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "Bugs";
        String newLN= "Bunny";
        String newPhone = "2392102020";
        String newEmail = "bugsbunny@gmail.com";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(0,newFN, newLN, newPhone, newEmail);
        assertEquals("Bugs", contact.getContacts().get(0).getFirstName());
        assertEquals("Bunny", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithBlankEmail()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "Bugs";
        String newLN= "Bunny";
        String newPhone = "239-210-2020";
        String newEmail = "";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(0,newFN, newLN, newPhone, newEmail);
        assertEquals("Bugs", contact.getContacts().get(0).getFirstName());
        assertEquals("Bunny", contact.getContacts().get(0).getLastName());
        assertEquals("239-210-2020", contact.getContacts().get(0).getPhone());
        assertEquals("", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void editingFailsWithInvalidEmail()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "Bugs";
        String newLN= "Bunny";
        String newPhone = "239-210-2020";
        String newEmail = "bugsbunnygmailcom";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(0,newFN, newLN, newPhone, newEmail);
        assertEquals("Bugs", contact.getContacts().get(0).getFirstName());
        assertEquals("Bunny", contact.getContacts().get(0).getLastName());
        assertEquals("239-210-2020", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void editingSucceedsWithNonBlankValues()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        String newFN = "Bugs";
        String newLN= "Bunny";
        String newPhone = "239-210-2020";
        String newEmail = "bugsbunny@gmail.com";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
        assertEquals("Tiger", contact.getContacts().get(0).getLastName());
        assertEquals("239-240-1010", contact.getContacts().get(0).getPhone());
        assertEquals("tonytiger@gmail.com", contact.getContacts().get(0).getEmail());

        contact.editItem(0,newFN, newLN, newPhone, newEmail);
        assertEquals("Bugs", contact.getContacts().get(0).getFirstName());
        assertEquals("Bunny", contact.getContacts().get(0).getLastName());
        assertEquals("239-210-2020", contact.getContacts().get(0).getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getContacts().get(0).getEmail());
    }

    @Test
    public void newListIsEmpty()
    {
        ContactList contact = new ContactList();

        assertTrue(contact.getContacts().isEmpty());
    }

    @Test
    public void removingItemsDecreasesSize()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals(1, contact.getContacts().size());

        contact.removeItem(0);
        assertEquals(0, contact.getContacts().size());
    }

    @Test
    public void removingItemsFailsWithInvalidIndex()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);
        assertEquals(1, contact.getContacts().size());

        contact.removeItem(1);
        assertEquals(1, contact.getContacts().size());
    }

    @Test
    public void savedContactListCanBeLoaded()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        ContactList contact = new ContactList();
        contact.newItem(firstName, lastName, phone, email);

        File name = new File("savedContactListCanBeLoaded.txt");
        contact.saveItem(name);
        assertTrue(name.exists());

        contact.loadItem(name);
        assertEquals("Tony", contact.getContacts().get(0).getFirstName());
    }

}