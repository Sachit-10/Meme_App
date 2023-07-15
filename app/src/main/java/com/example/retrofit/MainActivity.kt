package com.example.retrofit

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    var binding:ActivityMainBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        getData()

        binding?.btNextmeme?.setOnClickListener(){
            getData()
        }


    }

    private fun getData() {

        var progressdialog = ProgressDialog(this)
        progressdialog.setMessage("PLease wait while data is fetching")
        progressdialog.show()

        Retrofit_Instance.apiinterface.getData().enqueue(object : retrofit2.Callback<responsedataclass?> {
            override fun onResponse(
                call: Call<responsedataclass?>,
                response: Response<responsedataclass?>
            ) {

                binding?.tvTitle?.text = response.body()?.title
                binding?.tvAuthor?.text = response.body()?.author


                Glide.with(this@MainActivity).load(response.body()?.url).into(binding!!.ivMeme);

                progressdialog.dismiss()
            }

            override fun onFailure(call: Call<responsedataclass?>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.localizedMessage}" , Toast.LENGTH_SHORT).show()       //t.localisedmessage will show the exception
                progressdialog.dismiss()
            }
        })

        }


}


