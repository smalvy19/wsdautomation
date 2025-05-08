# Test Automation Framework

This is a Selenium-based Test Automation Framework using **TestNG**. It is designed to run tests on a web application with Firefox. The framework utilizes **Page Object Model (POM)** for better maintainability and separation of concerns.

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Java** (version 8 or higher)
- **Maven** (for dependency management)
- **Firefox** (as the only supported browser currently)
- **WebDriverManager** (to automatically manage the correct driver for Firefox)

## Framework Structure

### 1. **src/main/java**:
This folder contains all the page objects, and custom methods.

#### **src/main/java/tests**:
Contains all the test classes. For example:
- **HomeTest.java**: Tests the home page functionality such as product filtering by category and brand.

#### **pages**:
Contains Page Object classes representing various parts of the web application. For example:

#### **utils**:
Contains utility classes to read configurations or handle common operations like reading from files or managing WebDriver settings.

#### **BaseTest.java**:
The base class where the WebDriver setup and teardown happens. It configures the browser (currently Firefox) and initializes the driver for each test suite run. This class also manages the cleanup after test execution.

### 2. **src/test/resources**:
Contains configuration files (like **ConfigReader.properties**), which store various parameters like the browser to use, application URL, etc.

### 3. **pom.xml**:
Maven configuration file that includes dependencies for Selenium, TestNG, WebDriverManager, and other libraries required to run the tests.

---

## How to Run the Tests

### 1. Clone the repository:

```
git clone <repository-url>
cd <repository-directory>

```
### 2. Install Dependencies
Make sure Maven is installed in your system. Then run
```
mvn clean install
```
### 3. Run the Tests:
You can run the tests using Maven with the following command:
```
mvn test
```
### Framework Design Choices

1. Page Object Model (POM):
   
The framework follows the Page Object Model (POM) design pattern. Each web page is represented by a class (Page Object), encapsulating all the interactions with the elements on that page. This design provides the following benefits:

Maintainability: Changes in the UI (like element locators) require modifications only in the respective page class.

Reusability: Common actions and elements are centralized within page classes and reused across different tests.

2. BaseTest Class:
   
The BaseTest class is used to set up and tear down the WebDriver instance. This approach ensures:

Consistency: The WebDriver setup and teardown are handled in one place for all tests.

Scalability: New browser setups can be added easily by modifying this class without changing individual tests.

3. WebDriverManager:
   
WebDriverManager is used for automatic management of browser drivers (e.g., geckodriver for Firefox). This simplifies the configuration and maintenance of driver binaries:

No manual download: WebDriverManager handles driver downloading and versioning automatically.

Cross-platform compatibility: It supports different OS environments.

4. TestNG:
   
The framework uses TestNG for managing and executing tests:

Annotations: Easy setup of before/after hooks for tests.

Test prioritization: Tests can be prioritized based on their priority.

5. Error Handling & Assertions:

The framework uses standard assertions to validate the behavior of the application:

Assert methods: Assert.assertTrue(), Assert.assertFalse(), etc., ensure the correctness of the page functionality.

Error Handling: Errors are caught and logged, preventing the tests from failing silently.
