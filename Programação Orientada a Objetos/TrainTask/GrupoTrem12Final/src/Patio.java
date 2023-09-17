//Grupo 12: Giovana Raupp e Vitoria Gonzalez

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Patio {
    private ArrayList<Trem> trens;
    GaragemLocomotivas gloc;
    GaragemVagoes gvag;
    Random rand= new Random();
    Scanner entrada = new Scanner(System.in);

    public Patio(){
        trens = new ArrayList<Trem>(100);
        gloc = new GaragemLocomotivas();
        gvag = new GaragemVagoes();

        for (int i=0; i<20;i++)
        {
            gvag.entra(new Vagao(100+rand.nextInt(899), 6000));
        }

        gloc.entra(new Locomotiva(123, 6000, 5));
        gloc.entra(new Locomotiva(456, 8000, 6));
        gloc.entra(new Locomotiva(789, 7000, 5));
        gloc.entra(new Locomotiva(321, 9000, 9));

    }

    
    public Trem getTrem(int id){
        for(Trem t: trens){
            if (t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public boolean checaIdTrem(int id){
        for(Trem t: trens){
            if (t.getId() == id){
                return true;
            }
        }
        return false;
    }

    public boolean desfazTrem(int idTrem) {
        if (!checaIdTrem(idTrem)) {
            return false;
        }
        Trem t = getTrem(idTrem);
        while(true) {
            Vagao v = t.desengataVagao();
            if (v == null) {
                break;
            }
            gvag.entra(v);
        }
        while(true) {
            Locomotiva l = t.desengataLocomotiva();
            if (l == null) {
                break;
            }
            gloc.entra(l);
        }
        trens.remove(t);
        t = null;
        return true;
    }


    public boolean inserirVagao(int idTrem){
        if(gvag.getNumVagoes() < 1){
            System.out.println("Não há vagões disponíveis");
            return false;
        } else {
            System.out.println("Vagões disponíveis:" + gvag.toString());
            System.out.print("Qual vagão deseja engatar?(ID) ");
            Vagao vagao = gvag.sai(entrada.nextInt());
            Trem t = getTrem(idTrem);
            return t.adicionarVagao(vagao);
        }
    }

    public boolean inserirLocomotiva(int idTrem){
        if(gloc.getNumLocomotivas() < 1){
            System.out.println("Nao há locomotivas disponíveis!");
            return false;
        } else {
            System.out.println("Locomotivas disponiveis: " + gloc.toString());
            System.out.print("Qual locomotiva deseja engatar?(ID) ");
            Locomotiva locomotiva = gloc.sai(entrada.nextInt());
            return getTrem(idTrem).adicionarLocomotiva(locomotiva);
        }
    }

    public void entra(Trem trem){
        trens.add(trem);
    }

    public String toString() {
        StringBuilder aux = new StringBuilder("Patio de trens\n\n");
        for(Trem l:trens){
            aux.append(l.toString()).append("\n");
        }
        return aux.toString();
    }

    public boolean removerUltimo(int idTrem) {
        Trem trem= null;
        for (int i=0; i<trens.size();i++)
        {
            trem= trens.get(i);
            if (trem.getId()== idTrem)
            {
                break;
            }
        }
        Vagao vagao = trem.desengataVagao();
        if(vagao == null){
            return false;
        } else {
            gvag.entra(vagao);
            return true;
        }
    }

    public void listarLocomotivasLivres() {
        if(gloc.getNumLocomotivas() < 1){
            System.out.println("Nao há locomotivas disponíveis!");
        } else {
            System.out.println("Locomotivas disponiveis: " + gloc.toString());
        }
    }

    public void listarVagoesLivres() {
        if(gvag.getNumVagoes() < 1){
            System.out.println("Não há vagões disponíveis");
        } else {
            System.out.println("Vagões disponíveis:" + gvag.toString());
        }
    }

    public Trem criaTrem(int idTrem, int idLocomotiva){
        Trem t = new Trem(idTrem, gloc.sai(idLocomotiva));
        trens.add(t);
        return t;
    }
}
