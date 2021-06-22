package lt2020.sandelys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sandelys.entities.KlientasInfo;
import lt2020.sandelys.services.AtaskaitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Api(value = "Ataskaita")
@RequestMapping("/api/ataskaita")
public class AtaskaitaController {

    @Autowired
    private AtaskaitaService ataskaitaService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gauti kliento svorio top ataskaitas", notes = "Grazina kliento svorio top ataskaitas")
    public Collection<KlientasInfo> grazintiKlientoMaxSvorioTop() {
        return ataskaitaService.grazintilientoMaxSvorioTop();
    }
}
