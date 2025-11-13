# Pattern 03: Abstract Factory

## Mô Tả (Description)

**Vietnamese:** Cung cấp interface để tạo families of related objects mà không cần chỉ định concrete classes

**English:** Provides an interface for creating families of related objects without specifying concrete classes

## Bài Toán (Problem)

Cần tạo UI components (Button, Header, Footer) theo theme (Modern/Classic) nhất quán

## Giải Pháp (Solution)

UIComponentFactory với ModernUIFactory và ClassicUIFactory tạo components cùng theme

## Cấu Trúc (Structure)

```
pattern03_abstract_factory/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        // Modern theme
        UIComponentFactory factory = new ModernUIFactory();
        Button btn = factory.createButton();
        Header header = factory.createHeader();
        btn.render();
        header.render();

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern03_abstract_factory.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern03_abstract_factory/*.java
java com.blog.patterns.pattern03_abstract_factory.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
