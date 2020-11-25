import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactItemTest
{
    @Test
    public void creationFailsWithAllBlankValues()
    {
        String firstName = "";
        String lastName= "";
        String phone = "";
        String email = "";

        ContactList contact = new ContactList();
        assertEquals(0, contact.getContacts().size());

        contact.newItem(firstName, lastName, phone, email);
        assertEquals(0, contact.getContacts().size());
    }

    @Test
    public void creationSucceedsWithBlankEmail()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-245-1010";
        String email = "";

        ContactList contact = new ContactList();
        assertEquals(0, contact.getContacts().size());

        contact.newItem(firstName, lastName, phone, email);
        assertEquals(1, contact.getContacts().size());
    }
    @Test
    public void creationSucceedsWithBlankFirstName()
    {
        String firstName = "";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        ContactList contact = new ContactList();
        assertEquals(0, contact.getContacts().size());

        contact.newItem(firstName, lastName, phone, email);
        assertEquals(1, contact.getContacts().size());
    }

    @Test
    public void creationSucceedsWithBlankLastName()
    {
        String firstName = "Tony";
        String lastName= "";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        ContactList contact = new ContactList();
        assertEquals(0, contact.getContacts().size());

        contact.newItem(firstName, lastName, phone, email);
        assertEquals(1, contact.getContacts().size());
    }

    @Test
    public void creationSucceedsWithBlankPhone()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "";
        String email = "tonytiger@gmail.com";

        ContactList contact = new ContactList();
        assertEquals(0, contact.getContacts().size());

        contact.newItem(firstName, lastName, phone, email);
        assertEquals(1, contact.getContacts().size());
    }

    @Test
    public void creationSucceedsWithNonBlankValues()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-210-2020";
        String email = "tonytiger@gmail.com";

        ContactList contact = new ContactList();
        assertEquals(0, contact.getContacts().size());

        contact.newItem(firstName, lastName, phone, email);
        assertEquals(1, contact.getContacts().size());
    }

    @Test
    public void editingFailsWithAllBlankValues()
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

        ContactItem contact = new ContactItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getFirstName());
        assertEquals("Tiger", contact.getLastName());
        assertEquals("239-240-1010", contact.getPhone());
        assertEquals("tonytiger@gmail.com", contact.getEmail());

        contact.setFirstName(newFN);
        contact.setLastName(newLN);
        contact.setPhone(newPhone);
        contact.setEmail(newEmail);

        assertEquals("Bugs", contact.getFirstName());
        assertEquals("Bunny", contact.getLastName());
        assertEquals("239-210-2020", contact.getPhone());
        assertEquals("", contact.getEmail());
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

        ContactItem contact = new ContactItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getFirstName());
        assertEquals("Tiger", contact.getLastName());
        assertEquals("239-240-1010", contact.getPhone());
        assertEquals("tonytiger@gmail.com", contact.getEmail());

        contact.setFirstName(newFN);
        contact.setLastName(newLN);
        contact.setPhone(newPhone);
        contact.setEmail(newEmail);

        assertEquals("", contact.getFirstName());
        assertEquals("Bunny", contact.getLastName());
        assertEquals("239-210-2020", contact.getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getEmail());
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

        ContactItem contact = new ContactItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getFirstName());
        assertEquals("Tiger", contact.getLastName());
        assertEquals("239-240-1010", contact.getPhone());
        assertEquals("tonytiger@gmail.com", contact.getEmail());

        contact.setFirstName(newFN);
        contact.setLastName(newLN);
        contact.setPhone(newPhone);
        contact.setEmail(newEmail);

        assertEquals("Bugs", contact.getFirstName());
        assertEquals("", contact.getLastName());
        assertEquals("239-210-2020", contact.getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getEmail());
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

        ContactItem contact = new ContactItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getFirstName());
        assertEquals("Tiger", contact.getLastName());
        assertEquals("239-240-1010", contact.getPhone());
        assertEquals("tonytiger@gmail.com", contact.getEmail());

        contact.setFirstName(newFN);
        contact.setLastName(newLN);
        contact.setPhone(newPhone);
        contact.setEmail(newEmail);

        assertEquals("Bugs", contact.getFirstName());
        assertEquals("Bunny", contact.getLastName());
        assertEquals("", contact.getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getEmail());
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

        ContactItem contact = new ContactItem(firstName, lastName, phone, email);
        assertEquals("Tony", contact.getFirstName());
        assertEquals("Tiger", contact.getLastName());
        assertEquals("239-240-1010", contact.getPhone());
        assertEquals("tonytiger@gmail.com", contact.getEmail());

        contact.setFirstName(newFN);
        contact.setLastName(newLN);
        contact.setPhone(newPhone);
        contact.setEmail(newEmail);

        assertEquals("Bugs", contact.getFirstName());
        assertEquals("Bunny", contact.getLastName());
        assertEquals("239-210-2020", contact.getPhone());
        assertEquals("bugsbunny@gmail.com", contact.getEmail());
    }

    @Test
    public void testToString()
    {
        String firstName = "Tony";
        String lastName= "Tiger";
        String phone = "239-240-1010";
        String email = "tonytiger@gmail.com";

        ContactItem contact = new ContactItem(firstName, lastName, phone, email);

        assertEquals("Name: Tony Tiger\nPhone: 239-240-1010\nEmail: tonytiger@gmail.com", contact.toString());
    }
}