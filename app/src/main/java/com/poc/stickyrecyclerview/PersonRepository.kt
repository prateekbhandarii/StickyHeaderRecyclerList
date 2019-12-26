package com.poc.stickyrecyclerview

import java.util.*
import kotlin.collections.ArrayList

class PersonRepository{

   fun getPeople() : List<Person>{

       var people = ArrayList<Person>()
       people.add(Person("George", "Washington"))
       people.add(Person("John", "Adams"))
       people.add(Person("Thomas", "Jefferson"))
       people.add(Person("James", "Madison"))
       people.add(Person("James", "Monroe"))
       people.add(Person("John Quincy", "Adams"))
       people.add(Person("Andrew", "Jackson"))
       people.add(Person("Martin", "Van Buren"))
       people.add(Person("William", "Harrison"))
       people.add(Person("John", "Tyler"))
       people.add(Person("Zachary", "Taylor"))
       people.add(Person("Millard", "Fillmore"))
       people.add(Person("Franklin", "Pierce"))
       people.add(Person("James", "Buchanan"))
       people.add(Person("Abraham", "Lincoln"))
       people.add(Person("Andrew", "Johnson"))
       people.add(Person("Ulysses", "Grant"))
       people.add(Person("Rutherford", "Hayes"))
       people.add(Person("James", "Garfield"))
       people.add(Person("Chester", "Arthur"))
       people.add(Person("Grover", "Cleveland"))
       people.add(Person("Benjamin", "Harrison"))
       people.add(Person("William", "McKinley"))
       people.add(Person("Theodore", "Roosevelt"))
       people.add(Person("William", "Taft"))
       people.add(Person("Woodrow", "Wilson"))
       people.add(Person("Warren", "Harding"))
       people.add(Person("Calvin", "Coolidge"))
       people.add(Person("Herbert", "Hoover"))
       people.add(Person("Harry", "Truman"))
       people.add(Person("Dwight", "Eisenhower"))
       people.add(Person("John", "Kennedy"))
       people.add(Person("Lyndon", "Johnson"))
       people.add(Person("Richard", "Nixon"))
       people.add(Person("Gerald", "Ford"))
       people.add(Person("Jimmy", "Carter"))
       people.add(Person("Ronald", "Reagan"))
       people.add(Person("George H.W.", "Bush"))
       people.add(Person("Bill", "Clinton"))
       people.add(Person("George W.", "Bush"))
       people.add(Person("Barack", "Obama"))
       people.add(Person("Donald", "Trump"))
       return people
   }

    fun getPeopleSorted(): List<Person>{
        var people = getPeople()
        Collections.sort(people)
        return people
    }
}