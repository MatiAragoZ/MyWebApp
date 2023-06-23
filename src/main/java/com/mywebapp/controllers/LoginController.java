package com.mywebapp.controllers;

import com.mywebapp.models.User;
import com.mywebapp.services.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {
    private UserService userService;

    public void init() {
        userService = new UserService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = userService.login(username, password);
        if (user != null) {
            // Inicio de sesión exitoso, redirigir a la página de inicio
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            // Credenciales inválidas, mostrar mensaje de error y redirigir a la página de inicio de sesión
            request.setAttribute("error", "Credenciales inválidas");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
