package com.example.gitmeet

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RepoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo)
        val listRepos = findViewById<RecyclerView>(R.id.list_repos)
        listRepos.layoutManager = LinearLayoutManager(this)
        var cancio = Owner("13178261","filipecancio","https://avatars0.githubusercontent.com/u/13178261?v=4")
        var repos = listOf<Repo>(
            Repo("289819900","-gostack-nv01-desafio-react-native", cancio,""),
            Repo("220653792","Agronomobot", cancio,"A chatbot for help country man"),
            Repo("308465464","baskara-site", cancio,""),
            Repo("279197414","bass", cancio,"A basic shopify theme"),
            Repo("272122490","bobba", cancio,"Tema padrão para repositórios do GitHub"),
            Repo("252852741","bootcamp-gostack-desafios", cancio,"Repositório contendo todos os desafios dos módulos do Bootcamp Gostack"),
            Repo("148372161","brModelo", cancio,"brModelo 3.0 (principal)"),
            Repo("312301806","CalcRaiz", cancio,""),
            Repo("234373073","casa-dos-meninos", cancio,"A website template"),
            Repo("308719877","chatwp", cancio,""),
            Repo("208436819","clasp", cancio,"Command Line Apps Script Projects"),
            Repo("205859508","cursos-devdojo", cancio,"Repositório de cursos do devmedia"),
            Repo("287946127","desafio-1-2020", cancio,""),
            Repo("288059636","desafio-2-2020", cancio,""),
            Repo("254227469","Desafio-Conceitos-do-Node.js", cancio,"Desafio go stack nível 01")
        )
        listRepos.adapter = ReposAdapter(this,repos)

    }

}

class ReposAdapter(private val context: Context, private val list: List<Repo>) :
    RecyclerView.Adapter<ReposAdapter.RepoVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoVH {
        val view = LayoutInflater.from(context).inflate(R.layout.item_repos, parent, false)
        return RepoVH(view)
    }

    override fun onBindViewHolder(holder: RepoVH, position: Int) {
        val repo = list[position]
            holder.itemView.findViewById<ImageView>(R.id.repoid1).setImageURI(Uri
                .parse(repo.owner.avatarUrl));
        holder.itemView.findViewById<TextView>(R.id.txt_name).text = repo.name
        holder.itemView.findViewById<TextView>(R.id.txt_user).text = repo.owner.login
        val button = holder.itemView.findViewById<Button>(R.id.about_repos)
        button.setOnClickListener {
            context.startActivity(Intent(context,AboutRepoActivit::class.java))
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class RepoVH(view: View) : RecyclerView.ViewHolder(view)

}

class Repo( val id:String, val name: String,  val owner: Owner, val description:String )
class Owner( val id:String, val login: String,  val avatarUrl: String )



/*

* */