# Design Patterns for Blog Website - Java Implementation

This repository contains implementations of 12 Design Patterns in Java, specifically designed for a Blog Website application.

## 📋 Overview

This project demonstrates practical implementations of design patterns in the context of a blog website system. Each pattern is implemented with a specific use case related to blog functionality.

## 🎯 Design Patterns Implemented

### Creational Patterns (5)

1. **Singleton Pattern** - `BlogConfiguration`
   - Ensures only one instance of blog configuration exists
   - Manages global blog settings

2. **Factory Method Pattern** - `PostFactory`
   - Creates different types of blog posts (Technical, Lifestyle)
   - Encapsulates post creation logic

3. **Abstract Factory Pattern** - `UIComponentFactory`
   - Creates families of UI components (Modern, Classic themes)
   - Ensures UI consistency across themes

4. **Builder Pattern** - `BlogPostBuilder`
   - Constructs complex blog post objects step by step
   - Provides fluent interface for object creation

5. **Prototype Pattern** - `PostPrototypeRegistry`
   - Clones blog posts from templates
   - Efficient object creation through copying

### Structural Patterns (4)

6. **Adapter Pattern** - `MarkdownAdapter`
   - Adapts different content formats to common interface
   - Converts Markdown to HTML

7. **Decorator Pattern** - `PostDecorator`
   - Adds features to blog posts dynamically (comments, likes)
   - Extends functionality without modifying original class

8. **Facade Pattern** - `BlogManagementFacade`
   - Simplifies complex blog management operations
   - Provides unified interface for publishing workflow

9. **Proxy Pattern** - `PostContentProxy`
   - Lazy loads blog post content
   - Improves performance by loading on demand

### Behavioral Patterns (3)

10. **Observer Pattern** - `BlogPublisher`
    - Notifies subscribers when new posts are published
    - Implements publisher-subscriber relationship

11. **Strategy Pattern** - `RenderingStrategy`
    - Switches between different content rendering strategies
    - Supports Plain Text, HTML, and JSON rendering

12. **Template Method Pattern** - `PostPublishingTemplate`
    - Defines publishing workflow template
    - Allows customization of specific steps

## 🚀 Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Building the Project

```bash
mvn clean compile
```

### Running the Demo

```bash
mvn exec:java -Dexec.mainClass="com.blog.patterns.DesignPatternsDemo"
```

This will run demonstrations of all 12 design patterns with example outputs.

## 📁 Project Structure

```
src/main/java/com/blog/patterns/
├── creational/
│   ├── BlogConfiguration.java (Singleton)
│   ├── PostFactory.java (Factory Method)
│   ├── UIComponentFactory.java (Abstract Factory)
│   ├── BlogPostBuilder.java (Builder)
│   └── PostPrototypeRegistry.java (Prototype)
├── structural/
│   ├── MarkdownAdapter.java (Adapter)
│   ├── PostDecorator.java (Decorator)
│   ├── BlogManagementFacade.java (Facade)
│   └── PostContentProxy.java (Proxy)
├── behavioral/
│   ├── BlogPublisher.java (Observer)
│   ├── RenderingStrategy.java (Strategy)
│   └── PostPublishingTemplate.java (Template Method)
├── models/
│   ├── BlogPost.java
│   └── BlogSubscriber.java
└── DesignPatternsDemo.java
```

## 💡 Use Cases

### Singleton Pattern
Used for managing global blog configuration that should be consistent across the entire application.

### Factory Method Pattern
Creates different types of blog posts (technical, lifestyle) with appropriate default settings.

### Abstract Factory Pattern
Creates UI component families for different themes (modern, classic) ensuring visual consistency.

### Builder Pattern
Builds complex blog posts with multiple optional parameters in a readable way.

### Prototype Pattern
Clones blog post templates for quick creation of similar posts.

### Adapter Pattern
Adapts legacy Markdown parser to work with the new content rendering interface.

### Decorator Pattern
Dynamically adds features like comments and likes to blog posts without modifying the base class.

### Facade Pattern
Simplifies the complex process of publishing a blog post (validation, storage, indexing, notification).

### Proxy Pattern
Implements lazy loading for blog post content to improve performance.

### Observer Pattern
Notifies email and SMS subscribers when new posts are published.

### Strategy Pattern
Allows switching between different rendering strategies (plain text, HTML, JSON) at runtime.

### Template Method Pattern
Defines a standard publishing workflow while allowing customization for different post types.

## 🧪 Testing

The project includes unit tests for all patterns:

```bash
mvn test
```

## 📝 License

This project is created for educational purposes to demonstrate design patterns in Java.

## 👨‍💻 Author

BuiHuuNam

## 📚 References

- Gang of Four (GoF) Design Patterns
- Head First Design Patterns
- Refactoring Guru - Design Patterns