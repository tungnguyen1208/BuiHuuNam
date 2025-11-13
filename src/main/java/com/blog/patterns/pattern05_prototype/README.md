# Pattern 05: Prototype

## Mô Tả (Description)

**Vietnamese:** Tạo objects mới bằng cách clone từ một prototype instance

**English:** Creates new objects by cloning a prototypical instance

## Bài Toán (Problem)

Cần tạo blog posts mới dựa trên templates có sẵn để tiết kiệm thời gian

## Giải Pháp (Solution)

PostPrototypeRegistry lưu trữ templates và clone khi cần

## Cấu Trúc (Structure)

```
pattern05_prototype/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        PostPrototypeRegistry registry = new PostPrototypeRegistry();
        
        // Clone from technical template
        BlogPost post = registry.createPost("technical", "New Title", "Content", "Author");
        System.out.println("Cloned: " + post);

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern05_prototype.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern05_prototype/*.java
java com.blog.patterns.pattern05_prototype.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
