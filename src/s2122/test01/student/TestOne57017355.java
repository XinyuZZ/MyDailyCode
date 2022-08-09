package s2122.test01.student;

import java.util.*;
import java.util.Map.Entry;

/*==============================================================================

EE3206 Test 1

Student Name: ZHU Xinyu
Student ID: 57017355

================================================================================

This template has two classes: TestOneXXXXXXXX and Student.

TestOneXXXXXXXX is the main class. You should rename it by entering your student ID to replace
the string XXXXXXXX.

Student is an immutable class representing a student. It has a CSV string that contains the
information of 1000 students.

You are asked to implement all methods specified below:
(1) createList
(2) function1
(3) function2

You should refer to the detailed requirements written in each method.

You should NOT modify any other parts of this template, except importing classes.

You should NOT use any external libraries other than the JDK.

Below are the expected output from the main method:

=== Creating a student list: ===
1000 students have been created.

=== Math Scores ===
MALE : 68.73(avg) 14.34(stdev)
FEMALE : 63.63(avg) 15.48(stdev)

=== Math Scores / Parental Education Level (sorted) ===
high school = 62.13775510204081
some high school = 63.497206703910614
some college = 67.1283185840708
associate degree = 67.88288288288288
bachelor degree = 69.38983050847457
master degree = 69.7457627118644

==============================================================================*/
public class TestOne57017355 {

    public static void main(String[] args) {

        // Create a list of Student objects
        System.out.println("=== Creating a student list: ===");
        List<Student> students = Student.createList();
        System.out.println(students.size() + " students have been created.");
        System.out.println("");
        Map<Student.Gender, Double[]> map = function1(students);
        System.out.println("=== Math Scores ===");
        for (Entry<Student.Gender, Double[]> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue()[0] + "(avg) " + entry.getValue()[1] + "(stdev) ");
        }
        System.out.println("");

        List<Entry<String, Double>> list = function2(students);
        System.out.println("=== Math Scores / Parental Education Level (sorted) ===");
        for (Entry<String, Double> e : list) {
            System.out.println(e.getKey() + " = " + e.getValue());
        }
    }

    /**
     * Calculate the mean and standard deviation of the math scores for each gender.
     * <p>
     * The function returns a map that associates a gender (key) to a double array (value).
     * <p>
     * The 1st and 2nd elements of the array store the mean and standard deviation of the
     * math scores of a gender.
     * <p>
     * Both the mean and standard deviation should be rounded to 2 decimal places.
     *
     * @param list a list of students
     * @return a map that associates genders to computed math scores.
     */
    public static Map<Student.Gender, Double[]> function1(List<Student> list) {
        List<Student> boysList = new ArrayList<>();
        List<Student> girlsList = new ArrayList<>();
        for (Student index : list) {
            if (index.getGender() == Student.Gender.MALE) {
                boysList.add(index);
            } else {
                girlsList.add(index);
            }
        }

        Double[] maleValue = new Double[2];
        Double[] girlValue = new Double[2];
        double avgScoreForMale = 0;
        double avgScoreForGirl = 0;
        double devScoreForMale = 0;
        double devScoreForGirl = 0;

        for (Student index : boysList) {
            avgScoreForMale += index.getMath();
        }
        avgScoreForMale = avgScoreForMale / boysList.size();
        for (Student index : boysList) {
            devScoreForMale += Math.pow((index.getMath() - avgScoreForMale), 2);
        }
        devScoreForMale = Math.sqrt(devScoreForMale / boysList.size());

        // girlsList

        for (Student index : girlsList) {
            avgScoreForGirl += index.getMath();
        }
        avgScoreForGirl = avgScoreForGirl / girlsList.size();
        for (Student index : girlsList) {
            devScoreForGirl += Math.pow((index.getMath() - avgScoreForGirl), 2);
        }
        devScoreForGirl = Math.sqrt(devScoreForGirl / girlsList.size());

        HashMap<Student.Gender, Double[]> genderHashMap = new HashMap<>();
        maleValue[0] = (double) Math.round(avgScoreForMale * 100) / 100;
        maleValue[1] = (double) Math.round(devScoreForMale * 100) / 100;
        girlValue[0] = (double) Math.round(avgScoreForGirl * 100) / 100;
        girlValue[1] = (double) Math.round(devScoreForGirl * 100) / 100;
        genderHashMap.put(Student.Gender.MALE, maleValue);
        genderHashMap.put(Student.Gender.FEMALE, girlValue);
        return genderHashMap;
    }

    /**
     * Calculate the mean math score for each parental education level.
     * <p>
     * The function returns a sorted list of entries. Each entry is a pair of
     * parental education level (key) and the mean math score (value).
     * <p>
     * The entries are sorted by their mean math scores in ascending order.
     * <p>
     * The implementation should be a general solution that supports any number
     * of parental education levels from the CSV input. In other words, the
     * implementation should not hard code any parental education level in the program.
     *
     * @param list a list of students
     * @return a list of entries that associate the parental education levels to the mean
     * math score
     */
    public static List<Entry<String, Double>> function2(List<Student> list) {

//        Map<String, Integer[]> map = new HashMap<>();
//        for (Student student : list) {
//            String level = student.getLevel();
//            if (map.containsKey(level)) {
//                Integer[] temp = map.get(level);
//                temp[0] += student.getMath();       // sum of scores
//                temp[1]++;                          // count
//                map.put(level, temp);
//            } else {
//                map.put(level, new Integer[]{student.getMath(), 1});
//            }
//        }
//
//        List<Entry<String, Double>> result = new ArrayList<>();
//        for(Entry<String, Integer[]> entry : map.entrySet()) {
//            result.add(Map.entry(entry.getKey(), (double) entry.getValue()[0]/entry.getValue()[1]));
//        }
//        result.sort(Entry.comparingByValue());


//        List<Student> highSchool = new ArrayList<>();
//        List<Student> someHighSchool = new ArrayList<>();
//        List<Student> someCollege = new ArrayList<>();
//        List<Student> associateDegree = new ArrayList<>();
//        List<Student> bachelorDegree = new ArrayList<>();
//        List<Student> masterDegree = new ArrayList<>();
//        Double mathScore1 = (double) 0;
//        Double mathScore2 = (double) 0;
//        Double mathScore3 = (double) 0;
//        Double mathScore4 = (double) 0;
//        Double mathScore5 = (double) 0;
//        Double mathScore6 = (double) 0;
//
//        for (Student e : list) {
//            if (Objects.equals(e.getLevel(), "high school")) {
//                highSchool.add(e);
//                mathScore1 += e.getMath();
//            }
//        }
//
//
//        for (Student e : list) {
//            if (Objects.equals(e.getLevel(), "some high school")) {
//                someHighSchool.add(e);
//                mathScore2 += e.getMath();
//            }
//        }
//        for (Student e : list) {
//            if (Objects.equals(e.getLevel(), "some college")) {
//                someCollege.add(e);
//                mathScore3 += e.getMath();
//            }
//        }
//        for (Student e : list) {
//            if (Objects.equals(e.getLevel(), "associate degree")) {
//                associateDegree.add(e);
//                mathScore4 += e.getMath();
//            }
//        }
//        for (Student e : list) {
//            if (Objects.equals(e.getLevel(), "bachelor degree")) {
//                bachelorDegree.add(e);
//                mathScore5 += e.getMath();
//            }
//        }
//        for (Student e : list) {
//            if (Objects.equals(e.getLevel(), "master degree")) {
//                masterDegree.add(e);
//                mathScore6 += e.getMath();
//            }
//        }
//        mathScore1 = mathScore1/ highSchool.size();
//        mathScore2 = mathScore2/ someHighSchool.size();
//        mathScore3 = mathScore3/ someCollege.size();
//        mathScore4 = mathScore4/ associateDegree.size();
//        mathScore5 = mathScore5/ bachelorDegree.size();
//        mathScore6 = mathScore6/ masterDegree.size();
//        Map<String, Double> map = new HashMap<String, Double>();
//        map.put("high school",mathScore1);
//        map.put("some high school",mathScore2);
//        map.put("some college",mathScore3);
//        map.put("associate degree",mathScore4);
//        map.put("bachelor degree",mathScore5);
//        map.put("master degree",mathScore6);

        Map<String, Double[]> map = new HashMap<>();
        for (Student entry : list) {
            String key = entry.getLevel();
            if (map.containsKey(key)) {
                map.get(key)[0] += entry.getMath();
                map.get(key)[1] ++;
            } else {
                map.put(key, new Double[]{(double) entry.getMath(), (double) 1});
            }
        }

        List<Entry<String, Double>> finalList = new ArrayList<>();
        for (Entry<String, Double[]> entry : map.entrySet()) {
            finalList.add(Map.entry(entry.getKey(), entry.getValue()[0]/entry.getValue()[1]));
        }
        finalList.sort(Entry.comparingByValue());


//        high school = 62.13775510204081
//        some high school = 63.497206703910614
//        some college = 67.1283185840708
//        associate degree = 67.88288288288288
//        bachelor degree = 69.38983050847457
//        master degree = 69.7457627118644
        return finalList;

    }
}

