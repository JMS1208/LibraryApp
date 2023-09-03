package com.study.libraryapp.domain.user.loan_history

import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserLoanHistoryRepository: JpaRepository<UserLoanHistory, Long> {
    //책이름에 맞고 is_return 이 false 인게 있는지
    fun existsByBookNameAndIsReturn(bookName: String, isReturn: Boolean): Boolean

//    fun findByUserIdAndBookName(userId: Long, bookName: String): Optional<UserLoanHistory>
}