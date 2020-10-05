abstract class Shape3D extends Shape // Abstract class for 3D shapes, which pulls from Shape
{
    public abstract double getVolume(); // Abstract method for getting the volume

    @Override
    public String getName() // Two override methods to prevent errors in Java
    {
        return "cube";
    }

    @Override
    public double getArea()
    {
        return 0;
    }
}
class Cube extends Shape3D // Subclass of Cube
{
    private final double length;

    Cube(double length) // Collects the data values to be used in getArea and getVolume
    {
        this.length = length;
    }

    public String getName() // Name
    {
        return "cube";
    }

    public double getArea() // Area formula
    {
        return 6 * (length * length);
    }

    @Override
    public double getVolume() // Volume formula
    {
        return (length * length * length);
    }
}

class Pyramid extends Shape3D // Subclass of Pyramid
{
    private final double length;
    private final double width;
    private final double height;

    Pyramid(double length, double width, double height) // Collects the data values to be used in getArea and getVolume
    {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public String getName() // Name
    {
        return "pyramid";
    }

    public double getArea() // Area formula
    {
        double a = (length * Math.sqrt((width / 2) * (width / 2) + (height * height)));
        double b = (width * Math.sqrt((length / 2) * (length / 2)  + (height * height)));

        return (length * width) + a + b;
    }

    @Override
    public double getVolume() // Volume formula
    {
        return (length * width * height) / 3;
    }
}

class Sphere extends Shape3D // Subclass of Sphere
{
    private final double radius;

    Sphere(double radius) // Collects the data values to be in getArea and getVolume
    {
        this.radius = radius;
    }

    public String getName() // Name
    {
        return "sphere";
    }

    public double getArea() // Area formula
    {
        return 4 * Math.PI * (radius * radius);
    }

    @Override
    public double getVolume() // Volume formula
    {
        return (4.0 / 3.0) * Math.PI * (radius * radius * radius);
    }
}