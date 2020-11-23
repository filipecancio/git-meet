package com.example.gitmeet.repository

import com.example.gitmeet.model.Commit
import com.example.gitmeet.model.Owner
import com.example.gitmeet.model.Repo


class AllRepository (){
    fun getRepoList():List<Repo>{
        val owner = getOwner()
        return listOf(
            Repo("289819900","-gostack-nv01-desafio-react-native", owner,""),
            Repo("220653792","Agronomobot", owner,"A chatbot for help country man"),
            Repo("308465464","baskara-site", owner,""),
            Repo("279197414","bass", owner,"A basic shopify theme"),
            Repo("272122490","bobba", owner,"Tema padrão para repositórios do GitHub"),
            Repo("252852741","bootcamp-gostack-desafios", owner,"Repositório contendo todos os desafios dos módulos do Bootcamp Gostack"),
            Repo("148372161","brModelo", owner,"brModelo 3.0 (principal)"),
            Repo("312301806","CalcRaiz", owner,""),
            Repo("234373073","casa-dos-meninos", owner,"A website template"),
            Repo("308719877","chatwp", owner,""),
            Repo("208436819","clasp", owner,"Command Line Apps Script Projects"),
            Repo("205859508","cursos-devdojo", owner,"Repositório de cursos do devmedia"),
            Repo("287946127","desafio-1-2020", owner,""),
            Repo("288059636","desafio-2-2020", owner,""),
            Repo("254227469","Desafio-Conceitos-do-Node.js", owner,"Desafio go stack nível 01")
        )
    }
    private fun getOwner():Owner{
        return Owner("13178261","filipecancio","https://avatars0.githubusercontent.com/u/13178261?v=4")
    }
}

class AllCommits (){
    fun getCommitList():List<Commit>{
        val owner = Owner("13178261","filipecancio","https://avatars0.githubusercontent.com/u/13178261?v=4")
        return listOf(
            Commit("feat: update theme #1","as2dcde3",owner),
            Commit("feat: update theme #2","as2dcde3",owner),
            Commit("feat: update theme #3","as2dcde3",owner),
            Commit("feat: update theme #4","as2dcde3",owner),
            Commit("feat: update theme #3","as2dcde3",owner),
            Commit("feat: update theme #5","as2dcde3",owner),
            Commit("feat: update theme #6","as2dcde3",owner),
            Commit("feat: update theme #7","as2dcde3",owner),
            Commit("feat: update theme #8","as2dcde3",owner),
            Commit("feat: update theme #9","as2dcde3",owner),
            Commit("feat: update theme #10","as2dcde3",owner),
            Commit("feat: update theme #11","as2dcde3",owner),
            Commit("feat: update theme #12","as2dcde3",owner),
            Commit("feat: update theme #13","as2dcde3",owner),
            Commit("feat: update theme #14","as2dcde3",owner),
            Commit("feat: update theme #15","as2dcde3",owner),
            Commit("feat: update theme #16","as2dcde3",owner),
            Commit("feat: update theme #17","as2dcde3",owner),
            Commit("feat: update theme #18","as2dcde3",owner),
            Commit("feat: update theme #19","as2dcde3",owner),
            Commit("feat: update theme #20","as2dcde3",owner)
        )
    }
}