package Modul1;
import java.util.Scanner;

public class PRAK104_2310817310005_MuhammadNurwahyudiAdhitama {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	String Abu[] = new String[3];
	String Bagas[] = new String[3];
	
	System.out.print("Tangan Abu: ");
	for(int i = 0; i < 3; ++i) {
		String suit = scanner.next();
		Abu[i] = suit;
	}
	
	System.out.print("Tangan Bagas: ");
	for(int i = 0; i < 3; ++i) {
		String suit = scanner.next();
		Bagas[i] = suit;
	}
	
	int skorA = 0;
	int skorB = 0;
	for(int i = 0; i < 3; ++i) {
		if(Abu[i].equals(Bagas[i])) {
			skorA++;
			skorB++;
		} else if((Abu[i].equals("B") && Bagas[i].equals("G"))
			|| (Abu[i].equals("G") && Bagas[i].equals("K"))
			|| (Abu[i].equals("K") && Bagas[i].equals("B"))) {
			skorA++;
		}else {
			skorB++;
		}
	}
	if(skorA > skorB) {
		System.out.print("Abu");
	}else if (skorB > skorA) {
		System.out.print("Bagas");
	}else {
		System.out.print("Seri");
	}
	scanner.close();
 }
}