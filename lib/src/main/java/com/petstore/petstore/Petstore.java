/* 
 * Code generated by Speakeasy (https://speakeasyapi.dev). DO NOT EDIT.
 */

package com.petstore.petstore;

import com.petstore.petstore.utils.HTTPClient;
import com.petstore.petstore.utils.SpeakeasyHTTPClient;

public class Petstore {
	/**
	 * SERVERS contains the list of server urls available to the SDK.
	 */
	public static final String[] SERVERS = {
        "http://petstore.swagger.io/v1",
	};
  	
    public Pets pets;	

	private SDKConfiguration sdkConfiguration;

	/**
	 * The Builder class allows the configuration of a new instance of the SDK.
	 */
	public static class Builder {
		private SDKConfiguration sdkConfiguration = new SDKConfiguration();

		private Builder() {
		}

		/**
		 * Allows the default HTTP client to be overridden with a custom implementation.
		 * @param client The HTTP client to use for all requests.
		 * @return The builder instance.
		 */
		public Builder setClient(HTTPClient client) {
			this.sdkConfiguration.defaultClient = client;
			return this;
		}
		
		/**
		 * Allows the overriding of the default server URL.
		 * @param serverUrl The server URL to use for all requests.
		 * @return The builder instance.
		 */
		public Builder setServerURL(String serverUrl) {
			this.sdkConfiguration.serverUrl = serverUrl;
			return this;
		}
		
		/**
		 * Allows the overriding of the default server URL  with a templated URL populated with the provided parameters.
		 * @param serverUrl The server URL to use for all requests.
		 * @param params The parameters to use when templating the URL.
		 * @return The builder instance.
		 */
		public Builder setServerURL(String serverUrl, java.util.Map<String, String> params) {
			this.sdkConfiguration.serverUrl = com.petstore.petstore.utils.Utils.templateUrl(serverUrl, params);
			return this;
		}
		
		/**
		 * Allows the overriding of the default server by index
		 * @param serverIdx The server to use for all requests.
		 * @return The builder instance.
		 */
		public Builder setServerIndex(int serverIdx) {
			this.sdkConfiguration.serverIdx = serverIdx;
			this.sdkConfiguration.serverUrl = SERVERS[serverIdx];
			return this;
		}
		
		/**
		 * Builds a new instance of the SDK.
		 * @return The SDK instance.
		 * @throws Exception Thrown if the SDK could not be built.
		 */
		public Petstore build() throws Exception {
			if (this.sdkConfiguration.defaultClient == null) {
				this.sdkConfiguration.defaultClient = new SpeakeasyHTTPClient();
			}
			
			if (this.sdkConfiguration.securityClient == null) {
				this.sdkConfiguration.securityClient = this.sdkConfiguration.defaultClient;
			}
			
			if (this.sdkConfiguration.serverUrl == null || this.sdkConfiguration.serverUrl.isBlank()) {
				this.sdkConfiguration.serverUrl = SERVERS[0];
				this.sdkConfiguration.serverIdx = 0;
			}

			if (this.sdkConfiguration.serverUrl.endsWith("/")) {
				this.sdkConfiguration.serverUrl = this.sdkConfiguration.serverUrl.substring(0, this.sdkConfiguration.serverUrl.length() - 1);
			}
			
			return new Petstore(this.sdkConfiguration);
		}
	}

	/**
	 * Get a new instance of the SDK builder to configure a new instance of the SDK.
	 * @return The SDK builder instance.
	 */
	public static Builder builder() {
		return new Builder();
	}

	private Petstore(SDKConfiguration sdkConfiguration) throws Exception {
		this.sdkConfiguration = sdkConfiguration;
		
		this.pets = new Pets(this.sdkConfiguration);
	}
}