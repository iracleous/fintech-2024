package gr.oteshop.tech.services;

import gr.oteshop.tech.models.Mobile;
import gr.oteshop.tech.repositories.MobileRepository;
import gr.oteshop.tech.services.impl.MobileServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MobileServiceTest {

    @Mock
    private MobileRepository mobileRepository;

    @InjectMocks
    private MobileServiceImpl mobileService;

//    public MobileServiceTest() {
//        // Initialize mocks
//        MockitoAnnotations.openMocks(this);
//    }


    @Test
    void getMobiles() {

        when(mobileRepository.findAll()).thenReturn(List.of(new Mobile()));

        List<Mobile> mobiles = mobileService.getMobiles();
        assertNotNull(mobiles);
    }

    @Test
    void getMobile() {
        long mobileId = 1L;
        Mobile mobile = new Mobile();
        mobile.setId(mobileId);
        mobile.setName("test");
        when(mobileRepository.findById(1L)).thenReturn(Optional.of(mobile));

        Optional<Mobile> mobileFromTest = mobileService.getMobile(mobileId);
        assertNotNull(mobileFromTest);
        assertEquals(mobileId, mobileFromTest.get().getId());
    }

    @Test
    void createMobile() {
        long mobileId = 1L;
        Mobile mobile = new Mobile();
        mobile.setId(mobileId);
        mobile.setName("test");
        lenient().when(mobileRepository.save(any())).thenReturn(Optional.of(mobile));

        Optional<Mobile> mobileFromTest = mobileService.createMobile(mobile);
        assertNotNull(mobileFromTest);
        assertTrue(mobileFromTest.isEmpty(), "Optional should be empty");
    }
}