package com.study.libraryapp.domain.user

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
//    fun existsByName(name: String): Boolean

    /*
    find: 1건을 가져오는데 반환 타입은 객체가 될 수도 있고, Optional<T>가 될 수도 있다
    findAll: 쿼리의 결과물이 N개인 경우 사용. List<타입> 반환
    -> findAllByNameAndAge : where 절의 and 조건
    -> findAllByAgeBetween(startAge: Int, endAge: Int): where age between ? and ? 랑 같음
    -> findAllByAgeLessThan(age: Int): 미만
    -> GreaterThan: 초과
    -> GreaterThanEqual: 이상
    -> Between: 사이에
    -> LessThanEqual: 이하
    -> StartsWith: ~로 시작하는
    -> EndsWith: ~로 끝나는
    exists: 쿼리 결과가 존재하는 지 확인. 반환 타입은 Boolean
    -> existsByName 이런 식으로 만들면 됨
    count: SQL 의 결과 개수를 센다. 반환 타입은 Long
    -> countByAge
     */

}