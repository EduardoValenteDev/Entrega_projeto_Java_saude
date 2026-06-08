# ORBITCARE

Plataforma para atendimento médico remoto em comunidades isoladas.

Projeto Java desenvolvido para simular um sistema de atendimento em saúde utilizando Programação Orientada a Objetos.

## Funcionalidades

Cadastro e listagem de comunidades.

Cadastro, listagem, busca e atualização de pacientes.

Cadastro e listagem de unidades móveis.

Cadastro e listagem de profissionais de saúde.

Registro e listagem de atendimentos.

Registro e listagem de sinais vitais.

Geração automática de identificadores para comunidades, pacientes, unidades móveis, profissionais, atendimentos e sinais vitais.

Visualização organizada dos dados no console.

## Diagrama UML de Classes

```mermaid
classDiagram
    class Comunidade {
        - String idComunidade
        - String nome
        - int populacao
        - String riscos
        - double distanciaHospitalar
        - String conectividade
        + Comunidade(String, String, int, String, double, String)
        + getIdComunidade() String
        + setIdComunidade(String)
        + getNome() String
        + setNome(String)
        + getPopulacao() int
        + setPopulacao(int)
        + getRiscos() String
        + setRiscos(String)
        + getDistanciaHospitalar() double
        + setDistanciaHospitalar(double)
        + getConectividade() String
        + setConectividade(String)
        + toString() String
    }

    class Paciente {
        - String idPaciente
        - String nome
        - String dataNascimento
        - Comunidade comunidade
        - String historicoMedico
        + Paciente(String, String, String, Comunidade, String)
        + getIdPaciente() String
        + setIdPaciente(String)
        + getNome() String
        + setNome(String)
        + getDataNascimento() String
        + setDataNascimento(String)
        + getComunidade() Comunidade
        + setComunidade(Comunidade)
        + getHistoricoMedico() String
        + setHistoricoMedico(String)
        + toString() String
    }

    class UnidadeMovel {
        - String idUnidade
        - String identificacaoSatelite
        - String regiaoAtual
        - String statusConexao
        + UnidadeMovel(String, String, String, String)
        + getIdUnidade() String
        + setIdUnidade(String)
        + getIdentificacaoSatelite() String
        + setIdentificacaoSatelite(String)
        + getRegiaoAtual() String
        + setRegiaoAtual(String)
        + getStatusConexao() String
        + setStatusConexao(String)
        + toString() String
    }

    class Profissional {
        - String idProfissional
        - String nome
        - String registroConselho
        - String funcao
        + Profissional(String, String, String, String)
        + getIdProfissional() String
        + setIdProfissional(String)
        + getNome() String
        + setNome(String)
        + getRegistroConselho() String
        + setRegistroConselho(String)
        + getFuncao() String
        + setFuncao(String)
        + toString() String
    }

    class Atendimento {
        - String idAtendimento
        - Paciente paciente
        - UnidadeMovel unidade
        - Profissional profissionalLocal
        - Profissional especialistaRemoto
        - String dataHoraInicio
        - String resultadoTriagemIa
        - String nivelUrgencia
        + Atendimento(String, Paciente, UnidadeMovel, Profissional, Profissional, String, String, String)
        + getIdAtendimento() String
        + setIdAtendimento(String)
        + getPaciente() Paciente
        + setPaciente(Paciente)
        + getUnidade() UnidadeMovel
        + setUnidade(UnidadeMovel)
        + getProfissionalLocal() Profissional
        + setProfissionalLocal(Profissional)
        + getEspecialistaRemoto() Profissional
        + setEspecialistaRemoto(Profissional)
        + getDataHoraInicio() String
        + setDataHoraInicio(String)
        + getResultadoTriagemIa() String
        + setResultadoTriagemIa(String)
        + getNivelUrgencia() String
        + setNivelUrgencia(String)
        + toString() String
    }

    class TelemetriaSinaisVitais {
        - String idTelemetria
        - Atendimento atendimento
        - int frequenciaCardiaca
        - String pressaoArterial
        - int oxigenacao
        - double temperatura
        - String dataHoraLeitura
        + TelemetriaSinaisVitais(String, Atendimento, int, String, int, double, String)
        + getIdTelemetria() String
        + setIdTelemetria(String)
        + getAtendimento() Atendimento
        + setAtendimento(Atendimento)
        + getFrequenciaCardiaca() int
        + setFrequenciaCardiaca(int)
        + getPressaoArterial() String
        + setPressaoArterial(String)
        + getOxigenacao() int
        + setOxigenacao(int)
        + getTemperatura() double
        + setTemperatura(double)
        + getDataHoraLeitura() String
        + setDataHoraLeitura(String)
        + toString() String
    }

    Comunidade "1" --> "0..*" Paciente : possui
    Paciente "1" --> "0..*" Atendimento : participa
    UnidadeMovel "1" --> "0..*" Atendimento : realiza
    Profissional "1" --> "0..*" Atendimento : atua
    Atendimento "1" --> "0..*" TelemetriaSinaisVitais : registra
```

## Modelo de Orientação a Objetos

O projeto utiliza objetos para representar os relacionamentos entre as classes.

Um paciente possui uma comunidade.

Um atendimento possui um paciente, uma unidade móvel, um profissional local e, opcionalmente, um especialista remoto.

Um registro de sinais vitais possui um atendimento.

Essa estrutura permite que uma classe acesse diretamente as informações relacionadas, sem depender apenas de identificadores soltos.

## Organização do Projeto

```text
src
  Main.java
  model
    Atendimento.java
    Comunidade.java
    Paciente.java
    Profissional.java
    TelemetriaSinaisVitais.java
    UnidadeMovel.java
```
