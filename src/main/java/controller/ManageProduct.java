/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dao.HoaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Hoa;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "ManageProduct", urlPatterns = {"/ManageProduct"})
public class ManageProduct extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        HoaDAO hoaDAO = new HoaDAO();
        String action = "list";

        if (request.getParameter("action") != null)
        {
            action = request.getParameter("action");
        }
        switch (action) {
            case "list":
                ArrayList<Hoa> dsHoa = hoaDAO.getAll();
                request.setAttribute("dsHoa", dsHoa);
                request.getRequestDispatcher("admin/list_product.jsp").forward(request, response);
                break;
            case "add":
                System.out.println("add");
                //Xử lý giao diện thêm mới
                request.getRequestDispatcher("admin/add_product.jsp").forward(request, response);
                break;
            case "edit":
                System.out.println("edit");
                request.getRequestDispatcher("admin/edit_product.jsp").forward(request, response);
                break;
            case "update":
                System.out.println("update");
                //xử lý cập nhật sản phẩm
                break;
            case "delete":
                System.out.println("delete");
                //Xử lý xoá sản phẩm
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
