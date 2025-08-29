package com.bajajfinserv.healthqualifier.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "solutions")
public class Solution {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String regNo;
    
    @Column(nullable = false)
    private String questionType;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String sqlQuery;
    
    @Column(nullable = false)
    private String result;
    
    @Column(columnDefinition = "TEXT", nullable = false)
    private String finalQuery;
    
    public Solution() {}
    
    public Solution(String regNo, String questionType, String sqlQuery, String result, String finalQuery) {
        this.regNo = regNo;
        this.questionType = questionType;
        this.sqlQuery = sqlQuery;
        this.result = result;
        this.finalQuery = finalQuery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getSqlQuery() {
        return sqlQuery;
    }

    public void setSqlQuery(String sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getFinalQuery() {
        return finalQuery;
    }

    public void setFinalQuery(String finalQuery) {
        this.finalQuery = finalQuery;
    }
}

