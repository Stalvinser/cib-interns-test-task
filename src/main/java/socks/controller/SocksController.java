package socks.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socks.entity.SocksEntity;
import socks.service.SocksService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/socks")
public class SocksController {
    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }



    @PostMapping(value = "/income", consumes = "application/json")
    public ResponseEntity<?> registerNewSocksIncome (@Valid @RequestBody SocksEntity socks) {
        return socksService.registerNewSocksIncome(socks);
    }

    @GetMapping
    public ResponseEntity<String> getSockByColorAndCottonPart(@Valid @RequestParam("color") String color,
                                                              @Valid @RequestParam("operation") String operation,
                                                              @Valid @RequestParam("cottonPart") int cottonPart) {
        return socksService.getSockByColorAndCottonPart(color, operation, cottonPart);
    }

    @GetMapping("/allSocks")
    Iterable<SocksEntity> getSocks() {
        return socksService.findAll();
    }


}
