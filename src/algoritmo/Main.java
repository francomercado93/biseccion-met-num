package algoritmo;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		Float a = 0f;
		Float b = 0f;
		Float w = 0f;
		Float epsilon = 0.003f;
		while (Funciones.signo(Funcion.funcion(a)) == Funciones.signo(Funcion.funcion(b))) {
			a = Float.parseFloat(JOptionPane.showInputDialog("Ingresa un valor de a", a));
			b = Float.parseFloat(JOptionPane.showInputDialog("Ingresa un valor de b", b));
			if (Funciones.signo(Funcion.funcion(a)) == Funciones.signo(Funcion.funcion(b))) {
				JOptionPane.showMessageDialog(null,
						"No se cumple el teorema de Bolzano por lo que no existen raices en el intervalo" + "[" + a
								+ ", " + b + "]");
			}
		}
		while (w >= 1 || w <= 0) {
			w = Float.parseFloat(JOptionPane.showInputDialog("Ingresa un valor de w", w));
			if (w >= 1 || w <= 0) {
				JOptionPane.showMessageDialog(null, "El valor de w tiene que cumplir 0 < w < 1");
			}
		}
		epsilon = Float.parseFloat(JOptionPane.showInputDialog("Ingresa un valor de epsilon", epsilon));
		Funciones tabla = new Funciones(a, b, w, epsilon);
		tabla.pack();
		tabla.setVisible(true);
	}
}

final class Funcion {

	// esta es la función que se va a evaluar
	static Float funcion(Float x) {
		return 2 * x * x + x;
	}
}
