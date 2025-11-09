# Bài Toán Chi Tiết – 12 Mẫu Thiết Kế trong Hệ Thống Blog

Tài liệu này trình bày chi tiết bài toán, giải pháp, ví dụ áp dụng trong hệ thống blog, và lợi ích của từng mẫu. Cuối cùng là bảng so sánh và các ví dụ kết hợp nhiều mẫu trong cùng luồng nghiệp vụ.

---

## 1) Singleton — BlogConfiguration
- Bài toán cụ thể:
  - Cần một nguồn cấu hình dùng chung, đồng nhất cho toàn ứng dụng (tên blog, số bài/trang, theme, bật/tắt bình luận…). Nếu tạo nhiều thể hiện có thể gây lệch cấu hình.
- Giải pháp của mẫu:
  - Ẩn hàm tạo (private constructor), cung cấp phương thức truy cập tĩnh `getInstance()` để bảo đảm chỉ có một thể hiện, kèm đồng bộ khi cần.
  - Liên hệ mã: `BlogConfiguration`.
- Ví dụ trong blog:
  - Tất cả nơi hiển thị và xử lý đọc `postsPerPage`, `theme`… từ `BlogConfiguration.getInstance()`.
- Lợi ích:
  - Nhất quán cấu hình, dễ kiểm soát; tránh trùng lặp bộ nhớ; điểm tập trung để thay đổi.

## 2) Factory Method — BlogPostFactory (+ Provider)
- Bài toán cụ thể:
  - Cần tạo bài viết theo loại (kỹ thuật, hướng dẫn, tin tức) với quy tắc khởi tạo khác nhau nhưng muốn che giấu lớp cụ thể với client.
- Giải pháp của mẫu:
  - Định nghĩa factory trừu tượng `BlogPostFactory` và các triển khai cụ thể cho từng loại (thêm tag, định dạng ID…).
  - Liên hệ mã: `BlogPostFactory`, `BlogPostFactoryProvider` (chứa `TechnicalBlogPostFactory`, `TutorialBlogPostFactory`, `NewsBlogPostFactory`).
- Ví dụ trong blog:
  - Trang tạo bài chọn “Loại bài viết”, hệ thống gọi factory tương ứng để tạo và publish (`createAndPublish`).
- Lợi ích:
  - Mở rộng dễ dàng (thêm loại mới); giảm phụ thuộc vào lớp khởi tạo cụ thể; gom logic khởi tạo.

## 3) Abstract Factory — UIComponentFactory
- Bài toán cụ thể:
  - Cần tạo cả “họ” thành phần UI (button, text field, panel) theo chủ đề/thương hiệu (Dark/Light) đảm bảo đồng nhất.
- Giải pháp của mẫu:
  - Định nghĩa `UIComponentFactory` và các factory cụ thể `DarkThemeFactory`, `LightThemeFactory` tạo đúng tập thành phần tương ứng.
- Ví dụ trong blog:
  - Người dùng đổi theme; toàn bộ UI được dựng từ factory tương ứng, bảo đảm đồng nhất màu sắc/kiểu dáng.
- Lợi ích:
  - Đổi theme theo lô; giữ tính nhất quán; thay thế nhà cung cấp UI mà không đổi client.

## 4) Builder — BlogPostBuilder
- Bài toán cụ thể:
  - Bài viết có nhiều thuộc tính, phần lớn tùy chọn; khởi tạo bằng constructor dài khó đọc và dễ sai.
- Giải pháp của mẫu:
  - Xây dựng đối tượng theo từng bước qua API rõ ràng (`withTitle`, `withContent`, `addTag`…), cuối cùng `build()`.
  - Liên hệ mã: `BlogPostBuilder`.
- Ví dụ trong blog:
  - Trang soạn thảo có thể thêm/bớt tag, ngày đăng, tác giả… rồi build thành `BlogPost` hoàn chỉnh.
- Lợi ích:
  - Mã dễ đọc; tránh constructor dài; linh hoạt thêm thuộc tính tùy chọn.

## 5) Prototype — BlogPostPrototype
- Bài toán cụ thể:
  - Tạo nhanh các bài viết dựa trên mẫu chuẩn (template) để không phải cấu hình lặp lại.
- Giải pháp của mẫu:
  - Duy trì bộ prototype (standard/technical/tutorial). Tạo bài mới bằng cách clone prototype tương ứng.
  - Liên hệ mã: `BlogPostPrototype`.
- Ví dụ trong blog:
  - Tác giả chọn mẫu “Technical Post Template” để khởi tạo bài có sẵn dàn ý, tag.
- Lợi ích:
  - Tiết kiệm thời gian; đảm bảo nhất quán định dạng; dễ thêm mẫu mới.

## 6) Adapter — LegacyBlogAdapter
- Bài toán cụ thể:
  - Hệ thống cũ (kiểu dữ liệu/phương thức khác) cần tái sử dụng trong hệ thống mới mà không thể sửa mã cũ.
