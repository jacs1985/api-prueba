package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.example.demo.dto.UsuarioResponseDTO;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    @Value("${password.regex}")
    private String passwordRegex;

    public UsuarioResponseDTO registerUsuario(Usuario usuario) {
        if (!isValidEmail(usuario.getEmail())) {
            throw new RuntimeException("El formato del correo es inválido");
        }

        if (!isValidPassword(usuario.getPassword())) {
            throw new RuntimeException("La contraseña no cumple con los requisitos");
        }
        if (usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya registrado");
        }

        usuario.setCreated(LocalDateTime.now());
        usuario.setModified(LocalDateTime.now());
        usuario.setLastLogin(LocalDateTime.now());
        usuario.setToken(UUID.randomUUID().toString());
        usuario.setActive(true);

        Usuario savedUsuario = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(
                savedUsuario.getId(),
                savedUsuario.getCreated(),
                savedUsuario.getModified(),
                savedUsuario.getLastLogin(),
                savedUsuario.getToken(),
                savedUsuario.isActive()
        );
    }
    private boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    private boolean isValidPassword(String password) {
        return password.matches(passwordRegex);
    }
}
