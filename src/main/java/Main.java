import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Jogo começa com as peças no lugar
        // Looping
        //  Jogador um faz o movimento
        //  Jogador dois faz o movimento
        // Jogo termina pois peças acabaram
        
        Scanner sc = new Scanner(System.in);

        System.out.println("\u001B[31m" + "texto" + "\u001B[0m");
//        String viadaoBonito = sc.nextLine();

        clearConsole();
        
    
        
    }
    
    public static void clearConsole() {
        try {
            // pega o nome do OS
            if (System.getProperty("os.name").contains("Windows")) {
                // caso Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                return;
            }
            // caso mac
            new ProcessBuilder("clear").inheritIO().start().waitFor();
            
        } catch (Exception e) {
            // não consegue né
            System.out.println("Não consegue né");
        }
    }
}
