package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entidades.Reserva;
import model.excecoes.DominioException;

public class Programa {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Numero do quarto: ");
			int numero = sc.nextInt();
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());
			
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data para atualização da reserva: ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			reserva.atualizacaoDeData(checkIn, checkOut);
		    System.out.println("Reserva: " + reserva);
		}
		catch (ParseException e) {
			System.out.println("Formato da data inválida!");
		}
		catch (DominioException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("ERROR: Verifique os dados digitatos!");
		}
		
		sc.close();
	}

}
