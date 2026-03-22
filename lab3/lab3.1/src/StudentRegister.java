import java.util.HashMap;

public class StudentRegister {
    private HashMap<Integer,Student> StudentsList = new HashMap<>();

    public void AddToMap(Student student){
        StudentsList.put(student.GetId(),student);
    }

    public void DeleteFromMap(Student student){
        StudentsList.remove(student.GetId());
    }

    public Student Search(int target){
        if (StudentsList.containsKey(target)) {
            return StudentsList.get(target);
        }
        else {
            System.out.println("Такого студента неіснує");
            return null;
        }
    }

    public void ShowAllStudent(){
        StudentsList.forEach((key,value) -> {
            System.out.println(value.toString());
        });
    }
}
