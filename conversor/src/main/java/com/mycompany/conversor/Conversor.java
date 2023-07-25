

package com.mycompany.conversor;

import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Conversor {

    public static void main(String[] args) {

        double tipoCambioUSDtoEUR = 0.91;   // 1 USD = 0.91 EUR (EUROS)
        double tipoCambioUSDtoGBP = 0.78;   // 1 USD = 0.78 GBP (LIBRA ESTERLINA)
        double tipoCambioUSDtoJPY = 141.18; // 1 USD = 110.29 JPY (YEN JAPONÈS)
        double tipoCambioUSDtoKRW = 1277.33;// 1 USD = 1167.95 KRW (WON SURCOREANO)
        double tipoCambioUSDtoUSD = 1;  // 1 USD = 1 USD 
        double factorKmToM = 1000.0; // 1 KM = 1000 M

        boolean continuar = true;

        while (continuar) {
            String[] opciones = {
                "USD a EUR",
                "USD a GBP",
                "USD a JPY",
                "USD a KRW",
                "USD a USD",
                "EUR a USD",
                "GBP a USD",
                "JPY a USD",
                "KRW a USD",
                "USD a USD",
                "KM a M",
                "M a KM",
                "Salir"
            };

            int eleccion = JOptionPane.showOptionDialog(
                    null,
                    "Seleccione una conversión: (EUR) = EUROS. "
                            + "(GBP) = LIBRA ESTERLINA. "
                            + "(JPY) = YEN JAPONÈS. "
                            + "(KRW) = WON SURCOREANO. "
                            + "(USD) = Dolar. ",
                    "Conversor de Divisas y Algo mas.. por Guissela Jimenez",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );

            if (eleccion == 12) {
                continuar = false;
                continue;
            }

            double cantidadConvertir;
            try {
                String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad:");
                cantidadConvertir = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Cantidad inválida. Intente nuevamente.");
                continue;
            }

            double resultado = 0.0;
            String monedaOrigen = "";
            String monedaDestino = "";

            switch (eleccion) {
                case 0: // USD to EUR
                    resultado = cantidadConvertir * tipoCambioUSDtoEUR;
                    monedaOrigen = "USD";
                    monedaDestino = "EUR";
                    break;
                case 1: // USD to GBP
                    resultado = cantidadConvertir * tipoCambioUSDtoGBP;
                    monedaOrigen = "USD";
                    monedaDestino = "GBP";
                    break;
                case 2: // USD to JPY
                    resultado = cantidadConvertir * tipoCambioUSDtoJPY;
                    monedaOrigen = "USD";
                    monedaDestino = "JPY";
                    break;
                case 3: // USD to KRW
                    resultado = cantidadConvertir * tipoCambioUSDtoKRW;
                    monedaOrigen = "USD";
                    monedaDestino = "KRW";
                    break;
                case 4: // USD to USD
                    resultado = cantidadConvertir * tipoCambioUSDtoUSD;
                    monedaOrigen = "USD";
                    monedaDestino = "USD";
                    break;
                case 5: // EUR to USD
                    resultado = cantidadConvertir / tipoCambioUSDtoEUR;
                    monedaOrigen = "EUR";
                    monedaDestino = "USD";
                    break;
                case 6: // GBP to USD
                    resultado = cantidadConvertir / tipoCambioUSDtoGBP;
                    monedaOrigen = "GBP";
                    monedaDestino = "USD";
                    break;
                case 7: // JPY to USD
                    resultado = cantidadConvertir / tipoCambioUSDtoJPY;
                    monedaOrigen = "JPY";
                    monedaDestino = "USD";
                    break;
                case 8: // KRW to USD
                    resultado = cantidadConvertir / tipoCambioUSDtoKRW;
                    monedaOrigen = "KRW";
                    monedaDestino = "USD";
                    break;
                case 9: // USD to USD
                    resultado = cantidadConvertir / tipoCambioUSDtoUSD;
                    monedaOrigen = "USD";
                    monedaDestino = "USD";
                    break;
                 case 10: // Convertir a Kilómetros (KM) a Metros (M)
                    resultado = cantidadConvertir * factorKmToM;
                    monedaOrigen = "KM";
                    monedaDestino = "M";
                    break;
                case 11: // Convertir a Metros (M) a Kilómetros (KM)
                    resultado = cantidadConvertir / factorKmToM;
                    monedaOrigen = "M";
                    monedaDestino = "KM";
                    break;
            }

            // Redondeamos el resultado a 2 decimales
            resultado = Math.round(resultado * 100.0) / 100.0;

            String mensaje = String.format("%.2f %s = %.2f %s", cantidadConvertir, monedaOrigen, resultado, monedaDestino);
            int opcion = JOptionPane.showConfirmDialog(null, mensaje + "\n¿Desea hacer otra conversión?", "Resultado", JOptionPane.YES_NO_OPTION);

            if (opcion == JOptionPane.NO_OPTION) {
                continuar = false;
            }
        }
    }
}
