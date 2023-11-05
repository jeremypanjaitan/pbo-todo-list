import java.util.Objects;
import java.util.Scanner;

public class MainTodoList {
    public static String[] model = new String[10];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        viewShowTodoList();
    }

    public static String input(String info) {
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;
    }

    public static void testInput() {
        var name = input("Nama");
        System.out.println("Hi " + name);
    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;
            if (Objects.nonNull(todo)) {
                System.out.println(no + ". " + todo);
            }
        }
    }

    public static void testShowTodoList() {
        model[0] = "Belajar Java Dasar";
        model[1] = "Studi Kasus Java Dasar : Aplikasi Todolist";
        showTodoList();
    }

    /**
     * Menambah todo ke list
     */
    public static void addTodoList(String todo) {
        // cek apakah model penuh ?
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                isFull = false;
                break;
            }
        }

        //jika penuh, kita resize ukuran array 2 kali lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        // Tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }

    }

    public static void testAddTodoList() {
        for (int i = 0; i < 25; i++) {
            addTodoList("Contoh todo ke. " + (i + 1));
        }
        showTodoList();
    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer number) {
        // check whether the selected todo is 0
        if (number == 0) {
            return false;
        }
        // check whether the selected todo is greater than the current size of the model
        if (number - 1 > model.length - 1) {
            return false;
        }

        // check whether the selected todo is already null
        if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = number - 1; i < model.length; i++) {
                //if the selected id is the last element
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    // replace the current element with the element beside it
                    model[i] = model[i + 1];
                }
            }
            return true;
        }
    }

    public static void testRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        var result = removeTodoList(1);
        System.out.println(result);
        showTodoList();
    }


    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {
        while (true) {
            showTodoList();
            System.out.println("MENU : ");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("3. Keluar");

            var input = input("Pilih");

            if (input.equals("1")) {
                viewAddTodoList();
            } else if (input.equals("2")) {
                viewRemoveTodoList();
            } else if (input.equals("3")) {
                break;
            } else {
                System.out.println("Pilih menu dengan benar");
            }
        }
    }

    public static void testViewShowTodoList() {
        model[0] = "Satu";
        model[1] = "Dua";
        model[2] = "Tiga";
        model[3] = "Empat";
        model[4] = "Lima";
        viewShowTodoList();
    }

    /**
     * Menampilkan add todo list
     */
    public static void viewAddTodoList() {
        System.out.println("MENAMBAH TODO LIST");
        var todo = input("Todo (x jika batal)");
        if (todo.equals("x")) {
            //batal
        } else {
            addTodoList(todo);
        }
    }

    public static void testViewAddTodoList() {
        viewAddTodoList();
        showTodoList();
    }

    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList() {
        System.out.println("MENGHAPUS TODO LIST");

        var number = input("Nomor yang dihapus (x jika batal)");
        if (number.equals("x")) {
            // batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(number));
            if (!success) {
                System.out.println("Gagal menghapus todo list : " + number);
            }
        }
    }

    public static void testViewRemoveTodoList() {
        addTodoList("Satu");
        addTodoList("Dua");
        addTodoList("Tiga");

        showTodoList();
        viewRemoveTodoList();

        showTodoList();
    }
}