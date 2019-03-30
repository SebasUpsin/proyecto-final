package DB;

import java.io.Serializable;

public class Usuario implements Serializable {

    private int ID;
    private String nombre;
    private String genero;
    private int edad;
    private int progreso;
    private int puntuacionActividadUno;
    private int puntuacionActividadDos;
    private int puntuacionActividadTres;
    private int puntuacionModuloUno;
    private int puntuacionModuloDos;
    private int puntuacionModuloTres;

    public Usuario(){
        this.setID(0);
        this.setNombre("");
        this.setGenero("");
        this.setEdad(0);
        this.setProgreso(0);
        this.setPuntuacionActividadUno(0);
        this.setPuntuacionActividadDos(0);
        this.setPuntuacionActividadTres(0);
        this.setPuntuacionModuloUno(0);
        this.setPuntuacionModuloDos(0);
        this.setPuntuacionModuloTres(0);
    }

    public Usuario(int ID, String nombre, String genero, int edad, int progreso,
                   int puntuacionActividadUno, int puntuacionActividadDos, int puntuacionActividadTres,
                   int puntuacionModuloUno, int puntuacionModuloDos, int puntuacionModuloTres){
        this.setID(ID);
        this.setNombre(nombre);
        this.setGenero(genero);
        this.setEdad(edad);
        this.setProgreso(progreso);
        this.setPuntuacionActividadUno(puntuacionActividadUno);
        this.setPuntuacionActividadDos(puntuacionActividadDos);
        this.setPuntuacionActividadTres(puntuacionActividadTres);
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

    public int getPuntuacionActividadUno() {
        return puntuacionActividadUno;
    }

    public void setPuntuacionActividadUno(int puntuacionActividadUno) {
        this.puntuacionActividadUno = puntuacionActividadUno;
    }

    public int getPuntuacionActividadDos() {
        return puntuacionActividadDos;
    }

    public void setPuntuacionActividadDos(int puntuacionActividadDos) {
        this.puntuacionActividadDos = puntuacionActividadDos;
    }

    public int getPuntuacionActividadTres() {
        return puntuacionActividadTres;
    }

    public void setPuntuacionActividadTres(int puntuacionActividadTres) {
        this.puntuacionActividadTres = puntuacionActividadTres;
    }
}
