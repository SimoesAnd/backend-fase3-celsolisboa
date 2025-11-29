# backend-fase3-celso

Sistema Acadêmico: Abordagem via Composição

Este projeto é uma demonstração prática em Java de como utilizar Composição como alternativa à Herança para resolver problemas de acoplamento forte e permitir flexibilidade de papéis em um sistema orientado a objetos.

📄 # Sobre o Projeto

Em sistemas tradicionais usando herança pura, é difícil modelar uma pessoa que desempenha múltiplos papéis simultaneamente (ex: alguém que é tanto Professor quanto Aluno), pois o Java não suporta herança múltipla de classes.

Este projeto resolve isso utilizando o princípio "Prefira composição a herança".

MembroUniversidade: Representa a pessoa. Em vez de ser um Aluno, ela tem uma lista de papéis.

PapelAcademico: Uma interface que define o comportamento genérico.

PapelAluno / PapelProfessor: Implementações concretas que podem ser "plugadas" dinamicamente em um membro.

🚀 #Como Executar

# Pré-requisitos

Java JDK 8 ou superior instalado.

Passo a Passo

Salvar o Arquivo: Certifique-se de que o código fonte esteja salvo em um arquivo chamado SistemaComposicao.java.

Abrir o Terminal: Navegue até a pasta onde você salvou o arquivo.

Compilar:
Execute o comando abaixo para gerar os arquivos .class (bytecode):

# javac SistemaComposicao.java


Executar:
Execute a classe principal:

java SistemaComposicao


📊 O que esperar da Saída

O sistema demonstrará três casos de uso:

Caso 1: Uma pessoa agindo apenas como Aluno.

Caso 2: Uma pessoa agindo apenas como Professor.

Caso 3 (Híbrido): O cenário principal, onde uma única pessoa ("Thaís Nascimento") possui ambos os papéis simultaneamente, algo que exigiria uma hierarquia complexa se feito apenas com herança.

🛠 Estrutura do Código

interface PapelAcademico: Define o contrato realizarAtividade().

class MembroUniversidade: O container que gerencia a lista de papéis.

class SistemaComposicao: Contém o método main para execução.

Este exemplo foi criado para fins educacionais por Andrews Simões.
