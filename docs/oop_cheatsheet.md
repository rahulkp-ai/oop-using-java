# OOP Java Quick Cheatsheet

## Class Declaration
```java
public class ClassName extends ParentClass implements Interface1, Interface2 {
    // Fields
    private String name;           // instance field
    private static int count;      // class field
    public static final int MAX = 100; // constant

    // Constructor
    public ClassName(String name) { this.name = name; }

    // Methods
    public String getName() { return name; }        // getter
    public void setName(String n) { this.name = n; } // setter
    @Override public String toString() { return "ClassName{name=" + name + "}"; }
    @Override public boolean equals(Object o) { ... }
    @Override public int hashCode() { ... }
}
```

## Key OOP Keywords
| Keyword | Usage |
|---------|-------|
| `this` | Current object reference |
| `super` | Parent class reference |
| `extends` | Inherit from class |
| `implements` | Implement interface |
| `abstract` | Abstract class/method |
| `final` | Prevent override/subclassing |
| `static` | Class-level (not instance) |
| `instanceof` | Type check |
| `new` | Create object |

## Access Modifiers
| Modifier | Class | Package | Subclass | World |
|----------|-------|---------|----------|-------|
| `public` | ✅ | ✅ | ✅ | ✅ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `private` | ✅ | ❌ | ❌ | ❌ |

## Encapsulation Pattern
```java
public class BankAccount {
    private double balance; // private field
    public double getBalance() { return balance; } // getter
    public void deposit(double amount) {           // controlled setter
        if (amount > 0) balance += amount;
    }
}
```

## Inheritance Chain
```java
class Animal { void eat() { System.out.println("Eating"); } }
class Dog extends Animal {
    @Override void eat() { System.out.println("Dog eating"); }
    void bark() { System.out.println("Woof!"); }
}
Animal a = new Dog(); a.eat(); // Dog eating (polymorphism)
```

## Interface & Abstract Class
```java
interface Flyable { void fly(); default void land() { System.out.println("Landing"); } }
abstract class Vehicle { abstract void start(); void stop() { System.out.println("Stop"); } }
class Plane extends Vehicle implements Flyable {
    public void start() { System.out.println("Engines on"); }
    public void fly() { System.out.println("Flying!"); }
}
```

## Exception Handling
```java
try {
    riskyMethod();
} catch (SpecificException e) {
    handle(e);
} catch (AnotherException | YetAnother e) {
    handleMultiple(e);
} finally {
    cleanup(); // always runs
}
```

## Generics
```java
class Box<T> { private T value; public T get() { return value; } }
<T extends Comparable<T>> T max(T a, T b) { return a.compareTo(b) > 0 ? a : b; }
```

## Common Design Patterns (One-liner)
- **Singleton**: One instance, `synchronized getInstance()`
- **Factory**: Create objects via method, not `new`
- **Observer**: Publisher notifies subscribers on event
- **Strategy**: Swap algorithm at runtime via interface
- **Decorator**: Add behavior by wrapping objects
