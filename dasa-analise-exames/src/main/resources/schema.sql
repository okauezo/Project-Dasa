CREATE TABLE IF NOT EXISTS usuario (
                                       id IDENTITY PRIMARY KEY,
                                       nome VARCHAR(100) NOT NULL,
    email VARCHAR(120) UNIQUE NOT NULL,
    senha VARCHAR(80) NOT NULL,
    tipo VARCHAR(20) NOT NULL
    );


CREATE TABLE IF NOT EXISTS medico (
                                      id BIGINT PRIMARY KEY,
                                      crm VARCHAR(30) NOT NULL,
    especialidade VARCHAR(60) NOT NULL,
    FOREIGN KEY (id) REFERENCES usuario(id)
    );


CREATE TABLE IF NOT EXISTS exame (
                                     id IDENTITY PRIMARY KEY,
                                     tipo VARCHAR(50) NOT NULL,
    data DATE NOT NULL,
    status VARCHAR(20) NOT NULL,
    paciente_id BIGINT NOT NULL
    );


CREATE TABLE IF NOT EXISTS camera (
                                      id IDENTITY PRIMARY KEY,
                                      modelo VARCHAR(60),
    conexao VARCHAR(40),
    status VARCHAR(20)
    );


CREATE TABLE IF NOT EXISTS imagem (
                                      id IDENTITY PRIMARY KEY,
                                      caminho VARCHAR(255),
    formato VARCHAR(10),
    resolucao VARCHAR(20),
    exame_id BIGINT,
    FOREIGN KEY (exame_id) REFERENCES exame(id)
    );


CREATE TABLE IF NOT EXISTS analise_ia (
                                          id IDENTITY PRIMARY KEY,
                                          exame_id BIGINT NOT NULL,
                                          resultado VARCHAR(200),
    confianca DOUBLE,
    FOREIGN KEY (exame_id) REFERENCES exame(id)
    );