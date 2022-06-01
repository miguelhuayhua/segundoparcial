/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.miguel.parcialdao.controllers;

import com.miguel.parcialdao.dao.seminarioDAOImplement;
import com.miguel.parcialdao.models.Seminario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "seminarioController", urlPatterns = {"/seminario"})
public class seminarioController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String type = request.getParameter("type");
        if (type == null) {
            request.setAttribute("seminario", new Seminario(0, 0, "", ""));
            request.getRequestDispatcher("seminario.jsp").forward(request, response);
        } else if (type.equals("UPDATE")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Seminario seminario = new seminarioDAOImplement().getById(id);
            request.setAttribute("seminario", seminario);
            request.getRequestDispatcher("seminario.jsp").forward(request, response);
            
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Seminario seminario = new Seminario();
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String fecha = request.getParameter("fecha");
        int cupo = Integer.parseInt(request.getParameter("cupo"));
        
        seminario.setId(id);
        seminario.setTitulo(titulo);
        seminario.setFecha(fecha);
        seminario.setCupo(cupo);
        new seminarioDAOImplement().updateSeminario(seminario);
        response.sendRedirect("/segundoparcial");
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
