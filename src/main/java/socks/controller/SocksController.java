package socks.controller;

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

    @GetMapping("/allSocks")
    Iterable<SocksEntity> getSocks() {
        return socksService.findAll();
    }

    @GetMapping()
    public ResponseEntity<String> getSockByColorAndCottonPart(@Valid @RequestParam("color") String color,
                                                              @Valid @RequestParam("operation") String operation,
                                                              @Valid @RequestParam("cottonPart") int cottonPart) {
        return socksService.getSockByColorAndCottonPart(color, operation, cottonPart);
    }


}
