package se.project.coalingot.security.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import se.project.coalingot.security.JwtTokenUtil;
import se.project.coalingot.security.entity.Authority;
import se.project.coalingot.security.entity.AuthorityName;
import se.project.coalingot.security.entity.JwtUser;
import se.project.coalingot.security.entity.User;
import se.project.coalingot.security.repository.AuthorityRepository;
import se.project.coalingot.security.repository.UserRepository;
import se.project.coalingot.util.AuctionMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(maxAge = 3600)
public class AuthenticationRestController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthorityRepository authorityRepository;



    @PostMapping("${jwt.route.authentication.path}")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);
        Map result = new HashMap();
        result.put("token", token);
        User user = userRepository.findById(((JwtUser) userDetails).getId()).orElse(null);
        if (user != null) {
            result.put("user", AuctionMapper.INSTANCE.getUserAuthDto(user));
        }

        return ResponseEntity.ok(result);
    }


    @GetMapping(value = "${jwt.route.authentication.refresh}")
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken) + "You are now currently logout");
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("${jwt.route.register.path}")
    public ResponseEntity<?> registerAuthentication(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
        Authority authUser = Authority.builder().name(AuthorityName.ROLE_USER).build();
        authorityRepository.save(authUser);
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        if (userRepository.findByUsername(authenticationRequest.getUsername()) == null ){
            User newUser = User.builder()
                    .username(authenticationRequest.getUsername())
                    .password(encoder.encode(authenticationRequest.getPassword()))
                    .firstname(authenticationRequest.getFirstname())
                    .lastname(authenticationRequest.getLastname())
                    .email(authenticationRequest.getEmail())
                    .enabled(true)
                    .build();

            newUser.getAuthorities().add(authUser);

            userRepository.save(newUser);

            return ResponseEntity.ok("Registration successful");
        }else {
            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_GATEWAY);
        }
    }


}
