package Lab_4;

public class Point
{
    public final Integer x,y,degree_of_deviation;
    public Point(Integer x, Integer y)
    {
        this.x = x;
        this.y = y;
        degree_of_deviation = y/x;
    }

    @Override
    public String toString()
    {
        return String.valueOf(degree_of_deviation);
    }

}
