package com.example.aula.service;

import com.example.aula.model.Usuario;
import com.example.aula.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(@Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario atualizar(@Valid Usuario usuario) {
        Usuario existente = usuarioRepository.findById(usuario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado."));

        existente.setNome(usuario.getNome());
        existente.setSexo(usuario.getSexo());
        existente.setIdade(usuario.getIdade());
        existente.setAltura(usuario.getAltura());
        existente.setPeso(usuario.getPeso());
        existente.setPosicao(usuario.getPosicao());
        existente.setNumeroDaCamisa(usuario.getNumeroDaCamisa());

        return usuarioRepository.save(existente);
    }

    public void excluir(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        usuarioRepository.deleteById(usuario.getId());
    }
}
