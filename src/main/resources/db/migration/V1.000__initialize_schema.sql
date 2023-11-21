CREATE TABLE IF NOT EXISTS paciente
(
    id             UUID        NOT NULL,
    codigo         VARCHAR,
    nome           VARCHAR,
    nascimento     VARCHAR,
    sexo           SMALLINT,
    email          VARCHAR,
    cpf            VARCHAR,
    rg             VARCHAR,

    telefone          VARCHAR,
    telefoneTrabalho  VARCHAR,

    cep          VARCHAR,
    endereco     VARCHAR,
    complemento  VARCHAR,
    cidade       VARCHAR,
    pais         VARCHAR,
    numero       INT,
    bairro       VARCHAR,
    uf           SMALLINT,

    convenio     VARCHAR,
    numeroCarteirinha INT,
    acomodacao        VARCHAR,
    plano             VARCHAR,
    validade          TIMESTAMP,



    row_version    SMALLINT    NOT NULL DEFAULT 0,
    row_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_created_by VARCHAR(64) NOT NULL DEFAULT 'unknown',
    row_updated_by VARCHAR(64) NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_paciente PRIMARY KEY (id)
    );

CREATE TABLE IF NOT EXISTS atendimento
(
    id               UUID        NOT NULL,
    queixa_principal VARCHAR,
    historico_antecedentes VARCHAR,
    exame_fisico     VARCHAR,
    condutas         VARCHAR,
    diagnostico      VARCHAR,
    data_atendimento TIMESTAMP,
    paciente_id      UUID,
    profissional_id  UUID,



    row_version    SMALLINT    NOT NULL DEFAULT 0,
    row_created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_updated_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    row_created_by VARCHAR(64) NOT NULL DEFAULT 'unknown',
    row_updated_by VARCHAR(64) NOT NULL DEFAULT 'unknown',

    CONSTRAINT pk_atendimentoPRIMARY PRIMARY KEY (id)
    );