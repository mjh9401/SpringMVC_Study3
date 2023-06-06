package hello.itemService.web;

import hello.itemService.domain.member.Member;
import hello.itemService.domain.member.MemberRepository;
import hello.itemService.web.session.SessionManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberRepository memberRepository;
    private final SessionManager sessionManager;


    @GetMapping("/")
    public String homeLogin(@SessionAttribute(name=SessionConst.LOGIN_MEMBER,required = false) Member loginMember, Model model){

        // 세션에 회원 데이터가 없으면 home
        if(loginMember == null){
            return "home";
        }

        // 세션이 유지되면 로그인으로 이동동
        model.addAttribute("member",loginMember);
        return "loginHome";
    }
}
