package com.java.examples;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet("/ticketDetails")
public class TicketDetailsServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    response.setContentType("application/json");
    System.out.println("inside");
    // Read the JSON file
    String filePath = "src/main/resources/ticketdata.json";
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      String line;
      StringBuilder jsonContent = new StringBuilder();
      while ((line = br.readLine()) != null) {
        jsonContent.append(line);
      }

      // Send the JSON content as the response
      response.getWriter().write(jsonContent.toString());
    } catch (FileNotFoundException e) {
      response.setStatus(HttpServletResponse.SC_NOT_FOUND);
    }
  }
  private List<Ticket> readJsonFile(String filePath) throws IOException {
    List<Ticket> tickets = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
      // Parse the JSON data into a list of Ticket objects
      Type listType = new TypeToken<List<Ticket>>() {}.getType();
      List<Ticket> ticketData = new Gson().fromJson(br, listType);
      ticketData.forEach(System.out::println);
      tickets.addAll(ticketData);
    } catch (IOException e) {
      e.printStackTrace();
    }
    //System.out.println(ticketData);
    return tickets;
  }
}

class Ticket {
  private Map<String, Object> details;

  public Ticket(Map<String, Object> details) {
    this.details = details;
  }

  public Map<String, Object> getDetails() {
    return details;
  }
}
