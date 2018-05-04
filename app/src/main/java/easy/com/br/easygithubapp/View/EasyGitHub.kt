package easy.com.br.easygithubapp.View

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import easy.com.br.easygithubapp.Adapters.RepositoriesAdapter
import easy.com.br.easygithubapp.Model.Repository
import easy.com.br.easygithubapp.R
import kotlinx.android.synthetic.main.activity_easy_git_hub.*
import android.support.v7.widget.DividerItemDecoration
import android.widget.Toast
import easy.com.br.easygithubapp.Domain.Interfaces.IGithubRepositoriesService
import easy.com.br.easygithubapp.Model.RepositoriesResult
import easy.com.br.easygithubapp.Services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EasyGitHub : AppCompatActivity() {

    private var listRepository: RepositoriesResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub)

        val retrofitService = RetrofitService().Builder()
        val service = retrofitService.create<IGithubRepositoriesService>(IGithubRepositoriesService::class.java)
        val result = service.search()

        result.enqueue(object : Callback<RepositoriesResult> {
            override fun onFailure(call: Call<RepositoriesResult?>, t: Throwable?) {
                Toast.makeText(this@EasyGitHub, t.toString(), Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<RepositoriesResult>, response: Response<RepositoriesResult?>) {
                listRepository = response.body()

                Toast.makeText(this@EasyGitHub, listRepository?.items?.size.toString(), Toast.LENGTH_LONG).show()

                repositories_recycler_view.adapter = RepositoriesAdapter(listRepository?.items){}
            }
        })

        val mLayoutManager = LinearLayoutManager(applicationContext)
        repositories_recycler_view.layoutManager = mLayoutManager
        repositories_recycler_view.itemAnimator = DefaultItemAnimator()
        repositories_recycler_view.addItemDecoration(DividerItemDecoration(this, LinearLayoutManager.VERTICAL))
    }
}
