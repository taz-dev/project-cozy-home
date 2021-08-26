package com.third.shopping.model.vo;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Alias("MemberVO")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {

    private int mem_idx;
    private String id;
    private String name;
    private String addr;
    private String tel;
    private String isAdmin;
    private String addr_detail;

}