package com.poc.stickyrecyclerview

import java.util.*

class Person(private var firstName: String, private var lastName: String) : Comparable<Person> {

    private var NAME_DISPLAY: String = "%s, %s"

     fun getLastNames(): String {
        return lastName
    }

     fun getFirstNames(): String {
        return firstName
    }

     fun getFullNames(): String {
        return String.format(Locale.getDefault(), NAME_DISPLAY, getLastNames(), getFirstNames())
    }

    override fun compareTo(other: Person): Int {
        return getLastNames().compareTo(other.getLastNames())
    }
}