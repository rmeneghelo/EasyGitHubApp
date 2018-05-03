package easy.com.br.easygithubapp.Application

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import easy.com.br.easygithubapp.Adapters.RepositoriesAdapter
import easy.com.br.easygithubapp.Model.Repository
import easy.com.br.easygithubapp.R
import kotlinx.android.synthetic.main.activity_easy_git_hub.*
import android.support.v7.widget.DividerItemDecoration



class EasyGitHub : AppCompatActivity() {

    private var repositoriesList: MutableList<Repository> = arrayListOf()
    private var mAdapter: RepositoriesAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub)

        prepareRepositoriesData()
        mAdapter = RepositoriesAdapter(repositoriesList){}

        val mLayoutManager = LinearLayoutManager(applicationContext)
        repositories_recycler_view.layoutManager = mLayoutManager
        repositories_recycler_view.itemAnimator = DefaultItemAnimator()
        repositories_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
        repositories_recycler_view.adapter = mAdapter
    }

    private fun prepareRepositoriesData(){
        var repository = Repository("Xuxa Repository", "Descriptiooooooooooooooooon", "Xuxa",
                "Photo", 5, 90)
        repositoriesList.add(repository)

        var repository2 = Repository("Xuxa2 Repository", "Descriptiooooooooooooooooon 2", "Xuxa 2",
                "Photo 2", 3, 50)
        repositoriesList.add(repository2)
    }
}
