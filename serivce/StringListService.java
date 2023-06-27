package serivce;

import exception.ArrayIndexOutBondsException;
import exception.ElementMissingException;

import java.util.Arrays;

public class StringListService implements StringList {
    private final String[] stringList = new String[5];
    private int size = 1;
    public int index;
    public String removeItem;

    @Override
    public String add(String item) {
        index = size - 1;
        if (size < stringList.length) {
            stringList[index] = item;
            size++;
            return stringList[index];
        } else {
            throw new ArrayIndexOutBondsException("Массив переполнен");
        }
    }

    @Override
    public String add(int index, String item) {
        if (index >= size || index>=stringList.length -1){
            throw new ArrayIndexOutBondsException("Индекс вышел за пределы массива");
        }
        for (int i = stringList.length - 1; i == index; i--) {
            stringList[i] = stringList[i - 1];
        }
        stringList[index] = item;
        size++;
        return stringList[index];
    }

    @Override
    public String set(int index, String item) {
        if (index >= size || index >= stringList.length - 1) {
            throw new ArrayIndexOutBondsException("Индекс вышел за пределы массива");
        }
        stringList[index] = item;
        return stringList[index];
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < stringList.length - 1; i++) {
            if (stringList[i] == item) {
                removeItem = stringList[i];
                stringList[i] = null;
                size--;
                break;
            }
            for (int j = i; j < stringList.length - 1; j++) {
                stringList[j] = stringList[i + 1];
            }
        }
        return removeItem;
    }

    @Override
    public  String remove(int index) {
        if (index > stringList.length - 1) {
            throw new ArrayIndexOutBondsException("Индес вышел за пределы");
        }
        if (stringList[index] == null) {
            throw new ElementMissingException("Элемент отсутствует");
        } else {
            removeItem = stringList[index];
            stringList[index] = null;
            size--;
        }
        for (int i = index; i < stringList.length - 1; i++) {
            stringList[i] = stringList[index - 1];
        }
        return removeItem ;
    }
    @Override
    public boolean contains(String item) {
        boolean containsItem = false;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] == item) {
                containsItem = true;
            }
        }
        return containsItem;
    }

    @Override
    public int indexOf(String item) {
        int indexOf = -1;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] == item) {
                indexOf = i;
            }
        }
        return indexOf;
    }

    @Override
    public int lastIndexOf(String item) {
        int lastIndexOf = -1;
        for (int i = stringList.length - 1; i >=0 ; i--) {
            if (stringList[i] == item) {
                lastIndexOf = i;
                break;
            }
        }
        return lastIndexOf;
    }

    @Override
    public String get(int index) {
        String getItem = null;
        if (index > stringList.length - 1) {
            throw new ArrayIndexOutBondsException("Индекс вышел за пределы");
        }
        getItem = stringList[index];
        return getItem;
    }
    @Override
    public boolean equals(StringList otherList) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        boolean isEmpty = true;
        for (int i = 0; i < stringList.length; i++) {
            if (stringList[i] == null) {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    @Override
    public Object clear() {
        for (int i = 0; i < stringList.length; i++) {
            stringList[i] = null;
        }
        return null;
    }

    @Override
    public String[] toArray() {
        int n = stringList.length;
        String[] toArrayMas = null;
        String[] toArray = Arrays.copyOf(stringList, n);
        toArrayMas = toArray;
        return toArrayMas;
    }
}