package com.employee_servlet_jsp;

import java.io.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/employee-servlet")
public class EmployeeControllerServlet extends HttpServlet {
    EmployeeUtil employeeUtil;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            employeeUtil = new EmployeeUtil();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String theCommand = request.getParameter("command");
        if (theCommand == null){
            theCommand = "LIST";
        }
       switch (theCommand){
           case "LIST":
               listEmployee(request,response);
               break;
           case "ADD":
               addEmployee(request,response);
               break;
           case "LOAD":
               loadEmployee(request,response);
               listEmployeeINF(request,response);
               break;
           case "INF":
               listEmployeeINF(request,response);
           case "DELETE":
               deleteEmployee(request,response);
           default:
               listEmployee(request,response);

       }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("employeeId");
        Integer idInt = Integer.parseInt(id);
        employeeUtil.deleteEmployee(idInt);
    }

    private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fathersName = request.getParameter("fathersname");
        String nationalCode = request.getParameter("ncode");
        String phoneNumber = request.getParameter("pnumber");
        String address = request.getParameter("address");
        String id = request.getParameter("employeeId");
        int idInt = Integer.parseInt(id);
        EmployeeINF employeeINF = new EmployeeINF();
        employeeINF.setFathersName(fathersName);
        employeeINF.setNationalCode(nationalCode);
        employeeINF.setPhoneNumber(phoneNumber);
        employeeINF.setAddress(address);
        employeeUtil.addEmployeeINF(employeeINF);
        employeeUtil.updateEmployINF(idInt,employeeINF);




    }

    private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employeeUtil.addEmployee(employee);
        listEmployee(request,response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeUtil.getAllEmployees();
        request.setAttribute("EL",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-employee.jsp");
        dispatcher.forward(request,response);
    }

    private void listEmployeeINF(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeUtil.getAllEmployees();
        request.setAttribute("ELINF",employeeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("showinf.jsp");
        dispatcher.forward(request,response);
    }


}


