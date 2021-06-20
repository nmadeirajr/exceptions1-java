package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reserva {

    private Integer numeroQuarto;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reserva() {
    }

    public Reserva(Integer numeroQuarto, Date checkIn, Date checkOut) {
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

        long dif = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(dif, TimeUnit.MILLISECONDS);
    }

    public String atualizarDatas(Date checkIn, Date checkOut) {

        if (checkIn.before(new Date()) || checkOut.before(new Date())) {

            return "Verifique a reserva. Datas não podem ser inferiores à data atual";
        }
        
        if (!checkOut.after(checkIn)) {

            return "Verifique a reserva. A data de Checkout não pode ser inferior à data de Checkin";

        }
        
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        return null;

    }

    @Override
    public String toString() {

        return "Quarto"
                + numeroQuarto
                + ", Check-in: "
                + sdf.format(this.checkIn)
                + ", Check-out: "
                + sdf.format(this.checkOut)
                + ", "
                + duracao()
                + " noites";
    }
}
