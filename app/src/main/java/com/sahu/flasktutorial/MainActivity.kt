package com.sahu.flasktutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.lang.Exception
import java.util.HashMap

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text = "s"
        /*val url = "http://127.0.0.1:5000/hello"
        //val queue = Volley.newRequestQueue(this@MainActivity)
        val jsonParams  = JSONObject()
        jsonParams.put("name", nametxt.text.toString())
        submitbtn.setOnClickListener {
            val jsonRequest =
                object : JsonObjectRequest(Request.Method.POST, url, jsonParams,Response.Listener {
                Toast.makeText(this@MainActivity, "2nd check", Toast.LENGTH_LONG).show()
                try{
                    Toast.makeText(this@MainActivity, "2nd check", Toast.LENGTH_LONG).show()
                    textView.text = it.getString("greeting")
                }
                catch (e : Exception){
                    Toast.makeText(this@MainActivity, "Some Error occured", Toast.LENGTH_LONG).show()
                }
            }, Response.ErrorListener {
                Toast.makeText(this@MainActivity, " response error listener", Toast.LENGTH_LONG).show()
            }) {
                    override fun getHeaders(): MutableMap<String, String> {
                        val headers = HashMap<String, String>()
                        headers["Content-type"] = "application/json"
                        return headers
                    }
            }
            //queue.add(jsonRequest)
        }*/
        val queue = Volley.newRequestQueue(this@MainActivity)
        val url = "http://192.168.43.230:5000/hello"
        val jsonParams  = JSONObject()
        var bookId: String? = "100"
        bookId = "nametxt.text.toString()"
        jsonParams.put("name", bookId)
        submitbtn.setOnClickListener {
            val jsonRequest =
                object : JsonObjectRequest(Method.POST, url, jsonParams, Response.Listener {
                    try {

                        val str = it.getString("greeting")
                        textView.text = str
                    }
                    catch(e:Exception){
                        Toast.makeText(this@MainActivity, "catch exception", Toast.LENGTH_LONG).show()
                    }
                }, Response.ErrorListener {
                    Toast.makeText(this@MainActivity, "error listener", Toast.LENGTH_LONG).show()
                })
                {
                    override fun getHeaders(): MutableMap<String, String> {
                        val headers = HashMap<String, String> ()
                        headers["Content-type"] = "application/json"
                        return headers
                    }
                }
            queue.add(jsonRequest)
        }
        /*Always connect your phone to the same network as that of laptop or else u ll get a problem"*/
        /*val queue = Volley.newRequestQueue(this@MainActivity)
        val url = "http://13.235.250.119/v1/book/get_book/"
        val jsonParams  = JSONObject()
        jsonParams.put("book_id", "102")
        submitbtn.setOnClickListener {
            val jsonRequest =
                object : JsonObjectRequest(Method.POST, url, jsonParams, Response.Listener {
                    try {
                        val success = it.getBoolean("success")
                        if(success) {
                            val bookJsonObject = it.getJSONObject("book_data")
                            Toast.makeText(this@MainActivity, "success is true", Toast.LENGTH_LONG)
                                .show()
                            textView.text = bookJsonObject.getString("name")
                        }
                        else{
                            Toast.makeText(this@MainActivity, "success is false", Toast.LENGTH_LONG).show()
                    }
                } catch(e:Exception){
                    Toast.makeText(this@MainActivity, "catch exception", Toast.LENGTH_LONG).show()
                }
        }, Response.ErrorListener {
            Toast.makeText(this@MainActivity, "error listener", Toast.LENGTH_LONG).show()
        })
        {
            override fun getHeaders(): MutableMap<String, String> {
                val headers = HashMap<String, String> ()
                headers["Content-type"] = "application/json"
                headers["token"] = "d066812a22c5cb"
                return headers
            }
        }
        queue.add(jsonRequest)
    }*/

    }
}
