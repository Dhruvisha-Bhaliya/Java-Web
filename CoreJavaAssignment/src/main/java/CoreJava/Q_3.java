/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CoreJava;

/**
 *
 * @author DELL
 */

import java.util.*;

// Interface
interface Featurable {
    void setForegroundColor(String color);
    void setBackgroundColor(String color);
    void setFont(String font);
    String getForegroundColor();
    String getBackgroundColor();
    String getFont();
}

// Custom Exception
class TableException extends Exception {
    public TableException(String message) {
        super(message);
    }
}

// DataTable Class
class DataTable implements Featurable {
    private String[][] table;
    private int rows, cols;
    private String foregroundColor = "Black";
    private String backgroundColor = "White";
    private String font = "Arial";

    public DataTable(int rows, int cols) throws TableException {
        if (rows > 200 || cols > 200) {
            throw new TableException("Rows or columns cannot exceed 200.");
        }
        this.rows = rows;
        this.cols = cols;
        table = new String[rows][cols];
    }

    // Insert value
    public void insertValue(int row, int col, String value) {
        if (isValidCell(row, col)) {
            table[row][col] = value;
        } else {
            System.out.println("Invalid cell index!");
        }
    }

    // Resize table
    public void resize(int newRows, int newCols) throws TableException {
        if (newRows > 200 || newCols > 200) {
            throw new TableException("Rows or columns cannot exceed 200.");
        }
        String[][] newTable = new String[newRows][newCols];
        for (int i = 0; i < Math.min(rows, newRows); i++) {
            for (int j = 0; j < Math.min(cols, newCols); j++) {
                newTable[i][j] = table[i][j];
            }
        }
        rows = newRows;
        cols = newCols;
        table = newTable;
    }

    // Insert/Delete row
    public void insertRow(int index) throws TableException {
        resize(rows + 1, cols);
        for (int i = rows - 1; i > index; i--) {
            table[i] = table[i - 1];
        }
        table[index] = new String[cols];
    }

    public void deleteRow(int index) {
        for (int i = index; i < rows - 1; i++) {
            table[i] = table[i + 1];
        }
        rows--;
        table = Arrays.copyOf(table, rows);
    }

    // Insert/Delete column
    public void insertColumn(int index) throws TableException {
        resize(rows, cols + 1);
        for (int i = 0; i < rows; i++) {
            for (int j = cols - 1; j > index; j--) {
                table[i][j] = table[i][j - 1];
            }
            table[i][index] = null;
        }
    }

    public void deleteColumn(int index) {
        for (int i = 0; i < rows; i++) {
            for (int j = index; j < cols - 1; j++) {
                table[i][j] = table[i][j + 1];
            }
        }
        cols--;
        String[][] newTable = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            newTable[i] = Arrays.copyOf(table[i], cols);
        }
        table = newTable;
    }

    // Populate from Hashtable
    public void populateFromHashtable(Hashtable<Integer, String> data) {
        int count = 0;
        for (Map.Entry<Integer, String> entry : data.entrySet()) {
            int r = count / cols;
            int c = count % cols;
            if (r < rows) {
                table[r][c] = entry.getValue();
            }
            count++;
        }
    }

    // Display table
    public void display() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((table[i][j] == null ? "-" : table[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    private boolean isValidCell(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }

    // Featurable methods
    public void setForegroundColor(String color) { this.foregroundColor = color; }
    public void setBackgroundColor(String color) { this.backgroundColor = color; }
    public void setFont(String font) { this.font = font; }
    public String getForegroundColor() { return foregroundColor; }
    public String getBackgroundColor() { return backgroundColor; }
    public String getFont() { return font; }
}
public class Q_3 {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataTable table = null;

        try {
            System.out.print("Enter rows: ");
            int rows = sc.nextInt();
            System.out.print("Enter columns: ");
            int cols = sc.nextInt();
            table = new DataTable(rows, cols);
        } catch (TableException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.println("\n--- DataTable Menu ---");
            System.out.println("1. Insert value");
            System.out.println("2. Resize table");
            System.out.println("3. Insert row");
            System.out.println("4. Delete row");
            System.out.println("5. Insert column");
            System.out.println("6. Delete column");
            System.out.println("7. Set colors and font");
            System.out.println("8. Populate from Hashtable");
            System.out.println("9. Display table");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Row index: ");
                        int r = sc.nextInt();
                        System.out.print("Col index: ");
                        int c = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Value: ");
                        String val = sc.nextLine();
                        table.insertValue(r, c, val);
                        break;
                    case 2:
                        System.out.print("New rows: ");
                        int nr = sc.nextInt();
                        System.out.print("New cols: ");
                        int nc = sc.nextInt();
                        table.resize(nr, nc);
                        break;
                    case 3:
                        System.out.print("Row index to insert: ");
                        table.insertRow(sc.nextInt());
                        break;
                    case 4:
                        System.out.print("Row index to delete: ");
                        table.deleteRow(sc.nextInt());
                        break;
                    case 5:
                        System.out.print("Column index to insert: ");
                        table.insertColumn(sc.nextInt());
                        break;
                    case 6:
                        System.out.print("Column index to delete: ");
                        table.deleteColumn(sc.nextInt());
                        break;
                    case 7:
                        sc.nextLine();
                        System.out.print("Foreground color: ");
                        table.setForegroundColor(sc.nextLine());
                        System.out.print("Background color: ");
                        table.setBackgroundColor(sc.nextLine());
                        System.out.print("Font: ");
                        table.setFont(sc.nextLine());
                        break;
                    case 8:
                        Hashtable<Integer, String> data = new Hashtable<>();
                        sc.nextLine();
                        System.out.print("How many entries? ");
                        int n = sc.nextInt();
                        sc.nextLine();
                        for (int i = 0; i < n; i++) {
                            System.out.print("Key (int): ");
                            int key = sc.nextInt();
                            sc.nextLine();
                            System.out.print("Value: ");
                            String value = sc.nextLine();
                            data.put(key, value);
                        }
                        table.populateFromHashtable(data);
                        break;
                    case 9:
                        table.display();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (TableException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}