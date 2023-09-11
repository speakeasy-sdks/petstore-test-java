<!-- Start SDK Example Usage -->


```java
package hello.world;

import com.petstore.petstore.Petstore;
import com.petstore.petstore.models.operations.CreatePetsResponse;

public class Application {
    public static void main(String[] args) {
        try {
            Petstore sdk = Petstore.builder()
                .build();

            CreatePetsResponse res = sdk.pets.createPets();

            if (res.statusCode == 200) {
                // handle response
            }
        } catch (Exception e) {
            // handle exception
        }
    }
}
```
<!-- End SDK Example Usage -->