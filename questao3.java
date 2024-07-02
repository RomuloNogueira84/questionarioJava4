package questionarioaula4;
import java.util.ArrayList;
import java.util.List;

class InvalidTypeConversionException extends RuntimeException {
    public InvalidTypeConversionException(String message) {
        super(message);
    }
}

public class questao3 {
    public static List<Integer> converterParaInteiros(List<String> listaStrings) {
        List<Integer> listaInteiros = new ArrayList<>();
        for (String str : listaStrings) {
            str = str.trim(); // Remove espaços em branco no início e no final
            try {
                int inteiro = Integer.parseInt(str);
                listaInteiros.add(inteiro);
            } catch (NumberFormatException e) {
                System.err.println("Não foi possível converter a string '" + str + "' para um inteiro: " + e.getMessage());
                // Lança a exceção personalizada
                throw new InvalidTypeConversionException("Erro na conversão da string: " + str);
            }
        }
        return listaInteiros;
    }

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add(" 12 ");
        strings.add(" 40");
        strings.add("43");
        strings.add(" 18 ");
        strings.add(" 27");
        strings.add("15");
        strings.add(" 50 ");

        try {
            List<Integer> inteiros = converterParaInteiros(strings);
            System.out.println("Lista de inteiros: " + inteiros);
        } catch (InvalidTypeConversionException e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}

