package template_method;

public abstract class PostProcessor {
    
    // Template Method - định nghĩa skeleton
    public final void processPost(String title, String content) {
        System.out.println("\n=== Processing Post: " + title + " ===");
        
        validateContent(content);
        formatContent(content);
        saveToDatabase(title, content);
        notifyUsers(title);
        
        System.out.println("Post processing complete!\n");
    }
    
    // Common steps
    private void validateContent(String content) {
        System.out.println("1. Validating content length...");
        if (content.length() < 10) {
            throw new IllegalArgumentException("Content too short!");
        }
    }
    
    private void saveToDatabase(String title, String content) {
        System.out.println("3. Saving to database...");
    }
    
    // Abstract methods - subclass override
    protected abstract void formatContent(String content);
    protected abstract void notifyUsers(String title);
}
