package algoritmo;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {

		// PRUEBO ALGORITMO BISECCION
		Float x = -0.6f;
		Float y = -0.35f;
		Float w = 0.5f;
		Float epsilon = 0.003f;
		JOptionPane.showInputDialog("Ingresa un valor de w", w);
		JOptionPane.showInputDialog("Ingresa un valor de x", x);
		JOptionPane.showInputDialog("Ingresa un valor de y", y);
		Float resultado = Funciones.algoritmoBiseccion(x, y, epsilon, w);
		JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);

	}

}

final class Funcion {

	// esta es la función que se va a evaluar
	static Float funcion(Float x) {
		return 2 * x * x + x;
	}
}