/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2011 ForgeRock AS. All Rights Reserved
 *
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the License). You may not use this file except in
 * compliance with the License.
 *
 * You can obtain a copy of the License at
 * http://forgerock.org/license/CDDLv1.0.html
 * See the License for the specific language governing
 * permission and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * Header Notice in each file and include the License file
 * at http://forgerock.org/license/CDDLv1.0.html
 * If applicable, add the following below the CDDL Header,
 * with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 */

package org.forgerock.openam.session.ha.amsessionrepository.client;

import org.forgerock.openam.amsessionstore.common.AMRecord;
import org.forgerock.openam.amsessionstore.resources.ShutdownResource;
import org.restlet.Client;
import org.restlet.data.ChallengeResponse;
import org.restlet.resource.ClientResource;

/**
 *
 * @author steve
 */
public class ShutdownTask extends AbstractTask {
    public ShutdownTask(Client client,
                        String resourceURL, 
                        String username, 
                        String password) {
        super(client, resourceURL, username, password);
    }
    
    @Override
    public AMRecord call()
    throws Exception {
        ChallengeResponse response = getAuth();
        ClientResource resource = new ClientResource(resourceURL + ShutdownResource.URI);
        resource.setNext(client);
        resource.setChallengeResponse(response);
        ShutdownResource shutdownResource = resource.wrap(ShutdownResource.class);
        
        try {
            shutdownResource.shutdown();
        } catch (Exception ex) {
            if (resource.getStatus().getCode() != 401) {
                if (debug.warningEnabled()) {
                    debug.warning("Unable to call shutdown on amsessiondb", ex);
                }
                
                throw ex;
            }
            
            clearAuth();
            response = getAuth();
            resource.setChallengeResponse(response);
            
            try {
                shutdownResource.shutdown();
            } catch (Exception ex2) {
                if (resource.getStatus().getCode() == 401) {
                    if (debug.warningEnabled()) {
                        debug.warning("Unable to call shutdown on amsessiondb; unauthorized", ex2);
                    }
                    
                    throw new UnauthorizedException(ex2.getMessage());
                } else {
                    if (debug.warningEnabled()) {
                        debug.warning("Unable to call shutdown on amsessiondb", ex2);
                    }
                    throw ex2;
                }
            }
        }

        if (debug.messageEnabled()) {
            debug.message("Shutdown message sent");
        }
        
        return null;
    }
    
    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(ShutdownTask.class);
        
        return output.toString();        
    }
}
