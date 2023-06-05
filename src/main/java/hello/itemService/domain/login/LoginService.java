package hello.itemService.domain.login;

import hello.itemService.domain.member.Member;
import hello.itemService.domain.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    /**
     * @return null이면 로그인 실패
     */

    public Member login(String loginId, String loginPw){
//        Optional<Member> findMemberOptional = memberRepository.findByLoginId(loginId);
//        Member member = findMemberOptional.get();
//        if(member.getPassword().equals(loginPw)){
//            return member;
//        }else {
//            return null;
//        }

        return memberRepository.findByLoginId(loginId)
                .filter(m->m.getPassword().equals(loginPw))
                .orElse(null);
    }
}
