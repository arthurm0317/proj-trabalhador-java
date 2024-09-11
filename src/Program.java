import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome do departamento: ");
        String department = scanner.nextLine();
        System.out.println("Dados do trabalhador ");
        System.out.print("name: ");
        String name = scanner.nextLine();
        System.out.print("level: ");
        String level = scanner.nextLine().toUpperCase();
        System.out.print("salario base: ");
        Double baseSalary = scanner.nextDouble();

        Worker worker = new Worker(name,WorkerLevel.valueOf(level), baseSalary,new Department(department) );

        System.out.print("Quantidade de contratos do trabalhador: ");
        int quantContratos = scanner.nextInt();

        for(int i=1; i<=quantContratos; i++){
            System.out.println("entre com os dados do #"+i+" contrato: ");
            System.out.println("Data: ");
            Date contractDate = sdf.parse(scanner.next());
            System.out.println("valor por hora");
            Double valuePerHour = scanner.nextDouble();
            System.out.println("Duração: ");
            int hours = scanner.nextInt();
            HourContract contract = new HourContract(contractDate, valuePerHour, hours);
            worker.addContract(contract);
        }
        System.out.println(" ");
        System.out.println("Entre com o mes e ano que serao calculados (MM/YYYY)");
        String monthAndYear = scanner.next();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("nome:" +worker.getName());
        System.out.println("dapartamento: "+worker.getDepartment().getName());
        System.out.println("valor total do periodo "+monthAndYear+": "+ String.format("%2f", worker.income(year, month)));

    }
}
