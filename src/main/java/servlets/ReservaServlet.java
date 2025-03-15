/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import model.Reserva;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sofar
 */
@WebServlet(name = "ReservaServlet", urlPatterns = {"/ReservaServlet"})
public class ReservaServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static List<Reserva> reservas = new ArrayList<>();

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
        response.setContentType("text/html;charset=UTF-8");
        
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
        String nombre = request.getParameter("nombre");
        String fecha = request.getParameter("fecha");
        String espacio = request.getParameter("espacio");
        String duracionStr = request.getParameter("duracion");
        
        if (nombre == null || fecha == null || espacio == null || duracionStr == null || nombre.isEmpty() || fecha.isEmpty() || duracionStr.isEmpty()) {
            response.getWriter().println("Error: Todos los campos son obligatorios.");
            return;
        }
        
        int duracion = Integer.parseInt(duracionStr);
        Reserva reserva = new Reserva(nombre, fecha, espacio, duracion);
        reservas.add(reserva);
        
        // Redirige de vuelta al formulario con campos vacíos
        response.sendRedirect("index.html");
    }
    
    public static List<Reserva> getReservas() {
        return reservas;
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
