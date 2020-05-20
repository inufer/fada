package ProyectoFada;

public class main {

	public static void main(String[] args) {
	    
		int n = 6;
		int m = 3;
		int k = 2;

		String[] animales = {"gato", "libelula", "ciempies", "nutria", "perro", "tapir"};
		int[] grandezas = {3, 2, 1, 6, 4, 5};

		String[][] apertura = {{"tapir", "nutria", "perro"}, {"tapir", "perro", "gato"},
		                {"ciempies", "tapir", "gato"}, {"gato", "ciempies", "libelula"}};

		String[][][] partes = {{{"tapir", "nutria", "perro"}, {"ciempies", "tapir", "gato"}},
		                        {{"gato", "ciempies", "libelula"}, {"tapir", "perr", "gato"}}};
		O_n2 p1= new O_n2(n,m,k,animales,grandezas,apertura,partes);
		   

	}

}

