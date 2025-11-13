package template_method;

public class TechnicalPostProcessor extends PostProcessor {
    
    @Override
    protected void formatContent(String content) {
        System.out.println("2. Formatting as technical post (code highlighting)...");
    }
    
    @Override
    protected void notifyUsers(String title) {
        System.out.println("4. Notifying tech subscribers...");
    }
}
