//Grupo 12: Giovana Raupp e Vitoria Gonzalez

public class Locomotiva {

	private int identificador;
	private double pesoMaximo;
	private int numMaxVagoes;
	private Trem trem;

	public Locomotiva(int identificador, double pesoMaximo, int numMaxVagoes) {
		this.identificador = identificador;
		this.pesoMaximo = pesoMaximo;
		this.numMaxVagoes = numMaxVagoes;
		this.trem = null;
	}

	public int getIdentificador() {
		return identificador;
	}

	public double getPesoMaximo() {
		return pesoMaximo;
	}

	public int getNumMaxVagoes() {
		return numMaxVagoes;
	}

	public Trem getTrem() {
		return trem;
	}


	public void setTrem(Trem trem) {
		this.trem = trem; 
	}

    public void vincula(Trem trem){
        this.trem = trem;
    }
    public void desvincula(){
        this.trem = null;
    }

    @Override
    public String toString() {
        return "Locomotiva [identificador=" + identificador + ", numMaxVagoes=" + numMaxVagoes + ", pesoMaximo="
                + pesoMaximo + "]";
    }
}
