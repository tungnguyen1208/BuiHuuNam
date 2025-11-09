# Mô Tả Bài Toán Chi Tiết Của Từng Mẫu Thiết Kế

## Giới Thiệu

Tài liệu này mô tả chi tiết bài toán thực tế mà mỗi mẫu thiết kế giải quyết trong hệ thống Website Blog. Mỗi mẫu được trình bày với:
- **Bài toán**: Vấn đề cần giải quyết
- **Giải pháp**: Cách mẫu thiết kế giải quyết vấn đề
- **Ứng dụng thực tế**: Cách áp dụng trong hệ thống blog
- **Lợi ích**: Những ưu điểm khi sử dụng mẫu này

---

## NHÓM CREATIONAL PATTERNS (Mẫu Khởi Tạo)

### 1. Singleton Pattern - Mẫu Đơn Thể

#### Bài Toán
Trong hệ thống blog, chúng ta cần quản lý cấu hình toàn cục như:
- Tên blog
- Theme giao diện (màu sắc, font chữ)
- Số bài viết hiển thị trên mỗi trang
- Ngôn ngữ mặc định
- Các thiết lập chung khác

**Vấn đề**: Nếu mỗi lần cần đọc cấu hình, chúng ta tạo một đối tượng mới, sẽ dẫn đến:
- Lãng phí bộ nhớ (nhiều đối tượng cùng chứa dữ liệu giống nhau)
- Không đồng bộ dữ liệu (thay đổi ở một nơi không ảnh hưởng nơi khác)
- Khó quản lý trạng thái toàn cục

#### Giải Pháp
Singleton đảm bảo class BlogConfiguration chỉ có duy nhất một instance trong toàn bộ ứng dụng. Mọi phần của hệ thống đều truy cập vào cùng một đối tượng cấu hình.

#### Ứng Dụng Thực Tế
```java
// Ở bất kỳ đâu trong code
BlogConfiguration config = BlogConfiguration.getInstance();
String blogName = config.getSetting("blogName");

// Thay đổi cấu hình ở một nơi
config.setSetting("theme", "dark");

// Tất cả nơi khác đều nhận được giá trị mới
BlogConfiguration config2 = BlogConfiguration.getInstance();
// config2 là cùng một đối tượng với config
```

#### Lợi Ích
- Tiết kiệm bộ nhớ
- Đảm bảo tính nhất quán của dữ liệu
- Dễ dàng truy cập từ mọi nơi trong ứng dụng

---

### 2. Factory Method Pattern - Mẫu Phương Thức Nhà Máy

#### Bài Toán
Website blog hỗ trợ nhiều loại bài viết khác nhau:
- Bài viết kỹ thuật (Technical): Có code syntax highlighting, tags về lập trình
- Bài viết lifestyle: Có hình ảnh đẹp, tags về cuộc sống
- Bài viết tin tức: Có timestamp chính xác, tags về sự kiện

**Vấn đề**: Nếu tạo trực tiếp từng loại bài viết:
```java
// Code không linh hoạt
if (type.equals("technical")) {
    BlogPost post = new BlogPost();
    post.setCategory("Technical");
    post.addTag("programming");
    // ... nhiều cấu hình khác
} else if (type.equals("lifestyle")) {
    // ... lặp lại code tương tự
}
```
- Code lặp lại nhiều
- Khó mở rộng khi thêm loại bài viết mới
- Vi phạm nguyên tắc Open/Closed (đóng với sửa đổi, mở với mở rộng)

#### Giải Pháp
Factory Method tạo ra một hệ thống phân cấp factory, mỗi factory chuyên tạo một loại bài viết cụ thể với cấu hình mặc định phù hợp.

#### Ứng Dụng Thực Tế
```java
// Tạo factory phù hợp
PostFactory factory = new TechnicalPostFactory();
BlogPost techPost = factory.publishPost("Java Patterns", "Content...", "Author");
// Bài viết tự động có category="Technical", tags=["programming"]

// Muốn thêm loại bài viết mới? Chỉ cần tạo factory mới
class NewsPostFactory extends PostFactory {
    // Implement logic riêng
}
```

