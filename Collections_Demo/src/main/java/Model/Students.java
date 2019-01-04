package Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Students {
    private int studentId;
    private String studentName;
//    private List<GradeEntry> gradeEntryList = new ArrayList<>(); Also can use this!
    private List<GradeEntry> gradeEntryList;

    public Students() {
        gradeEntryList = new ArrayList<>();
    }

    public Students(int studentId, String studentName) {
        this();
        this.studentId = studentId;
        this.studentName = studentName;
    }

    /*public Students(int studentId, String studentName, List<GradeEntry> gradeEntryList) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.gradeEntryList = gradeEntryList;
    }*/

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public List<GradeEntry> getGradeEntryList() {
        return gradeEntryList;
    }

    public double getCgpa()
    {
        Map<Course, Grade> gradeMap = new HashMap<>();
        double sumCredit = 0.0;
        double sumGradePoint = 0.0;
        for(GradeEntry gradeEntry : gradeEntryList)
        {
            Course course = gradeEntry.getCourse();
            Grade grade = gradeMap.get(course);
            if(grade == null)
            {
                Grade Currentgrade = gradeEntry.getGrade();
                gradeMap.put(course, Currentgrade);
            }
            else
            {
                Grade newGrade = gradeEntry.getGrade();
                if(newGrade.getNumericGrade() > grade.getNumericGrade())
                {
                    grade = newGrade;
                }
                gradeMap.put(course,grade);
            }
        }

//        gradeMap.forEach((key, value) -> {
//
//        });
        for (Map.Entry grade: gradeMap.entrySet()) {
            Course course = (Course) grade.getKey();
            Grade grade1 = (Grade) grade.getValue();
            sumCredit += course.getCourseCredit();
            sumGradePoint += course.getCourseCredit() * grade1.getNumericGrade();
        }

        return sumGradePoint/sumCredit;
    }

    public Map<Course,Grade> studentFullResultDetails()
    {
        Map<Course,Grade> gradeMap = new HashMap<>();

        for (GradeEntry gradeEntry: gradeEntryList) {
            Course course = gradeEntry.getCourse();
            Grade grade = gradeMap.get(course);
            if(grade == null)
            {
                Grade Currentgrade = gradeEntry.getGrade();
                gradeMap.put(course, Currentgrade);
            }
            else
            {
                Grade newGrade = gradeEntry.getGrade();
                if(newGrade.getNumericGrade() > grade.getNumericGrade())
                {
                    grade = newGrade;
                }
                gradeMap.put(course,grade);
            }
        }

        return  gradeMap;
    }

    public double getTermGpa(int semesterId)
    {
        double sumCredit = 0.0;
        double sumGradePoint = 0.0;
        for (GradeEntry gradeEntry: gradeEntryList) {
            if (semesterId == gradeEntry.getSemesterId())
            {
                sumCredit += gradeEntry.getCourse().getCourseCredit();
                sumGradePoint += gradeEntry.getCourse().getCourseCredit() * gradeEntry.getGrade().getNumericGrade();
            }
        }
        return sumGradePoint/sumCredit;
    }

    @Override
    public String toString() {
        return "Students{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gradeEntryList=" + gradeEntryList +
                '}';
    }
}
