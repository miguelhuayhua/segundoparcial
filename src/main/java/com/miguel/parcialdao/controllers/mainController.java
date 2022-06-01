package com.miguel.parcialdao.controllers;

import com.miguel.parcialdao.dao.participanteDAOImplement;
import com.miguel.parcialdao.dao.seminarioDAOImplement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "mainController", urlPatterns = {"/"})
public class mainController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("seminarioLista", new seminarioDAOImplement().getAll());
        request.setAttribute("participanteLista", new participanteDAOImplement().getAll());

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
