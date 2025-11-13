# 2 Forms Sử Dụng Cả 12 Design Patterns

## Tổng Quan

Dự án này bao gồm **2 forms** hoàn chỉnh, mỗi form sử dụng **TẤT CẢ 12 Design Patterns** của Gang of Four.

### Form 1: Post Submission Form (Form Đăng Bài Viết)
**Mục đích:** Form để tạo và đăng bài viết blog mới

**File:**
- Frontend: `src/main/webapp/forms/post-submission-form.html`
- Backend Controller: `src/main/java/com/blog/patterns/forms/PostSubmissionController.java`

### Form 2: Blog Settings Form (Form Cấu Hình Blog)
**Mục đích:** Form để cấu hình các thiết lập toàn cục của blog

**File:**
- Frontend: `src/main/webapp/forms/blog-settings-form.html`
- Backend Controller: `src/main/java/com/blog/patterns/forms/BlogSettingsController.java`

---

## Chi Tiết Cách Sử Dụng 12 Patterns Trong Mỗi Form

### FORM 1: POST SUBMISSION FORM

#### 1. **Singleton Pattern** - Cấu Hình Toàn Cục
```java
BlogConfiguration config = BlogConfiguration.getInstance();
String blogName = config.getSetting("blogName");
```
**Ứng dụng:** Truy cập cấu hình toàn cục của blog (tên blog, theme, language)

#### 2. **Factory Method Pattern** - Tạo Post Theo Loại
```java
PostFactory factory = new TechnicalPostFactory();  // or LifestylePostFactory
BlogPost post = factory.createPost(title, content, author);
```
**Ứng dụng:** Người dùng chọn loại bài viết (Technical/Lifestyle/News), factory tự động tạo post với cấu hình phù hợp

#### 3. **Abstract Factory Pattern** - Theme UI Components
```java
UIComponentFactory uiFactory = new ModernUIFactory();  // or ClassicUIFactory
Button button = uiFactory.createButton();
Header header = uiFactory.createHeader();
Footer footer = uiFactory.createFooter();
```
**Ứng dụng:** Người dùng chọn theme (Modern/Classic), tất cả UI components tự động match với theme đó

#### 4. **Builder Pattern** - Xây Dựng Blog Post
```java
BlogPost post = new BlogPostBuilder()
    .setTitle(formData.getTitle())
    .setAuthor(formData.getAuthor())
    .setContent(formData.getContent())
    .addTag("java")
    .addTag("programming")
    .build();
```
**Ứng dụng:** Xây dựng blog post từng bước với nhiều thuộc tính tùy chọn

#### 5. **Prototype Pattern** - Load Template
```java
BlogPost templatePost = prototypeRegistry.createPost(
    "technical",  // Clone from technical template
    title, content, author
);
```
**Ứng dụng:** Button "Load Template" cho phép clone từ template có sẵn

#### 6. **Adapter Pattern** - Convert Content Format
```java
if (format.equals("markdown")) {
    ContentRenderer adapter = new MarkdownAdapter();
    String html = adapter.render(markdownContent);
}
```
**Ứng dụng:** Người dùng có thể nhập content dạng Markdown, adapter tự động convert sang HTML

#### 7. **Decorator Pattern** - Thêm Features
```java
BlogPostComponent post = new BasicBlogPost(blogPost);
if (enableComments) {
    post = new CommentDecorator(post, 0);
}
if (enableLikes) {
    post = new LikeDecorator(post, 0);
}
```
**Ứng dụng:** Checkboxes cho phép bật/tắt comments và likes động

#### 8. **Facade Pattern** - Đơn Giản Hóa Publishing
```java
BlogManagementFacade facade = new BlogManagementFacade();
facade.publishPost(post);  // Internally: validate -> save -> index -> notify
```
**Ứng dụng:** Button "Xuất Bản" gọi facade, che giấu các bước phức tạp (validate, save, index, notify)

#### 9. **Proxy Pattern** - Lazy Loading
```java
PostContent content = new PostContentProxy(postId);
// Content chỉ load khi gọi getContent() lần đầu
String text = content.getContent();
```
**Ứng dụng:** Checkbox "Lazy load nội dung" quyết định có dùng proxy hay không

#### 10. **Observer Pattern** - Thông Báo Subscribers
```java
BlogPublisher publisher = new BlogPublisher();
if (notifyEmail) {
    publisher.subscribe(new EmailSubscriber("user@example.com"));
}
if (notifySMS) {
    publisher.subscribe(new SMSSubscriber("+1234567890"));
}
publisher.publishPost(post);  // Notify all subscribers
```
**Ứng dụng:** Checkboxes chọn kênh thông báo (Email, SMS) khi post được publish

