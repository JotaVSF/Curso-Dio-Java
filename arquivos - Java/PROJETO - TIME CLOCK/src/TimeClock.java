
import java.util.Scanner;

public class TimeClock {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== SISTEMA DE REGISTRO DE PONTO ===");
        System.out.println("Digite o nome do funcionario: ");
        String name = scanner.nextLine();

        Employee employee = new Employee(name);
        employee.punchIn();
        System.out.println("\n✅ Entrada registrada às: " + employee.FormattedClockIn());

        System.out.println("\n(Pressione ENTER para registrar a saída)");

        while (true){
            scanner.nextLine();

            if(employee.MinimumWorkingHours(60)){
                employee.clockOut();
                System.out.println("\n✅ Saida registrada às: " + employee.FormattedClockOut());
                System.out.printf("\n🕑 %s trabalhou por %s (h:m:s)\n",employee.getName(), employee.getFormattedTimeWork());
                RegistroUtils.SaveRecord(employee);
                System.out.println("\nEncerrando!!!");
                break;
            }else{
                long remainingMinutes = employee.remainingMinutesTo(60);
                System.out.println("⏳ Ainda não se passaram 1 hora desde a entrada.");
                System.out.println("Por favor, aguarde mais " + remainingMinutes + " minuto(s)...");
                System.out.println("(Pressione ENTER novamente para tentar registrar a saída)\n");
            }
        }
    }
}
