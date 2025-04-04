package com.sachin.hello.servlet.controller;

import com.sachin.hello.servlet.service.HelloService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class HelloController extends HttpServlet {

    private static final HelloService helloService = new HelloService ();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println ("=========inside doGet() method ===========");

        response.setContentType ("text/html");
        PrintWriter writer = response.getWriter ();
        writer.println ("<html><body>");
        writer.println ("<h1>" + helloService.greet () + "</h1>");
        writer.println ("</body></html>");
    }


    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println ("=========inside service() method ===========");
        this.doGet (request, response);
    }

    public void destroy(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println ("=========inside destroy() method ===========");
    }
}
