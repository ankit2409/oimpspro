package com.example.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestedUrl = request.getRequestURI();

        if (requestedUrl.equals("/home")) {
            request.getRequestDispatcher("/WEB-INF/home.html").forward(request, response);
        } else if (requestedUrl.equals("/about")) {
            request.getRequestDispatcher("/WEB-INF/about.html").forward(request, response);
        } else if (requestedUrl.equals("/contact")) {
            request.getRequestDispatcher("/WEB-INF/contact.html").forward(request, response);
        } else {
            // Handle unknown URLs or display an error page
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}