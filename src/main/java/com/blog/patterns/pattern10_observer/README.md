# Pattern 10: Observer

## Mô Tả (Description)

**Vietnamese:** Định nghĩa one-to-many dependency để khi object thay đổi, tất cả dependents được notify

**English:** Defines a one-to-many dependency so when one object changes state, all dependents are notified

## Bài Toán (Problem)

Khi có post mới, cần notify tất cả subscribers qua email, SMS

## Giải Pháp (Solution)

BlogPublisher notify tất cả subscribers (EmailSubscriber, SMSSubscriber)

## Cấu Trúc (Structure)

```
pattern10_observer/
├── *.java                # Pattern implementation files
├── Demo.java             # Demo usage
└── README.md             # This file
```

## Cách Sử Dụng (Usage)

```java

        BlogPublisher publisher = new BlogPublisher();
        
        publisher.subscribe(new EmailSubscriber("user@example.com"));
        publisher.subscribe(new SMSSubscriber("+123456789"));
        
        BlogPost post = new BlogPost("Title", "Content", "Author");
        publisher.publishPost(post);  // All subscribers notified

```

## Chạy Demo (Run Demo)

```bash
# With Maven
mvn exec:java -Dexec.mainClass="com.blog.patterns.pattern10_observer.Demo"

# Or compile and run directly
javac com/blog/patterns/pattern10_observer/*.java
java com.blog.patterns.pattern10_observer.Demo
```

## Ưu Điểm (Advantages)

✓ Flexible and extensible
✓ Follows SOLID principles
✓ Reusable code

## Khi Nào Sử Dụng (When to Use)

Use this pattern when you need the specific functionality it provides.
See the demo and problem description for concrete use cases.
