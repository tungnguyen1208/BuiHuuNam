package adapter;

public class StandardHTMLRenderer implements HTMLRenderer {
    private String htmlContent;
    
    @Override
    public void setContent(String content) {
        this.htmlContent = content;
    }
    
    @Override
    public String renderHTML() {
        return "<html><body>" + htmlContent + "</body></html>";
    }
}
