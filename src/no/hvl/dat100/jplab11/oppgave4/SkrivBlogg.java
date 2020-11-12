package no.hvl.dat100.jplab11.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave3.*;

public class SkrivBlogg {

	
	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

		boolean written = true;
		
		try {
			//åpne ny fil
			//skrive til filen så lenge det er flere objekter i tabellen
			//bruke blogg sin toString, 
			//skrive til blogg.dat¨
			String fn = mappe + filnavn;
			
			PrintWriter skriver = new PrintWriter(fn);
			
			skriver.println(samling.toString());
			
			skriver.print("Alle innlegg er skrevet");
			
			skriver.close();
		}
			 
		catch (FileNotFoundException e) {
			System.out.println("En feil oppstod ved skriving til fil");
			written = false;
		}
			
		return written;		
	}
	}
  	
		
	
	
