package ru.skillbranch.devintensive.models

import java.util.*

data class User(
    val id: String,
    var firstName: String?,
    var lastName: String?,
    var avatar: String?,
    var rating: Int = 0,
    var respect: Int = 0,
    val lastVisit: Date? = null,
    val isOnline: Boolean = false
) {
    constructor(id: String, firstName: String?, lastName: String?) : this(
        id = id,
        firstName = firstName,
        lastName = lastName,
        avatar = null
    )

    constructor(id: String) : this(id, "John", "Doe")

    init {
        println(
            "It`s Alive!!!\n" +
                    "${if (lastName == "Doe") "His name is $firstName $lastName" else "And his name is $firstName $lastName!!!"}\n"
        )
    }

    companion object Factory {
        private var lastId: Int = -1
        fun makeUser(fullName: String?): User {
            lastId += 1

            if (fullName == null) {
                return User(id = lastId.toString(), firstName = "", lastName = "")
            }

            val parts = fullName.split(" ")

            return when (parts.size) {
                0 -> User(id = lastId.toString(), firstName = "", lastName = "")
                1 -> User(id = lastId.toString(), firstName = parts[0], lastName = "")
                else -> User(id = lastId.toString(), firstName = parts[0], lastName = parts[1])
            }
        }
    }
}