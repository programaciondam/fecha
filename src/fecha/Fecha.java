/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha;

/**
 *
 * @author ADMINMJ
 */
public class Fecha {

    int dia;
    int mes;
    int anno;
    static int[] diasMes;

    public Fecha() {
        diasMes = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
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
    public int finAnno(){
        int orden;
        bisiesto();
        if (diasMes[1]==29)
            orden =366-calcularOrden();
        else
            orden=365-calcularOrden();
        return orden;
    }

}
