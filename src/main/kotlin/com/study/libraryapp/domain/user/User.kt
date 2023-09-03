package com.study.libraryapp.domain.user


import com.study.libraryapp.domain.user.loan_history.UserLoanHistory
import javax.persistence.*
import javax.validation.constraints.NotBlank

/*
스프링이 User 객체와 user 테이블을 같은 것으로 바라보게 만듦
Entity의 의미는 저장되고, 관리되어야 하는 데이터를 의미함
 */
@Entity
data class User(
    //이 필드를 primary key 로 간주
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto Increment 전략과 동일함
    val id: Long? = null,
    //Column은 생략가능
    @Column(nullable = false, length = 20, name = "name") //키값이 같으면 name 생략가능 (그냥 명시하는 게 나을듯)
    var name: String? = null,
    @Column(nullable = true, name = "age")
    var age: Int? = null,
    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    var userLoanHistories: MutableList<UserLoanHistory> = mutableListOf()
) {
    fun loanBook(bookName: String) {
        userLoanHistories.add(
            UserLoanHistory(
                user = this@User,
                bookName = bookName
            )
        )
    }

    fun returnBook(bookName: String) {
        userLoanHistories
            .asSequence()
            .filter { history ->
                history.bookName == bookName
            }
            .first()
            .doReturn()
    }
}

