/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author ADMINMJ
 */
public class Fecha {

    public static int[] getDiasMes() {
        return diasMes;
    }

    private int dia;
    private int mes;
    private int anno;
    private static int[] diasMes;
    static String[] nombreMes;

    public Fecha() {
        nombreMes = new String[]{"Enero", "Febrero", "Marzo",
            "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre",
            "Octubre", "Noviembre", "Diciembre"};

        diasMes = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Calendar c = new GregorianCalendar();
        dia = c.get(Calendar.DAY_OF_MONTH);
        mes = c.get(Calendar.MONTH) + 1;
        anno = c.get(Calendar.YEAR);
    }

    /**
     *
     * @param fechaIntroducida
     * @return
     */
    public boolean comprobarFecha(String fechaIntroducida) {
        boolean correcta = true;
        String[] partida;
        partida = fechaIntroducida.split("/");
        if (partida.length != 3) {
            correcta = false;
        } else {
            try {
                dia = Integer.parseInt(partida[0]);
                mes = Integer.parseInt(partida[1]);
                anno = Integer.parseInt(partida[2]);
                if (anno < 1900 || anno > 3000) {
                    correcta = false;
                } else {
                    if (mes < 1 || mes > 12) {
                        correcta = false;
                    } else {
                        bisiesto();
                        if (dia < 1 || dia > diasMes[mes - 1]) {
                            correcta = false;
                        } else {
                            correcta = true;
                        }
                    }
                }

            } catch (NumberFormatException ex) {
                correcta = false;
            }
        }
        return correcta;

    }

    /**
     *
     * @return
     */
    public int calcularOrden() {
        int orden = 0;
        bisiesto();
        for (int mesx = 1; mesx != mes; mesx++) {
            orden = orden + diasMes[mesx - 1];
        }
        orden = orden + dia;
        return orden;
    }

    public void bisiesto() {
        if (anno % 4 == 0 && anno % 100 != 0 || anno % 400 == 0) {
            diasMes[1] = 29;
        } else {
            diasMes[1] = 28;
        }
    }

    /**
     *
     * @return
     */
    public int finAnno() {
        int orden;
        bisiesto();
        if (diasMes[1] == 29) {
            orden = 366 - calcularOrden();
        } else {
            orden = 365 - calcularOrden();
        }
        return orden;
    }

    public String fechaEnLetra() {
        return dia + " de " + nombreMes[mes - 1] + " de " + anno;
    }

    public int getDia() {
        return dia;
    }

    public int getAnno() {
        return anno;
    }

    public int getMes() {
        return mes;
    }

    /**
     * Método que compara dos fechas.
     *
     * @param fecha1 fecha con la que comparo
     * @return 0 en el caso de que las fechas sean iguales -1 en el caso de que
     * la fecha que llama es menor que la fecha que paso 1 cuando la fecha que
     * llama es mayor que la fecha que paso
     */

    public int compararFechas(Fecha fecha1) {
        int resultado;
        if (anno > fecha1.getAnno()) {
            resultado = 1;
        } else {
            if (anno < fecha1.getAnno()) {
                resultado = -1;
            } else {
                if (mes > fecha1.getMes()) {
                    resultado = 1;
                } else {
                    if (mes < fecha1.getMes()) {
                        resultado = -1;
                    } else {
                        if (dia > fecha1.getDia()) {
                            resultado = 1;
                        } else {
                            if (dia < fecha1.getDia()) {
                                resultado = -1;
                            } else {
                                resultado = 0;
                            }
                        }
                    }
                }
            }
        }
        return resultado;
    }

}
