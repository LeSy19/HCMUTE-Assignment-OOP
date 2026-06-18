package model;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class GenericStack<T> {
    private List<T> elements;

    public GenericStack() {
        this.elements = new ArrayList<>();
    }

    // Thêm item vào đỉnh ngăn xếp
    public void push(T item) {
        elements.add(item);
    }

    // Lấy và xóa phần tử ở đỉnh
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.remove(elements.size() - 1);
    }

    // Xem phần tử đỉnh mà không xóa
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return elements.get(elements.size() - 1);
    }

    // Kiểm tra ngăn xếp rỗng
    public boolean isEmpty() {
        return elements.isEmpty();
    }

    // Trả về số phần tử hiện có
    public int size() {
        return elements.size();
    }
}
