CREATE TABLE IF NOT EXISTS aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    idade INT NOT NULL,
    nota_primeiro_semestre DECIMAL(5,2) NOT NULL,
    nota_segundo_semestre DECIMAL(5,2) NOT NULL,
    nome_professor VARCHAR(255) NOT NULL,
    numero_sala INT NOT NULL
);
