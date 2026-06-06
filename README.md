# Playwright Automation Portfolio

![CI](https://github.com/uncleef/playwright-automation-portfolio/actions/workflows/ci.yml/badge.svg)

A test automation framework built with Java 21, Playwright, and Cucumber (BDD) to demonstrate UI and API testing skills.

---

## Tech Stack

| Tool | Version |
|------|---------|
| Java | 21 |
| Playwright | 1.44.0 |
| Cucumber | 7.18.0 |
| JUnit | 5.10.2 |
| REST Assured | 5.5.0 |
| Maven | 3.x |

---

## Project Structure


---

## Test Coverage

### UI Tests (Playwright)
| Feature | Scenarios |
|---------|-----------|
| Login | Successful login, failed login |
| Forgot Password | Form submission |
| Checkboxes | Default state, check/uncheck |
| Dynamic Controls | Remove/add checkbox, enable/disable input |
| File Upload | Select file, upload file |

### API Tests (REST Assured)
| Endpoint | Method | Scenario |
|----------|--------|----------|
| /posts | GET | Status 200, non-empty list |
| /posts/1 | GET | Status 200, title not null |
| /posts | POST | Status 201 |

---

## Run Tests

```bash
# Run all tests (headless)
HEADLESS=true mvn test

# Run all tests (headed, local)
mvn test
```

---

## CI/CD

GitHub Actions runs on every push to `main`:
- Installs Java 21
- Caches Maven dependencies
- Installs Chromium
- Runs all tests in headless mode
- Uploads Cucumber HTML report as artifact

---

## Author

Federico Bruno — [GitHub](https://github.com/uncleef) · [LinkedIn](https://www.linkedin.com/in/federicobruno2690/)