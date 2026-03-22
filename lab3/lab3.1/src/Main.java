public class Main {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        StudentRegister register = new StudentRegister();
        student1.SetId(1);
        student1.SetName("Mykhailo");
        student1.SetGrade(11);
        student2.SetId(2);
        student2.SetName("Kyrylo");
        student2.SetGrade(10);
        student3.SetId(3);
        student3.SetName("Maksym");
        student3.SetGrade(8);
        register.AddToMap(student1);
        register.AddToMap(student2);
        register.AddToMap(student3);
        System.out.println(register.Search(1));
    }
}
