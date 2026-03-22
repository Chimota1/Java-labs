import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        boolean file = true;
        try {
            FileCheck(file);
        }
        catch (FileNotFoundException e){
            System.err.println("Помилка: " + e.getMessage());
        }
        finally {
            System.out.println("Звільнення ресурсів");
        }

    }
    public static void FileCheck(boolean isExist) throws FileNotFoundException {
        if (isExist == true){
            System.out.println("Файл існує");
        }
        else {
            throw new java.io.FileNotFoundException("Файлу не існує");
        }
    }
}