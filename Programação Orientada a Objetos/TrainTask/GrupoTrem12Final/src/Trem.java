//Grupo 12: Giovana Raupp e Vitoria Gonzalez

import java.util.ArrayList;

public class Trem {

	private int id;
	private ArrayList<Locomotiva> locomotivas;
	private ArrayList<Vagao> vagoes;

	public Trem(int id,Locomotiva locomotiva){
        this.id = id;
        locomotivas = new ArrayList<>();
        vagoes = new ArrayList<>();
        adicionarLocomotiva(locomotiva);
    }

    public int getId() {
        return id;
    }

	public boolean adicionarLocomotiva(Locomotiva locomotiva) {
		if (vagoes.isEmpty()) { 
			locomotiva.vincula(this);
			locomotivas.add(locomotiva);
            return true;
		}
        return false;

    }


	public Locomotiva desengataLocomotiva(){
        if (locomotivas.size() == 0){
            return null;
        }
        Locomotiva aux = locomotivas.remove(locomotivas.size()-1);
        aux.desvincula();
        return aux;
    }

	public boolean adicionarVagao(Vagao vagao) { 
        if (limiteDeVagoesAtingido() || pesoMaximoDosVagoesAtingido()){
            return false;
        }
        vagoes.add(vagao);
        vagao.vincula(this);
        return true;
    }
    
    public Vagao desengataVagao(){
        if (vagoes.size() > 0){
            Vagao aux = vagoes.get(vagoes.size()-1);
            vagoes.remove(vagoes.size()-1);
            aux.desvincula(null);
            return aux;
        }
        return null;
    }

    //mostrar trem
    public String toString(){
        String aux = "T"+id+"+";
        for(Locomotiva l:locomotivas){
            aux += "[L"+l.getIdentificador()+"]+";
        }
        for(Vagao v:vagoes){
            aux += "[V"+v.getId()+"]+";
        }
        return aux;
    }

    // Métodos auxiliares
    private boolean limiteDeVagoesAtingido(){
        int qtdade = 0;
        for(Locomotiva l:locomotivas){
            qtdade += l.getNumMaxVagoes();
        }
        return vagoes.size() >= qtdade;
    }

    private double pesoMaximoLocomotivasTracionam(){
        double peso = 0;
        double tx = 1.0;
        for(Locomotiva l:locomotivas){
            peso += l.getPesoMaximo() * tx;
            tx *= 0.9;
        }
        return peso;
    }

    private boolean pesoMaximoDosVagoesAtingido(){
        double peso = 0.0;
        for(Vagao v:vagoes){
            peso += v.getCargaTotal();
        } 
        return peso >= pesoMaximoLocomotivasTracionam();
    }

}

