package com.example.demo.today;

import java.io.PrintWriter;
import java.util.Calendar;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SpringBootApplication
@RestController
public class Today {

    @GetMapping("/today")
    public void main(HttpServletRequest request, HttpServletResponse response){
        String year = request.getParameter("year");
        String month = request.getParameter("month");
        String day = request.getParameter("day");

        int yyyy = Integer.parseInt(year);
        int mm = Integer.parseInt(month);
        int dd = Integer.parseInt(day);

        Calendar cal = Calendar.getInstance();
        cal.set(yyyy, mm - 1, dd);

        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        char todayStr = " 일월화수목금토".charAt(dayOfWeek);

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        //PrintWriter out = response.getWriter();
    }
    
}
