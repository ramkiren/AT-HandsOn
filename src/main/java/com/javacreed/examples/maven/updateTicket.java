package com.javacreed.examples.maven;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/updateticket")
public class updateTicket extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String ticketId = request.getParameter("id");
        String subject = request.getParameter("subject");
        String description = request.getParameter("description");
        String priority = request.getParameter("priority");


        if (ticketId != null && !ticketId.isEmpty()) {

            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().write("Ticket updated successfully");
        } else {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid input");
        }
    }
}
