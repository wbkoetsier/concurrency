package nl.koetsier.irisserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IrisController {

    @Autowired
    private IrisService irisService;

    @GetMapping("/data")
    public List<Iris> getData() {
        return irisService.getIrisData();
    }
}