- Giải pháp của mẫu:
  - Tạo lớp adapter chuyển đổi giữa `LegacyBlogSystem`/`LegacyPost` và mô hình hiện tại `BlogPost`.
  - Liên hệ mã: `LegacyBlogAdapter`, `LegacyBlogAdapterFactory`.
- Ví dụ trong blog:
  - Nhập (import) các bài cũ vào hệ thống mới, đọc và lưu bài thông qua adapter.
- Lợi ích:
  - Tận dụng tài sản phần mềm cũ; giảm chi phí chuyển đổi; cô lập khác biệt giao diện.

## 7) Bridge — BlogRenderer (+ RenderingPlatform)
- Bài toán cụ thể:
  - Cần hiển thị bài viết trên nhiều nền tảng (HTML, Markdown, Plain Text) mà không muốn tạo số lớp bùng nổ khi kết hợp các biến thể.
- Giải pháp của mẫu:
  - Tách Abstraction `BlogRenderer` (Detailed/Summary) khỏi Implementor `RenderingPlatform` (HTML/Markdown/PlainText).
  - Liên hệ mã: `BlogRenderer`, `BlogRendererFactory`, `RenderingPlatform` và các triển khai.
- Ví dụ trong blog:
  - Trang chi tiết dùng `DetailedBlogRenderer` + `HTMLPlatform`; trang danh sách dùng `SummaryBlogRenderer` + `MarkdownPlatform`.
- Lợi ích:
  - Hai chiều (renderer và platform) phát triển độc lập; kết hợp linh hoạt.

## 8) Composite — CommentComponent
- Bài toán cụ thể:
  - Quản lý cấu trúc bình luận lồng nhau (comment và reply) sao cho client thao tác thống nhất với cả lá và nút tổng hợp.
- Giải pháp của mẫu:
  - Định nghĩa `CommentComponent` trừu tượng; `SingleComment` (lá) và `CommentThread` (tổ hợp) cùng triển khai giao diện chung.
- Ví dụ trong blog:
  - Hiển thị cây bình luận, đếm tổng số bình luận, thêm/xóa reply ở mọi cấp.
- Lợi ích:
  - Xử lý dữ liệu phân cấp nhất quán; mở rộng cấp độ lồng nhau dễ dàng.

## 9) Decorator — BlogPostDecorator
- Bài toán cụ thể:
  - Cần bổ sung tính năng quanh nội dung (SEO, nút chia sẻ, ước lượng thời gian đọc, quảng cáo) theo cách linh hoạt, có thể chồng nhiều tính năng mà không sửa lớp gốc.
- Giải pháp của mẫu:
  - Xây dựng lớp bọc trừu tượng và các decorator cụ thể; mỗi decorator thêm hành vi trước/sau khi truy cập đối tượng.
  - Liên hệ mã: `BlogPostDecorator`, `SEODecorator`, `SocialMediaDecorator`, `ReadingTimeDecorator`, `AdDecorator`, `BlogPostDecoratorFactory`.
- Ví dụ trong blog:
  - Khi render bài, chồng `SEODecorator` + `SocialMediaDecorator` để thêm meta và nút chia sẻ.
- Lợi ích:
  - Kết hợp tính năng linh hoạt; tránh bùng nổ số lớp con; tuân thủ Open/Closed.

## 10) Facade — BlogManagementFacade
- Bài toán cụ thể:
  - Luồng nghiệp vụ phức tạp cần tương tác nhiều phân hệ (lưu bài, index tìm kiếm, thông báo người theo dõi). Client muốn một API đơn giản, ổn định.
- Giải pháp của mẫu:
  - Cung cấp lớp Facade đóng gói và điều phối các subsystem bên dưới.
  - Liên hệ mã: `BlogManagementFacade` (gọi `PostManager`, `CommentManager`, `UserManager`, `NotificationService`, `SearchService`).
- Ví dụ trong blog:
  - `publishBlogPost(post, author)` thực hiện kiểm tra người dùng, lưu bài, index, gửi thông báo – tất cả qua 1 lệnh.
- Lợi ích:
  - Đơn giản hóa API cho client; cô lập thay đổi subsystem; giảm coupling.

## 11) Proxy — BlogPostProxy (+ RealBlogPostService)
- Bài toán cụ thể:
  - Cần kiểm soát truy cập/điều phối trước khi chạm vào đối tượng thật: cache, phân quyền, ghi log, trì hoãn tải, v.v.
- Giải pháp của mẫu:
  - Tạo lớp proxy triển khai cùng giao diện, chèn thêm hành vi (cache/quyền/logging) rồi ủy quyền cho “real subject”.
  - Liên hệ mã: `BlogPostService`, `RealBlogPostService`, `CachingBlogPostProxy`, `ProtectedBlogPostProxy`, `LoggingBlogPostProxy`, `BlogPostProxyFactory`.
- Ví dụ trong blog:
  - Trang xem bài hay được cache; chỉ admin/editor được cập nhật bài; mọi truy cập được log lại.
- Lợi ích:
  - Cải thiện hiệu năng; tăng bảo mật/kiểm soát; không làm thay đổi client.

