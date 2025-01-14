package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Thiết lập WebDriver
        System.setProperty("webdriver.chrome.driver", "D:\\chrome driver for selenium\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe"); // Thay bằng đường dẫn đến ChromeDriver
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        WebDriver driver = new ChromeDriver(options);

        try {
            // Điều hướng đến trang web
            driver.get("https://daominhha.net/dang-nhap-thanh-vien/"); // Thay bằng URL trang web của bạn
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // 1. Trường hợp đăng nhập với thông tin sai
            testLogin(driver, "wrong@example.com", "wrongpassword", false);

            // 2. Trường hợp đăng nhập với thông tin đúng
            testLogin(driver, "minhnhat11020@yahoo.com", "boy52351412", true);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng trình duyệt
            driver.quit();
        }
    }

    public static void testLogin(WebDriver driver, String email, String password, boolean expectSuccess) {
        try {
            // Điền thông tin đăng nhập
            WebElement emailField = driver.findElement(By.id("username-286"));
            WebElement passwordField = driver.findElement(By.id("user_password-286"));
            WebElement submitButton = driver.findElement(By.id("um-submit-btn"));

            emailField.clear();
            emailField.sendKeys(email);
            passwordField.clear();
            passwordField.sendKeys(password);
            submitButton.click();

            // Xử lý kết quả kiểm thử
            if (expectSuccess) {
                String expectedUrl = "https://daominhha.net/"; // URL sau khi đăng nhập thành công
                if (driver.getCurrentUrl().equals(expectedUrl)) {
                    System.out.println("Đăng nhập thành công với tài khoản: " + email);
                } else {
                    System.out.println("Thất bại: Đăng nhập đúng nhưng không chuyển đến dashboard.");
                }
            } else {
                // Kiểm tra thông báo lỗi
                WebElement errorMessage = driver.findElement(By.id("um-error-for-user_password-286")); // Thay ID bằng ID thực tế
                if (errorMessage.isDisplayed() && errorMessage.getText().contains("Sai thông tin đăng nhập")) {
                    System.out.println("Thông báo lỗi xuất hiện đúng khi đăng nhập sai với tài khoản: " + email);
                } else {
                    System.out.println("Thất bại: Thông báo lỗi không xuất hiện hoặc không đúng.");
                }
            }
        } catch (Exception e) {
            System.out.println("Lỗi xảy ra trong quá trình kiểm thử đăng nhập: " + e.getMessage());
        }
    }
}