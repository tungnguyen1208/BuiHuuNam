# Sơ Đồ Minh Họa Các Mẫu Thiết Kế – Hệ Thống Blog

## 1. Tổng quan quan hệ chính (Mermaid)
```mermaid
flowchart LR
  subgraph Creational
    A[BlogConfiguration (Singleton)]
    B[BlogPostFactory (Factory Method)]
    C[UIComponentFactory (Abstract Factory)]
    D[BlogPostBuilder (Builder)]
    E[BlogPostPrototype (Prototype)]
  end
  subgraph Structural
    F[LegacyBlogAdapter (Adapter)]
    G[BlogRenderer (Bridge)]
    H[CommentComponent (Composite)]
    I[BlogPostDecorator (Decorator)]
    J[BlogManagementFacade (Facade)]
    K[BlogPostProxy (Proxy)]
  end
  subgraph Behavioral
    L[BlogSubscriber (Observer)]
  end

  B -->|tạo| Post[BlogPost]
  D -->|xây dựng| Post
  E -->|clone| Post
  J -->|phối hợp| B
  J -->|phối hợp| L
  K -->|đại diện truy cập| Post
  I -->|bọc| Post
  F -->|chuyển đổi| Post
  G -->|render| Post
  H -->|quản lý| Comment[Comment Tree]
  L -->|nhận thông báo| Post
```

## 2. Factory Method (các triển khai)
```mermaid
classDiagram
    class BlogPostFactory {
        +createPost(title, content, author)
        +createAndPublish(...)
    }
    class TechnicalBlogPostFactory
    class TutorialBlogPostFactory
    class NewsBlogPostFactory
    BlogPostFactory <|-- TechnicalBlogPostFactory
    BlogPostFactory <|-- TutorialBlogPostFactory
    BlogPostFactory <|-- NewsBlogPostFactory
```

## 3. Abstract Factory giao diện UI
```mermaid
classDiagram
    class UIComponentFactory {
      +createButton()
      +createTextField()
      +createPanel()
    }
    class DarkThemeFactory
    class LightThemeFactory
    UIComponentFactory <|-- DarkThemeFactory
    UIComponentFactory <|-- LightThemeFactory
```

## 4. Decorator xếp chồng
```mermaid
graph LR
  Base[BlogPost] --> SEO[SEODecorator]
  SEO --> Share[SocialMediaDecorator]
  Share --> ReadTime[ReadingTimeDecorator]
  ReadTime --> Ad[AdDecorator]
```

## 5. Proxy các biến thể
```mermaid
flowchart LR
  Client --> CProxy[CachingBlogPostProxy]
  Client --> PProxy[ProtectedBlogPostProxy]
  Client --> LProxy[LoggingBlogPostProxy]
  CProxy --> Real[RealBlogPostService]
  PProxy --> Real
  LProxy --> Real
```

## 6. Observer thông báo đa kênh
```mermaid
flowchart LR
  BlogSubject[Blog] --> EmailSub[EmailSubscriber]
  BlogSubject --> SMSSub[SMSSubscriber]
  BlogSubject --> PushSub[PushNotificationSubscriber]
  BlogSubject --> RSSSub[RSSFeedSubscriber]
```

## 7. Composite cây bình luận
```mermaid
flowchart TB
  Thread[CommentThread Root]
  Thread --> C1[SingleComment]
  Thread --> Reply1[CommentThread]
  Reply1 --> C2[SingleComment]
  Reply1 --> C3[SingleComment]
```

## 8. Bridge renderer + platform
```mermaid
classDiagram
  class BlogRenderer {
    +render(post)
    -platform: RenderingPlatform
  }
  class DetailedBlogRenderer
  class SummaryBlogRenderer
  BlogRenderer <|-- DetailedBlogRenderer
  BlogRenderer <|-- SummaryBlogRenderer
  class RenderingPlatform {
    +renderTitle()
    +renderAuthor()
    +renderDate()
    +renderContent()
    +renderTags()
  }
  class HTMLPlatform
  class MarkdownPlatform
  class PlainTextPlatform
  RenderingPlatform <|-- HTMLPlatform
  RenderingPlatform <|-- MarkdownPlatform
  RenderingPlatform <|-- PlainTextPlatform
```

## 9. Facade phối hợp subsystem
```mermaid
flowchart LR
  Facade[BlogManagementFacade] --> PostMgr[PostManager]
  Facade --> CommentMgr[CommentManager]
  Facade --> UserMgr[UserManager]
  Facade --> Notif[NotificationService]
  Facade --> Search[SearchService]
```

## Ghi chú
- Các sơ đồ nhằm minh họa ý tưởng – không nhất thiết phản ánh mọi phương thức.
- Có thể mở rộng thêm sơ đồ Sequence cho luồng "publish bài".

## Liên kết
- `README.md`
- `PATTERNS_SUMMARY.md`
- `DESIGN_PATTERNS_PROBLEMS.md`
- `BAI_TOAN_CHI_TIET.md`
