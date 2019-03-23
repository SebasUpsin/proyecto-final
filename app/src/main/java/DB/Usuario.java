package DB;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int ID;
    private String nombre;
    private int puntuacionModuloUno;
    private int puntuacionModuloDos;
    private int puntuacionModuloTres;

    public Usuario(){
        this.setID(0);
        this.setNombre("");
        this.setPuntuacionModuloUno(0);
        this.setPuntuacionModuloDos(0);
        this.setPuntuacionModuloTres(0);
    }

    public Usuario(int ID, String nombre, int puntuacionModuloUno, int puntuacionModuloDos, int puntuacionModuloTres){
        this.setID(ID);
        this.setNombre(nombre);
        this.setPuntuacionModuloUno(puntuacionModuloUno);
        this.setPuntuacionModuloDos(puntuacionModuloDos);
        this.setPuntuacionModuloTres(puntuacionModuloTres);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacionModuloUno() {
        return puntuacionModuloUno;
    }

    public void setPuntuacionModuloUno(int puntuacionModuloUno) {
        this.puntuacionModuloUno = puntuacionModuloUno;
    }

    public int getPuntuacionModuloDos() {
        return puntuacionModuloDos;
    }

    public void setPuntuacionModuloDos(int puntuacionModuloDos) {
        this.puntuacionModuloDos = puntuacionModuloDos;
    }

    public int getPuntuacionModuloTres() {
        return puntuacionModuloTres;
    }

    public void setPuntuacionModuloTres(int puntuacionModuloTres) {
        this.puntuacionModuloTres = puntuacionModuloTres;
    }
}
