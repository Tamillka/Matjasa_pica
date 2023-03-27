import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Picerija {
	static ArrayList<Klients> klienti = new ArrayList<>();
	
	static Klients konts = new Klients(null, null, null,false);
	
	public static void izveidotKlientu() {
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
	
	try {
        FileWriter fw = new FileWriter("klientuDati.txt", true);
        fw.write(konts.izvadit());
        fw.close();
        JOptionPane.showMessageDialog(null, "Dati saglabāti");
    } catch (Exception e) { 
        JOptionPane.showMessageDialog(null, "Rādās kļūda ierakstot datus!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
    }
}
	public static void main(String[] args) {
		String[] darbibas = {"izveidot pasutijumu", "Apskatit sūtījumus", "Aizvert programmu"};	
		String izvele;
		int izveletaisIndekss;
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvelies darbību", "Izvele",
					JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			izveletaisIndekss = Arrays.asList(darbibas).indexOf(izvele);
			
			
			switch(izveletaisIndekss){
			case 0:
				izveidotKlientu();
				
				break;
			}
	}while(izveletaisIndekss !=2);


	}
}
