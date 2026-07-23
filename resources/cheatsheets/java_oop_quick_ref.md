# Java OOP Quick Reference Card

## Class Template
```java
public class ClassName extends Parent implements Interface {
    private Type field;                          // encapsulated field
    public ClassName(Type param) {               // constructor
        this.field = param;
    }
    public Type getField() { return field; }     // getter
    public void setField(Type v) { this.field = v; } // setter
    @Override public String toString() { return "ClassName{field=" + field + "}"; }
    @Override public boolean equals(Object o) { ... }
    @Override public int hashCode() { ... }
}
```

## Access Modifier Summary
```
private   → class only
(default) → package only
protected → package + subclasses
public    → everywhere
```

## Key OOP Patterns
```java
// Singleton
private static volatile T instance;
public static T getInstance() { /* double-checked locking */ }

// Factory
public static Animal create(String type) {
    return switch(type) { case "dog" -> new Dog(); ... };
}

// Builder
new Person.Builder("Alice").age(22).email("a@b.com").build();

// Strategy
interface Strategy { void execute(); }
class Context { private Strategy s; void run() { s.execute(); } }

// Observer
interface Observer { void update(String event); }
class Subject { List<Observer> obs; void notify(String e) { obs.forEach(o -> o.update(e)); } }
```

## Collections Quick Pick
```
Need fast get by index?   → ArrayList
Need fast insert/delete?  → LinkedList
Need key-value, fast?     → HashMap
Need sorted by key?       → TreeMap
Need unique elements?     → HashSet
Need unique + sorted?     → TreeSet
Need priority ordering?   → PriorityQueue
Need thread-safe map?     → ConcurrentHashMap
```

## Exception Quick Ref
```java
// Checked: must declare or handle
public void riskyMethod() throws IOException { ... }

// Unchecked: optional handling
throw new IllegalArgumentException("Bad input: " + value);

// Custom
class AppException extends RuntimeException {
    AppException(String msg) { super(msg); }
}

// Try-with-resources
try (Connection c = getConnection()) { c.query(); }
```
