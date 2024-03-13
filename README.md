# AlistamentoApp
Pequeno aplicativo com GUI para verificar se o usuário pode ou não ser chamado para alistamento militar. O intuito deste aplicativo é ajudar um colega da universidade Celp-Ulbra/Palmas

## Atividade

Crie um formulário no qual o usuário possa informar a data de nascimento, em três campos diferentes dias (inteiro), mês (inteiro) e ano (inteiro); o sexo (feminino ou masculino); e o nome completo de uma pessoa.
O
fereça ao usuário uma das seguintes opções

* Verificar se deve se alistar – apresente uma frase informando se a pessoa deve se alistar no
serviço militar ou não. Só chame o método se a pessoa informar um sexo válido e apresente
uma mensagem de erro se o usuário informar um sexo inválido

* Verificar a categoria da pessoa – apresente uma mensagem com a categoria da pessoa. Só
chame o método se a pessoa informar valores válidos para meses (1 a 12), dias (1 a 31) e ano
(1923 a 2023).

### Importante

* Utilize os métodos apresentados abaixo
* A entrada pode ser feita usando o componente que desejar (JTextField, JComboBox,JRadioButton etc).

## Métodos para usar na aplicação

```Java
import java.time.LocalDate;
import java.time.Period;

public int calcularIdade(int diaNasc, int mesNasc, int anoNasc) {
  LocalDate dataAtual = LocalDate.now(); // Obtém a data atual
  LocalDate dataNasc = LocalDate.of(anoNasc, mesNasc, diaNasc); // Cria a data de Nasc
  Period periodo = Period.between(dataNasc, dataAtual); // Calc. diferença entre as datas
  return periodo.getYears(); // Retorna a idade
}
public boolean deveAlistar(int idade, String sexo) {
  if (sexo.equalsIgnoreCase("Masculino")) {
    return idade >= 18;
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

```
