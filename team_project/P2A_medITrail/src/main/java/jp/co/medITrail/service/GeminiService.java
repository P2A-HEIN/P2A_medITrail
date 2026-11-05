package jp.co.medITrail.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class GeminiService {

    @Value("${gemini.api.key}")
    private String apiKey;
    
    private static final String GEMINI_URL =
            "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.5-flash:generateContent";

    public String summarize(String text) {
    	
    	String prompt = "以下の問診内容を医療従事者が確認しやすいように簡潔に要約してください。"
    	        + "入力されていない情報を推測して補わず、診断や治療の提案はしないでください。\n\n"
    	        + text;

        RestClient restClient = RestClient.create();

        Map<String, Object> requestBody = Map.of(
            "contents", new Object[] {
                Map.of(
                    "parts", new Object[] {
                        Map.of("text", prompt)
                    }
                )
            }
        );
        
        
        String response = restClient.post()
                .uri(GEMINI_URL)
                .header("x-goog-api-key", apiKey)
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .body(requestBody)
                .retrieve()
                .body(String.class);
        
        ObjectMapper mapper = new ObjectMapper();

        JsonNode json = mapper.readTree(response);

        String summary = json
                .path("candidates")
                .path(0)
                .path("content")
                .path("parts")
                .path(0)
                .path("text")
                .stringValue();

        return summary;
    }

}