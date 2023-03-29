import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class Picerija {
	static ArrayList<Klients> klienti = new ArrayList<>();
	static ArrayList<Pica> pici = new ArrayList<>();
	
	static Klients konts = new Klients(null, null, null, false, 0);
	static Pica picas = new Pica(null, null, null, 0.0);
	
	static String[] picasVeidi = {"Ananāsu - 6€|8€|12€", "Margarita - 6€|8€|12€", "Amerikāņu - 6€|8€|12€", "Mafija - 6€|8€|12€", "Studentu - 6€|8€|12€"};
	static String[] picasIzmeri = {"20cm", "30cm", "50cm"};
	static String[] merces = {"Siera", "Tomātu", "Ķiploku"};
	
	public static void izveidotKlientu() {
		String vards="", talrunis="", adrese="";	
		boolean piegade = false;
		int gNr=0;
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
			Random rand = new Random();
			gNr =(char) rand.nextInt(20)+1;
			ImageIcon icon = new ImageIcon("src/restaurant-table (2).png");
			JLabel label = new JLabel("Galdiņa numurs!\n"+gNr, icon, JLabel.CENTER);
			JOptionPane.showMessageDialog(null, label, "Galdīņa numurs", JOptionPane.WARNING_MESSAGE);
			
		}  		
		Klients konts = new Klients(vards, adrese, talrunis, piegade, gNr);	
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
		 int izmCena = Arrays.asList(picasIzmeri).indexOf(picasIzmers);
		 switch(izmCena) {
		 case 0:
			 izmCena=6;
		 break;
		 case 1:
			 izmCena=8;
			 break;
		 case 2:
			 izmCena=12;
			 break;
		 }
	     double cena = 0;     
	     cena+=izmCena;		     
	     
	     Pica picas = new Pica(picasVeids, picasIzmers, merce, cena);     
	     pici.add(picas);
	  	if(klienti.get(klienti.size()-1).piegade==true) {
	 		picas.cena+=1;
		
	 		int kartupeli = JOptionPane.showConfirmDialog(null, "Būs kartupeli fri?", "Piedevas", JOptionPane.YES_NO_OPTION); 		
		 	if(kartupeli==JOptionPane.YES_OPTION) pici.get(pici.size()-1).cena+=1.50; 
		 	
		 	int dzer = JOptionPane.showConfirmDialog(null, "Būs dzēriens?", "Piedevas", JOptionPane.YES_NO_OPTION);
		 	String str = "";
		 	//String dzeriens;
		 	//String[]dzerieni = {"Fanta - 1,25€", "Coca-Cola - 1,25€", 
		 			//"Sprite - 1,25€", "Karamēļu ledus Latte - 1,25€", "Melnā kārsta kafija - 1,25€"};
		 	if(dzer==JOptionPane.YES_OPTION) {
		 		JPanel panel = new JPanel();
		 		JCheckBox fanta = new JCheckBox("Fanta - 1,25€");
		 		JCheckBox cola = new JCheckBox("Coca-Cola - 1,35€");
		 		JCheckBox sprite = new JCheckBox("Sprite - 1,10€");
		 		JCheckBox kafija = new JCheckBox("Melnā kafija - 2,00€");
		 		panel.add(fanta);
		 		panel.add(cola);
		 		panel.add(sprite);
		 		panel.add(kafija);
		 		Object[]opcijas = {"Izvelēties", panel};
		 		JOptionPane.showOptionDialog(null, "Kādi dzērieni?", "Dzerieni", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[0]);
		 		
		 		if(fanta.isSelected()) {
		 			pici.get(pici.size()-1).cena+=1.25;
		 		    str += "Fanta ";
		 		}
		 		if(cola.isSelected()) {
		 			pici.get(pici.size()-1).cena+=1.35;
		 			str += "Coca-Cola ";
		 		}
		 		if(sprite.isSelected()) {
		 			pici.get(pici.size()-1).cena+=1.10;
		 			str += "Sprite ";
		 		}
		 		if(kafija.isSelected()) {
		 			pici.get(pici.size()-1).cena+=2.00;
		 			str += "Melnā kafija ";
		 		}
		 		
		 	}
		 		
	 		
	 		
	 	}
	}
	
	
	public static void main(String[] args) {
		String[] darbibas = {"izveidot pasutijumu", "Apskatit sūtījumus", "Aizvert programmu"};
		String[]darbibas1 = {"Pievienot picu", "Aiziet atpakaļ"};
		String izvele, izv;
		int izveletaisIndekss, izIndekss;
		do {
			izvele = (String)JOptionPane.showInputDialog(null, "Izvelies darbību", "Izvele",
					JOptionPane.QUESTION_MESSAGE, null, darbibas, darbibas[0]);
			izveletaisIndekss = Arrays.asList(darbibas).indexOf(izvele);					
			switch(izveletaisIndekss){
			case 0:
				izveidotKlientu();
				do {
					izv = (String)JOptionPane.showInputDialog(null, "Izvelies darbību", "Izvele",
						JOptionPane.QUESTION_MESSAGE, null, darbibas1, darbibas1[0]);
				izIndekss = Arrays.asList(darbibas1).indexOf(izv);
				switch(izIndekss) {
				case 0:
					izveidotPicu();					
				}
				}while(izIndekss!=1);
				
				break;
			case 1:
				//izvadit();
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Programma apturēta!");
			}
	}while(izveletaisIndekss !=2);


	}
}
