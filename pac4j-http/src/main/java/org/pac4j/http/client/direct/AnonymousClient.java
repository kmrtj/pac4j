/*
  Copyright 2012 - 2015 pac4j organization

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.pac4j.http.client.direct;

import org.pac4j.core.client.BaseClient;
import org.pac4j.core.client.ClientType;
import org.pac4j.core.context.WebContext;
import org.pac4j.http.credentials.AnonymousCredentials;
import org.pac4j.core.exception.RequiresHttpAction;
import org.pac4j.http.profile.AnonymousProfile;
import org.pac4j.http.profile.HttpProfile;

/**
 * Anonymous client. Not to be used except for advanced use cases.
 *
 * @author Jerome Leleu
 * @since 1.8.1
 */
public class AnonymousClient extends DirectHttpClient<AnonymousCredentials> {

    private final AnonymousCredentials CREDENTIALS;
    private final AnonymousProfile PROFILE;

    public AnonymousClient() {
        CREDENTIALS = new AnonymousCredentials();
        PROFILE = new AnonymousProfile();
        PROFILE.setId("anonymous");
    }

    @Override
    protected void internalInit() { }

    @Override
    protected BaseClient<AnonymousCredentials, HttpProfile> newClient() {
        return this;
    }

    @Override
    public AnonymousCredentials getCredentials(WebContext context) throws RequiresHttpAction {
        return CREDENTIALS;
    }

    @Override
    protected AnonymousProfile retrieveUserProfile(final AnonymousCredentials credentials, final WebContext context) {
        return PROFILE;
    }

    @Override
    public ClientType getClientType() {
        return ClientType.UNKNOWN;
    }
}
