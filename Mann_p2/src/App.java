import java.util.ArrayList;
import java.util.Scanner;

public class App
{
    // BMI Calculator
    // Average User BMI
    // BMI Categories for each user
    // No Negative Value
    // Call scanner's nextLine() after reading numeric value

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
        String yOrN = moreInput.nextLine();
        if(yOrN.equals("Y"))
        {
            return true;
        }
        else if(yOrN.equals("N"))
        {
            return false;
        }

        return false;
    }

    public static double getUserHeight()
    {
        Scanner userHeight = new Scanner(System.in);
        double uHeight = -1;
        while(uHeight < 0)
        {
            System.out.println("Please input user height in pounds.");
            uHeight = userHeight.nextDouble();
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
        while(uWeight < 0)
        {
            System.out.println("Please input user weight in pounds.");
            uWeight = userWeight.nextDouble();
            if(uWeight < 0)
            {
                System.out.println("Invalid input");
            }
        }

        return uWeight;
    }

    public static void displayBmiInfo(BodyMassIndex x)
    {
        System.out.println("Your BMI is: " + x.bmi);
        System.out.println(x.bmiCat());
    }

    public static void displayBmiStatistics(ArrayList<BodyMassIndex> y)
    {
        double total = 0;
        for(BodyMassIndex b : y)
        {
            total += b.bmi;
        }
        double finAl = total / y.size();

        System.out.println("Average BMI of users is: " + finAl);
    }
}