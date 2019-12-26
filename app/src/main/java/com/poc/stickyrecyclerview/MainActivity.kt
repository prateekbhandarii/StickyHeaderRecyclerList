package com.poc.stickyrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    lateinit var mRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mRecyclerView = findViewById<RecyclerView>(R.id.mRecyclerView)
        mRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        var personRepo = PersonRepository()
        var people: List<Person> = personRepo.getPeopleSorted()

        mRecyclerView.adapter = PersonAdapter(people)

        var sectionItemDecoration: RecyclerSectionItemDecoration = RecyclerSectionItemDecoration(
            resources.getDimensionPixelSize(R.dimen.recycler_section_header_height),
            true, RecyclerSectionItemDecorator(people)
        )
        mRecyclerView.addItemDecoration(sectionItemDecoration)
    }

    class RecyclerSectionItemDecorator(private var people: List<Person>) :
        RecyclerSectionItemDecoration.SectionCallBack {

        override fun isSection(position: Int): Boolean {
            return position == 0 || people[position].getLastNames().codePointAt(0) != people[position - 1].getLastNames().codePointAt(0)
        }

        override fun getSectionHeader(position: Int): String {
            return people[position].getLastNames().subSequence(0,1) as String
        }
    }
}
