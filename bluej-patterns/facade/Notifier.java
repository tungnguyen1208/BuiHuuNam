package facade;

public class Notifier {
    public void notifySubscribers(String title) {
        System.out.println("Notifying subscribers about: " + title);
    }
}
