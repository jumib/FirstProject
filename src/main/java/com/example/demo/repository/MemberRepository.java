package com.example.demo.repository;

import com.example.demo.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findByUserId(String userId);

    @Query("select m.userNo, m.userPw, m.userName, m.regDate from Member m")
    public List<Object[]> listAllMember();

    // public Member findByUserId(String findByUserId);


//    <jdbc버전>
//    public boolean idcheck(Member member) throws Exception {
//
//        String query = "select userId from member where userId=? ";
//        List<Member> results =  jdbcTemplate.query(query, new RowMapper<Member>(){
//                    @Override
//                    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
//                        Member members = new Member();
//
//                        member.setUserId(rs.getString("id"));
//
//                        return member;
//                    }
//                }
//                , member.getUserId());
//        return results.isEmpty() ? true : false;
//    }
}