## 12) Observer — BlogSubscriber (+ Facade)
- Bài toán cụ thể:
  - Khi có bài mới, cần thông báo ngay cho nhiều kênh (Email, SMS, Push, RSS) mà không muốn phụ thuộc chặt giữa nơi phát và nơi nhận.
- Giải pháp của mẫu:
  - Tách Subject (`Blog`) và các Observer (Email/SMS/Push/RSS). Subject publish sự kiện và notify tới tất cả observer đăng ký.
  - Liên hệ mã: `Blog`, `EmailSubscriber`, `SMSSubscriber`, `PushNotificationSubscriber`, `RSSFeedSubscriber`, `BlogSubscriberFacade`.
- Ví dụ trong blog:
  - Tác giả publish bài -> toàn bộ subscriber nhận thông báo theo kênh đã đăng ký.
- Lợi ích:
  - Mở rộng kênh thông báo dễ dàng; giảm kết nối cứng; kiến trúc hướng sự kiện.

---

## Bảng so sánh nhanh

| Mẫu | Nhóm | Mục tiêu chính | Áp dụng trong blog | Độ phức tạp | Mở rộng |
|-----|------|-----------------|--------------------|-------------|---------|
| Singleton | Khởi tạo | Một thể hiện dùng chung | Cấu hình blog | Thấp | Vừa |
| Factory Method | Khởi tạo | Tạo biến thể đối tượng | Bài viết theo loại | Vừa | Cao |
| Abstract Factory | Khởi tạo | Tạo họ đối tượng liên quan | Bộ UI theo theme | Vừa | Cao |
| Builder | Khởi tạo | Xây dựng đối tượng phức tạp | Bài viết nhiều tùy chọn | Thấp–Vừa | Cao |
| Prototype | Khởi tạo | Clone từ mẫu chuẩn | Mẫu bài viết | Thấp | Vừa |
| Adapter | Cấu trúc | Tương thích hệ cũ–mới | Nhập bài hệ cũ | Thấp–Vừa | Vừa |
| Bridge | Cấu trúc | Tách trừu tượng/hiện thực | Render đa nền tảng | Vừa | Cao |
| Composite | Cấu trúc | Cấu trúc cây phần–tổng thể | Cây bình luận | Vừa | Cao |
| Decorator | Cấu trúc | Thêm tính năng động | SEO/Share/Ads | Vừa | Rất cao |
| Facade | Cấu trúc | Giao diện đơn giản | Publish/Comment/Search | Thấp | Cao |
| Proxy | Cấu trúc | Kiểm soát truy cập/hiệu năng | Cache/Quyền/Log | Vừa | Cao |
| Observer | Hành vi | Pub/Sub sự kiện | Thông báo đa kênh | Thấp–Vừa | Cao |

Ghi chú: “Độ phức tạp” mang tính tương đối trong bối cảnh repo này.

---

## Ví dụ kết hợp các mẫu

1) Luồng xuất bản bài viết (End-to-End)
- Mẫu kết hợp: Facade + Factory Method + Builder + Observer + (tùy chọn) Proxy/Decorator.
- Mô tả:
  - Client gọi `BlogManagementFacade.publishBlogPost`.
  - Tạo bài qua `BlogPostFactory` hoặc dựng chi tiết qua `BlogPostBuilder`.
  - Facade lưu bài, index tìm kiếm, notify qua `Observer` (Email/SMS/Push/RSS).
  - Proxy có thể cache bài đọc nhiều; Decorator thêm SEO/Share khi render.

2) Hiển thị đa nền tảng
- Mẫu kết hợp: Bridge + Decorator.
- Mô tả:
  - Chọn `DetailedBlogRenderer`/`SummaryBlogRenderer` với `HTMLPlatform`/`MarkdownPlatform`.
  - Trước khi render, bọc bài bằng `SEODecorator` hoặc `ReadingTimeDecorator`.

3) Cây bình luận và kiểm soát truy cập
- Mẫu kết hợp: Composite + Proxy (+ Observer cho thông báo tác giả).
- Mô tả:
  - `CommentThread` chứa `SingleComment` nhiều cấp.
  - `ProtectedBlogPostProxy` bảo vệ thao tác cập nhật/xóa bình luận.
  - Thông báo tới tác giả qua Observer khi có bình luận mới (nếu tích hợp).

4) Tích hợp hệ cũ + luồng publish mới
- Mẫu kết hợp: Adapter + Facade + Observer.
- Mô tả:
  - Dữ liệu từ `LegacyBlogSystem` đi qua `LegacyBlogAdapter` thành `BlogPost`.
  - Facade publish lại bài; hệ thống thông báo subscriber qua Observer.

5) Giao diện người dùng theo chủ đề
- Mẫu kết hợp: Abstract Factory + Bridge.
- Mô tả:
  - `UIComponentFactory` tạo giao diện Dark/Light; nội dung bài render qua `BlogRenderer` phù hợp nền tảng.

---

## Liên kết
- `README.md`
- `PATTERNS_SUMMARY.md`
- `PATTERNS_DIAGRAM.md`
- `DESIGN_PATTERNS_PROBLEMS.md`
