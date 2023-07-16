package ar.com.codoacodo.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ar.com.codoacodo.db.AdministradorDeConexiones;
import ar.com.codoacodo.oop.Usuario;

public class MySQLDAOImpl implements DAO{
    
    //atributos
    private String tableName;

    //constructor 
    public MySQLDAOImpl() {
        this.tableName = "usuarios";
    }

    //metodos
    //va a cumplir ese contrato entre DAO y esta clase
    public Usuario getById(Long id) throws Exception {//1
        String sql = "select * from "+this.tableName+" where id =?";

        //Obtener la Conection
        Connection con = AdministradorDeConexiones.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        Usuario usuario = null;

        ResultSet res = pst.executeQuery();

        if(res.next()) {
            Long _id = res.getLong(1);
            String userName = res.getString(2);
            String password = res.getString(3);
            String nombre = res.getString(4);
            String apellido = res.getString(5);

            usuario = new Usuario(userName, password, nombre, apellido,_id);
        }
        return usuario;
    }


    @Override
    public void delete(Long id) throws Exception {
        String sql = "delete from "+this.tableName+" where id = ? ";
        
        //Obtener la Conection
        Connection con = AdministradorDeConexiones.getConnection();

        //PreparedStatement con mi sql
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1,id);

        pst.executeUpdate();
    }

    @Override
    public ArrayList<Usuario> findAll() throws Exception{
        String sql = "select * from "+this.tableName+"";

        return findBySQL(sql);
    }

    @Override
    public void update(Usuario usuario) throws Exception {
        // Implementación específica para actualizar un usuario
        String sql = "update "+this.tableName+" set password=? where id=?";

        Connection con = AdministradorDeConexiones.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1, usuario.getId());
        pst.setString(3, usuario.getPassword());

        pst.executeUpdate();
    }

    @Override
    public void create(Usuario usuario) throws Exception {
        // Implementación específica para crear un usuario
        String sql = "insert into "+this.tableName;
        sql += "(userName, password, nombre, apellido) ";
        sql += "values (?,?,?,?) ";

        Connection con = AdministradorDeConexiones.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, usuario.getUsername());
        pst.setString(2, usuario.getPassword());
        pst.setString(3, usuario.getNombre());
        pst.setString(4, usuario.getApellido());

        pst.executeUpdate();
    }

    private ArrayList<Usuario> findBySQL(String sql) throws SQLException {
        Connection con = AdministradorDeConexiones.getConnection();
        PreparedStatement pst = con.prepareStatement(sql);

        ArrayList<Usuario> listado = new ArrayList<>();

        ResultSet res = pst.executeQuery();

        while (res.next()) {
            Long id = res.getLong(1);
            String userName = res.getString(2);
            String password = res.getString(3);
            String nombre = res.getString(4);
            String apellido = res.getString(5);

            listado.add(new Usuario(userName, password, nombre, apellido,id));
        }

        return listado;
    }

}   