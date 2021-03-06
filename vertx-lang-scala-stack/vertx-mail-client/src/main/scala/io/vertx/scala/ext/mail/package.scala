//MODULE: vertx-mail
//MODULE: io.vertx.ext.mail
//MODULE: io.vertx
//MODULE: io.vertx.scala.ext.mail
/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.ext
import scala.collection.JavaConverters._
import scala.compat.java8.FunctionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import scala.concurrent.Promise

package object mail{


  type MailAttachment = io.vertx.ext.mail.MailAttachment

  object MailAttachment {
    def apply() = new MailAttachment()
    def apply(json: JsonObject) = new MailAttachment(json)
  }


import io.vertx.ext.mail.{MailConfig => JMailConfig}
import io.vertx.ext.mail.MailConfig
import io.vertx.ext.mail.{MailResult => JMailResult}
import io.vertx.core.Vertx
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.mail.MailMessage
import io.vertx.core.{Vertx => JVertx}
import io.vertx.ext.mail.{MailMessage => JMailMessage}
import io.vertx.ext.mail.MailResult

  /**
   * SMTP mail client for Vert.x
   * 
   * A simple asynchronous API for sending mails from Vert.x applications
   */
  implicit class MailClientScala(val asJava: io.vertx.ext.mail.MailClient) extends AnyVal {

    /**
     * Like [[sendMail]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def sendMailFuture(email: io.vertx.ext.mail.MailMessage): scala.concurrent.Future[io.vertx.ext.mail.MailResult] = {
      val promise = Promise[io.vertx.ext.mail.MailResult]()
      asJava.sendMail(email, {a:AsyncResult[io.vertx.ext.mail.MailResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

  type MailConfig = io.vertx.ext.mail.MailConfig

  object MailConfig {
    def apply() = new MailConfig()
    def apply(json: JsonObject) = new MailConfig(json)
  }


  type MailMessage = io.vertx.ext.mail.MailMessage

  object MailMessage {
    def apply() = new MailMessage()
    def apply(json: JsonObject) = new MailMessage(json)
  }


  type MailResult = io.vertx.ext.mail.MailResult

  object MailResult {
    def apply() = new MailResult()
    def apply(json: JsonObject) = new MailResult(json)
  }


}
