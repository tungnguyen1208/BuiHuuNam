# Pattern 06: Adapter

## Mô Tả (Description)

**Vietnamese:** Chuyển đổi interface của class thành interface khác mà client mong đợi

**English:** Converts the interface of a class into another interface clients expect

## Bài Toán (Problem)

Legacy MarkdownParser có interface cũ, cần adapt sang ContentRenderer interface mới

## Giải Pháp (Solution)

MarkdownAdapter làm cầu nối giữa MarkdownParser và ContentRenderer

## Cấu Trúc (Structure)

```
pattern06_adapter/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        ContentRenderer renderer = new MarkdownAdapter();
        String html = renderer.render("# Markdown Content\n\nParagraph here");
        System.out.println(html);

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern06_adapter.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern06_adapter/*.java
java com.blog.patterns.pattern06_adapter.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
