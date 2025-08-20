package hr.tvz.bilogrevic.zavrsniradbackend.controller;

import hr.tvz.bilogrevic.zavrsniradbackend.model.DhmzData;
import hr.tvz.bilogrevic.zavrsniradbackend.service.DhmzDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dhmz")
@CrossOrigin(origins = "http://localhost:4200")
public class DhmzDataControler {

    @Autowired
    private DhmzDataService dhmzDataService;

    @GetMapping("/xml")
    public DhmzData getDhmzData() {
        return dhmzDataService.getZagrebMaksimir();
    }

}
