package model.entidades;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import model.excecoes.DominioException;

public class Reserva {
	private Integer numeroQuarto;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) throws DominioException {
		if (!checkOut.after(checkIn)) {
			throw new DominioException("Check-out deve ser posterior a data de check-in");
		}
		this.numeroQuarto = numeroQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}

	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		//Convesão de mili-segundos para dias
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	//metodo para atualizar as datas de agendamento
	public void atualizacaoDeData(Date checkIn, Date checkOut) throws DominioException{
		Date agora = new Date();
		if (checkIn.before(agora) || checkOut.before(agora)) {
			throw new DominioException("As atualizações devem ser datas futuras");
		}
		if (!checkOut.after(checkIn)) {
			throw new DominioException("Check-out deve ser posterior a data de check-in");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Quarto: "
				+ numeroQuarto
				+ ", check-in: "
				+ sdf.format(checkIn)
				+ ", check-out: "
				+ sdf.format(checkOut)
				+ ", "
				+ duracao()
				+ " noites";
	}
}
