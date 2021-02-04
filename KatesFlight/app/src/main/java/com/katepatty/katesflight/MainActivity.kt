package com.katepatty.katesflight

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // recyclerview is as same as ViewGroup or Container
        rcv.adapter = KsAdapter() // data pass to left
        rcv.layoutManager =  LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) // UI

    }

}

// 單一欄位類別
class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val txt: TextView = itemView.findViewById(R.id.txt)

    fun setData(data: Int) {
        txt.text = "This is flight number: BA $data"
    }

}

// 繫結資料與UI的類別
class KsAdapter : RecyclerView.Adapter<MyViewHolder>() {

    //fake data
    private val data = (1111..9999).shuffled().toList()

    //private val flack = (1000..9999).random().toString().toList()

    // random id
    private fun randomStr(): String = List(2) {
        ('A'..'Z').random()
    }.joinToString("")

    // random id
    private fun randomId(): String = List(4) {
        ('0'..'9').random()
    }.joinToString("")


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        var g = MyViewHolder(
                LayoutInflater.from(parent.context)
                        .inflate(
                                R.layout.item_text,
                                parent,
                                false
                        )
        )

        return g
    }

    //override fun getItemCount() = data.size
    override fun getItemCount() =data.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.setData(data[position])

    }

}