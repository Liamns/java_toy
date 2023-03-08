package io.loan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.loan.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
