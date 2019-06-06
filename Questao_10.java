package br.ufc.crateus.eda.hash;

import java.util.Random;

public class Questao_10 {

	public static void main(String[] args) {
		
		Random rand1 = new Random();
		Random rand2 = new Random();
		Random rand3 = new Random();
		Random rand4 = new Random();

		
		
		SeparateChainingHashMap<Integer, Integer> teste1 = new SeparateChainingHashMap<Integer, Integer>(Math.pow(10, 3)/100);
		SeparateChainingHashMap<Integer, Integer> teste2= new SeparateChainingHashMap<Integer, Integer>(Math.pow(10, 4)/100);
		SeparateChainingHashMap<Integer, Integer> teste3 = new SeparateChainingHashMap<Integer, Integer>(Math.pow(10, 5)/100);
		SeparateChainingHashMap<Integer, Integer> teste4 = new SeparateChainingHashMap<Integer, Integer>(Math.pow(10, 6)/100);

		
		for(int i=0;i<Math.pow(10, 3);i++) {
			
			teste1.put(rand1.nextInt(), 0);
			
		}
		
		for(int i=0;i<Math.pow(10, 4);i++) {
			
			teste2.put(rand2.nextInt(), 0);
			
		}
		
		for(int i=0;i<Math.pow(10, 5);i++) {
			
			teste3.put(rand3.nextInt(), 0);
			
		}
		
		for(int i=0;i<Math.pow(10, 6);i++) {
			
			teste4.put(rand4.nextInt(), 0);
			
		}
		
		System.out.print("Tamanho da lista de 1000: ");
		int tam[] = teste1.getLength();
		System.out.println("Maior "+tam[0] +" Menor "+tam[1]);
				
		System.out.print("Tamanho da lista de 10000: ");
		tam = teste2.getLength();
		System.out.println("Maior "+tam[0] +" Menor "+tam[1]);
		
		System.out.print("Tamanho da lista de 100000: ");
		tam = teste3.getLength();
		System.out.println("Maior "+tam[0] +" Menor "+tam[1]);
		
		System.out.print("Tamanho da lista de 1000000: ");
		tam = teste4.getLength();
		System.out.println("Maior "+tam[0] +" Menor "+tam[1]);

		/*
		Ao multiplicarmos a quantidade de células (100) pela quantidade de vetores (aproximadamente 100)
		obtemos o número de chaves.	Algumas células ultrapassam o valor 100 e outras possuem tamanho menor 
		que 100. Ao tirarmos a média das células que ultrapassam o valor 100 e das células que possuem valor 
		abaixo de 100, descobrimos  um valor próximo 100 (que era o valor inicialmente esperado).
		 */
	}
}

