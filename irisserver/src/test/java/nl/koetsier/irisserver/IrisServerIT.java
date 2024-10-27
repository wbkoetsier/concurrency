package nl.koetsier.irisserver;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class IrisServerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetData() throws Exception {
        mockMvc.perform(get("/data"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(150))
                .andExpect(jsonPath("$[0].sepalLengthCm").value(5.1))
                .andExpect(jsonPath("$[1].sepalWidthCm").value(3.0))
                .andExpect(jsonPath("$[0].irisClass").value("Iris-setosa"))
                .andExpect(jsonPath("$[-1].irisClass").value("Iris-virginica"));
    }
}
