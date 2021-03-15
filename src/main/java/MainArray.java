import java.util.Arrays;

public class MainArray {

    static final ArrayStorage NEW_ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        execution();
        printAll();
    }

    static void printAll() {
        System.out.println(Arrays.toString(NEW_ARRAY_STORAGE.getAll()));
    }

    private static void startMessage() {
        System.out.println(" Введите одну из команд - (list | save uuid | delete uuid | get uuid | size | clear | exit):");
    }

    private static void execution() {
        startMessage();
        switch (NEW_ARRAY_STORAGE.scanner()) {
            case ("list"):
                printAll();
                execution();
                break;
            case ("save"):
                NEW_ARRAY_STORAGE.saveWithUuid();
                printAll();
                execution();
                break;
            case ("delete"):
                NEW_ARRAY_STORAGE.deleteWithUuid();
                printAll();
                execution();
                break;
            case ("get"):
                NEW_ARRAY_STORAGE.getWithUuid();
                execution();
                break;
            case ("size"):
                System.out.println("Size: " + NEW_ARRAY_STORAGE.size());
                execution();
                break;
            case ("clear"):
                NEW_ARRAY_STORAGE.clear();
                printAll();
                execution();
                break;
            case ("exit"):
                System.out.println("BYE");
                break;
            default:
                System.out.println("Ошибка");
                execution();
        }
    }
}
