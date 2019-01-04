import JUnit.Point;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {

    List<Point> pointList = new ArrayList<>();
    @BeforeEach
    public void getPointList()
    {
        pointList.add(new Point((int) (Math.random() * 100), (int) (Math.random() * 100)));
        pointList.add(new Point((int) (Math.random() * 100), (int) (Math.random() * 100)));
    }

    @BeforeEach
    public void beforeTest()
    {
        System.out.println("Start Test");
    }

    @AfterEach
    public void afterTest()
    {
        System.out.println("Testing is done!");
    }

    @Test
    public void test1()
    {
        Point p = new Point(2,2);
        Point q = new Point(6,2);
        int distance = p.getDistance(q);
        int realDistance = 4;
        assertEquals(realDistance, distance);
        System.out.println(p +"\n" + q);
    }
    @Test
    public void test2()
    {
        Point p = new Point(2,4);
        Point q = new Point(4,1);
        int distance = p.getDistance(q);
        int realDistance = 5;
        assertEquals(realDistance, distance);
        System.out.println(p +"\n" + q);
    }
    @Test
    public void test3()
    {
        Point p = pointList.get(0);
        Point q = pointList.get(1);
        int distance = p.getDistance(q);
        int realDistance = Math.abs(p.getX() - q.getX()) + Math.abs(p.getY() - q.getY());
        assertEquals(realDistance, distance);
        System.out.println(p +"\n" + q);
    }
    @Test
    public void test4()
    {
        Point p = pointList.get(0);
        Point q = pointList.get(1);
        int distance = p.getDistance(q);
        int realDistance = Math.abs(p.getX() - q.getX()) + Math.abs(p.getY() - q.getY());
        assertEquals(realDistance, distance);
        System.out.println(p +"\n" + q);
    }
    @Test
    public void test5()
    {
        Point p = pointList.get(0);
        Point q = pointList.get(1);
        int distance = p.getDistance(q);
        int realDistance = Math.abs(p.getX() - q.getX()) + Math.abs(p.getY() - q.getY());
        assertEquals(realDistance, distance);
        System.out.println(p +"\n" + q);
    }
    @Test
    public void test6()
    {
        Point p = pointList.get(0);
        Point q = pointList.get(1);
        int distance = p.getDistance(q);
        int realDistance = Math.abs(p.getX() - q.getX()) + Math.abs(p.getY() - q.getY());
        assertEquals(realDistance, distance);
        System.out.println(p +"\n" + q);
    }
}
