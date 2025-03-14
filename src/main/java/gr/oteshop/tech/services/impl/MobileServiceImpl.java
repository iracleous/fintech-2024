package gr.oteshop.tech.services.impl;

import gr.oteshop.tech.models.Mobile;
import gr.oteshop.tech.repositories.MobileRepository;
import gr.oteshop.tech.services.MobileService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MobileServiceImpl implements MobileService {
private final MobileRepository mobileRepository;

    @Override
    public List<Mobile> getMobiles() {

        return mobileRepository.findAll();



    }

    @Override
    public Optional<Mobile> getMobile(long id) {

        return mobileRepository.findById(id);
    }

    @Override
    public Optional<Mobile> createMobile(Mobile mobile) {
        if (mobile == null) {
            return Optional.empty();
        }
        if (mobile.getName()== null || mobile.getName().isEmpty())  {
            return Optional.empty();
        }
        if (mobile.getName().equals("test")){
            return Optional.empty();
        }
        mobileRepository.save(mobile);
        return Optional.of(mobile);
    }

    @Override
    public List<Mobile> getMobilesByModel(String model) {
        return  mobileRepository.findMobileByModelContainingIgnoreCase(model);
    }
}
