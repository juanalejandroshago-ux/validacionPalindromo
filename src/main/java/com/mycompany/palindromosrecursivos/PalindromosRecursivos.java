package com.mycompany.palindromosrecursivos;

public class PalindromosRecursivos {

    // 1. Método Público (Wrapper)
    public static boolean esPalindromo(String palabra) {
        // Validación de entrada nula
        if (palabra == null) {
            return false;
        }

        // Normalización: minúsculas y eliminación de caracteres no alfabéticos
        String limpia = palabra.toLowerCase().replaceAll("[^a-z]", "");

        // Llamada al método auxiliar recursivo
        return esPalindromoAux(limpia, 0, limpia.length() - 1);
    }

    // 2. Método Privado (Recursivo Auxiliar)
    private static boolean esPalindromoAux(String palabra, int inicio, int fin) {
        // Caso Base 1: Éxito (índices se alcanzaron o cruzaron)
        if (inicio >= fin) {
            return true;
        }

        // Caso Base 2: Fallo (los caracteres no coinciden)
        if (palabra.charAt(inicio) != palabra.charAt(fin)) {
            return false;
        }

        // Paso Recursivo
        return esPalindromoAux(palabra, inicio + 1, fin - 1);
    }

    // 3. Casos de Prueba
    public static void main(String[] args) {
        System.out.println("--- Casos Normales ---");
        probar("reconocer");
        probar("radar");
        probar("computadora");

        System.out.println("\n--- Casos Borde y Especiales ---");
        probar("");           // Cadena vacía
        probar("a");          // Un solo carácter
        probar(null);         // Nulo
        probar("AricA");      // Mayúsculas mezcladas
    }

    private static void probar(String texto) {
        System.out.println("\"" + texto + "\" -> ¿Es palíndromo? " + esPalindromo(texto));
    }
}