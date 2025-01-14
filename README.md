# Kiểm Thử Tự Động Trang Web với Selenium
## Giới thiệu
Chương trình này thực hiện kiểm thử tự động cho một trang web giả lập hoặc thực tế. Các chức năng được kiểm tra bao gồm:

Đăng nhập với tài khoản đúng và sai.

Kiểm tra thông báo lỗi khi nhập thông tin đăng nhập không hợp lệ.

Kiểm thử chức năng tìm kiếm.

Chương trình sử dụng Selenium WebDriver với ngôn ngữ lập trình Java để điều khiển trình duyệt và thực hiện các thao tác kiểm thử.

## Cài đặt
**Yêu cầu môi trường**

Java Development Kit (JDK): 8 trở lên.

Maven: Quản lý thư viện và phụ thuộc.

Selenium WebDriver: Phiên bản phù hợp với trình duyệt.

Trình duyệt: Chrome (hoặc các trình duyệt khác hỗ trợ Selenium).

**Bước cài đặt**

Clone dự án:

git clone https://github.com/your-repo/selenium-test.git

cd selenium-test

**Cài đặt thư viện:**

Đảm bảo tệp pom.xml chứa cấu hình sau:
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.9.0</version>
    </dependency>
</dependencies>

**Chạy lệnh Maven:**

mvn clean install

**Tải và cấu hình ChromeDriver:**

Tải ChromeDriver từ: https://chromedriver.chromium.org/downloads.

Đặt đường dẫn đến tệp chromedriver trong code:

System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

## Cách chạy chương trình

Mở dự án trong IDE (IntelliJ IDEA, Eclipse, hoặc VSCode).

Chạy file SeleniumTest.java.

Quan sát kết quả trên giao diện điều khiển và trình duyệt.

## Các chức năng kiểm thử

**1. Kiểm thử đăng nhập**

Trường hợp đúng: Nhập email và mật khẩu hợp lệ, xác minh chuyển hướng đến dashboard.

Trường hợp sai: Nhập thông tin sai, kiểm tra thông báo lỗi hiển thị đúng.

**2. Kiểm thử tìm kiếm**

Nhập từ khóa hợp lệ và xác minh kết quả hiển thị.

Nhập từ khóa không hợp lệ và kiểm tra thông báo "Không tìm thấy sản phẩm".

## Kết quả mong đợi

Khi đăng nhập thành công: Hiển thị thông báo Đăng nhập thành công với tài khoản: test@example.com.

Khi đăng nhập thất bại: Hiển thị thông báo Thông báo lỗi xuất hiện đúng khi đăng nhập sai với tài khoản: wrong@example.com.

Khi tìm kiếm thành công: Hiển thị thông báo Tìm kiếm thành công!.

Khi tìm kiếm thất bại: Hiển thị thông báo Không tìm thấy kết quả phù hợp!.

## kết quả chạy thật

![image](https://github.com/user-attachments/assets/1c71aab8-95ec-4b4f-9679-62aaf0e4def2)
