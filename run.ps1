#!/bin/bash
cd "C:\Users\DELL\OneDrive\Desktop\Travel Management System\Tourism_Management_System"

echo "Compiling project..."
mvn clean compile

echo "Setting up resources..."
mkdir -Force target/classes/ICONS | Out-Null
mkdir -Force target/classes/Image | Out-Null
Copy-Item src/ICONS/* target/classes/ICONS/ -Recurse -Force
Copy-Item src/Image/* target/classes/Image/ -Recurse -Force

echo "Starting Travel Management System..."
mvn exec:java
