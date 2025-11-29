import java.util.ArrayList;
import java.util.List;

// --- CENÁRIO: USO DE COMPOSIÇÃO ---
// Objetivo: Permitir que uma pessoa tenha múltiplos papéis (Professor E Aluno)
// e evitar o acoplamento forte da herança ("is-a").

// 1. A INTERFACE DO COMPONENTE (O Papel)
// Em vez de herdar de Pessoa, criamos comportamentos que podem ser "plugados" em uma pessoa.
interface PapelAcademico {
    void realizarAtividade();
    String getDescricao();
}

// 2. IMPLEMENTAÇÕES DOS PAPÉIS (Comportamentos concretos)

class PapelAluno implements PapelAcademico {
    private String matricula;
    private String curso;

    public PapelAluno(String matricula, String curso) {
        this.matricula = matricula;
        this.curso = curso;
    }

    @Override
    public void realizarAtividade() {
        System.out.println("  -> [Aluno] Assistindo aula do curso de " + curso + " (Matrícula: " + matricula + ")");
    }

    @Override
    public String getDescricao() {
        return "Aluno de " + curso;
    }
}

class PapelProfessor implements PapelAcademico {
    private String departamento;
    private String especializacao;

    public PapelProfessor(String departamento, String especializacao) {
        this.departamento = departamento;
        this.especializacao = especializacao;
    }

    @Override
    public void realizarAtividade() {
        System.out.println("  -> [Professor] Ministrando aula no dep. de " + departamento + " (" + especializacao + ")");
    }

    @Override
    public String getDescricao() {
        return "Professor de " + especializacao;
    }
}

// 3. A CLASSE CONTEXTO (O Container)
// Esta classe representa a entidade "Pessoa" ou "Membro".
// Em vez de SER um Aluno ou SER um Professor, ela TEM papéis.
class MembroUniversidade {
    // Atributos próprios da pessoa (Identidade)
    private String nome;
    private String cpf;
    
    // COMPOSIÇÃO: Uma lista de papéis. 
    // Isso é muito mais flexível que herança. 1 Pessoa -> N Papéis.
    private List<PapelAcademico> papeis;

    public MembroUniversidade(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.papeis = new ArrayList<>();
    }

    // Método para adicionar comportamento dinamicamente (Impossível com herança pura)
    public void adicionarPapel(PapelAcademico papel) {
        this.papeis.add(papel);
    }

    public void mostrarIdentidade() {
        System.out.println("Membro: " + nome + " (CPF: " + cpf + ")");
    }

    // Polimorfismo via Delegação
    public void realizarAtividadesDiarias() {
        System.out.println("Atividades de " + nome + ":");
        if (papeis.isEmpty()) {
            System.out.println("  - Nenhuma atividade acadêmica registrada.");
        } else {
            for (PapelAcademico papel : papeis) {
                papel.realizarAtividade();
            }
        }
        System.out.println("-------------------------------------------------");
    }
}

// --- CLASSE MAIN PARA DEMONSTRAÇÃO ---
public class SistemaComposicao {
    public static void main(String[] args) {
        System.out.println(">>> SISTEMA ACADÊMICO VIA COMPOSIÇÃO <<<\n");

        // CASO 1: Criando um Aluno comum
        MembroUniversidade membro1 = new MembroUniversidade("Andrews Simões", "111.222.333-44");
        membro1.adicionarPapel(new PapelAluno("2024-01", "Ciência da Computação"));
        
        membro1.mostrarIdentidade();
        membro1.realizarAtividadesDiarias();

        // CASO 2: Criando um Professor comum
        MembroUniversidade membro2 = new MembroUniversidade("Elvio Reis", "555.666.777-88");
        membro2.adicionarPapel(new PapelProfessor("Back-end", "Criptografia"));
        
        membro2.mostrarIdentidade();
        membro2.realizarAtividadesDiarias();

        // CASO 3: O PODER DA COMPOSIÇÃO
        // Imagine um monitor ou pós-graduando: Ele é Professor (dá aula) E Aluno (estuda).
        // Com herança (extends), teríamos que criar uma classe "ProfessorAluno".
        // Com composição, apenas adicionamos os dois papéis ao mesmo objeto.
        
        MembroUniversidade membroHibrido = new MembroUniversidade("Thaís Nascimento", "999.888.777-66");
        
        // Grace é Aluna de Doutorado...
        membroHibrido.adicionarPapel(new PapelAluno("DOC-2024", "Doutorado em Computação"));
        // ...E também é Professora Substituta
        membroHibrido.adicionarPapel(new PapelProfessor("Computação", "Compiladores"));

        System.out.println(">>> CASO HÍBRIDO (Sem Herança Múltipla) <<<");
        membroHibrido.mostrarIdentidade();
        membroHibrido.realizarAtividadesDiarias();
    }
}