#### Lợi Ích
- Dễ dàng thêm loại bài viết mới mà không sửa code cũ
- Mỗi factory chứa logic riêng cho từng loại bài viết
- Code sạch hơn, dễ bảo trì

---

### 3. Abstract Factory Pattern - Mẫu Nhà Máy Trừu Tượng

#### Bài Toán
Website blog cung cấp nhiều theme giao diện:
- Theme Modern: Button phẳng, header tối giản, footer có social media
- Theme Classic: Button có viền, header truyền thống, footer đơn giản

**Vấn đề**: Khi chọn một theme, cần đảm bảo:
- TẤT CẢ component (button, header, footer) đều thuộc cùng một theme
- Không được trộn lẫn component của các theme khác nhau
- Dễ dàng thêm theme mới mà không ảnh hưởng theme cũ

Nếu tạo từng component riêng lẻ:
```java
Button btn = new ModernButton();
Header header = new ClassicHeader(); // Lỗi! Không nhất quán
```

#### Giải Pháp
Abstract Factory cung cấp một factory tạo ra CẢ NHÓM component cùng theme, đảm bảo tính nhất quán về giao diện.

#### Ứng Dụng Thực Tế
```java
// Chọn theme
UIComponentFactory factory = new ModernUIFactory();

// Tạo tất cả component từ cùng một factory
Button button = factory.createButton();
Header header = factory.createHeader();
Footer footer = factory.createFooter();
// Đảm bảo tất cả đều theo Modern theme

// Đổi theme? Chỉ cần đổi factory
factory = new ClassicUIFactory();
// Tất cả component tự động theo Classic theme
```

#### Lợi Ích
- Đảm bảo tính nhất quán của các component cùng nhóm
- Dễ dàng chuyển đổi giữa các theme
- Thêm theme mới không ảnh hưởng code cũ

---

### 4. Builder Pattern - Mẫu Người Xây Dựng

#### Bài Toán
Một bài viết blog có rất nhiều thuộc tính:
- Bắt buộc: title, content, author
- Tùy chọn: tags, category, publishDate, featured, comments enabled, etc.

**Vấn đề**: Tạo bài viết với nhiều tham số:
```java
// Constructor quá dài, khó đọc
BlogPost post = new BlogPost(
    "id123", 
    "Title", 
    "Content", 
    "Author",
    LocalDateTime.now(),
    Arrays.asList("tag1", "tag2"),
    "Category",
    true,  // featured?
    false, // comments?
    100,   // views?
    // ... thêm nhiều tham số nữa
);
// Khó nhớ thứ tự tham số, dễ nhầm lẫn
```

#### Giải Pháp
Builder cho phép xây dựng đối tượng từng bước, với cú pháp rõ ràng, dễ đọc.

#### Ứng Dụng Thực Tế
```java
// Rõ ràng, dễ đọc, linh hoạt
BlogPost post = new BlogPostBuilder()
    .setTitle("Complete Java Guide")
    .setAuthor("John Doe")
    .setContent("This is a comprehensive guide...")
    .setCategory("Tutorial")
    .addTag("java")
    .addTag("programming")
    .addTag("beginner")
    .build();

// Chỉ set những thuộc tính cần thiết
BlogPost simplePost = new BlogPostBuilder()
    .setTitle("Quick Note")
    .setContent("Short content")
    .setAuthor("Jane")
    .build();
```

#### Lợi Ích
- Code dễ đọc, tự mô tả
- Linh hoạt: chỉ set những thuộc tính cần thiết
- Tránh constructor với quá nhiều tham số
- Dễ dàng thêm thuộc tính mới

---

### 5. Prototype Pattern - Mẫu Nguyên Mẫu

#### Bài Toán
Quản trị viên blog thường xuyên tạo các bài viết có format tương tự:
- Bài viết kỹ thuật: Luôn có category="Technical", tags cố định ["programming", "tutorial"]
- Bài viết tin tức: Luôn có category="News", tags cố định ["updates", "announcements"]

