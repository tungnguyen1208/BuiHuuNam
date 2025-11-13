package adapter;

public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("=== ADAPTER PATTERN DEMO ===\n");
        
        // Standard HTML
        HTMLRenderer standardRenderer = new StandardHTMLRenderer();
        standardRenderer.setContent("<p>This is HTML content</p>");
        System.out.println("Standard HTML:");
        System.out.println(standardRenderer.renderHTML());
        
        // Markdown through adapter
        MarkdownContent mdContent = new MarkdownContent(
            "# Title\n## Subtitle\n**Bold text** and *italic text*"
        );
        HTMLRenderer mdAdapter = new MarkdownToHTMLAdapter(mdContent);
        System.out.println("\nMarkdown converted to HTML:");
        System.out.println(mdAdapter.renderHTML());
    }
}
