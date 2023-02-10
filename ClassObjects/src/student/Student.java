package student;

public class Student {
    private String id;
    private String name;
    private String grade;
    private int age;
    private float avgMark;
    private float fee;
    private String email;

    public void setId(String id) {
        this.id = id;
    }

    public Student(String id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAvgMark(float avgMark) {
        this.avgMark = avgMark;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    public int getAge() {
        return age;
    }

    public float getAvgMark() {
        return avgMark;
    }

    public float getFee() {
        return fee;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    private String phoneNumber;

    public void study(String subject) {

    }

    public void payFee(float amount) {

    }

    public void doHomework(String subject) {
        System.out.println(this.name + " do " + subject);
    }

    public void doTest(String subject) {

    }

}
