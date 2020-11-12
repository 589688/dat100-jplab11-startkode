package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	Innlegg innleggtabell[];
	int nesteledig = 0;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		System.out.println("test");
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		int funnet = -1;
		
		for (int i=0;i<nesteledig && funnet == -1;i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				funnet = i;
			}
		}
		return funnet;
		}
	

	public boolean finnes(Innlegg innlegg) {
		boolean funnet = false;
		for (int i=0;i<nesteledig && !funnet;i++) {
			if (innleggtabell[i].erLik(innlegg)) 
				funnet = true;
		}	
		return funnet;
		}

	public boolean ledigPlass() {
		if (nesteledig < innleggtabell.length)
			return true;
		
		else 
			return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean lagtTil = false;
		
		if (!finnes(innlegg)) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			lagtTil = true;
		}
		return lagtTil;
	}
	
	public String toString() {
		
		String streng = nesteledig + "\n" ;
		
		for (int i=0; i<nesteledig; i++) {
		streng += innleggtabell[i].toString();
		}
		return streng;
	}

	// valgfrie oppgaver nedenfor

	
	public void utvid() {

		Innlegg[] nyTab = new Innlegg[innleggtabell.length * 2];
		
		for (int i=0; i<innleggtabell.length; i++) {
			nyTab[i] = innleggtabell[i];
		}
		
		innleggtabell = nyTab;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		
		boolean sattInn = false;
		if (nesteledig < innleggtabell.length && !finnes(innlegg)) {
			sattInn = leggTil(innlegg);
		}
		else if (nesteledig >= innleggtabell.length && !finnes(innlegg)) {
			utvid();
			sattInn = leggTil(innlegg);
		}
		
		return sattInn;
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		int pos = finnInnlegg(innlegg);
		
		if (pos >= 0) {
			nesteledig--;
			innleggtabell[pos] = innleggtabell[nesteledig];
			innleggtabell[nesteledig] = null;
			return true;
			
		}
		
		else
			return false;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}