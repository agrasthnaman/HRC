package com.highradius.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.dao.UserDAO;
import com.highradius.dao.UserDaoImpl;
import com.highradius.model.POJO;

@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerOrderID;
        int customerNumber;
        double amountUSD;
        java.util.Date orderCreationDate;
        try {
            customerOrderID = Integer.parseInt(request.getParameter("customerOrderID"));
            customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
            amountUSD = Double.parseDouble(request.getParameter("amountUSD"));
            orderCreationDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("orderCreationDate"));
        } catch (NumberFormatException | ParseException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("Invalid request parameters.");
            return;
        }

        String salesOrg = request.getParameter("salesOrg");
        String distributionChannel = request.getParameter("distributionChannel");
        String companyCode = request.getParameter("companyCode");
        String orderCurrency = request.getParameter("orderCurrency");

        // Create a new POJO object with the provided data
        POJO newUser = new POJO(customerOrderID, salesOrg, distributionChannel, customerNumber, companyCode,
                orderCurrency, amountUSD, orderCreationDate);

        try {
            // Insert the new user
            userDAO.insertUser(newUser);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("User inserted successfully.");
            
        } catch (SQLException e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Error inserting user: " + e.getMessage());
        }
    }
}
