package structure;

public class BinarySearchTree <T extends Comparable<T>> {

    Node<T> root;
    public BinarySearchTree() {
        root = null;
    }

    public void add (T element){
        System.out.println("Adding " + element.toString() + " to the tree");
        Node<T> node = new Node<T>(element);
        if (root == null) {
            root = node;
        } else {
            add(root,node);
        }
    }
    private void add(Node<T> root, Node<T> element) {
        if (root.getValue().compareTo(element.getValue()) > 0) {
            // Elemento menor, va a la izquierda
            if (root.getLeft() == null) {
                System.out.println("Adding to " + root.getValue().toString());
                root.setLeft(element);
            } else {
                add(root.getLeft(), element);
            }
        } else {
            // Elemento mayor o igual, va a la derecha
            if (root.getRight() == null) {
                System.out.println("Adding to " + root.getValue().toString());
                root.setRight(element);
            } else {
                add(root.getRight(), element);
            }
        }
    }


    public void insert(T adding) {
        Node<T> elementAdding = new Node<>(adding);
        root = insertRec(root, elementAdding);
    }

    private Node<T> insertRec(Node<T> root, Node<T> adding) {
        if (root == null) {
            root = adding;
            return root;
        }
        if (adding.getValue().compareTo(root.getValue()) < 0)
            root.left = insertRec(root.left, adding);
        else if (adding.getValue().compareTo(root.getValue()) > 0)
            root.right = insertRec(root.right, adding);

        return root;
    }


    public T find(T element) {
        Node<T> node = new Node<>(element);
        if (root == null) {
            return null;
        } else {
            return find(root,node);
        }
    }
    private T find(Node<T> root, Node<T> element) {
        if (root.getValue().compareTo(element.getValue()) == 0) {
            return element.getValue();
        } else {
            if (root.getValue().compareTo(element.getValue()) < 0) {
                return find(root.getRight(), element);
            } else {
                return find(root.getLeft(), element);
            }
        }
    }
    /*
    public String preOrder() {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();
        } else {
            return preOrder(root,result);
        }
    }
    private String preOrder(Node<T> root,StringBuilder result) {
        if (root != null) {
            result.append(root.getValue().toString()).append("\n");
            preOrder(root.getLeft(), result);
            preOrder(root.getRight(), result);
        }
        return result.toString();
    }


    public String preOrder1() {
        StringBuilder result = new StringBuilder();
        if (root == null) {
            return result.toString();  // Si la raíz es null, devuelve el String vacío.
        } else {
            preOrder1(root, result);    // Llama al método privado que modifica el StringBuilder.
            return result.toString();  // Convierte el StringBuilder a String y lo devuelve.
        }
    }

    private void preOrder1(Node<T> root, StringBuilder result) {
        if (root != null) {
            result.append(root.getValue().toString()).append(" ");  // Agrega el valor actual al StringBuilder.
            preOrder1(root.getLeft(), result);    // Recorre el subárbol izquierdo.
            preOrder1(root.getRight(), result);   // Recorre el subárbol derecho.
        }
    }

     */
    public String preOrder() {
        return preOrder(root);
    }

    private String preOrder(Node<T> node) {
        if (node == null) {
            return "";
        }
        return node.getValue().toString()
                +preOrder(node.getLeft())
                + preOrder(node.getRight());
    }
    public String inOrder() {
        return inOrder(root);
    }

    private String inOrder(Node<T> node) {
        if (node == null) {
            return "";
        }
        return inOrder(node.getLeft())
                +node.getValue().toString()
                + inOrder(node.getRight());
    }
    public String postOrder() {
        return postOrder(root);
    }

    private String postOrder(Node<T> node) {
        if (node == null) {
            return "";
        }
        return inOrder(node.getLeft())
                + inOrder(node.getRight())
                +node.getValue().toString();
    }

}

