package com.example.bootdemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BootdemoApplicationTests {
    @LocalServerPort
    private int port;
    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void before() throws MalformedURLException {
       this.base=new URL("http://localhost:" + port + "/chapter/demo1");
    }

    @Test
    public void contextLoads() {
        ResponseEntity<String> responseEntity = template.getForEntity(base.toString(), String.class);
        System.out.println(responseEntity.getBody());
        assertEquals(responseEntity.getBody(), "helloworld");
    }

}
