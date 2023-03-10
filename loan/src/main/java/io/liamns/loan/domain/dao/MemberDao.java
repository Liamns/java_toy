package io.liamns.loan.domain.dao;

import io.liamns.loan.domain.entity.Member;

public interface MemberDao {

    Member registerMember(Member member);

    Member getMember(Integer id);
}
