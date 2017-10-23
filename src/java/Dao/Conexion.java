package Dao;

import Vo.Tabla;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conexion {

    private static Connection CONEXION = null;

    public static Connection getConnection() throws SQLException {
        if (CONEXION == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //Integracion Log4J
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            } catch (InstantiationException e) {
                //Integracion Log4J
                throw new SQLException(e);
            } catch (IllegalAccessException e) {
                //Integracion Log4J
                throw new SQLException(e);
            }

            try {
                CONEXION = DriverManager.getConnection("jdbc:mysql://localhost:3306/websql", "root", "root");
                System.out.println("voy");
            } catch (SQLException e) {
                throw new SQLException(e);
            }

        }

        return CONEXION;
    }

    public static void closeConnection() throws SQLException {
        try {
            if (CONEXION != null) {
                CONEXION.close();
                CONEXION = null;
            }

        } catch (SQLException e) {
            //Integracion Log4J
            throw new SQLException(e);
        }

    }

    public long tamanio;

    public boolean escribir(int id) throws FileNotFoundException, IOException {

        RandomAccessFile Esquema
                = new RandomAccessFile("modelo3.txt", "rw");

        tamanio = Esquema.length();
        Esquema.seek(tamanio);
        Esquema.writeInt(id);

        return true;
    }

    public boolean escribir2(int id) throws FileNotFoundException, IOException {

        RandomAccessFile Esquema
                = new RandomAccessFile("contexto3.txt", "rw");

        tamanio = Esquema.length();
        Esquema.seek(tamanio);
        Esquema.writeInt(id);

        return true;
    }

    public int leer() throws IOException, ClassNotFoundException {

        RandomAccessFile Esquema
                = new RandomAccessFile("modelo3.txt", "rw");

        tamanio = Esquema.length();
        int numeroIteraciones = (int) tamanio / 4;
        Esquema.seek(0);
        int temp = 0;
        for (int i = 0; i < numeroIteraciones; i++) {
            temp = Esquema.readInt();;
        }

        return temp;
    }

    public int leer2() throws IOException, ClassNotFoundException {

        RandomAccessFile Esquema
                = new RandomAccessFile("contexto3.txt", "rw");

        tamanio = Esquema.length();
        int numeroIteraciones = (int) tamanio / 4;
        Esquema.seek(0);
        int temp = 0;
        for (int i = 0; i < numeroIteraciones; i++) {
            temp = Esquema.readInt();;
        }

        return temp;
    }

    public List<Tabla> findAll() throws SQLException {
        List<Tabla> departamentos = null;
        String query = "SELECT * FROM tablee";
        Connection connection = Conexion.getConnection();
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            int id = 0;
            String nombre = null;
            int id2 = 0;

            while (rs.next()) {
                if (departamentos == null) {
                    departamentos = new ArrayList<Tabla>();
                }

                Tabla registro = new Tabla();
                id = rs.getInt("IdTable");
                registro.setIdTabla(id);

                nombre = rs.getString("NameTable");
                registro.setNameTabla(nombre);

                id2 = rs.getInt("Idschema2");
                registro.setDesicion(id2);

                departamentos.add(registro);
            }
            st.close();

        } catch (SQLException e) {
            System.out.println("Problemas al obtener la lista de Departamentos");
            e.printStackTrace();
        }

        return departamentos;
    }

}
