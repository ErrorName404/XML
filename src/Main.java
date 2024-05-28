import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Files files = new Files();

        try {
            files.write();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        try {
            files.read();
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }

    }
}