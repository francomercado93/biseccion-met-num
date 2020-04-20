package algoritmo;

public class Funciones {
	/*
	 * ---------------------------------------------------------------- -- ALGORITMO
	 * DE BISECCION -- BY: GRN input = f : R->R continua, a€R, b€R, (a>b), epsilon,
	 * f(a)*f(b)<0 mientras ((b - a) / a >= epsilon){ let c = (a + b) / 2 if(f(c) ==
	 * 0) return c; if(signo(f(a) != signo(f(c))) b = c; else a = c; }
	 * ----------------------------------------------------------------
	 */
	static Float algoritmoBiseccion(Float a, Float b, Float epsilon, Float w) {
		Float c = 0f;
		Integer i = new Integer(0);
		System.out.println("I\t|a\t\t|b\t\t|c\t\t|F(c)\t\t|");
		while ((b - a) >= epsilon) {
			c = (w * a + (1 - w) * b);
			System.out.println(i++ + "\t|" + a + "\t\t|" + b + "\t\t|" + c + "\t|" + Funcion.funcion(c));
			if (Funcion.funcion(c) == 0)
				return c;
			if ((signo(Funcion.funcion(a)) * signo(Funcion.funcion(c))) < 0)
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
}