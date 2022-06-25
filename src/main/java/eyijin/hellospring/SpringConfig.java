package eyijin.hellospring;

import eyijin.hellospring.repository.MemberRepository;
import eyijin.hellospring.repository.MemoryMemberRepository;
import eyijin.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
