package com.example.demo.repository;

import com.example.demo.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<UserData, Long> {

//    @Procedure(procedureName = "adduser")
//    void addUser(@Param("p_name") Map<String, Object> nama);

//    @Procedure(procedureName = "adduser")
//    void insertUser(String json);

    @Transactional
    @Modifying
    @Query(
            value = "CALL adduser(CAST(:json AS JSONB))",
            nativeQuery = true
    )
    void insertUser(@Param("json") String json);
}