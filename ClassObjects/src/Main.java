import cat.Cat;
import student.Student;

public class Main {
    public static void main(String[] args) {
        /*cat.Cat tom = new cat.Cat();
        tom.setName("Tom");
        tom.setAge(6);

        System.out.println("cat's name : " + tom.getName());
        tom.move();

        System.out.println("=========");
        cat.Cat miu = new cat.Cat();
        miu.setName("Miuuuu");
        miu.setAge(6);
        miu.sleep();

        System.out.println("=========");
        student.Student mai = new student.Student();
        mai.setName("Pham Thi Mai");
        mai.setAge(20);
        mai.setEmail("mai@gmail.com");

        System.out.println("name: " + mai.getName());
        System.out.println("age: " + mai.getAge());
        System.out.println("email: " + mai.getEmail());
        mai.doHomework("Physic");*/

        Cat cat = new Cat("Tom", 4);
        System.out.println("cat.Cat name: " + cat.getName());
        System.out.println("cat.Cat age: " + cat.getAge());
        System.out.println("cat.Cat color: " + cat.getColor());

        Student student = new Student("21522004", "Nguyen Khanh Duy", 20,
                "nguyenkhanhduy@gmail.com");
        System.out.println("Name : " + student.getName());
        System.out.println("Id : " + student.getId());
        System.out.println("email : " + student.getEmail());
        System.out.println("age : " + student.getAge());
    }
}
