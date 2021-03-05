package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.text.SimpleDateFormat;
import funciones.Conexion;
import funciones.Myconexion;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

public final class Consulta_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"es\">\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <title>Consulta</title>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("\n");
      out.write("        <!--        <link href=\"CSS/jquery.dataTables.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("                <link href=\"CSS/styleicons.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("                <script src=\"Scripts/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("                <script src=\"Scripts/jquery.dataTables.min.js\" type=\"text/javascript\"></script>-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <link href=\"CSS/styleicons.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("        <script src=\"Scripts/jquery-3.3.1.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"Scripts/jquery.dataTables.min.js\" type=\"text/javascript\"></script>\n");
      out.write("        <link href=\"CSS/jquery.dataTables.min.css\" rel=\"stylesheet\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function () {\n");
      out.write("                $('#table_id').DataTable();\n");
      out.write("            });</script>        \n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <h2>Consulta</h2>\n");
      out.write("\n");
      out.write("        <table id=\"table_id\" class=\"display\">\n");
      out.write("            <thead>\n");
      out.write("            <th>DISPOSITIVO</th>\n");
      out.write("            <th>MARCA</th>\n");
      out.write("            <th>PLACA</th>\n");
      out.write("            <th>SERIAL</th>\n");
      out.write("            <th>FECHA INGRESO</th>\n");
      out.write("            <th>TIPO</th>\n");
      out.write("            <th>DESCRIPCION</th>\n");
      out.write("            <th>TARIFA</th>\n");
      out.write("            <th>OFICINA</th>\n");
      out.write("            <th>DEPENDENCIA</th>\n");
      out.write("            <th>ESTADO</th>\n");
      out.write("\n");
      out.write("        </thead>\n");
      out.write("        ");

            String estado = "";
             String SQL = "SELECT ele.Nom_elemento as dispositivo, mar.Descripcion as Marca, inv.placaInventario as placa,  inv.serial, inv.descripcion, inv.FecRIngreso, "
                    + "IFNULL(tip.Nombre,'') as Nombre, IFNULL(tip.Tarifa, '') as Tarifa, oficinas.tx_descrip as Oficina, dep.descripcion as Dependencia, inv.Estado, oficinas.tx_descrip as nombre_oficina "
                    + "FROM control_inventarios.inventario as inv "
                    + "LEFT JOIN control_inventarios.categoria as cat on inv.TipoActivo = cat.idcategoria "
                    + "INNER JOIN control_inventarios.marca as mar on inv.Marca_idMarca = mar.idMarca "
                    + "LEFT JOIN control_inventarios.tipoequipos as tip on inv.TipoEquipos_idTipoEquipo = tip.idTipoEquipo "
                    + "LEFT JOIN control_inventarios.dependencias as dep on inv.Dependencia_idDependencia = dep.idDependencia "
                    + "LEFT JOIN segurinet.tbl_oficinas as oficinas on dep.cod_ofi = oficinas.cod_ofi "
                    + "INNER JOIN control_inventarios.elementos as ele on inv.Elementos_idElemento = ele.idElemento "
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
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("            <td>");
      out.print(rs.getString("dispositivo"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(rs.getString("marca"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(rs.getString("placa"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(rs.getString("serial"));
      out.write("</td>\n");
      out.write("            ");
Date fecha = formatter.parse(rs.getString("FecRIngreso"));
      out.write("\n");
      out.write("            <td>");
      out.print(formatter.format(fecha));
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("Nombre"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("descripcion"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print(rs.getString("Tarifa"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("oficina"));
      out.write("</td>\n");
      out.write("            <td>");
      out.print( rs.getString("Dependencia"));
      out.write("</td>\n");
      out.write("            ");
int es = rs.getInt("Estado");
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

            
      out.write("\n");
      out.write("\n");
      out.write("            <td>");
      out.print(estado);
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        ");
 }

        
      out.write("\n");
      out.write("\n");
      out.write("    </table>\n");
      out.write("\n");
      out.write("\n");
      out.write("</body> \n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
