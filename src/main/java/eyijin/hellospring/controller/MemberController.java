package eyijin.hellospring.controller;

import eyijin.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired //Spring Container에 있는 것과 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
