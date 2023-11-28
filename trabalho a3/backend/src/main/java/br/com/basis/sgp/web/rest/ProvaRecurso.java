package br.com.basis.sgp.web.rest;
import br.com.basis.sgp.servico.ProvaServico;
import br.com.basis.sgp.servico.dto.ProvaDTO;
import br.com.basis.sgp.servico.dto.ProvaDetalhadaDTO;
import br.com.basis.sgp.servico.dto.ProvaListagemDTO;
import br.com.basis.sgp.servico.dto.SelectDTO;
import br.com.basis.sgp.servico.filtro.ProvaFiltro;
import br.com.basis.sgp.servico.filtro.UsuarioFiltro;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/provas")
@RequiredArgsConstructor
public class ProvaRecurso {

    private final ProvaServico provaServico;

    @GetMapping
    public ResponseEntity<Page<ProvaListagemDTO>> listarProvasPaginadas(@ModelAttribute ProvaFiltro filtro, Pageable pageable){
        Page<ProvaListagemDTO> provas = provaServico.listarProvas(filtro,pageable);
        return ResponseEntity.ok(provas);
    }

    @GetMapping("/filtro/{filtro}")
    public ResponseEntity<List<SelectDTO>> listarTituloProvasDropdown(@PathVariable String filtro) {
        List<SelectDTO> provas = provaServico.filtrarAutocomplete(filtro);
        return ResponseEntity.ok(provas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProvaDTO> visualizarProva(@PathVariable("id") Long id){
        ProvaDTO provaDTO = provaServico.exibirPorId(id);
        return ResponseEntity.ok(provaDTO);
    }

    @GetMapping("/avaliacoes/{id}")
    public ResponseEntity<ProvaDetalhadaDTO> visualizarProvaDetalhada(@PathVariable("id") Long id){
        return ResponseEntity.ok(provaServico.exibirProvaDetalhada(id));

    }

    @GetMapping("/dropdown")
    public ResponseEntity<List<SelectDTO>> visualizarDorpDownProva(){
        List<SelectDTO> provas = provaServico.listarProvaDropDown();
        return ResponseEntity.ok(provas);
    }

    @PostMapping
    public ResponseEntity<ProvaDTO> Cadastrar(@Valid @RequestBody ProvaDTO provaDTO) throws URISyntaxException {
        ProvaDTO provaCadastro = provaServico.salvar(provaDTO);
        return ResponseEntity.created(new URI("/provas/" + provaCadastro.getId())).body(null);
    }

    @PutMapping
    public ResponseEntity<Void> editar(@Valid @RequestBody ProvaDTO provaDTO){
        provaServico.salvar(provaDTO);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        provaServico.excluir(id);
        return ResponseEntity.ok(null);
    }
}
