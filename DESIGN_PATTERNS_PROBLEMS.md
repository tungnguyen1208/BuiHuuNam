# Mô tả bài toán của từng Mẫu Thiết Kế (Design Patterns)

Tài liệu này mô tả ngắn gọn “bài toán” (vấn đề cần giải quyết) của từng mẫu thiết kế được minh họa trong dự án, kèm ngữ cảnh áp dụng và liên hệ tới các lớp trong mã nguồn.

---

## Creational Patterns (Nhóm khởi tạo)

### 1) Factory Method
- Bài toán: Cần tạo ra các đối tượng cùng “kiểu khái niệm” (ví dụ: bài viết) nhưng khác biến thể (kỹ thuật, hướng dẫn, tin tức) mà không để client phụ thuộc vào lớp khởi tạo cụ thể.
- Khi áp dụng: Khi logic khởi tạo thay đổi theo biến thể/loại, cần đóng gói việc khởi tạo và cho phép mở rộng dễ dàng.
- Trong dự án: `BlogPostFactory` (trừu tượng) và các triển khai trong `BlogPostFactoryProvider.java` (`TechnicalBlogPostFactory`, `TutorialBlogPostFactory`, `NewsBlogPostFactory`).

### 2) Abstract Factory
- Bài toán: Cần tạo ra “họ” (family) các đối tượng liên quan/phụ thuộc lẫn nhau (nút, ô nhập, panel) để bảo đảm tính nhất quán theo chủ đề (Dark/Light) mà không phụ thuộc vào lớp cụ thể.
- Khi áp dụng: Khi UI hoặc các thành phần phải đi theo bộ chủ đề/nhà cung cấp và cần hoán đổi cả bộ một cách đồng nhất.
- Trong dự án: `UIComponentFactory` cùng các biến thể `DarkThemeFactory`, `LightThemeFactory` và `UIComponentFactoryProvider`.

### 3) Builder
- Bài toán: Cần khởi tạo đối tượng phức tạp (nhiều thuộc tính, có thuộc tính tùy chọn) một cách an toàn, dễ đọc, và linh hoạt theo từng bước.
- Khi áp dụng: Khi hàm khởi tạo có quá nhiều tham số, nhiều cấu hình tùy chọn, hoặc cần xây dựng dần theo từng bước.
- Trong dự án: `BlogPostBuilder`.

### 4) Prototype
- Bài toán: Cần tạo nhanh các đối tượng mới dựa trên việc sao chép (clone) từ các “mẫu” có sẵn thay vì khởi tạo và cấu hình lại từ đầu.
- Khi áp dụng: Khi chi phí tạo mới lớn hoặc cấu hình lặp lại nhiều; cần nhân bản từ mẫu chuẩn.
- Trong dự án: `BlogPostPrototype` quản lý các prototype như `standard`, `technical`, `tutorial`.

### 5) Singleton
- Bài toán: Cần đúng một (và chỉ một) thể hiện toàn cục quản lý cấu hình/trạng thái dùng chung trong toàn ứng dụng.
- Khi áp dụng: Khi tài nguyên/cấu hình dùng chung cần đồng nhất, kiểm soát truy cập tập trung.
- Trong dự án: `BlogConfiguration`.

---

## Structural Patterns (Nhóm cấu trúc)

### 6) Adapter
- Bài toán: Tích hợp hệ thống cũ (API/kiểu dữ liệu khác) vào hệ thống mới mà không thể (hoặc không muốn) sửa mã phía cũ.
- Khi áp dụng: Khi có sự không tương thích giao diện giữa hai hệ thống nhưng vẫn cần tái sử dụng chức năng cũ.
- Trong dự án: `LegacyBlogAdapter` chuyển đổi giữa `LegacyBlogSystem`/`LegacyPost` và mô hình `BlogPost`; `LegacyBlogAdapterFactory` hỗ trợ tạo adapter.

