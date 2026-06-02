# Contributing to OOP-Using-Java

Thank you for your interest in contributing! This guide explains how to contribute effectively.

## Code of Conduct
Please read and follow our [Code of Conduct](CODE_OF_CONDUCT.md).

## How to Contribute

### Reporting Bugs
- Use the Bug Report issue template
- Include Java version, OS, and steps to reproduce
- Attach console output or screenshots

### Suggesting Features
- Use the Feature Request issue template
- Describe the educational value
- Propose implementation approach

### Submitting Code
1. Fork the repository
2. Clone your fork: `git clone https://github.com/yourusername/OOP-Using-Java.git`
3. Create a branch: `git checkout -b feature/your-feature-name`
4. Make changes with meaningful commits
5. Ensure all tests pass: `mvn test`
6. Push and open a Pull Request

### Java Code Standards
- Java 17+ compatibility required
- Follow Google Java Style Guide
- Include Javadoc for all public methods
- Write JUnit 5 tests for new code
- Use meaningful variable and method names
- No magic numbers — use named constants

### Documentation Standards
- Markdown files must be well-structured
- Include code examples
- Reference related files/concepts

## Pull Request Checklist
- [ ] Code compiles without warnings
- [ ] Tests pass (`mvn test`)
- [ ] Documentation updated
- [ ] Follows naming conventions
- [ ] No placeholder/TODO code

## Commit Message Format
```
Type: Short description (max 72 chars)

Body explanation (optional)

Refs: #issue-number
```

Types: `Add`, `Fix`, `Update`, `Remove`, `Refactor`, `Docs`, `Test`

Example:
```
Add: Decorator design pattern with coffee shop example

Implements GoF Decorator pattern with full JUnit tests.
Refs: #42
```