#### 11. **Strategy Pattern** - Rendering Strategy
```java
ContentRenderer renderer = new ContentRenderer();
renderer.setStrategy(new HTMLRenderingStrategy());  // or JSON, PlainText
String output = renderer.renderContent(content);
```
**Ứng dụng:** Dropdown chọn format output (HTML/JSON/Plain Text)

#### 12. **Template Method Pattern** - Publishing Workflow
```java
PostPublishingTemplate publisher = new TechnicalPostPublisher();
publisher.publishPost(post);
// Workflow: validate -> format -> save -> notify -> (optional) featured
```
**Ứng dụng:** Workflow publish được định nghĩa sẵn, các bước cụ thể tùy loại post

---

### FORM 2: BLOG SETTINGS FORM

#### 1. **Singleton Pattern** - Global Configuration
```java
BlogConfiguration config = BlogConfiguration.getInstance();
config.setSetting("blogName", formData.getBlogName());
config.setSetting("language", formData.getLanguage());
config.setSetting("postsPerPage", formData.getPostsPerPage());
```
**Ứng dụng:** Cập nhật cấu hình toàn cục: tên blog, ngôn ngữ, số bài/trang, múi giờ

#### 2. **Factory Method Pattern** - Default Post Type
```java
PostFactory defaultFactory = createFactoryByType(formData.getDefaultPostType());
```
**Ứng dụng:** Dropdown chọn loại bài viết mặc định (Technical/Lifestyle/News)

#### 3. **Abstract Factory Pattern** - UI Theme
```java
UIComponentFactory uiFactory;
if (theme.equals("modern")) {
    uiFactory = new ModernUIFactory();
} else {
    uiFactory = new ClassicUIFactory();
}
```
**Ứng dụng:** Dropdown chọn theme, xem preview các UI components tương ứng

#### 4. **Builder Pattern** - Advanced Settings
```java
AdvancedSettings settings = new AdvancedSettingsBuilder()
    .setSeoTitleTemplate(formData.getSeoTitle())
    .setPermalinkFormat(formData.getPermalinkFormat())
    .setCacheExpiry(formData.getCacheExpiry())
    .setMaxImageSize(formData.getMaxImageSize())
    .build();
```
**Ứng dụng:** Build complex settings object từ nhiều fields (SEO, permalink, cache, image size)

#### 5. **Prototype Pattern** - Default Settings Template
```java
if (loadDefaults) {
    BlogSettingsFormData defaults = prototypeRegistry.getDefaultSettings();
    // Apply defaults
}
```
**Ứng dụng:** Button "Load Defaults" clone settings từ template mặc định

#### 6. **Adapter Pattern** - Content Format Support
```java
if (supportMarkdown) {
    ContentRenderer adapter = new MarkdownAdapter();
    // Enable markdown support
}
```
**Ứng dụng:** Checkbox bật/tắt hỗ trợ Markdown format (qua Adapter)

#### 7. **Decorator Pattern** - Default Features
```java
Map<String, Boolean> features = new HashMap<>();
features.put("comments", enableCommentsGlobal);
features.put("likes", enableLikesGlobal);
features.put("share", enableShare);
features.put("reactions", enableReactions);
```
**Ứng dụng:** Checkboxes cấu hình features mặc định cho tất cả bài viết

#### 8. **Facade Pattern** - Apply All Settings
```java
ConfigurationFacade facade = new ConfigurationFacade();
facade.applySettings(formData);
// Internally: validate -> save -> cache -> reload
```
**Ứng dụng:** Button "Lưu Cấu Hình" gọi facade để apply tất cả settings một lần

#### 9. **Proxy Pattern** - Lazy Loading Settings
```java
Map<String, Boolean> lazyLoad = new HashMap<>();
lazyLoad.put("content", lazyLoadContent);
lazyLoad.put("images", lazyLoadImages);
lazyLoad.put("comments", lazyLoadComments);
```
**Ứng dụng:** Checkboxes cấu hình lazy loading cho content/images/comments

#### 10. **Observer Pattern** - Notification Channels
```java
SettingsChangePublisher publisher = new SettingsChangePublisher();
if (notifyEmail) publisher.addSubscriber(new EmailObserver());
if (notifySMS) publisher.addSubscriber(new SMSObserver());
if (notifyPush) publisher.addSubscriber(new PushObserver());
if (notifyRSS) publisher.addSubscriber(new RSSObserver());
publisher.notifyConfigurationChange("Settings updated");
```
**Ứng dụng:** Checkboxes chọn kênh thông báo khi có bài viết mới

#### 11. **Strategy Pattern** - Default Rendering Strategy
```java
RenderingStrategy strategy;
if (renderStrategy.equals("html")) {
    strategy = new HTMLRenderingStrategy();
} else if (renderStrategy.equals("json")) {
    strategy = new JSONRenderingStrategy();
} else {
    strategy = new PlainTextStrategy();
}
```
**Ứng dụng:** Radio buttons chọn rendering strategy mặc định

