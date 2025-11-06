# Design Patterns Summary

## Vietnamese / Tiếng Việt

### Các Mẫu Thiết Kế Đã Được Triển Khai

Dự án này triển khai 12 mẫu thiết kế (Design Patterns) trong Java cho một ứng dụng Website Blog. Dưới đây là mô tả chi tiết về từng mẫu:

#### Nhóm Creational Patterns (Mẫu Khởi Tạo) - 5 mẫu

1. **Singleton Pattern** - Mẫu Đơn Thể
   - **Mục đích**: Đảm bảo một class chỉ có duy nhất một instance
   - **Ứng dụng**: BlogConfiguration - Quản lý cấu hình toàn cục của blog
   - **File**: `BlogConfiguration.java`

2. **Factory Method Pattern** - Mẫu Phương Thức Nhà Máy
   - **Mục đích**: Định nghĩa interface để tạo đối tượng, cho phép subclass quyết định class nào được khởi tạo
   - **Ứng dụng**: PostFactory - Tạo các loại bài viết khác nhau (Technical, Lifestyle)
   - **File**: `PostFactory.java`, `TechnicalPostFactory.java`, `LifestylePostFactory.java`

3. **Abstract Factory Pattern** - Mẫu Nhà Máy Trừu Tượng
   - **Mục đích**: Cung cấp interface để tạo các họ đối tượng có liên quan
   - **Ứng dụng**: UIComponentFactory - Tạo các thành phần giao diện theo theme (Modern, Classic)
   - **File**: `UIComponentFactory.java`, `ModernUIFactory.java`, `ClassicUIFactory.java`

4. **Builder Pattern** - Mẫu Người Xây Dựng
   - **Mục đích**: Xây dựng đối tượng phức tạp từng bước
   - **Ứng dụng**: BlogPostBuilder - Xây dựng bài viết blog với nhiều thuộc tính
   - **File**: `BlogPostBuilder.java`

5. **Prototype Pattern** - Mẫu Nguyên Mẫu
   - **Mục đích**: Tạo đối tượng mới bằng cách sao chép từ prototype
   - **Ứng dụng**: PostPrototypeRegistry - Sao chép bài viết từ template
   - **File**: `PostPrototypeRegistry.java`

#### Nhóm Structural Patterns (Mẫu Cấu Trúc) - 4 mẫu

6. **Adapter Pattern** - Mẫu Bộ Chuyển Đổi
   - **Mục đích**: Chuyển đổi interface của class sang interface khác
   - **Ứng dụng**: MarkdownAdapter - Chuyển đổi Markdown sang HTML
   - **File**: `MarkdownAdapter.java`, `MarkdownParser.java`

7. **Decorator Pattern** - Mẫu Trang Trí
   - **Mục đích**: Thêm chức năng mới cho đối tượng một cách linh hoạt
   - **Ứng dụng**: PostDecorator - Thêm comment và like cho bài viết
   - **File**: `PostDecorator.java`, `CommentDecorator.java`, `LikeDecorator.java`

8. **Facade Pattern** - Mẫu Mặt Tiền
   - **Mục đích**: Cung cấp interface đơn giản cho hệ thống phức tạp
   - **Ứng dụng**: BlogManagementFacade - Đơn giản hóa quy trình xuất bản bài viết
   - **File**: `BlogManagementFacade.java`

9. **Proxy Pattern** - Mẫu Đại Diện
   - **Mục đích**: Cung cấp đại diện cho đối tượng khác để kiểm soát truy cập
   - **Ứng dụng**: PostContentProxy - Lazy loading nội dung bài viết
   - **File**: `PostContentProxy.java`, `RealPostContent.java`

#### Nhóm Behavioral Patterns (Mẫu Hành Vi) - 3 mẫu

10. **Observer Pattern** - Mẫu Quan Sát
    - **Mục đích**: Định nghĩa mối quan hệ 1-nhiều giữa các đối tượng
    - **Ứng dụng**: BlogPublisher - Thông báo cho subscribers khi có bài viết mới
    - **File**: `BlogPublisher.java`, `EmailSubscriber.java`, `SMSSubscriber.java`

11. **Strategy Pattern** - Mẫu Chiến Lược
    - **Mục đích**: Định nghĩa họ các thuật toán có thể thay đổi được
    - **Ứng dụng**: RenderingStrategy - Các chiến lược render nội dung (Plain Text, HTML, JSON)
    - **File**: `RenderingStrategy.java`, `PlainTextStrategy.java`, `HTMLRenderingStrategy.java`, `JSONRenderingStrategy.java`

