package programacao_udemy27;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reserva;

public class Programacao_udemy27 {

    public static void main(String[] args) throws ParseException {

        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Número do quarto: ");
        int numero = teclado.nextInt();
        teclado.nextLine();
        System.out.print("Data de check-in: ");
        Date checkin = sdf.parse(teclado.nextLine());
        System.out.print("Data de check-out: ");
        Date checkout = sdf.parse(teclado.nextLine());

        if (!checkout.after(checkin)) {

            System.out.println("Verifique a reserva. A data de Checkout não pode ser inferior à data de Checkin");
        } else {

            Reserva x = new Reserva(numero, checkin, checkout);
            System.out.println(x);

            System.out.println("Atualize os dados da reserva: ");
            System.out.print("Nova data de check-in: ");
            checkin = sdf.parse(teclado.next());
            System.out.print("Nova data de check-out: ");
            checkout = sdf.parse(teclado.next());

            if (checkin.before(new Date()) || checkout.before(new Date())) {

                System.out.println("Verifique a reserva. Datas não podem ser inferiores à data atual");
            } else if (!checkout.after(checkin)) {

                System.out.println("Verifique a reserva. A data de Checkout não pode ser inferior à data de Checkin");

            } else {

                x.atualizarDatas(checkin, checkout);
                System.out.println(x);
            }
        }
    }

}
