package io.liamns.loan.domain.dao;

import java.util.List;

import io.liamns.loan.domain.entity.Member;
import io.liamns.loan.domain.entity.vo.RedemptionMethod;

public interface MemberDao {

    Member registerMember(Integer id, long loan, double min, double max, int redemptionYear,
            RedemptionMethod redemptionMethod);

    Member getMember(Integer id);

    List<Member> getMemberAll();
}
