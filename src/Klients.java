public class Klients {
		String vards, adrese,talrunis;
		boolean piegade;
		

		public Klients(String vards, String adrese, String talrunis, boolean piegade) {
			this.vards = vards;
			this.adrese = adrese;
			this.talrunis = talrunis;
			this.piegade = piegade;
		}

		public String izvadit() {
			return "\n------------------------------\nVārds: "+vards+"\nTālrunis: "+talrunis+"\nPiegādes adrese: "+adrese;
		}
}
