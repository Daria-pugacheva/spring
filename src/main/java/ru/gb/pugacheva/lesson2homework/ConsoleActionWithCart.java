package ru.gb.pugacheva.lesson2homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("ru.gb.pugacheva.lesson2homework")
public class ConsoleActionWithCart {

    public static void main(String[] args) {//маленький код, так что не стала делать отдельный метод, сразу логику в main реализовала
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsoleActionWithCart.class);
        Scanner scanner = new Scanner(System.in);
        ProductRepository productRepository = context.getBean(ProductRepository.class);

        while (true) {
            System.out.println("Выберите действие:\n - создать новую корзину - введите 0 \n" +
                    " - завершить работу приложения - введите 100");

            int startChoice = scanner.nextInt();

            if (startChoice == 0) {
                Cart cart = context.getBean(Cart.class);
                System.out.println("Корзина создана. Выберите действие:\n-добавление товара - введите 10\n" +
                        "-удаление товара - введите 20\n-завершение работы с данной корзиной - введите 30");
                workWithCart(cart, scanner, productRepository);
            }

            if (startChoice == 100) {
                System.out.println("Работа приложения завершена");
                break;
            }
        }
    }

    public static void workWithCart(Cart cart, Scanner scanner, ProductRepository productRepository) {
        while (true) {
            int value = scanner.nextInt();

            if (value == 10) {
                System.out.println("Ассортимент товаров для выбора: " + productRepository.showAllProducts());
                System.out.println("Введите id товара дла добавления в корзину");
                cart.addProduct(scanner.nextInt());
                System.out.println("Товар добавлен. Список товаров в корзине: " + cart.getProductsInCart());
                System.out.println("Выберите действие");
            }

            if (value == 20) {
                System.out.println("Текущий список товаров в корзине: " + cart.getProductsInCart());
                System.out.println("Введите id товара дла удаления товара из корзины");
                cart.deleteProduct(scanner.nextInt());
                System.out.println("Товар удален. Список товаров в корзине: " + cart.getProductsInCart());
                System.out.println("Выберите действие");
            }

            if (value == 30) {
                System.out.println("Работа с текущей корзиной завершена");
                break;
            }
        }
    }

}
