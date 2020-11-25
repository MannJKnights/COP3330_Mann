import java.io.*;
import java.util.ArrayList;

public class ContactList extends ItemList
{
    private ArrayList<ContactItem> contactArray = new ArrayList<>();

    // Method to show all contacts
    @Override
    public void showItem()
    {
        System.out.println("Current Contacts");
        System.out.println("--------------");

        int x = 0;

        // A loop to print out each Contact object going down with each array position printed alongside
        for (ContactItem tmp: getContacts())
        {
            System.out.println(x + ") " + tmp.toString());
            x++;
        }
        System.out.println(" ");
    }

    // Method to create new Contacts
    @Override
    public void newItem(String fName, String lName, String phone, String email)
    {
        ContactItem temp = new ContactItem(fName, lName, phone, email);

        // Checks if any of the variables aren't empty and in correct format
        if(!fName.isEmpty() || !lName.isEmpty() || (!phone.isEmpty() && temp.getPhone() != null) || (!email.isEmpty() && temp.getEmail() != null))
        {
            contactArray.add(temp);

            System.out.println("Contact's Name: " + fName + " " + lName);
            System.out.println("Contact's Phone Number: " + phone);
            System.out.println("Contact's Email: " + email);
            System.out.println(" ");
        }
        // Error message if variables are all empty
        else if(!temp.emptyChecker())
        {
            System.out.println("WARNING - Categories Can't All Be Empty");
        }
    }

    // Method to edit Contacts
    @Override
    public void editItem(int choice, String newFN, String newLN, String newPhone, String newEmail)
    {
        // Checks if the inputted number is within the ArrayList bounds
        if(checkIndex(choice))
        {
            ContactItem temp = new ContactItem(newFN, newLN, newPhone, newEmail);

            // Checks if any of the variables aren't empty and in correct format
            if(!newFN.isEmpty() || !newLN.isEmpty() || (!newPhone.isEmpty() && temp.getPhone() != null) || (!newEmail.isEmpty() && temp.getEmail() != null))
            {
                contactArray.get(choice).setFirstName(newFN);
                contactArray.get(choice).setLastName(newLN);
                contactArray.get(choice).setPhone(newPhone);
                contactArray.get(choice).setEmail(newEmail);
            }
            // Error message if variables are all empty
            else if(!temp.emptyChecker())
            {
                System.out.println("WARNING - Categories Can't All Be Empty");
            }
        }
    }

    // Method to remove Contacts
    @Override
    public void removeItem(int choice)
    {
        // Checks if the inputted number is within ArrayList bounds
        if(checkIndex(choice))
        {
            contactArray.remove(choice);
        }
    }

    // Method to save a file to the same file as the .java application
    // IMPORTANT NOTE: Can only load files saved in the same program!
    @Override
    public void saveItem(File file)
    {
        // A try-catch method to save the file
        try
        {
            FileOutputStream writer = new FileOutputStream(file);
            ObjectOutputStream writer2 = new ObjectOutputStream(writer);
            writer2.writeObject(contactArray);
            writer2.close();
            writer.close();

            System.out.println("Contact List has been saved!");
        }
        // Error message if couldn't save properly
        catch (IOException e)
        {
            System.out.println("An error has occurred!");
        }
    }

    // Method to load a file with a Contact List
    // IMPORTANT NOTE: Can only load files saved in the same program!
    @Override
    public void loadItem(File file)
    {
        // A try-catch method to load a file
        try
        {
            FileInputStream reader = new FileInputStream(file);
            ObjectInputStream reader1 = new ObjectInputStream(reader);
            contactArray = (ArrayList<ContactItem>)reader1.readObject();
            reader1.close();

            System.out.println("Contact List has been Loaded!");
        }
        // Error message if file wasn't loaded properly
        catch (IOException | ClassNotFoundException e)
        {
            System.out.println("An error has occurred!");
        }
    }

    // Method to check if array is empty
    @Override
    public boolean checkArray()
    {
        if(!contactArray.isEmpty())
        {
            return true;
        }
        else
        {
            System.out.println("Contact List is Currently Empty!");
            System.out.println(" ");
            return false;
        }
    }

    // Method to check if user input is within array list bounds
    @Override
    public boolean checkIndex(int index)
    {
        // If loop that checks if the number was below bounds or above bounds
        if(index < 0 || index >= contactArray.size())
        {
            System.out.println("Contact Does Not Exist!");
            System.out.println(" ");
            return false;
        }
        else
        {
            return true;
        }
    }

    // Method to get all objects within arraylist
    public ArrayList<ContactItem> getContacts()
    {
        return contactArray;
    }
}