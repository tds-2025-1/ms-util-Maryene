package br.edu.ifrs.riogrande.tads.tds.util.controller;
import br.edu.ifrs.riogrande.tads.tds.util.entity.CepResponse;
import br.edu.ifrs.riogrande.tads.tds.util.service.CepService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    private final CepService cepService;

    public CepController(CepService cepService) {
        this.cepService = cepService;
    }

    // @GetMapping("/{cep}"), produces = "text/plain")
    // public CepResponse getCepData(@PathVariable String cep) {
    //     return cepService.buscarDadosCep(cep);
    // }

    @GetMapping(value = "/{cep}", produces = "text/plain")
    public String getCepData(@PathVariable String cep) {
        CepResponse response = cepService.buscarDadosCep(cep);
        return formatarResposta(response);
    }

    private String formatarResposta(CepResponse endereco) {
        return String.format(
            "CEP: %s\n" +
            "Logradouro: %s\n" +
            "Complemento: %s\n" +
            "Bairro: %s\n" +
            "Cidade: %s\n" +
            "Estado: %s",
            endereco.getCep(),
            endereco.getLogradouro(),
            endereco.getComplemento().isEmpty() ? "Nenhum" : endereco.getComplemento(),
            endereco.getBairro(),
            endereco.getLocalidade(),
            endereco.getUf()
        );
    }
}
