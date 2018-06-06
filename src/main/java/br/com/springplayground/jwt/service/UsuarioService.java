package br.com.springplayground.jwt.service;

import br.com.springplayground.jwt.domain.Usuario;
import br.com.springplayground.jwt.domain.dto.UsuarioDTO;
import br.com.springplayground.jwt.repository.UsuarioRepository;
import br.com.springplayground.jwt.utils.ModelMapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ModelMapperConverter modelMapperConverter;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login);
        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", login));
        }
        return usuario;
    }

    public UsuarioDTO getUsuarioLogado() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        Authentication  authentication = securityContext.getAuthentication();
        String userName = (String) authentication.getPrincipal();
        Usuario usuario = usuarioRepository.findByLogin(userName);
        return modelMapperConverter.converterStrict(usuario, UsuarioDTO.class);
    }

}
