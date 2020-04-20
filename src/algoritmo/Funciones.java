package algoritmo;
//

//import java.awt.BorderLayout;
//
//import javax.swing.JFrame;
//import javax.swing.JTable;
//import javax.swing.table.DefaultTableModel;
//
//public class Funciones {
//	/*
//	 * ---------------------------------------------------------------- -- 
//	 * ALGORITMO DE BISECCION -- input = f : R -> R con f continua, a € R, b € R, (a > b), epsilon o valor de aprox,
//	 * f(a) * f(b) < 0 mientras que ((b - a) / a >= epsilon) { let c = (a + b) / 2 if(f(c) ==
//	 * 0) return c; if(signo(f(a) != signo(f(c))) b = c; else a = c; }
//	 * ----------------------------------------------------------------
//	 */
//	static JTable tabla = new JTable();
//	static DefaultTableModel modelo = new DefaultTableModel();
//	static String[] columnas = { "i", "a", "b", "c", "f(c)" };
//
//	static JTable algoritmoBiseccion(Float a, Float b, Float epsilon, Float w) {
//		Float c = 0f;
//		Integer i = new Integer(0);
//		modelo.setColumnIdentifiers(columnas);
//		while ((b - a) >= epsilon) {
//			c = (w * a + (1 - w) * b);
////			System.out.println(i++ + "\t|" + a + "\t\t|" + b + "\t\t|" + c + "\t|" + Funcion.funcion(c));
//			if (Funcion.funcion(c) == 0)
//				return tabla;
//			if ((signo(Funcion.funcion(a)) * signo(Funcion.funcion(c))) < 0)
//				b = c;
//			else
//				a = c;
//			String datos[] = { (i++).toString(), a.toString(), b.toString(), c.toString(),
//					Funcion.funcion(c).toString() };
//			modelo.addRow(datos);
//			System.out.println(datos[1]);
//		}
//		return tabla;
//	}
//
//	/* FUNCION SIGNO */
//	static int signo(Float x) {
//		if (x > 0)
//			return 1;
//		else
//			return -1;
//	}
//	
//
//}

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Funciones extends JFrame implements ActionListener {

	private static final long serialVersionUID = 7675022490591504183L;

	private final JTable tabla;
	private final JScrollPane barras;
	private final DefaultTableModel modelo;
	private final String[] columnas = { "i", "a", "b", "c", "f(c)" };

	public Funciones(Float a, Float b, Float w, Float epsilon) {
		// Inicializamos los elementos de la interfaz
		tabla = new JTable();
		barras = new JScrollPane(tabla);
		modelo = new DefaultTableModel();

		// Ponemos el nombre de las columnas en el modelo
		modelo.setColumnIdentifiers(columnas);

		// Establecemos el modelo de la tabla
		tabla.setModel(modelo);

		// Agregamos datos a la tabla
		this.algoritmoBiseccion(a, b, w, epsilon);

		// Configuramos la ventana principal
		this.prepararVentana();

		// Agregamos elementos a la interfaz
		this.agregarElementos();

	}

	/**
	 * Agregamos los elementos a la interfaz grafica
	 */
	private void agregarElementos() {
		this.getContentPane().add(barras, BorderLayout.CENTER);
	}

	/**
	 * Configuramos la ventana
	 */
	private void prepararVentana() {
		this.setTitle("Datos de tabla");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
	}

	/**
	 * Agregamos datos a la tabla
	 */
	private Float algoritmoBiseccion(Float a, Float b, Float w, Float epsilon) {
		Float c = 0f;
		Integer i = new Integer(0);
		while ((b - a) >= epsilon) {
			c = (w * a + (1 - w) * b);
			if (Funcion.funcion(c) == 0)
				return c;
			if ((signo(Funcion.funcion(a)) * signo(Funcion.funcion(c))) < 0)
				b = c;
			else
				a = c;
			String datos[] = { (i++).toString(), a.toString(), b.toString(), c.toString(),
					Funcion.funcion(c).toString() };
			modelo.addRow(datos);
		}
		return c;
//		for (Integer i = 0; i < 100; i++) {
//			String mensaje = i + " UNIDADES";
//
//			// Creamos un nuevo renglon para la tabla
//			String[] datos = { i.toString(), mensaje };
//			// Agregamos los datos a la tabla
//			modelo.addRow(datos);
//		}
	}

	/**
	 * Manejador del evento del boton, al activarse obtiene un dato de la tabla y lo
	 * imprime en la consola
	 *
	 * @param e
	 */
	public void actionPerformed(ActionEvent e) {
		// Obtenemos el primer dato del renglon seleccionado
		if (tabla.getSelectedRow() != -1) {
			String codigo = (String) modelo.getValueAt(tabla.getSelectedRow(), 0);

			// Lo imprimimos en pantalla
			System.out.println(codigo);
		} else {
			System.out.println("Seleccione un renglon primero");
		}
	}

	/* FUNCION SIGNO */
	static int signo(Float x) {
		if (x > 0)
			return 1;
		else
			return -1;
	}

}
