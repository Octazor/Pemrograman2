package Modul1;
import java.util.Scanner;

public class PRAK105_2310817310005_MuhammadNurwahyudiAdhitama {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Masukkan jari-jari: ");
		double JAR = scanner.nextDouble();
		System.out.print("Masukkan tinggi: ");
		double height = scanner.nextDouble();
		
		double phi = 3.14;
		
		double volume = phi * JAR * JAR * height;
		
		System.out.println("Volume tabung dengan jari-jari " + JAR + " cm dan tinggi " + height + " cm adalah " + volume + " m3");
		scanner.close();
	}
}
