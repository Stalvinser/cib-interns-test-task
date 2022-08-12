package socks.controller;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import socks.dto.SocksDTO;
import socks.mapper.SocksMapper;
import socks.model.Socks;
import socks.service.SocksService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/socks")
public class SocksController {
    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping("/income")
    public ResponseEntity<?> registerNewSocksIncome(@Valid @RequestBody SocksDTO socksDTO) {
        Socks sock = SocksMapper.DtoToEntity(socksDTO);
        return socksService.registerNewSocksIncome(sock);
    }

    @PostMapping("/outcome")
    public ResponseEntity<?> registerNewSocksOutcome(@Valid @RequestBody SocksDTO socksDTO) {
        Socks sock = SocksMapper.DtoToEntity(socksDTO);
        return socksService.registerNewSocksOutcome(sock);
    }


    @GetMapping
    public ResponseEntity<String> getSockByColorAndCottonPart(@Valid @RequestParam("color") String color,
                                                              @Valid @RequestParam("operation") String operation,
                                                              @Valid @RequestParam("cottonPart") int cottonPart) {
        return socksService.getSockByColorAndCottonPart(color, operation, cottonPart);

    }


}
