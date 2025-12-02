# MartianPay SDK Testing Guide

This directory contains the MartianPay Java SDK unit tests.

## Running Tests

Before testing, modify `API_KEY` constant in each test class with your actual API key:

```java
private static final String API_KEY = "your_api_key_here";
```

Also update the email and ID in each test case as needed.

### Customer Tests

```bash
# Run all customer tests
mvn test -Dtest=CustomerServiceTest

# Run specific test method
mvn test -Dtest=CustomerServiceTest#testCreateAndUpdateCustomer
mvn test -Dtest=CustomerServiceTest#testListCustomers
mvn test -Dtest=CustomerServiceTest#testGetCustomer
mvn test -Dtest=CustomerServiceTest#testDeleteCustomer
```

### Payment Intent Tests

```bash
# Create and update payment intent (crypto)
mvn test -Dtest=PaymentIntentServiceTest#testCreateAndUpdatePaymentIntent

# List payment intents
mvn test -Dtest=PaymentIntentServiceTest#testListPaymentIntents

# Get specific payment intent
mvn test -Dtest=PaymentIntentServiceTest#testGetPaymentIntent

# Cancel payment intent
mvn test -Dtest=PaymentIntentServiceTest#testCancelPaymentIntent
```

### Refund Tests

```bash
# Create refund
mvn test -Dtest=RefundServiceTest#testCreateRefund

# Get specific refund
mvn test -Dtest=RefundServiceTest#testGetRefund

# List refunds
mvn test -Dtest=RefundServiceTest#testListRefunds
```

### Run All Tests

```bash
# Run all tests
mvn test

# Run all tests with detailed output
mvn test -X

# Run tests and generate coverage report
mvn clean test jacoco:report
```

## Test Configuration

### Test Dependencies

The tests use JUnit 5 (Jupiter). Dependencies are configured in `pom.xml`:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.10.1</version>
    <scope>test</scope>
</dependency>
```

### Test Execution

Tests are executed using Maven Surefire Plugin:

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>3.2.2</version>
</plugin>
```

## Notes

- All test commands should be run from the project root directory
- Tests use the API key defined in each test class
- Make sure to update test data (emails, IDs, etc.) to match your test environment
- Tests make real API calls to the MartianPay API
- Some tests create and delete resources to avoid cluttering your account

## Alternative: Interactive Examples

For a more user-friendly way to explore the SDK, check out the [interactive examples](../examples/README.md) which provide example programs to run all SDK methods.

## Test Coverage

To generate test coverage reports:

```bash
# Add JaCoCo plugin to pom.xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.11</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>

# Run tests with coverage
mvn clean test jacoco:report

# View report at: target/site/jacoco/index.html
```

## Best Practices

1. **Use unique identifiers** - Generate unique emails/IDs for each test run:
   ```java
   String email = "test" + System.currentTimeMillis() + "@example.com";
   ```

2. **Clean up resources** - Always delete created resources after testing:
   ```java
   @AfterEach
   void cleanUp() {
       if (customerId != null) {
           service.deleteCustomer(customerId);
       }
   }
   ```

3. **Handle exceptions** - Properly handle and assert exceptions:
   ```java
   assertThrows(IOException.class, () -> {
       service.getCustomer("invalid_id");
   });
   ```

4. **Isolate tests** - Each test should be independent and not rely on other tests
