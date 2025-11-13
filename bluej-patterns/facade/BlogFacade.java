package facade;

public class BlogFacade {
    private Validator validator;
    private Database database;
    private SearchIndexer indexer;
    private Notifier notifier;
    
    public BlogFacade() {
        this.validator = new Validator();
        this.database = new Database();
        this.indexer = new SearchIndexer();
        this.notifier = new Notifier();
    }
    
    public boolean publishPost(String title, String content) {
        System.out.println("\n=== Publishing Post via Facade ===");
        
        if (!validator.validate(title, content)) {
            System.out.println("Validation failed!");
            return false;
        }
        
        database.save(title, content);
        indexer.index(title, content);
        notifier.notifySubscribers(title);
        
        System.out.println("Post published successfully!");
        return true;
    }
}
