public class Cofrinho {
    private Moeda [] cofrinho;
    private final int capacidade;
    private int proxLivre;

    public Cofrinho(){
        proxLivre = 0;
        capacidade = 100;
        cofrinho = new Moeda[capacidade];  
    }

    public Cofrinho(int capacidade){
        proxLivre = 0;
        this.capacidade = capacidade;
        cofrinho = new Moeda[capacidade]; 
    }

    public boolean Insere(Moeda moeda){
        if(proxLivre >= capacidade){
            return false;
        }
        cofrinho[proxLivre] = moeda;
        proxLivre++;

        return true;
    }

    public Moeda Retira(){
        if((proxLivre) == 0){
            return null;
        }
        proxLivre--;
        return cofrinho[proxLivre];
    }

    public int getQtdadeMoedas(){
        return cofrinho.length;
    }

    public int getQtDeMoedasTipo(NomeMoeda nomeMoeda){
        int quant = 0;
        for(int pos = 0; pos < proxLivre; pos++){
            if(cofrinho[pos].getNomeMoeda().equals(nomeMoeda)){
                quant++;
            }
        }
        return quant;
    }

    public double getValorTotalCentavos(){
        double soma = 0.0;
        for(int pos = 0; pos < proxLivre; pos++){
            soma += cofrinho[pos].getValorCentavos();
        }
        return soma;
    }
    
    public double getValorTotalReais(){
        double soma = 0.0;
        for(int pos = 0; pos < proxLivre; pos++){
            soma += cofrinho[pos].getValorReais();
        }
        return soma;
    }

    public String toString(){
        String textin = "[";
        for(int pos = 0; pos < proxLivre; pos++){
            textin += cofrinho[pos].getNomeMoeda().name() + " , ";
        }
        textin += cofrinho[proxLivre -1].getNomeMoeda().name() + "]";
        return textin;
    }
}