package Esercizio3;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        RegistroPresenze registroPresenze = new RegistroPresenze();

        registroPresenze.aggiungiPresenza(new Presenza("Mario Rossi", 5));
        registroPresenze.aggiungiPresenza(new Presenza("Giorgio Bianchi", 7));
        registroPresenze.aggiungiPresenza(new Presenza("Gianni Verdi", 7));

        registroPresenze.salvaPresenzeSuDisco("presenze.txt");

        List<Presenza> presenze = registroPresenze.leggiPresenzeDaDisco("presenze.txt");

        for (Presenza presenza : presenze) {
            System.out.println("Nome dipendente: " + presenza.getNomeDipendente());
            System.out.println("Giorni presenza: " + presenza.getGiorniPresenza());
            System.out.println();
        }
    }
}
