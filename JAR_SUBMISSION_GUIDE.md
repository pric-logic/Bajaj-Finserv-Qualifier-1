# JAR File Running and Submission Guide

## 🎉 JAR File Successfully Created!

Your Spring Boot application has been packaged into a JAR file:
- **Location**: `target/health-qualifier-1.0.0.jar`
- **Size**: ~54MB (includes all dependencies)
- **Type**: Executable Spring Boot JAR

## 🚀 How to Run the JAR File

### Method 1: Direct Java Execution
```powershell
# Navigate to the project directory
cd "D:\bajaj finserv"

# Run the JAR file
java -jar target/health-qualifier-1.0.0.jar
```

### Method 2: Using the Provided Script
```powershell
# Run the application using the batch file
.\run.bat
```

### Method 3: With Custom Parameters
```powershell
# Run with custom port
java -jar target/health-qualifier-1.0.0.jar --server.port=8081

# Run with debug logging
java -jar target/health-qualifier-1.0.0.jar --logging.level.com.bajajfinserv=DEBUG
```

## 📋 What Happens When You Run the JAR

1. **Application Startup**: Spring Boot starts up
2. **Database Initialization**: H2 in-memory database is created
3. **Webhook Flow Execution**: The application automatically:
   - Sends POST request to generate webhook
   - Solves SQL problem based on registration number
   - Stores solution in database
   - Submits final query with JWT token

## 🔍 Expected Output

When you run the JAR file, you should see output like this:

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
2024-01-XX XX:XX:XX.XXX  INFO 1234 --- [main] c.b.h.HealthQualifierApplication : Started HealthQualifierApplication in X.XXX seconds (process running for X.XXX)
Application started successfully!
Starting webhook flow...
Webhook generated successfully: [webhook_url]
SQL Problem solved: [sql_query]
Solution stored in database
Solution submitted successfully!
```

## 📦 JAR File Contents

The JAR file contains:
- ✅ Complete Spring Boot application
- ✅ All required dependencies (Spring Boot, JPA, H2, etc.)
- ✅ Application properties
- ✅ Compiled Java classes
- ✅ META-INF configuration

## 🎯 Testing the JAR File

### 1. Basic Functionality Test
```powershell
# Run the JAR
java -jar target/health-qualifier-1.0.0.jar

# Check if application starts successfully
# Look for "Application started successfully!" message
# Look for "Starting webhook flow..." message
```

### 2. Database Console Test
1. Start the application
2. Open browser: `http://localhost:8080/h2-console`
3. Use credentials:
   - JDBC URL: `jdbc:h2:mem:testdb`
   - Username: `sa`
   - Password: `password`
4. Check if `solutions` table exists and contains data

### 3. Network Connectivity Test
- Ensure internet connection is available
- The application will make HTTP requests to:
  - `https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA`
  - `https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA`

## 📤 Submission Instructions

### For Bajaj Finserv Health Java Qualifier

1. **JAR File Location**: `target/health-qualifier-1.0.0.jar`
2. **File Size**: ~54MB
3. **Java Version**: Compatible with Java 17+
4. **Dependencies**: All included in JAR (no external dependencies needed)

### Submission Package Should Include:

1. **Executable JAR File**: `health-qualifier-1.0.0.jar`
2. **Source Code**: Complete project structure
3. **Documentation**: README.md, TESTING_GUIDE.md
4. **Build Scripts**: build.bat, run.bat, package.bat

### How to Submit:

1. **Zip the entire project folder**:
   ```powershell
   # Create submission package
   Compress-Archive -Path "D:\bajaj finserv\*" -DestinationPath "bajaj-finserv-submission.zip"
   ```

2. **Or submit individual files**:
   - `health-qualifier-1.0.0.jar` (executable)
   - Complete source code folder
   - Documentation files

## 🔧 Troubleshooting

### Common Issues:

1. **"No main manifest attribute"**
   - Ensure you're using the correct JAR file from `target/` folder
   - The JAR should be created with Spring Boot Maven plugin

2. **"Port already in use"**
   ```powershell
   # Use different port
   java -jar target/health-qualifier-1.0.0.jar --server.port=8081
   ```

3. **"Java version not supported"**
   - Ensure Java 17+ is installed
   - Check with: `java -version`

4. **Network connectivity issues**
   - Check internet connection
   - Verify firewall settings
   - The application needs to access external APIs

### Verification Commands:

```powershell
# Check Java version
java -version

# Check JAR file
java -jar target/health-qualifier-1.0.0.jar --version

# List JAR contents
jar -tf target/health-qualifier-1.0.0.jar | findstr "META-INF"
```

## ✅ Pre-Submission Checklist

- [ ] JAR file runs successfully
- [ ] Application starts without errors
- [ ] Webhook flow executes automatically
- [ ] Solution is stored in database
- [ ] Final query is submitted successfully
- [ ] H2 console is accessible
- [ ] All source code is included
- [ ] Documentation is complete
- [ ] No sensitive information in code
- [ ] JAR file is executable

## 🎯 Key Features Demonstrated

✅ **Spring Boot Application**: Complete Spring Boot 3.2.0 application  
✅ **RestTemplate Usage**: Uses RestTemplate for HTTP communications  
✅ **No Controller Trigger**: Flow triggered on application startup  
✅ **JWT Authorization**: Uses JWT token in Authorization header  
✅ **Database Storage**: Stores solutions using Spring Data JPA  
✅ **Automatic Execution**: Runs automatically on startup  
✅ **Error Handling**: Comprehensive error handling and logging  
✅ **Clean Architecture**: Well-structured, maintainable code  

## 📞 Support

If you encounter issues:
1. Check the console logs for error messages
2. Verify Java 17+ is installed
3. Ensure network connectivity
4. Review the TESTING_GUIDE.md for detailed instructions
5. Check the README.md for project overview

---

**Your JAR file is ready for submission!** 🎉

The application will automatically execute the complete webhook flow when started, demonstrating all required functionality for the Bajaj Finserv Health Java qualifier.
