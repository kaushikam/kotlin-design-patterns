package com.kaushikam.design.patterns.builder

data class Contact (
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val phone: Long?
) {
    constructor(builder: ContactBuilder): this(
        builder.firstName,
        builder.lastName,
        builder.email,
        builder.phone)
}

class ContactBuilder {
    var firstName: String? = null
        private set

    var lastName: String? = null
        private set

    var email: String? = null
        private set

    var phone: Long? =  null
        private set

    fun firstName(firstName: String) = apply { this.firstName = firstName }
    fun lastName(laststName: String) = apply { this.lastName = lastName }
    fun email(email: String) = apply { this.email = email }
    fun phone(phone: Long) = apply { this.phone = phone }
    fun build() = Contact(this)
}