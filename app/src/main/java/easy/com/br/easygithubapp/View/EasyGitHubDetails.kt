package easy.com.br.easygithubapp.View

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import easy.com.br.easygithubapp.R

class EasyGitHubDetails: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_easy_git_hub_details)

        Toast.makeText(applicationContext,"Clicked on item ${intent.getStringExtra("repositoryId")}", Toast.LENGTH_LONG).show()
    }
}