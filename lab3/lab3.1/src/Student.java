import java.util.Map;

public class Student {
    private int id;
    private String fullName;
    private int grade;

    public void SetId (int id){
        this.id = id;
    }
    public int GetId(){
        return id;
    }
    public void SetName(String fullName){
        this.fullName = fullName;
    }

    public String GetName(){
        return fullName;
    }

    public void SetGrade(int grade){
        this.grade = grade;
    }

    public int GetGrade(){
        return grade;
    }

    @Override
    public String toString() {
        return "Студент [ID: " + GetId() + ", Ім'я: " + GetName() + ", Оцінка: " + GetGrade() + "]";
    }
}
