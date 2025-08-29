# Testing Guide - Bajaj Finserv Health Java Qualifier

## Prerequisites Setup

### 1. Install Maven

Since Maven is not installed, you need to install it first:

#### Option A: Download and Install Maven Manually
1. Download Maven from: https://maven.apache.org/download.cgi
2. Extract to a folder (e.g., `C:\Program Files\Apache\maven`)
3. Add Maven to PATH:
   - Open System Properties → Environment Variables
   - Add `C:\Program Files\Apache\maven\bin` to PATH
4. Restart your terminal/PowerShell

#### Option B: Use Chocolatey (if available)
```powershell
choco install maven
```

#### Option C: Use Maven Wrapper (Recommended)
The project includes Maven wrapper files. Let me create them for you.

### 2. Verify Installation
After installing Maven, run:
```powershell
mvn -version
```

## Testing Steps

### Step 1: Build the Project
```powershell
# Clean and compile
mvn clean compile

# Or use the provided batch file
.\build.bat
```

### Step 2: Run the Application
```powershell
# Run with Maven
mvn spring-boot:run

# Or use the provided batch file
.\run.bat
```

### Step 3: Monitor the Application

When you run the application, you should see output like this:

```
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.2.0)

2024-01-XX XX:XX:XX.XXX  INFO 1234 --- [main] c.b.h.HealthQualifierApplication : Starting HealthQualifierApplication using Java 23.0.1
2024-01-XX XX:XX:XX.XXX  INFO 1234 --- [main] c.b.h.HealthQualifierApplication : No active profile set, falling back to 1 default profile: "default"
2024-01-XX XX:XX:XX.XXX  INFO 1234 --- [main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
2024-01-XX XX:XX:XX.XXX  INFO 1234 --- [main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data JPA repository scan in XX ms. Found 1 JPA repository interface.
2024-01-XX XX:XX:XX.XXX  INFO 1234 --- [main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2024-01-XX XX:XX:XX.XXX  INFO 1234 --- [main] c.b.h.HealthQualifierApplication : Started HealthQualifierApplication in X.XXX seconds (process running for X.XXX)
Application started successfully!
Starting webhook flow...
```

### Step 4: Check Webhook Flow Execution

The application will automatically:
1. Generate a webhook
2. Solve the SQL problem
3. Store the solution
4. Submit the final query

Look for these log messages:
```
Starting webhook flow...
Webhook generated successfully: [webhook_url]
SQL Problem solved: [sql_query]
Solution stored in database
Solution submitted successfully!
```

### Step 5: Access H2 Database Console (Optional)

1. Open your browser
2. Go to: `http://localhost:8080/h2-console`
3. Use these credentials:
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: `password`
4. Click "Connect"
5. You can view the stored solutions in the `solutions` table

### Step 6: Check for Errors

If there are any errors, they will appear in the console. Common issues:

#### Network Issues
```
Error in webhook flow: I/O error on POST request for "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA"
```
**Solution**: Check your internet connection

#### Maven Issues
```
'mvn' is not recognized
```
**Solution**: Install Maven or use Maven wrapper

#### Java Version Issues
```
Unsupported major.minor version
```
**Solution**: Ensure Java 17+ is installed

## Alternative Testing Methods

### Method 1: Package and Run JAR
```powershell
# Create JAR file
mvn clean package -DskipTests

# Run JAR file
java -jar target/health-qualifier-1.0.0.jar
```

### Method 2: Use IDE
1. Open the project in IntelliJ IDEA or Eclipse
2. Run `HealthQualifierApplication.java` as a Spring Boot application
3. Monitor the console output

### Method 3: Test Individual Components

#### Test SQL Problem Solver
```java
// You can add this to the main method for testing
SqlProblemSolver solver = new SqlProblemSolver();
String query1 = solver.solveProblem("REG12347"); // Should return Question 1
String query2 = solver.solveProblem("REG12348"); // Should return Question 2
System.out.println("Query 1: " + query1);
System.out.println("Query 2: " + query2);
```

## Expected Results

### Successful Execution
- Application starts without errors
- Webhook flow executes automatically
- Solution is stored in database
- Final query is submitted successfully
- Console shows success messages

### Database Content
After successful execution, the H2 database should contain:
- Table: `solutions`
- Records with: regNo, questionType, sqlQuery, result, finalQuery

### API Responses
- Webhook generation should return a webhook URL and access token
- Solution submission should return a success response

## Troubleshooting

### Common Issues and Solutions

1. **Maven not found**
   - Install Maven or use Maven wrapper
   - Add Maven to PATH

2. **Port 8080 already in use**
   - Change port in `application.properties`
   - Or kill the process using port 8080

3. **Network connectivity issues**
   - Check internet connection
   - Verify firewall settings
   - Try using a different network

4. **Java version issues**
   - Ensure Java 17+ is installed
   - Set JAVA_HOME environment variable

5. **Database connection issues**
   - H2 database is in-memory, so no external setup needed
   - Check application.properties configuration

## Testing Checklist

- [ ] Maven is installed and working
- [ ] Java 17+ is installed
- [ ] Project builds successfully
- [ ] Application starts without errors
- [ ] Webhook flow executes automatically
- [ ] Solution is stored in database
- [ ] Final query is submitted successfully
- [ ] H2 console is accessible
- [ ] No error messages in console

## Support

If you encounter issues:
1. Check the console logs for error messages
2. Verify all prerequisites are installed
3. Ensure network connectivity
4. Review the troubleshooting section above
5. Check the README.md for additional information
