# Blog Website - 12 Design Patterns Implementation in Java

This project demonstrates the implementation of 12 Design Patterns for a blog website application, organized into three categories: Creational, Structural, and Behavioral patterns.

## 📋 Project Overview

This repository contains a complete implementation of 12 design patterns applied to a blog website context. Each pattern is implemented with practical examples relevant to blog management functionality.

## 🏗️ Design Patterns Implemented

### Creational Patterns (5)

1. **Singleton Pattern** - `BlogConfiguration`
   - Ensures only one instance of blog configuration exists
   - Manages global settings like blog name, posts per page, theme, etc.

2. **Factory Method Pattern** - `BlogPostFactory`
   - Creates different types of blog posts (Technical, Tutorial, News)
   - Each factory type adds appropriate tags and formatting

3. **Abstract Factory Pattern** - `UIComponentFactory`
   - Creates families of related UI components (Dark Theme, Light Theme)
   - Generates buttons, text fields, and panels with consistent theming

4. **Builder Pattern** - `BlogPostBuilder`
   - Constructs complex BlogPost objects step by step
   - Allows flexible creation of posts with optional attributes

5. **Prototype Pattern** - `BlogPostPrototype`
   - Creates new blog posts by cloning existing templates
   - Provides templates for standard, technical, and tutorial posts

### Structural Patterns (6)

6. **Adapter Pattern** - `LegacyBlogAdapter`
   - Adapts legacy blog system to work with modern interface
   - Converts between different data formats and method signatures

7. **Bridge Pattern** - `BlogRenderer`
   - Separates blog rendering abstraction from platform implementation
   - Supports HTML, Markdown, and Plain Text rendering

8. **Composite Pattern** - `CommentComponent`
   - Treats individual comments and comment threads uniformly
   - Creates tree structures for nested comments and replies

9. **Decorator Pattern** - `BlogPostDecorator`
   - Adds features dynamically: SEO metadata, social sharing, reading time, ads
   - Decorators can be combined for multiple enhancements

10. **Facade Pattern** - `BlogManagementFacade`
    - Simplifies complex blog operations (publish, comment, search)
    - Coordinates multiple subsystems (posts, users, notifications, search)

11. **Proxy Pattern** - `BlogPostProxy`
    - Controls access to blog posts with caching and security
    - Implements caching, access control, and logging proxies

### Behavioral Patterns (1)

12. **Observer Pattern** - `BlogSubscriber`
    - Notifies subscribers when new posts are published
    - Supports multiple notification channels: Email, SMS, Push, RSS

## 📁 Project Structure

```
src/main/java/com/blog/
├── model/
│   ├── BlogPost.java           # Main blog post model
│   ├── Comment.java             # Comment model
│   └── User.java                # User model
├── designpatterns/
│   ├── creational/
│   │   ├── BlogConfiguration.java          # Singleton
│   │   ├── BlogPostFactory.java            # Factory Method
│   │   ├── BlogPostFactoryProvider.java    # Factory helper
│   │   ├── UIComponentFactory.java         # Abstract Factory
│   │   ├── UIComponentFactoryProvider.java # Factory helper
│   │   ├── BlogPostBuilder.java            # Builder
│   │   └── BlogPostPrototype.java          # Prototype
│   ├── structural/
│   │   ├── LegacyBlogAdapter.java          # Adapter
│   │   ├── LegacyBlogAdapterFactory.java   # Adapter helper
│   │   ├── BlogRenderer.java               # Bridge
│   │   ├── BlogRendererFactory.java        # Bridge helper
│   │   ├── CommentComponent.java           # Composite
│   │   ├── CommentFactory.java             # Composite helper
│   │   ├── BlogPostDecorator.java          # Decorator
│   │   ├── BlogPostDecoratorFactory.java   # Decorator helper
│   │   ├── BlogManagementFacade.java       # Facade
│   │   ├── BlogPostProxy.java              # Proxy
│   │   └── BlogPostProxyFactory.java       # Proxy helper
│   └── behavioral/
│       ├── BlogSubscriber.java             # Observer
│       └── BlogSubscriberFacade.java       # Observer helper
└── BlogDesignPatternsDemo.java             # Demo application

```

## 🚀 How to Compile and Run

### Prerequisites
- Java Development Kit (JDK) 11 or higher

### Compilation

```bash
# Create bin directory
mkdir bin

# Compile all Java files
javac -d bin src/main/java/com/blog/model/*.java \
             src/main/java/com/blog/designpatterns/creational/*.java \
             src/main/java/com/blog/designpatterns/structural/*.java \
             src/main/java/com/blog/designpatterns/behavioral/*.java \
             src/main/java/com/blog/*.java
```

### Running the Demo

```bash
# Run the demo application
java -cp bin com.blog.BlogDesignPatternsDemo
```

## 📖 Design Pattern Details

### 1. Singleton Pattern - BlogConfiguration
**Purpose:** Ensure only one instance of configuration exists throughout the application.

**Usage Example:**
```java
BlogConfiguration config = BlogConfiguration.getInstance();
String blogName = config.getBlogName();
int postsPerPage = config.getPostsPerPage();
```

### 2. Factory Method Pattern - BlogPostFactory
**Purpose:** Create different types of blog posts without specifying their exact classes.

