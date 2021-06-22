package lt2020.sandelys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sandelys.entities.KlientasInfo;
import lt2020.sandelys.services.KlientasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api(value = "Klientas")
@RequestMapping("/api/klientas")
public class KlientasController {

    @Autowired
    private KlientasService klientasService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gauti klientus", notes = "Grazina visus klientus")
    public Collection<KlientasInfo> grazintiVisusKlientus() {
        return klientasService.grazintiVisusKlientus();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gauti klienta pagal ID", notes = "Grazina klienta pagal duota ID")
    public KlientasInfo grazintiKlientaPagalId(@PathVariable("id") Long id) {
        return klientasService.grazintiKlientaPagalId(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Sukurti klienta", notes = "Sukuria klienta")
    public void pridetiKlienta(@RequestBody KlientasInfo klientasInfo) {
        klientasService.pridetiKlienta(klientasInfo);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Istrinti klienta", notes = "Istrina klienta pagal duota ID")
    public void istrintiKlienta(Long id) {
        klientasService.istrintiKlienta(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atnaujinti klienta", notes = "Atnaujina kliento duomenis")
    public void atnaujintiKlienta(KlientasInfo klientasInfo, Long id) {
        klientasService.atnaujintiKlienta(klientasInfo, id);
    }
}
