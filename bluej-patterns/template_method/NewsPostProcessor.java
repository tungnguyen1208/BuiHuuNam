package template_method;

public class NewsPostProcessor extends PostProcessor {
    
    @Override
    protected void formatContent(String content) {
        System.out.println("2. Formatting as news post (headline style)...");
    }
    
    @Override
    protected void notifyUsers(String title) {
        System.out.println("4. Notifying all subscribers (breaking news)...");
    }
}
