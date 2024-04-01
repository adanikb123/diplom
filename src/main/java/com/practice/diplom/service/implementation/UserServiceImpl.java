package com.practice.diplom.service.implementation;

import com.practice.diplom.config.JwtService;
import com.practice.diplom.dto.JwtResponseDto;
import com.practice.diplom.dto.LoginRequestDto;
import com.practice.diplom.dto.UserRequestDto;
import com.practice.diplom.dto.UserResponseDto;
import com.practice.diplom.entity.User;
import com.practice.diplom.entity.enums.RoleType;
import com.practice.diplom.exception.AlreadyExistException;
import com.practice.diplom.exception.NotFoundException;
import com.practice.diplom.mapper.UserMapper;
import com.practice.diplom.repository.UserRepository;
import com.practice.diplom.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Lazy
    @Autowired
    private AuthenticationManager authenticationManager;

    @Lazy
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    private JwtService jwtService;


    @Override
    public List<UserResponseDto> getAllUsers() {
        return userMapper.toResponseDtos(userRepository.findAll());
    }

    @Override
    @Transactional
    public JwtResponseDto createUser(UserRequestDto userRequest) {
        String username = userRequest.getName();
        if (userRepository.existsByName(username)) {
            throw new AlreadyExistException(
                    String.format("Пользователь с именем %s уже существует", username)
            );
        }
        String email = userRequest.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new AlreadyExistException(
                    String.format("Пользователь с эл. почтой %s уже существует", email)
            );
        }
        String password = userRequest.getPassword();
        RoleType role = userRequest.getRole();

        User user = new User();
        user.setName(username);
        user.setEmail(email);
        user.setPassword(encoder.encode(password));
        user.setRole(role);
        userRepository.save(user);

        String jwt = jwtService.generateJwtToken(user);
        RoleType roleType = userRequest.getRole();
        JwtResponseDto jwtResponse = new JwtResponseDto();
        jwtResponse.setToken(jwt);
        jwtResponse.setId(user.getId());
        jwtResponse.setUsername(user.getName());
        jwtResponse.setEmail(user.getEmail());
        jwtResponse.setRole(roleType);
        return jwtResponse;
    }

    @Override
    public JwtResponseDto authenticateUser(LoginRequestDto loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtService.generateJwtToken((User) authentication.getPrincipal());

        User userDetails = (User) authentication.getPrincipal();
        RoleType role = userDetails.getRole();

        JwtResponseDto jwtResponse = new JwtResponseDto();
        jwtResponse.setToken(jwt);
        jwtResponse.setId(userDetails.getId());
        jwtResponse.setUsername(userDetails.getUsername());
        jwtResponse.setEmail(userDetails.getEmail());
        jwtResponse.setRole(role);
        return jwtResponse;
    }

    @Override
    @Transactional
    public void updateUser(UserRequestDto newUser, Long id) {
        User user = getUserById(id);
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
        user.setRole(newUser.getRole());
        userRepository.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserById(Long id) {
        checkid(id);
        return userRepository.findById(id).get();

    }

    @Override
    public UserResponseDto getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = ((User) authentication.getPrincipal()).getId();
        return getUserDtoById(userId);
    }

    @Override
    public UserResponseDto getUserDtoById(Long id) {
        return userMapper.toResponseDto(getUserById(id));
    }

    @Override
    public void checkid(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException(String.format("Пользователь с таким id = %d не существует", id));
        }
    }

    @Override
    @Transactional
    public User loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new NotFoundException(String.format("Пользователя с таким email = %s не существует", email)));
    }

    @Override
    @Transactional
    public void changePassword(String password) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Long userId = ((User) authentication.getPrincipal()).getId();
        User user = getUserById(userId);

        user.setPassword(encoder.encode(password));
        userRepository.save(user);
    }
}
