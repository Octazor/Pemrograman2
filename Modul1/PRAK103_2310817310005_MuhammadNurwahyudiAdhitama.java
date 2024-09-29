package Modul1;
import java.util.Scanner;

public class PRAK103_2310817310005_MuhammadNurwahyudiAdhitama {
	public static void main(String[] args) {
		
	Scanner scanner = new Scanner(System.in);
	  
	int jumlah = scanner.nextInt();
	int angka = scanner.nextInt();
	
	int count = 0;
	do {
		if (angka % 2 != 0) {
			System.out.print(angka);
			count++;
			if (count < jumlah) {
		     	  System.out.print(", ");	
			}    	   
		}
		angka++;
     	   
	}while (count < jumlah);
	
	scanner.close();
	}
}
