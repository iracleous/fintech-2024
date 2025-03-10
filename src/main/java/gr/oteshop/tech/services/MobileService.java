package gr.oteshop.tech.services;

import gr.oteshop.tech.models.Mobile;

import java.util.List;
import java.util.Optional;

public interface MobileService {
    List<Mobile> getMobiles();
    Optional<Mobile> getMobile(long id);
    Optional<Mobile> createMobile(Mobile mobile);

    List<Mobile> getMobilesByModel(String model);
}
