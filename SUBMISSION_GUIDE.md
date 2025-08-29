# Bajaj Finserv Health Java Qualifier - Submission Guide

## Project Overview

This Spring Boot application implements the complete Bajaj Finserv Health Java qualifier requirements. The application automatically executes the webhook flow on startup without requiring any controller endpoints.

## ✅ Requirements Met

### Core Requirements
- ✅ **Spring Boot Application**: Complete Spring Boot 3.2.0 application
- ✅ **RestTemplate Usage**: Uses RestTemplate for HTTP communications
- ✅ **No Controller Trigger**: Flow is triggered on application startup, not by controller
- ✅ **JWT Authorization**: Uses JWT token in Authorization header for solution submission
- ✅ **Database Storage**: Stores solutions using Spring Data JPA with H2 database

### Technical Requirements
- ✅ **Java 17**: Uses Java 17 as specified
- ✅ **Maven Build**: Complete Maven project with all dependencies
- ✅ **Automatic Execution**: Runs automatically on application startup
- ✅ **Error Handling**: Comprehensive error handling and logging
- ✅ **Clean Architecture**: Well-structured code with proper separation of concerns

## 📁 Project Structure

```
bajaj-finserv-health-qualifier/
├── src/main/java/com/bajajfinserv/healthqualifier/
│   ├── HealthQualifierApplication.java    # Main application class
│   ├── config/
│   │   └── AppConfig.java                 # RestTemplate configuration
│   ├── dto/
│   │   ├── WebhookRequest.java            # Webhook generation request
│   │   ├── WebhookResponse.java           # Webhook generation response
│   │   └── SolutionRequest.java           # Solution submission request
│   ├── entity/
│   │   └── Solution.java                  # JPA entity for solutions
│   ├── repository/
│   │   └── SolutionRepository.java        # JPA repository
│   └── service/
│       ├── WebhookService.java            # Main webhook processing logic
│       └── SqlProblemSolver.java          # SQL problem solving logic
├── src/main/resources/
│   └── application.properties             # Application configuration
├── pom.xml                               # Maven dependencies
├── README.md                             # Project documentation
├── build.bat                             # Windows build script
├── run.bat                               # Windows run script
├── package.bat                           # Windows package script
└── .gitignore                            # Git ignore file
```

## 🚀 How to Run

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Quick Start (Windows)
1. **Build the project**:
   ```bash
   build.bat
   ```

2. **Run the application**:
   ```bash
   run.bat
   ```

3. **Create JAR package**:
   ```bash
   package.bat
   ```

### Manual Commands
```bash
# Build
mvn clean compile

# Run
mvn spring-boot:run

# Package
mvn clean package -DskipTests

# Run JAR
java -jar target/health-qualifier-1.0.0.jar
```

## 🔄 Application Flow

1. **Application Startup**: Spring Boot application starts
2. **Event Trigger**: `ApplicationReadyEvent` triggers the webhook flow
3. **Webhook Generation**: POST request to generate webhook
4. **Problem Solving**: Determines question type and solves SQL problem
5. **Solution Storage**: Stores solution in H2 database
6. **Solution Submission**: Submits final query with JWT token

## 📊 SQL Problems Implemented

### Question 1 (Odd registration numbers)
```sql
SELECT MAX(salary) as second_highest_salary 
FROM employees 
WHERE salary < (SELECT MAX(salary) FROM employees)
```

### Question 2 (Even registration numbers)
```sql
SELECT * FROM employees 
WHERE salary > (SELECT AVG(salary) FROM employees)
```

## 🔧 Configuration

### Database
- **Type**: H2 in-memory database
- **Console**: Available at `http://localhost:8080/h2-console`
- **Credentials**: sa/password

### API Endpoints
- **Webhook Generation**: `https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
- **Solution Submission**: `https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`

## 📝 Logging

The application provides comprehensive logging:
- Application startup events
- Webhook generation status
- SQL problem solving steps
- Database operations
- Solution submission results
- Error handling

## 🎯 Key Features

- **Automatic Execution**: No manual intervention required
- **Robust Error Handling**: Graceful error handling with detailed logging
- **Database Persistence**: Solutions stored in H2 database
- **JWT Authentication**: Proper JWT token usage
- **Clean Code**: Well-structured, maintainable code
- **Documentation**: Comprehensive README and comments

## 📦 Submission Package

This project includes:
- ✅ Complete source code
- ✅ Maven build configuration
- ✅ Application properties
- ✅ Build and run scripts
- ✅ Comprehensive documentation
- ✅ JAR file generation capability
- ✅ Database configuration
- ✅ Error handling and logging

## 🔍 Testing

The application can be tested by:
1. Running the application
2. Monitoring console logs
3. Checking H2 database console
4. Verifying webhook flow execution

## 📞 Support

For any issues or questions:
1. Check the console logs for error messages
2. Verify Java 17 and Maven are installed
3. Ensure network connectivity for API calls
4. Review the README.md for detailed instructions

---

**Ready for submission!** 🎉
