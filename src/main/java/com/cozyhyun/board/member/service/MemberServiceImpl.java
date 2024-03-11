package com.cozyhyun.board.member.service;

import com.cozyhyun.board.global.error.NotFoundException;
import com.cozyhyun.board.global.response.ResponseStatus;
import com.cozyhyun.board.member.domain.dto.MemberCreateDto;
import com.cozyhyun.board.member.domain.dto.MemberReadDto;
import com.cozyhyun.board.member.domain.dto.MemberUpdateDto;
import com.cozyhyun.board.member.domain.entity.Member;
import com.cozyhyun.board.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;

    // member create
    @Transactional
    public void createMember(MemberCreateDto dto) {
        final Member member = Member.dtoToEntity(dto);
        memberRepository.save(member);
    }

    // member read
    @Transactional
    public MemberReadDto getMemberByMemberId(Long memberId) {
        final Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));
        return Member.entityToDto(member);
    }

    // member update
    @Transactional
    public void updateMember(Long memberId, MemberUpdateDto dto){
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        member.updateMember(dto);
    }

    // member delete
    @Transactional
    public void deleteMemberByMemberId(Long memberId) {
        Member member = memberRepository
                .findById(memberId)
                .orElseThrow(() -> new NotFoundException(ResponseStatus.FAIL_NOT_FOUND));

        memberRepository.delete(member);
    }
}
