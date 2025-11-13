package abstract_factory;

/**
 * Concrete Product - Classic Header
 */
public class ClassicHeader implements Header {
    private String title;
    private String logoPath;
    
    public ClassicHeader() {
        this.title = "Classic Blog";
        this.logoPath = "classic_logo.gif";
    }
    
    @Override
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Override
    public void setLogo(String logoPath) {
        this.logoPath = logoPath;
    }
    
    @Override
    public void render() {
        System.out.println("======= Classic Header =======");
        System.out.println("|| Logo: " + logoPath + " ||");
        System.out.println("|| " + title + " ||");
        System.out.println("==============================");
    }
    
    @Override
    public String getStyle() {
        return "Classic: Bold borders, table layout, centered elements";
    }
}
