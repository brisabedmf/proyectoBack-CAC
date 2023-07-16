package ar.com.codoacodo.oop;

public class Usuario {
    //atributos
    protected Long id;
    protected String username;
    protected String password;
    protected String nombre;
    protected String apellido;

    //Constructores
    public Usuario(String username, String password, String nombre, String apellido){
        extracted(username,password,nombre,apellido);
    }

    public Usuario(String username, String password, String nombre, String apellido, Long id){
        extracted(username,password,nombre,apellido);
        this.id=id;
    }

    private void extracted(String username, String password, String nombre, String apellido) {
        this.username= username;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}