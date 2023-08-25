enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int, val email: String)

data class ConteudoEducacional(val nome: String, val duracao: Int, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun estaMatriculado(usuario: Usuario): Boolean {
        return inscritos.contains(usuario)
    }
    
    fun conteudosPorNivel(nivel: Nivel): List<ConteudoEducacional> {
        return conteudos.filter { it.nivel == nivel }
    }
}

fun main() {
    // Criação de usuários
    val usuario1 = Usuario("Peppa Pig", 19, "peppapig@email.com")
    val usuario2 = Usuario(" Bubassauro ", 18, "bubba@email.com")

    // Criação de conteúdos educacionais
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin", 60, Nivel.BASICO)
    val conteudo2 = ConteudoEducacional("Programação Orientada a Objetos em Kotlin", 120, Nivel.INTERMEDIARIO)
    val conteudo3 = ConteudoEducacional("Desenvolvimento de Aplicativos Android com Kotlin", 180, Nivel.AVANCADO)

    // Criação de uma formação
    val formacao = Formacao("Desenvolvimento em Kotlin", listOf(conteudo1, conteudo2, conteudo3))

    // Matrícula de usuários na formação
    formacao.matricular(usuario1)
    formacao.matricular(usuario2)

    // Verificação se um usuário está matriculado na formação
    println(formacao.estaMatriculado(usuario1)) // true
    println(formacao.estaMatriculado(usuario2)) // true

    // Listagem de conteúdos por nível de dificuldade
    println(formacao.conteudosPorNivel(Nivel.BASICO)) // [ConteudoEducacional(nome=Introdução ao Kotlin, duracao=60, nivel=BASICO)]
    println(formacao.conteudosPorNivel(Nivel.INTERMEDIARIO)) // [ConteudoEducacional(nome=Programação Orientada a Objetos em Kotlin, duracao=120, nivel=INTERMEDIARIO)]
    println(formacao.conteudosPorNivel(Nivel.AVANCADO)) // [ConteudoEducacional(nome=Desenvolvimento de Aplicativos Android com Kotlin, duracao=180, nivel=DIFICIL)]
}
