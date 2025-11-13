# 12 Design Patterns - Reorganized Structure

## Tổng Quan (Overview)

**Vietnamese:** Dự án đã được tổ chức lại với **mỗi mẫu thiết kế trong 1 folder riêng biệt**. Điều này giúp code dễ tìm, dễ học và dễ bảo trì hơn.

**English:** The project has been reorganized with **each design pattern in its own separate folder**. This makes the code easier to find, learn, and maintain.

## 📁 Cấu Trúc Mới (New Structure)

```
src/main/java/com/blog/patterns/
│
├── pattern01_singleton/          ← Singleton Pattern
│   ├── BlogConfiguration.java
│   ├── SingletonDemo.java
│   └── README.md
│
├── pattern02_factory_method/     ← Factory Method Pattern
│   ├── PostFactory.java
│   ├── TechnicalPostFactory.java
│   ├── LifestylePostFactory.java
│   ├── Demo.java
│   └── README.md
│
├── pattern03_abstract_factory/   ← Abstract Factory Pattern
│   ├── UIComponentFactory.java
│   ├── ModernUIFactory.java
│   ├── ClassicUIFactory.java
│   ├── Button.java, Header.java, Footer.java
│   ├── Demo.java
│   └── README.md
│
├── pattern04_builder/            ← Builder Pattern
│   ├── BlogPostBuilder.java
│   ├── Demo.java
│   └── README.md
│
├── pattern05_prototype/          ← Prototype Pattern
│   ├── PostPrototypeRegistry.java
│   ├── Demo.java
│   └── README.md
│
├── pattern06_adapter/            ← Adapter Pattern
│   ├── MarkdownAdapter.java
│   ├── MarkdownParser.java
│   ├── ContentRenderer.java
│   ├── HTMLRenderer.java
│   ├── Demo.java
│   └── README.md
│
├── pattern07_decorator/          ← Decorator Pattern
│   ├── BlogPostComponent.java
│   ├── BasicBlogPost.java
│   ├── PostDecorator.java
│   ├── CommentDecorator.java
│   ├── LikeDecorator.java
│   ├── Demo.java
│   └── README.md
│
├── pattern08_facade/             ← Facade Pattern
│   ├── BlogManagementFacade.java
│   ├── Demo.java
│   └── README.md
│
├── pattern09_proxy/              ← Proxy Pattern
│   ├── PostContent.java
│   ├── RealPostContent.java
│   ├── PostContentProxy.java
│   ├── Demo.java
│   └── README.md
│
├── pattern10_observer/           ← Observer Pattern
│   ├── BlogPublisher.java
│   ├── EmailSubscriber.java
│   ├── SMSSubscriber.java
│   ├── Demo.java
│   └── README.md
│
├── pattern11_strategy/           ← Strategy Pattern
│   ├── RenderingStrategy.java
│   ├── HTMLRenderingStrategy.java
│   ├── JSONRenderingStrategy.java
│   ├── PlainTextStrategy.java
│   ├── ContentRenderer.java
│   ├── Demo.java
│   └── README.md
│
├── pattern12_template_method/    ← Template Method Pattern
│   ├── PostPublishingTemplate.java
│   ├── TechnicalPostPublisher.java
│   ├── NewsPostPublisher.java
│   ├── Demo.java
│   └── README.md
│
├── shared/                       ← Shared Models
│   └── BlogPost.java
│
├── forms/                        ← Forms using all patterns
│   ├── *Controller.java
│   └── *Demo.java
│
└── AllPatternsDemo.java          ← Master demo
```

## 🎯 Cách Chạy (How to Run)

### Chạy Demo Master (Run Master Demo)

```bash
mvn exec:java -Dexec.mainClass="com.blog.patterns.AllPatternsDemo"
```

### Chạy Demo Từng Pattern (Run Individual Pattern Demo)

```bash
# Pattern 01 - Singleton
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern01_singleton.SingletonDemo"

# Pattern 02 - Factory Method
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern02_factory_method.Demo"

# Pattern 03 - Abstract Factory
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern03_abstract_factory.Demo"

# Pattern 04 - Builder
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern04_builder.Demo"

# Pattern 05 - Prototype
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern05_prototype.Demo"

# Pattern 06 - Adapter
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern06_adapter.Demo"

# Pattern 07 - Decorator
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern07_decorator.Demo"

# Pattern 08 - Facade
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern08_facade.Demo"

# Pattern 09 - Proxy
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern09_proxy.Demo"

# Pattern 10 - Observer
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern10_observer.Demo"

# Pattern 11 - Strategy
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern11_strategy.Demo"

# Pattern 12 - Template Method
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern12_template_method.Demo"
```

## 📚 12 Design Patterns

### Creational Patterns (Nhóm Khởi Tạo) - 5 Patterns

