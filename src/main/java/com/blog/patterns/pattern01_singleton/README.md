# Pattern 01: Singleton Pattern

## Mô Tả (Description)

**Vietnamese:** Mẫu Singleton đảm bảo một class chỉ có duy nhất một instance và cung cấp một điểm truy cập toàn cục đến instance đó.

**English:** The Singleton pattern ensures a class has only one instance and provides a global point of access to it.

## Bài Toán (Problem)

Trong hệ thống blog, cấu hình blog (BlogConfiguration) cần được chia sẻ và nhất quán trong toàn bộ ứng dụng. Nếu tạo nhiều instance, có thể dẫn đến:
- Lãng phí tài nguyên
- Dữ liệu không nhất quán
- Khó quản lý trạng thái toàn cục

## Giải Pháp (Solution)

Sử dụng Singleton Pattern để:
- Đảm bảo chỉ có 1 instance của BlogConfiguration
- Cung cấp điểm truy cập toàn cục qua `getInstance()`
- Constructor private để ngăn tạo instance từ bên ngoài

## Cấu Trúc (Structure)

```
pattern01_singleton/
├── BlogConfiguration.java     # Singleton class
├── SingletonDemo.java         # Demo usage
└── README.md                  # This file
```

## Class Diagram

```
┌─────────────────────────┐
│   BlogConfiguration     │
├─────────────────────────┤
│ - instance: static      │
│ - settings: Map         │
├─────────────────────────┤
│ - BlogConfiguration()   │ (private)
│ + getInstance(): static │
│ + getSetting()          │
│ + setSetting()          │
│ + displaySettings()     │
└─────────────────────────┘
```

## Cách Sử Dụng (Usage)

```java
// Get the singleton instance
BlogConfiguration config = BlogConfiguration.getInstance();

// Use the instance
config.setSetting("blogName", "My Blog");
String name = config.getSetting("blogName");
```

## Chạy Demo (Run Demo)

```bash
# Compile
javac com/blog/patterns/pattern01_singleton/*.java

# Run
java com.blog.patterns.pattern01_singleton.SingletonDemo

# Or with Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern01_singleton.SingletonDemo"
```

## Ưu Điểm (Advantages)

✓ Đảm bảo chỉ có một instance duy nhất
✓ Tiết kiệm bộ nhớ
✓ Truy cập toàn cục dễ dàng
✓ Lazy initialization (tạo khi cần)

## Nhược Điểm (Disadvantages)

✗ Khó test (global state)
✗ Vi phạm Single Responsibility Principle
✗ Có thể gây vấn đề trong môi trường multi-threaded nếu không đồng bộ

## Khi Nào Sử Dụng (When to Use)

- Cần đảm bảo chỉ có 1 instance của class
- Cần điểm truy cập toàn cục
- Configuration, Logger, Database Connection Pool

## Related Patterns

- **Factory Method**: Singleton thường được sử dụng trong Factory
- **Facade**: Facade objects thường là Singleton
