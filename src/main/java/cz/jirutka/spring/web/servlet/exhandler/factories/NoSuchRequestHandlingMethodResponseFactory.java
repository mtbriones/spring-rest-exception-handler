/*
 * Copyright 2014 Jakub Jirutka <jakub@jirutka.cz>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cz.jirutka.spring.web.servlet.exhandler.factories;

import cz.jirutka.spring.web.servlet.exhandler.messages.ErrorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.multiaction.NoSuchRequestHandlingMethodException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

public class NoSuchRequestHandlingMethodResponseFactory
        extends LocalizableErrorMessageFactory<NoSuchRequestHandlingMethodException> {

    private static final Logger LOG = LoggerFactory.getLogger(DispatcherServlet.PAGE_NOT_FOUND_LOG_CATEGORY);


    public NoSuchRequestHandlingMethodResponseFactory() {
        super(NOT_FOUND);
    }

    @Override
    public ResponseEntity<ErrorMessage> createErrorResponse(NoSuchRequestHandlingMethodException ex, WebRequest req) {

        LOG.warn(ex.getMessage());
        return super.createErrorResponse(ex, req);
    }
}
