import model.Atendimento;
import model.Paciente;
import model.Profissional;
import model.TelemetriaSinaisVitais;
import model.UnidadeMovel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String NOME_ARQUIVO = "dados_sistema.dat";

    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static ArrayList<UnidadeMovel> unidades = new ArrayList<>();
    private static ArrayList<Profissional> profissionais = new ArrayList<>();
    private static ArrayList<Atendimento> atendimentos = new ArrayList<>();
    private static ArrayList<TelemetriaSinaisVitais> telemetrias = new ArrayList<>();

    private static HashMap<Integer, Paciente> pacientesPorId = new HashMap<>();
    private static HashMap<Integer, UnidadeMovel> unidadesPorId = new HashMap<>();
    private static HashMap<Integer, Profissional> profissionaisPorId = new HashMap<>();
    private static HashMap<Integer, Atendimento> atendimentosPorId = new HashMap<>();
    private static HashMap<Integer, TelemetriaSinaisVitais> telemetriasPorId = new HashMap<>();

    private static int proximoIdPaciente = 1;
    private static int proximoIdUnidade = 1;
    private static int proximoIdProfissional = 1;
    private static int proximoIdAtendimento = 1;
    private static int proximoIdTelemetria = 1;

    public static void main(String[] args) {
        int opcao;

        do {
            exibirMenu();
            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    listarPacientes();
                    break;
                case 3:
                    buscarPacientePorId();
                    break;
                case 4:
                    atualizarPaciente();
                    break;
                case 5:
                    cadastrarUnidadeMovel();
                    break;
                case 6:
                    listarUnidadesMoveis();
                    break;
                case 7:
                    cadastrarProfissional();
                    break;
                case 8:
                    listarProfissionais();
                    break;
                case 9:
                    registrarAtendimento();
                    break;
                case 10:
                    listarAtendimentos();
                    break;
                case 11:
                    registrarSinaisVitais();
                    break;
                case 12:
                    listarSinaisVitais();
                    break;
                case 13:
                    salvarDadosEmArquivo();
                    break;
                case 14:
                    carregarDadosDoArquivo();
                    break;
                case 0:
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println();
        System.out.println("Sistema de Atendimento em Unidades Móveis de Saúde");
        System.out.println("1. Cadastrar paciente");
        System.out.println("2. Listar pacientes");
        System.out.println("3. Buscar paciente por ID");
        System.out.println("4. Atualizar paciente");
        System.out.println("5. Cadastrar unidade móvel");
        System.out.println("6. Listar unidades móveis");
        System.out.println("7. Cadastrar profissional");
        System.out.println("8. Listar profissionais");
        System.out.println("9. Registrar atendimento");
        System.out.println("10. Listar atendimentos");
        System.out.println("11. Registrar sinais vitais");
        System.out.println("12. Listar sinais vitais");
        System.out.println("13. Salvar dados em arquivo");
        System.out.println("14. Carregar dados do arquivo");
        System.out.println("0. Sair");
        System.out.println();
    }

    private static void cadastrarPaciente() {
        System.out.println();
        System.out.println("Cadastro de paciente");

        String nome = lerTexto("Nome: ");
        String dataNascimento = lerTexto("Data de nascimento: ");
        String comunidadeOrigem = lerTexto("Comunidade de origem: ");
        String historicoMedico = lerTexto("Histórico médico: ");

        Paciente paciente = new Paciente(
                proximoIdPaciente,
                nome,
                dataNascimento,
                comunidadeOrigem,
                historicoMedico
        );

        pacientes.add(paciente);
        pacientesPorId.put(proximoIdPaciente, paciente);
        proximoIdPaciente++;

        System.out.println("Paciente cadastrado com sucesso.");
    }

    private static void listarPacientes() {
        System.out.println();
        System.out.println("Lista de pacientes");

        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
        }
    }

    private static void buscarPacientePorId() {
        System.out.println();
        int id = lerInteiro("Digite o ID do paciente: ");

        Paciente paciente = pacientesPorId.get(id);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
        } else {
            System.out.println(paciente);
        }
    }

    private static void atualizarPaciente() {
        System.out.println();
        int id = lerInteiro("Digite o ID do paciente que deseja atualizar: ");

        Paciente paciente = pacientesPorId.get(id);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Deixe em branco para manter o valor atual.");

        String nome = lerTexto("Novo nome: ");
        String dataNascimento = lerTexto("Nova data de nascimento: ");
        String comunidadeOrigem = lerTexto("Nova comunidade de origem: ");
        String historicoMedico = lerTexto("Novo histórico médico: ");

        if (!nome.trim().isEmpty()) {
            paciente.setNome(nome);
        }

        if (!dataNascimento.trim().isEmpty()) {
            paciente.setDataNascimento(dataNascimento);
        }

        if (!comunidadeOrigem.trim().isEmpty()) {
            paciente.setComunidadeOrigem(comunidadeOrigem);
        }

        if (!historicoMedico.trim().isEmpty()) {
            paciente.setHistoricoMedico(historicoMedico);
        }

        System.out.println("Paciente atualizado com sucesso.");
    }

    private static void cadastrarUnidadeMovel() {
        System.out.println();
        System.out.println("Cadastro de unidade móvel");

        String identificacaoSatelite = lerTexto("Identificação via satélite: ");
        String regiaoAtual = lerTexto("Região atual: ");
        String statusConexao = lerTexto("Status da conexão: ");

        UnidadeMovel unidade = new UnidadeMovel(
                proximoIdUnidade,
                identificacaoSatelite,
                regiaoAtual,
                statusConexao
        );

        unidades.add(unidade);
        unidadesPorId.put(proximoIdUnidade, unidade);
        proximoIdUnidade++;

        System.out.println("Unidade móvel cadastrada com sucesso.");
    }

    private static void listarUnidadesMoveis() {
        System.out.println();
        System.out.println("Lista de unidades móveis");

        if (unidades.isEmpty()) {
            System.out.println("Nenhuma unidade móvel cadastrada.");
            return;
        }

        for (UnidadeMovel unidade : unidades) {
            System.out.println(unidade);
        }
    }

    private static void cadastrarProfissional() {
        System.out.println();
        System.out.println("Cadastro de profissional");

        String nome = lerTexto("Nome: ");
        String registroConselho = lerTexto("Registro no conselho: ");
        String funcao = lerTexto("Função: ");

        Profissional profissional = new Profissional(
                proximoIdProfissional,
                nome,
                registroConselho,
                funcao
        );

        profissionais.add(profissional);
        profissionaisPorId.put(proximoIdProfissional, profissional);
        proximoIdProfissional++;

        System.out.println("Profissional cadastrado com sucesso.");
    }

    private static void listarProfissionais() {
        System.out.println();
        System.out.println("Lista de profissionais");

        if (profissionais.isEmpty()) {
            System.out.println("Nenhum profissional cadastrado.");
            return;
        }

        for (Profissional profissional : profissionais) {
            System.out.println(profissional);
        }
    }

    private static void registrarAtendimento() {
        System.out.println();
        System.out.println("Registro de atendimento");

        if (pacientes.isEmpty() || unidades.isEmpty() || profissionais.isEmpty()) {
            System.out.println("Antes de registrar atendimento, cadastre paciente, unidade móvel e profissional.");
            return;
        }

        listarPacientes();
        int idPaciente = lerInteiro("ID do paciente: ");

        if (!pacientesPorId.containsKey(idPaciente)) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        listarUnidadesMoveis();
        int idUnidade = lerInteiro("ID da unidade móvel: ");

        if (!unidadesPorId.containsKey(idUnidade)) {
            System.out.println("Unidade móvel não encontrada.");
            return;
        }

        listarProfissionais();
        int idProfissionalLocal = lerInteiro("ID do profissional local: ");

        if (!profissionaisPorId.containsKey(idProfissionalLocal)) {
            System.out.println("Profissional local não encontrado.");
            return;
        }

        int idEspecialistaDigitado = lerInteiro("ID do especialista remoto ou 0 se não houver: ");
        Integer idEspecialistaRemoto = null;

        if (idEspecialistaDigitado != 0) {
            if (!profissionaisPorId.containsKey(idEspecialistaDigitado)) {
                System.out.println("Especialista remoto não encontrado.");
                return;
            }

            idEspecialistaRemoto = idEspecialistaDigitado;
        }

        String dataHoraInicio = lerTexto("Data e hora do início: ");
        String resultadoTriagemIa = lerTexto("Resultado da triagem por IA: ");
        String nivelUrgencia = lerTexto("Nível de urgência: ");

        Atendimento atendimento = new Atendimento(
                proximoIdAtendimento,
                idPaciente,
                idUnidade,
                idProfissionalLocal,
                idEspecialistaRemoto,
                dataHoraInicio,
                resultadoTriagemIa,
                nivelUrgencia
        );

        atendimentos.add(atendimento);
        atendimentosPorId.put(proximoIdAtendimento, atendimento);
        proximoIdAtendimento++;

        System.out.println("Atendimento registrado com sucesso.");
    }

    private static void listarAtendimentos() {
        System.out.println();
        System.out.println("Lista de atendimentos");

        if (atendimentos.isEmpty()) {
            System.out.println("Nenhum atendimento registrado.");
            return;
        }

        for (Atendimento atendimento : atendimentos) {
            System.out.println(atendimento);
        }
    }

    private static void registrarSinaisVitais() {
        System.out.println();
        System.out.println("Registro de sinais vitais");

        if (atendimentos.isEmpty()) {
            System.out.println("Antes de registrar sinais vitais, registre um atendimento.");
            return;
        }

        listarAtendimentos();
        int idAtendimento = lerInteiro("ID do atendimento: ");

        if (!atendimentosPorId.containsKey(idAtendimento)) {
            System.out.println("Atendimento não encontrado.");
            return;
        }

        int frequenciaCardiaca = lerInteiro("Frequência cardíaca: ");
        String pressaoArterial = lerTexto("Pressão arterial: ");
        int oxigenacao = lerInteiro("Oxigenação: ");
        double temperatura = lerDouble("Temperatura: ");
        String dataHoraLeitura = lerTexto("Data e hora da leitura: ");

        TelemetriaSinaisVitais telemetria = new TelemetriaSinaisVitais(
                proximoIdTelemetria,
                idAtendimento,
                frequenciaCardiaca,
                pressaoArterial,
                oxigenacao,
                temperatura,
                dataHoraLeitura
        );

        telemetrias.add(telemetria);
        telemetriasPorId.put(proximoIdTelemetria, telemetria);
        proximoIdTelemetria++;

        System.out.println("Sinais vitais registrados com sucesso.");
    }

    private static void listarSinaisVitais() {
        System.out.println();
        System.out.println("Lista de sinais vitais");

        if (telemetrias.isEmpty()) {
            System.out.println("Nenhum sinal vital registrado.");
            return;
        }

        for (TelemetriaSinaisVitais telemetria : telemetrias) {
            System.out.println(telemetria);
        }
    }

    private static void salvarDadosEmArquivo() {
        try (ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            saida.writeObject(pacientes);
            saida.writeObject(unidades);
            saida.writeObject(profissionais);
            saida.writeObject(atendimentos);
            saida.writeObject(telemetrias);

            saida.writeInt(proximoIdPaciente);
            saida.writeInt(proximoIdUnidade);
            saida.writeInt(proximoIdProfissional);
            saida.writeInt(proximoIdAtendimento);
            saida.writeInt(proximoIdTelemetria);

            System.out.println("Dados salvos em arquivo com sucesso.");
        } catch (IOException erro) {
            System.out.println("Erro ao salvar dados: " + erro.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    private static void carregarDadosDoArquivo() {
        File arquivo = new File(NOME_ARQUIVO);

        if (!arquivo.exists()) {
            System.out.println("Arquivo de dados ainda não existe.");
            return;
        }

        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
            pacientes = (ArrayList<Paciente>) entrada.readObject();
            unidades = (ArrayList<UnidadeMovel>) entrada.readObject();
            profissionais = (ArrayList<Profissional>) entrada.readObject();
            atendimentos = (ArrayList<Atendimento>) entrada.readObject();
            telemetrias = (ArrayList<TelemetriaSinaisVitais>) entrada.readObject();

            proximoIdPaciente = entrada.readInt();
            proximoIdUnidade = entrada.readInt();
            proximoIdProfissional = entrada.readInt();
            proximoIdAtendimento = entrada.readInt();
            proximoIdTelemetria = entrada.readInt();

            recriarMapas();

            System.out.println("Dados carregados do arquivo com sucesso.");
        } catch (IOException | ClassNotFoundException erro) {
            System.out.println("Erro ao carregar dados: " + erro.getMessage());
        }
    }

    private static void recriarMapas() {
        pacientesPorId = new HashMap<>();
        unidadesPorId = new HashMap<>();
        profissionaisPorId = new HashMap<>();
        atendimentosPorId = new HashMap<>();
        telemetriasPorId = new HashMap<>();

        for (Paciente paciente : pacientes) {
            pacientesPorId.put(paciente.getIdPaciente(), paciente);
        }

        for (UnidadeMovel unidade : unidades) {
            unidadesPorId.put(unidade.getIdUnidade(), unidade);
        }

        for (Profissional profissional : profissionais) {
            profissionaisPorId.put(profissional.getIdProfissional(), profissional);
        }

        for (Atendimento atendimento : atendimentos) {
            atendimentosPorId.put(atendimento.getIdAtendimento(), atendimento);
        }

        for (TelemetriaSinaisVitais telemetria : telemetrias) {
            telemetriasPorId.put(telemetria.getIdTelemetria(), telemetria);
        }
    }

    private static String lerTexto(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    private static int lerInteiro(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException erro) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    private static double lerDouble(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Double.parseDouble(scanner.nextLine().replace(",", "."));
            } catch (NumberFormatException erro) {
                System.out.println("Digite um número válido.");
            }
        }
    }
}