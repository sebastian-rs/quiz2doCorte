/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.Conexion;
import Dao.CONTEXTO;
import Dao.MODELO;
import Vo.Contexto;
import Vo.Modelo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sebastian RS
 */
public class modelo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {

            int crear;
            int modificar;
            int eliminar;
            
           

            if (request.getParameter("crear") == null) {
                crear = 0;
            } else {
                crear = Integer.parseInt(request.getParameter("crear"));
            }

            if (request.getParameter("modificar") == null) {
                modificar = 0;
            } else {
                modificar = Integer.parseInt(request.getParameter("modificar"));
            }

            if (request.getParameter("eliminar") == null) {
                eliminar = 0;
            } else {
                eliminar = Integer.parseInt(request.getParameter("eliminar"));
            }

            String ID = request.getParameter("ID");
            String nombre = request.getParameter("NAME");
            int id = Integer.parseInt(ID);

            MODELO cr = new MODELO();
            if (crear == 1) {
                Modelo tab = new Modelo(id, nombre);
                Conexion cox = new Conexion();

                try {
                    cr.insert(tab);
                } catch (SQLException ex) {
                    Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
                }
                cox.escribir(id);

                request.getRequestDispatcher("ModelodeNavegacion.jsp").forward(request, response);

            }

        }

    }
}
