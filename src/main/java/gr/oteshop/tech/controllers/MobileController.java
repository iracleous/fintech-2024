package gr.oteshop.tech.controllers;

import gr.oteshop.tech.models.Mobile;
import gr.oteshop.tech.services.MobileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("api/mobile")
public class MobileController {
    private  final MobileService mobileService;

    @GetMapping
    public List<Mobile> getMobile(){
        return mobileService.getMobiles();
    }

    @GetMapping("{id}")
    public Optional<Mobile> getMobile(@PathVariable long id){
        return mobileService.getMobile(id);
    }

    @GetMapping("/model")
public List<Mobile> getMobileModel(@RequestParam("model") String model){
        return mobileService.getMobilesByModel(model);
    }
    @PostMapping
    public Optional<Mobile> saveMobile(@RequestBody Mobile mobile){
        return  mobileService.createMobile(mobile);
    }
}
