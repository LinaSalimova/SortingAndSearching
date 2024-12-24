package org.example;

import java.util.Comparator;
import java.util.List;

public class Collections {

    public static <T extends Comparable<? super T>> int binarySearch(List<? extends T> list, T key) {
        if (list instanceof java.util.RandomAccess) {
            return indexedBinarySearch(list, key);
        } else {
            return iteratorBinarySearch(list, key);
        }
    }

    private static <T> int indexedBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = list.get(mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    private static <T> int iteratorBinarySearch(List<? extends Comparable<? super T>> list, T key) {
        int low = 0;
        int high = list.size() - 1;
        java.util.ListIterator<? extends Comparable<? super T>> i = list.listIterator();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            Comparable<? super T> midVal = get(i, mid);
            int cmp = midVal.compareTo(key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    private static <T> T get(java.util.ListIterator<? extends T> i, int index) {
        T obj = null;
        int pos = i.nextIndex();
        if (pos <= index) {
            do {
                obj = i.next();
            } while (pos++ < index);
        } else {
            do {
                obj = i.previous();
            } while (--pos > index);
        }
        return obj;
    }

    public static <T> int binarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        if (list instanceof java.util.RandomAccess) {
            return indexedBinarySearch(list, key, c);
        } else {
            return iteratorBinarySearch(list, key, c);
        }
    }

    private static <T> int indexedBinarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = list.get(mid);
            int cmp = c.compare(midVal, key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }

    private static <T> int iteratorBinarySearch(List<? extends T> list, T key, Comparator<? super T> c) {
        int low = 0;
        int high = list.size() - 1;
        java.util.ListIterator<? extends T> i = list.listIterator();

        while (low <= high) {
            int mid = (low + high) >>> 1;
            T midVal = get(i, mid);
            int cmp = c.compare(midVal, key);

            if (cmp < 0)
                low = mid + 1;
            else if (cmp > 0)
                high = mid - 1;
            else
                return mid;
        }
        return -(low + 1);
    }
}