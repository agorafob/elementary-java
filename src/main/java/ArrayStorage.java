import java.util.Arrays;

/**
 * Array based storage for Employees
 */
public class ArrayStorage {
    Employee[] storage = new Employee[10000];

    int storageSize = 0;

    void clear() {
        Arrays.fill(storage, null);
        storageSize = 0;
    }

    void save(Employee employee) {
        storage[storageSize] = employee;
        storageSize++;
    }

    Employee get(String uuid) {
        Employee employee = null;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                employee = storage[i];
            }
        }
        return employee;
    }

    void delete(String uuid) {
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = storage[storageSize - 1];
                storage[storageSize - 1] = null;
                storageSize--;
            }
        }
    }

    /**
     * @return array, contains only Employees in storage (without null)
     */
    Employee[] getAll() {
        Employee[] allEmployee = new Employee[storageSize];
        if (storageSize == 0) {
            System.out.println("Storage is empty");
        } else {
            allEmployee = Arrays.copyOf(storage, storageSize);
        }
        return allEmployee;
    }

    int size() {
        return storageSize;
    }
}
