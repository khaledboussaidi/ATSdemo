package com.example.ATS.consummer;

import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class ATSConsumer {
    private static final RestTemplate restTemplate=new RestTemplate();


    public JSONObject getProductsFromATS() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<JSONObject> entity = new HttpEntity<JSONObject>(headers);
        return  restTemplate.exchange("http://test.ats-digital.com:3000/products?size=10", HttpMethod.GET, entity, JSONObject.class).getBody();
}



}