/**
 * This immutable class represent a student from the CSV data source. DO NOT
 * modify this class.
 */
class Student {


    public enum Gender {
        MALE, FEMALE
    }

    private final Gender gender;        // gender
    private final String group;         // group
    private final String level;         // parental level of education
    private final int math;             // math score
    private final int reading;          // reading score
    private final int writing;          // writing score

    public Student(Gender gender, String group, String level, int math, int reading, int writing) {
        this.gender = gender;
        this.group = group;
        this.level = level;
        this.math = math;
        this.reading = reading;
        this.writing = writing;
    }

    public Gender getGender() {
        return gender;
    }

    public String getGroup() {
        return group;
    }

    public String getLevel() {
        return level;
    }

    public int getMath() {
        return math;
    }

    public int getReading() {
        return reading;
    }

    public int getWriting() {
        return writing;
    }

    /**
     * Parse the CSV string below and create a list of Student objects.
     *
     * @return a list containing students created from the CSV string
     */
    public static List<Student> createList() {
        List<Student> studentArrayList = new ArrayList<>();
        Scanner scanner = new Scanner(csv);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] split = line.split(",");
            studentArrayList.add(new Student(Gender.valueOf(split[0].toUpperCase()), split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5])));
        }
        return studentArrayList;
    }
//        List<Student> people = new ArrayList<>();
//        StringTokenizer split = new StringTokenizer(csv, "\n");
//        while (split.hasMoreTokens()) {
//            String info = new String(split.nextToken() + ",");
//            StringTokenizer infoSplit = new StringTokenizer(info, ",");
//            String gender = infoSplit.nextToken();
//            String group = infoSplit.nextToken();
//            String level = infoSplit.nextToken();
//            int math = Integer.valueOf(infoSplit.nextToken());
//            int reading = Integer.valueOf(infoSplit.nextToken());
//            int writing = Integer.valueOf(infoSplit.nextToken());
//
//            if (gender == "male") {
//                people.add(new Student(Gender.FEMALE, group, level, math, reading, writing));
//            } else {
//                people.add(new Student(Gender.MALE, group, level, math, reading, writing));
//            }
//        }
//        return people;


    /*
    This CSV string has 1000 lines. Each line represents one student. The six 
    fields are listed in this order: gender, group, parental level of education,
    math score, reading score, writing score. 
     */
    public static final String csv = "female,group B,bachelor degree,72,72,74\n"
            + "female,group C,some college,69,90,88\n"
            + "female,group B,master degree,90,95,93\n"
            + "male,group A,associate degree,47,57,44\n"
            + "male,group C,some college,76,78,75\n"
            + "female,group B,associate degree,71,83,78\n"
            + "female,group B,some college,88,95,92\n"
            + "male,group B,some college,40,43,39\n"
            + "male,group D,high school,64,64,67\n"
            + "female,group B,high school,38,60,50\n"
            + "male,group C,associate degree,58,54,52\n"
            + "male,group D,associate degree,40,52,43\n"
            + "female,group B,high school,65,81,73\n"
            + "male,group A,some college,78,72,70\n"
            + "female,group A,master degree,50,53,58\n"
            + "female,group C,some high school,69,75,78\n"
            + "male,group C,high school,88,89,86\n"
            + "female,group B,some high school,18,32,28\n"
            + "male,group C,master degree,46,42,46\n"
            + "female,group C,associate degree,54,58,61\n"
            + "male,group D,high school,66,69,63\n"
            + "female,group B,some college,65,75,70\n"
            + "male,group D,some college,44,54,53\n"
            + "female,group C,some high school,69,73,73\n"
            + "male,group D,bachelor degree,74,71,80\n"
            + "male,group A,master degree,73,74,72\n"
            + "male,group B,some college,69,54,55\n"
            + "female,group C,bachelor degree,67,69,75\n"
            + "male,group C,high school,70,70,65\n"
            + "female,group D,master degree,62,70,75\n"
            + "female,group D,some college,69,74,74\n"
            + "female,group B,some college,63,65,61\n"
            + "female,group E,master degree,56,72,65\n"
            + "male,group D,some college,40,42,38\n"
            + "male,group E,some college,97,87,82\n"
            + "male,group E,associate degree,81,81,79\n"
            + "female,group D,associate degree,74,81,83\n"
            + "female,group D,some high school,50,64,59\n"
            + "female,group D,associate degree,75,90,88\n"
            + "male,group B,associate degree,57,56,57\n"
            + "male,group C,associate degree,55,61,54\n"
            + "female,group C,associate degree,58,73,68\n"
            + "female,group B,associate degree,53,58,65\n"
            + "male,group B,some college,59,65,66\n"
            + "female,group E,associate degree,50,56,54\n"
            + "male,group B,associate degree,65,54,57\n"
            + "female,group A,associate degree,55,65,62\n"
            + "female,group C,high school,66,71,76\n"
            + "female,group D,associate degree,57,74,76\n"
            + "male,group C,high school,82,84,82\n"
            + "male,group E,some college,53,55,48\n"
            + "male,group E,associate degree,77,69,68\n"
            + "male,group C,some college,53,44,42\n"
            + "male,group D,high school,88,78,75\n"
            + "female,group C,some high school,71,84,87\n"
            + "female,group C,high school,33,41,43\n"
            + "female,group E,associate degree,82,85,86\n"
            + "male,group D,associate degree,52,55,49\n"
            + "male,group D,some college,58,59,58\n"
            + "female,group C,some high school,0,17,10\n"
            + "male,group E,bachelor degree,79,74,72\n"
            + "male,group A,some high school,39,39,34\n"
            + "male,group A,associate degree,62,61,55\n"
            + "female,group C,associate degree,69,80,71\n"
            + "female,group D,some high school,59,58,59\n"
            + "male,group B,some high school,67,64,61\n"
            + "male,group D,some high school,45,37,37\n"
            + "female,group C,some college,60,72,74\n"
            + "male,group B,associate degree,61,58,56\n"
            + "female,group C,associate degree,39,64,57\n"
            + "female,group D,some college,58,63,73\n"
            + "male,group D,some college,63,55,63\n"
            + "female,group A,associate degree,41,51,48\n"
            + "male,group C,some high school,61,57,56\n"
            + "male,group C,some high school,49,49,41\n"
            + "male,group B,associate degree,44,41,38\n"
            + "male,group E,some high school,30,26,22\n"
            + "male,group A,bachelor degree,80,78,81\n"
            + "female,group D,some high school,61,74,72\n"
            + "female,group E,master degree,62,68,68\n"
            + "female,group B,associate degree,47,49,50\n"
            + "male,group B,high school,49,45,45\n"
            + "male,group A,some college,50,47,54\n"
            + "male,group E,associate degree,72,64,63\n"
            + "male,group D,high school,42,39,34\n"
            + "female,group C,some college,73,80,82\n"
            + "female,group C,some college,76,83,88\n"
            + "female,group D,associate degree,71,71,74\n"
            + "female,group A,some college,58,70,67\n"
            + "female,group D,some high school,73,86,82\n"
            + "female,group C,bachelor degree,65,72,74\n"
            + "male,group C,high school,27,34,36\n"
            + "male,group C,high school,71,79,71\n"
            + "male,group C,associate degree,43,45,50\n"
            + "female,group B,some college,79,86,92\n"
            + "male,group C,associate degree,78,81,82\n"
            + "male,group B,some high school,65,66,62\n"
            + "female,group E,some college,63,72,70\n"
            + "female,group D,some college,58,67,62\n"
            + "female,group D,bachelor degree,65,67,62\n"
            + "male,group B,some college,79,67,67\n"
            + "male,group D,bachelor degree,68,74,74\n"
            + "female,group D,associate degree,85,91,89\n"
            + "male,group B,high school,60,44,47\n"
            + "male,group C,some college,98,86,90\n"
            + "female,group C,some college,58,67,72\n"
            + "female,group D,master degree,87,100,100\n"
            + "male,group E,associate degree,66,63,64\n"
            + "female,group B,associate degree,52,76,70\n"
            + "female,group B,some high school,70,64,72\n"
            + "female,group D,associate degree,77,89,98\n"
            + "male,group C,high school,62,55,49\n"
            + "male,group A,associate degree,54,53,47\n"
            + "female,group D,some college,51,58,54\n"
            + "female,group E,bachelor degree,99,100,100\n"
            + "male,group C,high school,84,77,74\n"
            + "female,group B,bachelor degree,75,85,82\n"
            + "female,group D,bachelor degree,78,82,79\n"
            + "female,group D,some high school,51,63,61\n"
            + "female,group C,some college,55,69,65\n"
            + "female,group C,bachelor degree,79,92,89\n"
            + "male,group B,associate degree,91,89,92\n"
            + "female,group C,some college,88,93,93\n"
            + "male,group D,high school,63,57,56\n"
            + "male,group E,some college,83,80,73\n"
            + "female,group B,high school,87,95,86\n"
            + "male,group B,some high school,72,68,67\n"
            + "male,group D,some college,65,77,74\n"
            + "male,group D,master degree,82,82,74\n"
            + "female,group A,bachelor degree,51,49,51\n"
            + "male,group D,master degree,89,84,82\n"
            + "male,group C,some high school,53,37,40\n"
            + "male,group E,some college,87,74,70\n"
            + "female,group C,some college,75,81,84\n"
            + "male,group D,bachelor degree,74,79,75\n"
            + "male,group C,bachelor degree,58,55,48\n"
            + "male,group B,some high school,51,54,41\n"
            + "male,group E,high school,70,55,56\n"
            + "female,group C,associate degree,59,66,67\n"
            + "male,group D,some college,71,61,69\n"
            + "female,group D,some high school,76,72,71\n"
            + "female,group C,some college,59,62,64\n"
            + "female,group E,some college,42,55,54\n"
            + "male,group A,high school,57,43,47\n"
            + "male,group D,some college,88,73,78\n"
            + "female,group C,some college,22,39,33\n"
            + "male,group B,some high school,88,84,75\n"
            + "male,group C,associate degree,73,68,66\n"
            + "female,group D,bachelor degree,68,75,81\n"
            + "male,group E,associate degree,100,100,93\n"
            + "male,group A,some high school,62,67,69\n"
            + "male,group A,bachelor degree,77,67,68\n"
            + "female,group B,associate degree,59,70,66\n"
            + "male,group D,bachelor degree,54,49,47\n"
            + "male,group D,some high school,62,67,61\n"
            + "female,group C,some college,70,89,88\n"
            + "female,group E,high school,66,74,78\n"
            + "male,group B,some college,60,60,60\n"
            + "female,group B,associate degree,61,86,87\n"
            + "male,group D,associate degree,66,62,64\n"
            + "male,group B,associate degree,82,78,74\n"
            + "female,group E,some college,75,88,85\n"
            + "male,group B,master degree,49,53,52\n"
            + "male,group C,high school,52,53,49\n"
            + "female,group E,master degree,81,92,91\n"
            + "female,group C,bachelor degree,96,100,100\n"
            + "male,group C,high school,53,51,51\n"
            + "female,group B,master degree,58,76,78\n"
            + "female,group B,high school,68,83,78\n"
            + "female,group C,some college,67,75,70\n"
            + "male,group A,high school,72,73,74\n"
            + "male,group E,some high school,94,88,78\n"
            + "female,group D,some college,79,86,81\n"
            + "female,group C,associate degree,63,67,70\n"
            + "female,group C,bachelor degree,43,51,54\n"
            + "female,group C,master degree,81,91,87\n"
            + "female,group B,high school,46,54,58\n"
            + "female,group C,associate degree,71,77,77\n"
            + "female,group B,master degree,52,70,62\n"
            + "female,group D,some high school,97,100,100\n"
            + "male,group C,master degree,62,68,75\n"
            + "female,group C,some college,46,64,66\n"
            + "female,group E,high school,50,50,47\n"
            + "female,group D,associate degree,65,69,70\n"
            + "male,group C,some high school,45,52,49\n"
            + "male,group C,associate degree,65,67,65\n"
            + "male,group E,high school,80,76,65\n"
            + "male,group D,some high school,62,66,68\n"
            + "male,group B,some high school,48,52,45\n"
            + "female,group C,bachelor degree,77,88,87\n"
            + "female,group E,associate degree,66,65,69\n"
            + "male,group D,some college,76,83,79\n"
            + "female,group B,some high school,62,64,66\n"
            + "male,group D,some college,77,62,62\n"
            + "female,group C,master degree,69,84,85\n"
            + "male,group D,associate degree,61,55,52\n"
            + "male,group C,some high school,59,69,65\n"
            + "male,group E,high school,55,56,51\n"
            + "female,group B,some college,45,53,55\n"
            + "female,group B,bachelor degree,78,79,76\n"
            + "female,group C,associate degree,67,84,86\n"
            + "female,group D,some college,65,81,77\n"
            + "male,group C,associate degree,69,77,69\n"
            + "female,group B,associate degree,57,69,68\n"
            + "male,group C,some college,59,41,42\n"
            + "male,group D,some high school,74,71,78\n"
            + "male,group E,bachelor degree,82,62,62\n"
            + "male,group E,high school,81,80,76\n"
            + "female,group B,some college,74,81,76\n"
            + "female,group B,some college,58,61,66\n"
            + "male,group D,some high school,80,79,79\n"
            + "male,group C,some college,35,28,27\n"
            + "female,group C,high school,42,62,60\n"
            + "male,group C,associate degree,60,51,56\n"
            + "male,group E,high school,87,91,81\n"
            + "male,group B,some high school,84,83,75\n"
            + "female,group E,associate degree,83,86,88\n"
            + "female,group C,high school,34,42,39\n"
            + "male,group B,high school,66,77,70\n"
            + "male,group B,some high school,61,56,56\n"
            + "female,group D,high school,56,68,74\n"
            + "male,group B,associate degree,87,85,73\n"
            + "female,group C,some high school,55,65,62\n"
            + "male,group D,some high school,86,80,75\n"
            + "female,group B,associate degree,52,66,73\n"
            + "female,group E,master degree,45,56,54\n"
            + "female,group C,some college,72,72,71\n"
            + "male,group D,high school,57,50,54\n"
            + "male,group A,some high school,68,72,64\n"
            + "female,group C,some college,88,95,94\n"
            + "male,group D,some college,76,64,66\n"
            + "male,group C,associate degree,46,43,42\n"
            + "female,group B,bachelor degree,67,86,83\n"
            + "male,group E,some high school,92,87,78\n"
            + "male,group C,bachelor degree,83,82,84\n"
            + "male,group D,associate degree,80,75,77\n"
            + "male,group D,bachelor degree,63,66,67\n"
            + "female,group D,some high school,64,60,74\n"
            + "male,group B,some college,54,52,51\n"
            + "male,group C,associate degree,84,80,80\n"
            + "male,group D,high school,73,68,66\n"
            + "female,group E,bachelor degree,80,83,83\n"
            + "female,group D,high school,56,52,55\n"
            + "male,group E,some college,59,51,43\n"
            + "male,group D,some high school,75,74,69\n"
            + "male,group C,associate degree,85,76,71\n"
            + "male,group E,associate degree,89,76,74\n"
            + "female,group B,high school,58,70,68\n"
            + "female,group B,high school,65,64,62\n"
            + "male,group C,high school,68,60,53\n"
            + "male,group A,some high school,47,49,49\n"
            + "female,group D,some college,71,83,83\n"
            + "female,group B,some high school,60,70,70\n"
            + "male,group D,master degree,80,80,72\n"
            + "male,group D,high school,54,52,52\n"
            + "female,group E,some college,62,73,70\n"
            + "female,group C,associate degree,64,73,68\n"
            + "male,group C,associate degree,78,77,77\n"
            + "female,group B,some college,70,75,78\n"
            + "female,group C,master degree,65,81,81\n"
            + "female,group C,some high school,64,79,77\n"
            + "male,group C,some college,79,79,78\n"
            + "female,group C,some high school,44,50,51\n"
            + "female,group E,high school,99,93,90\n"
            + "male,group D,high school,76,73,68\n"
            + "male,group D,some high school,59,42,41\n"
            + "female,group C,bachelor degree,63,75,81\n"
            + "female,group D,high school,69,72,77\n"
            + "female,group D,associate degree,88,92,95\n"
            + "female,group E,some college,71,76,70\n"
            + "male,group C,bachelor degree,69,63,61\n"
            + "male,group C,some college,58,49,42\n"
            + "female,group D,associate degree,47,53,58\n"
            + "female,group D,some college,65,70,71\n"
            + "male,group B,some college,88,85,76\n"
            + "male,group C,bachelor degree,83,78,73\n"
            + "female,group C,some high school,85,92,93\n"
            + "female,group E,high school,59,63,75\n"
            + "female,group C,some high school,65,86,80\n"
            + "male,group B,bachelor degree,73,56,57\n"
            + "male,group D,high school,53,52,42\n"
            + "male,group D,high school,45,48,46\n"
            + "female,group D,bachelor degree,73,79,84\n"
            + "female,group D,some college,70,78,78\n"
            + "female,group B,some high school,37,46,46\n"
            + "male,group B,associate degree,81,82,82\n"
            + "male,group E,associate degree,97,82,88\n"
            + "female,group B,some high school,67,89,82\n"
            + "male,group B,bachelor degree,88,75,76\n"
            + "male,group E,some high school,77,76,77\n"
            + "male,group C,associate degree,76,70,68\n"
            + "male,group D,some high school,86,73,70\n"
            + "male,group C,some high school,63,60,57\n"
            + "female,group E,bachelor degree,65,73,75\n"
            + "male,group D,high school,78,77,80\n"
            + "male,group B,associate degree,67,62,60\n"
            + "male,group A,some high school,46,41,43\n"
            + "male,group E,associate degree,71,74,68\n"
            + "male,group C,high school,40,46,50\n"
            + "male,group D,associate degree,90,87,75\n"
            + "male,group A,some college,81,78,81\n"
            + "male,group D,some high school,56,54,52\n"
            + "female,group C,associate degree,67,84,81\n"
            + "male,group B,associate degree,80,76,64\n"
            + "female,group C,associate degree,74,75,83\n"
            + "male,group A,some college,69,67,69\n"
            + "male,group E,some college,99,87,81\n"
            + "male,group C,some high school,51,52,44\n"
            + "female,group B,associate degree,53,71,67\n"
            + "female,group D,high school,49,57,52\n"
            + "female,group B,associate degree,73,76,80\n"
            + "male,group B,bachelor degree,66,60,57\n"
            + "male,group D,bachelor degree,67,61,68\n"
            + "female,group C,associate degree,68,67,69\n"
            + "female,group C,bachelor degree,59,64,75\n"
            + "male,group C,high school,71,66,65\n"
            + "female,group D,master degree,77,82,91\n"
            + "male,group C,associate degree,83,72,78\n"
            + "male,group B,bachelor degree,63,71,69\n"
            + "female,group D,associate degree,56,65,63\n"
            + "female,group C,high school,67,79,84\n"
            + "female,group E,high school,75,86,79\n"
            + "female,group C,some college,71,81,80\n"
            + "female,group C,some high school,43,53,53\n"
            + "female,group C,high school,41,46,43\n"
            + "female,group C,some college,82,90,94\n"
            + "male,group C,some college,61,61,62\n"
            + "male,group A,some college,28,23,19\n"
            + "male,group C,associate degree,82,75,77\n"
            + "female,group B,some high school,41,55,51\n"
            + "male,group C,high school,71,60,61\n"
            + "male,group C,associate degree,47,37,35\n"
            + "male,group E,associate degree,62,56,53\n"
            + "male,group B,associate degree,90,78,81\n"
            + "female,group C,bachelor degree,83,93,95\n"
            + "female,group B,some college,61,68,66\n"
            + "male,group D,some high school,76,70,69\n"
            + "male,group C,associate degree,49,51,43\n"
            + "female,group B,some high school,24,38,27\n"
            + "female,group D,some high school,35,55,60\n"
            + "male,group C,high school,58,61,52\n"
            + "female,group C,high school,61,73,63\n"
            + "female,group B,high school,69,76,74\n"
            + "male,group D,associate degree,67,72,67\n"
            + "male,group D,some college,79,73,67\n"
            + "female,group C,high school,72,80,75\n"
            + "male,group B,some college,62,61,57\n"
            + "female,group C,bachelor degree,77,94,95\n"
            + "male,group D,high school,75,74,66\n"
            + "male,group E,associate degree,87,74,76\n"
            + "female,group B,bachelor degree,52,65,69\n"
            + "male,group E,some college,66,57,52\n"
            + "female,group C,some college,63,78,80\n"
            + "female,group C,associate degree,46,58,57\n"
            + "female,group C,some college,59,71,70\n"
            + "female,group B,bachelor degree,61,72,70\n"
            + "male,group A,associate degree,63,61,61\n"
            + "female,group C,some college,42,66,69\n"
            + "male,group D,some college,59,62,61\n"
            + "female,group D,some college,80,90,89\n"
            + "female,group B,high school,58,62,59\n"
            + "male,group B,some high school,85,84,78\n"
            + "female,group C,some college,52,58,58\n"
            + "female,group D,some high school,27,34,32\n"
            + "male,group C,some college,59,60,58\n"
            + "male,group A,bachelor degree,49,58,60\n"
            + "male,group C,high school,69,58,53\n"
            + "male,group C,bachelor degree,61,66,61\n"
            + "female,group A,some high school,44,64,58\n"
            + "female,group D,some high school,73,84,85\n"
            + "male,group E,some college,84,77,71\n"
            + "female,group C,some college,45,73,70\n"
            + "male,group D,some high school,74,74,72\n"
            + "female,group D,some college,82,97,96\n"
            + "female,group D,bachelor degree,59,70,73\n"
            + "male,group E,associate degree,46,43,41\n"
            + "female,group D,some high school,80,90,82\n"
            + "female,group D,master degree,85,95,100\n"
            + "female,group A,some high school,71,83,77\n"
            + "male,group A,bachelor degree,66,64,62\n"
            + "female,group B,associate degree,80,86,83\n"
            + "male,group C,associate degree,87,100,95\n"
            + "male,group C,master degree,79,81,71\n"
            + "female,group E,some high school,38,49,45\n"
            + "female,group A,some high school,38,43,43\n"
            + "female,group E,some college,67,76,75\n"
            + "female,group E,bachelor degree,64,73,70\n"
            + "female,group C,associate degree,57,78,67\n"
            + "female,group D,high school,62,64,64\n"
            + "male,group D,master degree,73,70,75\n"
            + "male,group E,some high school,73,67,59\n"
            + "female,group D,some college,77,68,77\n"
            + "male,group E,some college,76,67,67\n"
            + "male,group C,associate degree,57,54,56\n"
            + "female,group C,some high school,65,74,77\n"
            + "male,group A,high school,48,45,41\n"
            + "female,group B,high school,50,67,63\n"
            + "female,group C,associate degree,85,89,95\n"
            + "male,group B,some high school,74,63,57\n"
            + "male,group D,some high school,60,59,54\n"
            + "female,group C,some high school,59,54,67\n"
            + "male,group A,some college,53,43,43\n"
            + "female,group A,some college,49,65,55\n"
            + "female,group D,high school,88,99,100\n"
            + "female,group C,high school,54,59,62\n"
            + "female,group C,some high school,63,73,68\n"
            + "male,group B,associate degree,65,65,63\n"
            + "female,group B,associate degree,82,80,77\n"
            + "female,group D,high school,52,57,56\n"
            + "male,group D,associate degree,87,84,85\n"
            + "female,group D,master degree,70,71,74\n"
            + "male,group E,some college,84,83,78\n"
            + "male,group D,associate degree,71,66,60\n"
            + "male,group B,some high school,63,67,67\n"
            + "female,group C,bachelor degree,51,72,79\n"
            + "male,group E,high school,84,73,69\n"
            + "male,group C,bachelor degree,71,74,68\n"
            + "male,group C,associate degree,74,73,67\n"
            + "male,group D,some college,68,59,62\n"
            + "male,group E,high school,57,56,54\n"
            + "female,group C,associate degree,82,93,93\n"
            + "female,group D,high school,57,58,64\n"
            + "female,group D,master degree,47,58,67\n"
            + "female,group A,some high school,59,85,80\n"
            + "male,group B,some college,41,39,34\n"
            + "female,group C,some college,62,67,62\n"
            + "male,group C,bachelor degree,86,83,86\n"
            + "male,group C,some high school,69,71,65\n"
            + "male,group A,some high school,65,59,53\n"
            + "male,group C,some high school,68,63,54\n"
            + "male,group C,associate degree,64,66,59\n"
            + "female,group C,high school,61,72,70\n"
            + "male,group C,high school,61,56,55\n"
            + "female,group A,some high school,47,59,50\n"
            + "male,group C,some high school,73,66,66\n"
            + "male,group C,some college,50,48,53\n"
            + "male,group D,associate degree,75,68,64\n"
            + "male,group D,associate degree,75,66,73\n"
            + "male,group C,high school,70,56,51\n"
            + "male,group D,some high school,89,88,82\n"
            + "female,group C,some college,67,81,79\n"
            + "female,group D,high school,78,81,80\n"
            + "female,group A,some high school,59,73,69\n"
            + "female,group B,associate degree,73,83,76\n"
            + "male,group A,some high school,79,82,73\n"
            + "female,group C,some high school,67,74,77\n"
            + "male,group D,some college,69,66,60\n"
            + "male,group C,high school,86,81,80\n"
            + "male,group B,high school,47,46,42\n"
            + "male,group B,associate degree,81,73,72\n"
            + "female,group C,some college,64,85,85\n"
            + "female,group E,some college,100,92,97\n"
            + "female,group C,associate degree,65,77,74\n"
            + "male,group C,some college,65,58,49\n"
            + "female,group C,associate degree,53,61,62\n"
            + "male,group C,bachelor degree,37,56,47\n"
            + "female,group D,bachelor degree,79,89,89\n"
            + "male,group D,associate degree,53,54,48\n"
            + "female,group E,bachelor degree,100,100,100\n"
            + "male,group B,high school,72,65,68\n"
            + "male,group C,bachelor degree,53,58,55\n"
            + "male,group B,some college,54,54,45\n"
            + "female,group E,some college,71,70,76\n"
            + "female,group C,some college,77,90,91\n"
            + "male,group A,bachelor degree,75,58,62\n"
            + "female,group C,some college,84,87,91\n"
            + "female,group D,associate degree,26,31,38\n"
            + "male,group A,high school,72,67,65\n"
            + "female,group A,high school,77,88,85\n"
            + "male,group C,some college,91,74,76\n"
            + "female,group C,associate degree,83,85,90\n"
            + "female,group C,high school,63,69,74\n"
            + "female,group C,associate degree,68,86,84\n"
            + "female,group D,some high school,59,67,61\n"
            + "female,group B,associate degree,90,90,91\n"
            + "female,group D,bachelor degree,71,76,83\n"
            + "male,group E,bachelor degree,76,62,66\n"
            + "male,group D,associate degree,80,68,72\n"
            + "female,group D,master degree,55,64,70\n"
            + "male,group E,associate degree,76,71,67\n"
            + "male,group B,high school,73,71,68\n"
            + "female,group D,associate degree,52,59,56\n"
            + "male,group C,some college,68,68,61\n"
            + "male,group A,high school,59,52,46\n"
            + "female,group B,associate degree,49,52,54\n"
            + "male,group C,high school,70,74,71\n"
            + "male,group D,some college,61,47,56\n"
            + "female,group C,associate degree,60,75,74\n"
            + "male,group B,some high school,64,53,57\n"
            + "male,group A,associate degree,79,82,82\n"
            + "female,group A,associate degree,65,85,76\n"
            + "female,group C,associate degree,64,64,70\n"
            + "female,group C,some college,83,83,90\n"
            + "female,group C,bachelor degree,81,88,90\n"
            + "female,group B,high school,54,64,68\n"
            + "male,group D,high school,68,64,66\n"
            + "female,group C,some college,54,48,52\n"
            + "female,group D,some college,59,78,76\n"
            + "female,group B,some high school,66,69,68\n"
            + "male,group E,some college,76,71,72\n"
            + "female,group D,master degree,74,79,82\n"
            + "female,group B,associate degree,94,87,92\n"
            + "male,group C,some college,63,61,54\n"
            + "female,group E,associate degree,95,89,92\n"
            + "female,group D,master degree,40,59,54\n"
            + "female,group B,some high school,82,82,80\n"
            + "male,group A,high school,68,70,66\n"
            + "male,group B,bachelor degree,55,59,54\n"
            + "male,group C,master degree,79,78,77\n"
            + "female,group C,bachelor degree,86,92,87\n"
            + "male,group D,some college,76,71,73\n"
            + "male,group A,some high school,64,50,43\n"
            + "male,group D,some high school,62,49,52\n"
            + "female,group B,some high school,54,61,62\n"
            + "female,group B,master degree,77,97,94\n"
            + "female,group C,some high school,76,87,85\n"
            + "female,group D,some college,74,89,84\n"
            + "female,group E,some college,66,74,73\n"
            + "female,group D,some high school,66,78,78\n"
            + "female,group B,high school,67,78,79\n"
            + "male,group D,some college,71,49,52\n"
            + "female,group C,associate degree,91,86,84\n"
            + "male,group D,bachelor degree,69,58,57\n"
            + "male,group C,master degree,54,59,50\n"
            + "male,group C,high school,53,52,49\n"
            + "male,group E,some college,68,60,59\n"
            + "male,group C,some high school,56,61,60\n"
            + "female,group C,high school,36,53,43\n"
            + "female,group D,bachelor degree,29,41,47\n"
            + "female,group C,associate degree,62,74,70\n"
            + "female,group C,associate degree,68,67,73\n"
            + "female,group C,some high school,47,54,53\n"
            + "male,group E,associate degree,62,61,58\n"
            + "female,group E,associate degree,79,88,94\n"
            + "male,group B,high school,73,69,68\n"
            + "female,group C,bachelor degree,66,83,83\n"
            + "male,group C,associate degree,51,60,58\n"
            + "female,group D,high school,51,66,62\n"
            + "male,group E,bachelor degree,85,66,71\n"
            + "male,group A,associate degree,97,92,86\n"
            + "male,group C,high school,75,69,68\n"
            + "male,group D,associate degree,79,82,80\n"
            + "female,group C,associate degree,81,77,79\n"
            + "female,group D,associate degree,82,95,89\n"
            + "female,group D,master degree,64,63,66\n"
            + "male,group E,some high school,78,83,80\n"
            + "female,group A,some high school,92,100,97\n"
            + "male,group C,high school,72,67,64\n"
            + "female,group C,high school,62,67,64\n"
            + "male,group C,master degree,79,72,69\n"
            + "male,group C,some high school,79,76,65\n"
            + "male,group B,bachelor degree,87,90,88\n"
            + "female,group B,associate degree,40,48,50\n"
            + "male,group D,some college,77,62,64\n"
            + "male,group E,associate degree,53,45,40\n"
            + "female,group C,some college,32,39,33\n"
            + "female,group C,associate degree,55,72,79\n"
            + "male,group C,master degree,61,67,66\n"
            + "female,group B,associate degree,53,70,70\n"
            + "male,group D,some high school,73,66,62\n"
            + "female,group D,some college,74,75,79\n"
            + "female,group C,some college,63,74,74\n"
            + "male,group C,bachelor degree,96,90,92\n"
            + "female,group D,some college,63,80,80\n"
            + "male,group B,bachelor degree,48,51,46\n"
            + "male,group B,associate degree,48,43,45\n"
            + "female,group E,bachelor degree,92,100,100\n"
            + "female,group D,master degree,61,71,78\n"
            + "male,group B,high school,63,48,47\n"
            + "male,group D,bachelor degree,68,68,67\n"
            + "male,group B,some college,71,75,70\n"
            + "male,group A,bachelor degree,91,96,92\n"
            + "female,group C,some college,53,62,56\n"
            + "female,group C,high school,50,66,64\n"
            + "female,group E,high school,74,81,71\n"
            + "male,group A,associate degree,40,55,53\n"
            + "male,group A,some college,61,51,52\n"
            + "female,group B,high school,81,91,89\n"
            + "female,group B,some college,48,56,58\n"
            + "female,group D,master degree,53,61,68\n"
            + "female,group D,some high school,81,97,96\n"
            + "female,group E,some high school,77,79,80\n"
            + "female,group D,bachelor degree,63,73,78\n"
            + "female,group D,associate degree,73,75,80\n"
            + "female,group D,some college,69,77,77\n"
            + "female,group C,associate degree,65,76,76\n"
            + "female,group A,high school,55,73,73\n"
            + "female,group C,bachelor degree,44,63,62\n"
            + "female,group C,some college,54,64,65\n"
            + "female,group A,some high school,48,66,65\n"
            + "male,group C,some college,58,57,54\n"
            + "male,group A,some high school,71,62,50\n"
            + "male,group E,bachelor degree,68,68,64\n"
            + "female,group E,high school,74,76,73\n"
            + "female,group C,bachelor degree,92,100,99\n"
            + "female,group C,bachelor degree,56,79,72\n"
            + "male,group B,high school,30,24,15\n"
            + "male,group A,some high school,53,54,48\n"
            + "female,group D,high school,69,77,73\n"
            + "female,group D,some high school,65,82,81\n"
            + "female,group D,master degree,54,60,63\n"
            + "female,group C,high school,29,29,30\n"
            + "female,group E,some college,76,78,80\n"
            + "male,group D,high school,60,57,51\n"
            + "male,group D,master degree,84,89,90\n"
            + "male,group C,some high school,75,72,62\n"
            + "female,group C,associate degree,85,84,82\n"
            + "female,group C,master degree,40,58,54\n"
            + "female,group E,some college,61,64,62\n"
            + "female,group B,associate degree,58,63,65\n"
            + "male,group D,some college,69,60,63\n"
            + "female,group C,some college,58,59,66\n"
            + "male,group C,bachelor degree,94,90,91\n"
            + "female,group C,associate degree,65,77,74\n"
            + "female,group A,associate degree,82,93,93\n"
            + "female,group C,high school,60,68,72\n"
            + "female,group E,bachelor degree,37,45,38\n"
            + "male,group D,bachelor degree,88,78,83\n"
            + "male,group D,master degree,95,81,84\n"
            + "male,group C,associate degree,65,73,68\n"
            + "female,group C,high school,35,61,54\n"
            + "male,group B,bachelor degree,62,63,56\n"
            + "male,group C,high school,58,51,52\n"
            + "male,group A,some college,100,96,86\n"
            + "female,group E,bachelor degree,61,58,62\n"
            + "male,group D,some college,100,97,99\n"
            + "male,group B,associate degree,69,70,63\n"
            + "male,group D,associate degree,61,48,46\n"
            + "male,group D,some college,49,57,46\n"
            + "female,group C,some high school,44,51,55\n"
            + "male,group D,some college,67,64,70\n"
            + "male,group B,high school,79,60,65\n"
            + "female,group B,bachelor degree,66,74,81\n"
            + "female,group C,high school,75,88,85\n"
            + "male,group D,some high school,84,84,80\n"
            + "male,group A,high school,71,74,64\n"
            + "female,group B,high school,67,80,81\n"
            + "female,group D,some high school,80,92,88\n"
            + "male,group E,some college,86,76,74\n"
            + "female,group D,associate degree,76,74,73\n"
            + "male,group D,high school,41,52,51\n"
            + "female,group D,associate degree,74,88,90\n"
            + "female,group B,some high school,72,81,79\n"
            + "female,group E,high school,74,79,80\n"
            + "male,group B,high school,70,65,60\n"
            + "female,group B,bachelor degree,65,81,81\n"
            + "female,group D,associate degree,59,70,65\n"
            + "female,group E,high school,64,62,68\n"
            + "female,group B,high school,50,53,55\n"
            + "female,group D,some college,69,79,81\n"
            + "male,group C,some high school,51,56,53\n"
            + "female,group A,high school,68,80,76\n"
            + "female,group D,some college,85,86,98\n"
            + "female,group A,associate degree,65,70,74\n"
            + "female,group B,some high school,73,79,79\n"
            + "female,group B,some college,62,67,67\n"
            + "male,group C,associate degree,77,67,64\n"
            + "male,group D,some high school,69,66,61\n"
            + "female,group D,associate degree,43,60,58\n"
            + "male,group D,associate degree,90,87,85\n"
            + "male,group C,some college,74,77,73\n"
            + "male,group C,some high school,73,66,63\n"
            + "female,group D,some college,55,71,69\n"
            + "female,group C,high school,65,69,67\n"
            + "male,group D,associate degree,80,63,63\n"
            + "female,group C,some high school,50,60,60\n"
            + "female,group C,some college,63,73,71\n"
            + "female,group B,bachelor degree,77,85,87\n"
            + "male,group C,some college,73,74,61\n"
            + "male,group D,associate degree,81,72,77\n"
            + "female,group C,high school,66,76,68\n"
            + "male,group D,associate degree,52,57,50\n"
            + "female,group C,some college,69,78,76\n"
            + "female,group C,associate degree,65,84,84\n"
            + "female,group D,high school,69,77,78\n"
            + "female,group B,some college,50,64,66\n"
            + "female,group E,some college,73,78,76\n"
            + "female,group C,some high school,70,82,76\n"
            + "male,group D,associate degree,81,75,78\n"
            + "male,group D,some college,63,61,60\n"
            + "female,group D,high school,67,72,74\n"
            + "male,group B,high school,60,68,60\n"
            + "male,group B,high school,62,55,54\n"
            + "female,group C,some high school,29,40,44\n"
            + "male,group B,some college,62,66,68\n"
            + "female,group E,master degree,94,99,100\n"
            + "male,group E,some college,85,75,68\n"
            + "male,group D,associate degree,77,78,73\n"
            + "male,group A,high school,53,58,44\n"
            + "male,group E,some college,93,90,83\n"
            + "female,group C,associate degree,49,53,53\n"
            + "female,group E,associate degree,73,76,78\n"
            + "female,group C,bachelor degree,66,74,81\n"
            + "female,group D,associate degree,77,77,73\n"
            + "female,group C,some high school,49,63,56\n"
            + "female,group D,some college,79,89,86\n"
            + "female,group C,associate degree,75,82,90\n"
            + "female,group A,bachelor degree,59,72,70\n"
            + "female,group D,associate degree,57,78,79\n"
            + "male,group C,high school,66,66,59\n"
            + "female,group E,bachelor degree,79,81,82\n"
            + "female,group B,some high school,57,67,72\n"
            + "male,group A,bachelor degree,87,84,87\n"
            + "female,group D,some college,63,64,67\n"
            + "female,group B,some high school,59,63,64\n"
            + "male,group A,bachelor degree,62,72,65\n"
            + "male,group D,high school,46,34,36\n"
            + "male,group C,some college,66,59,52\n"
            + "male,group D,high school,89,87,79\n"
            + "female,group D,associate degree,42,61,58\n"
            + "male,group C,some college,93,84,90\n"
            + "female,group E,some high school,80,85,85\n"
            + "female,group D,some college,98,100,99\n"
            + "male,group D,master degree,81,81,84\n"
            + "female,group B,some high school,60,70,74\n"
            + "female,group B,associate degree,76,94,87\n"
            + "male,group C,associate degree,73,78,72\n"
            + "female,group C,associate degree,96,96,99\n"
            + "female,group C,high school,76,76,74\n"
            + "male,group E,associate degree,91,73,80\n"
            + "female,group C,some college,62,72,70\n"
            + "male,group D,some high school,55,59,59\n"
            + "female,group B,some high school,74,90,88\n"
            + "male,group C,high school,50,48,42\n"
            + "male,group B,some college,47,43,41\n"
            + "male,group E,some college,81,74,71\n"
            + "female,group E,associate degree,65,75,77\n"
            + "male,group E,some high school,68,51,57\n"
            + "female,group D,high school,73,92,84\n"
            + "male,group C,some college,53,39,37\n"
            + "female,group B,associate degree,68,77,80\n"
            + "male,group A,some high school,55,46,43\n"
            + "female,group C,some college,87,89,94\n"
            + "male,group D,some high school,55,47,44\n"
            + "female,group E,some college,53,58,57\n"
            + "male,group C,master degree,67,57,59\n"
            + "male,group C,associate degree,92,79,84\n"
            + "female,group B,some college,53,66,73\n"
            + "male,group D,associate degree,81,71,73\n"
            + "male,group C,high school,61,60,55\n"
            + "male,group D,bachelor degree,80,73,72\n"
            + "female,group A,associate degree,37,57,56\n"
            + "female,group C,high school,81,84,82\n"
            + "female,group C,associate degree,59,73,72\n"
            + "male,group B,some college,55,55,47\n"
            + "male,group D,associate degree,72,79,74\n"
            + "male,group D,high school,69,75,71\n"
            + "male,group C,some college,69,64,68\n"
            + "female,group C,bachelor degree,50,60,59\n"
            + "male,group B,some college,87,84,86\n"
            + "male,group D,some high school,71,69,68\n"
            + "male,group E,some college,68,72,65\n"
            + "male,group C,master degree,79,77,75\n"
            + "female,group C,some high school,77,90,85\n"
            + "male,group C,associate degree,58,55,53\n"
            + "female,group E,associate degree,84,95,92\n"
            + "male,group D,some college,55,58,52\n"
            + "male,group E,bachelor degree,70,68,72\n"
            + "female,group D,some college,52,59,65\n"
            + "male,group B,some college,69,77,77\n"
            + "female,group C,high school,53,72,64\n"
            + "female,group D,some high school,48,58,54\n"
            + "male,group D,some high school,78,81,86\n"
            + "female,group B,high school,62,62,63\n"
            + "male,group D,some college,60,63,59\n"
            + "female,group B,high school,74,72,72\n"
            + "female,group C,high school,58,75,77\n"
            + "male,group B,high school,76,62,60\n"
            + "female,group D,some high school,68,71,75\n"
            + "male,group A,some college,58,60,57\n"
            + "male,group B,high school,52,48,49\n"
            + "male,group D,bachelor degree,75,73,74\n"
            + "female,group B,some high school,52,67,72\n"
            + "female,group C,bachelor degree,62,78,79\n"
            + "male,group B,some college,66,65,60\n"
            + "female,group B,some high school,49,58,55\n"
            + "female,group B,high school,66,72,70\n"
            + "female,group C,some college,35,44,43\n"
            + "female,group A,some college,72,79,82\n"
            + "male,group E,associate degree,94,85,82\n"
            + "female,group D,associate degree,46,56,57\n"
            + "female,group B,master degree,77,90,84\n"
            + "female,group B,high school,76,85,82\n"
            + "female,group C,associate degree,52,59,62\n"
            + "male,group C,bachelor degree,91,81,79\n"
            + "female,group B,some high school,32,51,44\n"
            + "female,group E,some high school,72,79,77\n"
            + "female,group B,some college,19,38,32\n"
            + "male,group C,associate degree,68,65,61\n"
            + "female,group C,master degree,52,65,61\n"
            + "female,group B,high school,48,62,60\n"
            + "female,group D,some college,60,66,70\n"
            + "male,group D,high school,66,74,69\n"
            + "male,group E,some high school,89,84,77\n"
            + "female,group B,high school,42,52,51\n"
            + "female,group E,associate degree,57,68,73\n"
            + "male,group D,high school,70,70,70\n"
            + "female,group E,associate degree,70,84,81\n"
            + "male,group E,some college,69,60,54\n"
            + "female,group C,associate degree,52,55,57\n"
            + "male,group C,some high school,67,73,68\n"
            + "male,group C,some high school,76,80,73\n"
            + "female,group E,associate degree,87,94,95\n"
            + "female,group B,some college,82,85,87\n"
            + "female,group C,some college,73,76,78\n"
            + "male,group A,some college,75,81,74\n"
            + "female,group D,some college,64,74,75\n"
            + "female,group E,high school,41,45,40\n"
            + "male,group C,high school,90,75,69\n"
            + "male,group B,bachelor degree,59,54,51\n"
            + "male,group A,some high school,51,31,36\n"
            + "male,group A,high school,45,47,49\n"
            + "female,group C,master degree,54,64,67\n"
            + "male,group E,some high school,87,84,76\n"
            + "female,group C,high school,72,80,83\n"
            + "male,group B,some high school,94,86,87\n"
            + "female,group A,bachelor degree,45,59,64\n"
            + "male,group D,bachelor degree,61,70,76\n"
            + "female,group B,high school,60,72,68\n"
            + "female,group C,some high school,77,91,88\n"
            + "female,group A,some high school,85,90,92\n"
            + "female,group D,bachelor degree,78,90,93\n"
            + "male,group E,some college,49,52,51\n"
            + "female,group B,high school,71,87,82\n"
            + "female,group C,some high school,48,58,52\n"
            + "male,group C,high school,62,67,58\n"
            + "female,group C,associate degree,56,68,70\n"
            + "female,group C,some high school,65,69,76\n"
            + "female,group D,some high school,69,86,81\n"
            + "male,group B,some high school,68,54,53\n"
            + "female,group A,some college,61,60,57\n"
            + "female,group C,bachelor degree,74,86,89\n"
            + "male,group A,bachelor degree,64,60,58\n"
            + "female,group B,high school,77,82,89\n"
            + "male,group B,some college,58,50,45\n"
            + "female,group C,high school,60,64,74\n"
            + "male,group E,high school,73,64,57\n"
            + "female,group A,high school,75,82,79\n"
            + "male,group B,associate degree,58,57,53\n"
            + "female,group C,associate degree,66,77,73\n"
            + "female,group D,high school,39,52,46\n"
            + "male,group C,some high school,64,58,51\n"
            + "female,group B,high school,23,44,36\n"
            + "male,group B,some college,74,77,76\n"
            + "female,group D,some high school,40,65,64\n"
            + "male,group E,master degree,90,85,84\n"
            + "male,group C,master degree,91,85,85\n"
            + "male,group D,high school,64,54,50\n"
            + "female,group C,high school,59,72,68\n"
            + "male,group D,associate degree,80,75,69\n"
            + "male,group C,master degree,71,67,67\n"
            + "female,group A,high school,61,68,63\n"
            + "female,group E,some college,87,85,93\n"
            + "male,group E,some high school,82,67,61\n"
            + "male,group C,some high school,62,64,55\n"
            + "female,group B,bachelor degree,97,97,96\n"
            + "male,group B,some college,75,68,65\n"
            + "female,group C,bachelor degree,65,79,81\n"
            + "male,group B,high school,52,49,46\n"
            + "male,group C,associate degree,87,73,72\n"
            + "female,group C,associate degree,53,62,53\n"
            + "female,group E,master degree,81,86,87\n"
            + "male,group D,bachelor degree,39,42,38\n"
            + "female,group C,some college,71,71,80\n"
            + "male,group C,associate degree,97,93,91\n"
            + "male,group D,some college,82,82,88\n"
            + "male,group C,high school,59,53,52\n"
            + "male,group B,associate degree,61,42,41\n"
            + "male,group E,associate degree,78,74,72\n"
            + "male,group C,associate degree,49,51,51\n"
            + "male,group B,high school,59,58,47\n"
            + "female,group C,some college,70,72,76\n"
            + "male,group B,associate degree,82,84,78\n"
            + "male,group E,associate degree,90,90,82\n"
            + "female,group C,bachelor degree,43,62,61\n"
            + "male,group C,some college,80,64,66\n"
            + "male,group D,some college,81,82,84\n"
            + "male,group C,some high school,57,61,54\n"
            + "female,group D,some high school,59,72,80\n"
            + "female,group D,associate degree,64,76,74\n"
            + "male,group C,bachelor degree,63,64,66\n"
            + "female,group E,bachelor degree,71,70,70\n"
            + "female,group B,high school,64,73,71\n"
            + "male,group D,bachelor degree,55,46,44\n"
            + "female,group E,associate degree,51,51,54\n"
            + "female,group C,associate degree,62,76,80\n"
            + "female,group E,associate degree,93,100,95\n"
            + "male,group C,high school,54,72,59\n"
            + "female,group D,some college,69,65,74\n"
            + "male,group D,high school,44,51,48\n"
            + "female,group E,some college,86,85,91\n"
            + "female,group E,associate degree,85,92,85\n"
            + "female,group A,master degree,50,67,73\n"
            + "male,group D,some high school,88,74,75\n"
            + "female,group E,associate degree,59,62,69\n"
            + "female,group E,some high school,32,34,38\n"
            + "male,group B,high school,36,29,27\n"
            + "female,group B,some high school,63,78,79\n"
            + "male,group D,associate degree,67,54,63\n"
            + "female,group D,some high school,65,78,82\n"
            + "male,group D,master degree,85,84,89\n"
            + "female,group C,master degree,73,78,74\n"
            + "female,group A,high school,34,48,41\n"
            + "female,group D,bachelor degree,93,100,100\n"
            + "female,group D,some high school,67,84,84\n"
            + "male,group D,some college,88,77,77\n"
            + "male,group B,high school,57,48,51\n"
            + "female,group D,some college,79,84,91\n"
            + "female,group C,bachelor degree,67,75,72\n"
            + "male,group E,bachelor degree,70,64,70\n"
            + "male,group D,bachelor degree,50,42,48\n"
            + "female,group A,some college,69,84,82\n"
            + "female,group C,bachelor degree,52,61,66\n"
            + "female,group C,bachelor degree,47,62,66\n"
            + "female,group B,associate degree,46,61,55\n"
            + "female,group E,some college,68,70,66\n"
            + "male,group E,bachelor degree,100,100,100\n"
            + "female,group C,high school,44,61,52\n"
            + "female,group C,associate degree,57,77,80\n"
            + "male,group B,some college,91,96,91\n"
            + "male,group D,high school,69,70,67\n"
            + "female,group C,high school,35,53,46\n"
            + "male,group D,high school,72,66,66\n"
            + "female,group B,associate degree,54,65,65\n"
            + "male,group D,high school,74,70,69\n"
            + "male,group E,some high school,74,64,60\n"
            + "male,group E,associate degree,64,56,52\n"
            + "female,group D,high school,65,61,71\n"
            + "male,group E,associate degree,46,43,44\n"
            + "female,group C,some high school,48,56,51\n"
            + "male,group C,some college,67,74,70\n"
            + "male,group D,some college,62,57,62\n"
            + "male,group D,associate degree,61,71,73\n"
            + "male,group C,bachelor degree,70,75,74\n"
            + "male,group C,associate degree,98,87,90\n"
            + "male,group D,some college,70,63,58\n"
            + "male,group A,associate degree,67,57,53\n"
            + "female,group E,high school,57,58,57\n"
            + "male,group D,some college,85,81,85\n"
            + "male,group D,some high school,77,68,69\n"
            + "male,group C,master degree,72,66,72\n"
            + "female,group D,master degree,78,91,96\n"
            + "male,group C,high school,81,66,64\n"
            + "male,group A,some high school,61,62,61\n"
            + "female,group B,high school,58,68,61\n"
            + "female,group C,associate degree,54,61,58\n"
            + "male,group B,high school,82,82,80\n"
            + "female,group D,some college,49,58,60\n"
            + "male,group B,some high school,49,50,52\n"
            + "female,group E,high school,57,75,73\n"
            + "male,group E,high school,94,73,71\n"
            + "female,group D,some college,75,77,83\n"
            + "female,group E,some high school,74,74,72\n"
            + "male,group C,high school,58,52,54\n"
            + "female,group C,some college,62,69,69\n"
            + "male,group E,associate degree,72,57,62\n"
            + "male,group C,some college,84,87,81\n"
            + "female,group D,master degree,92,100,100\n"
            + "female,group D,high school,45,63,59\n"
            + "male,group C,high school,75,81,71\n"
            + "female,group A,some college,56,58,64\n"
            + "female,group D,some high school,48,54,53\n"
            + "female,group E,associate degree,100,100,100\n"
            + "female,group C,some high school,65,76,75\n"
            + "male,group D,some college,72,57,58\n"
            + "female,group D,some college,62,70,72\n"
            + "male,group A,some high school,66,68,64\n"
            + "male,group C,some college,63,63,60\n"
            + "female,group E,associate degree,68,76,67\n"
            + "female,group B,bachelor degree,75,84,80\n"
            + "female,group D,bachelor degree,89,100,100\n"
            + "male,group C,some high school,78,72,69\n"
            + "female,group A,high school,53,50,60\n"
            + "female,group D,some college,49,65,61\n"
            + "female,group A,some college,54,63,67\n"
            + "female,group C,some college,64,82,77\n"
            + "male,group B,some college,60,62,60\n"
            + "male,group C,associate degree,62,65,58\n"
            + "male,group D,high school,55,41,48\n"
            + "female,group C,associate degree,91,95,94\n"
            + "female,group B,high school,8,24,23\n"
            + "male,group D,some high school,81,78,78\n"
            + "male,group B,some high school,79,85,86\n"
            + "female,group A,some college,78,87,91\n"
            + "female,group C,some high school,74,75,82\n"
            + "male,group A,high school,57,51,54\n"
            + "female,group C,associate degree,40,59,51\n"
            + "male,group E,some high school,81,75,76\n"
            + "female,group A,some high school,44,45,45\n"
            + "female,group D,some college,67,86,83\n"
            + "male,group E,high school,86,81,75\n"
            + "female,group B,some high school,65,82,78\n"
            + "female,group D,associate degree,55,76,76\n"
            + "female,group D,bachelor degree,62,72,74\n"
            + "male,group A,high school,63,63,62\n"
            + "female,group E,master degree,88,99,95\n"
            + "male,group C,high school,62,55,55\n"
            + "female,group C,high school,59,71,65\n"
            + "female,group D,some college,68,78,77\n"
            + "female,group D,some college,77,86,86";
}
