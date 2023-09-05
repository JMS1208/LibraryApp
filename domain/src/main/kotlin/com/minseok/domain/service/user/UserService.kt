package com.study.libraryapp.service.user


import com.minseok.data.entity.user.User
import com.minseok.data.repository.user.UserRepository
import com.study.libraryapp.dto.user.request.UserCreateRequest
import com.study.libraryapp.dto.user.request.UserUpdateRequest
import com.study.libraryapp.dto.user.response.UserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService (
    private val repository: UserRepository
){
    //아래 있는 함수가 시작될 때 start transaction; 을 대신 해줌 (트랜잭션 시작)
    //함수가 예외 없이 잘 끝났다면 commit
    //문제가 생기면 rollback 시켜줌
    //이때 IOException 과 같은 Checked Exception 은 롤백이 일어나지 않음
    @Transactional
    fun saveUser(request: UserCreateRequest) {
        val savedUser = repository.save(
            User(
            name = request.name,
            age = request.age
        )
        )

        println("유저 저장됨: $savedUser")
    }

    @Transactional(readOnly = true) //성능적으로 더 좋다함
    fun getUsers(): List<UserResponse> {
        //mapNotNull 쓰면 null 인 건 걸러서 리스트에 포함시키지 않음
        return repository.findAll().asSequence().filter {user->
            user.id != null
        }.mapNotNull { user->
            user?.let {
                UserResponse(it)
            }
        }.toList()
    }

    @Transactional
    fun updateUser(request: UserUpdateRequest) {
        //id 로 못 찾으면 예외 날려줌
        val user: User = repository.findById(request.id).orElseThrow {
            IllegalArgumentException()
        }

        user.name = request.name

        /*
        @Transaction의 영속성 컨텍스트 때문에
        Dirty Check 로 엔티티 변경을 감지해서 알아서 save 시켜줌
         */

//        repository.save(
//            user.copy(
//                name = request.name
//            )
//        )
    }

    @Transactional
    fun deleteUser(name: String) {

        // repository.existsByName(name) 이렇게 확인도 가능

        val user: User = repository.findByName(name).orElseThrow {
            IllegalArgumentException()
        }

        repository.delete(user)
    }
}