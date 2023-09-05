package com.minseok.data.entity.user.loan_history

import com.minseok.data.entity.user.User
import jakarta.persistence.*

@Entity
data class UserLoanHistory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne
    @JoinColumn(nullable = false)
    val user: User? = null,
    @Column(nullable = false, name = "book_name")
    val bookName: String? = null,
    @Column(nullable = false, name = "is_return")
    var isReturn: Boolean = false //1이면 true
) {
    fun doReturn() {
        this.isReturn = true
    }

}
