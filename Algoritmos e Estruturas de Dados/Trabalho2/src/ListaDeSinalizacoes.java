import java.time.LocalDate;

public class ListaDeSinalizacoes {

    private class Node {
        public Sinalizacao element;
        public Node next;
    }

    private Node head;
    private Node tail;
    private Node current;
    private int size;

    public void add(Sinalizacao sinalizacao) {
        Node newNode = new Node();
        newNode.element = sinalizacao;
        newNode.next = null;

        if (head == null) {
            head = newNode;
            current = head;
        } else {
            current.next = newNode;
            current = newNode;
        }

        tail = newNode;

        size++;
    }

    public int size() {
        return size;
    }

    public int getMes(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = getNodeAt(index);
        LocalDate implantacao = node.element.getImplantacao();
        return implantacao.getMonthValue();
    }

    public LocalDate getDataImplantacao(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node node = getNodeAt(index);
        return node.element.getImplantacao();
    }

    public void reset() {
        current = head;
    }

    public void next() {
        if (current != null) {
            current = current.next;
        }
    }

    private Node getNodeAt(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public Sinalizacao getPrimeiraSinalizacao() {
        return head.element;
    }

    public Sinalizacao getUltimaSinalizacao() {
        return tail.element;
    }
}
