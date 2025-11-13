package adapter;

public class MarkdownContent {
    private String markdownText;
    
    public MarkdownContent(String text) {
        this.markdownText = text;
    }
    
    public String getMarkdownText() {
        return markdownText;
    }
    
    public void setMarkdownText(String text) {
        this.markdownText = text;
    }
}
