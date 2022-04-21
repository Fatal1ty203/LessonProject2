package hw.homework9.iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Apple",50));
        products.add(new Product("Cherry",25));
        products.add(new Product("Banana",78));

        Product.ProductService productService = new Product.ProductService();

        productService.setIterator(new Product.ProductService.IteratorPrice(products,50));

        int input = 0;
        while (input !=7){
            Scanner scn = new Scanner(System.in);
            System.out.println("1. простой вывод (просто выводит все товары из списка)\n" +
                    "2. вывод товаров с фильтром по цене (не дороже определенной цены)\n" +
                    "3. вывод товаров по возрастацию цены\n" +
                    "4. вывод товаров по убыванию цены\n" +
                    "5. вывод товаров по возрастанию цены с фильтром по цене(не дороже определенной цены)\n" +
                    "6. добавить товар\n" +
                    "7. выход");
            input = scn.nextInt();
            if (input == 1){
                System.out.println(products);
            }else if (input == 2){
                System.out.println("Введите цену: ");
                int price = scn.nextInt();
                productService.setIterator(new Product.ProductService.IteratorPrice(products,price));
            }else if (input == 3){
                Collections.sort(products, new Product.ProductService.AscendingPrice());
                System.out.println(products);
            }else if (input == 4){
                Collections.sort(products, new Product.ProductService.DescendingPrice());
                System.out.println(products);
            }else if (input == 5){
                Collections.sort(products, new Product.ProductService.AscendingPrice());
                System.out.println("Введите цену: ");
                int price = scn.nextInt();
                productService.setIterator(new Product.ProductService.IteratorPrice(products,price));
            }else if (input == 6){
                System.out.println("Введите наименование товара: ");
                scn.nextLine();
                String name = scn.nextLine();
                System.out.println("Введите цену товара: ");
                int price = scn.nextInt();
                products.add(new Product(name,price));
            }
        }
    }
}