#### 12. **Template Method Pattern** - Publishing Workflow Config
```java
PublishingWorkflowConfig workflow = new PublishingWorkflowConfig();
workflow.setAutoFormat(autoFormat);
workflow.setAutoIndex(autoIndex);
workflow.setAutoNotify(autoNotify);
workflow.setPublishMode(publishMode);
```
**Ứng dụng:** Checkboxes cấu hình các bước trong publishing workflow

---

## Cách Chạy Demo

### 1. Compile Project
```bash
mvn clean compile
```

### 2. Run Forms Demo
```bash
mvn exec:java -Dexec.mainClass="com.blog.patterns.forms.FormsDemo"
```

### 3. Xem Forms Trong Browser
Mở các file HTML trong trình duyệt:
- `src/main/webapp/forms/post-submission-form.html`
- `src/main/webapp/forms/blog-settings-form.html`

---

## Cấu Trúc Files

```
src/
├── main/
│   ├── java/com/blog/patterns/
│   │   ├── forms/
│   │   │   ├── PostSubmissionController.java      # Controller cho Form 1
│   │   │   ├── BlogSettingsController.java        # Controller cho Form 2
│   │   │   └── FormsDemo.java                     # Demo chạy cả 2 forms
│   │   ├── creational/        # 5 Creational patterns
│   │   ├── structural/        # 4 Structural patterns
│   │   ├── behavioral/        # 3 Behavioral patterns
│   │   └── models/            # Model classes
│   └── webapp/
│       └── forms/
│           ├── post-submission-form.html          # Form 1 HTML
│           └── blog-settings-form.html            # Form 2 HTML
```

---

## Tính Năng Của Mỗi Form

### Form 1: Post Submission Form

**Input Fields:**
- Title (text) - Builder
- Author (text) - Builder
- Post Type (dropdown) - Factory Method
- Content Format (dropdown) - Strategy + Adapter
- Content (textarea) - Builder
- Tags (dynamic list) - Builder
- Theme (dropdown) - Abstract Factory
- Enable Comments (checkbox) - Decorator
- Enable Likes (checkbox) - Decorator
- Lazy Load (checkbox) - Proxy
- Notify Email (checkbox) - Observer
- Notify SMS (checkbox) - Observer

**Buttons:**
- "Xuất Bản" - Uses Facade + Template Method
- "Load Template" - Uses Prototype

### Form 2: Blog Settings Form

**Sections:**
1. **Global Configuration** (Singleton)
   - Blog Name, Language, Posts Per Page, Timezone

2. **UI Theme** (Abstract Factory)
   - Theme selection with preview

3. **Default Post Settings** (Factory Method + Prototype)
   - Default post type, Templates

4. **Rendering Configuration** (Strategy + Adapter)
   - Rendering strategy, Format support

5. **Features** (Decorator)
   - Default features for posts

6. **Performance** (Proxy)
   - Lazy loading settings

7. **Notifications** (Observer)
   - Notification channels

8. **Publishing** (Facade + Template Method)
   - Publishing workflow, Publish mode

9. **Advanced** (Builder)
   - SEO, Permalink, Cache, Image size

**Buttons:**
- "Lưu Cấu Hình" - Uses Facade
- "Load Defaults" - Uses Prototype
- "Reset" - Reset form

---

## So Sánh 2 Forms

| Aspect | Form 1 (Post Submission) | Form 2 (Blog Settings) |
|--------|--------------------------|------------------------|
| **Mục đích** | Tạo bài viết mới | Cấu hình blog |
| **Singleton** | Read config | Update config |
| **Factory Method** | Choose post type | Set default type |
| **Abstract Factory** | Select theme for post | Set global theme |
| **Builder** | Build BlogPost | Build AdvancedSettings |
| **Prototype** | Load post template | Load default settings |
| **Adapter** | Convert Markdown content | Enable Markdown support |
| **Decorator** | Add features to post | Set default features |
| **Facade** | Publish post | Apply all settings |
| **Proxy** | Lazy load content | Configure lazy loading |
| **Observer** | Notify for this post | Configure channels |
| **Strategy** | Choose render format | Set default strategy |
| **Template Method** | Execute workflow | Configure workflow |

---

## Kết Luận

Cả 2 forms đều:
- ✅ Sử dụng đầy đủ 12 Design Patterns
- ✅ Có giao diện HTML đẹp, responsive
- ✅ Có backend controller xử lý logic
- ✅ Có demo code hoạt động hoàn chỉnh
- ✅ Được document chi tiết

Mỗi form giải quyết một bài toán khác nhau trong hệ thống blog và demonstrate cách các patterns làm việc cùng nhau trong thực tế.
