package Lab_4;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;

public class Main
{
    public static void main(String[] args)
    {
        Scanner write = new Scanner(System.in);
        System.out.println("write N: ");
        int N = write.nextInt();
        ArrayList<Point>list_point = new ArrayList<Point>(); 
        for (int i = 0; i < N;i++)
        {
            System.out.println("x = ");
            int x_temp = write.nextInt();
            System.out.println("y = ");
            int y_temp = write.nextInt();
            list_point.add(new Point(x_temp, y_temp)); 
        }
        Collections.sort(list_point, new Comparator<Point>()
        { 
            @Override
            public int compare(Point o1, Point o2) 
            {
                int result_degree = o1.degree_of_deviation.compareTo(o2.degree_of_deviation);
               
                if (result_degree == 0) 
                {
                    return o1.x.compareTo(o2.x); 
                }
                return result_degree;
            }
        });


        for (Object obj:list_point)
        {
            Point p = (Point) obj; 
            System.out.println("("+p.x+","+p.y+")" + "-" + "<Угол отклонения:"+p.toString()+">");
        }
    }
}
