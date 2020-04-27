package algoritmo;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		Float fc = 0f;
		Integer i = new Integer(0);
		while ((b - a) >= epsilon) {
			c = (w * a + (1 - w) * b);
			fc = Funcion.funcion(c);
			String datos[] = { (i++).toString(), a.toString(), b.toString(), c.toString(), fc.toString() };
			modelo.addRow(datos);
			if (fc == 0)
				return c;
			if ((signo(Funcion.funcion(a)) * signo(fc)) < 0)
				b = c;
			else
				a = c;
		}
		return c;
	}

	/* FUNCION SIGNO */
	static int signo(Float x) {
		if (x > 0)
			return 1;
		else
			return -1;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("No hay acciones disponibles");
	}

}
