# Variables
SRC_DIR := src/main/java
TEST_DIR := src/test/java
PACKAGE := portfolio.analysis
JAR_FILE := analysis-1.0.0.jar

# Commands
build:
	@echo "Building JAR file..."
	@mvn -q clean package
	@cp target/$(JAR_FILE) .

test:
	@echo "Running unit tests..."
	@mvn -q test

.PHONY: build test