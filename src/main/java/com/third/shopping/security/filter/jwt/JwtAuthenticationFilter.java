package com.third.shopping.security.filter.jwt;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.third.shopping.model.entity.MemberEntity;
import com.third.shopping.security.auth.PrincipalDetails;
import com.third.shopping.security.jwt.JwtToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {

        // request에 있는 username과 password를 파싱해서 자바 Object로 받기
        try {
            ObjectMapper om = new ObjectMapper();
            MemberEntity user = om.readValue(request.getInputStream(), MemberEntity.class); // user에 요청받은 정보 담김

            // 유저네임패스워드 토큰 생성
            UsernamePasswordAuthenticationToken authenticationToken =
                    new UsernamePasswordAuthenticationToken(user.getId(), user.getPw()); //우리가 원하는 형태의 토큰객체

            Authentication authentication = authenticationManager.authenticate(authenticationToken);// 로그인 인증 처리
                //authenticationManager이 로그인 인증처리를 대신해줌

            return authentication; // 시큐리티가 사용하기 위한 형태
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void successfulAuthentication(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain,
            Authentication authResult) throws IOException, ServletException {

            PrincipalDetails principalDetailis = (PrincipalDetails) authResult.getPrincipal();
            System.out.println("test");
            //response.addHeader("Authorization", "Bearer "+jwtToken);
            response.getWriter().append("Authorization:").append("Bearer " + JwtToken.createToken(principalDetailis.getUserIdx()) + "");

    }


}