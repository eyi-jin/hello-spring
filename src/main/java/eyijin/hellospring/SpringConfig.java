package eyijin.hellospring;

import eyijin.hellospring.repository.JdbcMemberRepository;
import eyijin.hellospring.repository.JdbcTemplateMemberRepository;
import eyijin.hellospring.repository.MemberRepository;
import eyijin.hellospring.repository.MemoryMemberRepository;
import eyijin.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private final DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new JdbcMemberRepository(dataSource);
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
