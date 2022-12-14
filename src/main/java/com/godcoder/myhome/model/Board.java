//데이터베이스 연동을 위한 모델클래스

package com.godcoder.myhome.model;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Board {
    @Id //Id가 pk라는 것을 알려주기 위해
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment 사용시 알아서 값 증가됨.
    private Long id;
    @NotNull
    @Size(min=2, max=30, message = "제목은 2자이상 30자 이하입니다.")
    private String title;
    private String content;
}
