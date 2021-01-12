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
			System.out.print("Entre com o número de figuras: ");
			int numberOfShapes = input.nextInt();

			int i = 1;
			while (i <= numberOfShapes) {
				System.out.println("\nDados da " + i + "ª figura.");
				System.out.print("Retângulo ou círculo? (r/c) ");
				char ch = input.next().charAt(0);

				if (ch != 'r' && ch != 'R' && ch != 'c' && ch != 'C') {
					System.out.println("\nVocê deixou de escolher uma das opções (r/c).");
					System.out.println("\nPor favor, tente novamente.");
				} else {
					System.out.print("Qual a cor da figura (PRETO/AZUl/VERMELHA)? ");
					Color color = Color.valueOf(input.next());

					if (ch == 'r' || ch == 'R') {
						System.out.print("Largura do retângulo: ");
						double width = input.nextDouble();
						System.out.print("Altura do retângulo: ");
						double height = input.nextDouble();
						shapes.add(new Rectangle(color, width, height));
					} else {
						System.out.print("Raio do círculo: ");
						double radius = input.nextDouble();
						shapes.add(new Circle(color, radius));
					}
					i++;
				}
			}
			System.out.println("\nÁREAS DAS FIGURAS");
			for (Shape shape : shapes) {
				System.out.println(String.format("%.2f", shape.area()));
			}
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("Foi inserido um valor inadequado para operação.");
			System.out.println("Você pode ter digitado uma letra no lugar de um número por exemplo.");
			System.out.println("Reinicie para tentar novamente.");
		} catch (IllegalArgumentException e) {
			System.out.println();
			System.out.println("Você não escolheu uma das cores (PRETO/AZUL/VERMELHO)");
			System.out.println("Certifique-se de escolher uma das opções, e escrever em letra maiúscula. Ex: VERMELHO");
			System.out.println("Reinicie o programa para tentar novamente.");
		} finally {
			input.close();
		}
	}
}
