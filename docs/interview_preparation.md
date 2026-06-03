# Java OOP Interview Preparation Guide

## Core OOP Concepts (100+ Questions)

---

### Section 1: Fundamentals

**Q1. What is OOP? What are its 4 pillars?**
> Object-Oriented Programming organizes software around objects that combine state (fields) and behavior (methods).
> - **Encapsulation**: Bundling data and methods; restricting direct access
> - **Inheritance**: Acquiring properties from parent class (`extends`)
> - **Polymorphism**: One interface, many implementations
> - **Abstraction**: Hiding complexity; exposing essentials

**Q2. Difference between class and object?**
> - **Class**: Blueprint / template (e.g., `Car` class)
> - **Object**: Instance of a class (e.g., `Car myCar = new Car()`)

**Q3. What is a constructor? Types?**
> - **Default**: No-arg, auto-generated if none defined
> - **Parameterized**: Accepts arguments for initialization
> - **Copy**: Creates a new object by copying another

**Q4. Difference between method overloading and overriding?**
> - **Overloading**: Same name, different parameters (compile-time polymorphism)
> - **Overriding**: Subclass redefines parent method (runtime polymorphism)

**Q5. What is `this` keyword?**
> Refers to current object instance. Used to:
> - Differentiate fields from parameters
> - Call another constructor (`this()`)
> - Return current object

**Q6. What is `super` keyword?**
> Refers to parent class:
> - `super.field` - access parent field
> - `super.method()` - call parent method
> - `super()` - call parent constructor

---

### Section 2: Encapsulation

**Q7. Why use private fields with getters/setters?**
> Encapsulation protects object integrity. Without it:
> - Anyone can set invalid values (`account.balance = -1000`)
> - Business rules cannot be enforced
> - Code becomes fragile and hard to maintain

**Q8. What is immutability? How to create immutable classes?**
> An immutable object cannot be modified after creation.
> Rules: `final` class, `private final` fields, no setters, deep copy in constructor/getters.
> Example: `String`, `Integer`, `LocalDate`

**Q9. What is the difference between encapsulation and abstraction?**
> - **Encapsulation**: HOW data is protected (implementation detail)
> - **Abstraction**: WHAT is exposed (interface design)

---

### Section 3: Inheritance

**Q10. Types of inheritance in Java?**
> - Single: A extends B
> - Multi-level: C extends B extends A
> - Hierarchical: B extends A, C extends A
> - Multiple: NOT supported (use interfaces)
> - Hybrid: Via interfaces only

**Q11. Why doesn't Java support multiple inheritance?**
> Diamond Problem: If B and C both extend A and override method, and D extends B and C — which method does D use?
> Java solves this via interfaces with default methods.

**Q12. Can we override static methods?**
> No. Static methods belong to the class, not the object. You can **hide** them but not override.

**Q13. What is method hiding vs overriding?**
> - **Overriding**: Instance methods, resolved at runtime (dynamic dispatch)
> - **Hiding**: Static methods, resolved at compile time (static dispatch)

**Q14. Can constructors be inherited?**
> No. Constructors are not inherited. But `super()` calls the parent constructor.

---

### Section 4: Polymorphism

**Q15. What is dynamic dispatch (runtime polymorphism)?**
> JVM decides at runtime which overridden method to call based on the actual object type, not the reference type.
```java
Animal a = new Dog(); // reference: Animal, object: Dog
a.makeSound();        // calls Dog.makeSound() — resolved at runtime
```

**Q16. What is covariant return type?**
> A subclass overriding method can return a subtype of the parent's return type.
```java
class Animal { Animal create() { return new Animal(); } }
class Dog extends Animal { Dog create() { return new Dog(); } } // covariant - Dog is a subtype of Animal
```

**Q17. Can we overload the main method?**
> Yes, but JVM will only call `public static void main(String[] args)`.

---

### Section 5: Abstraction

**Q18. Abstract class vs Interface?**

| Feature | Abstract Class | Interface |
|---------|----------------|-----------|
| Methods | Concrete + Abstract | Default + Abstract (Java 8+) |
| Fields | Any type | `public static final` only |
| Constructor | Yes | No |
| Multiple inheritance | No | Yes |
| Access modifiers | Any | `public` only |
| Use when | Common base + shared state | Contract / capability |

