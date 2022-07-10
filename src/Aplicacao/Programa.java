package Aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Entidades.Reserva;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Numero do quarto: ");
		int numero = sc.nextInt();
		System.out.print("Data do check-in (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Data do check-out (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		/*
		 * condicional para testar se a 
		 * data checkout a ser atualizada 
		 * é posterior a data checkin
		*/		
		if (!checkOut.after(checkIn)) {
			System.out.println("Erro na reserva: Check-out deve ser posterior a data de check-in");
		}
		else {
			Reserva reserva = new Reserva(numero, checkIn, checkOut);
			System.out.println("Reserva: " + reserva);
			
			System.out.println();
			System.out.println("Entre com a data para atualização da reserva: ");
			System.out.print("Data do check-in (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Data do check-out (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date agora = new Date();
			if (checkIn.before(agora) || checkOut.before(agora)) {
				System.out.println("Erro de resesva: As atualizações devem ser datas futuras");
			}
			else if (!checkOut.after(checkIn)) {
				System.out.println("Erro na reserva: Check-out deve ser posterior a data de check-in");
			}
			else {
				reserva.atualizacaoDeData(checkIn, checkOut);
				System.out.println("Reserva: " + reserva);
			}
			
		}
		
		sc.close();
	}

}
