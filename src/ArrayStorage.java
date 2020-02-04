/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < size(); i++) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (uuid.equals(storage[i].getUuid())) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int position = 0;
        for (int i = 0; i < size(); i++) {
            if (storage[i].getUuid().equals(uuid)) {
                position = i;
            }
        }
        storage[position] = null;
        for (int i = position; i < size(); i++) {
            storage[i] = storage[i + 1];
            storage[i + 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resultResumeArray = new Resume[size()];
        if (size() >= 0) System.arraycopy(storage, 0, resultResumeArray, 0, size());
        return resultResumeArray;
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
