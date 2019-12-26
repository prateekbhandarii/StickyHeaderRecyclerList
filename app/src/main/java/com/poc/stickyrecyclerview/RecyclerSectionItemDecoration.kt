package com.poc.stickyrecyclerview

import android.graphics.Canvas
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.max

class RecyclerSectionItemDecoration(
    headerHeight: Int,
    sticky: Boolean, @NonNull sectionCallBack: SectionCallBack
) : RecyclerView.ItemDecoration() {

    private var headerOffSet: Int = headerHeight
    private var sticky: Boolean = sticky
    private var sectionCallBack: SectionCallBack = sectionCallBack

    private lateinit var headerView: View
    private lateinit var header: TextView

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        var pos: Int = parent.getChildAdapterPosition(view)
        if (sectionCallBack.isSection(pos))
            outRect.top = headerOffSet
    }

    override fun onDrawOver(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDrawOver(c, parent, state)
        headerView = inflateHeaderView(parent)
        header = headerView.findViewById(R.id.mTextView)
        fixLayoutSize(headerView, parent)

        var previousHeader = ""
        for (i in 0..parent.childCount) {
            if (parent.getChildAt(i) != null) {
                val child: View = parent.getChildAt(i)
                val position: Int = parent.getChildAdapterPosition(child)

                var title: String = sectionCallBack.getSectionHeader(position)
                header.text = title
                if (previousHeader != title || sectionCallBack.isSection(position)) {
                    drawHeader(c, child, headerView)
                    previousHeader = title
                }
            }
        }
    }

    private fun drawHeader(c: Canvas, child: View, headerView: View) {
        c.save()
        if (sticky) {
            c.translate(0F, max(0, child.top - headerView.height).toFloat())
        } else {
            c.translate(0F, (child.top - headerView.height).toFloat())
        }
        headerView.draw(c)
        c.restore()
    }

    private fun inflateHeaderView(parent: RecyclerView): View {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.list_sticky_section, parent, false)
    }

    private fun fixLayoutSize(view: View, parent: ViewGroup) {
        val widthSpec: Int =
            View.MeasureSpec.makeMeasureSpec(parent.width, View.MeasureSpec.EXACTLY)
        val heightSpec: Int =
            View.MeasureSpec.makeMeasureSpec(parent.height, View.MeasureSpec.UNSPECIFIED)
        val childWidth: Int = ViewGroup.getChildMeasureSpec(
            widthSpec,
            parent.paddingLeft + parent.paddingRight,
            view.layoutParams.width
        )
        val childHeight: Int =
            ViewGroup.getChildMeasureSpec(
                heightSpec,
                parent.paddingTop + parent.paddingBottom,
                view.layoutParams.height
            )

        view.measure(childWidth, childHeight)
        view.layout(0, 0, view.measuredWidth, view.measuredHeight)
    }

    interface SectionCallBack {
        fun isSection(position: Int): Boolean
        fun getSectionHeader(position: Int): String
    }
}