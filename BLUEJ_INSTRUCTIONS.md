# Hướng Dẫn Chạy Code Trong BlueJ

## Tổng Quan

Dự án này là Maven project với cấu trúc phức tạp. BlueJ thường được dùng cho các project đơn giản hơn, nhưng bạn vẫn có thể chạy code theo các cách sau:

---

## CÁCH 1: Chạy Trực Tiếp Các Class Demo (Đơn Giản Nhất)

### Bước 1: Mở Project Trong BlueJ

1. Mở BlueJ
2. **Project → Open Non-BlueJ...** 
3. Chọn folder: `/src/main/java/com/blog/patterns`
4. BlueJ sẽ import tất cả các Java files

### Bước 2: Compile Project

1. Trong BlueJ, click **Compile** (hoặc Ctrl+K)
2. Đợi tất cả các class được compile

### Bước 3: Chạy Demo Classes

#### A. Chạy Demo Chính (12 Design Patterns)

1. Tìm class `DesignPatternsDemo` trong BlueJ
2. Right-click → chọn **void main(String[] args)**
3. Click **OK** để chạy
4. Xem output trong BlueJ Terminal

#### B. Chạy Demo 2 Forms

1. Tìm class `FormsDemo` trong package `forms`
2. Right-click → chọn **void main(String[] args)**
3. Click **OK**
4. Xem output hiển thị cách 2 forms sử dụng 12 patterns

### Bước 4: Test Từng Pattern Riêng Lẻ

Bạn có thể test từng pattern một cách độc lập:

**Singleton Pattern:**
```java
1. Tìm class "BlogConfiguration"
2. Right-click → chọn "BlogConfiguration getInstance()"
3. Lưu object vào Object Bench
4. Right-click object → chọn "void displaySettings()"
```

**Factory Method Pattern:**
```java
1. Tạo instance của "TechnicalPostFactory"
2. Right-click → chọn "BlogPost createPost(...)"
3. Nhập parameters: title, content, author
4. Xem BlogPost được tạo ra
```

**Builder Pattern:**
```java
1. Tạo instance của "BlogPostBuilder"
2. Gọi các methods: setTitle(), setAuthor(), setContent()
3. Cuối cùng gọi build() để tạo BlogPost
```

---

## CÁCH 2: Export Thành JAR File Và Chạy

### Bước 1: Build JAR File Bằng Maven (Ngoài BlueJ)

Mở Command Prompt/Terminal tại thư mục project:

```bash
cd /path/to/BuiHuuNam
mvn clean package
```

JAR file sẽ được tạo tại: `target/design-patterns-blog-1.0-SNAPSHOT.jar`

### Bước 2: Chạy JAR File

```bash
# Chạy demo chính
java -cp target/design-patterns-blog-1.0-SNAPSHOT.jar com.blog.patterns.DesignPatternsDemo

# Chạy forms demo
java -cp target/design-patterns-blog-1.0-SNAPSHOT.jar com.blog.patterns.forms.FormsDemo
```

---

## CÁCH 3: Tạo BlueJ Project Từ Đầu (Nếu Import Không Work)

### Bước 1: Tạo New Project Trong BlueJ

1. **Project → New Project**
2. Đặt tên: "BlogDesignPatterns"

### Bước 2: Copy Source Files

1. Copy tất cả files từ `src/main/java/com/blog/patterns/` 
2. Paste vào thư mục project BlueJ của bạn
3. Giữ nguyên cấu trúc thư mục:
   ```
   BlogDesignPatterns/
   ├── com/
   │   └── blog/
   │       └── patterns/
   │           ├── behavioral/
   │           ├── creational/
   │           ├── structural/
   │           ├── models/
   │           ├── forms/
   │           └── DesignPatternsDemo.java
   ```

### Bước 3: Compile và Run

1. Mở project trong BlueJ
2. Click **Compile All**
3. Run các demo classes như hướng dẫn ở Cách 1

---

## CÁCH 4: Xem HTML Forms Trong Browser

Forms không cần BlueJ để chạy:

1. Mở Windows Explorer/Finder
2. Navigate đến: `src/main/webapp/forms/`
3. Double-click file HTML:
   - `post-submission-form.html` - Form đăng bài viết
   - `blog-settings-form.html` - Form cấu hình blog
4. Forms sẽ mở trong browser mặc định
5. Bạn có thể điền form và submit để xem demo

