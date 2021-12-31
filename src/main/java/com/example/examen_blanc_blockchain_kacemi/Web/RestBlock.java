package com.example.examen_blanc_blockchain_kacemi.Web;


import com.example.examen_blanc_blockchain_kacemi.Services.BlockService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class RestBlock {
    private BlockService blockService;

    public RestBlock(BlockService blockService) {

        this.blockService = blockService;
    }


}
