package com.example.aula.controller;

import com.example.aula.model.Usuario;
import com.example.aula.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Listar todos os usuários
    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        return ResponseEntity.ok(usuarioService.listarTodos());
    }

    // Cadastrar novo usuário
    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario) {
        return ResponseEntity.ok(usuarioService.salvar(usuario));
    }

    // Atualizar usuário
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable Long id, @RequestBody @Valid Usuario usuario) {
        usuario.setId(id); // garante que o ID da URL será usado
        return ResponseEntity.ok(usuarioService.atualizar(usuario));
    }

    // Excluir usuário
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
