package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) throws NumberFormatException {
		Scanner input = new Scanner(System.in);

		List<Shape> shapes = new ArrayList<>();
		try {
			System.out.print("Entre com o n�mero de figuras: ");
			int numberOfShapes = input.nextInt();

			int i = 1;
			while (i <= numberOfShapes) {
				System.out.println("\nDados da " + i + "� figura.");
				System.out.print("Ret�ngulo ou c�rculo? (r/c) ");
				char ch = input.next().charAt(0);

				if (ch != 'r' && ch != 'R' && ch != 'c' && ch != 'C') {
					System.out.println("\nVoc� deixou de escolher uma das op��es (r/c).");
					System.out.println("\nPor favor, tente novamente.");
				} else {
					System.out.print("Qual a cor da figura (PRETO/AZUl/VERMELHA)? ");
					Color color = Color.valueOf(input.next());

					if (ch == 'r' || ch == 'R') {
						System.out.print("Largura do ret�ngulo: ");
						double width = input.nextDouble();
						System.out.print("Altura do ret�ngulo: ");
						double height = input.nextDouble();
						shapes.add(new Rectangle(color, width, height));
					} else {
						System.out.print("Raio do c�rculo: ");
						double radius = input.nextDouble();
						shapes.add(new Circle(color, radius));
					}
					i++;
				}
			}
			System.out.println("\n�REAS DAS FIGURAS");
			for (Shape shape : shapes) {
				System.out.println(String.format("%.2f", shape.area()));
			}
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Foi inserido um valor inadequado para opera��o.");
			System.out.println("Voc� pode ter digitado uma letra no lugar de um n�mero por exemplo.");
			System.out.println("Reinicie para tentar novamente.");
		} catch (IllegalArgumentException e) {
			System.out.println();
			System.out.println("Voc� n�o escolheu uma das cores (PRETO/AZUL/VERMELHO)");
			System.out.println("Certifique-se de escolher uma das op��es, e escrever em letra mai�scula. Ex: VERMELHO");
			System.out.println("Reinicie o programa para tentar novamente.");
		} finally {
			input.close();
		}
	}
}
