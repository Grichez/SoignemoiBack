package com.geodev.soignemoiapi.security.controller;

import com.geodev.soignemoiapi.pojo.User;
import com.geodev.soignemoiapi.pojo.ERole;
import com.geodev.soignemoiapi.pojo.Role;
import com.geodev.soignemoiapi.security.Service.UserDetailsImpl;
import com.geodev.soignemoiapi.security.jwt.JwtUtils;
import com.geodev.soignemoiapi.security.payload.requests.LoginRequest;
import com.geodev.soignemoiapi.security.repository.RoleRepository;
import com.geodev.soignemoiapi.security.payload.requests.SignupRequest;
import com.geodev.soignemoiapi.security.payload.response.UserInfoResponce;
import com.geodev.soignemoiapi.security.payload.response.MessageResponce;
import com.geodev.soignemoiapi.security.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiRegistrationAuth.API_AUTH)
public class AuthentificationController {

    @Autowired
    private AuthenticationManager authentificationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    //S'authentifier
    @PostMapping(ApiRegistrationAuth.API_SIGNIN)
    public ResponseEntity<UserInfoResponce> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        Authentication authentication = authentificationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponce(userDetails.getId(),
                        userDetails.getEmail(),
                        roles));
    }
    // Se déconnecter
    @PostMapping(ApiRegistrationAuth.API_SIGNOUT)
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponce("Vous avez été déconnecté !"));
    }

    //Creation de compte
    @PostMapping(ApiRegistrationAuth.API_SIGNUP)
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {

        if (userRepository.existsUserByEmail(signUpRequest.getEmail())) {
            return ResponseEntity.badRequest().body(new MessageResponce("Erreur: cet email est déjà utilisé"));
        }

        // Créer un nouveau compte
        User user = new User(signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByFonction(ERole.PATIENT)
                    .orElseThrow(() -> new RuntimeException("Erreur: rôle inconnu"));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "ADMIN":
                        Role adminRole = roleRepository.findByFonction(ERole.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Erreur: rôle inconnu"));
                        roles.add(adminRole);
                        break;

                    case "SECRETAIRE":
                        Role secrtRole = roleRepository.findByFonction(ERole.SECRETAIRE)
                                .orElseThrow(() -> new RuntimeException("Erreur: rôle inconnu"));
                        roles.add(secrtRole);
                        break;

                    case "MEDECIN":
                        Role medecRole = roleRepository.findByFonction(ERole.MEDECIN)
                            .orElseThrow(() -> new RuntimeException("Erreur: rôle inconnu"));
                        roles.add(medecRole);
                        break;

                    default:
                        Role patientRole = roleRepository.findByFonction(ERole.PATIENT)
                                .orElseThrow(() -> new RuntimeException("Erreur: rôle inconnu"));
                        roles.add(patientRole);
                }
            });
        }

        user.setRoles(roles);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponce("Utilisateur enregistré!"));
    }
}
