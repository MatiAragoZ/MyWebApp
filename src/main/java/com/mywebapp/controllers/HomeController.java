package com.mywebapp.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí puedes realizar cualquier lógica adicional antes de redirigir a la página de inicio
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }
}

