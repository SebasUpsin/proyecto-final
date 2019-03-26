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







    ///// METODOS PARA TOMAR LOS DATOS DEL SEGUNDO MODULO DE EXAMEN /////



    private String mPreguntas2 [] = {
            "¿A que letra del abecedario hace referencia la imagen?",
            "¿A que letra del abecedario hace referencia la imagen?",
            "¿A que letra del abecedario hace referencia la imagen?",
            "¿A que letra del abecedario hace referencia la imagen?",
            "¿A que letra del abecedario hace referencia la imagen?"
    };



    private String mOpciones2 [][] = {
            {"J","I","L"},
            {"M","D","H"},
            {"Q","T","O"},
            {"R","I","K"},
            {"C","X","F"}
    };



    private String mRespuestasCorrectas2 [] = {
            "J",
            "H",
            "T",
            "R",
            "X"
    };

    public String getPreguntas2(int a){
        String pregunta = mPreguntas2[a];
        return pregunta;
    }

    public String getOpcionesModuloDos(int a){
        String opcion1 = mOpciones2[a][0];
        return opcion1;
    }

    public String getOpcionesModuloDos2(int a){
        String opcion2 = mOpciones2[a][1];
        return opcion2;
    }

    public String getOpcionesModuloDos3(int a){
        String opcion3 = mOpciones2[a][2];
        return opcion3;
    }

    public String getRespuestaCorrecta2(int a){
        String correcto = mRespuestasCorrectas2[a];
        return correcto;
    }



    ///// METODOS PARA TOMAR LOS DATOS DEL TERCER MODULO DE EXAMEN /////



    private String mPreguntas3 [] = {
            "¿Que quiere decir la imagen?",
            "¿Que quiere decir la imagen?",
            "¿Que quiere decir la imagen?",
            "¿Que quiere decir la imagen?",
            "¿Que quiere decir la imagen?"
    };



    private String mOpciones3 [][] = {
            {"Hola","¿Como estas?","Si, señor"},
            {"A la vuelta","Aqui","Por favor"},
            {"Cuatro por favor","Ven aqui","Adios"},
            {"Pena","Gracias","Hambre"},
            {"Encantado de conocerte","Vamos tu  y yo","Estaba asi de cerca"}
    };



    private String mRespuestasCorrectas3 [] = {
            "Hola",
            "Por favor",
            "Adios",
            "Gracias",
            "Encantado de conocerte"
    };

    public String getPreguntas3(int a){
        String pregunta = mPreguntas3[a];
        return pregunta;
    }

    public String getOpcionesModuloTres(int a){
        String opcion1 = mOpciones3[a][0];
        return opcion1;
    }

    public String getOpcionesModuloTres2(int a){
        String opcion2 = mOpciones3[a][1];
        return opcion2;
    }

    public String getOpcionesModuloTres3(int a){
        String opcion3 = mOpciones3[a][2];
        return opcion3;
    }

    public String getRespuestaCorrecta3(int a){
        String correcto = mRespuestasCorrectas3[a];
        return correcto;
    }


}