**Usage Example:**
```java
BlogPostFactory factory = BlogPostFactoryProvider.getTechnicalFactory();
BlogPost post = factory.createAndPublish("Title", "Content", "Author");
```

### 3. Abstract Factory Pattern - UIComponentFactory
**Purpose:** Create families of related UI components (themes) without specifying concrete classes.

**Usage Example:**
```java
UIComponentFactory darkFactory = UIComponentFactoryProvider.getDarkThemeFactory();
// Creates dark-themed buttons, text fields, and panels
```

### 4. Builder Pattern - BlogPostBuilder
**Purpose:** Construct complex blog post objects step by step.

**Usage Example:**
```java
BlogPost post = BlogPostBuilder.builder()
    .withTitle("My Post")
    .withContent("Content here...")
    .withAuthor("John Doe")
    .addTag("Java")
    .addTag("Design Patterns")
    .build();
```

### 5. Prototype Pattern - BlogPostPrototype
**Purpose:** Create new objects by cloning existing prototypes.

**Usage Example:**
```java
BlogPostPrototype prototype = new BlogPostPrototype();
BlogPost technicalPost = prototype.createPost("technical");
technicalPost.setAuthor("Alice");
```

### 6. Adapter Pattern - LegacyBlogAdapter
**Purpose:** Allow legacy blog system to work with modern interfaces.

**Usage Example:**
```java
LegacyBlogAdapter adapter = LegacyBlogAdapterFactory.createAdapter();
adapter.savePost(modernBlogPost);
```

### 7. Bridge Pattern - BlogRenderer
**Purpose:** Separate rendering abstraction from platform implementation.

**Usage Example:**
```java
BlogRenderer renderer = BlogRendererFactory.createDetailedHTMLRenderer();
renderer.render(blogPost);
```

### 8. Composite Pattern - CommentComponent
**Purpose:** Treat individual comments and comment trees uniformly.

**Usage Example:**
```java
CommentComponent thread = CommentFactory.createCommentThread("1", "Alice", "Great!");
thread.add(CommentFactory.createSingleComment("2", "Bob", "Thanks!"));
thread.display(0);
```

### 9. Decorator Pattern - BlogPostDecorator
**Purpose:** Add features to blog posts dynamically without modifying their structure.

**Usage Example:**
```java
BlogPostDecorator decorated = BlogPostDecoratorFactory.withSEO(post, 
    "Description", "keywords");
decorated = BlogPostDecoratorFactory.withSocialMedia(post);
```

### 10. Facade Pattern - BlogManagementFacade
**Purpose:** Provide a simplified interface to complex blog subsystems.

**Usage Example:**
```java
BlogManagementFacade facade = new BlogManagementFacade();
facade.publishBlogPost(post, author);
facade.addComment("postId", comment, user);
```

### 11. Proxy Pattern - BlogPostProxy
**Purpose:** Control access to blog posts with caching, security, and logging.

**Usage Example:**
```java
BlogPostProxyFactory.demonstrateCachingProxy("123");
BlogPostProxyFactory.demonstrateProtectedProxy(user, post);
```

### 12. Observer Pattern - BlogSubscriber
**Purpose:** Notify multiple subscribers when new blog posts are published.

**Usage Example:**
```java
BlogSubscriberFacade facade = new BlogSubscriberFacade();
facade.subscribeEmail("Alice", "alice@example.com");
facade.subscribeSMS("Bob", "+1234567890");
facade.publishPost(newPost); // All subscribers are notified
```

## 🎯 Key Features

- **Comprehensive Implementation**: All 12 patterns are fully functional
- **Blog Context**: Each pattern is applied to real blog website scenarios
- **Clean Architecture**: Well-organized package structure
- **Practical Examples**: Demo application showcases each pattern in action
- **Production-Ready**: Patterns follow best practices and SOLID principles

## 🧪 Testing

Run the demo application to see all patterns in action:

```bash
java -cp bin com.blog.BlogDesignPatternsDemo
```

The demo will demonstrate:
- Configuration management (Singleton)
- Post creation with factories (Factory Method, Abstract Factory)
- Flexible post building (Builder)
- Template cloning (Prototype)
- Legacy system integration (Adapter)
- Multi-platform rendering (Bridge)
- Nested comment trees (Composite)
- Dynamic feature addition (Decorator)
- Simplified operations (Facade)
- Access control and caching (Proxy)
- Subscriber notifications (Observer)

## 📚 Learning Outcomes

By studying this project, you will learn:
1. How to apply design patterns to real-world applications
2. When to use each pattern
3. How patterns work together in a cohesive system
4. Best practices for implementing patterns in Java
5. How to structure a maintainable codebase with patterns

## 🤝 Contributing

This is an educational project demonstrating design patterns. Feel free to:
- Fork the repository
- Add more patterns
- Improve existing implementations
- Add unit tests
- Enhance documentation

## 📝 License

This project is for educational purposes. Feel free to use and modify as needed.

## 👨‍💻 Author

Created as a demonstration of design patterns in Java for blog website applications.

## 🔗 Resources

- [Design Patterns: Elements of Reusable Object-Oriented Software](https://en.wikipedia.org/wiki/Design_Patterns) by Gang of Four
- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)
- [Java Design Patterns](https://java-design-patterns.com/)

---

**Note:** This implementation focuses on demonstrating the patterns clearly. In a production environment, you would add error handling, validation, persistence, and comprehensive testing.
