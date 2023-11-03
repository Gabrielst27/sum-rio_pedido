package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		System.out.printf("\nHow many items to this order?: ");
		int itemsQuantity = sc.nextInt();
				
		Order order = new Order(new Date(), status, client);
		// newDate() instancia a hora e data atuais do sistema
		
		for(int i = 1; i <= itemsQuantity; i++) {
			sc.nextLine();
			System.out.println();
			System.out.printf("Enter item #%d data:\n", i);
			System.out.print("Product name: ");
			String prodName = sc.nextLine();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(prodName, price);
			OrderItem item = new OrderItem(quantity, price, product);
			
			order.addItem(item);
			}
		
		System.out.println();
		System.out.println(order);
		
		sc.close();

	}
}
