package com.example.tnb_20.andrevina;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ModelFame extends Activity{
    private List<Jugador> jugadors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record);
        mostrarDatos();
    }


    private void mostrarDatos(){
       jugadors = new ArrayList<>();
        leerFichero();
        final TextView tablaRecord = findViewById(R.id.record);
        tablaRecord.setText("");
        if(jugadors.size()>0){
            Collections.sort(jugadors);
            for (Jugador jug:
                 jugadors) {
                tablaRecord.setText(tablaRecord.getText() + jug.toString());
            }
        }else{
            
            tablaRecord.setText(tablaRecord.getText() + "No hay datos registrados");
        }
    }

    private void leerFichero(){
        try
        {
            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    openFileInput("jugadors.txt")));

            String texto;
            while((texto = fin.readLine())!=null){
                String[] cadena = texto.split(",");
                jugadors.add(new Jugador(cadena[0],Integer.parseInt(cadena[1])));
            }
            fin.close();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    }

