import java.util.Scanner;

//Taller 1 con Thread 
//Alejandro Ahogado Prieto - 201920701

public class ThreadsTaller1 extends Thread {


	private int numMaximo = 0;
	private String nombre  = "";

	public ThreadsTaller1 (int maximo, String nombre) {

		this.numMaximo=maximo;
		this.nombre=nombre;

	}


	public void run() {

		
		if (nombre.equals("numerosPares")) {
			
			for (int i = 1; i <=numMaximo; i++) {
				if (i%2==0) {
					System.out.println(i);
					try {
						currentThread().sleep(1000);
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
						currentThread().sleep(1000);
					} catch (InterruptedException e) {
					
						e.printStackTrace();
					}
				}
			}
		}

		try {
			Thread.sleep(1000000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}

	}



	public static void main(String[] args) {
		
		Scanner reader = new Scanner(System.in);
		int maximo =0;
		System.out.println("Digite el limite");
		maximo = reader.nextInt();


		ThreadsTaller1 t1 = new ThreadsTaller1(maximo,"numerosPares");

		ThreadsTaller1 t2 = new ThreadsTaller1(maximo, "numerosImpares");
		System.out.println("Imprimiendo numeros pares e impares entre 1 y "+ maximo);
		t1.start();
		t2.start();
	}

}
