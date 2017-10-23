/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;



import Controlador.modelo;
import Vo.Contexto;
import Vo.Modelo;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JCBOT
 */
public class MODELO {

    public List<Modelo> findAll() throws SQLException {
        List<Modelo> departamentos = null;
        String query = "SELECT * FROM ModeloNavegacion";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String nombre = null;
            int id2=0;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Modelo>();
                }

                Modelo registro = new Modelo();
                id = rs.getInt("Idmodelo");
                registro.setIdModelo(id);

                nombre = rs.getString("Name");
                registro.setNameModelo(nombre);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

    public boolean insert(Modelo t) throws SQLException, IOException, ClassNotFoundException {
        boolean result = false;
        Connection connection = Conexion.getConnection();
        String query = " insert into ModeloNavegacion (Idmodelo,Name) " + "values (?,?)";
        PreparedStatement preparedStmt = null;
        Conexion cox= new Conexion();
   
        try {
            preparedStmt = connection.prepareStatement(query);
            preparedStmt.setInt(1, t.getIdModelo());
            preparedStmt.setString(2, t.getNameModelo());
            result = preparedStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
}
