

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="funciones.Conexion"%>
<%@page import="funciones.Myconexion"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page session="true"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page session='true'%>


<!doctype html>
<html lang="es">
    <head>

        <title>Consulta</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!--        <link href="CSS/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
                <link href="CSS/styleicons.css" rel="stylesheet" type="text/css"/>
                <script src="Scripts/jquery-3.3.1.min.js" type="text/javascript"></script>
                <script src="Scripts/jquery.dataTables.min.js" type="text/javascript"></script>-->


        <link href="CSS/styleicons.css" rel="stylesheet" type="text/css"/>
        <script src="Scripts/jquery-3.3.1.min.js" type="text/javascript"></script>
        <script src="Scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <link href="CSS/jquery.dataTables.min.css" rel="stylesheet" type="text/css"/>
        <script src="https://kit.fontawesome.com/87dc83700d.js" crossorigin="anonymous"></script>

        <script>
            $(document).ready(function () {
                $('#table_id').DataTable();
            });</script>        
        <meta charset="UTF-8">
    </head>
    <body>


        <h2>Consulta</h2>

        <table id="table_id" class="display">
            <thead>
            <th>DISPOSITIVO</th>
            <th>MARCA</th>
            <th>PLACA</th>
            <th>SERIAL</th>
            <th>FECHA INGRESO</th>
            <th>TIPO</th>
            <th>DESCRIPCION</th>
            <th>TARIFA</th>
            <th>OFICINA</th>
            <th>DEPENDENCIA</th>
            <th>Proveedor</th>
            <th>ESTADO</th>


        </thead>
        <%
            String estado = "";
            String SQL = "SELECT ele.Nom_elemento as dispositivo, mar.Descripcion as Marca, inv.placaInventario as placa,  inv.serial, inv.descripcion, inv.FecRIngreso, "
                    + "IFNULL(tip.Nombre,'') as Nombre, IFNULL(tip.Tarifa, '') as Tarifa, oficinas.tx_descrip as Oficina, dep.descripcion as Dependencia, inv.Estado,"
                    + " oficinas.tx_descrip as nombre_oficina,  proveedores.tx_Nombre as Proveedor "
                    + "FROM control_inventarios.inventario as inv "
                    + "LEFT JOIN control_inventarios.categoria as cat on inv.TipoActivo = cat.idcategoria "
                    + "INNER JOIN control_inventarios.marca as mar on inv.Marca_idMarca = mar.idMarca "
                    + "LEFT JOIN control_inventarios.tipoequipos as tip on inv.TipoEquipos_idTipoEquipo = tip.idTipoEquipo "
                    + "LEFT JOIN control_inventarios.dependencias as dep on inv.Dependencia_idDependencia = dep.idDependencia "
                    + "LEFT JOIN segurinet.tbl_oficinas as oficinas on dep.cod_ofi = oficinas.cod_ofi "
                    + "INNER JOIN control_inventarios.elementos as ele on inv.Elementos_idElemento = ele.idElemento "
                    + "LEFT JOIN segurinet.tbl_proveedores as proveedores on inv.cod_proveedor = proveedores.idProveedor "
                    + "WHERE ele.Idcategoria='1' and estado != '5' ;";

//            String SQL = "SELECT ele.Nom_elemento as dispositivo, mar.Descripcion as Marca, inv.placaInventario as placa,  inv.serial, inv.descripcion, inv.FecRIngreso,"
//                    + "  IsNull(tip.Nombre, '') as Nombre ,IsNull(tip.Tarifa, 0) as Tarifa , IsNull(oficinas.tx_descrip, '') as Oficina, IsNull(dep.descripcion, '') as Dependencia, inv.Estado, "
//                    + "oficinas.tx_descrip as nombre_oficina"
//                    + " FROM inventarios.inventario as inv"
//                    + "  FULL OUTER join inventarios.categoria as cat on inv.TipoActivo = cat.idcategoria"
//                    + " inner JOIN inventarios.marca as mar on inv.Marca_idMarca = mar.idMarca "
//                    + " FULL OUTER JOIN inventarios.tipoequipos as tip on inv.TipoEquipos_idTipoEquipo = tip.idTipoEquipo "
//                    + "  FULL OUTER JOIN inventarios.dependencias as dep on inv.Dependencia_idDependencia = dep.idDependencia "
//                    + "FULL OUTER JOIN  segurinet.segurinet.tbl_oficinas as oficinas  on dep.cod_ofi = oficinas.cod_ofi "
//                    + " inner join inventarios.elementos as ele on inv.Elementos_idElemento = ele.idElemento";
            //+ " WHERE TipoActivo='1' or TipoActivo='0'"
            Myconexion cn = new Myconexion();
            Statement st = cn.obtener().createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while (rs.next()) {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        %>


        <tr>
            <td><%=rs.getString("dispositivo")%></td>
            <td><%=rs.getString("marca")%></td>
            <td><%=rs.getString("placa")%></td>
            <td><%=rs.getString("serial")%></td>
            <%Date fecha = formatter.parse(rs.getString("FecRIngreso"));%>
            <td><%=formatter.format(fecha)%></td>
            <td><%= rs.getString("Nombre")%></td>
            <td><%= rs.getString("descripcion")%></td>
            <td><%=rs.getString("Tarifa")%></td>
            <td><%= rs.getString("oficina")%></td>
            <td><%= rs.getString("Dependencia")%></td>
            <td><%= rs.getString("Proveedor")%></td>
            <%int es = rs.getInt("Estado");
                switch (es) {
                    case 1:
                        estado = "Ingresado";
                        break;
                    case 2:
                        estado = "Asignado";
                        break;
                    case 3:
                        estado = "Devuelto";
                        break;
                    case 4:
                        estado = "Entregado";
                        break;
                    case 5:
                        estado = "Baja";
                        break;
                    case 6:
                        estado = "Backup";
                        break;
                    case 8:
                        estado = "Transito";
                        break;

                }

            %>

            <td><%=estado%></td>


        </tr>

        <% }

        %>

    </table>


</body> 
</html>