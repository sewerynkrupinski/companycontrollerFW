package J38;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CompanyController {


    public void addEmployee(String sourceFile, String imie, String nazwisko) throws IOException {

        FileWriter fw = new FileWriter(sourceFile, true);
        fw.append(imie + ";" + nazwisko + "\n");
        fw.close();

    }

    public void showEmployee(String sourceFile) throws FileNotFoundException {

        Scanner rf = new Scanner(new File(sourceFile));
        while (rf.hasNextLine()) {
            System.out.println(rf.nextLine());
        }
        rf.close();

    }


    public void delEmployee(String sourceFile, String nazwisko) throws IOException {

        ArrayList<String> lista = new ArrayList<>();
        Scanner rf = new Scanner(new File(sourceFile));
        while (rf.hasNextLine()) {

            String[] parts = rf.nextLine().split(";");
            String imieF = parts[0].trim();
            String nazwiskoF = parts[1];

            if (!nazwiskoF.equals(nazwisko))
                lista.add(imieF + ";" + nazwiskoF + "\n");


        }
        rf.close();

        FileWriter fw = new FileWriter(sourceFile, false);
        for (String dane : lista) {
            fw.append(dane);
        }
        fw.close();
    }

    public void changeEmployee(String sourceFile, String nazwisko, String noweNazwisko) throws IOException {
        ArrayList<String> listaZmien = new ArrayList<>();
        Scanner rf = new Scanner(new File(sourceFile));
        while (rf.hasNextLine()) {
            String[] parts = rf.nextLine().split(";");
            String imieF = parts[0].trim();
            String nazwiskoF = parts[1];


            if (nazwiskoF.equals(nazwisko)) {
                listaZmien.add(imieF + ";" + noweNazwisko + "\n");
            }
            else if (!nazwiskoF.equals(nazwisko))
                listaZmien.add(imieF + ";" + nazwiskoF + "\n");
            }

        rf.close();

        FileWriter fw = new FileWriter(sourceFile, false);
        for (String dane : listaZmien) {
            fw.append(dane);
        }
        fw.close();


    }
}
