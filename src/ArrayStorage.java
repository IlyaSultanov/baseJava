/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
            size = 0;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
        size = size();
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int position = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                position = i;
            }
        }
        if (position == -1) {
            System.out.println("no matches for deleting");
            return;
        }
        storage[position] = null;
        for (int i = position; i < size; i++) {
            storage[i] = storage[i + 1];
            storage[i + 1] = null;
        }
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        System.arraycopy(storage, 0, resumes, 0, size);
        return resumes;
    }

    int size() {
        int sizeCount = 0;
        for (Resume resume : storage) {
            if (resume != null) {
                sizeCount++;
            } else {
                return sizeCount;
            }
        }
        return sizeCount;
    }

}
