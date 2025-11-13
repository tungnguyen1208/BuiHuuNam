# BlueJ Design Patterns - Blog Website

## 📚 Giới Thiệu / Introduction

Thư mục này chứa **12 mẫu thiết kế (Design Patterns)** được tối ưu hóa cho BlueJ IDE để tạo **sơ đồ UML tự động**.

This folder contains **12 Design Patterns** optimized for BlueJ IDE to generate **automatic UML diagrams**.

## 📁 Cấu Trúc / Structure

Mỗi mẫu thiết kế có **folder riêng** với tên đơn giản:

```
bluej-patterns/
├── singleton/              ← Singleton Pattern
├── factory_method/         ← Factory Method Pattern
├── abstract_factory/       ← Abstract Factory Pattern
├── builder/                ← Builder Pattern
├── prototype/              ← Prototype Pattern
├── adapter/                ← Adapter Pattern
├── decorator/              ← Decorator Pattern
├── facade/                 ← Facade Pattern
├── proxy/                  ← Proxy Pattern
├── observer/               ← Observer Pattern
├── strategy/               ← Strategy Pattern
└── template_method/        ← Template Method Pattern
```

## 🎯 Cách Sử Dụng Trong BlueJ / How to Use in BlueJ

### Bước 1: Mở Project
1. Khởi động BlueJ
2. **Project → Open Non-BlueJ...**
3. Chọn thư mục `bluej-patterns/`
4. Click **Open**

### Bước 2: Chọn Pattern để học
1. Trong BlueJ, click vào thư mục pattern muốn học (vd: `singleton`)
2. BlueJ sẽ hiển thị **sơ đồ UML** của các class

### Bước 3: Compile và Run
1. Click button **Compile** để compile toàn bộ
2. Right-click vào class Demo (vd: `SingletonDemo`)
3. Chọn **void main(String[] args)**
4. Xem kết quả output

## 📖 12 Mẫu Thiết Kế / 12 Design Patterns

### Creational Patterns (Nhóm Khởi Tạo) - 5 mẫu

#### 1. Singleton
- **Folder:** `singleton/`
- **Classes:** `BlogConfig`, `ConfigManager`, `SingletonDemo`
- **Mục đích:** Đảm bảo chỉ có 1 instance duy nhất
- **Demo:** `SingletonDemo.main()`

#### 2. Factory Method
- **Folder:** `factory_method/`
- **Classes:** `Post`, `TechnicalPost`, `NewsPost`, `LifestylePost`, `PostFactory`, `FactoryMethodDemo`
- **Mục đích:** Tạo objects thông qua factory method
- **Demo:** `FactoryMethodDemo.main()`

#### 3. Abstract Factory
- **Folder:** `abstract_factory/`
- **Classes:** `ThemeFactory`, `ModernThemeFactory`, `ClassicThemeFactory`, `Button`, `Header`, `Footer`, `BlogPage`, `AbstractFactoryDemo`
- **Mục đích:** Tạo families of related objects
- **Demo:** `AbstractFactoryDemo.main()`

#### 4. Builder
- **Folder:** `builder/`
- **Classes:** `Article`, `Article.Builder`, `BuilderDemo`
- **Mục đích:** Xây dựng complex objects từng bước
- **Demo:** `BuilderDemo.main()`

#### 5. Prototype
- **Folder:** `prototype/`
- **Classes:** `BlogPost`, `PostRegistry`, `PrototypeDemo`
- **Mục đích:** Clone objects từ prototype
- **Demo:** `PrototypeDemo.main()`

### Structural Patterns (Nhóm Cấu Trúc) - 4 mẫu

#### 6. Adapter
- **Folder:** `adapter/`
- **Classes:** `HTMLRenderer`, `MarkdownContent`, `MarkdownToHTMLAdapter`, `AdapterDemo`
- **Mục đích:** Convert interface này sang interface khác
- **Demo:** `AdapterDemo.main()`

#### 7. Decorator
- **Folder:** `decorator/`
- **Classes:** `Post`, `BasicPost`, `PostDecorator`, `ImageDecorator`, `VideoDecorator`, `DecoratorDemo`
- **Mục đích:** Thêm chức năng động cho objects
- **Demo:** `DecoratorDemo.main()`

#### 8. Facade
- **Folder:** `facade/`
- **Classes:** `BlogFacade`, `Validator`, `Database`, `SearchIndexer`, `Notifier`, `FacadeDemo`
- **Mục đích:** Đơn giản hóa interface phức tạp
- **Demo:** `FacadeDemo.main()`

#### 9. Proxy
- **Folder:** `proxy/`
- **Classes:** `Image`, `RealImage`, `ImageProxy`, `ProxyDemo`
- **Mục đích:** Lazy loading và access control
- **Demo:** `ProxyDemo.main()`

### Behavioral Patterns (Nhóm Hành Vi) - 3 mẫu

#### 10. Observer
- **Folder:** `observer/`
- **Classes:** `Subscriber`, `EmailSubscriber`, `SMSSubscriber`, `Publisher`, `ObserverDemo`
- **Mục đích:** Thông báo thay đổi cho subscribers
- **Demo:** `ObserverDemo.main()`

#### 11. Strategy
- **Folder:** `strategy/`
- **Classes:** `SortStrategy`, `DateSortStrategy`, `PopularitySortStrategy`, `AlphabeticalSortStrategy`, `BlogDisplay`, `StrategyDemo`
- **Mục đích:** Đổi algorithm tại runtime
- **Demo:** `StrategyDemo.main()`

#### 12. Template Method
- **Folder:** `template_method/`
- **Classes:** `PostProcessor`, `TechnicalPostProcessor`, `NewsPostProcessor`, `TemplateMethodDemo`
- **Mục đích:** Định nghĩa skeleton của algorithm
- **Demo:** `TemplateMethodDemo.main()`

## 🎨 Xem Sơ Đồ UML / View UML Diagrams

Trong BlueJ, khi mở folder của một pattern, bạn sẽ thấy:
- **Boxes** - Đại diện cho classes
- **Lines** - Đại diện cho relationships:
  - Solid arrow (→) - Inheritance
  - Dashed arrow (⇢) - Implementation
  - Diamond (◇) - Composition/Aggregation
  - Simple line - Association

## ✅ Lợi Ích / Benefits

✅ **Dễ học** - Mỗi pattern độc lập, dễ hiểu
✅ **Sơ đồ UML tự động** - BlueJ tạo UML diagram
✅ **Code đơn giản** - Tối ưu cho học tập
✅ **Demo có sẵn** - Mỗi pattern có demo class
✅ **Tên folder rõ ràng** - observer, strategy, singleton...

## 🚀 Quick Start

```bash
# 1. Mở BlueJ
# 2. Project → Open Non-BlueJ → chọn bluej-patterns/
# 3. Click vào folder pattern (vd: observer)
# 4. Xem UML diagram
# 5. Right-click Demo class → main()
```

## 📝 Lưu Ý / Notes

- Mỗi pattern có ít nhất 2-3 classes để thể hiện relationships rõ ràng
- Tất cả classes đều có Javadoc comments
- Demo classes có thể chạy độc lập
- Code được tối ưu để BlueJ tạo UML diagram đẹp

## 🎓 Học Tập / Learning Path

**Khuyến nghị thứ tự học:**

1. **Creational**: singleton → factory_method → builder → abstract_factory → prototype
2. **Structural**: adapter → decorator → facade → proxy
3. **Behavioral**: observer → strategy → template_method

---

**Chúc bạn học tốt! / Happy Learning!** 🎉
