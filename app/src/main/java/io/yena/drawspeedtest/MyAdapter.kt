package io.yena.drawspeedtest

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_square.view.*
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by yenachoi on 2019-10-30.
 */
class MyAdapter : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    private val startTime: Date = Calendar.getInstance().time
    private var list: ArrayList<Int> = arrayListOf()

    init {
        var red = 255
        var green = 255
        var blue = 255

        for (i in 0..11) {
            red -= 20
            green -= 20
            blue -= 10
            val c = Color.rgb(red, green, blue)

            list.add(c)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_square, parent, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val gapTime = (Calendar.getInstance().time.time - startTime.time)
        holder.bind(list[position], gapTime)
    }

    fun getDrawable(color: Int): GradientDrawable {
        val shape = GradientDrawable()
        shape.shape = GradientDrawable.RECTANGLE
        shape.setColor(color) // 입력받은 색상으로 지정
        return shape
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(color: Int, gapTime: Long) {
            itemView.tvItemSquare.apply{
                background = getDrawable(color)
//                background = context.getDrawable(R.drawable.background)
                text = gapTime.toString()
            }
        }
    }
}