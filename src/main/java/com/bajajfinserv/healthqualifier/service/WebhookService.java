package com.bajajfinserv.healthqualifier.service;

import com.bajajfinserv.healthqualifier.dto.SolutionRequest;
import com.bajajfinserv.healthqualifier.dto.WebhookRequest;
import com.bajajfinserv.healthqualifier.dto.WebhookResponse;
import com.bajajfinserv.healthqualifier.entity.Solution;
import com.bajajfinserv.healthqualifier.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WebhookService {
    
    private static final String WEBHOOK_GENERATION_URL = "https://bfhldevapigw.healthrx.co.in/hiring/generateWebhook/JAVA";
    private static final String SOLUTION_SUBMISSION_URL = "https://bfhldevapigw.healthrx.co.in/hiring/testWebhook/JAVA";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private SqlProblemSolver sqlProblemSolver;
    
    @Autowired
    private SolutionRepository solutionRepository;
    
    public void processWebhookFlow() {
        try {
            System.out.println("Starting webhook flow...");
            
            // Step 1: Generate webhook
            WebhookResponse webhookResponse = generateWebhook();
            System.out.println("Webhook generated successfully: " + webhookResponse.getWebhook());
            
            // Step 2: Solve SQL problem
            String regNo = "REG12347"; // Using the example from the instructions
            String questionType = sqlProblemSolver.getQuestionType(regNo);
            String sqlQuery = sqlProblemSolver.solveProblem(regNo);
            String finalQuery = sqlQuery; // For this example, using the same query
            
            System.out.println("SQL Problem solved: " + sqlQuery);
            
            // Step 3: Store solution
            Solution solution = new Solution(regNo, questionType, sqlQuery, "Success", finalQuery);
            solutionRepository.save(solution);
            System.out.println("Solution stored in database");
            
            // Step 4: Submit solution
            submitSolution(webhookResponse.getAccessToken(), finalQuery);
            System.out.println("Solution submitted successfully!");
            
        } catch (Exception e) {
            System.err.println("Error in webhook flow: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    private WebhookResponse generateWebhook() {
        WebhookRequest request = new WebhookRequest("John Doe", "REG12347", "john@example.com");
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<WebhookRequest> entity = new HttpEntity<>(request, headers);
        
        ResponseEntity<WebhookResponse> response = restTemplate.postForEntity(
            WEBHOOK_GENERATION_URL, 
            entity, 
            WebhookResponse.class
        );
        
        return response.getBody();
    }
    
    private void submitSolution(String accessToken, String finalQuery) {
        SolutionRequest request = new SolutionRequest(finalQuery);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", accessToken);
        
        HttpEntity<SolutionRequest> entity = new HttpEntity<>(request, headers);
        
        restTemplate.postForEntity(SOLUTION_SUBMISSION_URL, entity, String.class);
    }
}
