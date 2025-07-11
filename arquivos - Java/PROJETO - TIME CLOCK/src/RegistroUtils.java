import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegistroUtils {

    private static final String ARQUIVO = "registros.csv";
    public static void SaveRecord(Employee employee){
        try(FileWriter fw = new FileWriter(ARQUIVO, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){
            out.printf("%s,%s,%s,%s%n",
                    employee.getName(),
                    employee.FormattedClockIn(),
                    employee.FormattedClockOut(),
                    employee.getFormattedTimeWork()
            );
            System.out.println("💾 Registro salvo em '" + ARQUIVO + "' com sucesso.");
        } catch (IOException e) {
            System.out.println("❌ Erro ao salvar o registro: " + e.getMessage());
        }
    }

}
