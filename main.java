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
		
		System.out.print("prueba con complejidad n \n");
		
		O_n p1= new O_n(n,m,k,animales,grandezas,apertura,partes);
		
		System.out.print("\n \n");
		
		System.out.print("prueba con complejidad n2 \n");
		
		O_n2 p2= new O_n2(n,m,k,animales,grandezas,apertura,partes);
		
		System.out.print("\n \n");
		
		System.out.print("prueba con complejidad nlogn \n");
		
		O_nlogn p3= new O_nlogn(n,m,k,animales,grandezas,apertura,partes);
		
		System.out.print("\n \n");
		   
		int n2 = 9;
		int m2 = 4;
		int k2 = 3;
		String[] animales2 = {"leon", "panteranegra", "cebra", "cocodrilo", "boa", "loro", "caiman", "tigre", "capibara"};
		int[] grandezas2 = {9, 7, 6, 5, 4, 2, 3, 8, 1};
		String[][] apertura2 = {{"caiman", "capibara", "loro"}, {"boa", "caiman", "capibara"}, {"cocodrilo", "capibara", "loro"},
								{"panteranegra", "cocodrilo", "loro"}, {"tigre", "loro", "capibara"}, {"leon", "caiman", "loro"},
								{"leon", "cocodrilo", "boa"}, {"leon", "panteranegra", "cebra"}, {"tigre", "cebra", "panteranegra"}};
		String[][][] partes2 = {{{"caiman", "capibara", "loro"}, {"tigre", "loro", "capibara"}, {"tigre", "cebra", "panteranegra"}},
								{{"panteranegra", "cocodrilo", "loro"}, {"leon", "panteranegra", "cebra"}, {"cocodrilo", "capibara", "loro"}},
								{{"boa", "caiman", "capibara"}, {"leon", "caiman", "loro"}, {"leon", "cocodrilo", "boa"}}};
		
		System.out.print("prueba con complejidad n \n");
		
		O_n p4= new O_n(n2,m2,k2,animales2,grandezas2,apertura2,partes2);
		
		System.out.print("\n \n");
		
		System.out.print("prueba con complejidad n2 \n");
		
		O_n2 p5= new O_n2(n2,m2,k2,animales2,grandezas2,apertura2,partes2);
		
		System.out.print("\n \n");
		
		System.out.print("prueba con complejidad nlogn \n");
		
		O_nlogn p6 = new O_nlogn(n2,m2,k2,animales2,grandezas2,apertura2,partes2);
		
		System.out.print("\n \n");


	}

}

