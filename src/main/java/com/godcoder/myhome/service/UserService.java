package com.godcoder.myhome.service;

import com.godcoder.myhome.model.Role;
import com.godcoder.myhome.model.User;
import com.godcoder.myhome.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User save(User user) {
        //user를 그냥 저장하게 되면 사용자 이름과 패스워드만 저장됨.
        //사용자가 저장한 비밀번호를 encoder를 이용해서 인코딩 하게되면 암호화가 됨.
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        //기본적으로 회원가입을 하면 활성화된 상태로 바꿔줘야됨.
        user.setEnabled(true);
        Role role = new Role();
        role.setId(1l);
        user.getRoles().add(role);
        return userRepository.save(user);
    }

}
