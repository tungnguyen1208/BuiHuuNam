# Pattern 08: Facade

## Mô Tả (Description)

**Vietnamese:** Cung cấp unified interface đơn giản cho một subsystem phức tạp

**English:** Provides a unified interface to a set of interfaces in a subsystem

## Bài Toán (Problem)

Publish post cần validation, storage, indexing, notification - quá phức tạp

## Giải Pháp (Solution)

BlogManagementFacade đơn giản hóa thành một phương thức publishPost()

## Cấu Trúc (Structure)

```
pattern08_facade/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        BlogManagementFacade facade = new BlogManagementFacade();
        BlogPost post = new BlogPost("Title", "Content", "Author");
        
        facade.publishPost(post);  // Handles all complex operations

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern08_facade.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern08_facade/*.java
java com.blog.patterns.pattern08_facade.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
