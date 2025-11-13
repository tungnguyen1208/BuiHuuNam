# Pattern 02: Factory Method

## Mô Tả (Description)

**Vietnamese:** Định nghĩa interface để tạo object nhưng để subclass quyết định class nào sẽ được khởi tạo

**English:** Defines an interface for creating objects but lets subclasses decide which class to instantiate

## Bài Toán (Problem)

Cần tạo các loại blog post khác nhau (Technical, Lifestyle, News) mà không cần biết trước loại cụ thể

## Giải Pháp (Solution)

Sử dụng PostFactory với các subclass TechnicalPostFactory, LifestylePostFactory

## Cấu Trúc (Structure)

```
pattern02_factory_method/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        // Create Technical post
        PostFactory factory = new TechnicalPostFactory();
        BlogPost post = factory.createPost("Java Patterns", "Content...", "Author");
        System.out.println("Created: " + post);
        
        // Create Lifestyle post
        factory = new LifestylePostFactory();
        post = factory.createPost("Healthy Living", "Tips...", "Author");
        System.out.println("Created: " + post);

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern02_factory_method.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern02_factory_method/*.java
java com.blog.patterns.pattern02_factory_method.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
