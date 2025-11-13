package proxy;

public class RealImage implements Image {
    private String fileName;
    
    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }
    
    private void loadFromDisk() {
        System.out.println("Loading image from disk: " + fileName);
        try {
            Thread.sleep(1000); // Simulate slow loading
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    @Override
    public void display() {
        System.out.println("Displaying image: " + fileName);
    }
    
    @Override
    public String getFileName() {
        return fileName;
    }
}
