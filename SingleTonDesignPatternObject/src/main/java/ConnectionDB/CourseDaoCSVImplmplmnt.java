package ConnectionDB;

import Model.Course;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

public class CourseDaoCSVImplmplmnt implements CourseDao {

    private List<Course> courseList;

    @Override
    public List<Course> getALL() {
        courseList = new ArrayList<>();

        try(RandomAccessFile input = new RandomAccessFile("studentdemo.csv","r"))
        {
            System.out.println("try to read the file");
            String line;
            while ((line = input.readLine()) != null)
            {
//                System.out.println(line);

                // By using normal method substring
                int commaIndex = line.indexOf(",");
                String s1 = line.substring(1,commaIndex - 1);
                int id = Integer.parseInt(s1);

                String s2 = line.substring(commaIndex + 1);

                int commaIndex1 =  s2.indexOf(",");
                String  code = s2.substring(1,commaIndex1 - 1);
                String  s3 = s2.substring(commaIndex1+1);

                int commaIndex2 =  s3.indexOf(",");
                String  s4 = s3.substring(1,commaIndex2 - 1);
                int credit = Integer.parseInt(s4);

                String  title = s3.substring(commaIndex2+2 , s3.length()-1);

                Course course = new Course(id,code,title,credit);
                courseList.add(course);

                // By using Split

                /*String[] c = line.split(",");

                    Course course = new Course(
                            Integer.parseInt(c[0].substring(1,c[0].length()-1)),
                            c[1].substring(1,c[1].length() - 1),
                            c[3].substring(1,c[3].length() - 1),
                            Integer.parseInt(c[2].substring(1,c[2].length() - 1))
                    );
                    courseList.add(course);*/
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courseList;
    }

    @Override
    public boolean deleteData(int id) {

        List<Course> list = getALL();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == id)
            {
                list.remove(i);
            }
        }

        try(RandomAccessFile output = new RandomAccessFile("studentdemo.csv","rw")) {

            output.setLength(0);

            for (Course c : list) {
                String format =  String.format("\"%d\",\"%s\",\"%d\",\"%s\"\n",
                                                c.getId(), c.getCourseCode(),c.getCourseCredit(),c.getCourseTitle());

                output.writeBytes(format);
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean updateData(Course course) {

        List<Course> list = getALL();
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getId() == course.getId())
            {
                list.set(i,course);
            }
        }

        try(RandomAccessFile output = new RandomAccessFile("studentdemo.csv","rw")) {

            output.setLength(0);

            for (Course c : list) {
                String format =  String.format("\"%d\",\"%s\",\"%d\",\"%s\"\n",
                        c.getId(), c.getCourseCode(),c.getCourseCredit(),c.getCourseTitle());

                output.writeBytes(format);
            }
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

}
