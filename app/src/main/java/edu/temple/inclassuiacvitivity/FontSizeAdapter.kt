package edu.temple.inclassuiacvitivity

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class FontSizeAdapter(_context: Context, _sizes: Array<Int>) : BaseAdapter() {

    private val context = _context
    private val fontSizes = _sizes

    // what does this mean
    override fun getCount() = fontSizes.size

    // for a given index return the element at that index
    override fun getItem(p0: Int) = fontSizes[p0]

    // for a given index get its ID
    override fun getItemId(p0: Int) = p0.toLong()

    // the job of get view is to reurn a view whose data corresponds to the element in the collection found at this position
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return (getDropDownView(position, convertView, parent) as TextView).apply {
            textSize = 24f
        }
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val textView: TextView

        if(convertView == null) {
            textView = TextView(context)
            textView.setPadding(20,20,0,20)
        }
        else {
            textView = convertView as TextView
        }

        textView.text = fontSizes[position].toString()
        textView.textSize = fontSizes[position].toFloat()
        return textView
    }

}