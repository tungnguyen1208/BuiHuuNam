package facade;

public class Validator {
    public boolean validate(String title, String content) {
        System.out.println("Validating post...");
        return title != null && !title.isEmpty() && 
               content != null && content.length() > 10;
    }
}
