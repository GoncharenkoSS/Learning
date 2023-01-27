package For_example.BinaryTree;

import java.util.Stack;

class Tree {
    private Node rootNode; // корневой узел

    public Tree() { // Пустое дерево
        rootNode = null;
    }

    public Node findNodeByValue(int value) { // поиск узла по значению
        Node curr = rootNode; // начинаем поиск с корневого узла
        while (curr.getValue() != value) { // поиск покуда не будет найден элемент или не будут перебраны все
            if (value < curr.getValue()) { // движение влево?
                curr = curr.getLeft();
            } else { //движение вправо
                curr = curr.getRight();
            }
            if (curr == null) { // если потомка нет,
                return null; // возвращаем null
            }
        }
        return curr; // возвращаем найденный элемент
    }

    public void insertNode(int value) { // метод вставки нового элемента
        Node newNode = new Node(); // создание нового узла
        newNode.setValue(value); // вставка данных
        if (rootNode == null) { // если корневой узел не существует
            rootNode = newNode;// то новый элемент и есть корневой узел
        }
        else { // корневой узел занят
            Node current = rootNode; // начинаем с корневого узла
            Node parentNode;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentNode = current;
                if(value == current.getValue()) {   // если такой элемент в дереве уже есть, не сохраняем его
                    return;    // просто выходим из метода
                }
                else  if (value < current.getValue()) {   // движение влево?
                    current = current.getLeft();
                    if (current == null){ // если был достигнут конец цепочки,
                        parentNode.setLeft(newNode); //  то вставить слева и выйти из методы
                        return;
                    }
                }
                else { // Или направо?
                    current = current.getRight();
                    if (current == null) { // если был достигнут конец цепочки,
                        parentNode.setRight(newNode);  //то вставить справа
                        return; // и выйти
                    }
                }
            }
        }
    }

    public boolean deleteNode(int value) // Удаление узла с заданным ключом
    {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;
        while (currentNode.getValue() != value) { // начинаем поиск узла
            parentNode = currentNode;
            if (value < currentNode.getValue()) { // Определяем, нужно ли движение влево?
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            }
            else { // или движение вправо?
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }
            if (currentNode == null)
                return false; // yзел не найден
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) { // узел просто удаляется, если не имеет потомков
            if (currentNode == rootNode) // если узел - корень, то дерево очищается
                rootNode = null;
            else if (isLeftChild)
                parentNode.setLeft(null); // если нет - узел отсоединяется, от родителя
            else
                parentNode.setRight(null);
        }
        else if (currentNode.getRight() == null) { // узел заменяется левым поддеревом, если правого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getLeft();
            else if (isLeftChild)
                parentNode.setLeft(currentNode.getLeft());
            else
                parentNode.setRight(currentNode.getLeft());
        }
        else if (currentNode.getLeft() == null) { // узел заменяется правым поддеревом, если левого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getRight();
            else if (isLeftChild)
                parentNode.setLeft(currentNode.getRight());
            else
                parentNode.setRight(currentNode.getRight());
        }
        else { // если есть два потомка, узел заменяется преемником
            Node heir = receiveHeir(currentNode);// поиск преемника для удаляемого узла
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeft(heir);
            else
                parentNode.setRight(heir);
        }
        return true; // элемент успешно удалён
    }

    // метод возвращает узел со следующим значением после передаваемого аргументом.
    // для этого он сначала переходим к правому потомку, а затем
    // отслеживаем цепочку левых потомков этого узла.
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRight(); // Переход к правому потомку
        while (currentNode != null) // Пока остаются левые потомки
        {
            parentNode = heirNode;// потомка задаём как текущий узел
            heirNode = currentNode;
            currentNode = currentNode.getLeft(); // переход к левому потомку
        }
        // Если преемник не является
        if (heirNode != node.getRight()) // правым потомком,
        { // создать связи между узлами
            parentNode.setLeft(heirNode.getRight());
            heirNode.setRight(node.getRight());
        }
        return heirNode;// возвращаем приемника
    }

    public void printTree() { // метод для вывода дерева в консоль
        Stack globalStack = new Stack(); // общий стек для значений дерева
        globalStack.push(rootNode);
        int gaps = 32; // начальное значение расстояния между элементами
        boolean isRowEmpty = false;
        String separator = "-----------------------------------------------------------------";
        System.out.println(separator);// черта для указания начала нового дерева
        while (isRowEmpty == false) {
            Stack localStack = new Stack(); // локальный стек для задания потомков элемента
            isRowEmpty = true;

            for (int j = 0; j < gaps; j++)
                System.out.print(' ');
            while (globalStack.isEmpty() == false) { // покуда в общем стеке есть элементы
                Node temp = (Node) globalStack.pop(); // берем следующий, при этом удаляя его из стека
                if (temp != null) {
                    System.out.print(temp.getValue()); // выводим его значение в консоли
                    localStack.push(temp.getLeft()); // соохраняем в локальный стек, наследники текущего элемента
                    localStack.push(temp.getRight());
                    if (temp.getLeft() != null ||
                            temp.getRight() != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("__");// - если элемент пустой
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < gaps * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            gaps /= 2;// при переходе на следующий уровень расстояние между элементами каждый раз уменьшается
            while (localStack.isEmpty() == false)
                globalStack.push(localStack.pop()); // перемещаем все элементы из локального стека в глобальный
        }
        System.out.println(separator);// подводим черту
    }
}

