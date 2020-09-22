public class BodyMassIndex
{
    public double bmi;
    public BodyMassIndex(double bmiH, double bmiW)
    {
        bmi = (703 * bmiW) / (bmiH * bmiH);
        bmi = (Math.round(bmi * 10.0) / 10.0);
    }

    public String bmiCat()
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
