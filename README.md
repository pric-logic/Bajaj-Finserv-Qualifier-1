# Bajaj Finserv Health Java Qualifier

This is a Spring Boot application that implements the Bajaj Finserv Health Java qualifier requirements.

## Task Overview

Build a Spring Boot app that:
1. On startup, sends a POST request to generate a webhook
2. Based on the response, solves a SQL problem and stores the result
3. Sends the solution (a final SQL query) to the returned webhook URL using a JWT token

## Features

- **Automatic Webhook Generation**: Sends POST request to generate webhook on application startup
- **SQL Problem Solver**: Solves SQL problems based on registration number (odd/even logic)
- **Database Storage**: Stores solutions in H2 in-memory database
- **JWT Authentication**: Uses JWT token for solution submission
- **RESTful API**: Uses RestTemplate for HTTP communications

## Technology Stack

- **Spring Boot 3.2.0**
- **Java 17**
- **Spring Data JPA**
- **H2 Database**
- **RestTemplate**
- **Maven**

## Project Structure

```
src/main/java/com/bajajfinserv/healthqualifier/
├── HealthQualifierApplication.java    # Main application class
├── config/
│   └── AppConfig.java                 # Configuration beans
├── dto/
│   ├── WebhookRequest.java            # Webhook generation request DTO
│   ├── WebhookResponse.java           # Webhook generation response DTO
│   └── SolutionRequest.java           # Solution submission DTO
├── entity/
│   └── Solution.java                  # JPA entity for storing solutions
├── repository/
│   └── SolutionRepository.java        # JPA repository
└── service/
    ├── WebhookService.java            # Main webhook processing service
    └── SqlProblemSolver.java          # SQL problem solving logic
```

## How It Works

1. **Application Startup**: The application triggers the webhook flow automatically on startup
2. **Webhook Generation**: Sends POST request to `https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
3. **Problem Solving**: Determines question type based on registration number:
   - Odd last digit → Question 1 (Second highest salary)
   - Even last digit → Question 2 (Salary greater than average)
4. **Solution Storage**: Stores the solution in H2 database
5. **Solution Submission**: Submits final SQL query with JWT token

## API Endpoints Used

### Generate Webhook
- **URL**: `POST https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
- **Body**: 
```json
{
  "name": "John Doe",
  "regNo": "REG12347",
  "email": "john@example.com"
}
```

### Submit Solution
- **URL**: `POST https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`
- **Headers**: 
  - `Authorization: <accessToken>`
  - `Content-Type: application/json`
- **Body**:
```json
{
  "finalQuery": "YOUR_SQL_QUERY_HERE"
}
```

## Running the Application

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Build and Run

1. **Clone the repository**:
```bash
git clone <repository-url>
cd health-qualifier
```

2. **Build the project**:
```bash
mvn clean install
```

3. **Run the application**:
```bash
mvn spring-boot:run
```

4. **Access H2 Console** (optional):
   - URL: `http://localhost:8080/h2-console`
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: `password`

## SQL Problems

### Question 1 (Odd registration numbers)
Find the highest salary that was credited to an employee, but only for transactions that were not made on the 1st day of any month. Along with the salary, extract employee data like name, age and department:
```sql
SELECT 
    p.AMOUNT as SALARY, 
    CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) as NAME, 
    YEAR(CURDATE()) - YEAR(e.DOB) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(e.DOB, '%m%d')) as AGE, 
    d.DEPARTMENT_NAME 
FROM PAYMENTS p 
JOIN EMPLOYEE e ON p.EMP_ID = e.EMP_ID 
JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID 
WHERE DAY(p.PAYMENT_TIME) != 1 
ORDER BY p.AMOUNT DESC 
LIMIT 1
```

### Question 2 (Even registration numbers)
Find employees with salary greater than average:
```sql
SELECT * FROM employees 
WHERE salary > (SELECT AVG(salary) FROM employees)
```

## Configuration

The application uses the following configuration in `application.properties`:
- H2 in-memory database
- JPA with Hibernate
- Server port 8080
- Debug logging enabled

## Requirements Met

✅ **RestTemplate/WebClient**: Uses RestTemplate for HTTP communications  
✅ **No Controller Trigger**: Flow is triggered on application startup, not by controller  
✅ **JWT Authorization**: Uses JWT token in Authorization header  
✅ **Database Storage**: Stores solutions using Spring Data JPA  
✅ **Automatic Execution**: Runs automatically on application startup  

## Submission

This project includes:
- Complete Spring Boot application
- Maven build configuration
- H2 database for data persistence
- Comprehensive logging
- Error handling
- Clean code structure

The application will automatically execute the webhook flow when started and log all steps for monitoring.
