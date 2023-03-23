public class Pica {
	String picasVeids, picasIzmers, merce;
	double cena;
	
	public Pica(String picasVeids, String picasIzmers, String merce, double cena) {
		this.picasVeids = picasVeids;
		this.picasIzmers = picasIzmers;
		this.merce = merce;
		this.cena = cena;
	}
	public String izvadit() {
	return "\nIzvēlētais ēdiens: "+picasVeids+" "+picasIzmers+" ar "+merce+" mērci; ";	
	}
}
