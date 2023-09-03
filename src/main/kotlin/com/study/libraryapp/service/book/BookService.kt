package com.study.libraryapp.service.book

import com.study.libraryapp.domain.book.Book
import com.study.libraryapp.dto.book.request.BookCreateRequest
import com.study.libraryapp.domain.book.BookRepository
import com.study.libraryapp.domain.user.User
import com.study.libraryapp.domain.user.UserRepository
import com.study.libraryapp.domain.user.loan_history.UserLoanHistory
import com.study.libraryapp.domain.user.loan_history.UserLoanHistoryRepository
import com.study.libraryapp.dto.book.request.BookLoanRequest
import com.study.libraryapp.dto.book.request.BookReturnRequest
import net.bytebuddy.pool.TypePool.Resolution.Illegal
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.IllegalArgumentException

@Service
class BookService(
    private val bookRepository: BookRepository,
    private val userRepository: UserRepository,
    private val loanHistoryRepository: UserLoanHistoryRepository
) {

    @Transactional
    fun saveBook(request: BookCreateRequest) {
        bookRepository.save(
            Book(
                name = request.name
            )
        )
    }

    @Transactional
    fun loanBook(request: BookLoanRequest) {

        val book: Book = bookRepository.findByName(request.bookName).orElseThrow {
            //그런 책이 없음
            throw IllegalArgumentException()
        }

        if(loanHistoryRepository.existsByBookNameAndIsReturn(request.bookName, false)) {
            //누군가가 이미 빌린 책
            throw IllegalArgumentException()
        }

        val user: User = userRepository.findByName(request.userName).orElseThrow {
            //그런 유저가 없음
            throw IllegalArgumentException()
        }

        user.loanBook(bookName = book.name!!)

//        loanHistoryRepository.save(
//            UserLoanHistory(
//                user = user,
//                bookName = book.name
//            )
//        )
    }

    @Transactional
    fun returnBook(request: BookReturnRequest) {
        val user: User = userRepository.findByName(request.userName).orElseThrow {
            IllegalArgumentException()
        }

        user.returnBook(request.bookName)
//        val history: UserLoanHistory = loanHistoryRepository.findByUserIdAndBookName(
//            user.id!!,
//            request.bookName
//        ).orElseThrow {
//            IllegalArgumentException()
//        }

        //Dirty Check 때문에 따로 save 해주지 않아도 됨
//        history.doReturn()
    }

}