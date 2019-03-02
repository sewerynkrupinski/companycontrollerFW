package J38;

import java.io.IOException;
import java.util.Scanner;

public class CompanyRun{

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        CompanyController companyController = new CompanyController();
        String sourceFile = "C:\\Users\\kurs\\Desktop\\Projekty ALX\\src\\J38\\company.txt";
        String imie;
        String nazwisko;
        String noweNazwisko;

        while(true){

            System.out.println("D-dodaj, P-pokaż, U-usuń, Z-zmień, K-koniec");
            String dec = sc.nextLine().toUpperCase();

            if (dec.equals("D")){

                System.out.println("Podaj imię ");
                imie = sc.nextLine();
                System.out.println("Podaj nazwisko");
                nazwisko = sc.nextLine();

                companyController.addEmployee(sourceFile, imie, nazwisko);

            }

            else if(dec.equals("P")){

                companyController.showEmployee(sourceFile);
            }

            else if(dec.equals("U")){

                System.out.println("Podaj nazwisko do usunięcia");
                nazwisko = sc.nextLine();
                companyController.delEmployee(sourceFile,nazwisko);
            }

            else if(dec.equals("Z")){
                System.out.println("Podaj nazwisko do zmiany");
                nazwisko = sc.nextLine();
                System.out.println("Podaj nowe nazwisko");
                noweNazwisko = sc.nextLine();
                companyController.changeEmployee(sourceFile, nazwisko, noweNazwisko);

            }

            else if(dec.equals("K")){
                sc.close();
                break;

            }

        }

    }

}
