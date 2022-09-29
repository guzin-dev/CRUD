import javax.swing.*;
import java.util.*;

public class Main {

    static ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
    static Scanner leitor = new Scanner(System.in);
    static int id = 0;

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        int opcao = Integer.parseInt(JOptionPane.showInputDialog("1- Criar pessoa\n2- Ver pessoas\n3- Editar pessoa\n4- Deletar pessoas\n5- Fechar programa"));
        switch (opcao) {
            case 1:
                cPessoa();
                break;
            case 2:
                vPessoas();
                break;
            case 3:
                ePessoa();
                break;
            case 4:
                //dPessoa();
                break;
            case 5:
                int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja fechar o programa?", "Atenção", JOptionPane.YES_NO_OPTION);
                if (resposta == JOptionPane.YES_OPTION) {
                    break;
                } else {
                    menu();
                }
                break;
            default:
                JOptionPane.showMessageDialog(null, "Insira uma opção válida", "Erro", JOptionPane.ERROR_MESSAGE);
                menu();
        }
    }

    public static void cPessoa(){
        id++;
        String nome = JOptionPane.showInputDialog("Insira o nome da pessoa");
        int idade = Integer.parseInt(JOptionPane.showInputDialog("Insira a idade da pessoa"));
        Pessoa pessoa = new Pessoa(nome, idade, id);
        listaDePessoas.add(pessoa);
        menu();
    }

    public static void vPessoas(){
        String pessoas = "";
        for (int i = 0; i < listaDePessoas.size(); i++) {
            pessoas += "Nome: " + listaDePessoas.get(i).getNome() + ", idade: " + listaDePessoas.get(i).getIdade() + ", id: " + listaDePessoas.get(i).getId() + "\n";
        }
        if(listaDePessoas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não existem pessoas!");
        }else {
            JOptionPane.showMessageDialog(null, pessoas);
        }
        menu();
    }

    public static void ePessoa(){
        String pessoas = "";
        boolean encontrou = false;
        if(listaDePessoas.isEmpty()){
            JOptionPane.showMessageDialog(null, "Não existem pessoas!");
        }else {
            int idParaPesquisa = Integer.parseInt(JOptionPane.showInputDialog("Insira o id da pessoa que você deseja editar"));
            for (int i = 0; i < listaDePessoas.size(); i++) {
                if(listaDePessoas.get(i).getId() == idParaPesquisa){
                    String novoNome = JOptionPane.showInputDialog("Nome atual da pessoa: " + listaDePessoas.get(i).getNome() + "\nInsira o novo nome para este usuário");
                    int novaIdade = Integer.parseInt(JOptionPane.showInputDialog("Idade atual da pessoa: " + listaDePessoas.get(i).getIdade() + "\nInsira a nova idade para este usuário"));
                    listaDePessoas.get(i).setNome(novoNome);
                    listaDePessoas.get(i).setIdade(novaIdade);
                    JOptionPane.showMessageDialog(null, "Pessoa editada com sucesso!");
                    encontrou = true;
                }
            }
        }
        if(encontrou == false){
            JOptionPane.showMessageDialog(null, "Nenhuma pessoa encontrada com esse id");
        }
        menu();
    }
}