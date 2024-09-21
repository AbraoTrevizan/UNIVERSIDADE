import java.util.Scanner;

public class Aluno {
    private String nome;
    private String ra;
    private double[] notas;
    private double frequencia;
    private boolean ead;

    // Faz as classes nome, ra, notas, frequencias
    public Aluno(String nome, String ra, double[] notas, double frequencia) {
        this.nome = nome;
        this.ra = ra;
        this.notas = notas;
        this.frequencia = frequencia;
        this.ead = false;
    }

    // fazendo a diciplina ead
    public Aluno(String nome, String ra, double[] notas) {
        this.nome = nome;
        this.ra = ra;
        this.notas = notas;
        this.ead = true;
    }

    // Vai calcular a nota final
    public double calcularNotaFinal() {
        double notaFinal = 0.0;
        int numNotas = notas.length;

        if (numNotas == 1 || numNotas == 2) {
            // Vai estar fazendo a media aritmetica
            for (double nota : notas) {
                notaFinal += nota;
            }
            notaFinal /= numNotas;
        } else if (numNotas == 3) {
            // Vai estar fazendo a media ponderada
            notaFinal = (notas[0] + 2 * notas[1] + 4 * notas[2]) / 7;
        } else if (numNotas == 4) {
            // Vai estar fazendo o calculo para saber se foi aprovado ou nao
            notaFinal = (notas[0] * 0.15) + (notas[1] * 0.30) + (notas[2] * 0.10) + (notas[3] * 0.45);
        }

        return notaFinal;
    }

    // Vai verificar se o aluno foi aprovado ou reprovado
    public String verificarSituacao() {
        double notaFinal = calcularNotaFinal();
        if (ead) {
            return notaFinal >= 5 ? "Aprovado" : "Reprovado";
        } else {
            return (notaFinal >= 5 && frequencia >= 75) ? "Aprovado" : "Reprovado";
        }
    }

    // Vai estar mostrando ao usuario os resultados das perguntas
    public void imprimirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("RA: " + ra);
        System.out.println("Nota Final: " + calcularNotaFinal());
        System.out.println("Situação: " + verificarSituacao());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Vai estar peguntando ao usuario o nome do aluno
        System.out.println("Digite o nome do aluno:");
        String nome = scanner.nextLine();
        // Vai estar peguntando ao usuario o Ra do aluno
        System.out.println("Digite o RA do aluno:");
        String ra = scanner.nextLine();
        // Vai estar peguntando ao usuario o numero de notas
        System.out.println("Digite o número de notas:");
        int numNotas = scanner.nextInt();
        double[] notas = new double[numNotas];

        for (int i = 0; i < numNotas; i++) {
            System.out.println("Digite a nota " + (i + 1) + ":");
            notas[i] = scanner.nextDouble();
        }

        System.out.println("O aluno está em uma disciplina EAD? (true/false):");
        boolean ead = scanner.nextBoolean();

        Aluno aluno;
        if (ead) {
            aluno = new Aluno(nome, ra, notas);
        } else {
            System.out.println("Digite a frequência do aluno:");
            double frequencia = scanner.nextDouble();
            aluno = new Aluno(nome, ra, notas, frequencia);
        }

        // Vai estar imprimindo as informaçoes do aluno que foram das a cima
        aluno.imprimirInformacoes();

        scanner.close();
    }
}
