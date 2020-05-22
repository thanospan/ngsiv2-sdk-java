# [NGSI v2](https://fiware.github.io/specifications/ngsiv2/stable/) SDK for Java

## Documentation for API Endpoints

All URIs are relative to *http://localhost:1026/v2*

Class | Method | HTTP request
------------ | ------------- | -------------
ApiEntryPoint | retrieveApiResources | **GET** /
AttributeValue | getAttributeValue | **GET** /entities/{entityId}/attrs/{attrName}/value
AttributeValue | updateAttributeValue | **PUT** /entities/{entityId}/attrs/{attrName}/value
Attributes | getAttributeData | **GET** /entities/{entityId}/attrs/{attrName}
Attributes | removeASingleAttribute | **DELETE** /entities/{entityId}/attrs/{attrName}
Attributes | updateAttributeData | **PUT** /entities/{entityId}/attrs/{attrName}
BatchOperations | notify | **POST** /op/notify
BatchOperations | query | **POST** /op/query
BatchOperations | update | **POST** /op/update
Entities | createEntity | **POST** /entities
Entities | listEntities | **GET** /entities
Entities | removeEntity | **DELETE** /entities/{entityId}
Entities | replaceAllEntityAttributes | **PUT** /entities/{entityId}/attrs
Entities | retrieveEntity | **GET** /entities/{entityId}
Entities | retrieveEntityAttributes | **GET** /entities/{entityId}/attrs
Entities | updateExistingEntityAttributes | **PATCH** /entities/{entityId}/attrs
Entities | updateOrAppendEntityAttributes | **POST** /entities/{entityId}/attrs
Registrations | createRegistration | **POST** /registrations
Registrations | deleteRegistration | **DELETE** /registrations/{registrationId}
Registrations | listRegistrations | **GET** /registrations
Registrations | retrieveRegistration | **GET** /registrations/{registrationId}
Registrations | updateRegistration | **PATCH** /registrations/{registrationId}
Subscriptions | createSubscription | **POST** /subscriptions
Subscriptions | deleteSubscription | **DELETE** /subscriptions/{subscriptionId}
Subscriptions | listSubscriptions | **GET** /subscriptions
Subscriptions | retrieveSubscription | **GET** /subscriptions/{subscriptionId}
Subscriptions | updateSubscription) | **PATCH** /subscriptions/{subscriptionId}
Types | listEntityTypes | **GET** /types
Types | retrieveEntityType | **GET** /types/{entityType}

## Known Issues
* **PATCH** /registrations/{registrationId} returns **405 Method Not Allowed**.<br/>
According to the [NGSIv2 Implementation Notes](https://github.com/telefonicaid/fiware-orion/blob/master/doc/manuals/user/ngsiv2_implementation_notes.md#registrations):<br/>
`PATCH /v2/registration/<id>` is not implemented. Thus, registrations cannot be updated directly. I.e., updates must be done deleting and re-creating the registration. Please see [this issue](https://github.com/telefonicaid/fiware-orion/issues/3007) about this.
* **204 No Content** responses cause `java.io.IOException: unexpected content length header with 204 response`<br/>
[This bug](https://bugs.openjdk.java.net/browse/JDK-8218662) has been fixed in jdk-11.0.7

## Additional Resources
* An introductory tutorial to the FIWARE Platform can be found [here](https://github.com/FIWARE/tutorials.Getting-Started).
* The official docker image of the Orion Context Broker can be found [here](https://hub.docker.com/r/fiware/orion).
