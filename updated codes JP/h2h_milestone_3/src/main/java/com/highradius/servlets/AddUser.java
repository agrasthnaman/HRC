package com.highradius.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.dao.UserDAO;
import com.highradius.dao.UserDaoImpl;
import com.highradius.model.POJO;

@WebServlet("/AddUser")
public class AddUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int customerOrderID = Integer.parseInt(request.getParameter("customerOrderID"));
        String salesOrg = request.getParameter("salesOrg");
        String distributionChannel = request.getParameter("distributionChannel");
        int customerNumber = Integer.parseInt(request.getParameter("customerNumber"));
        String companyCode = request.getParameter("companyCode");
        String orderCurrency = request.getParameter("orderCurrency");
        double amountUSD = Double.parseDouble(request.getParameter("amountUSD"));
        // Assuming the orderCreationDate is passed as a string in the format "yyyy-MM-dd"
        String orderCreationDateStr = request.getParameter("orderCreationDate");

        try {
            // Convert orderCreationDate string to java.util.Date
            java.util.Date orderCreationDate = new SimpleDateFormat("yyyy-MM-dd").parse(orderCreationDateStr);

            // Create a new POJO object with the provided data
            POJO newUser = new POJO(customerOrderID, salesOrg, distributionChannel, customerNumber, companyCode,
                    orderCurrency, amountUSD, orderCreationDate);

            // Insert the new user
            userDAO.insertUser(newUser);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
