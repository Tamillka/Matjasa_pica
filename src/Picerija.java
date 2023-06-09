import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Picerija {
	static DecimalFormat df = new DecimalFormat("##.##");
	static ArrayList<Klients> klienti = new ArrayList<>();
	static ArrayList<Pica> pici = new ArrayList<>();
	
	static Klients konts = new Klients(null, null, null, false, 0);
	static Pica picas = new Pica(null, null, null, 0.0);
	
	static String[] picasVeidi = {"Ananāsu", "Margarita", "Amerikāņu", "Mafija", "Studentu"};
	static String[] picasIzmeri = {"20cm", "30cm", "50cm"};
	static String[] merces = {"Siera", "Tomātu", "Ķiploku"};
	
	public static void izveidotKlientu() {
		String vards="", talrunis="", adrese="";	
		boolean piegade = false;
		int gNr=0;
		int pieg = (JOptionPane.showConfirmDialog(null, "Būs piegāde mājās? - 2,50€", "Piegāde mājās", JOptionPane.YES_NO_OPTION));
		
		if (pieg==JOptionPane.YES_OPTION){	
			do {
			 vards += (String)JOptionPane.showInputDialog("Vārds");
			}while(vards.length()<3);
			 do {
			 talrunis = (String)JOptionPane.showInputDialog("Tālrunis", "+371");
			 }while(talrunis.length()!=12);
			 do {
	  adrese = (String)JOptionPane.showInputDialog("Adrese");	
			 }while(adrese.length()<10 && !adrese.equals("iela"));
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
        JOptionPane.showMessageDialog(null, "Klients saglabāts");
    } catch (Exception e) { 
        JOptionPane.showMessageDialog(null, "Rādās kļūda ierakstot datus!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
    }
}	

	public static void izveidotPicu() {
		 String picasVeids = (String)JOptionPane.showInputDialog(null, "Kāda pica? - 6€(20cm)|8€(30cm)|12€(50cm)", "Picas veidi", JOptionPane.QUESTION_MESSAGE, null, picasVeidi, picasVeidi[0]);
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
	  	
		
	 		int kartupeli = JOptionPane.showConfirmDialog(null, "Būs kartupeli fri?  1,50€", "Piedevas", JOptionPane.YES_NO_OPTION); 		
		 	if(kartupeli==JOptionPane.YES_OPTION) pici.get(pici.size()-1).cena+=1.50; 
		 	
		 	int dzer = JOptionPane.showConfirmDialog(null, "Būs dzēriens?", "Piedevas", JOptionPane.YES_NO_OPTION);
		 	String str = "";
		 	if(dzer==JOptionPane.YES_OPTION) {
		 		JPanel panel = new JPanel();
		 		JCheckBox fanta = new JCheckBox("Fanta - 1,25€");
		 		JCheckBox cola = new JCheckBox("Coca-Cola - 1,35€");
		 		JCheckBox sprite = new JCheckBox("Sprite - 1,10€");
		 		JCheckBox kafija = new JCheckBox("Melnā kafija - 2,00€");
		 		
		 		ImageIcon icon = new ImageIcon("src/napitki.png");
		 		JLabel label = new JLabel(icon);
		 		
		 		panel.add(fanta);
		 		panel.add(cola);
		 		panel.add(sprite);
		 		panel.add(kafija);
		 		panel.add(label);
		 		
		 		Object[]opcijas = {"Izvelēties", panel};
		 		JOptionPane.showOptionDialog(null, "Kādi dzērieni?", "Dzerieni", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcijas, opcijas[1]);
		 		
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
		 		
		 	try {
		        FileWriter fw = new FileWriter("klientuDati.txt", true); 
		        fw.write(picas.izvadit());
		        if(kartupeli==JOptionPane.YES_OPTION) {
		        	fw.write("\nPiedevas: kartupēļi fri ");
		        }
		        if(dzer==JOptionPane.YES_OPTION) {	      
		        	fw.write("\nDzērieni: "+str);
		        }        
		        	fw.write("\nCena par picu ar piedevām: "+df.format(picas.cena)+"€\n");    
		        fw.close();
		        JOptionPane.showMessageDialog(null, "Pica pievienota!");
		    } catch (Exception e) { 
		        JOptionPane.showMessageDialog(null, "Rādās kļūda ierakstot datus!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);
		    }
	 		 	
	}
	public static void summa() { 
		double summa = 0.0;		
		for(int i=0; i<pici.size(); i++) {
			summa += pici.get(i).cena;
		}	
			try {
				  FileWriter fw = new FileWriter("klientuDati.txt", true);
				  if(klienti.get(klienti.size()-1).piegade==true) {
					  summa += 2.50;
					  fw.write("Piegāde - 2,50€\n"); }
				  fw.write("_____________________\nCena par pirkumu: "+df.format(summa)+"€");
				  fw.close();
				  JOptionPane.showMessageDialog(null, "Pasutijums noformets");
			}catch (Exception e) { 
		        JOptionPane.showMessageDialog(null, "Rādās kļūda ierakstot datus!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);		
	   }
			klienti.clear();
			pici.clear();
  }
	public static void izvadit() {
		 JTextArea textArea = new JTextArea();
		    JScrollPane scrollPane = new JScrollPane(textArea);
		    scrollPane.setPreferredSize(new Dimension(350, 400));
		 try (BufferedReader br = new BufferedReader(new FileReader("klientuDati.txt"))){
	            String izvade;
	            String dati = "";
	            while ((izvade = br.readLine()) != null) {            	
	            	dati += izvade+"\n";	            	            	
	            }    
	            textArea.append(dati);	 
	            JOptionPane.showMessageDialog(null, scrollPane, "Pasūtījumi", JOptionPane.INFORMATION_MESSAGE);
	            br.close();
	        } catch (Exception e) {
	        	JOptionPane.showMessageDialog(null, "Rādās kļūda apskatot datus!", "Brīdinājums", JOptionPane.WARNING_MESSAGE);        	
	    }
	}
	
	
	public static void main(String[] args) {
		String[] darbibas = {"izveidot pasūtījumu", "Apskatīt sūtījumus", "Aizvert programmu"};
		String[]darbibas1 = {"Pievienot picu", "Pasutit"};
		int izvele=0, izv=0;
		do {
			 izvele = JOptionPane.showOptionDialog(null, "Izvelies darbību", "Darbības", JOptionPane.DEFAULT_OPTION,
					JOptionPane.PLAIN_MESSAGE, null, darbibas, darbibas[0]);
							
			switch(izvele){
			case 0:
				izveidotKlientu();
				do {
					 izv = JOptionPane.showOptionDialog(null, "Izvelies darbību", "Darbības", JOptionPane.DEFAULT_OPTION,
						JOptionPane.PLAIN_MESSAGE, null, darbibas1, darbibas1[0]);
			
				switch(izv) {
				case 0:
					izveidotPicu();	
					break;
				case 1:
					summa();
					break;
				}
				}while(izv!=1);
				
				break;
			case 1:
				izvadit();
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Programma apturēta!");
			}
	}while(izvele !=2);
	}
}
