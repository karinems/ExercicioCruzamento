package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Principal {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 0; i < 4; i++) {
			Thread carro = new ThreadCarro(i, 500, semaforo);
			carro.start();
		}
	}

}
