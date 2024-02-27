package at.ac.fhvie.w18.goop3bb.touristinfo;

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

