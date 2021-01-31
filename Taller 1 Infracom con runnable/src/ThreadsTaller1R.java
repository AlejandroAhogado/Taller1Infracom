import java.util.Scanner;

//Taller 1 con Runnable 
//Alejandro Ahogado Prieto - 201920701

public class ThreadsTaller1R implements Runnable {


	private int numMaximo = 0;
	private String nombre  = "";

	public ThreadsTaller1R (int maximo, String nombre) {

		this.numMaximo=maximo;
		this.nombre=nombre;

	}


	public void run() {

		
		if (nombre.equals("numerosPares")) {
			
			for (int i = 1; i <=numMaximo; i++) {
				if (i%2==0) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
				}
			}

		}
		else if (nombre.equals("numerosImpares")) {
			
			for (int i = 1; i <=numMaximo; i++) {
				if (i%2!=0) {
					System.out.println(i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
				}
			}
		}
	}



	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		int maximo =0;
		System.out.println("Digite el limite");
		maximo = reader.nextInt();

		Thread t1 = new Thread(new ThreadsTaller1R(maximo, "numerosPares"));
		Thread t2 = new Thread(new ThreadsTaller1R(maximo, "numerosImpares"));
		
		System.out.println("Imprimiendo numeros pares e impares entre 1 y "+ maximo);
		t1.start();
		t2.start();
	}

}
