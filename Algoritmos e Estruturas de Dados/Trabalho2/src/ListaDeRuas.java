public class ListaDeRuas {

    class Node {
        public Node prev;
        public Node next;
        public ListaDeSinalizacoes lista;
        public String prefixo;
        public String nomeDaRua;
        public String idDaRua;
        

        public ListaDeRuas.Node getRuaAtual() {
            return current;
        }
        
    }

    private Node head;
    private Node current;

    public void reset() {
        current = head;
    }

    public void next() {
        if (current != null) {
            current = current.next;
        }
    }

    public void prev() {
        if (current != null) {
            current = current.prev;
        }
    }

    public String getRuaComMaisSinalizacoes() {
        String ruaComMaisSinalizacoes = null;
        int maxSinalizacoes = 0;

        Node node = head;
        while (node != null) {
            int numSinalizacoes = node.lista.size();
            if (numSinalizacoes > maxSinalizacoes) {
                maxSinalizacoes = numSinalizacoes;
                ruaComMaisSinalizacoes = node.nomeDaRua;
            }
            node = node.next;
        }

        return ruaComMaisSinalizacoes;
    }

    public void insereOrdenado(String nomeDaRua, Sinalizacao sinalizacao) {
        StringBuilder sb = new StringBuilder();

        String[] partesRua = nomeDaRua.split(" ");

        for (int i = 1; i < partesRua.length; i++)
            sb.append(partesRua[i] + " ");

        Node newNode = new Node();
        newNode.prefixo = partesRua[0];
        newNode.nomeDaRua = sb.toString();
        newNode.lista = new ListaDeSinalizacoes();
        newNode.lista.add(sinalizacao);

        if (head == null) {
            head = newNode;
            current = head;
        } else {
            Node node = head;
            while (node.next != null) {
                int comparison = node.nomeDaRua.compareToIgnoreCase(sb.toString());
                if (comparison == 0) {
                    node.lista.add(sinalizacao);
                    return;
                } else if (comparison > 0) {

                    newNode.next = node;
                    if (node.prev != null) {
                        newNode.prev = node.prev;
                        newNode.prev.next = newNode;
                    }
                    node.prev = newNode;


                    if (node == head)
                        head = newNode;

                    return;
                }
                node = node.next;
            }
            node.next = newNode;
            newNode.prev = node;
        }
    }


    public boolean contains(String nomeDaRua) {
        Node node = head;
        while (node != null) {
            if (node.nomeDaRua.equalsIgnoreCase(nomeDaRua)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null){
            sb.append("Rua: ").append(node.nomeDaRua).append("\n");
            sb.append("ID da Rua: ").append(node.idDaRua).append("\n");
            sb.append("Número total de sinalizações: ").append(node.lista.size()).append("\n");
            sb.append("Primeira sinalização registrada na rua: ").append(node.lista.getPrimeiraSinalizacao().getDescricao()).append("\n");
            sb.append("Última sinalização registrada na rua: ").append(node.lista.getUltimaSinalizacao().getDescricao()).append("\n");
            sb.append("\n");
            node = node.next;
        }

        return sb.toString();
    }

    public String getRuaAtual() {
        return current.prefixo + " " + current.nomeDaRua;
   }

   public int getNumeroTotalSinalizacoesRuaAtual() {
    if (current != null) {
        return current.lista.size();
    } else {
        return 0;
    }
}

public String getPrimeiraSinalizacaoRuaAtual() {
    if (current != null && current.lista.size() > 0) {
        return current.lista.getPrimeiraSinalizacao().getDescricao();
    } else {
        return "Nenhuma sinalização encontrada.";
    }
}

public String getUltimaSinalizacaoRuaAtual() {
    if (current != null && current.lista.size() > 0) {
        return current.lista.getUltimaSinalizacao().getDescricao();
    } else {
        return "Nenhuma sinalização encontrada.";
    }
}

public int getMesComMaisSinalizacoesRuaAtual() {
    
    ListaDeSinalizacoes lista = current.lista;

    int[] meses = new int[12];

    for (int i = 0; i < lista.size(); i++) {
        meses[lista.getMes(i) - 1] += 1;
    }

    int mesMaisSinalizacoes = 0;

    for (int i = 0; i < meses.length; i++) {
        if (meses[mesMaisSinalizacoes] < meses[i])
            mesMaisSinalizacoes = i;
    }

    return mesMaisSinalizacoes + 1;
}

}