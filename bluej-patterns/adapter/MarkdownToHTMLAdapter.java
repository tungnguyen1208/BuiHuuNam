package adapter;

public class MarkdownToHTMLAdapter implements HTMLRenderer {
    private MarkdownContent markdownContent;
    
    public MarkdownToHTMLAdapter(MarkdownContent content) {
        this.markdownContent = content;
    }
    
    @Override
    public void setContent(String content) {
        markdownContent.setMarkdownText(content);
    }
    
    @Override
    public String renderHTML() {
        String md = markdownContent.getMarkdownText();
        String html = convertMarkdownToHTML(md);
        return "<html><body>" + html + "</body></html>";
    }
    
    private String convertMarkdownToHTML(String markdown) {
        String html = markdown;
        html = html.replaceAll("# (.*)", "<h1>$1</h1>");
        html = html.replaceAll("## (.*)", "<h2>$1</h2>");
        html = html.replaceAll("\\*\\*(.*?)\\*\\*", "<b>$1</b>");
        html = html.replaceAll("\\*(.*?)\\*", "<i>$1</i>");
        return html;
    }
}
