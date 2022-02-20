package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room number:");
			int number=sc.nextInt();
			sc.nextLine();
			System.out.println("Checkin date (dd/MM/yyyy):");
			Date checkin = sdf.parse(sc.next());
			System.out.println("Checkout date (dd/MM/yyyy):");
			Date checkout = sdf.parse(sc.next());		
			
			Reservation res = new Reservation(number, checkin, checkout);
			System.out.println(res);
			
			System.out.print("Room number:");
			number=sc.nextInt();
			sc.nextLine();
			System.out.println("Checkin date (dd/MM/yyyy):");
			checkin = sdf.parse(sc.next());
			System.out.println("Checkout date (dd/MM/yyyy):");
			checkout = sdf.parse(sc.next());
			res.updateDates(checkout, checkin);
		}
		catch(ParseException error){
			System.out.println("Invalid format date!");
		}
		catch(DomainException error) {
			System.out.println("Error on Reservation day:"+error.getMessage());
		}
		catch(RuntimeException error) {
			System.out.println("Unexpected error");
		}
		finally {
			System.out.println("End of program!");
			sc.close();
		}
	}

}
