import java.util.Scanner;

public class AppMain
{
    // Main Function to show main menu
    public static void main(String[] args)
    {
        System.out.println("Welcome to COP3330 O.O.P's Console-Based Task and Contact List!");

        // Main menu with scanner for user to navigate through the menu
        int userMenu;
        while(true)
        {
            Scanner userChoice = new Scanner(System.in);

            System.out.println("Applications");
            System.out.println("----------");
            System.out.println("1) Task List");
            System.out.println("2) Contact List");
            System.out.println("3) Quit");

            // Switch to iterate through choices
            userMenu = userChoice.nextInt();
            switch (userMenu)
            {
                // First choice sends you to TaskApp to tinker with tasks
                case 1 -> TaskApp.taskMenu();
                // Second choice sends you to ContactApp to tinker with contacts
                case 2 -> ContactApp.contactMenu();
                // Third choice exists the program
                case 3 -> System.exit(0);
            }
        }
    }
}