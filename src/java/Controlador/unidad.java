/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Dao.Conexion;
import Dao.CONTEXTO;
import Dao.UNIDAD;
import Vo.Contexto;
import Vo.Unidad;
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
public class unidad extends HttpServlet {

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
            String Tabla = request.getParameter("TABLA");
            int id = Integer.parseInt(ID);
            int tab2 = Integer.parseInt(Tabla);

            UNIDAD cr = new UNIDAD();
            if (crear == 1) {
                Unidad tab = new Unidad(id, nombre, tab2,crear);
                Conexion cox = new Conexion();

                try {
                    cr.insert(tab);
                } catch (SQLException ex) {
                    Logger.getLogger(Unidad.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Unidad.class.getName()).log(Level.SEVERE, null, ex);
                }

                cox.escribir2(id);

                request.getRequestDispatcher("Contexto Navegacion.jsp").forward(request, response);

            }

        }

    }

}
