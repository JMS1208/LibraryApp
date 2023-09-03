package com.study.libraryapp.domain.user.loan_history

import com.study.libraryapp.domain.user.User
import javax.persistence.*

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
