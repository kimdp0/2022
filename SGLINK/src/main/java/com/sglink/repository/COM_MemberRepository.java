package com.sglink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sglink.entity.COM_Member;

<<<<<<< HEAD
public interface COM_MemberRepository extends JpaRepository<COM_Member,String> {
	COM_Member findByCOMUSER_EMAIL(String COMUSER_EMAIL);

}
=======
public interface COM_MemberRepository extends JpaRepository<COM_Member, String> {
	COM_Member findByComuserEmail(String email);
}
>>>>>>> branch 'sub' of https://github.com/SilverCastle123/project.git
