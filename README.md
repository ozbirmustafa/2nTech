# 2nTech Test Automation Project

## Overview
This repository contains automated test scripts for the 2nTech platform. The goal is to ensure the functionality, performance, and reliability of the platform through automated tests.

## Features
- Behavior-driven development (BDD) with Cucumber and Gherkin syntax.

## Prerequisites
- **Java** (version 17)
- **Maven** (latest version)

Technologies Used
Java: Programming language for writing test scripts.
Selenium WebDriver: For browser automation.
Cucumber: BDD framework for creating test scenarios.
Maven: Dependency management and build tool.

Project Structure

## Project Structure

- **src/main/java/resources:**  
  Stores configuration files like `configuration.properties` and `log4j2.xml`.

- **Logs:**  
  Contains runtime logs and success logs for debugging and reporting purposes.

- **Files:**  
  Includes documentation (Excel files for manual test cases) and videos showing identified bugs.
  My Cv is used for job application test.

- **Screenshots:**  
  Captures and stores screenshots for passed test cases to validate visual output.

- **Screenshots:**  
  Captures and stores screenshots for passed test cases to validate visual output.

- **src/test/java/com/common:**  
  Constants.java: Contains constants that provide fixed values used across the project.
  Driver.java: Manages WebDriver instances for browser automation.
  ConfigReader.java: A utility class that reads configuration settings from external files (e.g., configuration.properties). 
