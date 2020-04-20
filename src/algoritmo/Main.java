package algoritmo;

import javax.swing.JOptionPane;

;

//public class Main {
//
//	public static void main(String[] args) {
//
//		// PRUEBO ALGORITMO BISECCION
//		Float a = -0.6f;
//		Float b = -0.35f;
//		Float w = 0.5f;
//		Float epsilon = 0.003f;
////		JOptionPane.showInputDialog("Ingresa un valor de w", w);
////		JOptionPane.showInputDialog("Ingresa un valor de a", a);
////		JOptionPane.showInputDialog("Ingresa un valor de b", b);
////		JOptionPane.showInputDialog("Ingresa un valor de epsilon", epsilon);
//		JTable tabla = Funciones.algoritmoBiseccion(a, b, epsilon, w);
//		tabla.setVisible(true);		
////		JOptionPane.showMessageDialog(null, "El resultado es: " + resultado);
//
//	}
//
//}
//

public class Main {
	public static void main(String[] args) {
		Float a = -0.6f;
		Float b = -0.35f;
		Float w = 0.5f;
		Float epsilon = 0.003f;
		JOptionPane.showInputDialog("Ingresa un valor de w", w);
		JOptionPane.showInputDialog("Ingresa un valor de a", a);
		JOptionPane.showInputDialog("Ingresa un valor de b", b);
		JOptionPane.showInputDialog("Ingresa un valor de epsilon", epsilon);
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