| # | Pattern | Folder | Mô Tả |
|---|---------|--------|-------|
| 01 | **Singleton** | `pattern01_singleton/` | Đảm bảo chỉ có 1 instance duy nhất |
| 02 | **Factory Method** | `pattern02_factory_method/` | Tạo object theo type |
| 03 | **Abstract Factory** | `pattern03_abstract_factory/` | Tạo families of related objects |
| 04 | **Builder** | `pattern04_builder/` | Xây dựng object phức tạp từng bước |
| 05 | **Prototype** | `pattern05_prototype/` | Clone từ template |

### Structural Patterns (Nhóm Cấu Trúc) - 4 Patterns

| # | Pattern | Folder | Mô Tả |
|---|---------|--------|-------|
| 06 | **Adapter** | `pattern06_adapter/` | Chuyển đổi interface |
| 07 | **Decorator** | `pattern07_decorator/` | Thêm tính năng động |
| 08 | **Facade** | `pattern08_facade/` | Interface đơn giản hóa |
| 09 | **Proxy** | `pattern09_proxy/` | Kiểm soát access/lazy loading |

### Behavioral Patterns (Nhóm Hành Vi) - 3 Patterns

| # | Pattern | Folder | Mô Tả |
|---|---------|--------|-------|
| 10 | **Observer** | `pattern10_observer/` | Notify các dependents |
| 11 | **Strategy** | `pattern11_strategy/` | Algorithms interchangeable |
| 12 | **Template Method** | `pattern12_template_method/` | Skeleton of algorithm |

## 📖 Tài Liệu (Documentation)

Mỗi folder pattern chứa:

1. **Implementation Files** (*.java) - Code implementation
2. **Demo.java** - Chương trình demo có thể chạy
3. **README.md** - Giải thích pattern bằng tiếng Việt và tiếng Anh

## ✨ Ưu Điểm Của Cấu Trúc Mới (Advantages)

✅ **Dễ tìm (Easy to Find)**
- Mỗi pattern có folder riêng với tên rõ ràng
- Không bị lẫn lộn giữa các patterns

✅ **Dễ học (Easy to Learn)**
- Mỗi folder là một bài học độc lập
- README giải thích chi tiết từng pattern

✅ **Dễ bảo trì (Easy to Maintain)**
- Thay đổi 1 pattern không ảnh hưởng patterns khác
- Code được tách biệt rõ ràng

✅ **Dễ mở rộng (Easy to Extend)**
- Thêm pattern mới chỉ cần tạo folder mới
- Không cần sửa code cũ

## 🔄 So Sánh Với Cấu Trúc Cũ

### Cấu Trúc Cũ (Old Structure)
```
patterns/
├── creational/      (5 patterns mixed together)
├── structural/      (4 patterns mixed together)
└── behavioral/      (3 patterns mixed together)
```

### Cấu Trúc Mới (New Structure)
```
patterns/
├── pattern01_singleton/
├── pattern02_factory_method/
├── pattern03_abstract_factory/
... (each pattern separate)
└── pattern12_template_method/
```

## 🎓 Học Tập Từng Pattern (Learn Each Pattern)

### Cách Học Hiệu Quả:

1. **Chọn 1 pattern** - Vào folder pattern muốn học
2. **Đọc README.md** - Hiểu bài toán và giải pháp
3. **Xem code** - Đọc implementation files
4. **Chạy Demo** - Xem pattern hoạt động thực tế
5. **Thực hành** - Thử modify code hoặc tạo example mới

### Thứ Tự Học Đề Nghị:

**Beginner** → Bắt đầu với:
- Pattern 01 (Singleton) - Đơn giản nhất
- Pattern 04 (Builder) - Rất thực tế
- Pattern 08 (Facade) - Dễ hiểu

**Intermediate** → Tiếp tục với:
- Pattern 02 (Factory Method)
- Pattern 06 (Adapter)
- Pattern 10 (Observer)

**Advanced** → Các pattern phức tạp hơn:
- Pattern 03 (Abstract Factory)
- Pattern 07 (Decorator)
- Pattern 11 (Strategy)
- Pattern 12 (Template Method)

## 🚀 Quick Start

```bash
# 1. Clone repository
git clone <repo-url>

# 2. Build project
mvn clean compile

# 3. Run master demo
mvn exec:java -Dexec.mainClass="com.blog.patterns.AllPatternsDemo"

# 4. Run individual pattern
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern01_singleton.SingletonDemo"

# 5. Explore code
cd src/main/java/com/blog/patterns/pattern01_singleton
cat README.md
```

## 📝 Notes

- **Shared Models**: Các model dùng chung (BlogPost) nằm trong `shared/` package
- **Forms**: Forms sử dụng tất cả 12 patterns vẫn giữ nguyên trong `forms/` package
- **Original Files**: Các files cũ trong `creational/`, `structural/`, `behavioral/` vẫn giữ để tham khảo

## 🎯 Kết Luận

Cấu trúc mới này giúp:
- ✅ Dễ dàng tìm pattern cần học
- ✅ Mỗi pattern là một module độc lập
- ✅ README riêng cho từng pattern
- ✅ Demo riêng cho từng pattern
- ✅ Phù hợp cho học tập và giảng dạy

**Happy Learning! 🎓**
