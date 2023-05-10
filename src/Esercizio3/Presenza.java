package Esercizio3;

public class Presenza {
    private String nomeDipendente;
    private int giorniPresenza;

    public Presenza(String nomeDipendente, int giorniPresenza) {
        this.nomeDipendente = nomeDipendente;
        this.giorniPresenza = giorniPresenza;
    }


    public String getNomeDipendente() {
        return nomeDipendente;
    }

    public void setNomeDipendente(String nomeDipendente) {
        this.nomeDipendente = nomeDipendente;
    }

    public int getGiorniPresenza() {
        return giorniPresenza;
    }

    public void setGiorniPresenza(int giorniPresenza) {
        this.giorniPresenza = giorniPresenza;
    }
}
