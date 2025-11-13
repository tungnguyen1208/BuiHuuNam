# Pattern 11: Strategy

## Mô Tả (Description)

**Vietnamese:** Định nghĩa family of algorithms và làm cho chúng interchangeable

**English:** Defines a family of algorithms and makes them interchangeable

## Bài Toán (Problem)

Cần render blog content theo nhiều format khác nhau (HTML, JSON, Plain Text)

## Giải Pháp (Solution)

RenderingStrategy với các implementations: HTMLRenderingStrategy, JSONRenderingStrategy

## Cấu Trúc (Structure)

```
pattern11_strategy/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        ContentRenderer renderer = new ContentRenderer();
        
        // Use HTML strategy
        renderer.setStrategy(new HTMLRenderingStrategy());
        System.out.println(renderer.renderContent(post));
        
        // Switch to JSON strategy
        renderer.setStrategy(new JSONRenderingStrategy());
        System.out.println(renderer.renderContent(post));

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern11_strategy.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern11_strategy/*.java
java com.blog.patterns.pattern11_strategy.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
