package Modul1;
import java.util.Scanner;

public class PRAK102_2310817310005_MuhammadNurwahyudiAdhitama {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        int angka = scanner.nextInt();
	        
	        int count = 0;  
	        while (count < 11) {  
	            if (angka % 5 == 0) {  
	            	System.out.print(angka /5 -1);
	            }
	            else {
	            	System.out.print(angka);
	            }
	            
	           if (count< 10) {
	        	   System.out.print(", ");
	           }
	           
	            count++;  
	            angka++;
	        }

	        scanner.close();
	    }
	}
