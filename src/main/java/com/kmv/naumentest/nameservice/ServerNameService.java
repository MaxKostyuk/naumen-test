package com.kmv.naumentest.nameservice;

import com.kmv.naumentest.model.NameAge;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ServerNameService {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String serverUrl = "https://api.agify.io/?name=";

    public Integer getAge(String name) {
        String url = serverUrl + name;
        NameAge nameAge = restTemplate.getForEntity(url, NameAge.class).getBody();
        return nameAge.getAge();
    }
}
