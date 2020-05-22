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
    private int[] grand,apar,pos;
    private String[][]aper;
    private String[][][]part;      
	    
	    public O_nlogn(int no,int p,int e, String[] a, int[] g,String[][] apr,String[][][] pa){      

	    	double inicio = System.currentTimeMillis();
	    	n=no;
	        m=p;
	        k=e;
	        int auxn,smge=0,smgt=0,mygr=0,mngr=1000000000;
	        String[] myes = new String[3];
	        String[] mnes = new String[3];
	        apar= new int[n];
	        pos= new int[n];
	        anim= new String[n];
	        grand=new int[n];
	        aper=new String[(m-1)*k][3];
	        part=new String[m-1][k][3];
	        int[] aux = new int[3];
	        int[] aux2 = new int[k];
	        for (int i=0;i<n;i++){
	        	anim[i]=a[i];
	            grand[i]=g[i];
	            apar[i]=0;
	            pos[i]=i;
	        }
	        sort(grand,anim, n);
	        for (int i=0;i<((m-1)*k);i++){
	            for (int j=0;j<3;j++){
	            	aper[i][j]=apr[i][j];
	                auxn=indf(aper[i][j]);
	                apar[auxn]+=1;
	                aux[j]=auxn;
	                smge+=grand[auxn];
	            }
	            
	            if(smge<mngr) {
	            	mngr=smge;
	            	for (int f=0;f<3;f++) {
	            		mnes[f]=a[aux[f]];
	            	}
	            }
	            if(smge>mygr) {
	            	mygr=smge;
	            	for (int f=0;f<3;f++) {
	            		myes[f]=a[aux[f]];
	            	}
	            }
	            sort(aux,aper[i],((m-1)*k)-1);
	            smgt+=smge;
	            smge=0;
	            
	        }
	        for (int i=0;i<(m-1);i++){
	            for (int j=0;j<k;j++){
	                for (int w=0;w<3;w++){
	                	part[i][j][w]=pa[i][j][w];
	                    auxn=indf(part[i][j][w]);
	                    apar[auxn]+=1;
	                    aux[w]=auxn;
	                    aux2[j]=aux2[j]+auxn;
	                    smge+=grand[auxn];
	                }
	                if(smge<mngr) {
	                	mngr=smge;
	                	for (int f=0;f<3;f++) {
	                		mnes[f]=a[aux[f]];
	                	}
	                }
	                if(smge>mygr) {
	                	mygr=smge;
	                	for (int f=0;f<3;f++) {
	                		myes[f]=a[aux[f]];
	                	}
	                }
	                sort(aux,part[i][j],3);
	                smgt+=smge;
	                smge=0;
	            }
	            sortar(aux2,part[i],k-1);
	        }
	        
	        System.out.print("la presentacion tiene "+n+" animales, asi:");
	        
	        for (int t=0;t<anim.length;t++) {
	        	System.out.print(anim[t]+", ");
	        }
	        
	        sort(apar,anim,n);
	        smgt=(smgt/(2*(k*(m-1))));
	        
	        System.out.print("\n consta de " + m + " partes de " + k + " escenas \n");
            
            System.out.print("el orden en el que hace la presentacion es: \n");
            
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
	                
	                System.out.print("El Promedio de las escenas es: "+smgt+"\n");
	                
	                System.out.print("La escena de mayor grandeza es: \n");
	                
	                for(int f=0;f<3;f++) {
	        			System.out.print( myes[f] +", ");
	                }
	                
	                System.out.print("\n La escena de menor grandeza es: \n");
	                
	                for(int f=0;f<3;f++) {
	        			System.out.print( mnes[f] +", ");
	                }
	                
	                
	               
	                System.out.print("\n el animal que mas aparece es: \n");
	                int v = n - 1;
	                System.out.print( anim[v] +", ");
	                while(apar[v]==apar[v-1]) {
	                	System.out.print( anim[v-1] +", ");
	                	v--;
	                }
	                System.out.print("\n el animal que menos aparece es: \n");
	                v = 0;
	                System.out.print( anim[v] +", ");
	                while(apar[v]==apar[v+1]) {
	                	System.out.print( anim[v+1] +", ");
	                	v++;
	                }
	                
	                double fin = System.currentTimeMillis();
	                
	                
	                double tiempo = (double) ((fin - inicio));
	                 
	                System.out.println("\n tiempo de ejecucion "+tiempo +"milisegundos\n");
	                
	        
	        
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
	        int mid = (n / 2);
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

