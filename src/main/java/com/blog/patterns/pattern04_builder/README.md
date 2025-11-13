# Pattern 04: Builder

## Mô Tả (Description)

**Vietnamese:** Tách rời việc xây dựng một object phức tạp khỏi representation của nó

**English:** Separates the construction of a complex object from its representation

## Bài Toán (Problem)

BlogPost có nhiều thuộc tính optional (title, content, author, category, tags) - khó quản lý constructor

## Giải Pháp (Solution)

BlogPostBuilder cho phép xây dựng post từng bước một cách rõ ràng

## Cấu Trúc (Structure)

```
pattern04_builder/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        BlogPost post = new BlogPostBuilder()
            .setTitle("Design Patterns")
            .setAuthor("John Doe")
            .setContent("Content here...")
            .setCategory("Technical")
            .addTag("java")
            .addTag("patterns")
            .build();

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern04_builder.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern04_builder/*.java
java com.blog.patterns.pattern04_builder.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
