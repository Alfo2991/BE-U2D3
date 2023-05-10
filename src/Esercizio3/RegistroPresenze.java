package Esercizio3;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RegistroPresenze {
    private List<Presenza> elencoPresenze;

    public RegistroPresenze() {
        elencoPresenze = new ArrayList<>();
    }

    public void aggiungiPresenza(Presenza presenza) {
        elencoPresenze.add(presenza);
    }

    public void salvaPresenzeSuDisco(String nomeFile) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Presenza presenza : elencoPresenze) {
            stringBuilder.append(presenza.getNomeDipendente())
                    .append("@")
                    .append(presenza.getGiorniPresenza())
                    .append("#");
        }

        try {
            FileUtils.writeStringToFile(new File(nomeFile), stringBuilder.toString(), "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Presenza> leggiPresenzeDaDisco(String nomeFile) {
        List<Presenza> presenze = new ArrayList<>();
        try {
            String contenutoFile = FileUtils.readFileToString(new File(nomeFile), "UTF-8");
            String[] presenzeString = contenutoFile.split("#");
            for (String presenzaString : presenzeString) {
                String[] presenzaSplit = presenzaString.split("@");
                if (presenzaSplit.length == 2) {
                    String nomeDipendente = presenzaSplit[0];
                    int giorniPresenza = Integer.parseInt(presenzaSplit[1]);
                    Presenza presenza = new Presenza(nomeDipendente, giorniPresenza);
                    presenze.add(presenza);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return presenze;
    }
}
