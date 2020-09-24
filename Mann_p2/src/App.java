import java.util.ArrayList; // Imports for ArraysLists and Scanners
import java.util.Scanner;

public class App
{
    public static void main(String[] args)
    {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput())
        {
            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    public static boolean moreInput()
    {
        Scanner moreInput = new Scanner(System.in);
        System.out.println("Enter 'Y' or 'N' to continue the program or exit");
        String yOrN = moreInput.nextLine(); // Creates a new scanner and string to test if the user typed Yes or No
        if(yOrN.equals("Y"))
        {
            return true; // If true it continues the while loop in main
        }
        else if(yOrN.equals("N"))
        {
            return false; // If false it stops the while loop
        }

        return false;
    }

    public static double getUserHeight()
    {
        Scanner userHeight = new Scanner(System.in);
        double uHeight = -1;
        while(uHeight < 0) // A while loop to test if the numbers are negative or not
        {
            System.out.println("Please input user height in pounds.");
            uHeight = userHeight.nextDouble(); // A code to get the user's height
            if(uHeight < 0)
            {
                System.out.println("Invalid input");
            }
        }

        return uHeight;
    }

    public static double getUserWeight()
    {
        Scanner userWeight = new Scanner(System.in);
        double uWeight = -1;
        while(uWeight < 0) // Tests if numbers are negative or not
        {
            System.out.println("Please input user weight in pounds.");
            uWeight = userWeight.nextDouble(); // Gets the user's weight
            if(uWeight < 0)
            {
                System.out.println("Invalid input");
            }
        }

        return uWeight;
    }

    public static void displayBmiInfo(BodyMassIndex x)
    {
        System.out.println("Your BMI is: " + x.bmi); // Code to give your BMI and your category
        System.out.println(x.bmiCat());
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> y)
    {
        double total = 0; // Code that takes the user's bmi in the arraylist and averages it
        for(BodyMassIndex b : y)
        {
            total += b.bmi;
        }
        double finAl = total / y.size();

        System.out.println("Average BMI of users is: " + finAl);
    }
}