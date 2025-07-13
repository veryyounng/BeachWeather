package com.example.demo.controller;

import com.example.demo.service.BeachWeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
@RequestMapping("/api/beach")
public class BeachWeatherController {

    private final BeachWeatherService beachWeatherService;

    public BeachWeatherController(BeachWeatherService beachWeatherService) {
        this.beachWeatherService = beachWeatherService;
    }

    @GetMapping("/test")
    public String test() {
        return "Spring Boot 연결 성공!";
    }

    @GetMapping("/ultra")
    public String callBeachApi() {
        StringBuffer result = new StringBuffer();
        try {
            String urlStr = "https://apis.data.go.kr/1360000/BeachInfoservice/getUltraSrtFcstBeach?serviceKey=RVuBcJu7WLxnDOcBSYfrJUHKDqnt0uoFElNmUIZSgDcHC3hfB2fw5I83g2JtLaDinp7EDGcU4A9e%2FjdcHUXjsg%3D%3D&numOfRows=10&pageNo=1&dataType=JSON&base_date=20250712&base_time=0800&beach_num=1"; // 네 API URL
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "UTF-8"));

            String returnLine;
            while ((returnLine = br.readLine()) != null) {
                result.append(returnLine + "\n");
            }

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            return "API 호출 중 에러 발생: " + e.getMessage();
        }

        return result.toString();
    }
}

