public class BodyMassIndex
{
    public double bmi;
    public BodyMassIndex(double bmiH, double bmiW) // Takes the height and weight, puts them through the formula for BMI
    {
        bmi = (703 * bmiW) / (bmiH * bmiH);
        bmi = (Math.round(bmi * 10.0) / 10.0); // Rounds the BMI to 1 decimal place
    }

    public String bmiCat() // Tests BMI for proper category and returns the string of that category
    {
        if(bmi < 18.5)
        {
            return "Underweight = < 18.5";
        }
        else if(bmi > 18.4 && bmi < 25)
        {
            return "Normal weight = 18.5 - 24.9";
        }
        else if(bmi > 24.9 && bmi < 29)
        {
            return "Overweight = 25 - 29.9";
        }
        else if(bmi > 29)
        {
            return "Obesity = BMI of 30 or greater";
        }

        return null;
    }
}
