package com.academia.payment.controller;

import com.academia.payment.bean.Employee;
import com.academia.payment.service.EmployeeSelectService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employeeSelect")
public class EmployeeSelectController {
    EmployeeSelectService employeeSelectService = new EmployeeSelectService();

    /*
        Path: GET /api/bill?studentId={studentId}
        Input: {studentId}
        Response: 200 Status Code with the Bills of the student (if Authorization added, would need to change this)
        Description: Return all bills of the Student with id = {studentId}
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployee(@QueryParam("empId") int empId) {
        List<Employee> employeeSelectList = employeeSelectService.getEmployee(empId);
        return Response.ok().entity(employeeSelectList).build();
    }
}
