package com.example.sgeapi.controller;
import com.example.sgeapi.dto.NominaDTO;
import com.example.sgeapi.service.NominaService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
@RequestMapping("//nominas")
public class NominaController {
    @Autowired
    private NominaService nominaService;
    @GetMapping
    public ResponseEntity<List<NominaDTO>>getallNominas(){

    }
}
