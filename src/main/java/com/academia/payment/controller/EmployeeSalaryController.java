package com.academia.payment.controller;

import com.academia.payment.bean.EmployeeSalary;
import com.academia.payment.service.EmployeeSalaryService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/employeeSalary")
public class EmployeeSalaryController {
    EmployeeSalaryService employeeSalaryService = new EmployeeSalaryService();

    /*
        Path: GET /api/bill?studentId={studentId}
        Input: {studentId}
        Response: 200 Status Code with the Bills of the student (if Authorization added, would need to change this)
        Description: Return all bills of the Student with id = {studentId}
    */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSalary(@QueryParam("empId") int empId) {
        List<EmployeeSalary> employeeSalaryList = employeeSalaryService.getSalary(empId);
        return Response.ok().entity(employeeSalaryList).build();
    }

    /*
        Path: DELETE /api/bill/{billId}
        Input: {billId}
        Response: 204 (No Content Created) if deletion successful, else return 400 (Bad Request)
        Description: Delete the bill with id = {billId}
    */
    @POST
    @Path("/{sId}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteSalary(@PathParam("sId") Integer sId) {
        Boolean successfulPayment = employeeSalaryService.paySalary(sId);
        if (successfulPayment)
            return Response.status(204).build();
        else
            return Response.status(400).build();
    }
}
//    public Response deleteBill(@PathParam("billId") Integer billId) {
//        Boolean successfulPayment = billService.payBill(billId);
//        if (successfulPayment)
//            return Response.status(204).build();
//        else
//            return Response.status(400).build();
//    }