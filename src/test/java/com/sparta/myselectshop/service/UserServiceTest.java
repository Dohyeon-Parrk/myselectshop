// package com.sparta.myselectshop.service;
//
// import static org.awaitility.Awaitility.*;
// import static org.junit.jupiter.api.Assertions.*;
//
// import org.junit.jupiter.api.DisplayName;
// import org.junit.jupiter.api.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.junit.jupiter.MockitoExtension;
// import org.springframework.security.crypto.password.PasswordEncoder;
//
// import com.sparta.myselectshop.dto.SignupRequestDto;
// import com.sparta.myselectshop.repository.UserRepository;
//
// @ExtendWith(MockitoExtension.class)
// class UserServiceTest {
//
// 	@Mock
// 	private UserRepository userRepository;
//
// 	@Mock
// 	private PasswordEncoder passwordEncoder;
//
// 	@InjectMocks
// 	private UserService userService;
//
// 	@Test
// 	@DisplayName("회원가입 성공")
// 	void signupSuccess(){
// 		// given
// 		SignupRequestDto signupRequestDto = new SignupRequestDto();
// 		signupRequestDto.setUsername("testName");
// 		signupRequestDto.setPassword("testPassword");
// 		signupRequestDto.setEmail("testEmail");
// 		signupRequestDto.setAdmin(false);
//
// 		given(userRepository.findByUsername(signupRequestDto.getUsername())).willReturn
//
// 		// when
//
// 		// then
// 	}
//
// }
//
//
//
//
//
//
//
//
//
//
//
//
//