12. **Template Method Pattern** - Mẫu Phương Thức Mẫu
    - **Mục đích**: Định nghĩa khung thuật toán, cho phép subclass override các bước
    - **Ứng dụng**: PostPublishingTemplate - Quy trình xuất bản bài viết
    - **File**: `PostPublishingTemplate.java`, `TechnicalPostPublisher.java`, `NewsPostPublisher.java`

### Cách Chạy Demo

```bash
# Biên dịch dự án
mvn clean compile

# Chạy demo
mvn exec:java -Dexec.mainClass="com.blog.patterns.DesignPatternsDemo"
```

### Cấu Trúc Thư Mục

```
src/main/java/com/blog/patterns/
├── creational/        # 5 mẫu khởi tạo
├── structural/        # 4 mẫu cấu trúc  
├── behavioral/        # 3 mẫu hành vi
├── models/            # Các class model
└── DesignPatternsDemo.java  # Class demo
```

---

## English

### Implemented Design Patterns

This project implements 12 Design Patterns in Java for a Blog Website application. Below is a detailed description of each pattern:

#### Creational Patterns Group - 5 patterns

1. **Singleton Pattern**
   - **Purpose**: Ensures a class has only one instance
   - **Application**: BlogConfiguration - Manages global blog configuration
   - **Files**: `BlogConfiguration.java`

2. **Factory Method Pattern**
   - **Purpose**: Defines an interface for creating objects, letting subclasses decide which class to instantiate
   - **Application**: PostFactory - Creates different types of posts (Technical, Lifestyle)
   - **Files**: `PostFactory.java`, `TechnicalPostFactory.java`, `LifestylePostFactory.java`

3. **Abstract Factory Pattern**
   - **Purpose**: Provides an interface for creating families of related objects
   - **Application**: UIComponentFactory - Creates UI components for different themes (Modern, Classic)
   - **Files**: `UIComponentFactory.java`, `ModernUIFactory.java`, `ClassicUIFactory.java`

4. **Builder Pattern**
   - **Purpose**: Constructs complex objects step by step
   - **Application**: BlogPostBuilder - Builds blog posts with multiple attributes
   - **Files**: `BlogPostBuilder.java`

5. **Prototype Pattern**
   - **Purpose**: Creates new objects by copying from prototypes
   - **Application**: PostPrototypeRegistry - Clones posts from templates
   - **Files**: `PostPrototypeRegistry.java`

#### Structural Patterns Group - 4 patterns

6. **Adapter Pattern**
   - **Purpose**: Converts the interface of a class into another interface
   - **Application**: MarkdownAdapter - Converts Markdown to HTML
   - **Files**: `MarkdownAdapter.java`, `MarkdownParser.java`

7. **Decorator Pattern**
   - **Purpose**: Adds new functionality to objects dynamically
   - **Application**: PostDecorator - Adds comments and likes to posts
   - **Files**: `PostDecorator.java`, `CommentDecorator.java`, `LikeDecorator.java`

8. **Facade Pattern**
   - **Purpose**: Provides a simple interface to a complex system
   - **Application**: BlogManagementFacade - Simplifies post publishing process
   - **Files**: `BlogManagementFacade.java`

9. **Proxy Pattern**
   - **Purpose**: Provides a surrogate for another object to control access
   - **Application**: PostContentProxy - Lazy loads post content
   - **Files**: `PostContentProxy.java`, `RealPostContent.java`

#### Behavioral Patterns Group - 3 patterns

10. **Observer Pattern**
    - **Purpose**: Defines a one-to-many dependency between objects
    - **Application**: BlogPublisher - Notifies subscribers of new posts
    - **Files**: `BlogPublisher.java`, `EmailSubscriber.java`, `SMSSubscriber.java`

11. **Strategy Pattern**
    - **Purpose**: Defines a family of interchangeable algorithms
    - **Application**: RenderingStrategy - Content rendering strategies (Plain Text, HTML, JSON)
    - **Files**: `RenderingStrategy.java`, `PlainTextStrategy.java`, `HTMLRenderingStrategy.java`, `JSONRenderingStrategy.java`

12. **Template Method Pattern**
    - **Purpose**: Defines the skeleton of an algorithm, letting subclasses override specific steps
    - **Application**: PostPublishingTemplate - Post publishing workflow
    - **Files**: `PostPublishingTemplate.java`, `TechnicalPostPublisher.java`, `NewsPostPublisher.java`

### Running the Demo

```bash
# Compile the project
mvn clean compile

# Run the demo
mvn exec:java -Dexec.mainClass="com.blog.patterns.DesignPatternsDemo"
```

### Directory Structure

```
src/main/java/com/blog/patterns/
├── creational/        # 5 creational patterns
├── structural/        # 4 structural patterns  
├── behavioral/        # 3 behavioral patterns
├── models/            # Model classes
└── DesignPatternsDemo.java  # Demo class
```
