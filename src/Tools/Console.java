package Tools;

public class Console {
    
    /**
     * Clear the terminal on windows and mac.
     * In case doesn't work calls clearANSI().
     */
    public static void clearConsole() {
        if (System.console() != null) {
            try {
                ProcessBuilder pb;
                // gets the OS name
                if (System.getProperty("os.name").contains("Windows")) {
                    // Windows
                    pb = new ProcessBuilder("cmd", "/c", "cls");
                } else {
                    // Mac
                    pb = new ProcessBuilder("clear");
                }
                pb.inheritIO().start().waitFor();
//                System.out.println("Clear as console");
                return;
            } catch (Exception e) {
                // Not standar console
                System.out.println("Not standar console");
                clearANSI();
            }
        }
    }
    
    /**
     * Clears the console in case it supports ANSI.
     * In case not supported, fallbacks to clearFallback().
     */
    private static void clearANSI() {
        try {
            System.out.print("\033[H\033[2J");
            System.out.flush();
//            System.out.println("Clear as ANSI");
            return;
        } catch (Exception e) {
            // fallback
            System.out.println("fallback");
            clearFallback();
        }
    }
    
    /**
     * Prints 50 lines to ""clear"" the console/terminal.
     */
    private static void clearFallback() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}
