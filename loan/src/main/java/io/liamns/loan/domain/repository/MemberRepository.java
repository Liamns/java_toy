package io.liamns.loan.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.liamns.loan.domain.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

}