**Vấn đề**: Mỗi lần tạo bài viết mới, phải:
1. Tạo đối tượng mới từ đầu
2. Set lại các thuộc tính giống nhau (category, tags mặc định)
3. Tốn thời gian và dễ quên setup

```java
// Lặp lại nhiều lần
BlogPost post1 = new BlogPost();
post1.setCategory("Technical");
post1.addTag("programming");
post1.addTag("tutorial");
// Thay đổi title, content, author...

BlogPost post2 = new BlogPost();
post2.setCategory("Technical");
post2.addTag("programming");
post2.addTag("tutorial");
// Lại lặp lại...
```

#### Giải Pháp
Prototype lưu trữ các template bài viết mẫu, khi cần tạo bài mới chỉ việc CLONE template và chỉnh sửa những phần khác biệt.

#### Ứng Dụng Thực Tế
```java
// Khởi tạo registry với các template
PostPrototypeRegistry registry = new PostPrototypeRegistry();

// Tạo bài viết từ template, chỉ cần điền nội dung riêng
BlogPost post1 = registry.createPost(
    "technical",  // Clone từ technical template
    "Java 17 Features",
    "New features in Java 17...",
    "Developer A"
);
// Tự động có category="Technical", tags=["programming", "tutorial"]

BlogPost post2 = registry.createPost(
    "news",
    "Conference Announcement",
    "Annual tech conference...",
    "Editor B"
);
// Tự động có category="News", tags=["updates", "announcements"]
```

#### Lợi Ích
- Tạo đối tượng nhanh hơn từ template có sẵn
- Đảm bảo tính nhất quán (các bài cùng loại có cấu trúc giống nhau)
- Dễ dàng thêm template mới
- Tiết kiệm thời gian setup

---

## NHÓM STRUCTURAL PATTERNS (Mẫu Cấu Trúc)

### 6. Adapter Pattern - Mẫu Bộ Chuyển Đổi

#### Bài Toán
Hệ thống blog mới sử dụng interface ContentRenderer để render nội dung:
```java
interface ContentRenderer {
    String render(String content);
}
```

Nhưng công ty đã có sẵn thư viện MarkdownParser cũ:
```java
class MarkdownParser {
    String parseMarkdown(String markdown) {...}
}
```

**Vấn đề**: 
- Interface không tương thích (render vs parseMarkdown)
- Không thể sửa code của thư viện cũ (vì không có quyền hoặc được nhiều hệ thống khác dùng)
- Muốn tái sử dụng code cũ mà không viết lại

#### Giải Pháp
Adapter đóng vai trò "cầu nối" chuyển đổi interface của MarkdownParser để tương thích với ContentRenderer.

#### Ứng Dụng Thực Tế
```java
// Adapter kết nối hai interface không tương thích
ContentRenderer adapter = new MarkdownAdapter();

// Sử dụng qua interface mới
String html = adapter.render("# Heading\n**Bold text**");
// Bên trong adapter gọi MarkdownParser.parseMarkdown()

// Code mới hoàn toàn không biết đến MarkdownParser
// Chỉ làm việc với ContentRenderer interface
```

#### Lợi Ích
- Tái sử dụng code cũ mà không cần sửa đổi
- Tích hợp dễ dàng thư viện bên thứ ba
- Giữ code mới độc lập với code cũ
- Dễ dàng thay thế implementation

---

### 7. Decorator Pattern - Mẫu Trang Trí

#### Bài Toán
Một bài viết blog cơ bản chỉ có title, author, content. Nhưng tùy theo loại bài viết, cần thêm tính năng:
- Một số bài có comments
- Một số bài có likes
- Một số bài có cả comments VÀ likes
- Một số bài có reactions (love, haha, wow)

**Vấn đề**: Nếu tạo class cho mỗi tổ hợp:
```java
class BlogPostWithComments {...}
class BlogPostWithLikes {...}
class BlogPostWithCommentsAndLikes {...}
class BlogPostWithCommentsLikesReactions {...}
// Số lượng class tăng theo cấp số nhân!
```

