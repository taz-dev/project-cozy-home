package com.third.shopping.security.auth;


import com.third.shopping.model.entity.MemberEntity;
import com.third.shopping.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrincipalDetailService implements UserDetailsService {


    private final MemberService memberService;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException{
        MemberEntity user = memberService.authMember(id);
        if(user == null){
            throw new UsernameNotFoundException("사용자 아이디를 확인해 주세요.");
        }
        return new PrincipalDetails(user);
    }
}
