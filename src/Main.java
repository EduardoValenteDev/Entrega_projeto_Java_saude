import model.Atendimento;
import model.Comunidade;
import model.Paciente;
import model.Profissional;
import model.TelemetriaSinaisVitais;
import model.UnidadeMovel;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static ArrayList<Comunidade> comunidades = new ArrayList<>();
    private static ArrayList<Paciente> pacientes = new ArrayList<>();
    private static ArrayList<UnidadeMovel> unidades = new ArrayList<>();
    private static ArrayList<Profissional> profissionais = new ArrayList<>();
    private static ArrayList<Atendimento> atendimentos = new ArrayList<>();
    private static ArrayList<TelemetriaSinaisVitais> telemetrias = new ArrayList<>();

    private static int proximoIdComunidade = 1;
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
                    cadastrarComunidade();
                    break;
                case 2:
                    listarComunidades();
                    break;
                case 3:
                    cadastrarPaciente();
                    break;
                case 4:
                    listarPacientes();
                    break;
                case 5:
                    buscarPacientePorId();
                    break;
                case 6:
                    atualizarPaciente();
                    break;
                case 7:
                    cadastrarUnidadeMovel();
                    break;
                case 8:
                    listarUnidadesMoveis();
                    break;
                case 9:
                    cadastrarProfissional();
                    break;
                case 10:
                    listarProfissionais();
                    break;
                case 11:
                    registrarAtendimento();
                    break;
                case 12:
                    listarAtendimentos();
                    break;
                case 13:
                    registrarSinaisVitais();
                    break;
                case 14:
                    listarSinaisVitais();
                    break;
                case 0:
                    System.out.println("ORBITCARE encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void exibirMenu() {
        System.out.println();
        exibirLinha();
        System.out.println("ORBITCARE");
        System.out.println("Plataforma para atendimento médico remoto em comunidades isoladas");
        exibirLinha();
        System.out.println("1. Cadastrar comunidade");
        System.out.println("2. Listar comunidades");
        System.out.println("3. Cadastrar paciente");
        System.out.println("4. Listar pacientes");
        System.out.println("5. Buscar paciente por ID");
        System.out.println("6. Atualizar paciente");
        System.out.println("7. Cadastrar unidade móvel");
        System.out.println("8. Listar unidades móveis");
        System.out.println("9. Cadastrar profissional");
        System.out.println("10. Listar profissionais");
        System.out.println("11. Registrar atendimento");
        System.out.println("12. Listar atendimentos");
        System.out.println("13. Registrar sinais vitais");
        System.out.println("14. Listar sinais vitais");
        System.out.println("0. Sair");
        exibirLinha();
        System.out.println();
    }

    private static void cadastrarComunidade() {
        exibirTituloSecao("CADASTRO DE COMUNIDADE");

        String idComunidade = gerarId("CM", proximoIdComunidade);
        String nome = lerTexto("Nome da comunidade: ");
        int populacao = lerInteiro("População: ");
        String riscos = lerTexto("Riscos da comunidade: ");
        double distanciaHospitalar = lerDouble("Distância hospitalar em km: ");
        String conectividade = lerTexto("Conectividade: ");

        Comunidade comunidade = new Comunidade(
                idComunidade,
                nome,
                populacao,
                riscos,
                distanciaHospitalar,
                conectividade
        );

        comunidades.add(comunidade);
        proximoIdComunidade++;

        System.out.println();
        System.out.println("Comunidade cadastrada com sucesso.");
        System.out.println("ID gerado automaticamente: " + idComunidade);
    }

    private static void listarComunidades() {
        exibirTituloSecao("COMUNIDADES ORBITCARE");

        if (comunidades.isEmpty()) {
            System.out.println("Nenhuma comunidade cadastrada.");
            return;
        }

        for (Comunidade comunidade : comunidades) {
            exibirComunidade(comunidade);
            exibirLinha();
        }
    }

    private static void cadastrarPaciente() {
        exibirTituloSecao("CADASTRO DE PACIENTE");

        if (comunidades.isEmpty()) {
            System.out.println("Antes de cadastrar um paciente, cadastre uma comunidade.");
            return;
        }

        String idPaciente = gerarId("PT", proximoIdPaciente);

        listarComunidades();
        String idComunidade = lerTexto("ID da comunidade do paciente: ").toUpperCase();

        Comunidade comunidade = encontrarComunidadePorId(idComunidade);

        if (comunidade == null) {
            System.out.println("Comunidade não encontrada.");
            return;
        }

        String nome = lerTexto("Nome: ");
        String dataNascimento = lerTexto("Data de nascimento: ");
        String historicoMedico = lerTexto("Histórico médico: ");

        Paciente paciente = new Paciente(
                idPaciente,
                nome,
                dataNascimento,
                comunidade,
                historicoMedico
        );

        pacientes.add(paciente);
        proximoIdPaciente++;

        System.out.println();
        System.out.println("Paciente cadastrado com sucesso.");
        System.out.println("ID gerado automaticamente: " + idPaciente);
    }

    private static void listarPacientes() {
        exibirTituloSecao("PACIENTES ORBITCARE");

        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
            return;
        }

        for (Paciente paciente : pacientes) {
            System.out.println(paciente);
            exibirLinha();
        }
    }

    private static void buscarPacientePorId() {
        exibirTituloSecao("BUSCA DE PACIENTE");

        String id = lerTexto("Digite o ID do paciente: ").toUpperCase();
        Paciente paciente = encontrarPacientePorId(id);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
        } else {
            System.out.println(paciente);
        }
    }

    private static void atualizarPaciente() {
        exibirTituloSecao("ATUALIZAÇÃO DE PACIENTE");

        String id = lerTexto("Digite o ID do paciente que deseja atualizar: ").toUpperCase();
        Paciente paciente = encontrarPacientePorId(id);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        System.out.println("Deixe em branco para manter o valor atual.");

        String nome = lerTexto("Novo nome: ");
        String dataNascimento = lerTexto("Nova data de nascimento: ");

        listarComunidades();
        String idComunidade = lerTexto("Novo ID da comunidade: ").toUpperCase();

        String historicoMedico = lerTexto("Novo histórico médico: ");

        if (!nome.trim().isEmpty()) {
            paciente.setNome(nome);
        }

        if (!dataNascimento.trim().isEmpty()) {
            paciente.setDataNascimento(dataNascimento);
        }

        if (!idComunidade.trim().isEmpty()) {
            Comunidade comunidade = encontrarComunidadePorId(idComunidade);

            if (comunidade == null) {
                System.out.println("Comunidade não encontrada. A comunidade do paciente não foi alterada.");
            } else {
                paciente.setComunidade(comunidade);
            }
        }

        if (!historicoMedico.trim().isEmpty()) {
            paciente.setHistoricoMedico(historicoMedico);
        }

        System.out.println("Paciente atualizado com sucesso.");
    }

    private static void cadastrarUnidadeMovel() {
        exibirTituloSecao("CADASTRO DE UNIDADE MÓVEL");

        String idUnidade = gerarId("ORB", proximoIdUnidade);
        String identificacaoSatelite = lerTexto("Identificação via satélite: ");
        String regiaoAtual = lerTexto("Região atual: ");
        String statusConexao = lerTexto("Status da conexão: ");

        UnidadeMovel unidade = new UnidadeMovel(
                idUnidade,
                identificacaoSatelite,
                regiaoAtual,
                statusConexao
        );

        unidades.add(unidade);
        proximoIdUnidade++;

        System.out.println();
        System.out.println("Unidade móvel cadastrada com sucesso.");
        System.out.println("ID gerado automaticamente: " + idUnidade);
    }

    private static void listarUnidadesMoveis() {
        exibirTituloSecao("UNIDADES MÓVEIS ORBITCARE");

        if (unidades.isEmpty()) {
            System.out.println("Nenhuma unidade móvel cadastrada.");
            return;
        }

        for (UnidadeMovel unidade : unidades) {
            System.out.println(unidade);
            exibirLinha();
        }
    }

    private static void cadastrarProfissional() {
        exibirTituloSecao("CADASTRO DE PROFISSIONAL");

        String idProfissional = gerarId("PR", proximoIdProfissional);
        String nome = lerTexto("Nome: ");
        String registroConselho = lerTexto("Registro no conselho: ");
        String funcao = lerTexto("Função: ");

        Profissional profissional = new Profissional(
                idProfissional,
                nome,
                registroConselho,
                funcao
        );

        profissionais.add(profissional);
        proximoIdProfissional++;

        System.out.println();
        System.out.println("Profissional cadastrado com sucesso.");
        System.out.println("ID gerado automaticamente: " + idProfissional);
    }

    private static void listarProfissionais() {
        exibirTituloSecao("PROFISSIONAIS ORBITCARE");

        if (profissionais.isEmpty()) {
            System.out.println("Nenhum profissional cadastrado.");
            return;
        }

        for (Profissional profissional : profissionais) {
            System.out.println(profissional);
            exibirLinha();
        }
    }

    private static void registrarAtendimento() {
        exibirTituloSecao("REGISTRO DE ATENDIMENTO");

        if (pacientes.isEmpty() || unidades.isEmpty() || profissionais.isEmpty()) {
            System.out.println("Antes de registrar atendimento, cadastre paciente, unidade móvel e profissional.");
            return;
        }

        String idAtendimento = gerarId("AT", proximoIdAtendimento);

        listarPacientes();
        String idPaciente = lerTexto("ID do paciente: ").toUpperCase();
        Paciente paciente = encontrarPacientePorId(idPaciente);

        if (paciente == null) {
            System.out.println("Paciente não encontrado.");
            return;
        }

        listarUnidadesMoveis();
        String idUnidade = lerTexto("ID da unidade móvel: ").toUpperCase();
        UnidadeMovel unidade = encontrarUnidadePorId(idUnidade);

        if (unidade == null) {
            System.out.println("Unidade móvel não encontrada.");
            return;
        }

        listarProfissionais();
        String idProfissionalLocal = lerTexto("ID do profissional local: ").toUpperCase();
        Profissional profissionalLocal = encontrarProfissionalPorId(idProfissionalLocal);

        if (profissionalLocal == null) {
            System.out.println("Profissional local não encontrado.");
            return;
        }

        String idEspecialistaRemoto = lerTexto("ID do especialista remoto ou 0 se não houver: ").toUpperCase();
        Profissional especialistaRemoto = null;

        if (!idEspecialistaRemoto.equals("0") && !idEspecialistaRemoto.trim().isEmpty()) {
            especialistaRemoto = encontrarProfissionalPorId(idEspecialistaRemoto);

            if (especialistaRemoto == null) {
                System.out.println("Especialista remoto não encontrado.");
                return;
            }
        }

        String dataHoraInicio = lerTexto("Data e hora do início: ");
        String resultadoTriagemIa = lerTexto("Resultado da triagem por IA: ");
        String nivelUrgencia = lerTexto("Nível de urgência: ");

        Atendimento atendimento = new Atendimento(
                idAtendimento,
                paciente,
                unidade,
                profissionalLocal,
                especialistaRemoto,
                dataHoraInicio,
                resultadoTriagemIa,
                nivelUrgencia
        );

        atendimentos.add(atendimento);
        proximoIdAtendimento++;

        System.out.println();
        System.out.println("Atendimento registrado com sucesso.");
        System.out.println("ID gerado automaticamente: " + idAtendimento);
    }

    private static void listarAtendimentos() {
        exibirTituloSecao("ATENDIMENTOS ORBITCARE");

        if (atendimentos.isEmpty()) {
            System.out.println("Nenhum atendimento registrado.");
            return;
        }

        for (Atendimento atendimento : atendimentos) {
            System.out.println(atendimento);
            exibirLinha();
        }
    }

    private static void registrarSinaisVitais() {
        exibirTituloSecao("REGISTRO DE SINAIS VITAIS");

        if (atendimentos.isEmpty()) {
            System.out.println("Antes de registrar sinais vitais, registre um atendimento.");
            return;
        }

        String idTelemetria = gerarId("SV", proximoIdTelemetria);

        listarAtendimentos();
        String idAtendimento = lerTexto("ID do atendimento: ").toUpperCase();
        Atendimento atendimento = encontrarAtendimentoPorId(idAtendimento);

        if (atendimento == null) {
            System.out.println("Atendimento não encontrado.");
            return;
        }

        int frequenciaCardiaca = lerInteiro("Frequência cardíaca: ");
        String pressaoArterial = lerTexto("Pressão arterial: ");
        int oxigenacao = lerInteiro("Oxigenação: ");
        double temperatura = lerDouble("Temperatura: ");
        String dataHoraLeitura = lerTexto("Data e hora da leitura: ");

        TelemetriaSinaisVitais telemetria = new TelemetriaSinaisVitais(
                idTelemetria,
                atendimento,
                frequenciaCardiaca,
                pressaoArterial,
                oxigenacao,
                temperatura,
                dataHoraLeitura
        );

        telemetrias.add(telemetria);
        proximoIdTelemetria++;

        System.out.println();
        System.out.println("Sinais vitais registrados com sucesso.");
        System.out.println("ID gerado automaticamente: " + idTelemetria);
    }

    private static void listarSinaisVitais() {
        exibirTituloSecao("SINAIS VITAIS ORBITCARE");

        if (telemetrias.isEmpty()) {
            System.out.println("Nenhum sinal vital registrado.");
            return;
        }

        for (TelemetriaSinaisVitais telemetria : telemetrias) {
            System.out.println(telemetria);
            exibirLinha();
        }
    }

    private static Comunidade encontrarComunidadePorId(String id) {
        for (Comunidade comunidade : comunidades) {
            if (comunidade.getIdComunidade().equalsIgnoreCase(id)) {
                return comunidade;
            }
        }

        return null;
    }

    private static Paciente encontrarPacientePorId(String id) {
        for (Paciente paciente : pacientes) {
            if (paciente.getIdPaciente().equalsIgnoreCase(id)) {
                return paciente;
            }
        }

        return null;
    }

    private static UnidadeMovel encontrarUnidadePorId(String id) {
        for (UnidadeMovel unidade : unidades) {
            if (unidade.getIdUnidade().equalsIgnoreCase(id)) {
                return unidade;
            }
        }

        return null;
    }

    private static Profissional encontrarProfissionalPorId(String id) {
        for (Profissional profissional : profissionais) {
            if (profissional.getIdProfissional().equalsIgnoreCase(id)) {
                return profissional;
            }
        }

        return null;
    }

    private static Atendimento encontrarAtendimentoPorId(String id) {
        for (Atendimento atendimento : atendimentos) {
            if (atendimento.getIdAtendimento().equalsIgnoreCase(id)) {
                return atendimento;
            }
        }

        return null;
    }

    private static void exibirComunidade(Comunidade comunidade) {
        System.out.println("\nComunidade");
        System.out.println("ID: " + comunidade.getIdComunidade());
        System.out.println("Nome: " + comunidade.getNome());
        System.out.println("População: " + comunidade.getPopulacao());
        System.out.println("Riscos: " + comunidade.getRiscos());
        System.out.println("Distância hospitalar: " + comunidade.getDistanciaHospitalar() + " km");
        System.out.println("Conectividade: " + comunidade.getConectividade());
    }

    private static String gerarId(String prefixo, int numero) {
        return String.format("%s-%02d", prefixo, numero);
    }

    private static void exibirTituloSecao(String titulo) {
        System.out.println();
        exibirLinha();
        System.out.println(titulo);
        exibirLinha();
    }

    private static void exibirLinha() {
        System.out.println("========================================");
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