**Lưu ý:** Forms chỉ demo frontend. Backend xử lý nằm trong Java controllers.

---

## Các Class Quan Trọng Để Test

### 1. Creational Patterns

| Class | Location | Cách Test |
|-------|----------|-----------|
| BlogConfiguration | `creational/` | `getInstance()` → `displaySettings()` |
| TechnicalPostFactory | `creational/` | `createPost(title, content, author)` |
| BlogPostBuilder | `creational/` | Chain methods → `build()` |
| PostPrototypeRegistry | `creational/` | `createPost(type, title, content, author)` |
| ModernUIFactory | `creational/` | `createButton()`, `createHeader()`, `createFooter()` |

### 2. Structural Patterns

| Class | Location | Cách Test |
|-------|----------|-----------|
| MarkdownAdapter | `structural/` | `render(markdownContent)` |
| CommentDecorator | `structural/` | Wrap BasicBlogPost → `display()` |
| BlogManagementFacade | `structural/` | `publishPost(post)` |
| PostContentProxy | `structural/` | `getContent()` |

### 3. Behavioral Patterns

| Class | Location | Cách Test |
|-------|----------|-----------|
| BlogPublisher | `behavioral/` | `subscribe()` → `publishPost()` |
| ContentRenderer | `behavioral/` | `setStrategy()` → `renderContent()` |
| TechnicalPostPublisher | `behavioral/` | `publishPost(post)` |

---

## Troubleshooting

### Vấn Đề 1: BlueJ Không Nhận Diện Package Structure

**Giải pháp:**
- Đảm bảo bạn mở đúng thư mục chứa `com` folder
- Hoặc copy từng file vào BlueJ bằng tay

### Vấn Đề 2: Compile Errors

**Giải pháp:**
- Compile theo thứ tự:
  1. `models/` (BlogPost, BlogSubscriber)
  2. `creational/`
  3. `structural/`
  4. `behavioral/`
  5. `forms/`
  6. `DesignPatternsDemo`

### Vấn Đề 3: Cannot Find Main Method

**Giải pháp:**
- Đảm bảo class có method: `public static void main(String[] args)`
- Right-click chính xác vào method `main`

### Vấn Đề 4: Dependencies Not Found

**Giải pháp:**
BlueJ không hỗ trợ Maven dependencies tốt. Project này không dùng external libraries nên không có vấn đề này.

---

## Output Mẫu

Khi chạy `DesignPatternsDemo.main()`, bạn sẽ thấy:

```
==============================================
   BLOG WEBSITE - 12 DESIGN PATTERNS DEMO   
==============================================

### 1. SINGLETON PATTERN ###
Purpose: Ensure only one instance of BlogConfiguration exists

=== Blog Configuration (Singleton) ===
blogName: My Awesome Blog
postsPerPage: 10
theme: modern
language: en
Are both instances same? true

### 2. FACTORY METHOD PATTERN ###
...
(12 patterns demo output)
```

Khi chạy `FormsDemo.main()`, bạn sẽ thấy:

```
╔═══════════════════════════════════════════╗
║   DEMO: 2 FORMS USING ALL 12 PATTERNS    ║
╚═══════════════════════════════════════════╝

Form 1: POST SUBMISSION FORM
Processing with all 12 patterns...
✅ Success!

Form 2: BLOG SETTINGS FORM
Processing with all 12 patterns...
✅ Success!
```

---

## Tài Liệu Tham Khảo

- `README.md` - Hướng dẫn tổng quan
- `BAI_TOAN_CHI_TIET.md` - Mô tả chi tiết từng pattern
- `PATTERNS_SUMMARY.md` - Tóm tắt patterns
- `FORMS_DOCUMENTATION.md` - Hướng dẫn về 2 forms

---

## Kết Luận

**Cách Dễ Nhất:**
1. Mở BlueJ
2. Import project từ `src/main/java/com/blog/patterns`
3. Compile
4. Run `DesignPatternsDemo.main()` hoặc `FormsDemo.main()`

**Cách Tốt Nhất:**
- Dùng IDE khác như IntelliJ IDEA, Eclipse, hoặc VS Code
- Chạy với Maven: `mvn exec:java -Dexec.mainClass="..."`

BlueJ tốt cho học tập nhưng không lý tưởng cho Maven projects lớn như project này.
