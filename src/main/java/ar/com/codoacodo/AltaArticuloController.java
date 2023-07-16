//paquete: ar/com/codo
package ar.com.codoacodo;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import ar.com.codoacodo.dao.impl.DAO;
import ar.com.codoacodo.dao.impl.MySQLDAOImpl;
import ar.com.codoacodo.oop.Usuario;

@WebServlet("/AltaArticuloController")
public class AltaArticuloController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AltaArticuloController");
        
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        
        Usuario usuario = new Usuario(username, password, nombre, apellido);
        
        DAO dao = new MySQLDAOImpl();
        
        try {
            dao.create(usuario);
            resp.sendRedirect(req.getContextPath() + "/exito.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/nuevo.jsp");
        }
    }
}