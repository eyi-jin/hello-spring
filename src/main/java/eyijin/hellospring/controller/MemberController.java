package eyijin.hellospring.controller;

import eyijin.hellospring.domain.Member;
import eyijin.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //Spring Container에 있는 것과 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new") //주로 조회할 때 사용
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new") //데이터를 form 같은곳에 넣어서 전달할 때 사용
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }
}
