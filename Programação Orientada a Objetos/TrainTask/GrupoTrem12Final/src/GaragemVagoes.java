//Grupo 12: Giovana Raupp e Vitoria Gonzalez

import java.util.ArrayList;

public class GaragemVagoes{
    private ArrayList<Vagao> vagoes;

    public GaragemVagoes(){
        vagoes = new ArrayList<>(20);
    }

    public void entra(Vagao vagao){
        vagoes.add(vagao);
    }

    public Vagao sai(int id){
        for(Vagao l:vagoes){
            if (l.getId() == id){
                vagoes.remove(l);
                return l;
            }
        }
        return null;
    }

    public Integer getNumVagoes(){
        return vagoes.size();
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder("Garagem dos vagões\n\n");
        for(Vagao l:vagoes){
            aux.append(l.toString()).append("\n");
        }
        return aux.toString();
    }
}