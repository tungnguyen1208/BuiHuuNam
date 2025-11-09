# Hệ Thống Blog – Minh họa 12 Mẫu Thiết Kế (Design Patterns) bằng Java

> Toàn bộ tài liệu đã được chuyển sang tiếng Việt. Dự án minh họa cách áp dụng 12 mẫu thiết kế kinh điển (GoF) trong ngữ cảnh xây dựng hệ thống blog: tạo bài viết, hiển thị, tương tác người dùng, quản lý bình luận, thông báo.

## 📋 Tổng quan

Mục tiêu của dự án:
- Cung cấp ví dụ rõ ràng, dễ đọc cho từng mẫu thiết kế.
- Cho thấy cách các mẫu kết hợp với nhau tạo thành một kiến trúc linh hoạt.
- Làm nền tảng học tập và tham khảo khi thiết kế hệ thống thực tế.

Các tài liệu liên quan:
- `PATTERNS_SUMMARY.md` – Tóm tắt ngắn gọn từng mẫu.
- `PATTERNS_DIAGRAM.md` – Sơ đồ và mối quan hệ giữa các mẫu.
- `DESIGN_PATTERNS_PROBLEMS.md` – Mô tả ngắn gọn bài toán mỗi mẫu.
- `BAI_TOAN_CHI_TIET.md` – Phân tích chi tiết bài toán & giải pháp (mới).

## 🏗️ Danh sách 12 Mẫu Thiết Kế

### Nhóm Khởi Tạo (Creational) – 5 mẫu
1. **Singleton** – `BlogConfiguration`: Một cấu hình dùng chung duy nhất.
2. **Factory Method** – `BlogPostFactory` (+ các factory triển khai): Tạo các loại bài viết chuyên biệt.
3. **Abstract Factory** – `UIComponentFactory`: Tạo “họ” các thành phần UI thống nhất theo chủ đề (dark/light).
4. **Builder** – `BlogPostBuilder`: Xây dựng bài viết phức tạp theo từng bước linh hoạt.
5. **Prototype** – `BlogPostPrototype`: Nhân bản bài viết từ các mẫu chuẩn.

### Nhóm Cấu Trúc (Structural) – 6 mẫu
6. **Adapter** – `LegacyBlogAdapter`: Tích hợp hệ thống blog cũ khác giao diện.
7. **Bridge** – `BlogRenderer`: Tách trừu tượng hiển thị khỏi nền tảng (HTML/Markdown/Text).
8. **Composite** – `CommentComponent`: Mô hình hóa cây bình luận lồng nhau.
9. **Decorator** – `BlogPostDecorator`: Thêm tính năng động quanh nội dung (SEO, chia sẻ, quảng cáo...).
10. **Facade** – `BlogManagementFacade`: Cửa giao tiếp đơn giản với nhiều phân hệ phức tạp.
11. **Proxy** – `BlogPostProxy`: Kiểm soát truy cập (cache, phân quyền, logging) tới bài viết.

### Nhóm Hành Vi (Behavioral) – 1 mẫu
12. **Observer** – `BlogSubscriber` / `BlogSubscriberFacade`: Cơ chế đăng ký nhận thông báo khi có bài mới.

## 📁 Cấu trúc thư mục

```
src/main/java/com/blog/
├── model/
│   ├── BlogPost.java          # Mô hình bài viết
│   ├── Comment.java           # Mô hình bình luận
│   └── User.java              # Mô hình người dùng
├── designpatterns/
│   ├── creational/
│   │   ├── BlogConfiguration.java          # Singleton
│   │   ├── BlogPostFactory.java            # Factory Method (abstract)
│   │   ├── BlogPostFactoryProvider.java    # Các factory cụ thể
│   │   ├── UIComponentFactory.java         # Abstract Factory
│   │   ├── UIComponentFactoryProvider.java # Helper
│   │   ├── BlogPostBuilder.java            # Builder
│   │   └── BlogPostPrototype.java          # Prototype
│   ├── structural/
│   │   ├── LegacyBlogAdapter.java          # Adapter
│   │   ├── LegacyBlogAdapterFactory.java   # Helper Adapter
│   │   ├── BlogRenderer.java               # Bridge
│   │   ├── BlogRendererFactory.java        # Helper Bridge
│   │   ├── CommentComponent.java           # Composite
│   │   ├── CommentFactory.java             # (nếu mở rộng) tạo comment
│   │   ├── BlogPostDecorator.java          # Decorator + triển khai
│   │   ├── BlogPostDecoratorFactory.java   # Helper Decorator
│   │   ├── BlogManagementFacade.java       # Facade
│   │   ├── BlogPostProxy.java              # Proxy + triển khai
│   │   └── BlogPostProxyFactory.java       # Helper Proxy
│   └── behavioral/
│       ├── BlogSubscriber.java             # Observer (Subject + Observers)
│       └── BlogSubscriberFacade.java       # Helper đăng ký thuận tiện
└── BlogDesignPatternsDemo.java             # Lớp demo chạy thử
```

