/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package com.petstore.petstore;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.petstore.petstore.utils.HTTPClient;
import com.petstore.petstore.utils.HTTPRequest;
import com.petstore.petstore.utils.JSON;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.http.NameValuePair;

public class Pets {
	
	private SDKConfiguration sdkConfiguration;

	public Pets(SDKConfiguration sdkConfiguration) {
		this.sdkConfiguration = sdkConfiguration;
	}

    /**
     * Create a pet
     * @return the response from the API call
     * @throws Exception if the API call fails
     */
    public com.petstore.petstore.models.operations.CreatePetsResponse createPets() throws Exception {
        String baseUrl = this.sdkConfiguration.serverUrl;
        String url = com.petstore.petstore.utils.Utils.generateURL(baseUrl, "/pets");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("POST");
        req.setURL(url);

        req.addHeader("Accept", "application/json");
        req.addHeader("user-agent", String.format("speakeasy-sdk/%s %s %s %s", this.sdkConfiguration.language, this.sdkConfiguration.sdkVersion, this.sdkConfiguration.genVersion, this.sdkConfiguration.openapiDocVersion));
        
        HTTPClient client = this.sdkConfiguration.defaultClient;
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        com.petstore.petstore.models.operations.CreatePetsResponse res = new com.petstore.petstore.models.operations.CreatePetsResponse(contentType, httpRes.statusCode()) {{
            error = null;
        }};
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 201) {
        }
        else {
            if (com.petstore.petstore.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                com.petstore.petstore.models.shared.Error out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), com.petstore.petstore.models.shared.Error.class);
                res.error = out;
            }
        }

        return res;
    }

    /**
     * List all pets
     * @param request the request object containing all of the parameters for the API call
     * @return the response from the API call
     * @throws Exception if the API call fails
     */
    public com.petstore.petstore.models.operations.ListPetsResponse listPets(com.petstore.petstore.models.operations.ListPetsRequest request) throws Exception {
        String baseUrl = this.sdkConfiguration.serverUrl;
        String url = com.petstore.petstore.utils.Utils.generateURL(baseUrl, "/pets");
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);

        req.addHeader("Accept", "application/json");
        req.addHeader("user-agent", String.format("speakeasy-sdk/%s %s %s %s", this.sdkConfiguration.language, this.sdkConfiguration.sdkVersion, this.sdkConfiguration.genVersion, this.sdkConfiguration.openapiDocVersion));
        java.util.List<NameValuePair> queryParams = com.petstore.petstore.utils.Utils.getQueryParams(com.petstore.petstore.models.operations.ListPetsRequest.class, request, null);
        if (queryParams != null) {
            for (NameValuePair queryParam : queryParams) {
                req.addQueryParam(queryParam);
            }
        }
        
        HTTPClient client = this.sdkConfiguration.defaultClient;
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        com.petstore.petstore.models.operations.ListPetsResponse res = new com.petstore.petstore.models.operations.ListPetsResponse(contentType, httpRes.statusCode()) {{
            pets = null;
            error = null;
        }};
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            res.headers = httpRes.headers().map().keySet().stream().collect(Collectors.toMap(Function.identity(), k -> httpRes.headers().allValues(k).toArray(new String[0])));
            
            if (com.petstore.petstore.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                com.petstore.petstore.models.shared.Pet[] out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), com.petstore.petstore.models.shared.Pet[].class);
                res.pets = out;
            }
        }
        else {
            if (com.petstore.petstore.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                com.petstore.petstore.models.shared.Error out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), com.petstore.petstore.models.shared.Error.class);
                res.error = out;
            }
        }

        return res;
    }

    /**
     * Info for a specific pet
     * @param request the request object containing all of the parameters for the API call
     * @return the response from the API call
     * @throws Exception if the API call fails
     */
    public com.petstore.petstore.models.operations.ShowPetByIdResponse showPetById(com.petstore.petstore.models.operations.ShowPetByIdRequest request) throws Exception {
        String baseUrl = this.sdkConfiguration.serverUrl;
        String url = com.petstore.petstore.utils.Utils.generateURL(com.petstore.petstore.models.operations.ShowPetByIdRequest.class, baseUrl, "/pets/{petId}", request, null);
        
        HTTPRequest req = new HTTPRequest();
        req.setMethod("GET");
        req.setURL(url);

        req.addHeader("Accept", "application/json");
        req.addHeader("user-agent", String.format("speakeasy-sdk/%s %s %s %s", this.sdkConfiguration.language, this.sdkConfiguration.sdkVersion, this.sdkConfiguration.genVersion, this.sdkConfiguration.openapiDocVersion));
        
        HTTPClient client = this.sdkConfiguration.defaultClient;
        HttpResponse<byte[]> httpRes = client.send(req);

        String contentType = httpRes.headers().firstValue("Content-Type").orElse("application/octet-stream");

        com.petstore.petstore.models.operations.ShowPetByIdResponse res = new com.petstore.petstore.models.operations.ShowPetByIdResponse(contentType, httpRes.statusCode()) {{
            pet = null;
            error = null;
        }};
        res.rawResponse = httpRes;
        
        if (httpRes.statusCode() == 200) {
            if (com.petstore.petstore.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                com.petstore.petstore.models.shared.Pet out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), com.petstore.petstore.models.shared.Pet.class);
                res.pet = out;
            }
        }
        else {
            if (com.petstore.petstore.utils.Utils.matchContentType(contentType, "application/json")) {
                ObjectMapper mapper = JSON.getMapper();
                com.petstore.petstore.models.shared.Error out = mapper.readValue(new String(httpRes.body(), StandardCharsets.UTF_8), com.petstore.petstore.models.shared.Error.class);
                res.error = out;
            }
        }

        return res;
    }
}