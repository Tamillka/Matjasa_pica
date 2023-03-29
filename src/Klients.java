public class Klients {
		String vards, adrese,talrunis;
		boolean piegade;
		int gNr;
		

		public Klients(String vards, String adrese, String talrunis, boolean piegade, int gNr) {
			this.vards = vards;
			this.adrese = adrese;
			this.talrunis = talrunis;
			this.piegade = piegade;
			this.gNr = gNr;
		}

		public String izvadit() {
			return "\n------------------------------\nVārds: "+vards+"\nTālrunis: "+talrunis+"\nPiegādes adrese: "+adrese+"\nGalda numurs: "+gNr;
		}
}
