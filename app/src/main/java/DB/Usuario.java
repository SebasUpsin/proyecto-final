package DB;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int ID;
    private String nombre;
    private String genero;
    private int edad;
    private int progreso;
    private int puntuacionModuloUno;
    private int puntuacionModuloDos;
    private int puntuacionModuloTres;

    public Usuario(){
        this.setID(0);
        this.setNombre("");
        this.setGenero("");
        this.setEdad(0);
        this.setProgreso(0);
        this.setPuntuacionModuloUno(0);
        this.setPuntuacionModuloDos(0);
        this.setPuntuacionModuloTres(0);
    }

    public Usuario(int ID, String nombre, String genero, int edad, int progreso, int puntuacionModuloUno, int puntuacionModuloDos, int puntuacionModuloTres){
        this.setID(ID);
        this.setNombre(nombre);
        this.setGenero(genero);
        this.setEdad(edad);
        this.setProgreso(progreso);
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getProgreso() {
        return progreso;
    }

    public void setProgreso(int progreso) {
        this.progreso = progreso;
    }
}
