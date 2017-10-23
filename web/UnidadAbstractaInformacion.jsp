<%@page import="Vo.Tabla"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="Dao.Conexion"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Quiz</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body bgcolor="#ffffff" background="fondo.jpg">

    <center>

        <h1>Unidad Abstracta De Informacion</h1>
        <img src="logo.PNG" border="4"  width="220" height="190"/>  


    </center>



    <center>
        <table >
            <tr >
                <th><strong>ID</strong></th>
                <th><strong>Name</strong></th>
                <th><strong>Tabla</strong></th>

            </tr>
            <form action="Unidad" method="post"> 
                <tr >

                    <td><input class="contact" type="text" name="ID" value="" /></td>
                    <td><input class="contact" type="text" name="NAME" value="" /></td>
                    <td><input class="contact" type="text" name="TABLA" value="" /></td> 

                    <%

                        Conexion cox = new Conexion();
                        List<Tabla> tablas = cox.findAll();

                        out.println("<h1>" + "Escoja la tabla en la que desea guardar" + "</h1>");

                        ArrayList<String> nombres = new ArrayList<String>();
                        ArrayList<Integer> id = new ArrayList<Integer>();
                        ;

                        for (int i = 0; i < tablas.size(); i++) {
                            nombres.add(tablas.get(i).getNameTabla());
                            id.add(tablas.get(i).getIdTabla());

                        }

                        out.println("<h2> Name: " + nombres.toString() + "</h2>");
                        out.println("<h2> Id: " + id.toString() + "</h2>");


                    %>


                    <td ><input style="background-color: #ffff33" class="submit" type="submit" name="crear"  value="Crear " onClick="value = 1" > <td> 
                    <td> <input style="background-color: #ffff33" class="submit" type="submit" name="modificar"  value="Modificar" onClick="value = 2" > <td>
                    <td> <input style="background-color: #ffff33" class="submit" type="submit" name="eliminar"  value="Eliminar" onClick="value = 3" > <td>

            </form>
            </tr>


        </table>




        <table >
            <tr>
                <td> <a href="List.jsp" ><input style="background-color: #33ffff" class="submit" type="submit" name="venta_registrada" value="Listar todo" /> </td>              
                <td> <a href="About.jsp" ><input style="background-color: #33ffff" class="submit" type="submit" name="venta_registrada" value="About" /> </td>
            </tr>
        </table>

    </center>




</body>
</html>
