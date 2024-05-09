package okhttp;

import com.google.gson.Gson;
import dto.UserDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestOkhttp {

    public static final MediaType JSON = MediaType.get("application/json");
    public static final String BASE_URI = "https://ilcarro-backend.herokuapp.com";
    Gson gson = new Gson();
    OkHttpClient okHttpClient = new OkHttpClient();

    @Test
    public void positiveLoginTest() throws IOException {

        UserDTO user = UserDTO.builder()
                .username("qweasd@gmail.com")
                .password("123456Aa$")
                .build();

        RequestBody requestBody = RequestBody.create(gson.toJson(user), JSON);

        Request request = new Request.Builder()
                .url(BASE_URI + "/v1/user/login/usernamepassword")
                .post(requestBody)
                .build();

        Response response = okHttpClient.newCall(request).execute();

        Assert.assertEquals(response.code(), 200);

    }
}
