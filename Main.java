import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static ArrayList<Medico> medicos = new ArrayList<>();
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static ArrayList<Consulta> consultas = new ArrayList<>();

    public static void main(String[] args) throws ParseException {

        // Criação de dois pacientes
        Paciente paciente1 = new Paciente("João", "Masculino", "910000000", "Arcozelo", "01/01/1990");
        Paciente paciente2 = new Paciente("Anabela", "Feminino", "912772266", "Serzedo", "02/02/1995");

        // Adiciona os pacientes à lista de pacientes
        pacientes.add(paciente1);
        pacientes.add(paciente2);

        // Criação de dois médicos
        Medico medico1 = new Medico("Dr. Pedro", "Masculino", "912222222", "Pediatria");
        Medico medico2 = new Medico("Dra. Joana", "Feminino", "913333333", "Cirurgia");

        // Adiciona os médicos à lista de médicos
        medicos.add(medico1);
        medicos.add(medico2);

        // Criação de duas consultas para cada paciente com cada médico
        Consulta consulta1 = new Consulta(paciente1, medico1, new Date());
        Consulta consulta2 = new Consulta(paciente2, medico2, new Date());

        // Adicionando as consultas à lista de consultas
        consultas.add(consulta1);
        consultas.add(consulta2);

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("----- Sistema de Gestão de Consultório Médico -----");
            System.out.println("1. Inserir Médico");
            System.out.println("2. Inserir Paciente");
            System.out.println("3. Agendar Consulta");
            System.out.println("4. Cancelar Consulta");
            System.out.println("5. Listar Médicos");
            System.out.println("6. Listar Pacientes");
            System.out.println("7. Listar Consultas");
            System.out.println("8. Eliminar Paciente ou Médico");
            System.out.println("9. Pesquisar Paciente ou Médico por Nome");
            System.out.println("10. Pesquisar Paciente ou Médico por Numero de Telemovel");
            System.out.println("11. Pesquisar Médico por Especialidade");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    inserirMedico(scanner);
                    break;
                case 2:
                    inserirPaciente(scanner);
                    break;
                case 3:
                    agendarConsulta(scanner);
                    break;
                case 4:
                    cancelarConsulta(scanner);
                    break;
                case 5:
                    listarMedicos();
                    break;
                case 6:
                    listarPacientes();
                    break;
                case 7:
                    listarConsultas();
                    break;
                case 8:
                    eliminarPacienteOuMedico(scanner);
                    break;
                case 9:
                    pesquisarPorNome(scanner);
                    break;
                case 10:
                    pesquisarPorTelemovel(scanner);
                    break;
                case 11:
                    pesquisarMedicoPorEspecialidade(scanner);
                    break;
                case 0:
                    System.out.println("A sair...");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }

            if (opcao != 0) {
                System.out.println("Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void inserirMedico(Scanner scanner) {
        System.out.print("Nome do médico: ");
        String nome = scanner.nextLine();

        String genero = escolherGenero(scanner);

        boolean telemovelValido = false;
        String telemovel = "";
        do {
            System.out.print("Número de telemóvel do médico (9 dígitos): ");
            telemovel = scanner.nextLine();
            if (telemovel.length() != 9) {
                System.out.println("Erro: O número de telemóvel deve ter exatamente 9 dígitos.");
            } else {
                telemovelValido = true;
            }
        } while (!telemovelValido);

        String especialidade = escolherEspecialidade(scanner);

        Pessoa medico = new Medico(nome, genero, telemovel, especialidade);
        medicos.add((Medico) medico);
        System.out.println("Médico inserido com sucesso!");
    }

    private static String escolherEspecialidade(Scanner scanner) {
        System.out.println("Escolha a especialidade:");
        System.out.println("1. Pediatria");
        System.out.println("2. Cirurgia");
        System.out.println("3. Psiquiatria");
        System.out.println("4. Ginecologia");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return "Pediatria";
            case 2:
                return "Cirurgia";
            case 3:
                return "Psiquiatria";
            case 4:
                return "Ginecologia";
            default:
                System.out.println("Opção inválida, será definido como Geral.");
                return "Geral";
        }
    }

    private static String escolherGenero(Scanner scanner) {
        while (true) {
            System.out.println("Escolha o genero do paciente:");
            System.out.println("1. Masculino");
            System.out.println("2. Feminino");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    return "Masculino";
                case 2:
                    return "Feminino";
                default:
                    System.out.println("Opção inválida, por favor tente novamente.");
            }
        }
    }

    private static void inserirPaciente(Scanner scanner) {
        String nome;
        String telemovel;
        String morada;
        String dataNascimentoStr;

        System.out.print("Nome do paciente: ");
        nome = scanner.nextLine();
        String genero = escolherGenero(scanner);

        boolean telemovelValido = false;
        do {
            System.out.print("Numero de telemovel do paciente: ");
            telemovel = scanner.nextLine();
            if (telemovel.length() != 9) {
                System.out.println("Erro: O número de telemovel deve ter exatamente 9 dígitos.");
            } else {
                telemovelValido = true;
            }
        } while (!telemovelValido);
        System.out.print("Morada do paciente: ");
        morada = scanner.nextLine();

        boolean dataNascimentoValida = false;
        do {
            System.out.print("Data de Nascimento do paciente (dd/MM/yyyy): ");
            dataNascimentoStr = scanner.nextLine();
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Date dataNascimento = sdf.parse(dataNascimentoStr);
                Date dataAtual = new Date();

                if (dataNascimento.after(dataAtual)) {
                    System.out.println("Erro: A data de nascimento colocada ultrapassa a data atual.");
                } else {
                    dataNascimentoValida = true;
                }
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Certifique-se de usar o formato dd/MM/yyyy.");
            }
        } while (!dataNascimentoValida);

        try {
            Pessoa paciente = new Paciente(nome, genero, telemovel, morada, dataNascimentoStr);
            pacientes.add((Paciente) paciente);
            System.out.println("Paciente inserido com sucesso!");
        } catch (ParseException e) {
            System.out.println("Erro ao inserir paciente. Verifique os dados e tente novamente.");
        }
    }

    private static void agendarConsulta(Scanner scanner) {
        System.out.println("Escolha o paciente:");
        Paciente paciente = escolherPaciente(scanner);

        if (paciente == null) {
            System.out.println("Agendamento cancelado.");
            return;
        }

        System.out.println("Escolha o médico:");
        Medico medico = escolherMedico(scanner);

        if (medico == null) {
            System.out.println("Agendamento cancelado.");
            return;
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date dataConsulta = null;
        boolean dataValida = false;
        do {
            System.out.print("Data da consulta (dd/MM/yyyy HH:mm): ");
            String dataConsultaStr = scanner.nextLine();
            try {
                dataConsulta = sdf.parse(dataConsultaStr);
                Date dataAtual = new Date();
                if (dataConsulta.before(dataAtual)) {
                    System.out.println("Erro: A data da consulta deve ser posterior à data e hora atual.");
                } else {
                    dataValida = true;
                }
            } catch (ParseException e) {
                System.out.println("Formato de data inválido. Certifique-se de usar o formato dia/mes/ano hora:minutos.");
            }
        } while (!dataValida);

        Consulta consulta = new Consulta(paciente, medico, dataConsulta);
        consultas.add(consulta);
        System.out.println("Consulta agendada com sucesso!");
    }

    private static Paciente escolherPaciente(Scanner scanner) {
        System.out.println("1. Escolher paciente pelo menu");
        System.out.println("2. Procurar paciente pelo número de telemóvel");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return escolherPacientePeloMenu(scanner);
            case 2:
                return procurarPacientePeloTelemovel(scanner);
            default:
                System.out.println("Opção inválida.");
                return null;
        }
    }

    private static Paciente escolherPacientePeloMenu(Scanner scanner) {
        listarPacientes();
        if (pacientes.isEmpty()) {
            return null;
        }
        System.out.print("Escolha o paciente: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        if (indice >= 1 && indice <= pacientes.size()) {
            return pacientes.get(indice - 1);
        } else {
            System.out.println("Numero introduzido inválido.");
            return null;
        }
    }

    private static Medico escolherMedico(Scanner scanner) {
        System.out.println("1. Escolher médico pelo menu");
        System.out.println("2. Procurar médico pelo número de telemóvel");
        System.out.print("Opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                return escolherMedicoPeloMenu(scanner);
            case 2:
                return procurarMedicoPeloTelemovel(scanner);
            default:
                System.out.println("Opção inválida.");
                return null;
        }
    }

    private static Medico escolherMedicoPeloMenu(Scanner scanner) {
        listarMedicos();
        if (medicos.isEmpty()) {
            return null;
        }
        System.out.print("Escolha o médico: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        if (indice >= 1 && indice <= medicos.size()) {
            return medicos.get(indice - 1);
        } else {
            System.out.println("Numero introduzido inválido.");
            return null;
        }
    }

    private static Paciente procurarPacientePeloTelemovel(Scanner scanner) {
        System.out.print("Número de telemóvel do paciente: ");
        String telemovel = scanner.nextLine();

        for (Paciente paciente : pacientes) {
            if (paciente.getTelemovel().equals(telemovel)) {
                return paciente;
            }
        }
        System.out.println("Paciente não encontrado.");
        return null;
    }

    private static Medico procurarMedicoPeloTelemovel(Scanner scanner) {
        System.out.print("Número de telemóvel do médico: ");
        String telemovel = scanner.nextLine();

        for (Medico medico : medicos) {
            if (medico.getTelemovel().equals(telemovel)) {
                return medico;
            }
        }
        System.out.println("Médico não encontrado.");
        return null;
    }

    private static void cancelarConsulta(Scanner scanner) {
        System.out.println("Consultas agendadas:");
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            System.out.println((i + 1) + ". " + consulta.getPaciente().getNome() + " com " + consulta.getMedico().getNome() + " em " + consulta.getData());
        }

        if (consultas.isEmpty()) {
            return;
        }

        System.out.print("Escolha a consulta que pretende cancelar: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        if (indice >= 1 && indice <= consultas.size()) {
            consultas.remove(indice - 1);
            System.out.println("Consulta cancelada com sucesso!");
        } else {
            System.out.println("Numero introduzido inválido.");
        }
    }

    private static void listarMedicos() {
        System.out.println("----- Lista de Médicos -----");
        if (medicos.isEmpty()) {
            System.out.println("Não há médicos inseridos.");
        } else {
            for (int i = 0; i < medicos.size(); i++) {
                Medico medico = medicos.get(i);
                System.out.println((i + 1) + ". " + medico);
            }
        }
    }

    private static void listarPacientes() {
        System.out.println("----- Lista de Pacientes -----");
        if (pacientes.isEmpty()) {
            System.out.println("Não há pacientes inseridos.");
        } else {
            for (int i = 0; i < pacientes.size(); i++) {
                Paciente paciente = pacientes.get(i);
                System.out.println((i + 1) + ". " + paciente);
            }
        }
    }

    private static void listarConsultas() {
        System.out.println("----- Lista de Consultas -----");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        if (consultas.isEmpty()) {
            System.out.println("Não há consultas agendadas.");
        } else {
            for (int i = 0; i < consultas.size(); i++) {
                Consulta consulta = consultas.get(i);
                String dataConsultaFormatada = sdf.format(consulta.getData());
                System.out.println((i + 1) + ". " + consulta.getPaciente() + " com " + consulta.getMedico() + " na data de " + dataConsultaFormatada);
            }
        }
    }

    private static void eliminarPacienteOuMedico(Scanner scanner) {
        int opcao;
        do {
            System.out.println("----- Eliminar Paciente ou Médico -----");
            System.out.println("1. Eliminar Paciente");
            System.out.println("2. Eliminar Médico");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    eliminarPaciente(scanner);
                    break;
                case 2:
                    eliminarMedico(scanner);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }

    private static void eliminarPaciente(Scanner scanner) {
        System.out.println("----- Eliminar Paciente -----");

        Paciente paciente = escolherPaciente(scanner);

        if (paciente == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        pacientes.remove(paciente);
        System.out.println("Paciente removido com sucesso!");
    }

    private static void eliminarMedico(Scanner scanner) {
        System.out.println("----- Eliminar Médico -----");

        Medico medico = escolherMedico(scanner);

        if (medico == null) {
            System.out.println("Operação cancelada.");
            return;
        }

        medicos.remove(medico);
        System.out.println("Médico removido com sucesso!");
    }

    private static void pesquisarPorNome(Scanner scanner) {
        System.out.print("Digite o nome do paciente ou médico: ");
        String nome = scanner.nextLine();

        boolean encontrado = false;
        System.out.println("Resultados da pesquisa:");
        for (Medico medico : medicos) {
            if (medico.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Médico: " + medico);
                encontrado = true;
            }
        }

        for (Paciente paciente : pacientes) {
            if (paciente.getNome().equalsIgnoreCase(nome)) {
                System.out.println("Paciente: " + paciente);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum médico ou paciente encontrado com esse nome.");
        }
    }

    private static void pesquisarPorTelemovel(Scanner scanner) {
        System.out.print("Digite o número de telemóvel do paciente ou médico: ");
        String telemovel = scanner.nextLine();

        boolean encontrado = false;
        System.out.println("Resultados da pesquisa:");
        for (Medico medico : medicos) {
            if (medico.getTelemovel().equals(telemovel)) {
                System.out.println("Médico: " + medico);
                encontrado = true;
            }
        }

        for (Paciente paciente : pacientes) {
            if (paciente.getTelemovel().equals(telemovel)) {
                System.out.println("Paciente: " + paciente);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum médico ou paciente encontrado com esse número de telemóvel.");
        }
    }

    private static void pesquisarMedicoPorEspecialidade(Scanner scanner) {
        System.out.println("Especialidades disponíveis:");
        System.out.println("1. Pediatria");
        System.out.println("2. Cirurgia");
        System.out.println("3. Psiquiatria");
        System.out.println("4. Ginecologia");
        System.out.print("Escolha a especialidade: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        String especialidade;
        switch (opcao) {
            case 1:
                especialidade = "Pediatria";
                break;
            case 2:
                especialidade = "Cirurgia";
                break;
            case 3:
                especialidade = "Psiquiatria";
                break;
            case 4:
                especialidade = "Ginecologia";
                break;
            default:
                System.out.println("Opção inválida.");
                return;
        }

        boolean encontrado = false;
        System.out.println("Resultados da pesquisa:");
        for (Medico medico : medicos) {
            if (medico.getEspecialidade().equalsIgnoreCase(especialidade)) {
                System.out.println("Médico: " + medico);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Nenhum médico encontrado com essa especialidade.");
        }
    }
}
