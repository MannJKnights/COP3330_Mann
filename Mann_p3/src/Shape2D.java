abstract class Shape2D extends Shape // Abstract class for 2D shapes, which pulls from the Shape class
{
    @Override
    public String getName() // Two override methods to prevent errors in Java
    {
        return null;
    }
    @Override
    public double getArea()
    {
        return 0;
    }
}
class Square extends Shape2D // Subclass of Square
{
    private final double length;

    Square(double length) // Collects the data values to be used in getArea
    {
        this.length = length;
    }

    public String getName() // Name
    {
        return "square";
    }

    public double getArea() // Area Formula
    {
        return length * length;
    }
}

class Triangle extends Shape2D // Subclass of Triangle
{
    private final double length;
    private final double width;

    Triangle(double length, double width) // Collects the data values to be used in getArea
    {
        this.length = length;
        this.width = width;
    }

    @Override
    public String getName() // Name
    {
        return "triangle";
    }

    @Override
    public double getArea() // Area formula
    {
        return 0.5 * (length * width);
    }
}

class Circle extends Shape2D // Subclass of Circle
{
    private final double radius;

    Circle(double radius) // Collects data values to be used in getArea
    {
        this.radius = radius;
    }

    @Override
    public String getName() // Name
    {
        return "circle";
    }

    @Override
    public double getArea() // Area Formula
    {
        return Math.PI * (radius * radius);
    }
}

