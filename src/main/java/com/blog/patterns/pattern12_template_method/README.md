# Pattern 12: Template Method

## Mô Tả (Description)

**Vietnamese:** Định nghĩa skeleton of algorithm, để subclass override các bước cụ thể

**English:** Defines the skeleton of an algorithm, letting subclasses override specific steps

## Bài Toán (Problem)

Workflow publish post có các bước chung nhưng mỗi loại post có implementation khác nhau

## Giải Pháp (Solution)

PostPublishingTemplate định nghĩa workflow, TechnicalPostPublisher và NewsPostPublisher override

## Cấu Trúc (Structure)

```
pattern12_template_method/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        PostPublishingTemplate publisher = new TechnicalPostPublisher();
        BlogPost post = new BlogPost("Java Guide", "Content", "Author");
        
        publisher.publishPost(post);  // Executes template workflow

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern12_template_method.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern12_template_method/*.java
java com.blog.patterns.pattern12_template_method.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
