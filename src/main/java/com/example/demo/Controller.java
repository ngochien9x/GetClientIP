package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.StringTokenizer;

@RestController
public class Controller {
    @RequestMapping(value = "/information")
    public String showInformation(HttpServletRequest request) {

        System.out.println("\n\n CLIENT IP ADDRESS: " + getClientIP(request));
        return getClientIP(request);
    }

    private String getClientIP(HttpServletRequest request) {
        String xForwardedForHeader = request.getHeader("X-Forwarded-For");
        if (xForwardedForHeader == null) {
            return request.getRemoteAddr();
        } else {
            return new StringTokenizer(xForwardedForHeader, ",").nextToken().trim();
        }
    }
}
