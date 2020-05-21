package ProyectoFada;

import java.util.Arrays;

/**
 * para la complejidad O(n) se usara el counting sort para hacerlo,
 * modificandolo para que ordene el array de los nombres en funcion de su
 * importancia
 * 
 * @author CamiloRosero
 * @author MariaArroyo
 * @author JoseErazo
 * 
 */
 
class O_n{ 
    
    private int n,m,k;
    private String[] anim;
    private int[] grand,apar,pos;
    private String[][]aper;
    private String[][][]part;    
    
    public O_n(int no,int p,int e, String[] a, int[] g,String[][] apr,String[][][] pa){      
        
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
        sort(grand,anim);
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
            sort(aux,aper[i]);
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
                sort(aux,part[i][j]);
                smgt+=smge;
                smge=0;
                
            }
            sortar(aux2,part[i]);
            
            
        }
        sort(apar,anim);
        
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
                int v = n -1;
                System.out.print( anim[v] +"\n ");
                while(apar[v]==apar[v-1]) {
                	System.out.print( anim[v-1] +"\n ");
                	v--;
                }
                System.out.print("\n el animal que menos aparece es: \n");
                v = 0;
                System.out.print( anim[v] +"\n ");
                while(apar[v]==apar[v+1]) {
                	System.out.print( anim[v+1] +"\n ");
                	v++;
                }
        
                double fin = System.currentTimeMillis();
                
                double tiempo = (double) ((fin - inicio));
                 
                System.out.println("tiempo de ejecucion "+tiempo +"milisegundos\n");
        
    }
    
    public void sort(int im[],String nom[]) 
    { 
    	
    	
        int b = im.length;

  
        // el array salida contiene el arreglo ordenado 
        int salida1[] = new int[b]; 
        String salida2[] = new String[b];
  
        /* 
        crea el array que contiene el contador y lo inicializa en 0
        */
        int cont[] = new int[256]; 
        for (int i = 0; i < 256; ++i){
            cont[i] = 0; 
        }
        /*
        guarda la cuenta de cada caracter
        */
        for (int i = 0; i < b; i++){
            cont[im[i]]++; 
        }
  
        /*
        cambia el contador para que contenga la posicion real de
        la posicion del objeto en el arreglo
        */
        for (int i = 1; i < 256; i++){ 
            cont[i] += cont[i - 1]; 
        }
  
        /*
        construye los array de salida
        */
        for (int i = 0; i < b; i++) { 
            salida1[cont[im[i]] - 1] = im[i];
            salida2[cont[im[i]] - 1] = nom[i];
            cont[im[i]]--; 
        } 
   
        for (int i = 0; i < b; i++){ 
            im[i] = salida1[i];
            nom[i] = salida2[i];
        }
    } 
    
    public void sortar(int im[],String nom[][]) 
    { 
        
        int b = im.length; 
  
        // el array salida contiene el arreglo ordenado 
        int salida1[] = new int[b]; 
        String salida2[][] = new String[b][3];
  
        /* 
        crea el array que contiene el contador y lo inicializa en 0
        */
        int cont[] = new int[256]; 
        for (int i = 0; i < 256; ++i){
            cont[i] = 0; 
        }
  
        /*
        guarda la cuenta de cada caracter
        */
        for (int i = 0; i < b; i++){
            cont[im[i]]++; 
        }
  
        /*
        cambia el contador para que contenga la posicion real de
        la posicion del objeto en el arreglo
        */
        for (int i = 1; i < 256; i++){ 
            cont[i] += cont[i - 1]; 
        }
  
        /*
        construye los array de salida
        */
        for (int i = 0; i < b; i++) { 
            salida1[cont[im[i]] - 1] = im[i];
            for (int j=0;j<3;j++){
                salida2[cont[im[i]] - 1][j] = nom[i][j];
            }
            --cont[im[i]]; 
        } 

        for (int i = 0; i < b; i++){ 
            im[i] = salida1[i];
             for (int j=0;j<3;j++){
                nom[i][j] = salida2[i][j];
            }
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
