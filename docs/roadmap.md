# Learning Roadmap — OOP Using Java

## Overview
This roadmap guides you from Java basics to production-level OOP mastery in 12 weeks.

## Phase 1: Java Foundations (Week 1-2)
- **Notebook**: `00_Java_Environment_Setup.ipynb`
- **Source**: `src/basics/`
- **Topics**: JDK setup, variables, data types, operators, control flow
- **Exercise**: Create a `Calculator` class with all arithmetic operations
- **Milestone**: Run `HelloOOP.java` and understand its structure

## Phase 2: OOP Core Pillars (Week 3-5)
- **Encapsulation**: `src/encapsulation/BankAccount.java` — private fields + controlled access
- **Inheritance**: `src/inheritance/Animal.java` → `Dog.java`, `Cat.java`
- **Polymorphism**: `src/polymorphism/Shape.java` — runtime dispatch
- **Abstraction**: `src/abstraction/Vehicle.java` — abstract class + template method
- **Exercise**: Build a complete `Zoo` system using all 4 pillars

## Phase 3: Object Relationships (Week 6)
- **Composition**: Car HAS-A Engine (strong ownership)
- **Aggregation**: Department HAS-A Professor (weak ownership)
- **Association**: Student USES Library (uses relationship)
- **Exercise**: Design a `School` system with departments, teachers, and students

## Phase 4: Advanced Java (Week 7-9)
- **Interfaces**: Payment system with UPI, Card, Wallet, Crypto
- **Generics**: Type-safe containers, bounded wildcards
- **Collections**: ArrayList, HashMap, TreeMap, HashSet, PriorityQueue
- **Exception Handling**: Custom exceptions, try-catch-finally, chaining
- **Multithreading**: Thread, Runnable, ExecutorService, synchronization
- **Exercise**: Build a concurrent order processing system

## Phase 5: Design Excellence (Week 10-11)
- **SOLID Principles**: See `docs/solid_principles.md`
- **Design Patterns**: Singleton, Factory, Observer, Strategy, Decorator
- **LLD**: See `system_design/low_level_design/`
- **Exercise**: Refactor previous code to follow SOLID

## Phase 6: Testing & CI/CD (Week 11)
- **JUnit 5**: Unit tests, parameterized tests, lifecycle annotations
- **Logging**: SLF4J + Logback
- **GitHub Actions**: CI/CD pipeline
- **Exercise**: Achieve 80%+ test coverage on BankAccount class

## Phase 7: Interview Preparation (Week 12)
- **100+ Q&A**: `docs/interview_preparation.md`
- **LLD Problems**: `problems/advanced/`
- **System Design**: `system_design/`
- **Mock Interviews**: Practice with `problems/` directory

## Assessment Checkpoints

| Week | Checkpoint | Pass Criteria |
|------|-----------|---------------|
| 2 | Basics Quiz | Write Student class from scratch |
| 4 | OOP Challenge | Pass all 4-pillar tests |
| 6 | Mini Project | Complete Library System |
| 9 | Advanced Test | Build payment processor |
| 11 | Full Test Suite | All JUnit tests pass |
| 12 | Mock Interview | Solve 2 LLD problems in 45 min |

