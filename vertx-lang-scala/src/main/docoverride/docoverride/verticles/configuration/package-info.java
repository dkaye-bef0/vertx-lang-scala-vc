/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

/**
 * === Passing configuration to a verticle
 *
 * Configuration in the form of Map can be passed to a verticle at deployment time:
 *
 * [source,scala]
 * ----
 * val config = Json.obj(("name","tim"), ("directory","/blah"))
 * vertx.deployVerticle(ScalaVerticle.nameForVerticle[DemoVerticle].getName, DeploymentOptions().setConfig(config))
 * ----
 *
 * This configuration is then available via the {@link io.vertx.core.Context}, The configuration is returned as a Map
 * object so you can retrieve data as follows:
 *
 * [source,scala]
 * ----
 * println vertx.getOrCreateContext().config().getString("name")
 * ----
 *
 * === Accessing environment variables in a Verticle
 *
 * Environment variables and system properties are accessible using the Java API:
 *
 * [source,scala]
 * ----
 * println System.getProperty("foo")
 * println System.getenv("HOME")
 * ----
 *
 */
@Document(fileName = "override/verticle-configuration.adoc")
package docoverride.verticles.configuration;

/*-
 * #%L
 * Vert.x Scala Language Support
 * %%
 * Copyright (C) 2016 vert.x
 * %%
 * This program and the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 * #L%
 */

import io.vertx.docgen.Document;
