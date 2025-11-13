# MÔ TẢ BÀI TOÁN CHI TIẾT - 12 MẪU THIẾT KẾ TRONG BLUEJ-PATTERNS

## DETAILED PROBLEM DESCRIPTIONS - 12 DESIGN PATTERNS IN BLUEJ-PATTERNS

---

## MỤC LỤC / TABLE OF CONTENTS

### CREATIONAL PATTERNS (Nhóm Khởi Tạo)
1. [Singleton Pattern](#1-singleton-pattern)
2. [Factory Method Pattern](#2-factory-method-pattern)
3. [Abstract Factory Pattern](#3-abstract-factory-pattern)
4. [Builder Pattern](#4-builder-pattern)
5. [Prototype Pattern](#5-prototype-pattern)

### STRUCTURAL PATTERNS (Nhóm Cấu Trúc)
6. [Adapter Pattern](#6-adapter-pattern)
7. [Decorator Pattern](#7-decorator-pattern)
8. [Facade Pattern](#8-facade-pattern)
9. [Proxy Pattern](#9-proxy-pattern)

### BEHAVIORAL PATTERNS (Nhóm Hành Vi)
10. [Observer Pattern](#10-observer-pattern)
11. [Strategy Pattern](#11-strategy-pattern)
12. [Template Method Pattern](#12-template-method-pattern)

---

# CREATIONAL PATTERNS (MẪU KHỞI TẠO)

## 1. SINGLETON PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Trong hệ thống website blog, chúng ta cần có một đối tượng quản lý cấu hình toàn cục (BlogConfig) mà toàn bộ ứng dụng sử dụng. Nếu tạo nhiều instance của cấu hình, sẽ dẫn đến:
- Lãng phí bộ nhớ
- Dữ liệu cấu hình không nhất quán
- Khó kiểm soát trạng thái hệ thống

**English:**
In a blog website system, we need a global configuration object (BlogConfig) that the entire application uses. Creating multiple instances of configuration leads to:
- Memory waste
- Inconsistent configuration data
- Difficulty controlling system state

### 💡 GIẢI PHÁP / SOLUTION

**Singleton Pattern** đảm bảo một class chỉ có duy nhất một instance và cung cấp một điểm truy cập toàn cục đến instance đó.

**Cấu trúc trong bluej-patterns/singleton/:**
- `BlogConfig` - Singleton class chứa cấu hình blog
- `ConfigManager` - Class quản lý và sử dụng singleton
- `SingletonDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public class BlogConfig {
    private static BlogConfig instance;
    
    private BlogConfig() { } // Private constructor
    
    public static BlogConfig getInstance() {
        if (instance == null) {
            instance = new BlogConfig();
        }
        return instance;
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Cấu hình blog:** Tên blog, số bài viết mỗi trang, theme mặc định
- **Kết nối database:** Chỉ cần một connection pool
- **Logger:** Một instance ghi log cho toàn hệ thống

### ✅ LỢI ÍCH / BENEFITS

1. **Tiết kiệm bộ nhớ** - Chỉ một instance duy nhất
2. **Dữ liệu nhất quán** - Một nguồn cấu hình cho toàn ứng dụng
3. **Truy cập dễ dàng** - Global access point
4. **Lazy initialization** - Chỉ tạo khi cần thiết

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

Khi mở trong BlueJ, bạn sẽ thấy:
- `BlogConfig` với constructor private
- Static method `getInstance()`
- `ConfigManager` sử dụng singleton
- `SingletonDemo` để test

---

## 2. FACTORY METHOD PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Website blog có nhiều loại bài viết khác nhau: Technical (công nghệ), News (tin tức), Lifestyle (phong cách sống). Mỗi loại có cách format và hiển thị riêng. Nếu dùng `if-else` hoặc `switch` để tạo bài viết:
- Code khó bảo trì
- Vi phạm Open/Closed Principle
- Khó mở rộng thêm loại bài viết mới

**English:**
A blog website has different post types: Technical, News, Lifestyle. Each type has its own formatting and display method. Using `if-else` or `switch` to create posts leads to:
- Hard to maintain code
- Violates Open/Closed Principle
- Difficult to add new post types

### 💡 GIẢI PHÁP / SOLUTION

**Factory Method Pattern** định nghĩa một interface để tạo đối tượng, nhưng để subclass quyết định class nào sẽ được khởi tạo.

**Cấu trúc trong bluej-patterns/factory_method/:**
- `Post` (interface) - Định nghĩa bài viết
- `TechnicalPost`, `NewsPost`, `LifestylePost` - Các loại bài viết cụ thể
- `PostFactory` (abstract) - Factory base class
- `TechnicalPostFactory`, `NewsPostFactory`, `LifestylePostFactory` - Concrete factories
- `FactoryMethodDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
// Abstract factory
public abstract class PostFactory {
    public abstract Post createPost(String title, String content);
}

// Concrete factory
public class TechnicalPostFactory extends PostFactory {
    public Post createPost(String title, String content) {
        return new TechnicalPost(title, content);
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Tạo bài viết theo loại:** Technical, News, Lifestyle
- **Tạo comment:** Text comment, Image comment, Video comment
- **Tạo notification:** Email, SMS, Push notification

### ✅ LỢI ÍCH / BENEFITS

1. **Tách biệt code tạo đối tượng** - Loose coupling
2. **Dễ mở rộng** - Thêm loại mới không ảnh hưởng code cũ
3. **Single Responsibility** - Mỗi factory có trách nhiệm riêng
4. **Tuân thủ Open/Closed Principle**

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

Trong BlueJ sẽ thấy rõ:
- Inheritance từ `PostFactory` đến các concrete factories
- Implementation của `Post` interface
- Relationships giữa factory và product

---

## 3. ABSTRACT FACTORY PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Website blog cần hỗ trợ nhiều theme (giao diện): Modern và Classic. Mỗi theme có bộ UI components khác nhau: Button, Header, Footer. Vấn đề:
- Các components phải tương thích với nhau trong cùng theme
- Không thể mix components từ theme khác nhau
- Khó quản lý khi thêm theme mới

**English:**
A blog website needs to support multiple themes: Modern and Classic. Each theme has different UI components: Button, Header, Footer. Problems:
- Components must be compatible within the same theme
- Cannot mix components from different themes
- Difficult to manage when adding new themes

### 💡 GIẢI PHÁP / SOLUTION

**Abstract Factory Pattern** cung cấp interface để tạo families of related objects mà không cần chỉ định concrete classes.

**Cấu trúc trong bluej-patterns/abstract_factory/:**
- `UIComponent` (interface) - Base component
- `Button`, `Header`, `Footer` (interfaces) - Component types
- `ModernButton`, `ClassicButton`, etc. - Concrete components
- `ThemeFactory` (interface) - Abstract factory
- `ModernThemeFactory`, `ClassicThemeFactory` - Concrete factories
- `BlogPage` - Client sử dụng factory
- `AbstractFactoryDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public interface ThemeFactory {
    Button createButton();
    Header createHeader();
    Footer createFooter();
}

public class ModernThemeFactory implements ThemeFactory {
    public Button createButton() { return new ModernButton(); }
    public Header createHeader() { return new ModernHeader(); }
    public Footer createFooter() { return new ModernFooter(); }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Theme system:** Modern theme, Classic theme
- **Export formats:** PDF exporter, HTML exporter, Markdown exporter
- **Platform-specific UI:** Web UI, Mobile UI, Desktop UI

### ✅ LỢI ÍCH / BENEFITS

1. **Đảm bảo tính tương thích** - Components cùng family
2. **Dễ thay đổi theme** - Chỉ cần đổi factory
3. **Tách biệt code** - Client không biết concrete classes
4. **Dễ mở rộng** - Thêm theme mới dễ dàng

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ hiển thị:
- Abstract factory interface và concrete factories
- Product families (Button, Header, Footer)
- Relationships giữa factory và products
- Client (`BlogPage`) sử dụng factory

---

## 4. BUILDER PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Tạo một bài viết blog phức tạp với nhiều thuộc tính: title, content, author, category, tags, publish date, status, etc. Vấn đề:
- Constructor có quá nhiều tham số (telescoping constructor problem)
- Khó đọc và dễ nhầm lẫn thứ tự tham số
- Không linh hoạt với optional parameters

**English:**
Creating a complex blog article with many attributes: title, content, author, category, tags, publish date, status, etc. Problems:
- Constructor has too many parameters (telescoping constructor problem)
- Hard to read and easy to confuse parameter order
- Not flexible with optional parameters

### 💡 GIẢI PHÁP / SOLUTION

**Builder Pattern** tách riêng quá trình construction của object phức tạp, cho phép tạo object theo từng bước với fluent interface.

**Cấu trúc trong bluej-patterns/builder/:**
- `Article` - Complex object cần build
- `Article.Builder` (inner class) - Builder class
- `BuilderDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public class Article {
    private String title;
    private String content;
    private String author;
    private List<String> tags;
    
    private Article(Builder builder) {
        this.title = builder.title;
        this.content = builder.content;
        // ...
    }
    
    public static class Builder {
        private String title;
        private String content;
        
        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }
        
        public Article build() {
            return new Article(this);
        }
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Tạo bài viết:** Article với nhiều thuộc tính
- **Tạo query:** SQL query builder
- **Tạo email:** Email với subject, body, attachments, recipients

### ✅ LỢI ÍCH / BENEFITS

1. **Fluent interface** - Code dễ đọc: `builder.setTitle().setContent().build()`
2. **Tách biệt construction** - Separate construction from representation
3. **Immutable objects** - Object final sau khi build
4. **Flexible** - Optional parameters dễ dàng

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ show:
- `Article` class với private constructor
- Inner class `Builder`
- Method chaining trong builder
- Demo sử dụng builder

---

## 5. PROTOTYPE PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Khi tạo bài viết mới, thường muốn copy từ template có sẵn (bài viết mẫu) để giữ format, category, tags. Vấn đề:
- Tạo object mới từ đầu tốn thời gian
- Muốn clone object nhưng không muốn phụ thuộc vào concrete class
- Cần copy deep vs shallow copy

**English:**
When creating new posts, often want to copy from existing templates (sample posts) to keep format, category, tags. Problems:
- Creating new object from scratch is time-consuming
- Want to clone object without depending on concrete class
- Need deep vs shallow copy

### 💡 GIẢI PHÁP / SOLUTION

**Prototype Pattern** cho phép copy object hiện có mà không phụ thuộc vào class của chúng.

**Cấu trúc trong bluej-patterns/prototype/:**
- `BlogPost` - Cloneable object
- `PostRegistry` - Quản lý prototypes
- `PrototypeDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public class BlogPost implements Cloneable {
    private String title;
    private String category;
    private List<String> tags;
    
    @Override
    public BlogPost clone() {
        try {
            BlogPost cloned = (BlogPost) super.clone();
            // Deep copy for mutable fields
            cloned.tags = new ArrayList<>(this.tags);
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

public class PostRegistry {
    private Map<String, BlogPost> templates = new HashMap<>();
    
    public BlogPost getTemplate(String key) {
        return templates.get(key).clone();
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Post templates:** Technical template, News template
- **Copy bài viết** để chỉnh sửa
- **Clone settings** để tạo variations

### ✅ LỢI ÍCH / BENEFITS

1. **Tạo nhanh** - Clone nhanh hơn new
2. **Giảm dependency** - Không cần biết concrete class
3. **Dynamic** - Add/remove prototypes at runtime
4. **Avoid subclassing** - Không cần nhiều subclass cho variations

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ hiển thị:
- `BlogPost` implements `Cloneable`
- `clone()` method
- `PostRegistry` quản lý prototypes
- Demo clone và modify

---

# STRUCTURAL PATTERNS (MẪU CẤU TRÚC)

## 6. ADAPTER PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Hệ thống blog cũ sử dụng Markdown format, nhưng hệ thống mới chỉ hiểu HTML. Markdown parser cũ (`MarkdownContent`) không tương thích với interface mới (`HTMLRenderer`). Vấn đề:
- Không thể sửa code cũ (legacy code)
- Muốn tái sử dụng Markdown parser
- Cần làm cho Markdown parser hoạt động với HTML renderer

**English:**
Old blog system uses Markdown format, but new system only understands HTML. Old Markdown parser (`MarkdownContent`) is not compatible with new interface (`HTMLRenderer`). Problems:
- Cannot modify legacy code
- Want to reuse Markdown parser
- Need to make Markdown parser work with HTML renderer

### 💡 GIẢI PHÁP / SOLUTION

**Adapter Pattern** chuyển đổi interface của một class thành interface mà client mong đợi.

**Cấu trúc trong bluej-patterns/adapter/:**
- `HTMLRenderer` (interface) - Target interface
- `StandardHTMLRenderer` - Standard implementation
- `MarkdownContent` - Adaptee (legacy class)
- `MarkdownToHTMLAdapter` - Adapter class
- `AdapterDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
// Target interface
public interface HTMLRenderer {
    String renderHTML();
}

// Adaptee (legacy)
public class MarkdownContent {
    public String getMarkdown() {
        return "# Title\n**bold**";
    }
}

// Adapter
public class MarkdownToHTMLAdapter implements HTMLRenderer {
    private MarkdownContent markdown;
    
    public MarkdownToHTMLAdapter(MarkdownContent markdown) {
        this.markdown = markdown;
    }
    
    @Override
    public String renderHTML() {
        String md = markdown.getMarkdown();
        // Convert Markdown to HTML
        return convertToHTML(md);
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Format conversion:** Markdown → HTML, JSON → XML
- **Legacy integration:** Old payment system → New payment interface
- **Third-party libraries:** Adapt external library to your interface

### ✅ LỢI ÍCH / BENEFITS

1. **Tái sử dụng code cũ** - Reuse existing code
2. **Tách biệt concerns** - Conversion logic separated
3. **Single Responsibility** - Adapter chỉ lo conversion
4. **Open/Closed** - Thêm adapter mới không sửa code cũ

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ show rõ:
- Target interface (`HTMLRenderer`)
- Adaptee (`MarkdownContent`)
- Adapter implementing target và sử dụng adaptee
- Composition relationship

---

## 7. DECORATOR PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Bài viết blog có thể có thêm nhiều tính năng: Image, Video, Comments, Likes. Nếu dùng inheritance:
- Tạo quá nhiều subclass: PostWithImage, PostWithVideo, PostWithImageAndVideo...
- Không linh hoạt: Không thể add/remove features at runtime
- Class explosion problem

**English:**
Blog posts can have additional features: Image, Video, Comments, Likes. Using inheritance:
- Creates too many subclasses: PostWithImage, PostWithVideo, PostWithImageAndVideo...
- Not flexible: Cannot add/remove features at runtime
- Class explosion problem

### 💡 GIẢI PHÁP / SOLUTION

**Decorator Pattern** cho phép thêm behavior vào object một cách động mà không ảnh hưởng đến objects khác.

**Cấu trúc trong bluej-patterns/decorator/:**
- `Post` (interface) - Component interface
- `BasicPost` - Concrete component
- `PostDecorator` (abstract) - Decorator base
- `ImageDecorator`, `VideoDecorator` - Concrete decorators
- `DecoratorDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public interface Post {
    String display();
    double getCost();
}

public class BasicPost implements Post {
    public String display() { return "Basic Post"; }
    public double getCost() { return 0.0; }
}

public abstract class PostDecorator implements Post {
    protected Post decoratedPost;
    
    public PostDecorator(Post post) {
        this.decoratedPost = post;
    }
}

public class ImageDecorator extends PostDecorator {
    public ImageDecorator(Post post) { super(post); }
    
    public String display() {
        return decoratedPost.display() + " + Image";
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Post features:** Add image, video, comments dynamically
- **Formatting:** Bold, Italic, Underline text
- **Stream processing:** BufferedInputStream wraps FileInputStream

### ✅ LỢI ÍCH / BENEFITS

1. **Flexible** - Add/remove features at runtime
2. **Single Responsibility** - Mỗi decorator một feature
3. **Open/Closed** - Extend without modifying
4. **Composition over inheritance** - Tránh class explosion

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ hiển thị:
- Component interface (`Post`)
- Concrete component (`BasicPost`)
- Decorator base class
- Concrete decorators
- Wrapping relationships

---

## 8. FACADE PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Publish một bài viết blog cần nhiều bước phức tạp:
1. Validate dữ liệu (Validator)
2. Lưu vào database (Database)
3. Index cho search (SearchIndexer)
4. Gửi notification (Notifier)

Client phải biết và gọi từng subsystem → Phức tạp và dễ sai.

**English:**
Publishing a blog post requires many complex steps:
1. Validate data (Validator)
2. Save to database (Database)
3. Index for search (SearchIndexer)
4. Send notifications (Notifier)

Client must know and call each subsystem → Complex and error-prone.

### 💡 GIẢI PHÁP / SOLUTION

**Facade Pattern** cung cấp unified interface đơn giản cho một tập các interfaces phức tạp trong subsystem.

**Cấu trúc trong bluej-patterns/facade/:**
- `Validator` - Validate subsystem
- `Database` - Storage subsystem
- `SearchIndexer` - Indexing subsystem
- `Notifier` - Notification subsystem
- `BlogFacade` - Facade class
- `FacadeDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
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
    
    public void publishPost(String title, String content) {
        // Simplified interface
        validator.validate(title, content);
        database.save(title, content);
        indexer.index(title, content);
        notifier.notify(title);
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Blog publishing:** Validate → Save → Index → Notify
- **Order processing:** Check inventory → Process payment → Ship → Send receipt
- **Library usage:** Complex library → Simple facade

### ✅ LỢI ÍCH / BENEFITS

1. **Simplify complex systems** - Một interface đơn giản
2. **Loose coupling** - Client không phụ thuộc subsystems
3. **Easy to use** - Fewer methods to learn
4. **Layered architecture** - Clear separation

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ show:
- Multiple subsystem classes
- Facade class coordinating them
- Client chỉ biết facade
- Composition relationships

---

## 9. PROXY PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Load hình ảnh trong bài viết blog tốn nhiều tài nguyên:
- Hình ảnh lớn (vài MB)
- Tốn bandwidth
- Tốn thời gian load
- Có thể user không xem hết các hình

Cần lazy loading: chỉ load hình khi thực sự cần.

**English:**
Loading images in blog posts is resource-intensive:
- Large images (several MB)
- Bandwidth consumption
- Long loading time
- User may not view all images

Need lazy loading: only load image when actually needed.

### 💡 GIẢI PHÁP / SOLUTION

**Proxy Pattern** cung cấp placeholder/surrogate để kiểm soát access đến object thực.

**Cấu trúc trong bluej-patterns/proxy/:**
- `Image` (interface) - Subject interface
- `RealImage` - Real object (expensive)
- `ImageProxy` - Proxy object (placeholder)
- `ProxyDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public interface Image {
    void display();
}

public class RealImage implements Image {
    private String filename;
    
    public RealImage(String filename) {
        this.filename = filename;
        loadFromDisk(); // Expensive operation
    }
    
    public void display() {
        System.out.println("Displaying " + filename);
    }
}

public class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;
    
    public ImageProxy(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // Lazy load
        }
        realImage.display();
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Lazy loading:** Images, videos, large documents
- **Access control:** Check permissions before accessing
- **Caching:** Cache results of expensive operations
- **Remote proxy:** Access remote objects

### ✅ LỢI ÍCH / BENEFITS

1. **Performance** - Lazy initialization
2. **Control access** - Add security, logging
3. **Reduce memory** - Load only when needed
4. **Transparent** - Client treats proxy same as real object

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ hiển thị:
- Subject interface (`Image`)
- RealSubject (`RealImage`)
- Proxy (`ImageProxy`)
- Both implement same interface
- Proxy holds reference to RealSubject

---

# BEHAVIORAL PATTERNS (MẪU HÀNH VI)

## 10. OBSERVER PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Khi có bài viết mới, cần thông báo cho nhiều subscribers:
- Email subscribers
- SMS subscribers
- Push notification subscribers

Vấn đề:
- Publisher không nên biết chi tiết từng subscriber
- Subscribers có thể subscribe/unsubscribe dynamically
- Một thay đổi → nhiều objects phải update

**English:**
When there's a new post, need to notify many subscribers:
- Email subscribers
- SMS subscribers
- Push notification subscribers

Problems:
- Publisher shouldn't know details of each subscriber
- Subscribers can subscribe/unsubscribe dynamically
- One change → many objects must update

### 💡 GIẢI PHÁP / SOLUTION

**Observer Pattern** định nghĩa one-to-many dependency giữa objects sao cho khi một object thay đổi state, tất cả dependents được notify và update tự động.

**Cấu trúc trong bluej-patterns/observer/:**
- `Subscriber` (interface) - Observer interface
- `EmailSubscriber`, `SMSSubscriber` - Concrete observers
- `Publisher` - Subject class
- `ObserverDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public interface Subscriber {
    void update(String postTitle);
}

public class EmailSubscriber implements Subscriber {
    private String email;
    
    public void update(String postTitle) {
        System.out.println("Email to " + email + ": " + postTitle);
    }
}

public class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    
    public void subscribe(Subscriber s) {
        subscribers.add(s);
    }
    
    public void publishPost(String title) {
        // Notify all subscribers
        for (Subscriber s : subscribers) {
            s.update(title);
        }
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Blog notifications:** Notify subscribers về bài mới
- **Event handling:** GUI events (button click → multiple listeners)
- **Stock market:** Price change → notify investors
- **Social media:** New post → notify followers

### ✅ LỢI ÍCH / BENEFITS

1. **Loose coupling** - Publisher không biết concrete observers
2. **Dynamic relationships** - Add/remove observers at runtime
3. **Broadcast communication** - One-to-many notification
4. **Open/Closed Principle** - Thêm observer mới dễ dàng

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ show rõ:
- Observer interface (`Subscriber`)
- Concrete observers (`EmailSubscriber`, `SMSSubscriber`)
- Subject (`Publisher`)
- Observer list trong subject
- Update flow

---

## 11. STRATEGY PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Hiển thị danh sách bài viết blog có nhiều cách sắp xếp:
- Theo alphabet
- Theo ngày đăng
- Theo popularity (views, likes)

Vấn đề:
- Không muốn dùng `if-else` để chọn algorithm
- Muốn thay đổi sorting strategy at runtime
- Muốn dễ dàng thêm strategy mới

**English:**
Displaying blog post list has multiple sorting methods:
- Alphabetically
- By date
- By popularity (views, likes)

Problems:
- Don't want to use `if-else` to select algorithm
- Want to change sorting strategy at runtime
- Want to easily add new strategies

### 💡 GIẢI PHÁP / SOLUTION

**Strategy Pattern** định nghĩa family of algorithms, đóng gói từng algorithm, và làm chúng interchangeable.

**Cấu trúc trong bluej-patterns/strategy/:**
- `SortStrategy` (interface) - Strategy interface
- `AlphabeticalSortStrategy`, `DateSortStrategy`, `PopularitySortStrategy` - Concrete strategies
- `BlogDisplay` - Context class
- `StrategyDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public interface SortStrategy {
    List<String> sort(List<String> posts);
}

public class AlphabeticalSortStrategy implements SortStrategy {
    public List<String> sort(List<String> posts) {
        List<String> sorted = new ArrayList<>(posts);
        Collections.sort(sorted);
        return sorted;
    }
}

public class BlogDisplay {
    private SortStrategy strategy;
    
    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void displayPosts(List<String> posts) {
        List<String> sorted = strategy.sort(posts);
        // Display sorted posts
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Sorting:** Different sorting algorithms
- **Payment:** Credit card, PayPal, Bitcoin
- **Compression:** ZIP, RAR, 7Z
- **Rendering:** HTML, JSON, XML output

### ✅ LỢI ÍCH / BENEFITS

1. **Flexible** - Switch algorithms at runtime
2. **Eliminate conditionals** - No `if-else` chains
3. **Open/Closed** - Add strategy without modifying context
4. **Testable** - Test each strategy independently

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ hiển thị:
- Strategy interface (`SortStrategy`)
- Concrete strategies
- Context class (`BlogDisplay`)
- Strategy composition trong context
- Interchangeable strategies

---

## 12. TEMPLATE METHOD PATTERN

### 📋 BÀI TOÁN / PROBLEM STATEMENT

**Tiếng Việt:**
Xử lý bài viết blog có workflow chung nhưng một số bước khác nhau:
- Technical posts: Validate → Format code → SEO → Publish
- News posts: Validate → Check facts → SEO → Publish

Vấn đề:
- Nhiều code trùng lặp
- Khó maintain khi thay đổi workflow
- Muốn định nghĩa skeleton nhưng customize steps

**English:**
Processing blog posts has common workflow but some different steps:
- Technical posts: Validate → Format code → SEO → Publish
- News posts: Validate → Check facts → SEO → Publish

Problems:
- Much duplicate code
- Hard to maintain when changing workflow
- Want to define skeleton but customize steps

### 💡 GIẢI PHÁP / SOLUTION

**Template Method Pattern** định nghĩa skeleton của algorithm trong method, để subclasses override specific steps mà không thay đổi structure.

**Cấu trúc trong bluej-patterns/template_method/:**
- `PostProcessor` (abstract) - Template class
- `TechnicalPostProcessor`, `NewsPostProcessor` - Concrete classes
- `TemplateMethodDemo` - Demo chương trình

### 🔧 CÁCH GIẢI QUYẾT / IMPLEMENTATION

```java
public abstract class PostProcessor {
    // Template method
    public final void processPost(String title, String content) {
        validate(title, content);
        specificProcessing(content); // Hook - can be overridden
        applySEO(title);
        publish(title, content);
    }
    
    private void validate(String title, String content) {
        System.out.println("Validating post...");
    }
    
    protected abstract void specificProcessing(String content);
    
    private void applySEO(String title) {
        System.out.println("Applying SEO...");
    }
    
    private void publish(String title, String content) {
        System.out.println("Publishing post...");
    }
}

public class TechnicalPostProcessor extends PostProcessor {
    @Override
    protected void specificProcessing(String content) {
        System.out.println("Formatting code blocks...");
    }
}
```

### 🎯 ỨNG DỤNG THỰC TẾ / REAL-WORLD APPLICATION

- **Post processing:** Technical vs News workflow
- **Data parsing:** CSV, JSON, XML parsers
- **Testing framework:** Setup → Test → Teardown
- **HTTP request handling:** Parse → Validate → Process → Respond

### ✅ LỢI ÍCH / BENEFITS

1. **Code reuse** - Common steps trong base class
2. **Control** - Base class controls algorithm structure
3. **Flexibility** - Subclasses customize specific steps
4. **Hollywood Principle** - "Don't call us, we'll call you"

### 📊 SƠ ĐỒ UML TRONG BLUEJ / UML IN BLUEJ

BlueJ show:
- Abstract base class (`PostProcessor`)
- Template method (final)
- Abstract methods for customization
- Concrete subclasses
- Inheritance relationships
- Method call sequence

---

## 🎓 HƯỚNG DẪN SỬ DỤNG VỚI BLUEJ / BLUEJ USAGE GUIDE

### Cách Mở Project trong BlueJ:

1. **Khởi động BlueJ**
2. **Project → Open Non-BlueJ...**
3. **Chọn folder `bluej-patterns/`**
4. **Double-click vào folder pattern muốn học** (vd: `observer`, `singleton`)
5. **BlueJ tự động hiển thị sơ đồ UML**

### Xem UML Diagrams:

- **Classes:** Hiển thị dưới dạng boxes
- **Relationships:** 
  - Inheritance: Mũi tên rỗng
  - Implementation: Đường gạch ngang
  - Composition: Kim cương đen
  - Association: Đường thẳng

### Chạy Demo:

1. **Compile all classes:** Click nút "Compile"
2. **Tìm class Demo** (vd: `SingletonDemo`, `ObserverDemo`)
3. **Right-click → void main(String[] args)**
4. **Xem output trong Terminal**

### Khám Phá Code:

- **Double-click class** để xem source code
- **Right-click method** để run method đó
- **View relationships** bằng cách click các arrows

---

## 📚 TÀI LIỆU THAM KHẢO / REFERENCES

### Design Patterns Books:
1. **"Design Patterns: Elements of Reusable Object-Oriented Software"** - Gang of Four
2. **"Head First Design Patterns"** - Eric Freeman
3. **"Refactoring to Patterns"** - Joshua Kerievsky

### Online Resources:
- Refactoring.Guru - Design Patterns
- SourceMaking.com - Design Patterns
- Oracle Java Tutorials

### Project Documentation:
- `README.md` - Project overview
- `PATTERNS_REORGANIZED.md` - Structure guide
- `BLUEJ_INSTRUCTIONS.md` - BlueJ setup
- `bluej-patterns/README.md` - BlueJ patterns guide

---

## ✅ CHECKLIST HỌC TẬP / LEARNING CHECKLIST

### Creational Patterns:
- [ ] Singleton - Hiểu cách đảm bảo 1 instance duy nhất
- [ ] Factory Method - Tạo objects thông qua inheritance
- [ ] Abstract Factory - Families of related objects
- [ ] Builder - Build complex objects step by step
- [ ] Prototype - Clone objects

### Structural Patterns:
- [ ] Adapter - Convert interfaces
- [ ] Decorator - Add behaviors dynamically
- [ ] Facade - Simplify complex subsystems
- [ ] Proxy - Control access to objects

### Behavioral Patterns:
- [ ] Observer - One-to-many notifications
- [ ] Strategy - Interchangeable algorithms
- [ ] Template Method - Algorithm skeleton

### Thực Hành:
- [ ] Chạy được tất cả 12 demos trong BlueJ
- [ ] Xem và hiểu UML diagrams
- [ ] Modify code và test changes
- [ ] Tạo examples riêng cho từng pattern

---

## 🤝 ĐÓNG GÓP / CONTRIBUTING

Nếu bạn tìm thấy lỗi hoặc muốn cải thiện documentation, xin hãy:
1. Fork repository
2. Tạo branch mới
3. Commit changes
4. Push và tạo Pull Request

---

## 📞 LIÊN HỆ / CONTACT

Nếu có câu hỏi về các design patterns hoặc cần hỗ trợ:
- Xem documentation trong từng pattern folder
- Check `BLUEJ_INSTRUCTIONS.md` cho BlueJ setup
- Review `PATTERNS_REORGANIZED.md` cho project structure

---

**Chúc bạn học tốt! / Happy Learning!** 🎉

*Last Updated: 2025-11-13*
