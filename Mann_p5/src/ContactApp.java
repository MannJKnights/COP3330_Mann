import java.io.File;
import java.util.Scanner;

public class ContactApp
{
    public static void contactMenu()
    {
        // Contact Menu with a scanner for user to navigate through the menu
        int menuInput;
        while (true) {
            Scanner userChoice = new Scanner(System.in);

            System.out.println("Contact Menu");
            System.out.println("----------");
            System.out.println("1) Create a New List");
            System.out.println("2) Load an Existing List");
            System.out.println("3) Quit to Main Menu");

            // Switch to iterate through the choices
            menuInput = userChoice.nextInt();
            switch (menuInput)
            {
                // First choice creates a new ContactList and then calls to the second menu screen
                case 1 -> {
                    ContactList contacts = new ContactList();
                    System.out.println("New contact list has been created!");
                    System.out.println(" ");

                    secondMenu(contacts);
                }
                // Second choice loads in a file and then sends that ContactList to the second menu screen
                // IMPORTANT NOTE: Can only load files saved in the same program!
                case 2 -> {
                    System.out.println("Please input file name to load!");
                    Scanner fileName = new Scanner(System.in);
                    String loadFiler = fileName.nextLine();
                    ContactList contacts = new ContactList();

                    contacts.loadItem(new File(loadFiler));
                    System.out.println(" ");

                    // Makes sure that the file loaded has content in it before sending to second menu
                    if(!contacts.getContacts().isEmpty())
                    {
                        secondMenu(contacts);
                    }
                }
                // Third choice returns user to main menu
                case 3 -> {
                    return;
                }
            }
        }
    }

    // Second contact menu
    public static void secondMenu(ContactList contacts)
    {
        // Menu with scanner to help user navigate through the menu
        int exitC = 0;
        while (exitC == 0)
        {
            System.out.println("List Operation Menu");
            System.out.println("--------------------");
            System.out.println("1) View the List");
            System.out.println("2) Add an Item");
            System.out.println("3) Edit an Item");
            System.out.println("4) Remove an Item");
            System.out.println("5) Save the Current List");
            System.out.println("6) Quit to the Contact Menu");

            Scanner user2 = new Scanner(System.in);
            int menu2 = user2.nextInt();

            // Switch to iterate through choices
            switch (menu2) {
                // First choice shows all the current contacts by calling the method in ContactList
                case 1 -> contacts.showItem();
                // Second choice creates a new contact by gathering input and then sending that to the method in ContactList
                case 2 -> {
                    Scanner contactItems = new Scanner(System.in);

                    System.out.println("Please enter your contact's first name:");
                    String firstName = contactItems.nextLine();
                    System.out.println("Please enter your contact's last name:");
                    String lastName = contactItems.nextLine();
                    System.out.println("Please enter your contact's phone number (XXX-XXX-XXXX):");
                    String phone = contactItems.nextLine();
                    System.out.println("Please enter your contact's email (x@y.z):");
                    String email = contactItems.nextLine();

                    contacts.newItem(firstName, lastName, phone, email);
                }
                // Third choice edits contacts already made by taking the new data and sending it to the method in ContactList
                case 3 -> {
                    contacts.showItem();
                    // Checks if the list is empty
                    if(contacts.checkArray())
                    {
                        System.out.println("Which contact will you edit?");

                        Scanner arrayChoice = new Scanner(System.in);
                        int line = arrayChoice.nextInt();
                        Scanner newContactItems = new Scanner(System.in);

                        System.out.println("Please enter your contact's first name:");
                        String firstName = newContactItems.nextLine();
                        System.out.println("Please enter your contact's last name:");
                        String lastName = newContactItems.nextLine();
                        System.out.println("Please enter your contact's phone number (XXX-XXX-XXXX):");
                        String phone = newContactItems.nextLine();
                        System.out.println("Please enter your contact's email (x@y.z):");
                        String email = newContactItems.nextLine();

                        contacts.editItem(line, firstName, lastName, phone, email);
                    }
                }
                // Fourth choice removes contacts from the list by calling the method in ContactList
                case 4 -> {
                    contacts.showItem();

                    // Checks if the list is empty
                    if(contacts.checkArray())
                    {
                        System.out.println("Which contact will you remove?");

                        Scanner arrayChoice = new Scanner(System.in);
                        int line = arrayChoice.nextInt();
                        contacts.removeItem(line);
                    }
                }
                // Seventh choice saves a file to the same folder as the .java
                // IMPORTANT NOTE: Can only load files saved in the same program!
                case 5 -> {
                    String h;
                    System.out.println("Please input file name to save!");
                    Scanner fileName = new Scanner(System.in);
                    h = fileName.nextLine();

                    File y = new File(h);
                    contacts.saveItem(y);
                    System.out.println(" ");
                }
                // Eighth choice sends user back to Contact Menu
                case 6 -> exitC = 1;
            }
        }
    }
}