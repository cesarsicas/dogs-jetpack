package com.cesarsicas.dogsjetpack.custom

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.cesarsicas.dogsjetpack.R
import kotlinx.android.synthetic.main.information_view.view.*

class InformationViewFacelift @JvmOverloads constructor(
    context: Context,
    val attrs: AttributeSet? = null,
    defStyle: Int = 0,
    defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes) {


    init {
        LayoutInflater.from(context).inflate(R.layout.information_view, this, true)

        orientation = VERTICAL


        this.attrs?.let {


            val typedArray = context.obtainStyledAttributes(it, R.styleable.InformationVewFacelift, 0, 0)

            val label = resources.getText(typedArray
                .getResourceId(R.styleable.InformationVewFacelift_information_label, R.string.default_information_label))


            val content = resources.getText(typedArray.getResourceId(R.styleable
                .InformationVewFacelift_information_content,
                R.string.default_information_content))

            informationViewLabel.text = label
            informationViewContent.text = content

            typedArray.recycle()
        }
    }




}