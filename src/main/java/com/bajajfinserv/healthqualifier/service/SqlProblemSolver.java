package com.bajajfinserv.healthqualifier.service;

import org.springframework.stereotype.Service;

@Service
public class SqlProblemSolver {
    
    public String solveProblem(String regNo) {
        // Extract last two digits of registration number
        String lastTwoDigits = regNo.substring(regNo.length() - 2);
        int lastDigit = Integer.parseInt(lastTwoDigits) % 10;
        
        if (lastDigit % 2 == 1) {
            // Odd - Question 1
            return solveQuestion1();
        } else {
            // Even - Question 2
            return solveQuestion2();
        }
    }
    
    private String solveQuestion1() {
        // Question 1: Find the highest salary that was credited to an employee, 
        // but only for transactions that were not made on the 1st day of any month.
        // Along with the salary, extract employee data like name, age and department.
        return "SELECT " +
               "    p.AMOUNT as SALARY, " +
               "    CONCAT(e.FIRST_NAME, ' ', e.LAST_NAME) as NAME, " +
               "    YEAR(CURDATE()) - YEAR(e.DOB) - (DATE_FORMAT(CURDATE(), '%m%d') < DATE_FORMAT(e.DOB, '%m%d')) as AGE, " +
               "    d.DEPARTMENT_NAME " +
               "FROM PAYMENTS p " +
               "JOIN EMPLOYEE e ON p.EMP_ID = e.EMP_ID " +
               "JOIN DEPARTMENT d ON e.DEPARTMENT = d.DEPARTMENT_ID " +
               "WHERE DAY(p.PAYMENT_TIME) != 1 " +
               "ORDER BY p.AMOUNT DESC " +
               "LIMIT 1";
    }
    
    private String solveQuestion2() {
        // Question 2: Find employees with salary greater than average
        return "SELECT * FROM employees WHERE salary > (SELECT AVG(salary) FROM employees)";
    }
    
    public String getQuestionType(String regNo) {
        String lastTwoDigits = regNo.substring(regNo.length() - 2);
        int lastDigit = Integer.parseInt(lastTwoDigits) % 10;
        
        return lastDigit % 2 == 1 ? "Question 1 - Highest Salary Not on 1st Day" : "Question 2 - Employees with Salary Greater Than Average";
    }
}
