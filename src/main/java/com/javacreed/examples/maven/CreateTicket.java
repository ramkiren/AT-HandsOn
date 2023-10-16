package com.javacreed.examples.maven;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/createticket")
public class CreateTicket extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws  IOException {


        String subject = request.getParameter("subject");
        String description = request.getParameter("description");
        String priority = request.getParameter("priority");


        if (subject != null && description != null && priority != null) {
            System.out.println(subject);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Missing mandatory fields");
            return;
        }


        System.out.println("Subject: " + subject);
        System.out.println("Description: " + description);
        System.out.println("Priority: " + priority);
        response.getWriter().write("Ticket created successfully");
    }
}
