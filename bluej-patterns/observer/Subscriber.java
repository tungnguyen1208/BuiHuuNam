package observer;

public interface Subscriber {
    void update(String postTitle, String postContent);
    String getName();
}
