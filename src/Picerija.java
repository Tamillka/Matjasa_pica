import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JOptionPane;



public class Picerija {
	static ArrayList<Klients> klienti = new ArrayList<>();
	static ArrayList<Pica> pici = new ArrayList<>();
	
	static Klients konts = new Klients(null, null, null,false);
	static Pica picas = new Pica(null, null, null, 0.0);
	
	static String[] picasVeidi = {"Ananāsu - 6€|8€|12€", "Margarita - 6€|8€|12€", "Amerikāņu - 6€|8€|12€", "Mafija - 6€|8€|12€", "Studentu - 6€|8€|12€"};
	static String[] picasIzmeri = {"20cm", "30cm", "50cm"};
	static String[] merces = {"Siera", "Tomātu", "Ķiploku"};
	static String[]dzerieni = {"Fanta - 1,25€", "Coca-Cola - 1,25€", "Sprite - 1,25€", "Karamēļu ledus Latte - 1,25€", "Melnā kārsta kafija - 1,25€"};
	
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
	
	public static void izveidotPicu() {
		String picasVeids = (String)JOptionPane.showInputDialog(null, "Kāda pica?", "Picas veidi", JOptionPane.QUESTION_MESSAGE, null, picasVeidi, picasVeidi[0]);
		 String picasIzmers = (String) JOptionPane.showInputDialog(null, "Kāds picas izmērs?", "Picas izmērs", JOptionPane.QUESTION_MESSAGE, null, picasIzmeri, picasIzmeri[0]);
		 String merce = (String)JOptionPane.showInputDialog(null, "Kāda mērce?", "Mērces", JOptionPane.QUESTION_MESSAGE, null, merces, merces[0]);
		 
		 double cena = 0;
		 Pica picas = new Pica(picasVeids, picasIzmers, merce, cena);
		 pici.add(picas);
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
