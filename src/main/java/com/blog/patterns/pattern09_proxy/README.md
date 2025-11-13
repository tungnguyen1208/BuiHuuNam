# Pattern 09: Proxy

## Mô Tả (Description)

**Vietnamese:** Cung cấp placeholder cho object khác để control access

**English:** Provides a placeholder for another object to control access to it

## Bài Toán (Problem)

Blog post content có thể rất lớn - không nên load hết ngay lập tức

## Giải Pháp (Solution)

PostContentProxy lazy load content chỉ khi thực sự cần

## Cấu Trúc (Structure)

```
pattern09_proxy/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        PostContent content = new PostContentProxy("post-123");
        
        // Content not loaded yet
        System.out.println("Proxy created");
        
        // Now load content
        String text = content.getContent();  // Loads on demand

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern09_proxy.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern09_proxy/*.java
java com.blog.patterns.pattern09_proxy.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
