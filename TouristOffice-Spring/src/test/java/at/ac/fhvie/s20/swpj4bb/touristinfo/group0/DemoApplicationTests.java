package at.ac.fhvie.s20.swpj4bb.touristinfo.group0;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

  @Test
  public void contextLoads() {
    String message = "hello there";
    assertNotNull(message);
  }

}

