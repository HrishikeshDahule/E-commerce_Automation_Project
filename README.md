# 🛒 Ecommerce Automation Testing Project

This is a comprehensive automation testing framework for an ecommerce web application, built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**. It is designed to validate key user workflows such as login, product search, add-to-cart, and checkout functionalities. The project is integrated with **Extent Reports** and **GitHub Actions** for CI/CD.

---

## 🔧 Tech Stack

- **Programming Language**: Java
- **Automation Tool**: Selenium WebDriver
- **Test Framework**: TestNG
- **Build Tool**: Maven
- **Reporting**: Extent Reports
- **CI/CD**: GitHub Actions
- **IDE**: Eclipse

---

## 📁 Project Structure
Ecommerce_Automation_Testing/
src/
├── test/
│ └── java/
│ ├── Base/
│ │ └── BaseTest.java # Common WebDriver setup and teardown
│ ├── Pages/ # Page Object Model classes
│ │ ├── LoginPage.java
│ │ ├── CartPage.java
│ │ ├── ProductDetailPage.java
│ │ └── ... (all page classes)
│ └── Tests/ # Test classes
│ ├── LoginTest.java
│ ├── CartTest.java
│ └── ... (all test classes)
| └── utils/
│   ├── ExtentReportManager.java # Report configuration
└── testng.xml # TestNG suite configuration

## 🚀 How to Run
1. Clone the repository
2. Import into Eclipse
3. Run tests using TestNG or via Maven:
   ```bash
   mvn clean test
