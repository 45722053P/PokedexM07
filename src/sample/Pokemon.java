package sample;

/**
 * Created by 45722053p on 18/12/15.
 */
public class Pokemon {
    private String nombre;
    private int id;
    private int hp;
    private String peso;
    private String tipo;
    private String imagen;



    public Pokemon(int id,String nombre){
        this.id=id;
        this.nombre=nombre;
    }
    public Pokemon(String nombre, int hp, String peso) {
        this.nombre = nombre;
        this.hp = hp;
        this.peso = peso;

    }

    public Pokemon(String nombre, int hp, int peso) {

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return id +"--" +nombre;
    }
}