Hoặc thêm tất cả vào một class:
```java
class BlogPost {
    List<Comment> comments; // Lãng phí nếu không dùng
    int likes;              // Lãng phí nếu không dùng
    List<Reaction> reactions; // Lãng phí nếu không dùng
    // Class trở nên quá phức tạp
}
```

#### Giải Pháp
Decorator cho phép thêm tính năng ĐỘNG vào đối tượng bằng cách "bọc" đối tượng gốc trong các lớp decorator.

#### Ứng Dụng Thực Tế
```java
// Bài viết cơ bản
BlogPostComponent post = new BasicBlogPost(blogPost);

// Thêm comments
post = new CommentDecorator(post, 15);

// Thêm likes
post = new LikeDecorator(post, 42);

// Display hiển thị tất cả: nội dung + comments + likes
post.display();
// Output:
// Title: ...
// Author: ...
// Content: ...
// Comments: 15 comments
// Likes: 42 likes

// Tạo bài viết khác chỉ có comments, không có likes
BlogPostComponent post2 = new CommentDecorator(new BasicBlogPost(post2), 5);
```

#### Lợi Ích
- Thêm tính năng linh hoạt, không cần sửa class gốc
- Tránh class explosion (nhiều class con)
- Có thể kết hợp nhiều decorator theo bất kỳ cách nào
- Tuân thủ Open/Closed Principle

---

### 8. Facade Pattern - Mẫu Mặt Tiền

#### Bài Toán
Để xuất bản một bài viết blog, cần thực hiện nhiều bước phức tạp:
1. Validate bài viết (kiểm tra title, content không rỗng)
2. Save vào database
3. Index cho search engine (Elasticsearch)
4. Gửi notification cho subscribers
5. Cache lại để tăng tốc độ truy cập
6. Update sitemap
7. Trigger webhook
8. Log activity

**Vấn đề**: Client phải biết và gọi tất cả các hệ thống con:
```java
// Code phức tạp, khó maintain
PostValidator validator = new PostValidator();
if (validator.validate(post)) {
    PostStorage storage = new PostStorage();
    storage.save(post);
    
    SearchIndexer indexer = new SearchIndexer();
    indexer.index(post);
    
    NotificationService notifier = new NotificationService();
    notifier.notifySubscribers(post);
    
    CacheManager cache = new CacheManager();
    cache.updateCache(post);
    
    SitemapGenerator sitemap = new SitemapGenerator();
    sitemap.update();
    
    WebhookService webhook = new WebhookService();
    webhook.trigger("post_published", post);
    
    ActivityLogger logger = new ActivityLogger();
    logger.log("Published", post.getId());
}
// Quá nhiều code, dễ quên bước, khó test
```

#### Giải Pháp
Facade cung cấp một interface đơn giản che giấu sự phức tạp của nhiều hệ thống con.

#### Ứng Dụng Thực Tế
```java
// Đơn giản, dễ sử dụng
BlogManagementFacade facade = new BlogManagementFacade();
facade.publishPost(post);

// Bên trong facade tự động thực hiện tất cả các bước:
// validate -> save -> index -> notify -> cache -> sitemap -> webhook -> log
```

#### Lợi Ích
- Code client đơn giản, dễ đọc
- Giảm sự phụ thuộc vào các hệ thống con
- Dễ dàng thay đổi logic bên trong mà không ảnh hưởng client
- Tập trung logic phức tạp vào một nơi

---

### 9. Proxy Pattern - Mẫu Đại Diện

#### Bài Toán
Blog có hàng nghìn bài viết, mỗi bài viết có nội dung dài. Trong trang danh sách bài viết:
- Hiển thị title, author, date
- KHÔNG cần hiển thị nội dung đầy đủ
- Nội dung chỉ cần load khi user click vào đọc chi tiết

