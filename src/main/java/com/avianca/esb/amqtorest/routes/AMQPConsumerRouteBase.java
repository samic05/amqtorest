/*
 * Copyright 2005-2016 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version
 * 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.avianca.esb.amqtorest.routes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.avianca.esb.amqtorest.properties.AmqConsumerBase;
import com.avianca.esb.amqtorest.configurador.ConfigurationRoute;

@Component
public class AMQPConsumerRouteBase extends ConfigurationRoute {

	@Autowired
	private AmqConsumerBase amqConsumerConfig;

	public void configure() throws Exception {
		super.configure();
		from("activemq:queue://" + amqConsumerConfig.getQueueName()).routeId("amqtorest_amqp_consumer")
			.to("direct:transformationRouteBase")
			.end();
	}
}
