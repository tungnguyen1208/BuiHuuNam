# Design Patterns Diagram Overview

## Pattern Categories

```
┌─────────────────────────────────────────────────────────────┐
│                    12 DESIGN PATTERNS                        │
│                    FOR BLOG WEBSITE                          │
└─────────────────────────────────────────────────────────────┘
                              │
        ┌─────────────────────┼─────────────────────┐
        │                     │                     │
        ▼                     ▼                     ▼
┌───────────────┐    ┌───────────────┐    ┌───────────────┐
│  CREATIONAL   │    │  STRUCTURAL   │    │  BEHAVIORAL   │
│  PATTERNS     │    │  PATTERNS     │    │  PATTERNS     │
│   (5)         │    │   (4)         │    │   (3)         │
└───────────────┘    └───────────────┘    └───────────────┘
```

## Creational Patterns (Creating Objects)

### 1. Singleton Pattern
```
BlogConfiguration (Static Instance)
    │
    ├── getInstance() → Returns same instance
    ├── getSetting(key)
    └── setSetting(key, value)
```

### 2. Factory Method Pattern
```
PostFactory (Abstract)
    │
    ├── TechnicalPostFactory → Creates Technical Posts
    │       └── createPost() → BlogPost with "Technical" category
    │
    └── LifestylePostFactory → Creates Lifestyle Posts
            └── createPost() → BlogPost with "Lifestyle" category
```

### 3. Abstract Factory Pattern
```
UIComponentFactory (Interface)
    │
    ├── ModernUIFactory
    │   ├── createButton() → ModernButton
    │   ├── createHeader() → ModernHeader
    │   └── createFooter() → ModernFooter
    │
    └── ClassicUIFactory
        ├── createButton() → ClassicButton
        ├── createHeader() → ClassicHeader
        └── createFooter() → ClassicFooter
```

### 4. Builder Pattern
```
BlogPostBuilder
    │
    ├── setTitle(title) → returns this
    ├── setContent(content) → returns this
    ├── setAuthor(author) → returns this
    ├── addTag(tag) → returns this
    └── build() → BlogPost (complete object)
```

### 5. Prototype Pattern
```
PostPrototypeRegistry
    │
    ├── Prototypes Map
    │   ├── "technical" → Technical Template
    │   └── "news" → News Template
    │
    └── createPost(type) → Clones template and customizes
```

## Structural Patterns (Organizing Objects)

### 6. Adapter Pattern
```
ContentRenderer (Interface)
    │
    ├── HTMLRenderer → Direct implementation
    │
    └── MarkdownAdapter → Adapts MarkdownParser
            │
            └── MarkdownParser (Legacy class)
                    └── parseMarkdown()
```

### 7. Decorator Pattern
```
BlogPostComponent (Interface)
    │
    └── BasicBlogPost → Basic implementation
            │
            ├── CommentDecorator → Adds comments
            │       └── + display comments count
            │
            └── LikeDecorator → Adds likes
                    └── + display likes count
```

### 8. Facade Pattern
```
BlogManagementFacade
    │
    ├── publishPost(post)
    │   │
    │   ├─→ PostValidator.validate()
    │   ├─→ PostStorage.save()
    │   ├─→ SearchIndexer.index()
    │   └─→ NotificationService.notify()
    │
    └── Simplifies complex subsystem
```

### 9. Proxy Pattern
```
PostContent (Interface)
    │
    ├── RealPostContent → Actual content from DB
    │       └── Expensive to load
    │
    └── PostContentProxy → Lazy loading wrapper
            └── Loads RealPostContent only when needed
```

## Behavioral Patterns (Object Interactions)

### 10. Observer Pattern
```
BlogPublisher (Subject)
    │
    ├── subscribe(subscriber)
    ├── unsubscribe(subscriber)
    └── publishPost(post) → Notifies all
            │
            ├─→ EmailSubscriber
            ├─→ EmailSubscriber
            └─→ SMSSubscriber
```

### 11. Strategy Pattern
```
ContentRenderer (Context)
    │
    └── setStrategy(strategy)
            │
            ├─→ PlainTextStrategy → Plain text output
            ├─→ HTMLRenderingStrategy → HTML output
            └─→ JSONRenderingStrategy → JSON output
```

### 12. Template Method Pattern
```
PostPublishingTemplate (Abstract)
    │
    ├── publishPost() [Template Method]
    │   ├── validatePost() [Concrete]
    │   ├── formatContent() [Abstract]
    │   ├── saveToDatabase() [Concrete]
    │   ├── notifyUsers() [Abstract]
    │   └── shouldAddToFeatured() [Hook]
    │
    ├── TechnicalPostPublisher
    │   ├── formatContent() → Code highlighting
    │   └── notifyUsers() → Developer subscribers
    │
    └── NewsPostPublisher
        ├── formatContent() → Breaking news style
        └── notifyUsers() → Push notifications
```

## Usage Flow Example

```
1. Get Configuration (Singleton)
   └─→ BlogConfiguration.getInstance()

2. Create Post (Builder + Factory)
   └─→ BlogPostBuilder.setTitle()...build()

3. Add Features (Decorator)
   └─→ new CommentDecorator(new LikeDecorator(post))

4. Render Content (Strategy + Adapter)
   └─→ renderer.setStrategy(new HTMLRenderingStrategy())

5. Publish Post (Facade + Template Method + Observer)
   └─→ facade.publishPost(post)
       ├─→ Uses Template Method for workflow
       └─→ Triggers Observer notifications

6. Load Content (Proxy)
   └─→ proxy.getContent() [Lazy loading]
```

## Pattern Relationships in Blog System

```
┌──────────────────────────────────────────────────────────┐
│  Blog Website System Architecture                        │
├──────────────────────────────────────────────────────────┤
│                                                          │
│  [Singleton: Configuration] ──→ Global Settings         │
│                                                          │
│  [Factory Method] ──→ [Builder] ──→ BlogPost            │
│                           │                              │
│  [Abstract Factory] ──→ UI Components                   │
│                           │                              │
│  [Adapter] ──→ Content Format Conversion                │
│                           │                              │
│  [Decorator] ──→ Enhanced BlogPost Features             │
│                           │                              │
│  [Strategy] ──→ Rendering Output                        │
│                           │                              │
│  [Facade] ──→ [Template Method] ──→ Publishing          │
│                           │                              │
│  [Observer] ──→ Subscriber Notifications                │
│                           │                              │
│  [Proxy] ──→ Lazy Content Loading                       │
│                                                          │
└──────────────────────────────────────────────────────────┘
```

## Key Benefits

### Creational
- **Singleton**: Single source of truth for configuration
- **Factory Method**: Easy to add new post types
- **Abstract Factory**: Consistent UI theming
- **Builder**: Flexible object construction
- **Prototype**: Efficient template-based creation

### Structural
- **Adapter**: Integration with legacy systems
- **Decorator**: Dynamic feature addition
- **Facade**: Simplified complex operations
- **Proxy**: Performance optimization

### Behavioral
- **Observer**: Decoupled notification system
- **Strategy**: Flexible rendering options
- **Template Method**: Consistent workflow with customization
