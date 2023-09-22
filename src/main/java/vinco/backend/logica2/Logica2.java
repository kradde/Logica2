package vinco.backend.logica2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alex Garcia
 */
public class Logica2 {

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            int times = Integer.parseInt(line);
            while(times-- > 0){
                line = reader.readLine();
                String[] split = line.trim().split(" ");
                int x = Integer.parseInt(split[0]);
                int y = Integer.parseInt(split[1]);
                char[][] garden = new char[x][y];
                
                line = reader.readLine();
                int row = 0;
                while (line != null && row++ < x) {
                    for (int i = 0; i < line.length(); i++) {
                        garden[row - 1][i] = line.charAt(i);
                    }
                    if (row < x){
                        line = reader.readLine();
                    }
                }
                
                int count = 0;
                for (int size = 1; size < Math.min(x, y); size++) {
                    for (int i = 0; i < x - size; i++) {
                        for (int j = 0; j < y - size; j++) {
                            if (garden[i][j] == garden[i + size][j] && garden[i][j] == garden[i][j + size] && garden[i][j] == garden[i + size][j + size]) {
                                count++;
                            }
                        }
                    }
                }
                System.out.println(count);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }

}
