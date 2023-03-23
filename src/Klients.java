public class Klients {
		String vards, uzvards, adrese,talrunis;
		boolean piegade;

		public Klients(String vards, String uzvards, String adrese, String talrunis,boolean piegade) {
			this.vards = vards;
			this.uzvards = uzvards;
			this.adrese = adrese;
			this.talrunis = talrunis;
			this.piegade = piegade;
		}

		public String izvadit() {
			return "\n------------------------------\nVārds: "+vards+" "+uzvards+"\nTālrunis: "+talrunis+"\nPiegādes adrese: "+adrese;
		}
}
