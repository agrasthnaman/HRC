package com.highradius.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.highradius.dao.UserDAO;
import com.highradius.dao.UserDaoImpl;
import com.highradius.model.POJO;

@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;

    public void init() {
        userDAO = new UserDaoImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int CUSTOMER_ORDER_ID = Integer.parseInt(request.getParameter("CUSTOMER_ORDER_ID"));
        String SALES_ORG = request.getParameter("SALES_ORG");
        String DISTRIBUTION_CHANNEL = request.getParameter("DISTRIBUTION_CHANNEL");
        int CUSTOMER_NUMBER = Integer.parseInt(request.getParameter("CUSTOMER_NUMBER"));
        String COMPANY_CODE = request.getParameter("COMPANY_CODE");
        String ORDER_CURRENCY = request.getParameter("ORDER_CURRENCY");
        double AMOUNT_IN_USD = Double.parseDouble(request.getParameter("AMOUNT_IN_USD"));
        // Assuming the ORDER_CREATION_DATE is passed as a string in the format "yyyy-MM-dd"
        String orderCreationDateStr = request.getParameter("ORDER_CREATION_DATE");

        try {
            // Convert ORDER_CREATION_DATE string to java.util.Date
            Date ORDER_CREATION_DATE = new SimpleDateFormat("yyyy-MM-dd").parse(orderCreationDateStr);

            // Create a new POJO object with the updated data
            POJO updatedUser = new POJO(CUSTOMER_ORDER_ID, SALES_ORG, DISTRIBUTION_CHANNEL, CUSTOMER_NUMBER, COMPANY_CODE,
                    ORDER_CURRENCY, AMOUNT_IN_USD, ORDER_CREATION_DATE);

            // Update the user
            userDAO.updateUser(updatedUser);
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
