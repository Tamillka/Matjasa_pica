import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Picerija {
	static ArrayList<Klients> klienti = new ArrayList<>();
	
	public static void izveidotKlientu() {
	int gNr=0;
		String vards="", talrunis="", adrese="";	
		boolean piegade = false;
		int pieg = (JOptionPane.showConfirmDialog(null, "Būs piegāde mājās?", "Piegāde mājās", JOptionPane.YES_NO_OPTION));
		
		if (pieg==JOptionPane.YES_OPTION){	
			 vards += (String)JOptionPane.showInputDialog("Vārds");
			 talrunis += (String)JOptionPane.showInputDialog("Tālrunis");
	  adrese = (String)JOptionPane.showInputDialog("Adrese");	
	 piegade = true;
		}else if(pieg==JOptionPane.NO_OPTION) {
		    vards += "-";
		    talrunis += "-";
			adrese += "-";
			
		}  		
		Klients konts = new Klients(vards, adrese, talrunis, piegade);	
		klienti.add(konts);
	}
	public static void main(String[] args) {
		

	}
}
