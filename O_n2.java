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
    private int[] grand,apar,pos;
    private String[][]aper;
    private String[][][]part;    
    
    public O_n2(int no,int p,int e, String[] a, int[] g,String[][] apr,String[][][] pa){      
        
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
        sort(grand,anim,0,n);
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
            sort(aux,aper[i],0,((m-1)*k)-1);
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
                sort(aux,part[i][j],0,3);
                smgt+=smge;
                smge=0;
                
            }
            sortar(aux2,part[i],0,k-1);
            
            
        }
        sort(apar,anim,0,n);
        
        System.out.print(smgt+"\n");
        smgt=(smgt/(2*(k*(m-1))));
        
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
                int v = 0;
                System.out.print( anim[v] +"\n ");
                while(apar[v]==apar[v+1]) {
                	System.out.print( anim[v+1] +"\n ");
                	v++;
                }
                System.out.print("\n el animal que menos aparece es: \n");
                v = n -1;
                System.out.print( anim[v] +"\n ");
                while(apar[v]==apar[v-1]) {
                	System.out.print( anim[v-1] +"\n ");
                	v--;
                }
                
                double fin = System.currentTimeMillis();
                
                double tiempo = (double) ((fin - inicio));
                 
                System.out.println("tiempo de ejecucion "+tiempo +"milisegundos\n");
        
	        
	    }
	    
	    
    	int par(int a[], String[] b, int l, int h) 
        { 
            int temp;
            String tmp;
            int aux;
            int pi = a[h-1];  
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
