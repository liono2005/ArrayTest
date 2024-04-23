package org.example.in;

import java.util.Arrays;

public class ArrayListString implements StringList {
    private String[] array;
    private int size;

    public ArrayListString(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть больше 0.");
        }
        this.array = new String[capacity];
        this.size = 0;
    }

    // Добавление элемента.
    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не должен быть пустым.");
        }
        if (size == array.length) {
            throw new ArrayIndexOutOfBoundsException("Элементов, массив заполнен!");
        }
        array[size] = item;
        size++;
        return item;
    }

    // Добавление элемента на определенную позицию списка.
    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не должен быть пустым.");
        }
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы массива.");
        }
        if (size == array.length) {
            throw new ArrayIndexOutOfBoundsException("Невозможно добавить больше элементов, массив заполнен!");
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
        return item;
    }

    // Установить элемент на определенную позицию, затерев существующий.
    @Override
    public String set(int index, String item) {
        if (item == null) {

            throw new IllegalArgumentException("Элемент не должен быть пустым.");
        }
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы массива.");
        }
        String replacedItem = array[index];
        array[index] = item;
        return replacedItem;
    }

    // Удаление элемента.
    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не должен быть пустым.");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return item;
            }
        }
        throw new IllegalArgumentException("Удаляемый элемент не был найден в массиве.");
    }

    // Удаление элемента по индексу.
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы массива.");
        }
        String removedItem = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return removedItem;
    }

    // Проверка на существование.
    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    // Поиск элемента.
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Поиск элемента с конца массива.
    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    // Получение элемента по индексу.
    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы массива.");
        }
        return array[index];
    }

    // Сравнение текущего списка с другим.
    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Другой cписок не может быть пустым.");
        }
        if (this.size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }

    // Вернуть фактическое количество элементов.
    @Override
    public int size() {
        return size;
    }

    // Проверка на то, пуст массив или нет.
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    // Удаление всех элементов из списка.
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    // Создание нового массива.
    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
}
