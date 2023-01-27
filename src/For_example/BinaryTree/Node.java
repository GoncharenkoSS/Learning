package For_example.BinaryTree;

class Node {
    private int value; // ключ узла
    private Node left; // Левый узел потомок
    private Node right; // Правый узел потомок

    public void printNode() { // Вывод значения узла в консоль
        System.out.println(" Выбранный узел имеет значение :" + value);
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(final int value) {
        this.value = value;
    }

    public Node getLeft() {
        return this.left;
    }

    public void setLeft(final Node leftChild) {
        this.left = leftChild;
    }

    public Node getRight() {
        return this.right;
    }

    public void setRight(final Node rightChild) {
        this.right = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + left +
                ", rightChild=" + right +
                '}';
    }
}
