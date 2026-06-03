# SOLID Principles in Java

## Overview
SOLID is an acronym for five object-oriented design principles that make software more maintainable, flexible, and scalable.

---

## S — Single Responsibility Principle (SRP)

**"A class should have only one reason to change."**

### ❌ Violation
```java
class UserManager {
    public void createUser(String name) { /* DB logic */ }
    public void sendWelcomeEmail(String email) { /* Email logic */ }
    public void generateReport() { /* Reporting logic */ }
    // 3 reasons to change!
}
```

### ✅ Correct
```java
class UserRepository { public void save(User user) { /*DB*/ } }
class EmailService    { public void sendWelcome(String email) { /*Email*/ } }
class ReportGenerator { public void generate() { /*Report*/ } }
```

**Benefits:** Easier to test, maintain, and modify each class independently.

---

## O — Open/Closed Principle (OCP)

**"Software entities should be open for extension, but closed for modification."**

### ❌ Violation
```java
class DiscountCalculator {
    public double calculate(String type, double price) {
        if (type.equals("STUDENT")) return price * 0.8;
        if (type.equals("EMPLOYEE")) return price * 0.7;
        // Must modify this class to add new discount types
        return price;
    }
}
```

### ✅ Correct (using interface)
```java
interface DiscountStrategy {
    double apply(double price);
}
class StudentDiscount  implements DiscountStrategy { public double apply(double p) { return p * 0.8; } }
class EmployeeDiscount implements DiscountStrategy { public double apply(double p) { return p * 0.7; } }
class SeniorDiscount   implements DiscountStrategy { public double apply(double p) { return p * 0.6; } }

class PriceCalculator {
    public double calculate(double price, DiscountStrategy strategy) {
        return strategy.apply(price); // never needs to change
    }
}
```

---

## L — Liskov Substitution Principle (LSP)

**"Derived classes must be substitutable for their base classes."**

### ❌ Violation
```java
class Bird { public void fly() { System.out.println("Flying"); } }
class Penguin extends Bird {
    @Override
    public void fly() { throw new UnsupportedOperationException("Penguins can't fly!"); }
    // Breaks the contract of Bird!
}
```

### ✅ Correct
```java
interface Bird { void move(); }
interface FlyingBird extends Bird { void fly(); }

class Penguin implements Bird { public void move() { System.out.println("Swimming"); } }
class Eagle implements FlyingBird {
    public void move() { fly(); }
    public void fly() { System.out.println("Flying high"); }
}
```

---

## I — Interface Segregation Principle (ISP)

**"Clients should not be forced to depend on interfaces they don't use."**

### ❌ Violation
```java
interface Worker {
    void work();
    void eat();
    void sleep();
}
class Robot implements Worker {
    public void work() { /* Works */ }
    public void eat() { throw new UnsupportedOperationException(); } // Robot doesn't eat!
    public void sleep() { throw new UnsupportedOperationException(); }
}
```

### ✅ Correct
```java
interface Workable { void work(); }
interface Eatable  { void eat(); }
interface Sleepable { void sleep(); }

class Human implements Workable, Eatable, Sleepable { /* implements all */ }
class Robot implements Workable { /* only work */ }
```

---

## D — Dependency Inversion Principle (DIP)

**"High-level modules should not depend on low-level modules. Both should depend on abstractions."**

### ❌ Violation
```java
class OrderService {
    private MySQLDatabase db = new MySQLDatabase(); // tightly coupled!
    public void saveOrder(Order o) { db.save(o); }
}
```

### ✅ Correct
```java
interface Database { void save(Object obj); }

class MySQLDatabase implements Database { public void save(Object o) { /* MySQL */ } }
class MongoDB       implements Database { public void save(Object o) { /* Mongo */ } }

class OrderService {
    private final Database db; // depends on abstraction

    public OrderService(Database db) { this.db = db; } // Dependency Injection

    public void saveOrder(Order o) { db.save(o); }
}

// Usage
OrderService service = new OrderService(new MySQLDatabase()); // easily swappable
```

---

## Summary Table

| Principle | Rule | Key Benefit |
|-----------|------|-------------|
| SRP | One class, one reason to change | Maintainability |
| OCP | Extend, don't modify | Flexibility |
| LSP | Subtypes honor parent contracts | Correctness |
| ISP | Small, specific interfaces | Decoupling |
| DIP | Depend on abstractions | Testability |

---

## Interview Questions

1. What is the difference between SRP and Separation of Concerns?
2. How does the Strategy Pattern implement OCP?
3. Give a real-world example where LSP is violated.
4. Why is ISP important for microservices?
5. How does Dependency Injection implement DIP?

