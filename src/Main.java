import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("employees.txt");
        Path copyPath = Paths.get("copy_employees.txt");

        ArrayList<String> employees = new ArrayList<>();

        try {
            if (Files.notExists(path)) {
                System.out.println("File employees.txt tidak ditemukan.");
                return;
            }

            try (BufferedReader br = Files.newBufferedReader(
                    path, StandardCharsets.UTF_8)) {

                String line;

                while ((line = br.readLine()) != null) {
                    employees.add(line);
                }
            }

            System.out.println("Isi file employees.txt:");

            for (String employee : employees) {
                System.out.println(employee);
            }

            Files.write(copyPath, employees,
                    StandardCharsets.UTF_8);

            System.out.println("File berhasil disalin ke copy_employees.txt");

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }
}