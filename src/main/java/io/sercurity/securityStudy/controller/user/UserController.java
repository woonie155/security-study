package io.sercurity.securityStudy.controller.user;

import io.sercurity.securityStudy.domain.Account;
import io.sercurity.securityStudy.domain.AccountDto;
import io.sercurity.securityStudy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder encoder;


    @GetMapping("/mypage")
    public String myPage() throws Exception {

        return "user/mypage";
    }

    @GetMapping("/users")
    public String createUser(){
        return "user/login/register";
    }

    @PostMapping("/users")
    public String createUser(AccountDto dto){
        ModelMapper modelMapper = new ModelMapper();
        Account account = modelMapper.map(dto, Account.class);
        account.setPassword(encoder.encode(account.getPassword()));

        userService.createUser(account);

        return "redirect:/";
    }
}