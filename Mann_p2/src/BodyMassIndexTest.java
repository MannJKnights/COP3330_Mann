import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest
{
    @Test
    public void bmiTest() // Tests the BMI code
    {
        BodyMassIndex h = new BodyMassIndex(74, 197.8);
        assertEquals(25.4, h.bmi);
    }

    @Test
    public void underweightTest() // Tests the underweight category
    {
        BodyMassIndex h = new BodyMassIndex(74, 100);
        assertEquals("Underweight = < 18.5", h.bmiCat());
    }

    @Test
    public void normalweightTest() // Tests the normal weight category
    {
        BodyMassIndex h = new BodyMassIndex(74, 170);
        assertEquals("Normal weight = 18.5 - 24.9", h.bmiCat());
    }

    @Test
    public void overweightTest() // Tests the overweight category
    {
        BodyMassIndex h = new BodyMassIndex(74, 198);
        assertEquals("Overweight = 25 - 29.9", h.bmiCat());
    }

    @Test
    public void obesityTest() // Tests the obese category
    {
        BodyMassIndex h = new BodyMassIndex(74, 270);
        assertEquals("Obesity = BMI of 30 or greater", h.bmiCat());
    }
}