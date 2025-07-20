package com.example.librarymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.librarymanagementsystem.entity.Member;
@Repository
public interface MemberRepo extends JpaRepository<Member, String> {

}
