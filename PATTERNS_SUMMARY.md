# Tóm Tắt Nhanh 12 Mẫu Thiết Kế (Design Patterns) – Hệ Thống Blog

| # | Mẫu | Mục đích ngắn gọn | Lớp/chính trong dự án | Tình huống ví dụ |
|---|-----|-------------------|------------------------|------------------|
| 1 | Singleton | Một thể hiện cấu hình dùng chung | `BlogConfiguration` | Đọc theme, số bài/trang |
| 2 | Factory Method | Tạo bài viết theo loại cụ thể | `BlogPostFactory` + các factory con | Bài kỹ thuật/tin tức/hướng dẫn |
| 3 | Abstract Factory | Tạo “họ” thành phần UI thống nhất | `UIComponentFactory` | Giao diện dark vs light |
| 4 | Builder | Xây dựng bài viết phức tạp từng bước | `BlogPostBuilder` | Bài nhiều tag, ngày tùy chỉnh |
| 5 | Prototype | Nhân bản từ mẫu chuẩn có sẵn | `BlogPostPrototype` | Tạo nhanh bài theo template |
| 6 | Adapter | Tích hợp hệ thống blog cũ khác API | `LegacyBlogAdapter` | Dùng dữ liệu bài viết cũ |
| 7 | Bridge | Tách hiển thị khỏi nền tảng cụ thể | `BlogRenderer` + `RenderingPlatform` | Render HTML / Markdown |
| 8 | Composite | Mô hình cây bình luận lồng nhau | `CommentComponent` | Bình luận & phản hồi nhiều cấp |
| 9 | Decorator | Bọc thêm tính năng động quanh nội dung | `BlogPostDecorator` | Thêm SEO, nút chia sẻ, quảng cáo |
|10 | Facade | Giao diện đơn giản cho nhiều subsystem | `BlogManagementFacade` | Publish bài + index + notify |
|11 | Proxy | Trung gian kiểm soát truy cập, cache | `BlogPostProxy` | Cache bài đọc nhiều, kiểm tra quyền |
|12 | Observer | Thông báo đa kênh khi có bài mới | `BlogSubscriber` + facade | Email/SMS/Push/RSS thông báo |

## Nhóm & Ý nghĩa
- Khởi tạo (Creational): Linh hoạt tạo và cấu hình đối tượng.
- Cấu trúc (Structural): Tổ chức quan hệ và thành phần lớn nhỏ.
- Hành vi (Behavioral): Truyền thông & phối hợp đối tượng.

## Khi chọn mẫu
- Nếu phải tạo nhiều biến thể: dùng Factory / Abstract Factory.
- Nếu khởi tạo phức tạp: Builder.
- Nếu cần clone nhanh: Prototype.
- Nếu cần một nguồn cấu hình duy nhất: Singleton.
- Nếu phải tích hợp API cũ: Adapter.
- Nếu muốn đa nền tảng hiển thị: Bridge.
- Nếu quản lý cây phần–tổng thể: Composite.
- Nếu muốn thêm tính năng không làm nổ số lớp: Decorator.
- Nếu cần API đơn giản cho nhiều bước: Facade.
- Nếu tối ưu truy cập, bảo vệ: Proxy.
- Nếu cần pub/sub sự kiện: Observer.

## Liên kết
- `README.md`
- `DESIGN_PATTERNS_PROBLEMS.md`
- `BAI_TOAN_CHI_TIET.md`
- `PATTERNS_DIAGRAM.md`
