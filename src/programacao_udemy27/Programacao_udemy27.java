package programacao_udemy27;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reserva;
import model.exceptions.Excecoes;

public class Programacao_udemy27 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.print("Número do quarto: ");
            int numero = teclado.nextInt();
            teclado.nextLine();
            System.out.print("Data de check-in: ");
            Date checkin = sdf.parse(teclado.nextLine());
            System.out.print("Data de check-out: ");
            Date checkout = sdf.parse(teclado.nextLine());

            Reserva x = new Reserva(numero, checkin, checkout);
            System.out.println(x);

            System.out.println("Atualize os dados da reserva: ");
            System.out.print("Nova data de check-in: ");
            checkin = sdf.parse(teclado.next());
            System.out.print("Nova data de check-out: ");
            checkout = sdf.parse(teclado.next());
            x.atualizarDatas(checkin, checkout);

            System.out.println(x);
        }
        
        catch (ParseException p) {
            
            System.out.println("Formato de data inválida");
        }
        
        catch (Excecoes i) {
            
            System.out.println("Erro: " + i.getMessage());
        }
    }

}
