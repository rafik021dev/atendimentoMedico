
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Fila fila = new Fila();
    private static final List<Medico> medicos = new ArrayList<>();
    private static final Historico historico = new Historico(fila);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) {
        inicializarSistema();
        exibirMenuPrincipal();
    }

    private static void inicializarSistema() {
        System.out.println("╔═════════════════════════════════╗");
        System.out.println("║  SISTEMA DE ATENDIMENTO MÉDICO  ║");
        System.out.println("╚═════════════════════════════════╝");
        System.out.println("\nInicializando sistema...\n");

        /*
         * Criação de médicos
         */
        medicos.add(new Medico(12345, "Dr. Carlos Silva", 21));
        medicos.add(new Medico(23456, "Dra. Ana Santos", 37));
        medicos.add(new Medico(34567, "Dr. João Oliveira", 32));
        medicos.add(new Medico(45678, "Dra. Maria Costa", 46));
        System.out.println(medicos.size() + " médicos cadastrados no sistema.");

        /*
         * Geração de pacientes utilizando a classe GeraPaciente
         */
        List<Paciente> pacientesGerados = GeraPaciente.gerarListaPacientes(20);
        for (Paciente paciente : pacientesGerados) {
            fila.addPaciente(paciente);
        }
        System.out.println(pacientesGerados.size() + " pacientes adicionados à fila de atendimento.");
    }

    private static void exibirMenuPrincipal() {
        while (true) {
            limparTela();
            System.out.println("╔════════════════════════════════════════════════════════╗");
            System.out.println("║             MENU PRINCIPAL - ATENDIMENTO               ║");
            System.out.println("╠════════════════════════════════════════════════════════╣");
            System.out.println("║  1. Inserir novo paciente na fila                      ║");
            System.out.println("║  2. Visualizar fila de atendimento                     ║");
            System.out.println("║  3. Realizar atendimento                               ║");
            System.out.println("║  4. Visualizar histórico de atendimentos               ║");
            System.out.println("║  0. Sair do sistema                                    ║");
            System.out.println("╚════════════════════════════════════════════════════════╝");
            System.out.print("\nEscolha uma opção: ");

            String opcaoAtendimento = scanner.nextLine().trim();
            switch (opcaoAtendimento) {
                case "1":
                    inserirNovoPaciente();
                    break;
                case "2":
                    visualizarFila();
                    break;
                case "3":
                    realizarAtendimento();
                    break;
                case "4":
                    visualizarHistorico();
                    break;
                case "0":
                    System.out.println("\nEncerrando sistema...");
                    System.out.println("Sistema finalizado com sucesso!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }

        }
    }

    private static void inserirNovoPaciente() {
        limparTela();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║           CADASTRO DE NOVO PACIENTE - TRIAGEM          ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        try {
            System.out.print("Nome completo: ");
            String nome = scanner.nextLine().trim();

            System.out.print("Idade: ");
            int idade = Integer.parseInt(scanner.nextLine().trim());

            System.out.println("\n--- TRIAGEM ---");
            System.out.println("Responda SIM (S) ou NÃO (N) para cada pergunta:\n");

            System.out.print("1. Dor intensa ou desconforto severo? (S/N): ");
            boolean p1 = scanner.nextLine().trim().equalsIgnoreCase("S");

            System.out.print("2. Sinais vitais muito alterados (pressão, febre alta, taquicardia)? (S/N): ");
            boolean p2 = scanner.nextLine().trim().equalsIgnoreCase("S");

            System.out.print("3. Perda de consciência/convulsão/confusão mental? (S/N): ");
            boolean p3 = scanner.nextLine().trim().equalsIgnoreCase("S");

            System.out.print("4. Sangramento ativo/dificuldade respiratória/trauma grave? (S/N): ");
            boolean p4 = scanner.nextLine().trim().equalsIgnoreCase("S");

            String classificacaoRisco;
            if (p3 || p4) classificacaoRisco = "vermelho"; 
            else if (p1 || p2) classificacaoRisco = "amarelo"; 
            else if (p1 || p2 || p3 || p4) classificacaoRisco = "verde"; 
            else classificacaoRisco = "azul";

            Paciente novoPaciente = new Paciente(nome, idade, classificacaoRisco);
            fila.addPaciente(novoPaciente);

            System.out.println("\nPaciente cadastrado com sucesso!");
            System.out.println("Classificação atribuída: " + classificacaoRisco.toUpperCase());
        } catch (Exception e) {
            System.out.println("\nDados inválidos! Cadastro cancelado.");
        }

        pausa();
    }

    private static void visualizarFila() {
        limparTela();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║              FILA DE ATENDIMENTO ATUAL                 ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        String lista = fila.listaCompleta();
        if (lista == null || !lista.contains("Lista de Espera:")) {
            System.out.println("A fila está vazia. Não há pacientes aguardando atendimento.");
        } else {
            System.out.println(lista);
        }
        pausa();
    }

    /*
     * Ao realizar o atendimento, o paciente é automaticamente removido da fila
     */
    private static void realizarAtendimento() {
        limparTela();
        System.out.println("╔════════════════════════════════════════════════════════╗");
        System.out.println("║              REALIZAR ATENDIMENTO MÉDICO               ║");
        System.out.println("╚════════════════════════════════════════════════════════╝\n");

        Paciente paciente;
        try {
            paciente = fila.removerPaciente();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Não há pacientes na fila para atendimento.");
            pausa();
            return;
        }

        System.out.println("--- PACIENTE PARA ATENDIMENTO ---");
        System.out.println("Nome: " + paciente.getNome());
        System.out.println("Idade: " + paciente.getIdade());
        System.out.println("Prioridade: " + paciente.getCorPrioridade().toUpperCase());
        System.out.println("Chegada: " + paciente.getHorarioChegada().format(formatter));

        System.out.println("\n--- MÉDICOS DISPONÍVEIS ---");
        for (int i = 0; i < medicos.size(); i++) {
            Medico medico = medicos.get(i);
            System.out.println((i + 1) + ". " + medico.getNome() + " (CRM: " + medico.getCrm() + ")");
        }

        System.out.print("\nEscolha o médico responsável pelo atendimento (0 para cancelar): ");
        try {
            int opcao = Integer.parseInt(scanner.nextLine().trim());
            if (opcao == 0) {
                System.out.println("Atendimento cancelado.");
                fila.addPaciente(paciente);
                return;
            }
            if (opcao < 1 || opcao > medicos.size()) {
                System.out.println("Opção inválida!");
                fila.addPaciente(paciente);
                return;
            }

            Medico medicoSelecionado = medicos.get(opcao - 1);
            System.out.print("Descrição do atendimento: ");
            String descricao = scanner.nextLine().trim();
            System.out.print("Tempo de atendimento em minutos: ");
            int tempo = Integer.parseInt(scanner.nextLine().trim());

            historico.registrarAtendimento(paciente, medicoSelecionado, descricao, tempo);
            System.out.println("\nAtendimento registrado com sucesso!");
            System.out.println("Paciente: " + paciente.getNome());
            System.out.println("Médico: " + medicoSelecionado.getNome());
            System.out.println("Horário: " + LocalDateTime.now().format(formatter));

        } catch (Exception e) {
            System.out.println("\nEntrada inválida! Atendimento cancelado e paciente retornado à fila.");
            fila.addPaciente(paciente);
        }

        pausa();
    }

    private static void visualizarHistorico() {
        limparTela();
        System.out.println("╔══════════════════════════════════════════╗");
        System.out.println("║        HISTÓRICO DE ATENDIMENTOS         ║");
        System.out.println("╚══════════════════════════════════════════╝\n");

        String historicoStr = historico.mostrarHistorico();
        System.out.println(historicoStr);

        pausa();
    }

    /*
     * Métodos para melhorar a usabilidade do programa
     */

    private static void limparTela() {
        System.out.println();
    }

    private static void pausa() {
        System.out.println("\nPressione ENTER para continuar...");
        try {
            System.in.read();
        } catch (Exception e) {

        }
    }

}
