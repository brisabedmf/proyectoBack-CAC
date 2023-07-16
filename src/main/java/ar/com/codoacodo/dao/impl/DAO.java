package ar.com.codoacodo.dao.impl;

import java.util.ArrayList;

import ar.com.codoacodo.oop.Usuario;

//el contrato es DAO
//no se pueden instanciar
public interface DAO {
 
    //el que debe hacer el que quiera usar el contrato DAO
    public Usuario getById(Long id) throws Exception;//LA PK DE LA TABLA
    public void delete(Long id) throws Exception;//LA PK DE LA TABLA
    public ArrayList<Usuario> findAll() throws Exception;
    public void update(Usuario usuario) throws Exception;//TIENE ID
    public void create(Usuario usuario) throws Exception;//NO TIENE ID
}
