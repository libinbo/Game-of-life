class Verden {
    private int antRader;// setter inn instans varibalene som verden han 
    private int antKolonner;
    public int genNr = 0;
    private Rutenett rutenett; 

    public Verden(int rader, int kolonner) { // lager verden konstruksjonen 
        this.antRader = rader;
        this.antKolonner = kolonner;
        this.rutenett = new Rutenett(antRader, antKolonner);
        this.rutenett.fyllMedTilfeldigeCeller();
        this.rutenett.kobleAlleCeller();
    }

    public void tegn() { // lager metoden tegn 
        System.out.println(); 
        this.rutenett.tegnRutenett(); // insnasvaribelen rutenett kaller på tegnRutenett
        System.out.println( "Generasjon:  " + this.genNr); // printer ut generasjons nr 
        System.out.println( "Antall: "  + this.rutenett.antallLevende()); //  printer ut antalle celler  som er lever
    }

    public void oppdatering() {
        for (int i = 0; i < antRader; i++) {
            for (int x = 0; x < antKolonner; x++) {
                rutenett.rutene[i][x].tellLevendeNaboer();

            }

        }

        for (int g = 0; g < antRader; g++) {
            for (int f = 0; f < antKolonner; f++) {
                        rutenett.rutene[g][f].oppdaterStatus();
                    
            }
        }
       
        this.genNr ++;
    }
}