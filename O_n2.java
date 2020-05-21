package ProyectoFada;
import java.util.Arrays;

/**
 * para la complejidad O(n2) se usara el quick sort para hacerlo,
 * modificandolo para que ordene el array de los nombres en funcion de su
 * importancia
 * 
 * @author CamiloRosero
 * @author MariaArroyo
 * @author JoseErazo
 * 
 */

public class O_n2 {
        
		private int n,m,k;
	    private String[] anim;
	    private int[]grand;
	    private String[][]aper;
	    private String[][][]part;    
	    
	    public O_n2(int no,int p,int e, String[] a, int[] g,String[][] apr,String[][][] pa){      
	        n=no; //6
	        m=p;  //3
	        k=e;  //2
	        int auxn;
	        anim= new String[n];
	        grand=new int[n];
	        aper=new String[(m-1)*k][3];
	        part=new String[m-1][k][3];
	        int[] aux = new int[3];
	        int[] aux2 = new int[k];
	        for (int i=0;i<n;i++){
	            anim[i]=a[i];
	            grand[i]=g[i];
	        }
	        sort(grand,anim,0,n);
	        for (int i=0;i<((m-1)*k);i++){
	            for (int j=0;j<3;j++){
	                aper[i][j]=apr[i][j];
	                auxn=indf(aper[i][j]);
	                aux[j]=auxn;
	            }
	            sort(aux,aper[i],0,((m-1)*k)-1);
	            
	        }
	        for (int i=0;i<(m-1);i++){
	            for (int j=0;j<k;j++){
	                for (int w=0;w<3;w++){
	                part[i][j][w]=pa[i][j][w];
	                auxn=indf(part[i][j][w]);
	                aux[w]=auxn;
	                aux2[j]=aux2[j]+auxn;
	                }
	                sort(aux,part[i][j],0,3);
	            }
	            sortar(aux2,part[i],0,k-1);
	        }
	        
	        System.out.print("la presentacion tiene "+n+" animales en total,y consta de "+m+" partes de "
	                +k+" escenas \n");
	                
	                System.out.print("el orden en el que hace la prsentacion es: \n");
	                
	                System.out.print("apertura :");
	                
	                for(int w=((m-1)*k)-1;w>=0;w--) {
	                	System.out.print("[ ");
	                	for(int t=0;t<3;t++) {
	                		System.out.print(aper[w][t]+ ", ");
	                	}
	                	System.out.print("] ");
	                }
                        
                        System.out.print("\n");
                        
	                for(int w=(m-2);w>=0;w--) {
                            int d = m-w-1;
	                	System.out.print("parte"+d+": ");
	                	for(int t=0;t<k;t++) {
	                		System.out.print("escena"+k+": [ ");
	                		for(int f=0;f<3;f++) {
	                			System.out.print( part[w][t][f] +", ");
	                		}
                                 System.out.print("] ");     
	                	}
	                	System.out.print("\n");
	                }
	                
	        
	        
	        
	    }
	    
	    
    	int par(int a[], String[] b, int l, int h) 
        { 
            int temp;
            String tmp;
            int aux;
            int pi = a[h];  
            int i = (l-1); 
            for (int j=l; j<h; j++) 
            { 

                if (a[j] < pi) 
                { 
                    i++; 
      
                    temp = a[i];
                    tmp = b[i];
                    a[i] = a[j]; 
                    b[i] = b[j];
                    a[j] = temp;
                    b[j] = tmp;
                    
                } 
            } 
       
            aux= i+1;
            temp = a[aux];
            tmp = b[aux];
            a[aux] = a[h]; 
            b[aux] = b[h];
            a[h] = temp; 
            b[h] = tmp;
      
            return i+1; 
        }  
	      
	      void sort(int[] a,String[] b, int l, int h) { 
	            if (l < h){ 
	              
	                int pi = par(a, b, l, (h-1)); 
	       
	                sort(a, b, l, pi-1); 
	                sort(a, b, pi+1, h); 
	            } 
	      }
	    
	      int parar(int a[], String[][] b, int l, int h) 
	        { 
	    		int temp;
	            String[] tmp= new String[3];
	            int aux;
	            int pi = a[h-1];  
	            int i = (l-1); 
	            for (int j=l; j<h; j++) 
	            { 
	    
	                if (a[j] < pi) 
	                { 
	                    i++; 

	                    temp = a[i];
	                    for (int w=0;w<3;w++) {
	                    	tmp[w]=b[i][w];
	                    }
	                    a[i] = a[j];
	                    for (int w=0;w<3;w++) {
	                    	b[i][w]=b[j][w];
	                    }
	                    a[j] = temp;
	                    for (int w=0;w<3;w++) {
	                    	b[j][w]=tmp[w];
	                    }
	                    b[j] = tmp;
	                    
	                } 
	            } 

	            aux= i+1;
	            temp = a[aux];
	            for (int w=0;w<3;w++) {
                	tmp[w]=b[aux][w];
                }
	            a[aux] = a[h];
	            for (int w=0;w<3;w++) {
                	b[aux][w]=b[h][w];
                }
	            a[h] = temp; 
	            for (int w=0;w<3;w++) {
                	b[h][w]=tmp[w];
                }
	      
	            return i+1; 
	        }  
		 
		      void sortar(int[] a,String[][] b, int l, int h) { 
		            if (l < h){ 
		   
		                int pi = parar(a, b, l, h); 
		      
		                sortar(a, b, l, pi-1); 
		                sortar(a, b, pi+1, h); 
		            } 
		      }
	    
	    public int indf(String tar) {
	    	int index=-1;
	    	for (int i=0;i<anim.length;i++) {
	    	    if (anim[i].equals(tar)) {
	    	        index = i;
	    	        break;
	    	    }
	    	}
	    	return index;
	    }
	    
	    
	    
}
