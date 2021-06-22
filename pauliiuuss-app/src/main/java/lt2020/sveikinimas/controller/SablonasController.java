package lt2020.sveikinimas.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sveikinimas.entities.SablonasInfo;
import lt2020.sveikinimas.services.SablonasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@Api(value = "sablonas")
@RequestMapping("/api/sablonas")
public class SablonasController {

    @Autowired
    private SablonasService sablonasService;

    @GetMapping("/all")
    @ApiOperation(value = "gauti sablona", notes = "grazina sablonus")
    public Collection<SablonasInfo> gautiVisusSablonus() { return sablonasService.gautiSablonus(); }
}
