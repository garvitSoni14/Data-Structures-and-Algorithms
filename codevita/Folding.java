package codevita;
import java.util.*;

public class Folding {

    static class Cell {
        Deque<Integer> stack = new ArrayDeque<>();
        Cell(int num) { stack.push(num); }
        Cell() {}
        void addAllOnTop(Cell other) {
            Deque<Integer> temp = new ArrayDeque<>();
            for (int val : other.stack)
                temp.addFirst(val);
            while (!temp.isEmpty())
                stack.push(temp.removeFirst());
        }
        int top() { return stack.peek(); }
        int bottom() { return stack.peekLast(); }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        String[] folds = sc.nextLine().trim().split("\\s+");

        // Initialize sheet numbers
        Cell[][] sheet = new Cell[R][C];
        int num = 1;
        for (int i = 0; i < R; i++)
            for (int j = 0; j < C; j++)
                sheet[i][j] = new Cell(num++);

        // Apply folds
        for (String f : folds) {
            char type = f.charAt(0);
            int line = Integer.parseInt(f.substring(1));
            if (type == 'h')
                sheet = foldHorizontal(sheet, line);
            else
                sheet = foldVertical(sheet, line);
        }

        System.out.println(sheet[0][0].top() + " " + sheet[0][0].bottom());
    }

    // ---------------- Folding operations ----------------

    // Fold bottom half upward
    static Cell[][] foldHorizontal(Cell[][] sheet, int h) {
        int R = sheet.length, C = sheet[0].length;
        int topRows = h, bottomRows = R - h;

        if (h <= 0 || h >= R) return sheet; // invalid fold → ignore

        Cell[][] top = new Cell[topRows][C];
        Cell[][] bottom = new Cell[bottomRows][C];

        for (int i = 0; i < topRows; i++)
            for (int j = 0; j < C; j++)
                top[i][j] = sheet[i][j];

        for (int i = 0; i < bottomRows; i++)
            for (int j = 0; j < C; j++)
                bottom[i][j] = sheet[h + i][j];

        reverseRows(bottom); // bottom folds up

        int newR = Math.min(topRows, bottomRows);
        Cell[][] result = new Cell[newR][C];

        for (int i = 0; i < newR; i++) {
            for (int j = 0; j < C; j++) {
                Cell merged = new Cell();
                merged.addAllOnTop(bottom[i][j]); // folded part on top
                merged.addAllOnTop(top[topRows - newR + i][j]);
                result[i][j] = merged;
            }
        }
        return result;
    }

    // Fold right half leftward
    static Cell[][] foldVertical(Cell[][] sheet, int v) {
        int R = sheet.length, C = sheet[0].length;
        int leftCols = v, rightCols = C - v;

        if (v <= 0 || v >= C) return sheet; // invalid fold → ignore

        Cell[][] left = new Cell[R][leftCols];
        Cell[][] right = new Cell[R][rightCols];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < leftCols; j++)
                left[i][j] = sheet[i][j];
            for (int j = 0; j < rightCols; j++)
                right[i][j] = sheet[i][v + j];
        }

        reverseCols(right); // right folds leftward

        int newC = Math.min(leftCols, rightCols);
        Cell[][] result = new Cell[R][newC];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < newC; j++) {
                Cell merged = new Cell();
                merged.addAllOnTop(right[i][j]); // folded side on top
                merged.addAllOnTop(left[leftCols - newC + j][i < left.length ? j : 0]);
                result[i][j] = merged;
            }
        }
        return result;
    }

    static void reverseRows(Cell[][] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            Cell[] tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    static void reverseCols(Cell[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int l = 0, r = arr[i].length - 1; l < r; l++, r--) {
                Cell tmp = arr[i][l];
                arr[i][l] = arr[i][r];
                arr[i][r] = tmp;
            }
        }
    }
}
