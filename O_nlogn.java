package ProyectoFada;
import java.util.Arrays;

/**
 * para la complejidad O(nlogn) se usara el merge sort para hacerlo,
 * modificandolo para que ordene el array de los nombres en funcion de su
 * importancia
 * 
 * @author CamiloRosero
 * @author MariaArroyo
 * @author JoseErazo
 * 
 */

public class O_nlogn {
	
	 private int n,m,k;
	    private String[] anim;
	    private int[]grand;
	    private String[][]aper;
	    private String[][][]part;    
	    
	    public O_nlogn(int no,int p,int e, String[] a, int[] g,String[][] apr,String[][][] pa){      

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
	        sort(grand,anim, n);
	        for (int i=0;i<((m-1)*k);i++){
	            for (int j=0;j<3;j++){
	                aper[i][j]=apr[i][j];
	                auxn=indf(aper[i][j]);
	                aux[j]=auxn;
	            }
	            sort(aux,aper[i],((m-1)*k)-1);
	            
	        }
	        for (int i=0;i<(m-1);i++){
	            for (int j=0;j<k;j++){
	                for (int w=0;w<3;w++){
	                part[i][j][w]=pa[i][j][w];
	                auxn=indf(part[i][j][w]);
	                aux[w]=auxn;
	                aux2[j]=aux2[j]+auxn;
	                }
	                sort(aux,part[i][j],3);
	            }
	            sortar(aux2,part[i],k-1);
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
	    
	    public void merge(int[] a, String[] nom, int[] l, String[] ln, int[] r, String[] rn, int left, int right) {
	    		  
	    		    int i = 0, j = 0, k = 0,aux,aux2;
	    		    while (i < left && j < right) {
	    		        if (l[i] <= r[j]) {
	    		        	aux=k++;
	    		        	aux2=i++;
	    		            a[aux] = l[aux2];
	    		            nom[aux]= ln[aux2];
	    		        }
	    		        else {
	    		        	aux=k++;
	    		        	aux2=j++;
	    		            a[aux] = r[aux2];
	    		            nom[aux]= rn[aux2];
	    		        }
	    		    }
	    		    while (i < left) {
	    		    	aux=k++;
    		        	aux2=i++;
	    		        a[aux] = l[aux2];
	    		        nom[aux]= ln[aux2];
	    		    }
	    		    while (j < right) {
	    		    	aux=k++;
    		        	aux2=j++;
	    		        a[aux] = r[aux2];
	    		        nom[aux]= rn[aux2];
	    		    }
	    		}
	    
	    public void sort(int[] a,String[] nom, int n) {
	        if (n < 2) {
	            return;
	        }
	        int mid = n / 2;
	        int[] l = new int[mid];
	        String[] ln = new String[mid];
	        int[] r = new int[n-mid];
	        String[] rn = new String[n-mid];
	     
	        for (int i = 0; i < mid; i++) {
	            l[i] = a[i];
	            ln[i] = nom[i];
	        }
	        for (int i = mid; i < n; i++) {
	            r[i - mid] = a[i];
	            rn[i - mid] = nom[i];
	        }
	        sort(l,ln, mid);
	        sort(r,rn, n - mid);
	     
	        merge(a, nom, l, ln, r, rn, mid, n - mid);
	    }
	    
	    
	    public void mergear(int[] a, String[][] nom, int[] l, String[][] ln, int[] r, String[][] rn, int left, int right) {
  		  
		    int i = 0, j = 0, k = 0,aux,aux2;
		    while (i < left && j < right) {
		        if (l[i] <= r[j]) {
		        	aux=k++;
		        	aux2=i++;
		            a[aux] = l[aux2];
		            for (int f=0;f<3;f++)
		            	nom[aux][f]= ln[aux2][f];
		        }
		        else {
		        	aux=k++;
		        	aux2=j++;
		            a[aux] = r[aux2];
		            for (int f=0;f<3;f++)
		            	nom[aux][f]= rn[aux2][f];
		        }
		    }
		    while (i < left) {
		    	aux=k++;
	        	aux2=i++;
		        a[aux] = l[aux2];
		        for (int f=0;f<3;f++)
		        	nom[aux][f]= ln[aux2][f];
		    }
		    while (j < right) {
		    	aux=k++;
	        	aux2=j++;
		        a[aux] = r[aux2];
		        for (int f=0;f<3;f++)
		        	nom[aux][f]= rn[aux2][f];
		    }
		}

	    public void sortar(int[] a,String[][] nom, int n) {
	    	if (n < 2) {
	    		return;
	    	}
	    	int mid = n / 2;
	    	int[] l = new int[mid];
	    	String[][] ln = new String[mid][3];
	    	int[] r = new int[n-mid];
	    	String[][] rn = new String[n-mid][3];
 
	    	for (int i = 0; i < mid; i++) {
	    		l[i] = a[i];
	    		for (int f=0;f<3;f++)
	    			ln[i][f] = nom[i][f];
	    	}
	    	for (int i = mid; i < n; i++) {
	    		r[i - mid] = a[i];
	    		for (int f=0;f<3;f++)
	    			rn[i - mid][f] = nom[i][f];
	    	}
	    	sortar(l,ln, mid);
	    	sortar(r,rn, n - mid);
 
	    	mergear(a, nom, l, ln, r, rn, mid, n - mid);
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
