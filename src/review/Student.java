package review;

public class Student {
    private int id;
    private BirthDate birthDate;

    public Student(int ssn,
                   int year, int month, int day) {
        id = ssn;
        birthDate = new BirthDate(year, month, day);
    }

    public int getId() {
        return id;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public static void main(String[] args) {
        Student s1 = new Student(12, 1999, 11, 15);
        BirthDate b1 = new BirthDate(1999, 11, 16);
        System.out.println(s1.birthDate);
        System.out.println(s1.getBirthDate());
        b1.setYear(2000);

    }
}