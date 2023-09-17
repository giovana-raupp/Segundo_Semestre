//Grupo 12: Giovana Raupp e Vitoria Gonzalez

import java.util.ArrayList;

public class GaragemLocomotivas{
    private ArrayList<Locomotiva> locomotivas;

    public GaragemLocomotivas(){
        locomotivas = new ArrayList<>(20);
    }

    public void entra(Locomotiva locomotiva){
        locomotivas.add(locomotiva);
    }

    public Locomotiva sai(int id){
        for(Locomotiva l:locomotivas){
            if (l.getIdentificador() == id){
                locomotivas.remove(l);
                return l;
            }
        }
        return null;
    }

    public Integer getNumLocomotivas(){
        return locomotivas.size();
    }

    public String getInfoLocomotivas(){
        return null;
    }

    @Override
    public String toString() {
        StringBuilder aux = new StringBuilder("Garagem das locomotivas\n\n");
        for(Locomotiva l:locomotivas){
            aux.append(l.toString()).append("\n");
        }
        return aux.toString();
    }
}
