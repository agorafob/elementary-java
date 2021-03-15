import java.util.Arrays;
import java.util.Scanner;

public class ArrayStorage {
    private Employee[] storage = new Employee[10000];
    private int storageSize = 0;

    public void clear() {
        Arrays.fill(this.storage, null);
        this.storageSize = 0;
        System.out.println("Storage cleared");
    }

    public void save(Employee employee) {
        this.storage[this.storageSize] = employee;
        this.storageSize++;
    }

    public String scanner() {
        Scanner scc = new Scanner(System.in);
        return scc.next();
    }

    public void saveWithUuid() {
        System.out.println("Input new uuid");
        Employee employee = new Employee();
        employee.setUuid(scanner());
        save(employee);
    }

    public void deleteWithUuid() {
        System.out.println("Input uuid for delete");
        delete(scanner());
    }

    public void getWithUuid() {
        if (this.storageSize == 0) {
            getAll();
        } else {
            System.out.println("Input uuid to get");
            System.out.println(get(scanner()).toString());
        }
    }

    public Employee get(String uuid) {
        Employee employee = null;
        for (int i = 0; i < this.storageSize; i++) {
            if (this.storage[i].getUuid().equals(uuid)) {
                employee = this.storage[i];
            }
        }
        return employee;
    }

    public void delete(String uuid) {
        for (int i = 0; i < this.storageSize; i++) {
            if (this.storage[i].getUuid().equals(uuid)) {
                this.storage[i] = this.storage[this.storageSize - 1];
                this.storage[this.storageSize - 1] = null;
                this.storageSize--;
            }
        }
    }

    public Employee[] getAll() {
        Employee[] allEmployee = new Employee[this.storageSize];
        if (this.storageSize == 0) {
            System.out.println("Storage is empty");
        } else {
            allEmployee = Arrays.copyOf(this.storage, this.storageSize);
        }
        return allEmployee;
    }

    public int size() {
        return this.storageSize;
    }
}