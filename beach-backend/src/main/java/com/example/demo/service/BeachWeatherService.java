package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
public class BeachWeatherService {

    private final String DECODED_SERVICE_KEY = "RVuBcJu7WLxnDOcBSYfrJUHKDqnt0uoFElNmUIZSgDcHC3hfB2fw5I83g2JtLaDinp7EDGcU4A9e/jdcHUXjsg==";

    public String getUltraSrtFcstBeach() {
        String url = UriComponentsBuilder
                .fromHttpUrl("https://apis.data.go.kr/1360000/BeachInfoservice/getUltraSrtFcstBeach")
                .queryParam("serviceKey", DECODED_SERVICE_KEY) // 🔥 인코딩 전 원본 키 사용
                .queryParam("numOfRows", "10")
                .queryParam("pageNo", "1")
                .queryParam("dataType", "JSON")
                .queryParam("base_date", "20250712")
                .queryParam("base_time", "0800")
                .queryParam("beach_num", "1")
                .build(true) // ✅ 인코딩 자동 처리
                .toUriString();

        log.info("요청 URL: {}", url);

        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
