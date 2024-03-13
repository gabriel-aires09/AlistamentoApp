package calculadora;

import java.time.LocalDate;
import java.time.Period;

public class calculaIdade {
    public int calcularIdade(int diaNasc, int mesNasc, int anoNasc) {
        LocalDate dataAtual = LocalDate.now(); // Obtém a data atual
        LocalDate dataNasc = LocalDate.of(anoNasc, mesNasc, diaNasc); // Cria a data de Nasc
        Period periodo = Period.between(dataNasc, dataAtual); // Calc. diferença entre as datas
        return periodo.getYears(); // Retorna a idade
    }
    
    public boolean deveAlistar(int idade, String sexo) {
        if (sexo.equalsIgnoreCase("Masculino") && idade >= 18) {
            return true;
        } else {
            return false;
        }
    }
    public String informarCategoria(int idade) {
        if (idade < 10) {
        return "Criança";
        } else if (idade >= 10 && idade <= 14) {
        return "Pré-adolescente";
        } else if (idade >= 15 && idade <= 19) {
        return "Adolescente";
        } else if (idade >= 20 && idade <= 24) {
        return "Adulto Jovem";
        } else if (idade >= 25 && idade <= 64) {
        return "Adulto";
        } else {
        return "Idoso";
        }
    }
}      
        