**Vấn đề**: Nếu load tất cả nội dung ngay từ đầu:
```java
List<BlogPost> posts = database.getAllPosts();
// Load cả nội dung của 1000 bài viết
// Tốn 50MB RAM, 5 giây query
// Nhưng user chỉ xem danh sách, không đọc nội dung!

// Hiển thị danh sách
for (BlogPost post : posts) {
    displaySummary(post.getTitle(), post.getAuthor());
    // Không dùng post.getContent() => lãng phí
}
```

#### Giải Pháp
Proxy đại diện cho đối tượng thực, chỉ load dữ liệu nặng (nội dung) khi thực sự cần thiết.

#### Ứng Dụng Thực Tế
```java
// Tạo proxy, chưa load nội dung
PostContent content = new PostContentProxy("post-123");

System.out.println("Post created, content not loaded yet");

// Lần đầu tiên gọi getContent() => load từ database
String text1 = content.getContent();
// Output: [Proxy] Loading content from database... (1 second delay)

// Lần thứ hai gọi getContent() => dùng cache, không load lại
String text2 = content.getContent();
// Output: [Proxy] Content already cached, return immediately
```

#### Lợi Ích
- Tiết kiệm bộ nhớ (chỉ load khi cần)
- Tăng tốc độ (lazy loading)
- Có thể thêm logic khác: access control, logging, caching
- Transparent (client không biết là đang dùng proxy hay real object)

---

## NHÓM BEHAVIORAL PATTERNS (Mẫu Hành Vi)

### 10. Observer Pattern - Mẫu Quan Sát

#### Bài Toán
Khi admin xuất bản bài viết mới, cần thông báo cho:
- Subscribers qua email
- Subscribers qua SMS
- Subscribers qua push notification
- Subscribers qua Telegram bot
- RSS feed reader
- Search engine crawler

**Vấn đề**: Nếu hard-code logic thông báo trong BlogPublisher:
```java
class BlogPublisher {
    void publishPost(BlogPost post) {
        // Save post
        
        // Hard-coded notification logic
        EmailService.sendEmail(subscriberEmails, post);
        SMSService.sendSMS(subscriberPhones, post);
        PushService.send(deviceTokens, post);
        TelegramBot.notify(chatIds, post);
        RSSFeed.update(post);
        GoogleBot.notify(post);
        
        // Muốn thêm Discord notification?
        // => Phải sửa code BlogPublisher!
    }
}
```

Vấn đề:
- Vi phạm Open/Closed Principle
- BlogPublisher biết quá nhiều về các service khác
- Khó test
- Thêm/bớt notification channel phải sửa code

#### Giải Pháp
Observer tạo mối quan hệ loosely coupled giữa publisher (subject) và subscribers (observers). Publisher không cần biết chi tiết về subscribers, chỉ cần notify.

#### Ứng Dụng Thực Tế
```java
// Setup: Đăng ký các observers
BlogPublisher publisher = new BlogPublisher();
publisher.subscribe(new EmailSubscriber("user1@example.com"));
publisher.subscribe(new EmailSubscriber("user2@example.com"));
publisher.subscribe(new SMSSubscriber("+1234567890"));
publisher.subscribe(new TelegramSubscriber("@user123"));

// Publish: Tất cả observers tự động nhận thông báo
publisher.publishPost(newPost);

// Output:
// [Email to user1@example.com] New post: 'Title' by Author
// [Email to user2@example.com] New post: 'Title' by Author
// [SMS to +1234567890] New post: 'Title' by Author
// [Telegram to @user123] New post: 'Title' by Author

// Thêm Discord? Không cần sửa BlogPublisher
publisher.subscribe(new DiscordSubscriber("webhook-url"));
```

#### Lợi Ích
- Loose coupling (publisher không biết chi tiết về observers)
- Dễ dàng thêm/bớt observers
- Publisher và Observers có thể thay đổi độc lập
- Follows Open/Closed Principle

---

### 11. Strategy Pattern - Mẫu Chiến Lược

