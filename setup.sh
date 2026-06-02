#!/bin/bash
# OOP-Using-Java Setup Script

set -e

echo "=============================="
echo " OOP-Using-Java Setup Script"
echo "=============================="

# Check Java version
echo "Checking Java version..."
java_version=$(java -version 2>&1 | head -1 | cut -d'"' -f2 | cut -d'.' -f1)
if [ "$java_version" -lt 17 ]; then
    echo "ERROR: Java 17+ is required. Current: $(java -version 2>&1 | head -1)"
    exit 1
fi
echo "✅ Java version OK: $(java -version 2>&1 | head -1)"

# Check Maven
echo "Checking Maven..."
if ! command -v mvn &> /dev/null; then
    echo "ERROR: Maven is not installed."
    exit 1
fi
echo "✅ Maven OK: $(mvn -version 2>&1 | head -1)"

# Build project
echo "Building project..."
mvn clean install -q
echo "✅ Build successful"

# Run tests
echo "Running tests..."
mvn test -q
echo "✅ All tests passed"

echo ""
echo "=============================="
echo " Setup complete! 🚀"
echo "=============================="
echo ""
echo "Next steps:"
echo "  • Browse notebooks/ for interactive learning"
echo "  • Explore src/ for Java examples"
echo "  • Check problems/ for exercises"
echo "  • Read docs/roadmap.md for learning path"
