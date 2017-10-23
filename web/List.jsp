
<%@page import="Vo.Unidad"%>
<%@page import="Vo.Contexto"%>
<%@page import="Vo.Modelo"%>
<%@page import="Dao.Conexion"%>
<%@page import="Dao.UNIDAD"%>
<%@page import="Dao.CONTEXTO"%>
<%@page import="Dao.MODELO"%>
<%@page import="Vo.Tabla"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Web Sql</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body bgcolor="#ffffff" background="fondo.jpg">

    <center>
        <p>&nbsp;</p>
        <h1>Lista</h1>
        <img src="logo.PNG" border="4"  width="300" height="260"/>  



        <h1>ID-----------------------------NAME-------------FOREING ID     </h1>

        <%

            MODELO mod = new MODELO();
            UNIDAD unid = new UNIDAD();
            CONTEXTO con = new CONTEXTO();
            Conexion cone = new Conexion();

            List<Modelo> modelos = mod.findAll();
            List<Contexto> contextos = con.findAll();
            List<Unidad> unidades = unid.findAll();
            List<Tabla> tablas = cone.findAll();

            for (int i = 0; i < modelos.size(); i++) {

                out.println("<h1>" + modelos.get(i).getIdModelo() + "----" + modelos.get(i).getNameModelo() + "</h1>");

                for (int j = 0; j < contextos.size(); j++) {
                    if (modelos.get(j).getIdModelo() == contextos.get(i).getDesicion()) {
                        out.println("<h1>" + contextos.get(j).getIdContexto() + "----" + contextos.get(j).getNameContexto() + "----" + contextos.get(j).getDesicion() + "</h1>");

                    }

                }

                for (int j = 0; j < unidades.size(); j++) {
                    if (unidades.get(j).getDecision() == contextos.get(i).getIdContexto()) {
                        out.println("<h1>" + unidades.get(j).getIdUnidad() + "----" + unidades.get(j).getNameUnidad()+"----" + unidades.get(j).getIdtabla()+ "----" + unidades.get(j).getDecision() + "</h1>");

                    }

                }

                for (int j = 0; j < tablas.size(); j++) {
                    if (tablas.get(j).getIdTabla() == unidades.get(i).getIdtabla()) {
                        out.println("<h1>" + tablas.get(j).getIdTabla() + "----" + tablas.get(j).getNameTabla() + "</h1>");

                    }

                }

            }


        %>




    </center>


</body>
</html>
