package ud3.reto;


import java.util.Scanner;


//Excepción propia 
class GordoException extends Exception {
	//COMPLETAR DFR
	public GordoException (String mensaje) {
		super(mensaje);
	}
	
}

public class LoteriaFinal {	
	
	//devuelve un array de tamaño numBolas con todos los números del sorteo 
	public static int[] creaBomboNumeros(int numBolas) {
		//COMPLETAR JSC
		int[] bomboNumeros = new int[numBolas];
		
		for(int i=0;i<numBolas;i++){
			bomboNumeros[i] = i;
		}
		
		System.out.println("Bombo de números creado...");
		return bomboNumeros;
	}
	
	//devuelve un array de tamaño numPremios con todos los premios del sorteo
	public static String[] creaBomboPremios(int numPremios) {
		String[] bomboPremios = new String[numPremios];
		
		bomboPremios[0]="PRIMER PREMIO";  // gordo de navidad
		bomboPremios[1]="SEGUNDO PREMIO";	// un segundo premio
		
		//COMPLETAR DFR 
		
		// un tercer premio
		bomboPremios[2]="TERCER PREMIO";
		// dos cuartos premios
		bomboPremios[3]="CUARTO PREMIO";
		bomboPremios[4]="CUARTO PREMIO";
		// 8 quintos premios
		for(int i=5;i<13;i++){
			bomboPremios[i]="QUINTO PREMIO";
		}
		// el resto hasta completar 1.807 premios son "pedrea"
		for(int i=13;i<numPremios;i++){
			bomboPremios[i]="pedrea";
			}
		System.out.println("Bombo de premios creado...");
		return bomboPremios;
	}
	
	//devuelve un numero al azar del bombo de números, que será objeto de un premio.
	//Si un número ya ha salido, no debe volver a salir
	public static int dameNumero(int[] bombo) {
		
		int numAgraciado = (int) (Math.random()*bombo.length);

		// si el número ya había salido, generamos otro al azar

		while(bombo[numAgraciado] == -1){
			numAgraciado = (int)(Math.random()*bombo.length);
		}
		
		//COMPLETAR JSC
		
		// marcamos el número que ha salido con -1 para que no vuelva a salir
		int numero = bombo[numAgraciado];
		bombo[numAgraciado] = -1;
		
		return numero;
		//COMPLETAR JSC
	}
	
	//devuelve un premio al azar del bombo de premios
	//Si un premio ya ha salido, no debe volver a salir 
	public static String damePremio(String[] bombo) {
		//COMPLETAR JSC
		String premio;
		
		int indicePremiado = (int) (Math.random()*bombo.length);

		while(bombo[indicePremiado] == null){
			indicePremiado = (int) (Math.random()*bombo.length);
		}

		premio = bombo[indicePremiado];
		
		bombo[indicePremiado] = null;
 				
		return premio;
	}
	
	
	//Comprueba si un décimo ha sido agraciado y en tal caso indica por consola el premio
	//Ejemplo: "Agraciado con: pedrea"
	public static String heSidoAgraciado(String[] numerosSorteo, String[] premiosSorteo, String miDecimo){
	    String premio="Número no premiado"; //valor por defecto
	            
	    //COMPLETAR DFR
	    int i = 0;
	    while (i < numerosSorteo.length) {
	        if (miDecimo.equals(numerosSorteo[i])) {
	            premio = premiosSorteo[i];
	            break; // si ya lo he encontrado, salgo
	        }
	        i++;
	    }
	    return premio;
	}

	
	
	//Implementa un bucle para comprobar, haciendo uso del método heSidoAgraciado, si nuestro décimo tiene o no premio
	// Debe comprobar que se introducen exactamente 5 dígitos entre el 0 y el 9, por ejemplo 04544
	// Al introducir fin, finaliza la comprobación de décimos
	public static void compruebaDecimos(String[] numerosSorteo, String[] premiosSorteo) throws GordoException{
		Scanner sc=new Scanner(System.in);	
		String miDecimo;
		String miPremio="";
		boolean terminarDeComprobar=false;
		boolean numeroValido=false;
		    
		System.out.println("\nCOMPROBACION DE DECIMOS:");
			//Compruebo si me ha tocado la lotería

		while(!terminarDeComprobar){
		        
		System.out.println("Introduzca los 5 dígitos de su décimo (fin para terminar)");
		miDecimo = sc.nextLine();
		//COMPLETAR JSC DFR

		if(miDecimo.equals("fin")){
		            terminarDeComprobar = true;
		}else{
		if(miDecimo.length() == 5){
			char[] digitos = miDecimo.toCharArray();
			numeroValido = true;

		    for(int i=0; i<digitos.length; i++){
		    	if(digitos[i] < '0' || digitos[i] > '9'){
		        numeroValido = false;
		        }
		    }
		                
		   if(numeroValido){
		   miPremio = heSidoAgraciado(numerosSorteo, premiosSorteo, miDecimo);
		   System.out.println("Agraciado con: " + miPremio);
		   if(miPremio.equals("PRIMER PREMIO")){
			   throw new GordoException("¡¡A celebrar, te ha tocado el Gordo!!");
		       }
		   }
		   else{
			   System.out.println("Formato incorrecto.");
		   }
		                
}
		   else{
		       System.out.println("Formato incorrecto.");
}
	}
		    }
	}
					

	public static void main(String[] args) {
		
		final int MAX_NUMEROS=100000; // números del sorteo
		final int MAX_PREMIOS=1807;   // premios del sorteo
		
		int numeroAgraciado; //número que sale del bombo
		String premio=""; //premio que sale del bombo
		
				
		int[] bomboBolas = new int[MAX_NUMEROS];
		String[] bomboPremios = new String[MAX_PREMIOS];

		String[] listaNumerosSorteo = new String[MAX_PREMIOS]; // lista oficial de números que han salido en el sorteo
		String[] listaPremiosSorteo = new String[MAX_PREMIOS]; // lista oficial de premios que han salido en el sorteo
		
		try {
		
			//Creamos los bombos con sus bolas
			bomboBolas=creaBomboNumeros(MAX_NUMEROS);		
			bomboPremios=creaBomboPremios(MAX_PREMIOS);
			
			//Mostramos el listado completo de números premiados
			System.out.println("\nLISTADO OFICIAL DE PREMIOS:\n");
		
			int j=0;
			for (int i=0;i<MAX_PREMIOS;i++) {
				//Sacamos un número del bombo y lo rellenamos con ceros a la izquierda
				numeroAgraciado=dameNumero(bomboBolas);
				String numeroFormateado=String.format("%05d",numeroAgraciado);
			
				//Sacamos un premio del bombo
				premio=damePremio(bomboPremios);
				
				//Añado el número a la lista oficial del sorteo en la posición j
				listaNumerosSorteo[j]=numeroFormateado;
				
				//Añado el premio a la lista oficial del sorteo en la posición j
				//COMPLETAR DFR
				listaPremiosSorteo[j] = premio;
				
				j++;
				
				System.out.println("Numero:"+numeroFormateado+" agraciado con: "+premio);		
			}
		
			compruebaDecimos(listaNumerosSorteo, listaPremiosSorteo);
				
			
		} 	//COMPLETAR DFR (capturar excepción propia)
		
		//COMPLETAR DFR
		catch (GordoException e) {
			System.out.println("¡¡A celebrar, te ha tocado el gordo!!");
		}
		catch (Exception e) {
				System.out.println("Error:"+e.getMessage());
				} finally {
					System.out.println("\nSorteo finalizado");			
				}		
	}
}
