public class GameOfLife {
    public static void main(String[] args) {
        Verden verden = new Verden(8, 12); // lager en verden med 8 rader og 12 kolonner 
        
        // printer ut generasjon 0 )
        verden.tegn(); 
        
        // lager en for løkke for de tre generasjonen 
        for (int i = 0; i < 3; i++) {
            verden.oppdatering(); // her blir blir verden med de tre generasjonen blir oppatert 
            verden.tegn(); // ut i terminalen blir de tre generasjonen tegnet  .
        }
    }
}






