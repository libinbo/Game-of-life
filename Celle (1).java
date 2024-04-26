class Celle { //lager klasse cellen
    public boolean levende; // setter status til å være false, fordi den er død
    public Celle [] naboer;  // naboer arrayen 
    public int antLevendeNaboer;
    public int antNaboer; 

    public Celle(){  // 
        this.levende= false; // som nevt blir instanse variablen død til å starte med 
        naboer= new Celle[8]; // arrayen består av 8 elemneter 
        antLevendeNaboer=0; // celeen har null naboer, og ingen levende naboer når den dannes 
        antNaboer=0;
       
    }
    public void settDoed(){ 
        levende= false;
    }
    public void settLevende(){; // setter status til å være true når den er levende
        levende=true;
    } 
    public boolean erLevende(){ 
            if (levende== true){
                 return true; 
            }
            else {
                return false;
            } 

    }
    public char hentStatusTegn(){
        if (levende == true) { // hvis cellen er levende, kaller metoden er levende og den får "o"
            return'O';
        } else{
            return '.'; // hvis den har statusen død får den "."
        }
    }  
    public void leggTilNabo(Celle nabo){  // legger en nabo celle 
        this.naboer[this.antNaboer]=nabo;
        this.antNaboer +=1; // øker antallnaboer 
    } 
    public void tellLevendeNaboer() { // denne metoden gir 0 antall naboer, jeg har prøvd og prøv redigere koden min, men jeg får uansett 0.
        antLevendeNaboer = 0;
        for (int i = 0; i < naboer.length; i++) {
            if (naboer[i] != null) {
                if (naboer[i].erLevende()) {
                    antLevendeNaboer += 1;
                }
            }
        }
    }
    
    public void oppdaterStatus() { // endrer statuses til cellen 

    if (this.antLevendeNaboer < 2) { // cell dør pga underpopulasjon
        settDoed();
    } else if (this.antLevendeNaboer == 2) { // status er den samme

    } else if (this.antLevendeNaboer > 3) { // dør pga av overppulasjon
        settDoed();
    } else if (this.antLevendeNaboer == 3) { // cellen blir levende igjen 
        settLevende();
    }
}
}







    








