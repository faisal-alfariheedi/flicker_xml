package com.example.flicker_xml

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rv: RecyclerView
    lateinit var ser: Button
    lateinit var ed: EditText
    lateinit var spn: Spinner
    var sel=0
    var sell=arrayListOf(10,50,100)
//    var imgarr=arrayListOf<image>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        if (spn != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,sell )
            spn.adapter = adapter
            spn.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, position: Int, id: Long) {
                    sel = position
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    sel=0
                }
            }
        }
        ser.setOnClickListener{
            search()
        }

    }

    fun init() {
        ser=findViewById(R.id.serch)
        ed=findViewById(R.id.ed)
        spn=findViewById(R.id.spn)
        rv=findViewById(R.id.rvm)
        rv.adapter=RVAdapter(image.imgarr,this)
        rv.layoutManager= GridLayoutManager(this,2)
//        rv.layoutManager= LinearLayoutManager(this)
    }
    fun search() {
        val apif = APIClient().getClient()?.create(APIInterface::class.java)
        image.imgarr.clear()
        CoroutineScope(Dispatchers.IO).launch {
            if (apif != null) {
                apif.getdat("flickr.photos.search","33a9d39f0edb9d9c75cdf2a50fa983cd",ed.text.toString(),sell[sel].toString(),"xml",)
                    .enqueue(object : Callback<MethodResponse> {
                        override fun onResponse(call: Call<MethodResponse>, response: Response<MethodResponse>
                        ) {
//                            Log.d("responimg", "onResponse: ${response}")
//                            Log.d("responimg", "onResponse: ${response.body()}")
                            var a = response.body()
                            if (a != null) {
                                for (i in a.params.param.value.string.photos.photo) {

                                    image.imgarr.add(
                                        image(
                                            i.title,
                                            "https://farm${i.farm}.staticflickr.com/${i.server}/${i.id}_${i.secret}.jpg"
                                        )
                                    )

                                }
                            }
                            rv.adapter?.notifyDataSetChanged()

                        }

                        override fun onFailure(call: Call<MethodResponse>, t: Throwable) {
                            Log.d("responimg", "onResponse: ${t}")
                            Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show();
                        }

                    })
            }
        }
    }
    //https://farm$farmID.staticflickr.com/$serverID/${id}_$secret.jpg
}