**Q19. Can abstract class have constructors?**
> Yes! Called via `super()` from subclass. Used to initialize common fields.

**Q20. When to use abstract class vs interface?**
> - **Abstract class**: Shared implementation, "IS-A" relationship with state
> - **Interface**: Capability/contract, "CAN-DO" relationship, multiple inheritance

---

### Section 6: Collections & Generics

**Q21. ArrayList vs LinkedList vs Vector?**
> - `ArrayList`: Dynamic array, O(1) get, O(n) insert middle, not thread-safe
> - `LinkedList`: Doubly-linked, O(1) insert/delete at ends, O(n) random access
> - `Vector`: Thread-safe ArrayList (legacy, prefer `CopyOnWriteArrayList`)

**Q22. HashMap vs TreeMap vs LinkedHashMap?**
> - `HashMap`: No order, O(1) avg operations
> - `TreeMap`: Sorted by key, O(log n) operations
> - `LinkedHashMap`: Insertion order maintained, O(1) operations

**Q23. What is a generic wildcard?**
> - `<T>`: Unbounded type parameter
> - `<? extends T>`: T or any subtype (read-only, upper bounded)
> - `<? super T>`: T or any supertype (write-allowed, lower bounded)

---

### Section 7: Exception Handling

**Q24. Checked vs Unchecked exceptions?**
> - **Checked**: Must handle or declare (`IOException`, `SQLException`)
> - **Unchecked** (RuntimeException): Optional handling (`NullPointerException`, `ArrayIndexOutOfBoundsException`)
> - **Error**: JVM issues, don't handle (`OutOfMemoryError`)

**Q25. throw vs throws?**
> - `throw`: Actually throws an exception object
> - `throws`: Declares that a method might throw a checked exception

**Q26. What is try-with-resources?**
> Automatically closes `AutoCloseable` resources:
```java
try (FileReader fr = new FileReader("file.txt")) {
    // use fr
} // fr.close() called automatically, even on exception
```

---

### Section 8: Design Patterns

**Q27. Singleton Pattern — thread-safe implementation?**
```java
public class Singleton {
    private static volatile Singleton instance;
    private Singleton() {}
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) instance = new Singleton();
            }
        }
        return instance;
    }
}
```

**Q28. Factory Pattern — when to use?**
> When object creation logic is complex, or when the exact type is determined at runtime.

**Q29. Observer Pattern — real-world use?**
> Event listeners, MVC (Model → View updates), notification systems.

**Q30. Strategy Pattern — benefit?**
> Allows swapping algorithms at runtime without changing the client code. Implements OCP.

---

### Section 9: Multithreading

**Q31. Thread vs Runnable — which is preferred?**
> `Runnable` is preferred because:
> - Java supports single inheritance; extending Thread wastes it
> - Promotes composition over inheritance
> - Better for thread pool usage via `ExecutorService`

**Q32. What is `synchronized`?**
> Ensures only one thread accesses the synchronized block/method at a time. Prevents race conditions.

**Q33. volatile vs synchronized?**
> - `volatile`: Visibility guarantee (reads/writes go to main memory), no atomicity
> - `synchronized`: Atomicity + visibility + mutual exclusion

---

### FAANG-Style Coding Questions (OOP Design)

1. Design a Parking Lot system
2. Design an ATM machine
3. Design a Library Management System
4. Design an Elevator controller
5. Design a Food Delivery system (like Swiggy)
6. Design a Hotel Booking system
7. Design a Movie Ticket Booking system (like BookMyShow)
8. Design an E-commerce shopping cart
9. Design a Ride-sharing system (like Ola/Uber)
10. Design a Hospital Management system

---

### System Design Questions

1. How would you design a scalable payment gateway?
2. Explain the difference between monolith and microservices with OOP lens
3. How does OOP help in designing RESTful APIs?
4. Explain the role of interfaces in dependency injection frameworks like Spring
5. How would you apply SOLID principles to a student management system?

