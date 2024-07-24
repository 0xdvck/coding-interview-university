//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

class ArrayListClone {
    private int[] store;
    private int size;
    private int capacity;

    ArrayListClone(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.store = new int[capacity];
    }

    boolean isEmpty() {
        return this.size == 0;
    }

    int size() {
        return this.size;
    }

    int getCapacity() {
        return this.capacity;
    }

    void push(int item) {
        ++this.size;
        if (this.size >= this.capacity) {
            this.resize(this.capacity * 2);
        }

        this.store[this.size - 1] = item;
    }

    void prepend(int item) {
        ++this.size;
        if (this.size >= this.capacity) {
            this.resize(this.capacity * 2);
        }

        for(int i = this.size - 1; i > 0; --i) {
            this.store[i] = this.store[i - 1];
        }

        this.store[0] = item;
    }

    void remove(int item) {
        int index = -1;

        int i;
        for(i = this.size - 1; i > 0; --i) {
            if (this.store[i] == item) {
                index = i;
            }
        }

        if (index != -1) {
            for(i = this.size - 1; i > index; --i) {
                this.store[i - 1] = this.store[i];
                this.store[i] = 0;
            }

            --this.size;
            if (this.size < this.capacity / 4) {
                this.resize(this.capacity / 2);
            }
        }

    }

    int find(int item) {
        for(int i = 0; i < this.size; ++i) {
            if (this.store[i] == item) {
                return i;
            }
        }

        return -1;
    }

    void insert(int item, int index) {
        ++this.size;
        if (this.size >= this.capacity) {
            this.resize(this.capacity * 2);
        }

        for(int i = this.size - 1; i > index; --i) {
            this.store[i] = this.store[i - 1];
        }

        this.store[index] = item;
    }

    int pop() {
        int result = this.store[this.size - 1];
        this.store[this.size - 1] = 0;
        --this.size;
        if (this.size <= this.capacity / 4) {
            this.resize(this.capacity / 2);
        }

        return result;
    }

    int at(int index) throws Exception {
        if (index >= 0 && index < this.size) {
            return this.store[index];
        } else {
            throw new Exception("Access index out of bound");
        }
    }

    private void resize(int newCapacity) {
        this.capacity = newCapacity;
        int[] newStore = new int[newCapacity];
        System.arraycopy(this.store, 0, newStore, 0, this.size);
        this.store = newStore;
    }

    public String toString() {
        return Arrays.toString(this.store);
    }
}
