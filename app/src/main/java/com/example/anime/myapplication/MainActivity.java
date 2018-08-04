package com.example.anime.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String dDia;
        String dMes;
        String dAno;

        int a = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView resultado = findViewById(R.id.resultado);
        final EditText editDia= findViewById(R.id.edit1);
        final EditText editMes = findViewById(R.id.edit2);
        final EditText editAno = findViewById(R.id.edit3);
        Button convertirEdad = findViewById(R.id.button1);
        Button diferenciaEdad = findViewById(R.id.button2);
        final int dia = Calendar.getInstance().getTime().getDay()-2;
        final int mes = Calendar.getInstance().getTime().getMonth()+1;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy");
        String newdate=dateFormat.format(new Date());
        final int ano = Integer.valueOf(newdate);
        final int[] edadanterior = {0};
        convertirEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dDia = editDia.getText().toString();
                String dMes = editMes.getText().toString();
                String dAno = editAno.getText().toString();
                int intdia = Integer.valueOf(dDia);
                int intano = Integer.valueOf(dAno);
                int intmes = Integer.valueOf(dMes);
                int resta = ano - intano;
                String r = String.valueOf(resta);


                int anoatl = resta - 1;
                String altano = String.valueOf(anoatl);
                resultado.setText(altano);
                if (intmes > mes) {

                    resultado.setText("Tu edad es:"+altano);
                    edadanterior[0] =anoatl;
                } else if(intmes==mes) {
                    if (intdia > dia) {

                        resultado.setText("Tu edad es:"+altano);
                        edadanterior[0] =anoatl;

                    } else {

                        resultado.setText("Tu edad es:"+r);
                        edadanterior[0] =resta;
                    }
                }
                editMes.setText("");
                editDia.setText("");
                editAno.setText("");
            }



        });

        diferenciaEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dDia = editDia.getText().toString();
                String dMes = editMes.getText().toString();
                String dAno = editAno.getText().toString();
                int intdia = Integer.valueOf(dDia);
                int intano = Integer.valueOf(dAno);
                int intmes = Integer.valueOf(dMes);
                int resta = ano - intano;
                int dif;
                String r = String.valueOf(resta);


                int anoatl = resta - 1;


                if (intmes > mes) {

                  dif=anoatl- edadanterior[0];
                if(dif<0){
                      dif=dif*(-1);
                        }
                    String diferencia=String.valueOf(dif);
                    resultado.setText("La diferencia es:"+diferencia);

                } else if(intmes==mes) {
                    if (intdia > dia) {

                        dif=anoatl- edadanterior[0];
                        if(dif<0){
                            dif=dif*(-1);
                        }
                        String diferencia=String.valueOf(dif);
                        resultado.setText("La diferencia es:"+diferencia);


                    } else {

                       dif=resta- edadanterior[0];

                        String diferencia=String.valueOf(dif);
                        resultado.setText("La diferencia es:"+diferencia);

                    }
                }
                editMes.setText("");
                editDia.setText("");
                editAno.setText("");

            }



        });



    }
}
