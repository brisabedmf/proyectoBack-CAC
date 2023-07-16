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


@WebServlet("/EditarController")
public class EditarController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        
        DAO dao = new MySQLDAOImpl();
        
        try {
            Usuario usuario = dao.getById(Long.parseLong(id));
            req.setAttribute("usuario", usuario);
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "No se ha encontrado el artículo");
        }
        
        getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String nombre = req.getParameter("nombre");
        String apellido = req.getParameter("apellido");
        
        Usuario usuario = new Usuario(username, password, nombre, apellido, Long.parseLong(id));
        
        DAO dao = new MySQLDAOImpl();
        
        try {
            dao.update(usuario);
            resp.sendRedirect(req.getContextPath() + "/exito.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "No se pudo actualizar el artículo");
            getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
        }
    }
}