#### Bài Toán
Blog cần render nội dung ra nhiều format khác nhau:
- Web browser: Render ra HTML
- Mobile app: Render ra JSON
- RSS reader: Render ra Plain Text
- Email: Render ra HTML đơn giản (không dùng CSS phức tạp)
- API export: Render ra Markdown

**Vấn đề**: Nếu dùng if-else:
```java
class ContentRenderer {
    String render(String content, String format) {
        if (format.equals("html")) {
            return "<html><body>" + content + "</body></html>";
        } else if (format.equals("json")) {
            return "{\"content\": \"" + content + "\"}";
        } else if (format.equals("text")) {
            return content;
        } else if (format.equals("markdown")) {
            // ...
        }
        // Thêm format mới => phải sửa method này
        // Vi phạm Open/Closed Principle
    }
}
```

#### Giải Pháp
Strategy đóng gói mỗi thuật toán (cách render) vào một class riêng, có thể thay đổi thuật toán tại runtime.

#### Ứng Dụng Thực Tế
```java
ContentRenderer renderer = new ContentRenderer();
String content = "Hello World";

// Render as HTML
renderer.setStrategy(new HTMLRenderingStrategy());
String html = renderer.renderContent(content);
// Output: <html><body><p>Hello World</p></body></html>

// Đổi strategy sang JSON
renderer.setStrategy(new JSONRenderingStrategy());
String json = renderer.renderContent(content);
// Output: {"content": "Hello World"}

// Đổi strategy sang Plain Text
renderer.setStrategy(new PlainTextStrategy());
String text = renderer.renderContent(content);
// Output: Hello World

// Thêm Markdown strategy? Tạo class mới, không sửa code cũ
renderer.setStrategy(new MarkdownRenderingStrategy());
```

#### Lợi Ích
- Dễ dàng thêm thuật toán mới
- Có thể thay đổi thuật toán tại runtime
- Code sạch hơn, tránh if-else dài
- Mỗi strategy độc lập, dễ test

---

### 12. Template Method Pattern - Mẫu Phương Thức Mẫu

#### Bài Toán
Quy trình xuất bản bài viết có các bước chung:
1. Validate bài viết
2. Format nội dung (khác nhau theo loại bài)
3. Save vào database
4. Notify users (khác nhau theo loại bài)
5. (Optional) Add to featured section

Nhưng một số bước khác nhau:
- **Technical post**: Format với code highlighting, notify developer subscribers
- **News post**: Format với breaking news style, notify ALL users (push notification)
- **Tutorial post**: Format với step-by-step layout, add to featured section

**Vấn đề**: Nếu mỗi loại bài viết tự implement toàn bộ quy trình:
```java
class TechnicalPostPublisher {
    void publish(BlogPost post) {
        validate(post);            // Giống nhau
        formatWithCodeHighlight(); // Khác
        save(post);                // Giống nhau
        notifyDevelopers();        // Khác
    }
}

class NewsPostPublisher {
    void publish(BlogPost post) {
        validate(post);            // Lặp code
        formatBreakingNews();      // Khác
        save(post);                // Lặp code
        notifyAllUsers();          // Khác
    }
}
// Code lặp lại nhiều, khó maintain
```

#### Giải Pháp
Template Method định nghĩa KHUNG (skeleton) của thuật toán trong base class, các subclass override những bước cụ thể.

