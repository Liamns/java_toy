package io.loan.store;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import io.loan.entity.dto.MemberDto;

public interface MemberRepository extends JpaRepository<MemberDto, UUID> {

}
