# Pattern 07: Decorator

## Mô Tả (Description)

**Vietnamese:** Gắn thêm responsibilities cho object một cách động

**English:** Attaches additional responsibilities to an object dynamically

## Bài Toán (Problem)

Cần thêm features (comments, likes) cho blog post mà không thay đổi class gốc

## Giải Pháp (Solution)

PostDecorator với CommentDecorator và LikeDecorator wrap blog post

## Cấu Trúc (Structure)

```
pattern07_decorator/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        BlogPost post = new BlogPost("Title", "Content", "Author");
        BlogPostComponent component = new BasicBlogPost(post);
        
        // Add comments
        component = new CommentDecorator(component, 5);
        
        // Add likes
        component = new LikeDecorator(component, 10);
        
        component.display();

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern07_decorator.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern07_decorator/*.java
java com.blog.patterns.pattern07_decorator.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