### 7) Facade
- Bài toán: Ẩn đi sự phức tạp của nhiều phân hệ con, cung cấp một giao diện đơn giản, “một cửa” cho các luồng nghiệp vụ thường dùng.
- Khi áp dụng: Khi client không cần biết chi tiết nhiều subsystem, chỉ cần các tác vụ cấp cao.
- Trong dự án: `BlogManagementFacade` gói `PostManager`, `CommentManager`, `UserManager`, `NotificationService`, `SearchService`.

### 8) Decorator
- Bài toán: Cần bổ sung tính năng/“trang trí” động cho đối tượng (trước/sau) mà không sửa đổi lớp gốc và vẫn có thể xếp chồng nhiều phần mở rộng.
- Khi áp dụng: Khi số lượng kết hợp tính năng lớn, không muốn tạo nhiều lớp con cố định.
- Trong dự án: `BlogPostDecorator` và các decorator cụ thể `SEODecorator`, `SocialMediaDecorator`, `ReadingTimeDecorator`, `AdDecorator`; kèm `BlogPostDecoratorFactory`.

### 9) Proxy
- Bài toán: Cần một lớp “đại diện” kiểm soát truy cập đối tượng thật (thêm cache, ghi log, phân quyền, trì hoãn khởi tạo…) mà không đổi giao diện client.
- Khi áp dụng: Khi muốn chặn/trang bị thêm trước khi gọi đối tượng thật, hoặc tối ưu hiệu năng.
- Trong dự án: `BlogPostService` (giao diện), `RealBlogPostService` (thật), các proxy `CachingBlogPostProxy`, `ProtectedBlogPostProxy`, `LoggingBlogPostProxy`; `BlogPostProxyFactory` minh họa sử dụng.

### 10) Bridge
- Bài toán: Tách phần trừu tượng (cái “làm gì”) khỏi phần hiện thực (cái “làm như thế nào”) để hai chiều có thể phát triển độc lập và kết hợp linh hoạt.
- Khi áp dụng: Khi số biến thể của trừu tượng và hiện thực đều nhiều, nếu dùng kế thừa sẽ bùng nổ số lớp.
- Trong dự án: Abstraction `BlogRenderer` với các refined `DetailedBlogRenderer`, `SummaryBlogRenderer`; Implementor `RenderingPlatform` với các hiện thực `HTMLPlatform`, `MarkdownPlatform`, `PlainTextPlatform`; `BlogRendererFactory` tạo tổ hợp.

### 11) Composite
- Bài toán: Cần xử lý cấu trúc cây (phần–tổng thể) để client tương tác thống nhất với cả lá và nút tổng hợp.
- Khi áp dụng: Khi dữ liệu phân cấp (ví dụ: bình luận và các trả lời lồng nhau) cần thao tác như một thể thống nhất.
- Trong dự án: `CommentComponent` (trừu tượng), `SingleComment` (lá), `CommentThread` (tổ hợp).

---

## Behavioral Patterns (Nhóm hành vi)

### 12) Observer
- Bài toán: Khi một đối tượng thay đổi trạng thái (xuất bản bài viết mới), cần tự động thông báo cho nhiều đối tượng quan tâm mà không tạo phụ thuộc chặt giữa chúng.
- Khi áp dụng: Khi cần cơ chế pub/sub, event-driven giữa chủ thể và các người nghe.
- Trong dự án: `Blog` (Subject) và các Observer: `EmailSubscriber`, `SMSSubscriber`, `PushNotificationSubscriber`, `RSSFeedSubscriber`; `BlogSubscriberFacade` hỗ trợ đăng ký thuận tiện.

---

## Gợi ý sử dụng nhanh
- Xác định vấn đề bạn đang gặp (khởi tạo phức tạp? tích hợp hệ cũ? thêm tính năng động?).
- Tra cứu mẫu tương ứng ở trên để chọn giải pháp phù hợp.
- Tham chiếu trực tiếp tới các lớp trong thư mục `src/main/java/com/blog/designpatterns/**` để xem cách áp dụng thực tế.
