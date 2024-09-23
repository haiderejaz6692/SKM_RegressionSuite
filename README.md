

# SKM_RegressionSuite

SKM_RegressionSuite is an automated testing suite for the SKM web application. This suite uses **Cucumber**, **Selenium WebDriver**, **Extent Reports**, and **Maven** to perform automated functional testing of the web application. It follows the **Behavior-Driven Development (BDD)** approach, with scenarios written in **Gherkin**.

---

## Features

- **BDD with Cucumber**: Allows test scenarios to be written in Gherkin syntax for readability and collaboration between technical and non-technical members.
- **Selenium WebDriver**: Handles browser automation for executing test steps.
- **Extent Reports**: Generates detailed HTML reports with step-level logging.
- **Page Object Model (POM)**: Ensures that page interactions are modular and reusable.

---

## Prerequisites

Ensure you have the following installed on your machine:

1. **Java 17** or later
2. **Maven** (for build automation)
3. **Git** (for version control)
4. **Chrome Browser** (required for ChromeDriver)

---

## Getting Started

### 1. Clone the Repository

Use the following command to clone the repository to your local machine:

```bash
git clone https://github.com/haiderejaz6692/SKM_RegressionSuite.git
```

### 2. Open the Project

You can open the project in any Java IDE like **Eclipse** or **IntelliJ IDEA**. Make sure Maven is set up and linked to the project.

### 3. Configure Dependencies

Maven will automatically download all the required dependencies, including **Cucumber**, **Selenium WebDriver**, **WebDriverManager**, and **Extent Reports**. If needed, you can force Maven to download dependencies by running:

```bash
mvn clean install
```

### 4. Running Tests

You can run the test suite using **Maven** commands or directly from your IDE.

#### Run Tests via Maven

```bash
mvn clean test
```

After execution, the test results will be available in the `target/` folder, along with the Extent Reports.

---

## Project Structure

```
SKM_RegressionSuite
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── skm
│   │               ├── pageobjects        # Page Object Model classes
│   │               ├── utils              # Utility classes (hooks, config, etc.)
│   │               └── context            # Application, Feature, and Scenario contexts
│   └── test
│       ├── java
│       │   └── com
│       │       └── skm
│       │           ├── stepdefinitions    # Step definitions for Cucumber tests
│       │           └── runners            # Cucumber test runners
│       └── resources
│           └── features                   # Gherkin feature files
├── target                                  # Generated test results and compiled classes
└── pom.xml                                 # Maven dependencies
```

### Key Directories:
- **pageobjects**: Contains the Page Object Model classes for web page interactions.
- **utils**: Utility classes like Hooks, WebDriver management, and Extent Report manager.
- **context**: Application, Feature, and Scenario contexts for dependency injection.
- **stepdefinitions**: Contains Cucumber step definitions, which link Gherkin steps to Java code.
- **features**: Gherkin feature files that describe the test scenarios.

---

## Writing Tests

Tests are written using **Gherkin** syntax in `.feature` files. For example, a login scenario might look like this:

```gherkin
Feature: Login Functionality

  Scenario: Successful login with valid credentials
    Given User is on the login page
    When User enters username "validUsername" and password "validPassword"
    Then User should be redirected to the home page
```

### Step Definitions

For every step in the feature file, there’s a corresponding step definition in the `stepdefinitions` package. These step definitions use the **Page Object Model** to interact with the application.

---

## Generating Reports

After test execution, **Extent Reports** are generated in HTML format at:

```
/target/ExtentReport.html
```

You can open this file in any browser to view the detailed report, which includes logs for each step in the test scenarios.

---

## Contribution

Feel free to contribute to this project by following these steps:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature/your-feature-name`).
3. Make your changes and commit them (`git commit -m 'Add new feature'`).
4. Push your changes to the branch (`git push origin feature/your-feature-name`).
5. Create a new Pull Request.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---

## Contact

For any questions or issues, please contact the repository owner:

- **GitHub**: [haiderejaz6692](https://github.com/haiderejaz6692)

---

### Final Notes:

- Make sure you follow the coding standards while writing test scenarios.
- Ensure that every new feature is well-documented with both Gherkin and Java code.

---

You can add more sections if you want to include specific instructions, but this should serve as a solid starting point for newcomers to the project.

Let me know if you'd like to adjust or add anything!
