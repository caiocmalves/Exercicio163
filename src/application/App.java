package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App {
    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        List<Product> lista = new ArrayList<>();
        
        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + "data: ");
            System.out.print("Common, used or imported (c/u/i)?");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();            
            String name = sc.nextLine();
            System.out.println("Price: ");
            double price = sc.nextDouble();
            if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                lista.add(new ImportedProduct(name, price, customsFee));
            }
            else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                Date manufactureDate = sdf.parse(sc.next());
                lista.add(new UsedProduct(name, price, manufactureDate));
            }
            else if (ch == 'c'){
                lista.add(new Product(name, price));
            }
        }

        for (Product product : lista) {
            System.out.println(product.priceTag());    
        }

        sc.close();
    }
}
