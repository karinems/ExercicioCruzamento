package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {

	private String destino;
	private Semaphore semaforo;
	private int cruzamento;

	public ThreadCarro(int i, int distancia, Semaphore semaf) {

		switch (i) {
		case 0:
			destino = "Vai de Norte para Sul";
			break;

		case 1:
			destino = "Vai de Sul para Norte";
			break;

		case 2:
			destino = "Vai de Leste para Oeste";
			break;

		case 3:
			destino = "Vai de Oeste para Leste";
			break;
		default:
			break;
		}
		cruzamento = distancia;
		semaforo = semaf;

	}

	@Override
	public void run() {

		try {
			semaforo.acquire();
			Transito();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {

			semaforo.release();

		}
		super.run();
	}

	private void Transito() {

		int distanciaPercorrida = 0;
		int deslocamento = 100;
		int tempo = 30;
		while (distanciaPercorrida < cruzamento) {
			distanciaPercorrida += deslocamento;

			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		System.out.println("Carro " + getId() + " andou " + distanciaPercorrida + " m. " + destino);
	}
}
