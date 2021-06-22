package lt2020.sandelys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lt2020.sandelys.entities.InventoriusInfo;
import lt2020.sandelys.services.InventoriusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@Api(value = "Inventorius")
@RequestMapping("/api/inventorius")
public class InventoriusController {

    @Autowired
    private InventoriusService inventoriusService;

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gauti inventoriu", notes = "Grazina visa inventoriu")
    public Collection<InventoriusInfo> grazintiVisusInventorius() {
        return inventoriusService.grazintiVisusInventorius();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Gauti inventoriu pagal ID", notes = "Grazina inventoriu pagal duota ID")
    public InventoriusInfo grazintiInventoriuPagalId(@PathVariable("id") Long id) {
        return inventoriusService.grazintiInventoriuPagalId(id);
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Sukurti inventoriu", notes = "Sukuria inventoriu")
    public void pridetiInventoriu(@RequestBody InventoriusInfo inventoriusInfo) {
        inventoriusService.pridetiInventoriu(inventoriusInfo);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Istrinti inventoriu", notes = "Istrina inventoriu pagal duota ID")
    public void istrintiInventoriu(Long id) {
        inventoriusService.istrintiInventoriu(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Atnaujinti inventoriu", notes = "Atnaujina inventoriaus informacija")
    public void atnaujintiInventoriu(InventoriusInfo inventoriusInfo, Long id) {
        inventoriusService.atnaujintiInventoriu(inventoriusInfo, id);
    }
}
