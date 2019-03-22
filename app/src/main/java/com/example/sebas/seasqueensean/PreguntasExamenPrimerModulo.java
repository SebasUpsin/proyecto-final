package com.example.sebas.seasqueensean;

public class PreguntasExamenPrimerModulo {

    private String mPreguntas [] = {
            "¿A que numero hace referencia la imagen?",
            "¿A que vocal hace referencia la imagen?",
            "¿A que numero hace referencia la imagen?",
            "¿A que vocal hace referencia la imagen?",
            "¿A que numero hace referencia la imagen?"
    };

    private String mOpciones [][] = {
            {"1","0","9"},
            {"E","U","A"},
            {"3","7","6"},
            {"I","Z","U"},
            {"5","9","4"}
    };

    private String mRespuestasCorrectas [] = {
            "0",
            "E",
            "3",
            "U",
            "9"
    };

    public String getPreguntas(int a){
        String pregunta = mPreguntas[a];
        return pregunta;
    }

    public String getOpciones(int a){
        String opcion1 = mOpciones[a][0];
        return opcion1;
    }

    public String getOpciones2(int a){
        String opcion2 = mOpciones[a][1];
        return opcion2;
    }

    public String getOpciones3(int a){
        String opcion3 = mOpciones[a][2];
        return opcion3;
    }

    public String getRespuestaCorrecta(int a){
        String correcto = mRespuestasCorrectas[a];
        return correcto;
    }
}
