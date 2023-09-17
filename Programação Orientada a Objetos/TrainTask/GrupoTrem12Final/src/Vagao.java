//Grupo 12: Giovana Raupp e Vitoria Gonzalez

public class Vagao {

	private int id;
	private double cargaTotal;
	private Trem trem;

	public Vagao(int id, double cargaTotal) {
		this.id = id;
		this.cargaTotal = cargaTotal;
		trem = null;
	}

	public int getId() {
		return id;
	}

	public double getCargaTotal() {
		return cargaTotal;
	}

    public Trem getTrem() {
        return trem;
    }

    public void vincula(Trem trem){
        this.trem = trem;
    }

    public void desvincula(Trem trem){
        this.trem = null;
    }

    @Override
    public String toString() {
        return "Vagao [cargaMax=" + cargaTotal + ", id=" + id + "]";
    }    
}