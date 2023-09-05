package com.minseok.data.repository.user

import com.minseok.data.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

//제네릭으로는 User와 primary key 타입이 들어감
//JpaRepository 를 상속하는 것만으로도 스프링 빈으로 등록됨
interface UserRepository : JpaRepository<User, Long>  {
    /*
    함수 이름보고 알아서 쿼리를 작성함
    find 라고 하면 하나를 반환하고,
    By 뒤에 붙는 필드 이름으로 찾음
     */
    fun findByName(name: String): Optional<User>


}