## 🚀 Hướng dẫn biên dịch & chạy

### Yêu cầu
- JDK 11 trở lên.

### Biên dịch (Windows CMD)
```cmd
mkdir bin
javac -d bin src\main\java\com\blog\model\*.java ^
  src\main\java\com\blog\designpatterns\creational\*.java ^
  src\main\java\com\blog\designpatterns\structural\*.java ^
  src\main\java\com\blog\designpatterns\behavioral\*.java ^
  src\main\java\com\blog\*.java
```

### Chạy demo
```cmd
java -cp bin com.blog.BlogDesignPatternsDemo
```

## 🔍 Ví dụ ngắn cho từng mẫu

**Singleton**
```java
BlogConfiguration cfg = BlogConfiguration.getInstance();
System.out.println(cfg.getBlogName());
```

**Factory Method**
```java
BlogPostFactory factory = BlogPostFactoryProvider.getTechnicalFactory();
BlogPost post = factory.createAndPublish("Giới thiệu Java", "Nội dung...", "Nam");
```

**Abstract Factory**
```java
UIComponentFactory dark = UIComponentFactoryProvider.getDarkThemeFactory();
dark.createButton().render();
```

**Builder**
```java
BlogPost post = BlogPostBuilder.builder()
    .withTitle("Thiết kế sạch")
    .withContent("Nguyên tắc SOLID...")
    .withAuthor("Hữu Nam")
    .addTag("SOLID")
    .addTag("Design")
    .build();
```

**Prototype**
```java
BlogPostPrototype proto = new BlogPostPrototype();
BlogPost tut = proto.createPost("tutorial");
tut.setAuthor("Tác giả A");
```

**Adapter**
```java
LegacyBlogAdapter adapter = LegacyBlogAdapterFactory.createAdapter();
adapter.savePost(post);
```

**Bridge**
```java
BlogRenderer renderer = BlogRendererFactory.createDetailedMarkdownRenderer();
renderer.render(post);
```

**Composite**
```java
CommentComponent root = new CommentThread("1", "Alice", "Bài viết hay!");
root.add(new SingleComment("2", "Bob", "Đồng ý!"));
root.display(0);
```

**Decorator**
```java
BlogPostDecorator seo = BlogPostDecoratorFactory.withSEO(post, "Mô tả", "java,design");
BlogPostDecorator share = BlogPostDecoratorFactory.withSocialMedia(post);
```

**Facade**
```java
BlogManagementFacade facade = new BlogManagementFacade();
facade.publishBlogPost(post, new User());
```

**Proxy**
```java
BlogPostProxyFactory.demonstrateCachingProxy("123");
```

**Observer**
```java
BlogSubscriberFacade subs = new BlogSubscriberFacade();
subs.subscribeEmail("Nam", "nam@example.com");
subs.publishPost(post);
```

## 🎯 Điểm nổi bật
- Minh họa đầy đủ 12 mẫu kinh điển.
- Ngữ cảnh thực tế: hệ thống blog.
- Mã rõ ràng, dễ đọc, tách lớp hợp lý.
- Dễ mở rộng để bổ sung persistence, validation, bảo mật.

## 🧪 Kiểm thử nhanh
Chạy lớp `BlogDesignPatternsDemo` để xem chuỗi minh họa tổng hợp:
```cmd
java -cp bin com.blog.BlogDesignPatternsDemo
```

## 📚 Học được gì?
1. Nhận biết bài toán phù hợp cho từng mẫu.
2. Cách ghép nhiều mẫu để tránh trùng lặp logic.
3. Thiết kế linh hoạt: thay đổi phần hiển thị không ảnh hưởng phần tạo dữ liệu.
4. Phân tách trách nhiệm và giảm phụ thuộc.

## 🤝 Đóng góp
Bạn có thể fork, thêm ví dụ, bổ sung unit test, mở rộng thêm mẫu khác (Strategy, Command, State...).

## 📝 Giấy phép
Dự án phục vụ mục đích học tập – bạn có thể sử dụng và chỉnh sửa tự do.

## 👨‍💻 Tác giả
Thực hiện nhằm minh họa rõ ràng các Design Patterns trong Java cho hệ thống blog.

## 🔗 Tài liệu tham khảo
- *Design Patterns* (Gang of Four)
- Refactoring Guru – https://refactoring.guru/design-patterns
- Java Design Patterns – https://java-design-patterns.com/

## 🔁 Liên kết chéo
- `DESIGN_PATTERNS_PROBLEMS.md`
- `PATTERNS_SUMMARY.md`
- `PATTERNS_DIAGRAM.md`
- `BAI_TOAN_CHI_TIET.md`

---
*Ghi chú:* Mã ví dụ tập trung vào minh họa mẫu – môi trường sản xuất cần thêm xử lý lỗi, tối ưu hiệu năng, bảo mật và lưu trữ dữ liệu.
