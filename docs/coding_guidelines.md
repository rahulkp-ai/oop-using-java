# Java Coding Guidelines

## Naming Conventions

```
Class / Interface  : PascalCase          → BankAccount, PaymentService
Method / Variable  : camelCase           → calculateInterest(), totalBalance
Constant           : UPPER_SNAKE_CASE    → MAX_RETRIES, DEFAULT_TIMEOUT
Package            : lowercase.dot       → com.company.service
Generic Type Param : Single uppercase    → T, E, K, V
```

## Class Design Rules

1. One class per file (public)
2. Keep classes under 300 lines; split if larger
3. Prefer composition over inheritance
4. Program to interfaces, not implementations
5. Always override `toString()`, `equals()`, `hashCode()` if needed

## Method Guidelines

- Methods should do ONE thing (SRP)
- Maximum 20 lines per method
- Maximum 3 parameters (use objects for more)
- Return early to avoid deep nesting
- Avoid side effects in getters

## Exception Handling

```java
// Good: specific exception, meaningful message
throw new IllegalArgumentException("Amount must be > 0, got: " + amount);

// Bad: swallowing exception
try { ... } catch (Exception e) { /* DO NOT DO THIS */ }

// Good: log and rethrow or handle
catch (Exception e) {
    logger.error("Failed to process payment: " + e.getMessage(), e);
    throw new PaymentException("Payment processing failed", e);
}
```

## Documentation Standards

```java
/**
 * Calculates the total price including tax.
 *
 * @param basePrice the pre-tax price in INR (must be positive)
 * @param taxRate   tax rate as a decimal (e.g., 0.18 for 18% GST)
 * @return total price including tax
 * @throws IllegalArgumentException if basePrice <= 0 or taxRate < 0
 */
public double calculateTotalPrice(double basePrice, double taxRate) { ... }
```

## Testing Guidelines

- Test each public method
- One assertion concept per test
- Use descriptive test names: `testWithdrawalFailsWhenAccountFrozen`
- Test edge cases: null, empty, boundary values
- Follow AAA pattern: Arrange → Act → Assert
