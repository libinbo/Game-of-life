class Rutenett{
   public int antRader;
   public int antKolonner;
   public Celle [][] rutene;// lager 2d ruttenett
   public Rutenett(int rader,int kolonner){
      antRader=rader;
      antKolonner=kolonner;
      rutene=new Celle[rader][kolonner];
   }
   public void lagCelle(int rad,int kol){

      Celle celle2 = new Celle(); // lager et celle objekt 
      if (Math.random()<=0.333){ 
         rutene[rad][kol]=celle2;
         celle2.settLevende(); 
      } else {
      rutene[rad][kol]=celle2;
         celle2.settDoed();
      }
   }
      
   public void fyllMedTilfeldigeCeller(){
      for (int rad =0; rad <  this.antRader; rad ++) {
         for (int kol = 0; kol < this.antKolonner; kol ++){
            this.lagCelle(rad, kol);
         }
      }
   }
   public Celle hentCelle(int radEn, int kolEn) {
      if (0 <= radEn && radEn < this.antRader && 0 <= kolEn && kolEn < this.antKolonner) {
          return rutene[radEn][kolEn];
      }else{
         return null;
       } // her vil det kunne returneres null, hvis det er ulovlige rader og kolonner vi arbeider med
   }
   public void tegnRutenett(){
      for (int i=0; i < rutene.length; i++){
         System.out.println(" ");
         for (int x = 0; x < antKolonner; x++){
            System.out.print(rutene[i][x].hentStatusTegn());
         }
      } 
      System.out.println(); // lager melleomrom 


   }
   public void settNaboer(int rad, int kol) {
      Celle c1 = this.rutene[rad][kol];
      for (int i = rad - 1; i <= rad + 1; i++) {
          for (int x = kol - 1; x <= kol +1; x++) {
              if (i != rad || x != kol) {
                  if (hentCelle(i, x) != null) {
                      c1.leggTilNabo(hentCelle(i, x));
                  }
              }
          }
      }
  }
   public void kobleAlleCeller(){
     for(int i = 0; i < this.antRader; i++){  // går gjennom alle radene i antrader 
         for (int x = 0; x < this.antKolonner; x++) { // det samme, men i kolonner
        settNaboer(i,x);// setter i og x som parameter i naboer, denne metoden kobleralle celler 
      }
     }
   }
   public int antallLevende() {
      int lever = 0;// lager en telle for antall levende celler
      for (int i = 0; i < this.antRader; i++) { // intrer gjennom radene o
          for (int x = 0; x < this.antKolonner; x++) {  // dette samme med koloner 
              if (this.rutene[i][x].erLevende()) {// setter disse sammen og hvsi cellen er levende 
                  lever++; // øker antalllevne 
              }
          }
      }
      return lever; // returnen tellern 
  }
}

         

