package socks.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import socks.dto.SocksDTO;
import socks.mapper.SocksMapper;
import socks.model.Socks;
import socks.service.SocksService;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/socks")
@Validated
public class SocksController {
    private final SocksService socksService;

    public SocksController(SocksService socksService) {
        this.socksService = socksService;
    }

    @PostMapping("/income")
    public ResponseEntity<?> registerNewSocksIncome(@Valid @RequestBody SocksDTO socksDTO) {
        Socks sock = SocksMapper.DtoToEntity(socksDTO);
        socksService.registerNewSocksIncome(sock);
        return ResponseEntity.ok("socks income registered");
    }

    @PostMapping("/outcome")
    public ResponseEntity<?> registerNewSocksOutcome(@Valid @RequestBody SocksDTO socksDTO) {
        Socks sock = SocksMapper.DtoToEntity(socksDTO);
        socksService.registerNewSocksOutcome(sock);
        return ResponseEntity.ok("socks outcome delivery status - ok");
    }







    @GetMapping
    public ResponseEntity<String> getSockByColorAndCottonPart(@Valid @RequestParam("color") String color,
                                                              @Valid @RequestParam("operation") String operation,
                                                              @Valid @RequestParam("cottonPart") int cottonPart) {


        return new ResponseEntity<>(socksService.getSockByColorAndCottonPart(color, operation, cottonPart),
                HttpStatus.OK);

    }

    @GetMapping("/allSocks")
    Iterable<Socks> getSocks() {
        return socksService.findAll();
    }


}
