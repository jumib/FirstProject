package com.example.demo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // pathPattern 인자에 해당하는 /**은 모든 파일 디렉토리 등등을 의미 (모든 URL을 사용하겠다)
        // 그리고 8080 서비스 포트로 들어오는 요청을 인가함을 의미한다 (서비스를 찾아갈 때 포트를 찾아간다)
        // 특정 IP에 대한 요청을 수락하는 작업 (밑에서 127.0.0.1 과 localhost는 같은 의미임)
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:8080")
                .allowedOrigins("http://localhost:8080");
    }
}