#### Ứng Dụng Thực Tế
```java
// Template Method trong base class
abstract class PostPublishingTemplate {
    // TEMPLATE METHOD - định nghĩa khung thuật toán
    final void publishPost(BlogPost post) {
        validatePost(post);      // Bước chung (concrete)
        formatContent(post);     // Bước khác nhau (abstract)
        saveToDatabase(post);    // Bước chung (concrete)
        notifyUsers(post);       // Bước khác nhau (abstract)
        
        if (shouldAddToFeatured(post)) {  // Hook method
            addToFeaturedSection(post);
        }
    }
    
    // Concrete methods - giống nhau cho tất cả
    private void validatePost(BlogPost post) {...}
    private void saveToDatabase(BlogPost post) {...}
    
    // Abstract methods - subclass phải implement
    protected abstract void formatContent(BlogPost post);
    protected abstract void notifyUsers(BlogPost post);
    
    // Hook method - subclass có thể override
    protected boolean shouldAddToFeatured(BlogPost post) {
        return false;
    }
}

// Subclass chỉ implement bước khác biệt
class TechnicalPostPublisher extends PostPublishingTemplate {
    protected void formatContent(BlogPost post) {
        // Code syntax highlighting
    }
    
    protected void notifyUsers(BlogPost post) {
        // Notify developer subscribers
    }
}

class NewsPostPublisher extends PostPublishingTemplate {
    protected void formatContent(BlogPost post) {
        // Breaking news style
    }
    
    protected void notifyUsers(BlogPost post) {
        // Push notification to ALL users
    }
}

// Sử dụng
PostPublishingTemplate publisher = new TechnicalPostPublisher();
publisher.publishPost(techPost);
// Tự động thực hiện: validate -> format (tech) -> save -> notify (devs)
```

#### Lợi Ích
- Tránh code lặp lại (các bước chung viết một lần)
- Đảm bảo quy trình đúng thứ tự
- Subclass chỉ lo phần khác biệt
- Dễ dàng thêm loại bài viết mới

---

## Tổng Kết

### So Sánh Các Mẫu

| Mẫu | Khi Nào Dùng | Lợi Ích Chính |
|-----|--------------|---------------|
| **Singleton** | Cần duy nhất một instance toàn cục | Tiết kiệm bộ nhớ, đảm bảo tính nhất quán |
| **Factory Method** | Tạo nhiều loại đối tượng tương tự | Dễ mở rộng, code sạch |
| **Abstract Factory** | Tạo nhóm đối tượng liên quan | Đảm bảo tính nhất quán nhóm |
| **Builder** | Đối tượng có nhiều tham số tùy chọn | Code dễ đọc, linh hoạt |
| **Prototype** | Tạo đối tượng từ template | Nhanh hơn, tiết kiệm setup |
| **Adapter** | Tích hợp code cũ/thư viện bên thứ ba | Tái sử dụng code, không cần sửa |
| **Decorator** | Thêm tính năng động | Linh hoạt, tránh class explosion |
| **Facade** | Đơn giản hóa hệ thống phức tạp | Code client đơn giản |
| **Proxy** | Lazy loading, access control | Tiết kiệm tài nguyên |
| **Observer** | Thông báo nhiều đối tượng khi có sự kiện | Loose coupling, dễ mở rộng |
| **Strategy** | Nhiều cách thực hiện cùng một task | Linh hoạt, tránh if-else |
| **Template Method** | Quy trình có bước chung và bước khác | Tránh code lặp, đảm bảo quy trình |

### Kết Hợp Các Mẫu

Trong thực tế, các mẫu thường được kết hợp:

```java
// 1. Lấy config (Singleton)
BlogConfiguration config = BlogConfiguration.getInstance();

// 2. Tạo bài viết (Builder + Factory)
BlogPost post = new BlogPostBuilder()
    .setTitle("New Post")
    .build();

// 3. Thêm features (Decorator)
BlogPostComponent enhanced = new LikeDecorator(
    new CommentDecorator(new BasicBlogPost(post), 10),
    50
);

// 4. Render content (Strategy + Adapter)
ContentRenderer renderer = new ContentRenderer();
renderer.setStrategy(new HTMLRenderingStrategy());
String html = renderer.renderContent(post.getContent());

// 5. Publish (Facade + Template Method + Observer)
BlogManagementFacade facade = new BlogManagementFacade();
facade.publishPost(post);  // Tự động notify subscribers

// 6. Load chi tiết khi cần (Proxy)
PostContent content = new PostContentProxy(post.getId());
String fullContent = content.getContent();  // Lazy load
```

---

## Tài Liệu Tham Khảo

- Gang of Four (GoF) Design Patterns
- Head First Design Patterns
- Refactoring Guru - Design Patterns
- Clean Code by Robert C. Martin
- Effective Java by Joshua Bloch
