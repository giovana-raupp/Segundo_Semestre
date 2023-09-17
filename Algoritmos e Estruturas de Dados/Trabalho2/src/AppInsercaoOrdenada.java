
public class AppInsercaoOrdenada {
   /* public static void main(String[] args) {
        LinkedListOfString lista = new LinkedListOfString();
        lista.orderedAdd("ASSIS BRASIL");
        lista.orderedAdd("ALBERTO BINS");
        lista.orderedAdd("BENTO GONCALVES");
        lista.orderedAdd("IPIRANGA");
        lista.orderedAdd("ITABORAI");
        lista.orderedAdd("SILVA SO");
        lista.orderedAdd("ALBERTO BINS");
        lista.orderedAdd("SALVADOR FRANCA");
        lista.orderedAdd("CARLOS GOMES");
        lista.orderedAdd("NILO PEÇANHA");
        lista.orderedAdd("ALBERTO BINS");
        lista.orderedAdd("ITABORAI");12
        lista.orderedAdd("BENTO GONCALVES");
        lista.orderedAdd("MARIANTE");
        lista.orderedAdd("ALBERTO BINS");
        lista.orderedAdd("BENTO GONCALVES");
        lista.orderedAdd("FELIPE DE OLIVEIRA");
        lista.orderedAdd("LUCAS DE OLIVEIRA");
        System.out.println(lista);

    } */

    public static void main(String[] args) {
        ListaDeRuas listaDeRuas = new ListaDeRuas();

        Menu menu = new Menu(listaDeRuas);
        menu.exibirMenu();
    }
}
