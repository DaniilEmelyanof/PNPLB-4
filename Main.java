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
        ArrayList<Point>list_point = new ArrayList<Point>();//объект ArrayList с типом данных Point
        for (int i = 0; i < N;i++)
        {
            System.out.println("x = ");
            int x_temp = write.nextInt();
            System.out.println("y = ");
            int y_temp = write.nextInt();
            list_point.add(new Point(x_temp, y_temp));//добавление в список нового объекта класса Parallelepiped, с установленными нами парметрами x, y
        }
        Collections.sort(list_point, new Comparator<Point>()
        {//производим сортировку нашей коллекции (эрейлиста)
            //в сигнатуру сортировки передаем саму коллекцию и компаратор, где тоже указан тип данных - Point
            @Override
            public int compare(Point o1, Point o2)//переопределенный метод compare, в сигнатуре которого два объекта класса Point
             /*
             ???
             ???????????Как работает компаратор?????
             Его методу на вход подаются два объекта класса, которые мы хотим сравнивать.
             поскольку метод типа "int", то возвращать он тоже должен int
             он возвращает 1, если первый объект будет больше второго (Parallelepiped o1 > Parallelepiped o2)
             вернет 0, если их значения равны, и вернет -1, если второй больше первого.
             ???
             */
            {
                int result_degree = o1.degree_of_deviation.compareTo(o2.degree_of_deviation);
                //рез-т сравнения углов отклонения
                if (result_degree == 0)//если одинковые
                {
                    return o1.x.compareTo(o2.x);//то возвращаем рез-т сравнения по иксу
                }
                return result_degree;
            }
        });


        for (Object obj:list_point)//вывод рез-та
        {
            Point p = (Point) obj;//парсинг obj в Point
            System.out.println("("+p.x+","+p.y+")" + "-" + "<Угол отклонения:"+p.toString()+">");
        }
    }
}
//сортировка по у/х
// если это совпадает, то первой должна идти точка, у которой меньше х
//вывод в виде (х,у) - <угол отклонения: у/х>