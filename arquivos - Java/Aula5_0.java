
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Calendar;
import java.util.Date; //biblioteca responsavel por mostrar a data.


public class Aula5_0 {
    public static void main(String[] args){
       var date = new Date();
       DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        //Usando o H (maiusculo) a biblioterca converte para formato 24Horas.
       System.out.println(formatter.format(date));

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = localDate.atTime(localTime);
        Date date1 = Date.from(localDateTime.toInstant(ZoneOffset.ofHours(-3)));

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date1);
        System.out.println(date1);

    }
}